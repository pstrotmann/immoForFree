package org.strotmann.immos

import java.util.List;

class Umlageanteil implements Comparable{
	
	String kostenart
	String umlageschluessel
	BigDecimal betrag
	
	Nebenkostenabrechnung nebenkostenabrechnung

	static belongsTo = [umlage:Umlage]
	
	static constraints = {
		kostenart()
		umlageschluessel(inList: Umlage.umlageschluessels<<"Zähler")
		betrag()
	}
	
	int compareTo(obj) {
		umlage.id.compareTo(obj.umlage.id)
	}
	
	String toString() {
		"${kostenart},${umlageschluessel},${betrag}"
	}
	
	int getSortpos() {
		def int i = 0
		def int retI = 0
		Umlage.kostenarten.each {String koart ->
			i++
			if (koart == kostenart) retI = i*1000000 + id
			}
		retI
	}
	
	BigDecimal getGesamtbetrag () {
		BigDecimal gesBtr = 0
		nebenkostenabrechnung.betriebskostenabrechnung.immoabrechnung.umlagen.each {Umlage u ->
			if (u.kostenart == kostenart)
				gesBtr = u.betrag
		}
		gesBtr
	}
	
	BigDecimal getUmlagebetrag () {
		BigDecimal umBtr = 0
		def Map koartAb = nebenkostenabrechnung.betriebskostenabrechnung.immoabrechnung.koartAbschlaege
		def abBtr = koartAb."${kostenart}"?koartAb."${kostenart}"[2]:0	
		umBtr = gesamtbetrag - abBtr
		umBtr
	}
	
	String getEinheit() {
		umlage.zaehler?umlage.zaehler.zaehlereinheit:''
	}
	
	String getMenge() {
		umlage.menge
	}
	
	String getAnteil() {
		def String fo = ""
		def Map koartAb = nebenkostenabrechnung.betriebskostenabrechnung.immoabrechnung.koartAbschlaege
		if (umlageschluessel.equals("qm")) {
			def BigDecimal wfMiet
			wfMiet = nebenkostenabrechnung.betriebskostenabrechnung.mietvertrag.mietsache.wohnflaeche
			fo = wfMiet.toString().replace('.',',').replace(',00', '')
		}
		if (umlageschluessel.equals("Personen")) {
			def BigDecimal persMiet
			persMiet = nebenkostenabrechnung.betriebskostenabrechnung.mietvertrag.anzahlPersonen
			fo = persMiet.toString()
		
		}
		if (umlageschluessel.equals("Haushalt")) {
			fo = "1"
		}
		if (umlageschluessel.equals("Zaehler") && umlage.zaehler) {
			def Zaehler z = umlage.zaehler
			def int i = 0
			def String zzStr = ''
			def BigDecimal zzSum = 0
			z.zwischenzaehlers.each {Zwischenzaehler zz ->
				if (nebenkostenabrechnung.betriebskostenabrechnung.mietvertrag.mietsache.id == zz.mietsache.id) {
					i = 0
					def BigDecimal zzWert = 0
					zz.zwischenzaehlerstaende.each {Zwischenzaehlerstand zzSt ->
						i++
						if (i == 1) zzWert += zzSt.wert
						if (i == 2) zzWert -= zzSt.wert
						if (i >  2) {return}
					}
					zzSum += zzWert
					zzStr += '+'+zzWert.toString().replace('.',',').replace(',00', '')
				}
			}
			//zzStr = zzStr.substring(1)
			//fo = zzStr
			fo = zzSum.toString().replace('.',',').replace(',00', '')
		}
		
		if (umlageschluessel.equals("Stück")) {
			String anzW = nebenkostenabrechnung.betriebskostenabrechnung.mietvertrag.mietsache.anzWasserzaehler.toString()
			fo = anzW
		}
		
		fo
	}
}
