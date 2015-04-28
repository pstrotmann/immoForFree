package org.strotmann.immos

import java.util.Date;
import java.util.List;

import grails.util.Holders

class Umlageinfo {

	String art
	Date von
	Date bis
	String kostenart
	String umlageschluessel
	BigDecimal verbrauch
	String einheit
	Mietsache umlageAuf
	Dienstleistungsvertrag teilbescheidVon
	
	Rechnung rechnung
	
	static constraints = {
		rechnung()
		art(inList:["nk", "hk"])
		von()
		bis()
		kostenart()
		umlageschluessel(inList: umlageschluessels)
		verbrauch(nullable:true)
		einheit(nullable:true)
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
	
	static List getEinheiten () {
		List e = Holders.config.zaehlereinheit
		return e
	}
	
	static Date getAnfangVorjahr () {
		def Calendar cal = Calendar.getInstance();
		cal.setTime(new Date())
		int vorjahr = cal.get(Calendar.YEAR) - 1
		cal.set(vorjahr,Calendar.JANUARY,1)
		cal.getTime()
	}
	
	static Date getEndeVorjahr () {
		def Calendar cal = Calendar.getInstance();
		cal.setTime(new Date())
		int vorjahr = cal.get(Calendar.YEAR) - 1
		cal.set(vorjahr,Calendar.DECEMBER,31)
		cal.getTime()
	}
}
