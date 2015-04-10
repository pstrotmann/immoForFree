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
	String erstattung
	String kto
	String blz
	String bankname
	String kontoinhaber
	String mitKonto
	
	static belongsTo = [betriebskostenabrechnung:Betriebskostenabrechnung ]
	
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
		 erstattung()
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
