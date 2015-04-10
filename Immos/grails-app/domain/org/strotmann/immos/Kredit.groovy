package org.strotmann.immos

import java.util.List;
import java.util.SortedSet;
import grails.util.Holders

class Kredit implements Comparable{
	
	Partnerrolle kreditgeber
	Immobilie verwendung
	Grundschuld grundschuld
	String vertragsnummer
	int zahlweise
	
	SortedSet zahlungen, kreditstaende
	static hasMany = [zahlungen:Zahlung, kreditstaende:Kreditstand]

    static constraints = {
		
		kreditgeber(unique:['vertragsnummer'])
		verwendung()
		vertragsnummer()
		zahlweise(inList:Zahlung.zahlweiseNum)
		grundschuld(nullable:true)
    }
	
	int compareTo(obj) {
		vertragsnummer.compareTo(obj.vertragsnummer) 
	}
	
	String toString() {
		"${kreditgeber.partner.name},${vertragsnummer},${verwendung.hausadresse.ort}"
	}
	
	static List getKreditgeberList () {
		Organisation.findAll("from Organisation as o where not o.rechtsform = 'Personengemeinschaft'").sort()
	}
	
	static List getKredite () {
		Kredit.findAll("from Kredit order by verwendung.hausadresse.ort, verwendung.hausadresse.strasse, verwendung.hausadresse.hausnummer")
	}
	
	static BigDecimal getKreditsumme() {
		BigDecimal summe = 0
		Kredit.findAll("from Kredit").each {
			Kredit k -> summe += k.kreditsaldo
		}
		summe
	}
	
	
	String getZahlweiseKlar() {
		Holders.config.zahlweise[zahlweise]
	}
	
	BigDecimal getKreditsaldo() {
		def BigDecimal saldo = 0
		def List <Kreditstand> ksList = Kreditstand.findAll("from Kreditstand as ks where ks.kredit = ${id} and current_date between ks.laufzeitAb and ks.laufzeitBis")
		ksList.each {ks ->
			 saldo += ks.kreditsumme
			 saldo += ((ks.kreditsumme * (ks.zinssatz ?: 0)) / 100) * ((new Date().minus(ks.laufzeitAb)/360))
			 saldo += (ks.zinsbetrag?:0) + (ks.verwKostenbetrag?:0)
		 }
		
		if (!ksList.empty && this.zahlweise == 12 ) {
			Kreditstand ks = ksList[0]
			def List <Zahlung> zList = Zahlung.findAll("from Zahlung as z where z.kredit = ${id} ")
			zList.each {Zahlung z ->
				 if (!(z.datum < ks.laufzeitAb))
				 	saldo += z.betrag}
		}
		
		saldo
	}
}
