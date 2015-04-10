package org.strotmann.immos

class Hausadresse extends Adresse implements Comparable {
	
	String strasse
	int hausnummer
	String zusatz = ''

    static constraints = {
		strasse (blank:false,size:3..50,matches:"[a-zäöüßA-ZÄÖÜ\\- .0-9]+")
		hausnummer (min:1, max:1000)
		zusatz (size:1..10,nullable:true)
		postleitzahl (min:1000, max:99999,unique:['strasse','hausnummer','zusatz'])
		ort (blank:false,size:3..50,matches:"[a-zäöüßA-ZÄÖÜ\\- .,()/]+")
    }
	
	String toString() {"${this.strasse}  ${this.hausnummer} ${this.zusatz?zusatz:''}, ${this.postleitzahl}  ${this.ort}" }
	
	int compareTo(obj) {
		postleitzahl+strasse.compareTo(obj.postleitzahl+obj.strasse)		
	}
	
	static List getMiniList () {
		return(Hausadresse.findAll("from Hausadresse as h order by h.postleitzahl, h.strasse"))
	}
}
