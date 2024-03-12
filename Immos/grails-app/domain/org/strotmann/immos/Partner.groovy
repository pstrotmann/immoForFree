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
	
	static List <Partner> getStrotmann () {
		List strotmanns
//		String s = "from Person as p where p.name = 'Strotmann' "
//		strotmanns = Person.findAll(s)
//		s = "from Organisation as p where p.name like 'Strotmann%' "
//		strotmanns = strotmanns + Organisation.findAll(s)
		String s = "from Partner as p where p.name like 'Strotmann%' "
		strotmanns = Partner.findAll(s)
		strotmanns
	}
	
}
