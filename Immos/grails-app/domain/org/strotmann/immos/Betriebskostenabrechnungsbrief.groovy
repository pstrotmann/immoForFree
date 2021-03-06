package org.strotmann.immos

import java.text.SimpleDateFormat

class Betriebskostenabrechnungsbrief {

	String briefDatum
	String adressAnrede
	String adressName
	String strHnr
	String plzOrt
	String briefAnrede1
	String anredeName
	String briefAnrede2
	String jahr
	
	BigDecimal nebenkosten
	BigDecimal heizkosten
	BigDecimal umlageausfallwagnis
	String heizVon
	String heizBis
	BigDecimal nebenkostenvorauszahlung
	BigDecimal heizkostenvorauszahlung
	BigDecimal saldo
	BigDecimal mietsaldo
	BigDecimal erstattung
	
	String iban
	String kto
	String blz
	String bankname
	String kontoinhaber
	String mitKonto
	
	Betriebskostenabrechnung betriebskostenabrechnung 
	
	static constraints = {
		 briefDatum()
		 adressAnrede()
		 adressName()
		 strHnr()
		 plzOrt()
		 briefAnrede1()
		 anredeName()
		 briefAnrede2()
		 jahr()
		 nebenkosten()
		 heizkosten()
		 umlageausfallwagnis(nullable:true)
		 heizVon()
		 heizBis()
		 nebenkostenvorauszahlung()
		 heizkostenvorauszahlung()
		 saldo()
		 mietsaldo(nullable:true)
		 erstattung(nullable:true)
		 iban()
		 kto()
		 blz()
		 bankname()
		 kontoinhaber()
		 mitKonto()
    }
	
	Date getZahlungsziel() {
		def Calendar cal = Calendar.getInstance()
		cal.setTime(stringToDate(briefDatum))
		Date d = cal.getTime()
		use (groovy.time.TimeCategory) {
			d = d + 16.days
			cal.setTime(d)
			switch (cal.get(Calendar.DAY_OF_WEEK)) {
				case cal.SATURDAY:
				d = d + 2.days
				break
				case cal.SUNDAY:
				d = d + 1.days
				break
			}
		}
		d
	}
	
	Date getNaechsterErster () {
		def Calendar cal = Calendar.getInstance()
		cal.setTime(stringToDate(briefDatum))
		Date d = cal.getTime()
		use (groovy.time.TimeCategory) {
			if (cal.get(Calendar.DAY_OF_MONTH) < 15)
				d = d + 1.month
			else
				d = d + 2.month
			cal.setTime(d)
			cal.set(Calendar.DAY_OF_MONTH, 1)
			d = cal.getTime()
		}
		d
	}
	
	Double getHkErhoehung () {
		Double erh = 
		((heizkosten + umlAnteil(heizkosten) - heizkostenvorauszahlung) / restMonate)
		erh.round()
	}
	
	Double getNkErhoehung () {
		Double erh =
		((nebenkosten + umlAnteil(nebenkosten) - nebenkostenvorauszahlung) / restMonate)
		erh.round()
	}
	
	private Double umlAnteil (BigDecimal kosten) {
		umlageausfallwagnis * (kosten/(heizkosten + nebenkosten))
	}
	
	private Integer getRestMonate () {
		
		def Calendar nxt_01 = Calendar.getInstance()
		nxt_01.setTime(naechsterErster)
		
		if (nxt_01.get(Calendar.YEAR) > jahr.toInteger()) 
			12 - nxt_01.get(Calendar.MONTH)
		else
			12 
	}
	
	Boolean getBruttomietErhoehung () {
		def Double erhoehung =
		hkErhoehung + nkErhoehung
		return (erhoehung >= 10)
	}
	
	Double getBruttomietErhoehungBetrag () {
		def Double erhoehung =
		hkErhoehung + nkErhoehung
	}
	
	Mietvertragsstand getMietvertragsstand () {
		betriebskostenabrechnung.mietvertrag.vertragsstaende.last()
	}
	
	BigDecimal getGrundmiete() {
		mietvertragsstand.grundmiete
	}
	
	BigDecimal getNebenkostenNeu() {
		mietvertragsstand.nebenkostenpauschale + nkErhoehung
	}
	
	BigDecimal getHeizkostenNeu() {
		mietvertragsstand.heizkostenpauschale + hkErhoehung
	}
	
	BigDecimal getBruttomieteNeu() {
		mietvertragsstand.bruttomiete + hkErhoehung + nkErhoehung
	}
	
	
	String toString() {
		"vom:${briefDatum},an:${adressAnrede} ${adressName},${strHnr},${plzOrt}"
	}
	
	Date stringToDate (String s) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yy")
		formatter.parse(s)
	}
}
