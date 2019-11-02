package org.strotmann.immos

import org.strotmann.util.*

class Verwendung implements Comparable {
	
	Kredit kredit
	Immobilie immobilie
	BigDecimal betrag

    static constraints = {
		kredit()
		immobilie()
		betrag()
    }
	
	String toString() {
		"${kredit},${immobilie},${betrag?BigDec.nk0(betrag):''}"
	}
	
	String getImmoString() {
		"${immobilie},${BigDec.nk0(betrag)}"
	}
	
	int compareTo(obj) {
		immoString.compareTo(obj.immoString)
	}
	
	BigDecimal getVerwSaldo() {
		kredit.kreditsaldo * (this.betrag / kredit.betrag)
	}
}
