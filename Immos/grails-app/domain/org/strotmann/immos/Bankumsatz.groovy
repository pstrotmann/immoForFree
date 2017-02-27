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
	}

    static constraints = {
		 auftragskonto()
		 buchungstag()
		 valutadatum()
		 buchungstext()
		 verwendungszweck()
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
	
	static List getOffeneUmsaetze () {
		def zeit = new Date()
		def jahr = "${1900+zeit.year}"
		List <Bankumsatz> bu = []
		String s = "from Bankumsatz as b where not exists (from Zahlung as z where z.bankumsatz = b.id) order by trim(leading 2 from substring(b.valutadatum,7,4)),substring(b.valutadatum,4,2), substring(b.valutadatum,1,2)"
		Bankumsatz.findAll(s).each {
			if (it.valutadatum.size() == 8 && it.valutadatum.substring(6,8)== jahr.substring(2,4)) 
				bu << it
		}
		bu
	}
	
	static List getZeitraumUms () {
		def Calendar ago = Calendar.getInstance()
		use (groovy.time.TimeCategory) {
			ago.setTime(new Date() - 3.months)
		}
		def Calendar umsDat = Calendar.getInstance()
		List <Bankumsatz> bu = []
		String s = "from Bankumsatz as b where substring(verwendungszweck,1,6) <> 'PS-LOS' and substring(verwendungszweck,1,8) <> 'Sparrate' and not exists (from Zahlung as z where z.bankumsatz = b.id)"
		Bankumsatz.findAll(s).each {Bankumsatz bUms ->
			if (bUms.valutadatum.size() == 8 ) {
				umsDat.setTime(new java.text.SimpleDateFormat("dd.MM.yy").parse(bUms.valutadatum))
				if (umsDat > ago)
					bu << bUms
			}
		}
		bu
	}
	
	static List getZugeordneteUmsaetze () {
		Bankumsatz.findAll("from Bankumsatz as b where exists (from Zahlung as z where z.bankumsatz = b.id) order by b.beguenstigterZahlungspflichtiger")
	}
	
	static void printOffeneUmsaetze (PrintWriter uOut) {
		List <Bankumsatz> bList = getOffeneUmsaetze ()
		bList.each {b ->
			String verw = StringUtils.rightPad(StringUtils.leftPad(StringUtils.substring(b.verwendungszweck+' '+b.buchungstext,0,50),50,' '),50,' ')
			String beZa = StringUtils.rightPad(StringUtils.substring(b.beguenstigterZahlungspflichtiger,0,27),27,' ')
			String bBtr = StringUtils.leftPad(b.betrag.toString(),10,' ')
			uOut.println(b.valutadatum.replace('.14', '.2014')+' '+verw+' '+beZa+' '+bBtr)
		} 
	}
}
