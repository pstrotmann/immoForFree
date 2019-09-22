package org.strotmann.immos

import java.util.List;
import org.strotmann.util.*

class Grundschuld implements Comparable {
	
	Date eintragAm
	Date loeschungAm
	BigDecimal betrag
	int rang
	
	Organisation glaeubiger
	
	static belongsTo = [immobilie:Immobilie]
	
	static hasMany = [kredite:Kredit, //nicht mehr gepflegt
		 besicherungen:Besicherung]

    static constraints = {
		eintragAm()
		loeschungAm(nullable:true)
		betrag()
		rang()		
    }
	
	int compareTo(obj) {
		
		String plz = immobilie.hausadresse.postleitzahl
		String oplz = obj.immobilie.hausadresse.postleitzahl
		String str = immobilie.hausadresse.strasse
		String ostr = obj.immobilie.hausadresse.strasse
		String hnr = immobilie.hausadresse.hausnummer
		String ohnr = obj.immobilie.hausadresse.hausnummer
		
		(plz+str+hnr+rang+id).compareTo(oplz+ostr+ohnr+obj.rang+obj.id)
	}
	
	String toString() {
		"${immobilie},${glaeubiger.name},${BigDec.nk0(betrag)}"
	}
	
	String getNoImmo() {
		"${glaeubiger.name},${BigDec.nk0(betrag)}"
	}
	
	BigDecimal getSaldo() {
		BigDecimal s = 0
		kredite.each {Kredit k ->
			s += k.kreditsaldo
		}
		s
	}
		
	static List getGrundschuldList () {
		Grundschuld.findAll("from Grundschuld where loeschungAm is null").sort()
	}
	
	static BigDecimal getGrundschuldSumme () {
		BigDecimal s = 0
		grundschuldList.each {Grundschuld  g -> 
			s += g.betrag
		}
		s
	}
}
