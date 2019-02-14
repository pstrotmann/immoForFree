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
}
