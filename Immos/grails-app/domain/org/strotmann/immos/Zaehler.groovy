package org.strotmann.immos

import java.util.List;
import java.util.SortedSet;
import grails.util.Holders

class Zaehler {
	
	String zaehlernummer
	String zaehlertyp
	String zaehlereinheit
	
	static belongsTo = [immobilie:Immobilie]
	
	SortedSet zaehlerstaende
	static hasMany = [zaehlerstaende:Zaehlerstand, zwischenzaehlers:Zwischenzaehler]
	
	static constraints = {
		zaehlernummer(nullable:true)
		zaehlertyp(inList: zaehlertypen)
		zaehlereinheit(inList: zaehlereinheiten)
    }
	
	String toString () {
		"${zaehlernummer?zaehlernummer+',':''} ${zaehlertyp}"
	}
	
	String getZaehlerLong () {
		"${immobilie} ${zaehlernummer?zaehlernummer+',':''} ${zaehlertyp}"
	}
	
	List <Zwischenzaehler> getZwischenzaehler() {
		Zwischenzaehler.findAll("from Zwischenzaehler as zz where zz.zaehler = ${id}")	
	}
	
	static List getZaehlertypen () {
		Holders.config.zaehlertyp
	}
	
	static List getZaehlereinheiten () {
		Holders.config.zaehlereinheit
	}
}
