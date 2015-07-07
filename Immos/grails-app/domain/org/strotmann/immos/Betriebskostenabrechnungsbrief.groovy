package org.strotmann.immos

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
	String heizVon
	String heizBis
	BigDecimal nebenkostenvorauszahlung
	BigDecimal heizkostenvorauszahlung
	BigDecimal saldo
	
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
		 heizVon()
		 heizBis()
		 nebenkostenvorauszahlung()
		 heizkostenvorauszahlung()
		 saldo()
		 iban()
		 kto()
		 blz()
		 bankname()
		 kontoinhaber()
		 mitKonto()
    }
	
	Date getZahlungsziel() {
		def Calendar cal = Calendar.getInstance()
		cal.setTime(new Date())
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
	
	String toString() {
		"vom:${briefDatum},an:${adressAnrede} ${adressName},${strHnr},${plzOrt}"
	}
}
