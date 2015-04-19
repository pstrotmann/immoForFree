package org.strotmann.immos

import java.util.List;

class Immobilie {
	
	int baujahr
	Date eigentumAb
	Date eigentumBis
	BigDecimal anschaffungspreis
	BigDecimal verkaufspreis
	BigDecimal grundstueckspreis
	BigDecimal grundstuecksgroesse
	boolean erhoehteAbschreibung	
	boolean sozialerWohnungsbau
	String grundbuch
	int anzRauchmelder
	
	Hausadresse hausadresse
	
	SortedSet mietsachen, kredite, grundschulden, rechnungen, dienstleistungsvertraege
	static hasMany = [mietsachen:Mietsache,
					  kredite:Kredit,
					  dienstleistungsvertraege:Dienstleistungsvertrag,
					  rechnungen:Rechnung,
					  einheitswerte:Einheitswert,
					  grundschulden:Grundschuld,
					  immoabrechnungen:Immoabrechnung,
					  zaehlers:Zaehler]

    static constraints = {
		hausadresse(unique:true)
		grundbuch(nullable:true)
		baujahr()
		eigentumAb(nullable:true)
		eigentumBis(nullable:true)
		anschaffungspreis(nullable:true)
		verkaufspreis(nullable:true)
		grundstueckspreis(nullable:true)
		grundstuecksgroesse(nullable:true)
		erhoehteAbschreibung()
		sozialerWohnungsbau()
		mietsachen()
		kredite()
		dienstleistungsvertraege()
		rechnungen()
		anzRauchmelder(nullable:true)
	}
	
	static transients = ['prozentAbschreibung', 'anschaffungspreisDM', 'grundstueckspreisDM', 
							'aktuelleBruttomiete', 'restschuld', 'summeRestschuld']
	
	def getProzentAbschreibung() {
		int jahr = Calendar.getInstance().get(Calendar.YEAR)
		if (erhoehteAbschreibung.equals("ja") &&
			jahr - baujahr <= 8	)
			return 5
		else
			return 2
	}
	
	def getAnschaffungspreisDM () {
		return this.anschaffungspreis * 1.95583
	}
	def getGrundstueckspreisDM () {
		return this.grundstueckspreis * 1.95583
	}
	 
	static BigDecimal getSummeRestschuld () {
		BigDecimal rS = 0
		Immobilie.list().each {immobilie ->
			Immobilie i = (Immobilie) immobilie
			rS = rS + i.restschuld
		}
		return rS
	}
	 
	BigDecimal getRestschuld () {
		BigDecimal rS = 0
		this.kredite.each {kredit ->
			Kredit k = (Kredit)kredit
			rS = rS + k.kreditsaldo
		}
		return rS
	}
	
	BigDecimal getWohnflaeche () {
		BigDecimal wF = 0
		this.mietsachen.each {Mietsache ms ->
			wF += ms.wohnflaeche?:0
		}
		wF
	}
	
	int getAnzahlPersonen () {
		int anzP = 0
		this.mietsachen.each {Mietsache ms ->
			if (ms.wohnflaeche)
				ms.mietvertraege.each {Mietvertrag mv ->
					anzP += mv.anzahlPersonen
				}
		}
		anzP
	}
	
	int getAnzahlHaushalte () {
		int anzHH = 0
		this.mietsachen.each {Mietsache ms ->
			if (ms.wohnflaeche)
				anzHH++
		}
		anzHH
	}
	
	static BigDecimal summe(String field) {
		def c = Immobilie.createCriteria()
		def sum = c { 
			projections { 
				sum(field) 
			}
		}
		return(sum[0]);
	}
	
	String toString() {"${this.hausadresse}"}
	
	static List getImmobilien () {
		Immobilie.findAll("from Immobilie as im where im.eigentumBis = null order by im.hausadresse.ort, im.hausadresse.strasse, im.hausadresse.hausnummer")
	}
	
	static BigDecimal getAnschaffungssumme () {
		def BigDecimal summe = 0
		getImmobilien().each {Immobilie immo ->
			summe += immo.anschaffungspreis
		}
		summe
	}
	
	List <Mietvertrag> getMietvertraege () {
		List <Mietvertrag> mvList = []
		Mietvertrag.findAll ("from Mietvertrag as mv where mv.mietsache.immobilie = ${id}").each {mvList << it}
		mvList
	}
	
	List <Zwischenzaehler> getZwischenzaehlers () {
		List <Zwischenzaehler> zzList = []
		Zwischenzaehler.findAll ("from Zwischenzaehler as zz where zz.zaehler.immobilie = ${id}").each {zzList << it}
		zzList
	}
	
	Map <String, BigDecimal[]> getTeilsummen () {
		Map tSum = [:]
		def Calendar cal = Calendar.getInstance();
		cal.setTime(new Date())
		int vorjahr = cal.get(Calendar.YEAR) - 1
		cal.set(vorjahr,Calendar.JANUARY,1)
		Date vorjahrBeginn = cal.getTime()
		cal.set(vorjahr,Calendar.DECEMBER,31)
		Date vorjahrEnde = cal.getTime()
		//Zusamenfassen der Wohnungen je Etage 
		this.mietsachen.each {Mietsache ms ->
			String immoteil
			if (ms.art == 'Wohnung') 
				immoteil = ms.lage.split('-')[0]
			else
			 	immoteil = ms.art
			if (!tSum[(immoteil)]) tSum += [(immoteil):[0,0]]	
			ms.vertragsstaende.each {Mietvertragsstand mvs ->
				def Date ab, bis
				def int mo = 0
				if (mvs.gueltigAb.clearTime().compareTo(vorjahrEnde.clearTime()) > 0) 
					ab = null
				else
					if (mvs.gueltigAb.clearTime().compareTo(vorjahrBeginn.clearTime()) < 0)
						ab = vorjahrBeginn.clearTime()
					else
						ab = mvs.gueltigAb.clearTime()
				if (mvs.gueltigBis.clearTime().compareTo(vorjahrBeginn.clearTime()) < 0) 
					bis = null
				else
					if (mvs.gueltigBis.clearTime().compareTo(vorjahrEnde.clearTime()) > 0)
						bis = vorjahrEnde.clearTime()
					else
						bis = mvs.gueltigBis.clearTime()
						
				if (ab && bis)
					mo = bis.minus(ab) / 30 + 0.5
				
				if (immoteil == 'Garage' || immoteil == 'Stellplatz') 
						tSum[(immoteil)][0] += (mvs.zusatzmiete * mo)
					else {
						tSum[(immoteil)][0] += (mvs.grundmiete * mo)
						tSum[(immoteil)][1] += ((mvs.nebenkostenpauschale + mvs.heizkostenpauschale) * mo)
					}
					if (mvs.mietvertrag.mietsache.art == 'Garage' || mvs.mietvertrag.mietsache.art == 'Stellplatz')
						tSum[(immoteil)][0] += (mvs.grundmiete * mo)
				
			}
		}		 		 
		tSum
	}
	
}
