package org.strotmann.immos

import java.util.Date;

class Zwischenzaehlerstand implements Comparable {

    Date ablesedatum
	BigDecimal wert
	
	static belongsTo = [zz:Zwischenzaehler]
	
	static constraints = {
		ablesedatum()
		wert(scale:3)
    }
	
	int compareTo(obj) {
		ablesedatum.compareTo(obj.ablesedatum) * (-1)
	}
	
	String toString () {
		"${ablesedatum.getDateString()}, ${wert.toString().replace('.',',')} ${zz.zaehler.zaehlereinheit}"
	}
}
