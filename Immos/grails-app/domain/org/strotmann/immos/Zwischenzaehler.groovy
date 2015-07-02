package org.strotmann.immos

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
	
	String toString () {
		"${zaehlernummer?zaehlernummer+',':''} ${zaehler?.zaehlertyp}"
	}
}
