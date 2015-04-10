package org.strotmann.immos

class Kreditstand implements Comparable {
	
	Date laufzeitAb
	Date laufzeitBis
	BigDecimal bewilligt // bei Abschluss
	BigDecimal kreditsumme // bei laufzeitAb
	BigDecimal zinssatz // fest für Laufzeit
	BigDecimal tilgungssatz //Anfangstilgung
	BigDecimal annuitaet //zins++tilgungsbetrag
	BigDecimal zinsbetrag //für laufzeitBis - laufzeitAb
	BigDecimal tilgungsbetrag //für laufzeitBis - laufzeitAb
	BigDecimal verwKostenbetrag //Vewaltungskosten für laufzeitBis - laufzeitAb
	String sondertilgung
	
	static belongsTo = [kredit:Kredit]

	static constraints = {
		
		laufzeitAb()
		laufzeitBis()
		kreditsumme()
		bewilligt(nullable:true)
		zinssatz(nullable:true)
		tilgungssatz(nullable:true)
		annuitaet(nullable:true)
		zinsbetrag(nullable:true)
		tilgungsbetrag(nullable:true)
		verwKostenbetrag(nullable:true)
		sondertilgung(nullable:true)
    }
	
	int compareTo(obj) {
		id.compareTo(obj.id)
	}
	
	String toString() {
		"ab:${laufzeitAb.getDateString()},bis:${laufzeitBis.getDateString()},€${kreditsumme}"
	}
}
