package org.strotmann.immos

import java.io.PrintWriter;
import org.apache.commons.lang.*
import static java.util.Calendar.*

class Mietvertrag implements Comparable {
	
	Partnerrolle mieter
	
	Date mietbeginn
	Date mietende
	
	BigDecimal kaution = 0	
	
	int zahlweise
	
	String tuerschluessel
		
	Mietsache mietsache // Hauptmietsache Wohnung
	
	Mietsache zusatzMietsache // z.b. Garage, Stellplatz 
	
	SortedSet vertragsstaende, mietforderungen, zahlungen, betriebskostenabrechnungen
	static hasMany = [vertragsstaende:Mietvertragsstand, zahlungen:Zahlung, mietforderungen:OffenerPosten, betriebskostenabrechnungen:Betriebskostenabrechnung]
	 
	static constraints = {
		
		mieter()
		mietsache()
		mietbeginn()
		mietende(nullable:true)
		kaution(nullable:true)
		zahlweise(inList: Zahlung.zahlweiseNum)
		zusatzMietsache(nullable:true)
		tuerschluessel(nullable:true)
		vertragsstaende()
		zahlungen()
		mietforderungen()
		
	}
	
	static transients = ['mietbeginnAufbereitet','mietendeAufbereitet','zahlweiseKlar']
	
	int compareTo(obj) {    	
    	return (mietbeginn.compareTo(obj.mietbeginn) * -1)
	}
	
	String getMietbeginnAufbereitet () {		
		return this.mietbeginn.getDateString()		
	}
	String getMietendeAufbereitet () {
		if (this.mietende)
			return ", Mietende: "+this.mietende.getDateString()
		else
			return ""
	}
	
	String toString() {
		return "${this.mietsache} ${this.zusatzMietsache?'+'+this.zusatzMietsache.mietsacheKurz:''}"
	}
	
	String getZahlweiseKlar() {
		grails.util.Holders.config.zahlweise [zahlweise]
	}
	
	String getMietvertragKlar() {
		return "${this.mieter.partner} ${this.mietsache}${this.zusatzMietsache?'+'+this.zusatzMietsache.mietsacheKurz:''}"		
	}
	
	List getZahlerList () {
		def List paroList = Partnerrolle.findAll("from Partnerrolle as paro where paro.mietvertrag = ${id} and paro.rolle = 'Mietzahler'")
		def pList = []
		paroList.each {def Partnerrolle paro = it
			pList << Partner.get(paro.partner.id)}
		return pList
	}
	
	BigDecimal getBruttomiete () {
		def List mvsList = Mietvertragsstand.findAll("from Mietvertragsstand as mvs where mvs.mietvertrag = ${id} order by mvs.gueltigAb desc")
		def Mietvertragsstand mvs = mvsList.empty ? null : mvsList.first()
		mvs ? mvs.bruttomiete : 0
	}
	
	BigDecimal getGrundmiete () {
		def List mvsList = Mietvertragsstand.findAll("from Mietvertragsstand as mvs where mvs.mietvertrag = ${id} order by mvs.gueltigAb desc")
		def Mietvertragsstand mvs = mvsList.empty ? null : mvsList.first()
		mvs ? mvs.grundmiete + mvs.zusatzmiete : 0
	}
	
	int getAnzahlPersonen() {
		def Mietvertragsstand mvs = vertragsstaende.empty ? null : vertragsstaende.last()
		def int anzP = mvs?mvs.anzahlPersonen:0 
		anzP
	}
	
