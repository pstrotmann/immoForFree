package org.strotmann.immos

import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.hssf.usermodel.HSSFCell
import org.apache.poi.hssf.usermodel.HSSFCellStyle
import org.apache.poi.poifs.filesystem.POIFSFileSystem
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.CellStyle
import org.apache.poi.ss.usermodel.Font
import org.apache.poi.ss.usermodel.IndexedColors
import org.strotmann.util.*

class DruckController {
	
	def printMietjournal () {
		def mOut = printFile ("mietjournal")
		Mietvertrag.printMietjournal(mOut)
		mOut.close()
		downloadFile("mietjournal.txt")
	}
	
	def printOffeneUmsaetze () {
		def int jahr
		if (session.jahr)
			jahr = session.jahr
		else
			jahr = Datum.aktJahr
		def uOut = printFile ("offeneUmsaetze")
		Bankumsatz.printOffeneUmsaetze(uOut, jahr);
		uOut.close()
		downloadFile("offeneUmsaetze.txt")
	}
	
	def printZuordnungen () {
		def int jahr 
		if (session.jahr)
			jahr = session.jahr
		else
			jahr = Datum.aktJahr
		def zOut = printFile ("zahlungsZuordnung")
		Zahlung.printZuordnungen(zOut, jahr);
		zOut.close()
		downloadFile("zahlungsZuordnung.txt")
	}
	
	def excel () {
		def nOut = csvFile ("nebenkostenabrechung")
		def Nebenkostenabrechnung nebenkostenabrechnung = Nebenkostenabrechnung.get(params.id)
		nebenkostenabrechnung.erzeugeCsv(nOut);
		nOut.close()
		downloadFile("nebenkostenabrechung.csv")
	}
	
	def serienbriefe () {
		//XSSFWorkbook für Serienbriefparamater und Anlagen
		XSSFWorkbook workBook = new XSSFWorkbook();
		
		Font fatFont = workBook.createFont()
		fatFont.setFontHeightInPoints((short) 8)
		fatFont.setBoldweight(Font.BOLDWEIGHT_BOLD)
						
		CellStyle horStyle = workBook.createCellStyle()
		horStyle.setAlignment(CellStyle.ALIGN_RIGHT)
		
		CellStyle fatLeftStyle = workBook.createCellStyle()
		fatLeftStyle.setAlignment(CellStyle.ALIGN_LEFT)
		fatLeftStyle.setFont(fatFont)
		
		CellStyle fatRightStyle = workBook.createCellStyle()
		fatRightStyle.setAlignment(CellStyle.ALIGN_RIGHT)
		fatRightStyle.setFont(fatFont)
		
		def sOut = csvFile ("serienbriefe")
		def Immoabrechnung immoabrechnung = Immoabrechnung.get(params.id)
		immoabrechnung.loescheOp()
		immoabrechnung.erzeugeCsv(sOut)
		immoabrechnung.erzeugeOp()
		sOut.close()
				
		//je Nebenkostenabrechnung 1 sheet
		def int sheetNum = 1
		immoabrechnung.betriebskostenabrechnungen.each {Betriebskostenabrechnung b ->
			Nebenkostenabrechnung n  = b.nebenkostenabrechnung
			def nOut = csvFile ("nebenkostenabrechung${sheetNum}")
			n.erzeugeCsv(nOut)
			nOut.close()
			String sheetName = b.mietvertrag.mieter.partner.name
			if (b.mietvertrag.mieter.partner instanceof Person) sheetName += ','+((Person)b.mietvertrag.mieter.partner).vorname
			XSSFSheet sheet = workBook.createSheet(sheetName)
			sheet.getPrintSetup().setLandscape(true) //Querformat
			
			sheet.setColumnWidth(0, 5500)
			for (i in 1..5) {
				sheet.setColumnWidth(i, 3500)
			}
			def int rowNum = 0
			new File("nebenkostenabrechung${sheetNum}.csv").eachLine {String line ->
				def String[] str = line.split(";")
				XSSFRow currentRow = sheet.createRow(rowNum)
				def short h = 420
				currentRow.setHeight(h)
				Boolean summenZeile = false
				
				for(int i=0;i<str.length;i++){
					if (str[i] == 'Summe')
						summenZeile = true
					Cell c = currentRow.createCell(i)
					
					if (i > 1)
						c.setCellStyle(horStyle)
					if (summenZeile)
						c.setCellStyle(fatRightStyle)
															
					c.setCellValue(str[i])
				}
				rowNum++
			}
			sheetNum++
		}
		
		//Ausgabe der gesamten ExcelDatei
		FileOutputStream fileOutputStream =  new FileOutputStream("nebenkostenabrechung.xlsx")
		workBook.write(fileOutputStream)
		fileOutputStream.close()
		downloadFile("nebenkostenabrechung.xlsx")
	}
	
	def setAuswJahr () {
		if (params.jahr)
			session.jahr = params.jahr.toString().toInteger()
		else 
			session.jahr = Datum.aktJahr
		redirect(uri: "/")
	}
	
	private PrintWriter printFile (String objName) {
		
		PrintWriter retBuf = null;
		
		try {
			@SuppressWarnings("resource")
			FileOutputStream fileOutputStream = new FileOutputStream (objName+".txt");
			OutputStreamWriter outpuStreamWriter = null;
			try {
				outpuStreamWriter = new OutputStreamWriter (fileOutputStream, "UTF-8");
			} catch (UnsupportedEncodingException ex) {
				System.out.println("Encoding nicht gefunden");
			}
			retBuf = new PrintWriter(outpuStreamWriter);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		return retBuf;
	}
	
	private BufferedWriter csvFile (String objName) {
		
		BufferedWriter retBuf = null;
		
		try {
			@SuppressWarnings("resource")
			FileOutputStream fileOutputStream = new FileOutputStream (objName+".csv");
			OutputStreamWriter outpuStreamWriter = null;
			try {
				outpuStreamWriter = new OutputStreamWriter (fileOutputStream, "UTF-8");
			} catch (UnsupportedEncodingException ex) {
				System.out.println("Encoding nicht gefunden");
			}
			retBuf = new BufferedWriter(outpuStreamWriter);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		return retBuf;
	}
	
	private void downloadFile(String fileName) {
		def File file = new File(fileName)
		
		def os = response.outputStream
		response.setHeader("Content-Type", "application/octet-stream;")
		response.setHeader("Content-Disposition", "attachment;filename=${fileName}")
		response.setHeader("Content-Length", "${file.size()}")

		def bytes = file.readBytes()
		for(b in bytes) {
			os.write(b)
		}
	}
}
