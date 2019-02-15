package org.strotmann.immos

import java.math.MathContext
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
		"${kreditgeber.partner.name},${vertragsnummer},${verwendung.hausadresse.ort}, Saldo: ${((Double)kreditsaldo).round(2)}"
	}
	
	static List getKreditgeberList () {
		Organisation.findAll("from Organisation as o where not o.rechtsform = 'Personengemeinschaft'").sort()
	}
	
	static List getKredite () {
		Kredit.findAll("from Kredit order by verwendung.hausadresse.ort, verwendung.hausadresse.strasse, verwendung.hausadresse.hausnummer")
	}
	
	static List getAktiveKredite () {
		List l = []
		Kredit.findAll("from Kredit order by verwendung.hausadresse.ort, verwendung.hausadresse.strasse, verwendung.hausadresse.hausnummer").each {Kredit k ->
			if (k.kreditsaldo > 0)
				l << k			
		}
		l
	}
	
	static BigDecimal getSaldoSumme() {
		BigDecimal s = 0
		Kredit.findAll("from Kredit").each {Kredit k ->
			s += k.kreditsaldo
		}
		s
	}
	
	static Map getKrediteUndSummen() {
		Map krSum = ['kredite':[],'summen':[0,0,0,0],'sumProz':[0,0,0,0],'sumRate':[0,0,0,0],'sumZins':[0,0,0,0],'sumTilg':[0,0,0,0]]
		String s = "from Kredit order by verwendung.hausadresse.ort, verwendung.hausadresse.strasse, verwendung.hausadresse.hausnummer"
		Kredit.findAll(s).each {Kredit k ->
			def BigDecimal kSaldo = k.kreditsaldo
			def BigDecimal kAktProz = k.aktProz
			def BigDecimal kMtlRate = k.mtlRate
			def BigDecimal kMtlZins = k.getMtlZins(kSaldo,kAktProz)
			def BigDecimal kMtlTilg = kMtlRate - kMtlZins
			krSum.kredite << [k,kSaldo,kAktProz,kMtlRate,kMtlZins,kMtlTilg]
			krSum.summen[0] += kSaldo
			krSum.sumRate[0] += kMtlRate
			krSum.sumZins[0] += kMtlZins
			krSum.sumTilg[0] += kMtlTilg
			if (k.kreditgeber.partner.name == "Wfa") {
				krSum.summen[1] += kSaldo
				krSum.sumRate[1] += kMtlRate
				krSum.sumZins[1] += kMtlZins
				krSum.sumTilg[1] += kMtlTilg
			}
			if (k.kreditgeber.partner.name == "Sparkasse Dortmund") {
				krSum.summen[2] += kSaldo
				krSum.sumRate[2] += kMtlRate
				krSum.sumZins[2] += kMtlZins
				krSum.sumTilg[2] += kMtlTilg
			}
			if (k.kreditgeber.partner.name == "Wüstenrot Bank") {
				krSum.summen[3] += kSaldo
				krSum.sumRate[3] += kMtlRate
				krSum.sumZins[3] += kMtlZins
				krSum.sumTilg[3] += kMtlTilg
			}
		}
		
		krSum.sumProz[1] = (krSum.summen[1] / krSum.summen[0]) * 100
		krSum.sumProz[2] = (krSum.summen[2] / krSum.summen[0]) * 100
		krSum.sumProz[3] = (krSum.summen[3] / krSum.summen[0]) * 100
		
		krSum
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
	
	BigDecimal getMtlZins(BigDecimal kSaldo, kAktProz) {
		BigDecimal zins = ((kSaldo * aktProz)/100) / 12
		zins
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
				proz = (((z + v) * zahlweise) / ks.kreditsumme) * 100
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
