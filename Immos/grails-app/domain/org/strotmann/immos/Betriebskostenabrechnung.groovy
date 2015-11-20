package org.strotmann.immos

class Betriebskostenabrechnung implements Comparable{
	//als nächstes zu realisieren, nach Prüfung, was bereits läuft
	Mietvertrag mietvertrag
	
	static belongsTo = [immoabrechnung:Immoabrechnung ]
		
    static constraints = {
    }
	
	int compareTo(obj) {
		id.compareTo(obj.id)
	}
	
	String toString() {
		"${mietvertrag?.mietsache?.mietsacheKurz}"
		}
	
	Nebenkostenabrechnung getNebenkostenabrechnung() {
		String s = "from Nebenkostenabrechnung as nAbr where nAbr.betriebskostenabrechnung.id = ${this.id}"
		Nebenkostenabrechnung.find(s)
	}
	
	Heizkostenabrechnung getHeizkostenabrechnung() {
		String s = "from Heizkostenabrechnung as hAbr where hAbr.betriebskostenabrechnung.id = ${this.id}"
		Heizkostenabrechnung.find(s)
	}
	
	Betriebskostenabrechnungsbrief getBetriebskostenabrechnungsbrief() {
		String s = "from Betriebskostenabrechnungsbrief as brAbr where brAbr.betriebskostenabrechnung.id = ${this.id}"
		Betriebskostenabrechnungsbrief.find(s)
	}
	
	BigDecimal getNebenkosten() {
		nebenkostenabrechnung?.betrag?:0
	}
	
	BigDecimal getHeizkosten() {
		heizkostenabrechnung?.betrag?:0
	}
	
	BigDecimal getUmlageausfallwagnis() {
		if (immoabrechnung.immobilie.sozialerWohnungsbau)
			(nebenkosten + heizkosten) * 0.02
		else
			0
	}
	
	BigDecimal getBetriebskosten() {
		nebenkosten + heizkosten+ umlageausfallwagnis
	}
	
	String abrechnungsbrief () {
		int jahr = immoabrechnung.jahr
		def Betriebskostenabrechnungsbrief brief = betriebskostenabrechnungsbrief?:new Betriebskostenabrechnungsbrief()
		brief.betriebskostenabrechnung = this
		def Partner p = mietvertrag.mieter.partner
		def String pString = p
		def List pList = pString.split(' ',2)
		def String adressAnrede
		def String adressName
		def String strHnr
		def String plzOrt
		def String briefAnrede1
		def String anredeName
		def String briefAnrede2
		
		if (pList[0] in ['Herr', 'Frau']) {
			adressAnrede = pString.split(' ')[0]
			adressName = pList[1]
			
			briefAnrede1 = (pList[0] == 'Herr'?"Sehr geehrter Herr":"Sehr geehrte Frau" )
			briefAnrede2 = "Ihnen"
			anredeName = p.name
		}
		else {
			adressAnrede = "Familie"
			briefAnrede1 = "Sehr geehrte Familie"
			briefAnrede2 = "Ihnen"
			adressName = p.name
			anredeName = p.name
		}
		
		def Hausadresse hausadresse = p.hausadresse
		strHnr = hausadresse.strasse+' '+hausadresse.hausnummer
		plzOrt = hausadresse.postleitzahl+' '+hausadresse.ort
		def String adresse = "${adressAnrede};${adressName};${strHnr};${plzOrt}"
		def String anrede = "${briefAnrede1};${anredeName};${briefAnrede2}"
		def String bankdaten
		def Bankverbindung bank
		if (p.einzelverbindung)
			if (!mietvertrag.zahlerList.empty) {
				def Partner mietzahler = mietvertrag.zahlerList[0]
				bank = null
			}
			else
				bank = p.einzelverbindung
		else
			bank = null
		if (bank)
			bankdaten = "${bank.ktoNr};${bank.blz};${bank.nameUndAdresse};${p};ja"
		else
			bankdaten = ";;;;nein"
			
		brief.briefDatum = new Date().getDateString()
		brief.adressAnrede = adressAnrede
		brief.adressName = adressName
		brief.strHnr = strHnr
		brief.plzOrt = plzOrt
		brief.briefAnrede1 = briefAnrede1
		brief.anredeName = anredeName
		brief.briefAnrede2 = briefAnrede2
		brief.jahr = jahr 
		
		Nebenkostenabrechnung n = nebenkostenabrechnung
		
		def BigDecimal nebSaldo = n?n.saldo:0
		brief.nebenkosten = n.betrag
		brief.nebenkostenvorauszahlung = n.gezahlteNebenkosten
		
		if (heizkostenabrechnung) {
			Heizkostenabrechnung h = heizkostenabrechnung
			brief.heizkosten = h.betrag
			brief.heizVon = h.von.getDateString()
			brief.heizBis = h.bis.getDateString()
			brief.heizkostenvorauszahlung = h.gezahlteHeizkosten
		}
		else {
			brief.heizkosten = 0
			brief.heizVon = ""
			brief.heizBis = ""
			brief.heizkostenvorauszahlung = 0
		}
		brief.umlageausfallwagnis = this.umlageausfallwagnis
		brief.saldo = - brief.nebenkosten + brief.nebenkostenvorauszahlung - brief.heizkosten + brief.heizkostenvorauszahlung - brief.umlageausfallwagnis
		
		if (bank) {
			brief.iban = bank.iban
			brief.kto = bank.ktoNr
			brief.blz = bank.blz
			brief.bankname = bank.nameUndAdresse
			brief.kontoinhaber = p
			brief.mitKonto = 'ja'
		}
		else {
			brief.iban = ''
			brief.kto = ''
			brief.blz = ''
			brief.bankname = ''
			brief.kontoinhaber = ''
			brief.mitKonto = 'nein'
		}
		
		if (!brief.save(flush: true)) {
			brief.errors.each {
				println it
			}
		}
			
		"${new Date().getDateString()};${adresse};${anrede};${jahr};${nebSaldo.toString().replace('.',',')};${bankdaten}"
	}
}