	List getNebko (int jahr) {
		List list = []
		def BigDecimal gezahltePauschale = 0
		def String formel = ''
		def String abrZeitraum = ''
		def int vonMon = 0
		def int bisMon = 11
		def Calendar mvsAnf = Calendar.getInstance();
		def Calendar mvsEnd = Calendar.getInstance();
		vertragsstaende.each {Mietvertragsstand mvs ->
			def int anfMon = 0
			def int endMon = 0
			mvsAnf.setTime(mvs.gueltigAb)
			if (mvsAnf.get(Calendar.YEAR) == jahr) {
				anfMon = mvsAnf.get(Calendar.MONTH)
				if (mvs.is(vertragsstaende.last())) {
					if (mietende) {
						mvsEnd.setTime(mietende)
						endMon = mvsEnd.get(Calendar.MONTH)
					}
					else
						endMon = 11
				}
				else {
					Mietvertragsstand mLast = vertragsstaende.tailSet(mvs).last()
					mvsEnd.setTime(mLast.gueltigAb)
					endMon = mvsEnd.get(Calendar.MONTH) - 1
				}
				gezahltePauschale += (endMon - anfMon + 1) * mvs.nebenkostenpauschale
				formel += "${endMon - anfMon + 1}*${mvs.nebenkostenpauschale} ".replace('.',',')
			}
			vonMon = (anfMon < vonMon ? anfMon : vonMon)
			bisMon = (endMon > bisMon ? endMon : bisMon)
		}
		list << gezahltePauschale
		list << formel
		list << "${(vonMon+1).toString().padLeft(2,'0')}-${(bisMon+1).toString().padLeft(2,'0')}"
	}
	
	BigDecimal getHeiko (int jahr) {
		def BigDecimal gezahltePauschale = 0
		def String abrZeitraum = ''
		def int vonMon = 0
		def int bisMon = 11
		def Calendar mvsAnf = Calendar.getInstance();
		def Calendar mvsEnd = Calendar.getInstance();
		vertragsstaende.each {Mietvertragsstand mvs ->
			def int anfMon = 0
			def int endMon = 0
			mvsAnf.setTime(mvs.gueltigAb)
			if (mvsAnf.get(Calendar.YEAR) == jahr) {
				anfMon = mvsAnf.get(Calendar.MONTH)
				if (mvs.is(vertragsstaende.last())) {
					if (mietende) {
						mvsEnd.setTime(mietende)
						endMon = mvsEnd.get(Calendar.MONTH)
					}
					else
						endMon = 11
				}
				else {
					Mietvertragsstand mLast = vertragsstaende.tailSet(mvs).last()
					mvsEnd.setTime(mLast.gueltigAb)
					endMon = mvsEnd.get(Calendar.MONTH)
				}
				gezahltePauschale += (endMon - anfMon + 1) * mvs.heizkostenpauschale
			}
			vonMon = (anfMon < vonMon ? anfMon : vonMon)
			bisMon = (endMon > bisMon ? endMon : bisMon)
		}
		gezahltePauschale
	}
	
	List <BigDecimal> bkVj () {
		
		List <BigDecimal> bk =[0,0]
		Calendar heute = Calendar.getInstance()
		int vj = heute.get(Calendar.YEAR) - 1
		List l = []
		vertragsstaende.each {l << it}
		Mietvertragsstand vsFolge = null
		l.reverse().each {Mietvertragsstand vs ->
			Calendar calVon = vs.gueltigAb.toCalendar()
			Calendar calBis
			if (vsFolge) {
				use (groovy.time.TimeCategory) {
					Date d = (vsFolge.gueltigAb - 1.months)
					calBis = d.toCalendar()
				}
			}
			else
				if (mietende)
					calBis = mietende.toCalendar()
				else {
					def d = new Date()
					calBis = d.toCalendar()
					if (calVon > calBis)
						calBis = calVon
				}
			
			vsFolge = vs
			if(vj >= calVon.get(Calendar.YEAR) && vj <= calBis.get(Calendar.YEAR)) {
				
				if (calVon.get(Calendar.YEAR) < vj) {
					calVon[YEAR] = vj
					calVon[MONTH] = 0
				}
				
				if (calBis.get(Calendar.YEAR) > vj) {
					calBis[YEAR] = vj
					calBis[MONTH] = 11
				}
				
				bk[0] += vs.nebenkostenpauschale * (calBis.get(Calendar.MONTH) - calVon.get(Calendar.MONTH) + 1)
				bk[1] += vs.heizkostenpauschale  * (calBis.get(Calendar.MONTH) - calVon.get(Calendar.MONTH) + 1)
			}
		}
		bk
	}
	
