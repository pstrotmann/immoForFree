package org.strotmann.util

class UmlageSel {
	long id
	String selektor
	
	UmlageSel (id, selektor) {
		this.id = id
		this.selektor = selektor
	}
	
	String toString() {"${selektor}"}
	
	static getUmlage (List <UmlageSel> u, String i) {
		UmlageSel uml
		u.each{UmlageSel us ->
			if (us.id == i.toLong())
				uml = us			
		}
		uml
	}
}
