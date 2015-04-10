package org.strotmann.immos

import java.util.List;

import grails.util.Holders

class Umlage implements Comparable {

	String kostenart
	String umlageschluessel
	BigDecimal betrag
	int art //1=Nebenkostenumlage, 2=Heizkostenumlage
	
	Zaehler zaehler
	
	static belongsTo = [immoabrechnung:Immoabrechnung]
	
	static hasMany = [umlageanteile:Umlageanteil]
	
	static constraints = {
		kostenart(inList: kostenarten)
		umlageschluessel(inList: umlageschluessels)
		betrag()
		umlageanteile(nullable:true)
		zaehler(nullable:true)
		art()
    }
	
	int compareTo(obj) {
		sortpos.compareTo(obj.sortpos)
	}
	
	static List getUmlageschluessels () {
		List u = Holders.config.umlageschluessel
		return u
	}
	
	static List getKostenarten () {
		Holders.config.kostenart
	}
	
	int getSortpos() {
		def int i = 0
		def int retI = 0
		kostenarten.each {String koart ->
			i++
			if (koart == kostenart) retI = i
			}
		retI
	}
	
	String toString() {
		def nbsp = "\u2007"
		def btr =betrag.toString().replace('.',',').padLeft(10,nbsp)
		def koArt =kostenart.toString().padRight(30,nbsp)
		def umlKey =umlageschluessel.toString().padRight(10,nbsp)
		"${kostenart},${umlageschluessel},${betrag}"
	}
	
	BigDecimal getBetragOhneZZ () {
		
		this.betrag - (zzBetrag?:0)
	} 
	
	BigDecimal getZzBetrag () {
		if (ZVerbrauch)		
			return ((zzVerbrauch?:0) / ZVerbrauch) * this.betrag
		else
			return null
	}
	
	BigDecimal getZzVerbrauch () {		
		BigDecimal zzV = 0	
		if (!zaehler)
			return null
		this.zaehler.zwischenzaehlers.each {Zwischenzaehler zz ->
			Zwischenzaehlerstand zz1st
			Zwischenzaehlerstand zz2nd
			def i = 0
			zz.zwischenzaehlerstaende.each {Zwischenzaehlerstand zzStand ->
				if (jahr(zzStand.ablesedatum) > immoabrechnung.jahr) {return}
				i++
				if (i == 1) zz1st = zzStand
				if (i == 2) zz2nd = zzStand
			}
			zzV += (zz1st?zz1st.wert:0) - (zz2nd?zz2nd.wert:0) 
		}
		zzV
	}
	
	BigDecimal getZVerbrauch () {
		BigDecimal zV = 0
		if (!zaehler)
			 return null
		Zaehlerstand z1st
		Zaehlerstand z2nd
		def i = 0
		zaehler.zaehlerstaende.each {Zaehlerstand zStand ->
			if (jahr(zStand.ablesedatum) > immoabrechnung.jahr) {return}
			i++
			if (i == 1) z1st = zStand
			if (i == 2) z2nd = zStand
		}
		zV += (z1st?z1st.wert:0) - (z2nd?z2nd.wert:0) 
		zV
	}
	
	List <Zaehler> getZaehlers () {
		List zList = []		
		Zaehler.findAll ("from Zaehler as z where z.immobilie = ${this.immoabrechnung.immobilie.id}").each {zList << it}
		zList
	}
	
	int jahr (Date d) {
		def Calendar c = Calendar.getInstance();
		c.setTime(d)
		c.get(Calendar.YEAR)
	}
}
