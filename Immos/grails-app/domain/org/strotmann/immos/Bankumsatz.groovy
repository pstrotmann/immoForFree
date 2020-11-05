package org.strotmann.immos

import java.io.BufferedWriter;
import java.io.File;
import java.util.List;
import org.apache.commons.lang.*

class Bankumsatz {
	
	String auftragskonto
	String buchungstag
	String valutadatum
	String buchungstext
	String verwendungszweck
	String verwLong
	String glaeubigerId
	String mandatsreferenz
	String kundenreferenz
	String sammlerreferenz
	String lastschriftUrsprungsbetrag
	String auslagenersatzRuecklastschrift
	String beguenstigterZahlungspflichtiger
	String kontonummerIBAN
	String bic
	String betrag
	String waehrung
	String info	
	
	static hasMany = [zahlungen:Zahlung]
	
	static mapping = {
		valutadatum column: 'Valutadatum', index: 'Valutadatum_Idx'
		verwLong column: 'verwLong', sqlType: "varchar(1024)"
	}

    static constraints = {
		 auftragskonto()
		 buchungstag()
		 valutadatum()
		 buchungstext()
		 verwendungszweck()
		 verwLong(nullable: true)
		 glaeubigerId()
		 mandatsreferenz()
		 kundenreferenz()
		 sammlerreferenz()
		 lastschriftUrsprungsbetrag()
		 auslagenersatzRuecklastschrift()
		 beguenstigterZahlungspflichtiger()
		 kontonummerIBAN()
		 bic()
		 betrag()
		 waehrung()
		 info()
    }
	
	String toString() {"${this.valutadatum},${this.betrag},${this.beguenstigterZahlungspflichtiger}"}
	
	static List getUmsaetze () {
		Bankumsatz.findAll("from Bankumsatz as b order by b.beguenstigterZahlungspflichtiger, b.buchungstag")
	}
	
	static List getOffeneUmsaetze (int jahr) {
		
		List umsOffen = []
		
		String s = "from Bankumsatz as b where length(b.valutadatum) = 8 and substring(b.valutadatum,7,2) = ? order by substring(b.valutadatum,4,2), substring(b.valutadatum,1,2)"
		List umsJahr = Bankumsatz.findAll(s, [jahr.toString().substring(2,4)])
		
		umsJahr.each {Bankumsatz b ->
			List zahlungZuB = Zahlung.findAll("from Zahlung as z where z.bankumsatz = ${b.id}")
			if (zahlungZuB.empty)
				umsOffen << b			
		}
		
		umsOffen
	}
	
	static List getZeitraumUms (long maxId) {
		def Calendar ago = Calendar.getInstance()
		use (groovy.time.TimeCategory) {
			ago.setTime(new Date() - 3.months)
		}
		def Calendar umsDat = Calendar.getInstance()
		List <Bankumsatz> bu = []
		String s = "from Bankumsatz as b where b.id > ? and substring(verwendungszweck,1,6) <> 'PS-LOS' and substring(verwendungszweck,1,8) <> 'Sparrate' and not exists (from Zahlung as z where z.bankumsatz = b.id)"
		
		Bankumsatz.findAll(s,[maxId]).each {Bankumsatz bUms ->
			if (bUms.valutadatum.size() == 8 ) {
				umsDat.setTime(new java.text.SimpleDateFormat("dd.MM.yy").parse(bUms.valutadatum))
				if (umsDat > ago)
					bu << bUms
			}
		}
		bu
	}
	
	static List getZugeordneteUmsaetze (int jahr) {
		List <Bankumsatz> bu = []
		String s = "from Bankumsatz as b where exists (from Zahlung as z where z.bankumsatz = b.id) order by b.beguenstigterZahlungspflichtiger"
		Bankumsatz.findAll(s).each {
			if (it.valutadatum.size() == 8 && it.valutadatum.substring(6,8)== jahr.toString().substring(2,4))
				bu << it
		}
		bu
	}
	
	static void printOffeneUmsaetze (PrintWriter uOut, int jahr) {
		List <Bankumsatz> bList = getOffeneUmsaetze (jahr)
		uOut.println("-------------- Offene Umsätze für ${jahr} --------------------")
		bList.each {b ->
			String verw = StringUtils.rightPad(StringUtils.leftPad(StringUtils.substring(b.verwendungszweck+' '+b.buchungstext,0,50),50,' '),50,' ')
			String beZa = StringUtils.rightPad(StringUtils.substring(b.beguenstigterZahlungspflichtiger,0,27),27,' ')
			String bBtr = StringUtils.leftPad(b.betrag.toString(),10,' ')
			uOut.println(b.valutadatum.replace('.14', '.2014')+' '+verw+' '+beZa+' '+bBtr)
		} 
	}
}
