package org.strotmann.immos

import java.util.List
import org.strotmann.immos.Notiz
import org.apache.commons.lang3.StringUtils

class Immobilie {
	
	int baujahr
	Partner eigentuemer
	Date eigentumAb
	Date eigentumBis
	BigDecimal anschaffungspreis
	BigDecimal grundstueckspreis
	BigDecimal grundstuecksgroesse
	BigDecimal grundbesitzwert
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
					  zaehlers:Zaehler,
					  verwendungen:Verwendung]

    static constraints = {
		hausadresse(unique:true)
		grundbuch(nullable:true)
		baujahr()
		eigentuemer(nullable:true)
		eigentumAb(nullable:true)
		eigentumBis(nullable:true)
		anschaffungspreis(nullable:true)
		grundstueckspreis(nullable:true)
		grundstuecksgroesse(nullable:true)
		grundbesitzwert(nullable:true)
		erhoehteAbschreibung()
		sozialerWohnungsbau()
		mietsachen()
		kredite()
		dienstleistungsvertraege()
		rechnungen()
		anzRauchmelder()
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
	
	def int getBewertungszahl () {
		int z =18
		Notiz.getNotizen('Immobilie',this.id).each {Notiz n ->
			if (StringUtils.contains(n.notiztext,"Jahresmieten:"))
				z = new Integer(StringUtils.split(n.notiztext,':')[1])
		}
		z
	}
	
	def BigDecimal getVerkaufspreis () {
		BigDecimal vk
		if (this.jahresnettomiete > 0)		
			vk = this.jahresnettomiete * bewertungszahl
		else		
			vk = this.anschaffungspreis
		return vk
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
		Verwendung.findAll("from Verwendung as v where v.immobilie = ${id}").each {Verwendung v ->
			BigDecimal kSaldo = v.kredit.kreditsaldo
			if (kSaldo > 0)
				rS = rS + kSaldo * (v.betrag/v.kredit.betrag)
		}
		rS
	}
	
	List <Kredit> getVerwKredite() {
		List <Kredit> l = []
		Verwendung.findAll("from Verwendung as v where v.immobilie = ${id}").each {Verwendung v ->
			l << v.kredit
		}
		l
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
					if (!mv.mietende || mv.mietende > new Date())
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
		List <Immobilie> immos = []
		def Calendar ago = Calendar.getInstance()
		use (groovy.time.TimeCategory) {
			ago.setTime(new Date() - 1.years)
		}
		Immobilie.findAll("from Immobilie as im order by im.hausadresse.ort, im.hausadresse.strasse, im.hausadresse.hausnummer").each {Immobilie immo ->
			if (immo.eigentumBis == null || immo.eigentumBis > ago.getTime())
			immos << immo
		}
		immos		
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
	
	List <Grundschuld> getGrundschuldenAktiv () {
		List <Grundschuld> gsList = []
		grundschulden.each {Grundschuld gs ->
			if (gs.loeschungAm == null)
				gsList << gs}
		gsList
	}
	
	List <Zwischenzaehler> getZwischenzaehlers () {
		List <Zwischenzaehler> zzList = []
		Zwischenzaehler.findAll ("from Zwischenzaehler as zz where zz.zaehler.immobilie = ${id}").each {zzList << it}
		zzList
	}
	
	List <Umlageinfo> getUmlageinfos () {
		List <Umlageinfo> uiList = []
		Umlageinfo.findAll ("from Umlageinfo").each {if (this.id == it.immobilie.id) uiList << it}
		uiList
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
				if (mvs.gueltigAb.compareTo(vorjahrEnde) > 0) 
					ab = null
				else
					if (mvs.gueltigAb.compareTo(vorjahrBeginn) < 0)
						ab = vorjahrBeginn.clearTime()
					else
						ab = mvs.gueltigAb.clearTime()
				if (mvs.gueltigBis.compareTo(vorjahrBeginn) < 0) 
					bis = null
				else
					if (mvs.gueltigBis.compareTo(vorjahrEnde) > 0)
						bis = vorjahrEnde
					else
						bis = mvs.gueltigBis
						
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
	
	BigDecimal getJahresnettomiete() {
		def BigDecimal netto = 0
		teilsummen.each {
			netto += it.value[0]
		}
		netto
	}
	
	static BigDecimal getJahresnettomietsumme () {
		def BigDecimal summe = 0
		getImmobilien().each {Immobilie immo ->
			summe += immo.jahresnettomiete
		}
		summe
	}
	
	BigDecimal getJahresumlage() {
		def BigDecimal umlage = 0
		teilsummen.each {
			umlage += it.value[1]
		}
		umlage
	}
	
	BigDecimal getAnnuitaet() {
		def BigDecimal betrag = 0
		Verwendung.findAll("from Verwendung as v where v.immobilie = ${id}").each {Verwendung v ->
			Kredit kr = v.kredit
			BigDecimal kSaldo = kr.kreditsaldo
			if (kSaldo > 0 && kr.aktKreditstand)
				betrag += kr.aktKreditstand.mtlAnnuitaet * kr.zahlweise * (v.betrag/kr.betrag)
		}
		betrag
	}
	
	BigDecimal getEinheitswert() {
		def BigDecimal betrag = 0
		if (einheitswerte) {
			einheitswerte.each {Einheitswert e ->
				betrag = e.wert
			}
		}
		betrag
	}
	
	List <Dienstleistungsvertrag> getAktDienstleistungsvertraege() {
		List <Dienstleistungsvertrag> dv = []
		def Calendar heute = Calendar.getInstance()
		use (groovy.time.TimeCategory) {
			heute.setTime(new Date())}
		this.dienstleistungsvertraege.each {Dienstleistungsvertrag d ->
			if (d.vertragsende == null || heute.getTime() < d.vertragsende)
				dv << d
		}
		dv
	}
	
	static BigDecimal getAnnuitaetensumme () {
		def BigDecimal summe = 0
		getImmobilien().each {Immobilie immo ->
			summe += immo.annuitaet
		}
		summe
	}
	
	static Map getImmobilienUndSummen() {
		Map iSum = ['immobilien':[],'sumJahresnetto':0,'sumAnnuitaet':0,'sumAnschaffung':0,'sumRestschuld':0,'sumEinheitswert':0,'sumWohnflaeche':0,'sumSchenkwert':0,'sumVerkauf':0]
		getAktImmos().each {Immobilie immo -> 
			
			def iJahresnetto = immo.jahresnettomiete
			def iAnnuitaet = immo.annuitaet
			def iAnschaffung = immo.anschaffungspreis
			def iRestschuld = immo.restschuld
			def iEinheitswert = immo.einheitswert
			def iWohnflaeche = immo.wohnflaeche
			def iVerkauf = immo.verkaufspreis
			def iSchenkwert = iVerkauf - 10 * iJahresnetto
			 
			iSum.immobilien << [immo, iJahresnetto, iAnnuitaet, iAnschaffung, iRestschuld, iEinheitswert, iWohnflaeche, iSchenkwert]
			iSum.sumJahresnetto += iJahresnetto
			iSum.sumAnnuitaet += iAnnuitaet
			iSum.sumAnschaffung += iAnschaffung
			iSum.sumRestschuld += iRestschuld
			iSum.sumEinheitswert += iEinheitswert
			iSum.sumWohnflaeche += iWohnflaeche
			iSum.sumSchenkwert += iSchenkwert
			iSum.sumVerkauf += iVerkauf
		}
		iSum
	}
	
	BigDecimal getNiesbrauch() {
		10 * jahresnettomiete 
	}
	
	BigDecimal getSchenkwert() {
		grundbesitzwert - niesbrauch 
	}
	
	static List <Immobilie> getAktImmos() {
		List <Immobilie> immos = []
		def Calendar ago = Calendar.getInstance()
		use (groovy.time.TimeCategory) {
			ago.setTime(new Date() - 1.years)
		}
		Immobilie.findAll("from Immobilie as im order by im.hausadresse.ort, im.hausadresse.strasse, im.hausadresse.hausnummer").each {Immobilie immo ->
			if (immo.eigentumBis == null || immo.eigentumBis > ago.getTime())
				immos << immo
		}
		immos
	}	
	
}
