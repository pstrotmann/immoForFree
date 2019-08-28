package org.strotmann.immos

import java.util.List;

class Mietvertragsstand implements Comparable{
	
	Date gueltigAb
	BigDecimal grundmiete = 0
	BigDecimal qmMiete = 0
	BigDecimal nebenkostenpauschale = 0
	BigDecimal heizkostenpauschale = 0
	BigDecimal zusatzmiete = 0 //Garage, Stellplatz, etc.
	int anzahlPersonen
	
	static belongsTo = [mietvertrag:Mietvertrag]
	
	static constraints = {
		
		mietvertrag()
		gueltigAb(unique:['mietvertrag'])
		grundmiete()
		qmMiete()
		nebenkostenpauschale()
		heizkostenpauschale()
		zusatzmiete()
		anzahlPersonen(max:6)
	}
	
	int compareTo(obj) {    	
    	return (gueltigAb.compareTo(obj.gueltigAb))
	}
	
	static transients = ['stand','bruttomiete','bruttoAufbereitet','vstandKurz']
	
	String getStand () {
		return this.gueltigAb.getDateString()
	}
	
	BigDecimal getBruttomiete () {
		
		BigDecimal brutto = 0
		
		brutto =
		this.grundmiete +
		this.nebenkostenpauschale +
		this.heizkostenpauschale +
		this.zusatzmiete 
		
		return brutto
		
	}
	
	String getBruttoAufbereitet () {		
		 java.text.DecimalFormat df = new java.text.DecimalFormat("###,##0.00");
		 df.format(bruttomiete)		
	}
	
	Date getGueltigBis () {
		Date gueBis
		
		if (this.nachfolger)
			use (groovy.time.TimeCategory) {
				gueBis = nachfolger.gueltigAb - 1.day
			}
		else
			use (groovy.time.TimeCategory) {
				if (this.mietvertrag.mietende)
					gueBis = this.mietvertrag.mietende
				else
					gueBis = new Date() + 1000.years
			}
		
		gueBis
	}
	
	Mietvertragsstand getNachfolger() {
		Mietvertragsstand nf
		int i = 0
		
		this.mietvertrag.vertragsstaende.tailSet(this).each {Mietvertragsstand mvs ->
			i++
			if (i == 2)
				nf = mvs
		}
		
		nf
	}
	
	String getVstandKurz () {
		this.stand+" Bruttomiete: "+this.bruttoAufbereitet
	}
	
	String toString() {"${this.mietvertrag},Stand ${this.vstandKurz}"}
	
	static List getStaende () {
		Mietvertragsstand.findAll("from Mietvertragsstand order by mietvertrag.mietsache.immobilie.id, mietvertrag.id, id ")
	}
}
