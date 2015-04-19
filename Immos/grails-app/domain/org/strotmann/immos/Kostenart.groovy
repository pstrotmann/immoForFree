package org.strotmann.immos

class Kostenart {

    String bezeichnung
	boolean kommunal
	
	static constraints = {
		bezeichnung()
		kommunal(nullable:true)
    }
}
