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
	
	String toString() {
		"vom:${briefDatum},an:${adressAnrede} ${adressName},${strHnr},${plzOrt}"
	}
}
