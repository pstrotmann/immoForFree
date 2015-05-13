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
	
	Dienstleistungsvertrag dienstleistungsvertrag
	Date abrDatum //Abrechnungsdatum des Dienstleistungsvertrages
	BigDecimal abrBetrag //Abrechnungsbetrag des Dienstleistungsvertrages
	String abrGegenstand //des Dienstleistungsvertrages
	Rechnung rechnung
	
	static constraints = {
		rechnung(nullable:true)
		art(inList:["nk", "hk"])
		von()
		bis()
		kostenart()
		umlageschluessel(inList: umlageschluessels)
		verbrauch(nullable:true)
		einheit(nullable:true)
		umlageAuf(nullable:true)
		dienstleistungsvertrag(nullable:true)
		abrDatum(nullable:true)
		abrBetrag(nullable:true)
		abrGegenstand(nullable:true)
    }
	
	String toString() {
		if(rechnung)
			"${umlageAuf?:rechnung.immobilie},${kostenart},${umlageschluessel},${kurz(von)}-${kurz(bis)},${abrBetrag}"
		else
			if(dienstleistungsvertrag)
				"${umlageAuf?:dienstleistungsvertrag.immobilie},${kostenart},${umlageschluessel},${kurz(von)}-${kurz(bis)},${abrBetrag}"
				else ""
	}
	
	BigDecimal getAbrBetrag() {
		abrBetrag?:rechnung?rechnung.betrag:0
	}
	
	Date getAbrDatum() {
		rechnung?rechnung.rechnungsdatum:abrDatum
	}
	
	String getAbrGegenstand() {
		rechnung?rechnung.rechnungsgegenstand:abrGegenstand
	}
	
	Immobilie getImmobilie() {
		if (rechnung)
			rechnung.immobilie
		else
			dienstleistungsvertrag.immobilie
	}
	
	String kurz (Date d) {
		def Calendar cal = Calendar.getInstance();
		d?cal.setTime(d):cal.setTime(new Date())
		"${cal.get(Calendar.DAY_OF_MONTH)}.${cal.get(Calendar.MONTH)+1}.${cal.get(Calendar.YEAR)}"
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
	
	static List infoZuImmoUndArt (String immoId, String art) {
		List <Umlageinfo> uiList = []
		if (immoId) {
			int iId = new Integer (immoId)
			if (art)
				Umlageinfo.findAllByArt (art).each {if (iId == it.immobilie.id) uiList << it}
			else
				Umlageinfo.findAll().each {if (iId == it.immobilie.id) uiList << it}
		}
		else Umlageinfo.findAll().each {uiList << it}
	uiList
	}
}
