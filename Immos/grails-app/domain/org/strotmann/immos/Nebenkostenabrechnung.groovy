package org.strotmann.immos
import org.apache.commons.lang.*

import java.text.DecimalFormat
import java.util.SortedSet;

class Nebenkostenabrechnung implements Comparable {
	
	static belongsTo = [betriebskostenabrechnung:Betriebskostenabrechnung]

	SortedSet umlageanteile
	static hasMany = [umlageanteile:Umlageanteil]
   
	
	static constraints = {
		
    }
	
	int compareTo(obj) {
		betriebskostenabrechnung.mietvertrag.mietsache.lage.compareTo(obj.betriebskostenabrechnung.mietvertrag.mietsache.lage)
	}
	
	String toString() {
		"${betriebskostenabrechnung.mietvertrag} für:${betriebskostenabrechnung.immoabrechnung.jahr}"
	}
	
	BigDecimal getSummeUmlageanteile() {
		def BigDecimal summe = 0
		umlageanteile.each {Umlageanteil ua ->
			summe += ua.betrag
		}
		summe
	}
	
	BigDecimal getBetrag() {
		summeUmlageanteile
	}
	
	BigDecimal getGezahlteNebenkosten () {
		betriebskostenabrechnung.mietvertrag.getGezahlteNebenkosten (betriebskostenabrechnung.immoabrechnung.jahr)
	}
	
	String getFormelNebenkosten () {
		betriebskostenabrechnung.mietvertrag.getFormelNebenkosten (betriebskostenabrechnung.immoabrechnung.jahr)
	}
	
	String getAbrechnungszeitraum () {
		betriebskostenabrechnung.mietvertrag.getAbrechnungszeitraum (betriebskostenabrechnung.immoabrechnung.jahr)
	}
	
	String getSaldokommentar () {
		if (saldo > 0)
			return "Ihr Guthaben:"
		else
		    return "Nachzuzahlen:"
	}
	
	BigDecimal getSaldo () {
		BigDecimal n = gezahlteNebenkosten
		BigDecimal u = summeUmlageanteile
		gezahlteNebenkosten - summeUmlageanteile
	}
	
	void erzeugeCsv(BufferedWriter nOut) {
		nOut.writeLine("Nebenkostenabrechnung ;${betriebskostenabrechnung.immoabrechnung.jahr};Monat:${abrechnungszeitraum}")
		nOut.writeLine("${betriebskostenabrechnung.mietvertrag.mietsache}")
		nOut.writeLine("Mieter:;${betriebskostenabrechnung.mietvertrag.mieter.partner.name}")
		nOut.writeLine("Kostenart;UmlSchl;Ges €;x (Anteil;/ MengeGes) =;€")
		umlageanteile.each {Umlageanteil ua ->
			nOut.writeLine("${ua.kostenart};${ua.umlageschluessel} ${ua.einheit};${rB2(ua.umlage.betrag)};${ua.anteil};${ua.menge};${rB2(ua.betrag)}")			
		}
		nOut.writeLine(";;;;Summe;${rB2(summeUmlageanteile)}")
		nOut.writeLine(";;;;;")
		
		if (!betriebskostenabrechnung.mietvertrag.mietsache.zwischenzaehlers.empty) {
			nOut.writeLine("Zwischenzähler;Stand Neu; - Alt;= Verbrauch;;")
			BigDecimal sumVerbrauch = 0
			betriebskostenabrechnung.mietvertrag.mietsache.zwischenzaehlers.each {Zwischenzaehler zz ->
			BigDecimal [] NeuAlt = zz.standNeuAlt
			nOut.writeLine("${zz.zaehlernummer};${rB3(NeuAlt[0])};${rB3(NeuAlt[1])};${rB3(NeuAlt[0]-NeuAlt[1])};;")
			sumVerbrauch += (NeuAlt[0]-NeuAlt[1])
			}
			nOut.writeLine(";;Summe;${rB3(sumVerbrauch)};;")
		}
	}
	
	String rB2 (BigDecimal w) {
		DecimalFormat df = new DecimalFormat("###,##0.00")
		df.format(w)
	}
	
	String rB3 (BigDecimal w) {
		DecimalFormat df = new DecimalFormat("###,##0.000")
		df.format(w)
	}
	
}
