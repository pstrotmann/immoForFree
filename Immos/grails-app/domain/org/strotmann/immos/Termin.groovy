package org.strotmann.immos

class Termin {
	
	Date vorlage
	String grund
	Date erledigung
	
	//referenzierte Objekte
	Organisation organisation
	Person person
	Immobilie immobilie
	Grundschuld grundschuld
	Mietvertrag mietvertrag
	Kredit kredit
	Dienstleistungsvertrag dienstleistungsvertrag
	Rechnung rechnung
	
    static constraints = {
		erledigung (nullable:true)
		organisation (nullable:true)
		person (nullable:true)
		immobilie (nullable:true)
		grundschuld (nullable:true)
		mietvertrag (nullable:true)
		kredit (nullable:true)
		dienstleistungsvertrag (nullable:true)
		rechnung (nullable:true)
	}
	
	String toString() {
		return 	"${this.vorlage},${this.grund},${this.erledigung}"
	}
	
	String getReferenz() {
		String s = " "
		if(dienstleistungsvertrag) s=s+"Vertrag:${dienstleistungsvertrag},"
		if(immobilie) s=s+"Objekt:${immobilie},"
		if(mietvertrag) s=s+"Vertrag:${mietvertrag},"
		if(person) s=s+"Person:${person},"
		if(organisation) s=s+"Organisation:${organisation},"
		
		s.substring(0, s.length() - 1).trim()
	}
}
