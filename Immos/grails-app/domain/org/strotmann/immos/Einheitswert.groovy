package org.strotmann.immos

class Einheitswert {

    String ewNummer
	Date gueltigAb
	BigDecimal wert
	
	static belongsTo = [immobilie:Immobilie]
	
	static constraints = {
		ewNummer(unique:['gueltigAb'])
		gueltigAb()
		wert()
	}
	
	static transients = ['stand','wertAufbereitet','wertDM', 'wertAufbereitetDM']
	
	String toString() {"${this.ewNummer} ab: ${this.gueltigAb.toLocaleString().split(" ")[0]} € ${this.wert}"}
	
	def getWertDM () {
		this.wert * 1.95583
	}
	
	String getStand () {
			return this.gueltigAb.getDateString()
	}
	
	String getWertAufbereitet () {		
		 java.text.DecimalFormat df = new java.text.DecimalFormat("###,##0.00");
		 df.format(wert)		
	}
	
	String getWertAufbereitetDM () {		
		 java.text.DecimalFormat df = new java.text.DecimalFormat("###,##0");
		 df.format(wertDM)		
	}
	
}
