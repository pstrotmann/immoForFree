package org.strotmann.immos

import java.util.Date;
import java.util.List;
import java.util.SortedSet;

import grails.util.Holders

class Dienstleistungsvertrag implements Comparable{
	
	Partnerrolle dienstleister
	Immobilie immobilie
	
	String dienstleistungsart
	
	String vertragsnummer // zum Zuordnen der Zahlung
	String kundennummer // zum Zuordnen der Zahlung
	String referenz // zum Zuordnen der Zahlung, z.B. Mandatsreferenz
	
	Date vertragsbeginn
	Date vertragsende
	
	int zahlweise
	
	boolean umlagefaehig
	
	Integer autoVerlJahre
	Integer kueWochen //zum Monatsende
	
	SortedSet zahlungen, vertragsstaende
	static hasMany = [zahlungen:Zahlung, vertragsstaende:Dienstleistungsvertragsstand]

    static constraints = {
		dienstleister()
		immobilie()
		dienstleistungsart()
		vertragsnummer(nullable:true)
		kundennummer(nullable:true)
		referenz(nullable:true)
		vertragsbeginn()
		vertragsende(nullable:true)
		autoVerlJahre(nullable:true)
		kueWochen(nullable:true)
		zahlweise(inList: Zahlung.zahlweiseNum)
    }
	
	int compareTo(obj) {
		String v1 = this.dienstleister.partner.name
		String v2 = obj.dienstleister.partner.name
		(v1+id).compareTo(v2+obj.id)
	}
	
	String toString() {
		return "${this.immobilie},${this.dienstleister.partner.name},${this.dienstleistungsart}"
	}
	
	String getDvKurz() {
		"${this.dienstleister.partner.name},${this.dienstleistungsart}"
	}
	
	static List getArten () {
		Holders.config.dienstleistungsart
	}
	
	static List getDienstleisterList () {
		Organisation.findAll("from Organisation as o where not o.rechtsform = 'Personengemeinschaft'").sort()
	}
	
	String getZahlweiseKlar() {
		Holders.config.zahlweise[zahlweise]
	}
	
	Double getPauschale () {
		def List dvsList = Dienstleistungsvertragsstand.findAll("from Dienstleistungsvertragsstand as dvs where dvs.dienstleistungsvertrag = ${id} order by dvs.id")
		def Dienstleistungsvertragsstand dvs = dvsList.empty ? null : dvsList.last()
		dvs ? dvs.pauschale : 0
	}
	
	String getReferenzen() {
		String k = kundennummer?:'_'
		String v = vertragsnummer?:'_'
		String r = referenz?:'_'
		k+', '+v+', '+r
	}
	
	static List getDienstleistungsvertraege () {
		Dienstleistungsvertrag.findAll("from Dienstleistungsvertrag order by dienstleister.partner.name")
	}
	
	static List dienstleistungsvertraegeZuImmo (Rechnung rechnung) {
		String suchString = "from Dienstleistungsvertrag as dv where dv.immobilie.id = ${rechnung.immobilie.id} "
		Dienstleistungsvertrag.findAll(suchString)
	}
}
