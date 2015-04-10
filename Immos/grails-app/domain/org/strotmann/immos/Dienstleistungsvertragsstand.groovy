package org.strotmann.immos

import java.util.Date;

class Dienstleistungsvertragsstand implements Comparable {
	
	Date gueltigAb
	BigDecimal pauschale = 0

	static belongsTo = [dienstleistungsvertrag:Dienstleistungsvertrag]
	
	static constraints = {
		gueltigAb()
		pauschale()
    }
	
	int compareTo(obj) {
		return (gueltigAb.compareTo(obj.gueltigAb) * -1)
	}
	
	String toString() {
		return "${this.gueltigAb.getDateString()},${this.pauschale}"
	}
	
	String getPauschaleAufbereitet () {
		java.text.DecimalFormat df = new java.text.DecimalFormat("###,##0.00");
		df.format(pauschale)
   }
   
   String getVstandKurz () {
	   this.gueltigAb.getDateString()+" Pauschale: "+this.pauschaleAufbereitet
   }
}
