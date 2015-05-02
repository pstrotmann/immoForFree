package org.strotmann.immos

import java.io.BufferedWriter;
import java.util.Date;

import grails.util.Holders

class Immoabrechnung implements Comparable {
	
	int jahr   //der Abrechnung
	Date datum //der Abrechnung

    static belongsTo = [immobilie:Immobilie]
	
	SortedSet umlagen
	static hasMany = [umlagen:Umlage, betriebskostenabrechnungen:Betriebskostenabrechnung]
     
    static constraints = {
		jahr()
		datum()
    }
	
	int compareTo(obj) {
		jahr.compareTo(obj.jahr)
	}
	
	String getAbrKurz() {
		"für:${jahr},vom:${datum.getDateString()}"
	}
	
	String toString() {
		"${immobilie},${jahr},vom:${datum.getDateString()}"
	}
	
	void abrechnenNebko () {
		def BigDecimal wF = immobilie.wohnflaeche
		def BigDecimal anzP = immobilie.anzahlPersonen
		def BigDecimal anzHH = immobilie.anzahlHaushalte
		def Map koartMap = koartAbschlaege
		Umlage umlageausfallwagnis = null
		if (immobilie.sozialerWohnungsbau) {
			if (umlagen.last().kostenart == '2% Umlageausfallwagnis'){
				umlageausfallwagnis = umlagen.last()
				umlageausfallwagnis.betrag = 0
			}
			else {
				umlageausfallwagnis = new Umlage()
				umlageausfallwagnis.kostenart = '2% Umlageausfallwagnis'
				umlageausfallwagnis.umlageschluessel = 'gesetzliche Umlage'
				umlageausfallwagnis.betrag = 0
				umlageausfallwagnis.immoabrechnung = this
			}
		}
		
		def List <Mietvertrag> mvList = Mietvertrag.findAll("from Mietvertrag as mv where mv.mietsache.immobilie = ${immobilie.id}")
		mvList.each {mv ->
			if (mv.anzahlPersonen == 0) {return}
			def Nebenkostenabrechnung nebenkostenabrechnung 
			def Betriebskostenabrechnung betriebskostenabrechnung
			mv.betriebskostenabrechnungen.each {Betriebskostenabrechnung ba ->
				if (ba.immoabrechnung.id == id)
					betriebskostenabrechnung = ba
				if (ba.nebenkostenabrechnungen)
					nebenkostenabrechnung = Nebenkostenabrechnung.get(ba.nebenkostenabrechnungen[0].id)
			}
			if (!betriebskostenabrechnung) {
				betriebskostenabrechnung = new Betriebskostenabrechnung()
				betriebskostenabrechnung.mietvertrag = mv
				betriebskostenabrechnung.immoabrechnung = this
				betriebskostenabrechnung.save()
			}
			if (!nebenkostenabrechnung) { 
				nebenkostenabrechnung = new Nebenkostenabrechnung()
				nebenkostenabrechnung.betriebskostenabrechnung = betriebskostenabrechnung
				nebenkostenabrechnung.save()				
			}
			
			def BigDecimal nebkoSum = 0
			def Umlageanteil ausW = null
			umlagen.each {Umlage u ->
				
				def Umlageanteil umlageanteil
				nebenkostenabrechnung.umlageanteile.each {Umlageanteil ua ->
					if (ua.kostenart == u.kostenart)
						umlageanteil = ua
				}
				if (u.kostenart == '2% Umlageausfallwagnis') ausW = umlageanteil					
				if (ausW) {return}
				
				if (umlageanteil && umlageanteil.umlageschluessel == "Zähler")
					 {nebkoSum += umlageanteil.betrag
						 return}
				
				if (!umlageanteil)
					umlageanteil = new Umlageanteil()
					
				umlageanteil.nebenkostenabrechnung = nebenkostenabrechnung
				umlageanteil.kostenart = u.kostenart
				umlageanteil.umlageschluessel = u.umlageschluessel
				umlageanteil.umlage = u
				def BigDecimal btrKorr = koartMap."${u.kostenart}"?koartMap."${u.kostenart}"[2]:0
				def BigDecimal wfKorr = koartMap."${u.kostenart}"?koartMap."${u.kostenart}"[0]:0
				def int persKorr = koartMap."${u.kostenart}"?koartMap."${u.kostenart}"[1]:0
				if (u.umlageschluessel.equals("qm")) 
					umlageanteil.betrag = (u.betrag - btrKorr) * (mv.mietsache.wohnflaeche / (wF - wfKorr))
				if (u.umlageschluessel.equals("Personen"))
					umlageanteil.betrag = (u.betrag - btrKorr) * (mv.anzahlPersonen / (anzP - persKorr))
				if (u.umlageschluessel.equals("Haushalt"))
					umlageanteil.betrag = u.betrag / anzHH
				
				if (umlageanteil.betrag) {
					nebkoSum += umlageanteil.betrag
					umlageanteil.save()
				}
				
			}
			
			//Umlageausfallwagnis
			if (mv.mietsache.immobilie.sozialerWohnungsbau) {
				if (!ausW) ausW = new Umlageanteil()
				ausW.kostenart = '2% Umlageausfallwagnis'
				ausW.umlageschluessel = 'gesetzliche Umlage'
				ausW.betrag = nebkoSum * 0.02
				ausW.nebenkostenabrechnung = nebenkostenabrechnung
				ausW.umlage = umlageausfallwagnis
				umlageausfallwagnis.betrag += ausW.betrag
				
				if (!umlageausfallwagnis.save(flush: true)) {
				    umlageausfallwagnis.errors.each {
				        println it
				    }
				}
				if (!ausW.save(flush: true)) {
					ausW.errors.each {
						println it
					}
				}
			}
			
			def OffenerPosten offenerPosten
			mv.mietforderungen.each {OffenerPosten op ->
				if (op.grund.contains("Nebenkostenabrechnung ${jahr.toString()}"))
					offenerPosten = op
			}
			if(!offenerPosten)
				offenerPosten = new OffenerPosten()
			Calendar cal = Calendar.getInstance()
			cal.setTime(datum)
			cal.add(Calendar.DATE,14)
			offenerPosten.faelligkeit = cal.getTime()
			offenerPosten.betrag = mv.getGezahlteNebenkosten(jahr) - nebkoSum
			offenerPosten.grund = "Nebenkostenabrechnung ${jahr.toString()}"
			offenerPosten.mietvertrag = mv
			//offenerPosten.save()
		}
	}
	
