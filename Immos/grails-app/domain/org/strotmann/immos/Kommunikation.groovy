package org.strotmann.immos

import java.util.List;
import grails.util.Holders

class Kommunikation {
	
	String art
	String anwahl
	String zusatz
	
	static belongsTo = [partner:Partner]
			
	static constraints = {
		art(inList:kommunikationsart)
		anwahl(maxLength:40, blank:false,
				validator: {wert, objekt ->
					switch (objekt.art) {
					case ["Festnetz","Fax"]:
						return wert ==~ /[0]\d{2,6}[-]\d{2,10}[-]{0,1}\d{1,5}/
					case "Handy":
						return wert ==~ /[0]\d{3,6}[-]\d{3,10}/
					case "eMail":
						return wert ==~ /[A-Za-zäöüß0-9\-\.]+[@][A-Za-zäöüß0-9\-\.]+[.][A-Za-z]{1,4}/
					case "Homepage":
						return wert ==~ /[w]{3,3}[.][A-Za-z0-9\-\.]+/
					default: return false
					}
				})
		zusatz(nullable:true)
	}
	
	String toString() {"${this.art}: ${this.anwahl} ${if (this.zusatz) this.zusatz else ''}" }
	
	Person getPerson () {
		def p
		try {
			p = Person.get(this.partner.id)
		} catch (Exception e) {
		}
		return (p?:null)
	}
	
	static List getKommunikationsart () {
		Holders.config.kommunikationsart
	}
}