	BigDecimal getNebkoVj () {
		bkVj()[0]
	}
	
	BigDecimal getHeikoVj () {
		bkVj()[1]
	}
	
	BigDecimal getGezahlteNebenkosten (int jahr) {
		getNebko(jahr)[0]
	}
	
	BigDecimal getGezahlteHeizkosten (int jahr) {
		getHeiko(jahr)
	}
	
	String getFormelNebenkosten (int jahr) {
		getNebko(jahr)[1]
	}
	
	String getAbrechnungszeitraum (int jahr) {
		getNebko(jahr)[2]
	}
		
	BigDecimal getMietsaldo () {
		
		def BigDecimal sumZahlung = 0
		def BigDecimal sumOffenerPosten = 0
		def List <Zahlung> zList = Zahlung.findAll("from Zahlung as z where z.mietvertrag = ${id} ")
		zList.each {zahlung ->
			sumZahlung += zahlung.betrag
		}
		def List <OffenerPosten> opList = OffenerPosten.findAll("from OffenerPosten as op where op.mietvertrag = ${id} ")
		opList.each {offenerPosten ->
			sumOffenerPosten += offenerPosten.betrag
		}
		return sumZahlung + sumOffenerPosten - sumVstand(id, mietende, kaution, zahlweise)
	}

