package org.strotmann.immos

class Matchcode {
	
	String name
	String vorname
	String strasse
	int postleitzahl
	String ort	
	
	String partnerart
	
	static transients = ['partnerart']	
		
	static constraints = {
		name()
		vorname()
		strasse()
		postleitzahl()
		ort()
	}
	
	static List getMatches(Map params) {
		
		params.name = params.name+'%'
		params.vorname = params.vorname+'%'
		params.strasse = params.strasse+'%'
		params.ort = params.ort+'%'
		
		def plzLo = 0
		def plzHi = 0
		def String plz = params.postleitzahl
		def int p = new Integer(plz)
		if (p==0)
			plz = ""
		plzLo = p * 10 ** (5 - plz.length())
		plzHi = (p + 1) * 10 ** (5 - plz.length())
		
		def query = Person.where
			 {name =~ "${params['name']}" &&
			 vorname =~ "${params['vorname']}" &&
			 hausadresse != null &&
			 name =~ "${params['name']}" &&
			 vorname =~ "${params['vorname']}" &&
			 hausadresse.strasse =~ "${params['strasse']}" &&
			 (hausadresse.postleitzahl >= plzLo && hausadresse.postleitzahl < plzHi) &&
			 hausadresse.ort =~ "${params['ort']}"
			 }
			 
		List <Person> pList = query.findAll()
		
		query = Person.where
			{name =~ "${params['name']}" &&
				vorname =~ "${params['vorname']}" &&
				hausadresse == null}
			
		List <Person> pList0 = []
		
		if (params.strasse.equals("%") && params.ort.equals("%") && params.postleitzahl.equals('0'))
		pList0 = query.findAll();
		query = Organisation.where
		{name =~ "${params['name']}"  &&
		hausadresse.strasse =~ "${params['strasse']}" &&
		(hausadresse.postleitzahl >= plzLo && hausadresse.postleitzahl < plzHi) &&
		hausadresse.ort =~ "${params['ort']}"}
		List <Organisation> oList = query.findAll()
		
		List <Matchcode> mcList = []
		
		pList.each {item ->
			 Matchcode mc = new Matchcode()
			 mc.id = item.id
			 mc.partnerart = 'p'
			 mc.name = item.name
			 mc.vorname = item.vorname
			 mc.strasse = item.hausadresse.strasse+" "+item.hausadresse.hausnummer
			 mc.postleitzahl = item.hausadresse.postleitzahl
			 mc.ort = item.hausadresse.ort
			 mcList << mc
			 }
		
		pList0.each {item ->
			Matchcode mc = new Matchcode()
			mc.id = item.id
			mc.partnerart = 'p'
			mc.name = item.name
			mc.vorname = item.vorname
			mc.strasse = ''
			mc.postleitzahl = 0
			mc.ort = ''
			mcList << mc
			}
		
		if (params.vorname.length() == 1) {
		oList.each {item ->
			Matchcode mc = new Matchcode()
			mc.id = item.id
			mc.partnerart = 'o'
			mc.name = item.name+' '+(item.nameZusatz?:'')
			mc.vorname = item.rechtsform
			mc.strasse = item.hausadresse.strasse+" "+item.hausadresse.hausnummer
			mc.postleitzahl = item.hausadresse.postleitzahl
			mc.ort = item.hausadresse.ort
			mcList << mc
			}
		}		
		return mcList.sort{it.name}		
	}	
}
