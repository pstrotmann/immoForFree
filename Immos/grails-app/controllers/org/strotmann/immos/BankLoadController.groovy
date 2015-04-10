package org.strotmann.immos

import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.poifs.filesystem.POIFSFileSystem

class BankLoadController {

    def index() { 
		render ("Bank Tabelle wird aus ExcelDatei der Bundesbank geladen")
		// öffnen ExcelDatei der Bundesbank
		POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("/vol/BLZ_BIC.xls"));
		HSSFWorkbook bBkTab = new HSSFWorkbook(fs);
		HSSFSheet bBkSheet = bBkTab.getSheetAt(0);
		for (int i = 1; i <= bBkSheet.getLastRowNum(); i++)
		//for (int i = 1; i <= 1000; i++)
		{
			HSSFRow row = bBkSheet.getRow(i);
			render ("<p>"+"BLZ="+row.getCell(0).getStringCellValue()+"</p>")
			params.bankleitzahl = row.getCell(0).getStringCellValue().toInteger()
			params.name = row.getCell(1).getStringCellValue()
			params.postleitzahl = row.getCell(2).getStringCellValue().toInteger()
			params.nameZusatz = "z.z."+i
			params.zusatz = "z.z."+i
			params.ort = row.getCell(3).getStringCellValue()
			params.bic = row.getCell(4).getStringCellValue()
			render (params)
			try {
				def b = new Bank (params)
				params.strasse = "n.n."+i
				params.hausnummer = 1
				def h = new Hausadresse(params)
				if (!h.save(flush:true)) {
					h.errors.each {
						println it
						render (it)
					}
				}
				b.hausadresse = Hausadresse.get(h.id)
				if (!b.save(flush:true)) {
					b.errors.each {
						println it
						render (it)
					}
				}
								
			} catch (Exception e) {
				e.printStackTrace()
			} 			
		}
		render ("Bank Tabelle wurde aus ExcelDatei der Bundesbank geladen")
	}
	
}