	private static BigDecimal sumVstand(long id, Date mietende, BigDecimal kaution, int zahlweise) {
		
		def BigDecimal sumVstand = 0
		String q = "from Mietvertragsstand as mvs where mvs.mietvertrag = ${id} and mvs.gueltigAb < current_date() order by mvs.gueltigAb"
		def List <Mietvertragsstand> mvsList = Mietvertragsstand.findAll(q)
		if (mvsList.empty)
			return 0
		def Date start2014 = new GregorianCalendar(2014,Calendar.JANUARY,1).getTime().clearTime()
		def Calendar cal = Calendar.getInstance()
		cal.setTime(new Date())
		cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH)+1,1)
		Date d = cal.getTime()
		use (groovy.time.TimeCategory) {
			d = d - 1.days
		}
		def Date lastVstandEnde = mietende?:d
		if (lastVstandEnde.compareTo(start2014) <= 0)
			return 0
		def int lastI = mvsList.size() - 1
		for (i in 0..lastI) {
			
			def vStand = mvsList[i]
			def Date ab
			if (vStand.gueltigAb.compareTo(start2014) >= 0)
				ab = vStand.gueltigAb
			else
				ab = start2014
			def int forderungsperioden = 0
			def Map tage =[12:30.41, 4:91.25] 
			if (vStand.is(mvsList.last()))
				forderungsperioden = lastVstandEnde.minus(ab)/tage[zahlweise] + 0.5 // Aufrunden
			else
				forderungsperioden = mvsList[i+1].gueltigAb.minus(ab)/tage[zahlweise] + 0.5 // Aufrunden
			sumVstand += forderungsperioden * vStand.bruttomiete
			cal = Calendar.getInstance()
			cal.setTime(lastVstandEnde)
			if (cal.get(Calendar.DAY_OF_MONTH) == 15)
				sumVstand += vStand.bruttomiete / 2
		}
		if (mietende)
		sumVstand -= kaution
		return sumVstand
	}
	
	static List getMieterList () {
		List oList = Organisation.findAll("from Organisation as o where o.rechtsform = 'Personengemeinschaft'")
		List pList = Person.findAll("from Person as p where not exists (from Partnerrolle as paro where paro.rolle = 'Ansprechpartner' and paro.partner =p.id)")
		oList += pList
		oList.sort()
	}
	
	static Map getMietvertraegeUndSummen () {
		Map mvSum = ['mietvertraege':[],'sumGrund':0,'sumBrutto':0,'sumSaldo':0]
		Mietvertrag.findAll("from Mietvertrag as mv where mv.mietende is null order by mieter.partner.name ").each {Mietvertrag mv ->
			def BigDecimal mvGrund = mv.grundmiete
			def BigDecimal mvBrutto = mv.bruttomiete
			def BigDecimal mvSaldo = mv.mietsaldo
			mvSum.mietvertraege << [mv,mvGrund,mvBrutto,mvSaldo]
			mvSum.sumGrund += mvGrund
			mvSum.sumBrutto += mvBrutto
			mvSum.sumSaldo += mvSaldo
		}
		mvSum
	}
	
	static List getMietvertraege () {
		Mietvertrag.findAll("from Mietvertrag as mv where mv.mietende is null order by mieter.partner.name ")
	}
	
	static BigDecimal getSumMtlGrund () {
		def BigDecimal sum = 0
		Mietvertrag.findAll("from Mietvertrag as mv where mv.mietende is null").each {Mietvertrag mv ->
			sum += mv.grundmiete
		}
		sum
	}
	
	static BigDecimal getSumMtlBrutto () {
		def BigDecimal sum = 0
		Mietvertrag.findAll("from Mietvertrag as mv where mv.mietende is null").each {Mietvertrag mv ->
			sum += mv.bruttomiete
		}
		sum
	}
	
	static BigDecimal getSumSaldo () {
		def BigDecimal sum = 0
		Mietvertrag.findAll("from Mietvertrag as mv where mv.mietende is null").each {Mietvertrag mv ->
			sum += mv.mietsaldo
		}
		sum
	}
	
	static void printMietjournal (PrintWriter mOut) {
		def Date start2014 = new GregorianCalendar(2014,Calendar.JANUARY,1).getTime().clearTime()
		List <Mietvertrag> mList = getMietvertraege ()
		mList.each {Mietvertrag mv ->
			
			def BigDecimal forderung = sumVstand(mv.id, mv.mietende, mv.kaution, mv.zahlweise) * (-1)
			def String fBtr = forderung.toString().padLeft(10).replace('.',',')
			def String mName = mv.mieter.partner.name.padRight(32)
			def Date von = [start2014,mv.mietbeginn].max()
			mOut.println("${mName} Mietforderung   ${fBtr} Zeitraum ${von.getDateString()} bis ${new Date().getDateString()}")
			
			def BigDecimal sumOffenerPosten = 0
			def List <OffenerPosten> opList = OffenerPosten.findAll("from OffenerPosten as op where op.mietvertrag = ${mv.id} order by op.faelligkeit")
			opList.each {offenerPosten ->
				mOut.println ("offener Posten vom ${offenerPosten.toKurzString()}".padLeft(59)+" "+offenerPosten.grund.trim())
				sumOffenerPosten += offenerPosten.betrag
			}
			
			mOut.println ()
			def BigDecimal sumZahlung = 0
			def List <Zahlung> zList = Zahlung.findAll("from Zahlung as z where z.mietvertrag = ${mv.id} order by z.datum")
			zList.each {zahlung ->
				sumZahlung += zahlung.betrag
				String s = "Zahlung am   ${zahlung}".padLeft(59)
				if (zahlung.bankumsatz)
					s = s+" "+zahlung.bankumsatz.verwendungszweck.trim()
				
				mOut.println (StringUtils.substring(s,0,100))
			}
			mOut.println ()
			
			def BigDecimal saldo = [sumZahlung,sumOffenerPosten,forderung].sum()
			def String sBtr = saldo.toString().padLeft(10).replace('.',',')
			
			def filler = " ".padRight(29)
			mOut.println("${filler}Saldo per   ${new Date().getDateString()}${sBtr}")
			mOut.write('\f')
		}
	}
}
