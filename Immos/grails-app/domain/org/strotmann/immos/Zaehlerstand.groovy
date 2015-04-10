package org.strotmann.immos

class Zaehlerstand implements Comparable {

    Date ablesedatum
	BigDecimal wert
	
	static belongsTo = [z:Zaehler]
	
	static constraints = {
		ablesedatum()
		wert(scale:3)
    }
	
	int compareTo(obj) {
		ablesedatum.compareTo(obj.ablesedatum) * (-1)
	}
	
	String toString () {
		"${ablesedatum.getDateString()}, ${wert.toString().replace('.',',')} ${z.zaehlereinheit}"
	}
}
