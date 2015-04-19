package org.strotmann.immos

class Kostenart {

    String bezeichnung
	boolean kommunal
	
	static constraints = {
		bezeichnung()
		kommunal(nullable:true)
    }
	
	String toString() {
		"${bezeichnung} ${kommunal:'kommunale Kostenart'}"
	}
}
