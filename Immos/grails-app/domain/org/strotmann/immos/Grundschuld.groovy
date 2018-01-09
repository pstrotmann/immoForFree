package org.strotmann.immos

import java.util.List;

class Grundschuld implements Comparable {
	
	Date eintragAm
	Date loeschungAm
	BigDecimal betrag
	int rang
	
	Organisation glaeubiger
	
	static belongsTo = [immobilie:Immobilie]
	
	static hasMany = [kredite:Kredit]

    static constraints = {
		eintragAm()
		loeschungAm(nullable:true)
		betrag()
		rang()		
    }
	
	int compareTo(obj) {
		rang.compareTo(obj.rang)
	}
	
	String toString() {
		"${glaeubiger.name},${betrag}"
	}
	
	static List getGrundschuldList () {
		Grundschuld.findAll("from Grundschuld order by eintragAm")
	}
}
