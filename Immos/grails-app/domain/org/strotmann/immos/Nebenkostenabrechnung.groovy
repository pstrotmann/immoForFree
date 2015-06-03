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
		gezahlteNebenkosten - summeUmlageanteile
	}
	
	void erzeugeCsv(BufferedWriter nOut) {
		nOut.writeLine("Betriebskostenabrechnung ;${betriebskostenabrechnung.immoabrechnung.jahr};Monat:${abrechnungszeitraum}")
		nOut.writeLine("${betriebskostenabrechnung.immoabrechnung}")
		nOut.writeLine("Mieter:;${betriebskostenabrechnung.mietvertrag.mieter.partner.name}")
		nOut.writeLine("Kostenart;Gesamtbetrag;Umlagebetrag;Umlageschlüssel;Formel;Betrag")
		umlageanteile.each {Umlageanteil ua ->
			nOut.writeLine("${ua.kostenart};${rB(ua.gesamtbetrag)};${rB(ua.umlagebetrag)};${ua.umlageschluessel};${ua.anteil};${rB(ua.betrag)}")			
		}
		nOut.writeLine(";;;Summe;;${rB(summeUmlageanteile)}")
		nOut.writeLine(";;;gezahlte Pauschale;${formelNebenkosten};${rB(gezahlteNebenkosten)}")
		nOut.writeLine(";;;${saldokommentar};;${rB(saldo)}")
	}
	
	String rB (BigDecimal w) {
		DecimalFormat df = new DecimalFormat("###,##0.00")
		df.format(w)
	}
	
}
