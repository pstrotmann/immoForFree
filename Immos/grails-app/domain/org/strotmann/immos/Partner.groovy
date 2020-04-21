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
}
