package org.strotmann.immos

class Betriebskostenabrechnung implements Comparable{
	
	Mietvertrag mietvertrag
	
	static belongsTo = [immoabrechnung:Immoabrechnung ]
	
	static hasMany = [nebenkostenabrechnungen:Nebenkostenabrechnung, heizkostenabrechnungen:Heizkostenabrechnung,
		betriebskostenabrechnungsbriefe : Betriebskostenabrechnungsbrief ]
		
    static constraints = {
    }
	
	int compareTo(obj) {
		id.compareTo(obj.id)
	}
	
	String toString() {
		"${mietvertrag?.mietsache?.mietsacheKurz}"
		}
	
	String abrechnungsbrief (int jahr) {
		def Betriebskostenabrechnungsbrief brief = new Betriebskostenabrechnungsbrief()
		brief.betriebskostenabrechnung = this
		def Partner p = mietvertrag.mieter.partner
		def String adressAnrede
		def String adressName
		def String strHnr
		def String plzOrt
		def String briefAnrede1
		def String anredeName
		def String briefAnrede2
		def BigDecimal nebSaldo = nebenkostenabrechnungen.empty?0:nebenkostenabrechnungen[0].saldo
		
		if (p instanceof Person) {
			def Person pers = p
			adressAnrede = (pers.geschlecht == 'm'?"Herr":"Frau" )
			adressName = pers.vorname+' '+pers.name
			if (pers.persoenlicheAnrede) {
				briefAnrede1 = "Hallo"
				briefAnrede2 = "Dir"
				anredeName = pers.vorname
			}
			else {
				briefAnrede1 = (pers.geschlecht == 'm'?"Sehr geehrter Herr":"Sehr geehrte Frau" )
				briefAnrede2 = "Ihnen"
				anredeName = pers.name
			}
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
		if (p.bankverbindung.empty)
			if (!mietvertrag.zahlerList.empty) {
				def Partner mietzahler = mietvertrag.zahlerList[0]
				bank = null
			}
			else
				bank = null
		else
			bank = p.bankverbindung.first()
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
			brief.erstattung = nebSaldo.toString().replace('.',',')
			if (bank) {
				brief.kto = bank.ktoNr
				brief.blz = bank.blz
				brief.bankname = bank.nameUndAdresse
				brief.kontoinhaber = p
				brief.mitKonto = 'ja'
			}
			else {
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
