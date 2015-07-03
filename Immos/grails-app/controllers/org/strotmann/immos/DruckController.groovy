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

class DruckController {
	
	def printMietjournal () {
		def mOut = printFile ("mietjournal")
		Mietvertrag.printMietjournal(mOut)
		mOut.close()
		downloadFile("mietjournal.txt")
	}
	
	def printOffeneUmsaetze () {
		def uOut = printFile ("offeneUmsaetze")
		Bankumsatz.printOffeneUmsaetze(uOut);
		uOut.close()
		downloadFile("offeneUmsaetze.txt")
	}
	
	def printZuordnungen () {
		def zOut = printFile ("zahlungsZuordnung")
		Zahlung.printZuordnungen(zOut);
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
		
		CellStyle cellStyle = workBook.createCellStyle()
		short halign = CellStyle.ALIGN_RIGHT
		cellStyle.setAlignment(halign)
		
		CellStyle fatStyle = workBook.createCellStyle()
		fatStyle.setAlignment(halign)
		Font fatFont = workBook.createFont()
		short s = 5
		fatFont.setBoldweight(s)
		fatFont.setItalic(true)
		fatStyle.setFont(fatFont)
		
		//Bestimmung der Serienbriefparameter 1 Überschrift und je Serienbrief eine Zeile
		def sOut = csvFile ("serienbriefparameter")
		def Immoabrechnung immoabrechnung = Immoabrechnung.get(params.id)
		immoabrechnung.erzeugeCsv(sOut);
		sOut.close()
		XSSFSheet sheet0 = workBook.createSheet("Serienbriefparameter")
		def int rowNum = 0
		new File("serienbriefparameter.csv").eachLine {String line ->
			def String[] str = line.split(";")
			XSSFRow currentRow=sheet0.createRow(rowNum)
			
			for(int i=0;i<str.length;i++){
				
				Cell c = currentRow.createCell(i)
				
				c.setCellValue(str[i])
			}
			rowNum++
		}
		
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
			
			sheet.setColumnWidth(0, 5000)
			for (i in 1..5) {
				sheet.setColumnWidth(i, 4000)
			}
			rowNum = 0
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
					if (i > 0)
						c.setCellStyle(cellStyle)
					if (summenZeile)
						c.setCellStyle(fatStyle)
										
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