	Map getKoartAbschlaege() {
		def Map koart = [:]
		umlagen.each {Umlage u ->
			if (u.zaehler) {
				def int persAb = 0
				def BigDecimal wfAb = 0
				List uList = []
				u.zaehler.zwischenzaehlers.each {Zwischenzaehler zz ->
					Mietsache ms = zz.mietsache
					if (!(ms.id in uList) && zz.stattZaehler) {
						uList << ms.id
						persAb += ms.aktPersonen
						wfAb += ms.wohnflaeche?ms.wohnflaeche:0
					}
				}
				koart."${u.kostenart}"=[wfAb,persAb,0]
			}
		}
		koart
	}
	
	BigDecimal getSummeUmlagen() {
		def BigDecimal summe = 0
		umlagen.each {Umlage u ->
			summe += u.betrag
			}
		summe
	}
	
	BigDecimal getSummeKommunalabgaben() {
		def BigDecimal summe = 0
		umlagen.each {Umlage u ->
			if (isKommunal(u.kostenart)) summe += u.betrag
		}
		summe
	}
	
	boolean isKommunal(String koart) {
		List l = Holders.config.kommunal
		l.contains(koart)
	}
	
	void erzeugeCsv(BufferedWriter sOut) {
		sOut.writeLine("briefDatum;adressAnrede;adressName;strHnr;plzOrt;briefAnrede1;anredeName;briefAnrede2;jahr;erstattung;kto;blz;bankname;kontoinhaber;mitKonto")
		betriebskostenabrechnungen.each {Betriebskostenabrechnung b ->
			sOut.writeLine(b.abrechnungsbrief(jahr))
		}
	}
	
	void erzeugeUmlagen() {
		List <Umlage> uList = []
		List <Umlageinfo> uiList = Umlageinfo.findAll("from Umlageinfo as u where u.art = 'nk' ")
		uiList.each {Umlageinfo it ->
			if (it.immobilie == this.immobilie && (jahr(it.von) == jahr || jahr(it.bis) == jahr)) {
				println it
			}
		}
	}
	
	Date getAnfangAbrJahr () {
		def Calendar cal = Calendar.getInstance()
		cal.set(jahr,Calendar.JANUARY,1)
		cal.getTime()
	}
	Date getEndeAbrJahr () {
		def Calendar cal = Calendar.getInstance()
		cal.set(jahr,Calendar.DECEMBER,31)
		cal.getTime()
	}
	int jahr(Date d){
		def Calendar cal = Calendar.getInstance()
		cal.setTime(d)
		cal.get(cal.YEAR)
	}
	
	
	
}
