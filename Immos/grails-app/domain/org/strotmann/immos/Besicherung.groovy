package org.strotmann.immos

import org.strotmann.util.*

class Besicherung implements Comparable {

    Kredit kredit
	Grundschuld grundschuld
	BigDecimal betrag

    static constraints = {
		kredit()
		grundschuld()
		betrag()
    }
	
	String toString() {
		"${kredit},${grundschuld},${betrag?BigDec.nk0(betrag):''}"
	}
	
	String getGrString() {
		"${grundschuld}"
	}
	
	String getBtrString() {
		"Kredit:${kredit.vertragsnummer},${betrag?BigDec.nk0(betrag):''}"
	}
	
	int compareTo(obj) {
		grString.compareTo(obj.grString)
	}
}
