package org.strotmann.immos

import java.util.List;

class Person extends Partner {
	
	String titel = ''
	String vorname = ''
	String geschlecht
	Date geburtsdatum
	boolean persoenlicheAnrede
	
    static constraints = {
		titel(size:3..20,matches:"[a-zA-Z\\. ]+",nullable:true)
		vorname (size:1..30,matches:"[a-zäöüßA-ZÄÖÜ\\- .]+",nullable:true)
		name(blank:false,size:1..30,matches:"[a-zäöüßA-ZÄÖÜ\\- .]+",unique:['vorname','geschlecht','geburtsdatum'])
		geschlecht (inList:["m", "w"])
		geburtsdatum (nullable:true)
		persoenlicheAnrede(nullable:true)
		hausadresse (nullable:true)
    }	
	
	String toString() {"${geschlecht == 'm'?'Herr':'Frau'} ${titel?titel:''} ${vorname?vorname:''} ${this.name} "}
	
	static List getPersonList () {
		Person.findAll("from Person order by name")
	}
	
}
