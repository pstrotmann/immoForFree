package org.strotmann.immos

import java.util.SortedSet;

class Partner implements Comparable {
	 
	String name
	
	Hausadresse hausadresse 
	
	SortedSet partnerrolle
	static hasMany = [kommunikation:Kommunikation,
					 partnerrolle:Partnerrolle,
					 bankverbindung:Bankverbindung]
	
	static mapping = {
		tablePerHierarchy false
	}
		
	static constraints = {
		name()
		hausadresse (nullable:true)
	}
	
	String toString() {"${this.name}" }
	
	int compareTo(obj) {
		name.compareTo(obj.name)
	}
	
	Bankverbindung getEinzelverbindung () {
		Bankverbindung bv = null
		this.bankverbindung.each {
			bv = it
		}
		if (!bv)
			if (this instanceof Organisation && this.rechtsform == 'Personengemeinschaft')
				bv = bankverbindungPerson
		bv
	}
	
	Bankverbindung getBankverbindungPerson () {
		Bankverbindung bv = null
		String s = "from Partnerrolle as paro where paro.organisation.id = ${this.id} and paro.rolle ='Ansprechpartner' "
		List <Partnerrolle> aspaRollen = Partnerrolle.findAll (s)
		aspaRollen.each {Partnerrolle it ->
			if(it.partner.einzelverbindung)
				bv = it.partner.einzelverbindung
		}
		bv
	}
	
	List <Partnerrolle> getParoAktive () {
		List <Partnerrolle> aktive = []
		partnerrolle.each {Partnerrolle paro ->
			if (paro.dienstleistungsvertrag) {
				if (!paro.dienstleistungsvertrag.vertragsende)
					aktive << paro
			}
			else 
				aktive << paro
		} 
		aktive
	}
	
	List <Rechnung> getRechnungen () {
		List <Rechnung> rechnungen = []
		partnerrolle.each {Partnerrolle paro ->
			if (paro.rechnung)
				rechnungen << paro.rechnung
		}
		rechnungen
	}
	
	List <Kredit> getKredite () {
		List <Kredit> kredite = []
		partnerrolle.each {Partnerrolle paro ->
			if (paro.kredit)
				kredite << paro.kredit
		}
		kredite
	}
	
	List <Dienstleistungsvertrag> getDienstleistungsvertraege () {
		List <Dienstleistungsvertrag> dienstleistungsvertraege = []
		def Calendar heute = Calendar.getInstance()
		use (groovy.time.TimeCategory) {
			heute.setTime(new Date())}
		partnerrolle.each {Partnerrolle paro ->
			if (paro.dienstleistungsvertrag)
				if (paro.dienstleistungsvertrag.vertragsende == null || heute.getTime() < paro.dienstleistungsvertrag.vertragsende)
					dienstleistungsvertraege << paro.dienstleistungsvertrag
		}
		dienstleistungsvertraege
	}
	
	List <Mietvertrag> getMietvertraege () {
		List <Mietvertrag> mietvertraege = []
		partnerrolle.each {Partnerrolle paro ->
			if (paro.mietvertrag)
				mietvertraege << paro.mietvertrag
		}
		mietvertraege
	}
	
	List <Organisation> getAnsprechpartner () {
		List <Organisation> ansprechpartner = []
		partnerrolle.each {Partnerrolle paro ->
			if (paro.organisation)
				ansprechpartner << paro.organisation
		}
		ansprechpartner
	}
	
	Map <Integer,BigDecimal> getSumZahlg() {
		Map m = [:]
		BigDecimal s = 0
		partnerrolle.each {Partnerrolle p ->
			if(p.dienstleistungsvertrag)	
				p.dienstleistungsvertrag.zahlungen.each{Zahlung z ->
					s += z.betrag
					m[z.buchungsjahr]=m[z.buchungsjahr]?:0
					m[z.buchungsjahr]+=z.betrag
				}
			if(p.kredit)
				p.kredit.zahlungen.each{Zahlung z ->
					s += z.betrag
					m[z.buchungsjahr]=m[z.buchungsjahr]?:0
					m[z.buchungsjahr]+=z.betrag
				}
			if(p.mietvertrag)
				p.mietvertrag.zahlungen.each{Zahlung z ->
					s += z.betrag
					m[z.buchungsjahr]=m[z.buchungsjahr]?:0
					m[z.buchungsjahr]+=z.betrag
				}
			if(p.rechnung)
				p.rechnung.zahlungen.each{Zahlung z ->
					s += z.betrag
					m[z.buchungsjahr]=m[z.buchungsjahr]?:0
					m[z.buchungsjahr]+=z.betrag
				}
		}
		m[0] = s
		m
	}
	
	BigDecimal getSumZahlgGes() {
		sumZahlg[0]
	}
	
	Map <Integer,BigDecimal> getSumZahlgYear() {
		Map m = sumZahlg
		m.remove(0)
		m
	}
	
	static BigDecimal getSumZahlgGesP() {
		BigDecimal s = 0
		Partner.findAll("from Partner").each {Partner p ->
			s += p.sumZahlgGes			
		}
		s
	}
	
	static Map <Integer,BigDecimal> getSumZahlgYearP() {
		Map m = [:]
		Partner.findAll("from Partner").each {Partner p ->
			p.sumZahlgYear.each {it ->
				m[it.key]=m[it.key]?:0
				m[it.key]+=it.value
			}
		}
		m
	}
	
	static List <Partner> getStrotmann () {
		List strotmanns
		String s = "from Partner as p where p.name like 'Strotmann%' "
		strotmanns = Partner.findAll(s)
		strotmanns
	}
	
}
