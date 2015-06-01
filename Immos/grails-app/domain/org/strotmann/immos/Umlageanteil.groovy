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
	
	String getFormel() {
		def String fo = ""
		def Map koartAb = nebenkostenabrechnung.betriebskostenabrechnung.immoabrechnung.koartAbschlaege
		if (umlageschluessel.equals("qm")) {
			def BigDecimal wfImmo
			wfImmo = nebenkostenabrechnung.betriebskostenabrechnung.immoabrechnung.immobilie.wohnflaeche
			def BigDecimal wfMiet
			wfMiet = nebenkostenabrechnung.betriebskostenabrechnung.mietvertrag.mietsache.wohnflaeche
			def abWf = koartAb."${kostenart}"?koartAb."${kostenart}"[0]:0
			fo = (wfMiet.toString()+'/'+(wfImmo - abWf).toString()).replace('.',',')
		}
		if (umlageschluessel.equals("Personen")) {
			def int persImmo
			persImmo = nebenkostenabrechnung.betriebskostenabrechnung.immoabrechnung.immobilie.anzahlPersonen
			def BigDecimal persMiet
			persMiet = nebenkostenabrechnung.betriebskostenabrechnung.mietvertrag.anzahlPersonen
			def abPers = koartAb."${kostenart}"?koartAb."${kostenart}"[1]:0
			fo = persMiet.toString()+'/'+(persImmo - abPers).toString()
		
		}
		if (umlageschluessel.equals("Haushalt")) {
			def int immoHH
			immoHH = nebenkostenabrechnung.betriebskostenabrechnung.immoabrechnung.immobilie.anzahlHaushalte
			fo = "1/"+immoHH.toString()
		}
		if (umlageschluessel.equals("Zähler") && umlage.zaehler) {
			def Zaehler z = umlage.zaehler
			def int i = 0
			def BigDecimal zWert = 0
			z.zaehlerstaende.each {Zaehlerstand zSt ->
				i++
				if (i == 1) zWert += zSt.wert
				if (i == 2) zWert -= zSt.wert
				if (i >  2) {return}
			}
			def String zzStr = ''
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
					zzStr += '+'+zzWert.toString().replace('.',',').replace(',000', '')
				}
			}
			zzStr = zzStr.substring(1)
			if (zzStr.contains('+')) zzStr = '('+zzStr+')'
			fo = zzStr+"/"+zWert.toString().replace('.',',').replace(',000', '')
		}
		fo
	}
}
