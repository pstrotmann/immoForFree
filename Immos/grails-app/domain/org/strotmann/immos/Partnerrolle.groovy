package org.strotmann.immos

import java.util.List;
import grails.util.Holders

class Partnerrolle implements Comparable {
	
	String rolle
	//mit der Belegung dieses Strings gibt es noch ein Problem
	//manchmal nicht belegt, nicht nachstellbar
	
	Mietvertrag mietvertrag
	Kredit kredit
	Dienstleistungsvertrag dienstleistungsvertrag
	Rechnung rechnung
	Organisation organisation
	
	static belongsTo = [partner:Partner]
	
	static transients = ['rollen']

    static constraints = {
		partner (validator: {w, o ->
			int i = 0
			
			if (o.mietvertrag) i++
			if (o.kredit) i++
			if (o.dienstleistungsvertrag) i++
			if (o.rechnung) i++
			if (o.organisation) i++
			
			return i <= 1
		})
		rolle(inList:getRollen())
		mietvertrag (nullable:true, unique:['partner'])
		kredit (nullable:true, unique:['partner'])
		dienstleistungsvertrag (nullable:true, unique:['partner'])
		rechnung (nullable:true, unique:['partner'])
		organisation (nullable:true, unique:['partner'])
    }
	
	int compareTo(obj) {
		if (rechnung)
			if(rechnung.rechnungsdatum.compareTo(obj.rechnung.rechnungsdatum) == 0)
				return rechnung.rechnungsnummer.compareTo(obj.rechnung.rechnungsnummer)
			else
				return rechnung.rechnungsdatum.compareTo(obj.rechnung.rechnungsdatum)
		else
			return id.compareTo(obj.id)
	}
	
	String toString() {	
		return 	"${this.rolle}:${this.properties[getRollenwert(this.rolle)]}"
	}
	
	Person getPerson () {
		def p
		try {
			p = Person.get(this.partner.id)
		} catch (Exception e) {	}
		return (p?:null)
	}
	
	static List getRollen () {		
		List rList = []		
		Holders.config.rolle.each {rList << it.key}
		rList		
	}
	 
	String getRollenwert (String r) {
		if (r == "Mietzahler")
			return "mietvertrag"
		if (r == "Ansprechpartner")
			return "organisation"
		
		return Holders.config.rolle[r]	
	}
	 
}
