package org.strotmann.immos

import java.util.Date;
import java.util.List;
import java.util.SortedSet;

class Zwischenzaehler implements Comparable{

    String zaehlernummer
	boolean stattZaehler
	
	Mietsache mietsache
	
	static belongsTo = [zaehler:Zaehler]
	
	SortedSet zwischenzaehlerstaende
	static hasMany = [zwischenzaehlerstaende:Zwischenzaehlerstand]
	
	static constraints = {
		zaehlernummer(nullable:true)
		stattZaehler(nullable:true)
	}
	
	int compareTo(obj) {
		zaehlernummer.compareTo(obj.zaehlernummer) 
	}
	
	BigDecimal[] getStandNeuAlt() {
		BigDecimal [] stand = [0,0]
		def i = 0
		zwischenzaehlerstaende.each {Zwischenzaehlerstand zStand ->
			if (i == 0) stand [0] = zStand.wert
			if (i == 1) stand [1] = zStand.wert
			i++
		}
		stand
	}
	
	String toString () {
		"${zaehlernummer?zaehlernummer+',':''} ${zaehler?.zaehlertyp}"
	}
}
