package org.strotmann.immos

import java.util.List;
import java.util.SortedSet;
import org.apache.commons.lang.*

class Rechnung implements Comparable{
	
	Partnerrolle rechnungssteller
	Immobilie immobilie
	
	String rechnungsgegenstand // ausgeführte Arbeit, Dienstleistung
	String rechnungsnummer // des Rechnungsstellers
	String kundennummer // unsere Kundennummer beim Rechnungssteller
	String auftragsnummer // Auftrags-, Projekt-, Vorgangsnummer beim Rechnungssteller
	Date rechnungsdatum
		
	BigDecimal betrag  //bruttoBetrag - skonto
	BigDecimal nettoBetrag
	BigDecimal mehrwertsteuerSatz  //%
	BigDecimal mehrwertsteuer // =  nettoBetrag * mehrwertsteuerSatz / 100
	BigDecimal bruttoBetrag // = nettoBetrag + mehrwertsteuer
	BigDecimal skontoSatz //%
	BigDecimal skonto //bruttoBetrag * skontoSatz / 100
	
	boolean umlagefaehig
	
	SortedSet zahlungen
	static hasMany = [zahlungen:Zahlung]
	
    static constraints = {
		rechnungssteller()
		immobilie()
		rechnungsdatum()
		betrag()
		bruttoBetrag(nullable:true)
		nettoBetrag(nullable:true)
		mehrwertsteuerSatz(nullable:true)
		mehrwertsteuer(nullable:true)
		skontoSatz(nullable:true)
		skonto(nullable:true)
		kundennummer(nullable:true)
		auftragsnummer(nullable:true)
		umlagefaehig(nullable:true)
	}
	
	int compareTo(obj) {
		if (rechnungsdatum.compareTo(obj.rechnungsdatum) < 0)
			return -1
		else
			if (rechnungsdatum.compareTo(obj.rechnungsdatum) > 0)
				return 1
			else
				return id.compareTo(obj.id) * (-1)
	}
	
	String getDatum (Date d) {
		return d.getDateString() 
	}
	
	String getReLang() {
		def nbsp = "\u2007"
		toString()+','+nbsp+rechnungssteller.partner.name
	}
	
	String toString() {
		def nbsp = "\u2007"
		def btr =betrag.toString().replace('.',',').padLeft(9,nbsp)
		"${rechnungsdatum.getDateString()}$btr ${rechnungsgegenstand}"
	}
	
	List <Umlageinfo> getUmlageinfos() {
		if (this.id) { 
			String s = "from Umlageinfo as u where u.rechnung.id = ${this.id} "
			Umlageinfo.findAll (s)
		}
		else []
	}
	
	static List getFreeList () {
		Rechnung.findAll("from Rechnung as r order by r.rechnungsdatum")
	}
	
	static List getRechnungen () {
		Rechnung.findAll("from Rechnung order by rechnungssteller.partner.name")
	}
	
	static List getRechnungen (Immobilie i) {
		Rechnung.findAll("from Rechnung as r where r.immobilie.id = ${i.id} order by r.rechnungsdatum")
	}
	
	static List getRechnungsstellerList () {
		Organisation.findAll("from Organisation as o where o.rechtsform = null or not o.rechtsform = 'Personengemeinschaft' order by o.name")
	}
}
