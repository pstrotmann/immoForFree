package org.strotmann.immos

import java.util.List;

class Mietsache implements Comparable{
	
	String lage // in Immobilie
	String art // (Mietsachen)art
	BigDecimal wohnflaeche
	String aufteilung
	int anzRauchmelder
	
	static belongsTo = [immobilie:Immobilie]
	
	static hasMany = [zwischenzaehlers:Zwischenzaehler]
	
	static constraints = {		
		lage()
		art()
		wohnflaeche (nullable:true)
		aufteilung (nullable:true)
		anzRauchmelder()
	}
		
	int compareTo(obj) {
		if (art.equals("Wohnung"))
			return -1
		else
			return 1
	}
	
	String getMietsacheKurz () {
		"${art},${lage}"
	}
		
	String toString() {
		return "${this.immobilie},${art},${lage}"
	}
	
	static List getArten () {
		grails.util.Holders.config.mietsachenart
	}
	
	List getMietvertraege () {
		return(Mietvertrag.findAll("from Mietvertrag as mv where mv.mietsache = ${id} or mv.zusatzMietsache = ${id}"))
	}
	
	List getVertragsstaende () {
		return(Mietvertragsstand.findAll("from Mietvertragsstand as mvs where mvs.mietvertrag.mietsache = ${id} or mvs.mietvertrag.zusatzMietsache = ${id}"))
	}
	
	int getAktPersonen () {
		Mietvertrag mv = Mietvertrag.find("from Mietvertrag as mv where mv.mietsache = ${id} and mv.mietende = null")
		Mietvertragsstand mvStand = mv.vertragsstaende.first()
		mvStand.anzahlPersonen
	}
	
	static List mietsachenZuImmo (Rechnung rechnung) {
		String suchString = "from Mietsache as ms where ms.immobilie.id = ${rechnung.immobilie.id} "
		Mietsache.findAll(suchString)
	}
	
	static List mietsachenZuImmo (Dienstleistungsvertrag dienstleistungsvertrag) {
		String suchString = "from Mietsache as ms where ms.immobilie.id = ${dienstleistungsvertrag.immobilie.id} "
		Mietsache.findAll(suchString)
	}
}
