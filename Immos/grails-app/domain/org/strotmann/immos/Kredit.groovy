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
	
	static Map kreditsummen(String kreditgeber) {
		Map summen = ['gesSaldo':[0,0,0,0],'mtlRate':[0,0,0,0],'mtlZins':[0,0,0,0],'mtlTilg':[0,0,0,0]]
		Kredit.findAll("from Kredit").each {Kredit k ->
			if (kreditgeber == "") {
			 	summen.gesSaldo[0] += k.kreditsaldo
				summen.mtlRate[0] += k.mtlRate
				summen.mtlZins[0] += k.mtlZins
				summen.mtlTilg[0] += k.mtlTilg
			}
			if (k.kreditgeber.partner.name == "Wfa") {
				summen.gesSaldo[1] += k.kreditsaldo
				summen.mtlRate[1] += k.mtlRate
				summen.mtlZins[1] += k.mtlZins
				summen.mtlTilg[1] += k.mtlTilg
		    }
			if (k.kreditgeber.partner.name == "Sparkasse Dortmund") {
				summen.gesSaldo[2] += k.kreditsaldo
				summen.mtlRate[2] += k.mtlRate
				summen.mtlZins[2] += k.mtlZins
				summen.mtlTilg[2] += k.mtlTilg
		   }
			if (k.kreditgeber.partner.name == "Wüstenrot Bank") {
				summen.gesSaldo[3] += k.kreditsaldo
				summen.mtlRate[3] += k.mtlRate
				summen.mtlZins[3] += k.mtlZins
				summen.mtlTilg[3] += k.mtlTilg
		   }
		}
		summen
	}
	
	Kreditstand getAktKreditstand() {
		def List <Kreditstand> ksList = Kreditstand.findAll("from Kreditstand as ks where ks.kredit = ${id} and current_date between ks.laufzeitAb and ks.laufzeitBis")
		ksList.empty?null:ksList[0]
	}
	
	String getZahlweiseKlar() {
		Holders.config.zahlweise[zahlweise]
	}
	
	BigDecimal getKreditsaldo() {
		def BigDecimal saldo = 0
		def List <Kreditstand> ksList = Kreditstand.findAll("from Kreditstand as ks where ks.kredit = ${id} and current_date between ks.laufzeitAb and ks.laufzeitBis")
		ksList.each {ks ->
			 saldo += ks.kreditsumme
			 saldo += ((ks.kreditsumme * (ks.zinssatz ?: 0)) / 100) * ((new Date().minus(ks.laufzeitAb)/365))
			 saldo += (ks.zinsbetrag?:0) + (ks.verwKostenbetrag?:0)
		 }
		
		if (!ksList.empty && (this.zahlweise == 12 || this.zahlweise == 4 )) {
			Kreditstand ks = ksList[0]
			def List <Zahlung> zList = Zahlung.findAll("from Zahlung as z where z.kredit = ${id} ")
			zList.each {Zahlung z ->
				 if (!(z.datum < ks.laufzeitAb))
				 	saldo += z.betrag}
		}
		
		saldo
	}
	
	BigDecimal getMtlRate() {
		def BigDecimal rate = 0
		def List <Kreditstand> ksList = Kreditstand.findAll("from Kreditstand as ks where ks.kredit = ${id} and current_date between ks.laufzeitAb and ks.laufzeitBis")
		
		ksList.each {ks ->
			
			if (this.zahlweise == 12)
			 	rate += ks.annuitaet
			else
				rate += ks.annuitaet / 6
		}
						
		rate
	}
	
	BigDecimal getMtlZins() {
		BigDecimal zins = ((kreditsaldo * aktProz)/100) / 12 
		zins
	}
	
	BigDecimal getMtlTilg() {
		BigDecimal tilg = mtlRate - mtlZins
		tilg
	}
	
	BigDecimal getAktProz() {
		def BigDecimal proz = 0
		def List <Kreditstand> ksList = Kreditstand.findAll("from Kreditstand as ks where ks.kredit = ${id} and current_date between ks.laufzeitAb and ks.laufzeitBis")
		Kreditstand ks = ksList?ksList.first():null
		if (ks)
			if(ks.zinssatz)
				proz = ks.zinssatz
			else {
				BigDecimal z = ks.zinsbetrag?:0 
				BigDecimal v = ks.verwKostenbetrag?:0
				proz = ((z + v) / ks.bewilligt) * 100
			}
		proz
	}
	
	Date getFestBis() {
		def Date bis = null
		def List <Kreditstand> ksList = Kreditstand.findAll("from Kreditstand as ks where ks.kredit = ${id} and current_date between ks.laufzeitAb and ks.laufzeitBis")
		Kreditstand ks = ksList.first()
		if (ks)
			if(ks.laufzeitBis && ks.zinssatz)
				bis = ks.laufzeitBis
			
		bis
	}
}
