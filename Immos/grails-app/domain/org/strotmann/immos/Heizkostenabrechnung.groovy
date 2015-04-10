package org.strotmann.immos

class Heizkostenabrechnung {
	
	/*
	 * die Heizkostenabrechnung wird vorläufig nur im Ergebnis festgehalten
	 * die eigentliche Durchführung erfolgt extern	
	 * Sollte die Abrechnung selbst erstellt werden, wird sie analog der
	 * Nebenkostenabrechnung implementiert
	 */
	
	static belongsTo = [betriebskostenabrechnung:Betriebskostenabrechnung]
	
	Date von
	Date bis
	
	BigDecimal betrag

    static constraints = {
		von()
		bis()
		betrag()
    }
	String toString() {
		"${betriebskostenabrechnung.mietvertrag} für:${betriebskostenabrechnung.immoabrechnung.jahr}"
	}
}
