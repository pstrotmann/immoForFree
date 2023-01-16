package org.strotmann.immos

import org.strotmann.util.IBAN

class BankumsatzImportController {

    def index() {
		def org.springframework.web.multipart.commons.CommonsMultipartFile f = request.getFile('file')
		String fName = f.getOriginalFilename()
		if (!(fName.contains('-umsatz') && (fName.contains('.csv') || fName.contains('.CSV')))) {
			flash.messageF = "ungültiger Dateiname, nur ....-umsatz...csv erlaubt"
		}
		else {
			flash.messageF = null
		}
		
		if (!flash.messageF) {	
			f.transferTo(new File('sparkasse-umsatz.csv'))
			File b = new File("sparkasse-umsatz.csv")
			boolean bOk
			try {
				b.eachLine {}
				bOk = true
			} catch (Exception e) {
				bOk = false
				flash.message = "Datei sparkasse-umsatz.csv nicht vorhanden"
			}
			if (bOk) {
				def int i = 0
				def int k = 0
				b.eachLine("ISO-8859-15")
				 {line ->
				 if (line.startsWith('"Auftragskonto"')) {return}
				 def bankumsatz = new Bankumsatz()
				 def lineArray = line.split(';')
				 def int j = 0
				 lineArray.each
				  	{it->
						def String itPur, itLong
						if(it.length() > 255) { 
						   itPur = it.substring(1,255) 
						   itLong = it
						}
						else
						   itPur = it.substring(1,it.length()-1)
						 
						switch (j) {
						  case 0: bankumsatz.auftragskonto = itPur
						  case 1: bankumsatz.buchungstag = itPur
						  case 2: bankumsatz.valutadatum = itPur
						  case 3: bankumsatz.buchungstext = itPur
						  case 4: bankumsatz.verwendungszweck = itPur
						          bankumsatz.verwLong = itLong
						  case 5: bankumsatz.glaeubigerId = itPur
						  case 6: bankumsatz.mandatsreferenz = itPur
						  case 7: bankumsatz.kundenreferenz = itPur
						  case 8: bankumsatz.sammlerreferenz = itPur
						  case 9: bankumsatz.lastschriftUrsprungsbetrag = itPur
						  case 10: bankumsatz.auslagenersatzRuecklastschrift = itPur
						  case 11: bankumsatz.beguenstigterZahlungspflichtiger = itPur
						  case 12: bankumsatz.kontonummerIBAN = itPur
						  case 13: bankumsatz.bic = itPur
						  case 14: bankumsatz.betrag = itPur
						  case 15: bankumsatz.waehrung = itPur
						  case 16: bankumsatz.info = itPur
					  }
					  j++
					}
				 i++
				 if (!inDB(bankumsatz) && !bankumsatz.info.contains("vorgemerkt"))	{
					 bankumsatz.kontonummerIBAN = IBAN.generateAccountNumber(bankumsatz.bic, bankumsatz.kontonummerIBAN)
					 bankumsatz.bic = IBAN.generateBIC(bankumsatz.kontonummerIBAN)
				 	 bankumsatz.save()
					 k++
				 }	
				}
				flash.message = "${i} Bankumsätze sind gelesen, ${k} Bankumsätze sind importiert"
			}
		}
		redirect(uri: "/")
    }
	
	boolean inDB (Bankumsatz b) {
		List <Bankumsatz> bList = 
		Bankumsatz.findAllByValutadatumAndVerwendungszweckAndBeguenstigterZahlungspflichtigerAndBetrag (b.valutadatum, b.verwendungszweck, b.beguenstigterZahlungspflichtiger, b.betrag)
		if (bList.empty)
			return false
		else
			return true
	}
}
