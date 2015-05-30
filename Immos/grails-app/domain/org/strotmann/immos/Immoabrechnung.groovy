package org.strotmann.immos

import java.io.BufferedWriter;
import java.util.Date;

import grails.util.Holders
import groovy.time.Duration

class Immoabrechnung implements Comparable {
	
	int jahr   //der Abrechnung
	Date datum //der Abrechnung

    static belongsTo = [immobilie:Immobilie]
	
	SortedSet umlagen, betriebskostenabrechnungen
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
		def BigDecimal anzP = 0
		def BigDecimal anzHH = immobilie.anzahlHaushalte
		def int anzRauchWhgn = 0
		def int anzWzWhgn = 0
		def Map koartMap = koartAbschlaege
		
		def List <Mietvertrag> mvList = Mietvertrag.findAll("from Mietvertrag as mv where mv.mietsache.immobilie = ${immobilie.id}")
		mvList.each {mv ->
			if (groesser(mv.mietbeginn, endeAbrJahr) || (mv.mietende && kleiner (mv.mietende, anfangAbrJahr))) {return} 
			anzP += mv.anzahlPersonen
			anzRauchWhgn += mv.mietsache.anzRauchmelder?:0
			anzWzWhgn += mv.mietsache.anzWasserzaehler?:0
		}
		mvList.each {mv ->
			if (mv.anzahlPersonen == 0) {return}
			if (groesser(mv.mietbeginn, endeAbrJahr) || (mv.mietende && kleiner (mv.mietende, anfangAbrJahr))) {return}
			def Nebenkostenabrechnung nebenkostenabrechnung 
			def Betriebskostenabrechnung betriebskostenabrechnung
			mv.betriebskostenabrechnungen.each {Betriebskostenabrechnung it ->
				if (it.immoabrechnung.id == id) {
					betriebskostenabrechnung = it
					if (it.nebenkostenabrechnung)
						nebenkostenabrechnung = it.nebenkostenabrechnung
				}
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
				if (u.umlageschluessel.equals("Zaehler"))
					umlageanteil.betrag = u.betrag  * (mv.mietsache.wasserverbrauch(jahr) / (u.zzVerbrauch))
				if (u.umlageschluessel.equals("qm")) 
					umlageanteil.betrag = (u.betrag - btrKorr) * (mv.mietsache.wohnflaeche / (wF - wfKorr))
				if (u.umlageschluessel.equals("Personen"))
					umlageanteil.betrag = (u.betrag - btrKorr) * (mv.anzahlPersonen / (anzP - persKorr))
				if (u.umlageschluessel.equals("Haushalt"))
					umlageanteil.betrag = u.betrag / anzHH
				if (u.umlageschluessel.equals("stck")) {
					if (u.kostenart == 'Rauchmelder Wohnung')
						umlageanteil.betrag = u.betrag * ((mv.mietsache.anzRauchmelder?:0) / anzRauchWhgn) 
					if (u.kostenart == 'Mietwasseruhr')
						umlageanteil.betrag = u.betrag * ((mv.mietsache.anzWasserzaehler?:0) / anzWzWhgn)
				}
				if (umlageanteil.betrag) {
					nebkoSum += umlageanteil.betrag
					umlageanteil.save()
				}
				
			}
			/*
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
			*/
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
		String s = "from Umlage as u where u.immoabrechnung.id = ${id}"
		Umlage.deleteAll(Umlage.findAll(s))
		List <Umlage> uList = []
		List <Umlageinfo> uiList = Umlageinfo.findAll("from Umlageinfo as u where u.art = 'nk' ")
		uiList.each {Umlageinfo it ->
			if (it.immobilie.id == this.immobilie.id && (jahr(it.von) == jahr || jahr(it.bis) == jahr)) {
				Umlage u = uList.find {item -> item.kostenart == it.kostenart }
				if (u)
					u.betrag += betragTage(it)
				else
				 {
					u = new Umlage()
					uList << u
					u.immoabrechnung = this
					u.art = 1
					u.kostenart = it.kostenart
					u.umlageschluessel = it.umlageschluessel
					u.betrag = betragTage(it)
					u.zaehler = findeZaehler (it.kostenart)
				}
			}
		}
		uList.sort {a,b ->
			!a.kommunal <=> !b.kommunal ?: a.kostenart <=> b.kostenart 
		}.each {Umlage it ->
			it.save flush:true
		}
	}
	
	Zaehler findeZaehler(String kostenart) {
		Zaehler z = null
		this.immobilie.zaehlers.each {
			if (it.zaehlertyp == 'Wasser' && (kostenart == 'Entwässerung' || kostenart == 'Wasser'))
				z = it
			if (it.zaehlertyp == 'Strom' && (kostenart == 'Strom allgemein'))
				z = it
			if (it.zaehlertyp == 'Gas' && (kostenart == 'Gas'))
				z = it
		}
		z
	}
	
	Date getAnfangAbrJahr () {
		def Calendar cal = Calendar.getInstance()
		cal.set(jahr,Calendar.JANUARY,1,0,0,0)
		cal.getTime()
	}
	Date getEndeAbrJahr () {
		def Calendar cal = Calendar.getInstance()
		cal.set(jahr,Calendar.DECEMBER,31,0,0,0)
		cal.getTime()
	}
	int jahr(Date d){
		def Calendar cal = Calendar.getInstance()
		cal.setTime(d)
		cal.get(cal.YEAR)
	}
	
	int diffDatum (Date d1, Date d2) {
		use (groovy.time.TimeCategory) {
			def d = d1 - d2
			d.days
		}
	}
	
	boolean gleich (Date d1, Date d2) {
		use (groovy.time.TimeCategory) {
			def d = d1 - d2
			d.days == 0
		}
	}
	boolean groesser (Date d1, Date d2) {
		use (groovy.time.TimeCategory) {
			def d = d1 - d2
			d.days > 0
		}
	}
	boolean kleiner (Date d1, Date d2) {
		use (groovy.time.TimeCategory) {
			def d = d1 - d2
			d.days < 0
		}
	}
	
	BigDecimal betragTage (Umlageinfo ui) {
		if (gleich(ui.von,anfangAbrJahr) && gleich(ui.bis,endeAbrJahr))
			return ui.abrBetrag
		else {
			int tageJ
			if (jahr(ui.von) == jahr(endeAbrJahr)) 
				tageJ = diffDatum (endeAbrJahr, ui.von)
			if (jahr(ui.bis) == jahr(anfangAbrJahr)) 
				tageJ = diffDatum (ui.bis,anfangAbrJahr)
			
			int tageEx = diffDatum (ui.bis, ui.von) - tageJ
			return ui.abrBetrag - (ui.abrBetrag * tageEx) / 365 
		}
			
	}
}
