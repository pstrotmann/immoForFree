package org.strotmann.immos

class OffenerPosten implements Comparable {
	
	Date faelligkeit
	BigDecimal betrag //-Forderung oder +Verbindlichkeit
	String grund

	Mietvertrag mietvertrag
	Rechnung rechnung
	Dienstleistungsvertrag dienstleistungsvertrag
	Kredit kredit
	
    static constraints = {
		faelligkeit(validator: {w, o ->
			int i = 0
			
			if (o.mietvertrag) i++
			if (o.kredit) i++
			if (o.dienstleistungsvertrag) i++
			if (o.rechnung) i++
			
			return i <= 1
		})
		grund()
		betrag()
		mietvertrag(nullable:true)
		dienstleistungsvertrag(nullable:true)
		rechnung(nullable:true)
		kredit(nullable:true)
	}
	
	String getUrsprung () {
		if (this.mietvertrag) return "Miete:"+this.mietvertrag
		if (this.dienstleistungsvertrag) return "Kosten"+this.dienstleistungsvertrag
		if (this.rechnung) return "Reparatur"+this.rechnung
		if (this.kredit) return "Kredit: "+this.kredit.immobilie
	}
	
	int compareTo(obj) {
		if (faelligkeit.compareTo(obj.faelligkeit) < 0)
		return -1
	else
		if (faelligkeit.compareTo(obj.faelligkeit) > 0)
			return 1
		else
			return id.compareTo(obj.id) * (-1)
	}
	
	String toString() {
		def nbsp = "\u2007"
		def btr =betrag.toString().replace('.',',').padLeft(10,nbsp)
		"${this.faelligkeit.getDateString()}$btr$nbsp$grund"
	}
	String toKurzString() {
		def nbsp = "\u2007"
		def btr = betrag.toString().replace('.',',').padLeft(10,nbsp)
		"${this.faelligkeit.getDateString()}$btr"
	}
}
