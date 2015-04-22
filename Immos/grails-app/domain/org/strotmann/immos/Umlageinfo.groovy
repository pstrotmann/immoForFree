package org.strotmann.immos

import java.util.Date;
import java.util.List;
import grails.util.Holders

class Umlageinfo {

	Date von
	Date bis
	String kostenart
	String umlageschluessel
	Mietsache umlageAuf
	Dienstleistungsvertrag teilbescheidVon
	
	static belongsTo = [rechnung:Rechnung]
	
	static constraints = {
		von()
		bis()
		kostenart()
		umlageschluessel(inList: umlageschluessels)
		umlageAuf(nullable:true)
		teilbescheidVon(nullable:true)
    }
	
	String toString() {
		if(rechnung)
			"${umlageAuf?:rechnung.immobilie},${kostenart},${umlageschluessel}"
		else
			""
	}
	
	static List getUmlageschluessels () {
		List u = Holders.config.umlageschluessel
		return u
	}
}
