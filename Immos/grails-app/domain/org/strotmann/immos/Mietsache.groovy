package org.strotmann.immos

import java.util.Date;
import java.util.List;
import java.util.SortedSet;

class Mietsache implements Comparable{
	
	String lage // in Immobilie
	String art // (Mietsachen)art
	BigDecimal wohnflaeche
	String aufteilung
	int anzRauchmelder
	
	static belongsTo = [immobilie:Immobilie]
	
	SortedSet zwischenzaehlers
	static hasMany = [zwischenzaehlers:Zwischenzaehler]
	
	static constraints = {		
		lage()
		art()
		wohnflaeche (nullable:true)
		aufteilung (nullable:true)
		anzRauchmelder()
	}
		
	int compareTo(obj) {
		if (art.equals("Wohnung"))
			return -1
		else
			return 1
	}
	
	String getMietsacheKurz () {
		"${art},${lage}"
	}
		
	String toString() {
		return "${this.immobilie},${art},${lage}"
	}
	
	static List getArten () {
		grails.util.Holders.config.mietsachenart
	}
	
	List getMietvertraege () {
		return(Mietvertrag.findAll("from Mietvertrag as mv where mv.mietsache = ${id} or mv.zusatzMietsache = ${id}"))
	}
	
	List getVertragsstaende () {
		return(Mietvertragsstand.findAll("from Mietvertragsstand as mvs where mvs.mietvertrag.mietsache = ${id} or mvs.mietvertrag.zusatzMietsache = ${id}"))
	}
	
	int getAktPersonen () {
		Mietvertrag mv = Mietvertrag.find("from Mietvertrag as mv where mv.mietsache = ${id} and mv.mietende = null")
		Mietvertragsstand mvStand = mv.vertragsstaende.first()
		mvStand.anzahlPersonen
	}
	
	BigDecimal wasserverbrauch (int kj) {
		BigDecimal zV = 0
		if (anzWasserzaehler == 0)
			 return 0
		Zwischenzaehlerstand z1st
		Zwischenzaehlerstand z2nd
		zwischenzaehlers.each {Zwischenzaehler zz -> 
			if (zz.zaehler.zaehlertyp == 'Wasser') {
				def i = 0
				zz.zwischenzaehlerstaende.each {Zwischenzaehlerstand zStand ->
					if (jahr(zStand.ablesedatum) > kj) {return}
					i++
					if (i == 1) z1st = zStand
					if (i == 2) z2nd = zStand
				}
			}
			zV += (z1st?z1st.wert:0) - (z2nd?z2nd.wert:0)
			}
		zV
	}
	
	int getAnzWasserzaehler () {
		def int anz = 0
		zwischenzaehlers.each {
			if (it.zaehler.zaehlertyp == 'Wasser' && 
				!it.zaehlernummer.endsWith('2'))
				anz++
		}
		anz
	}
	
	BigDecimal getVorjahresnettomiete() {
		def BigDecimal netto = 0
		List <Mietvertragsstand> mvsGue = []
		Date gueBis, gueAb
		
		def Calendar cal = Calendar.getInstance();
		cal.setTime(new Date())
		int vorjahr = cal.get(Calendar.YEAR) - 1
		cal.set(vorjahr,Calendar.JANUARY,1)
		Date vorjahrBeginn = cal.getTime()
		cal.set(vorjahr,Calendar.DECEMBER,31)
		Date vorjahrEnde = cal.getTime()
		
		vertragsstaende.each {Mietvertragsstand mvs ->
			
			if (mvs.gueltigBis.compareTo(vorjahrEnde) > 0)
				gueBis = vorjahrEnde
			else
				gueBis = mvs.gueltigBis
				
			if (mvs.gueltigAb > vorjahrEnde || gueBis < vorjahrBeginn)
			 	{/*do nothing, Vertragsstand liegt außerhalb des Vorjahres*/}
			else
				mvsGue << mvs
		}
		
		mvsGue.each {Mietvertragsstand mvs ->
			
			if (mvs.gueltigAb.compareTo(vorjahrBeginn) < 0)
				gueAb = vorjahrBeginn
			else
				gueAb = mvs.gueltigAb
			
			if (mvs.gueltigBis.compareTo(vorjahrEnde) > 0)
				gueBis = vorjahrEnde
			else
				gueBis = mvs.gueltigBis
				
			def int monate = gueBis.minus(gueAb) / 30 + 0.5
			
			if (this.art in ['Garage','Stellplatz'])
				netto += (mvs.zusatzmiete) * monate
			else
				netto += (mvs.grundmiete) * monate
			
		}
		
		netto
	}
	
	BigDecimal getVorjahresumlage() {
		def BigDecimal uml = 0
		uml
	}
	
	int jahr (Date d) {
		def Calendar c = Calendar.getInstance();
		c.setTime(d)
		c.get(Calendar.YEAR)
	}
	
	static List mietsachenZuImmo (long immoId) {
		String suchString = "from Mietsache as ms where ms.immobilie.id = ${immoId} "
		Mietsache.findAll(suchString)
	}
}
