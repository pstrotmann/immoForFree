package org.strotmann.immos
import java.util.List;
import org.apache.commons.lang.*
import grails.util.Holders

class Zahlung implements Comparable{
	
	Date datum
	BigDecimal betrag
	
	Mietvertrag mietvertrag
	Rechnung rechnung
	Dienstleistungsvertrag dienstleistungsvertrag
	Kredit kredit
	
	Bankumsatz bankumsatz
	int buchungsjahr 

	static constraints = {
		datum(validator: {w, o ->
			int i = 0
			
			if (o.mietvertrag) i++
			if (o.kredit) i++
			if (o.dienstleistungsvertrag) i++
			if (o.rechnung) i++
			
			return i <= 1
		})
		betrag()
		
		mietvertrag(nullable:true)
		rechnung(nullable:true)
		dienstleistungsvertrag(nullable:true)
		kredit(nullable:true)
		
		bankumsatz(nullable:true)
		buchungsjahr(nullable:true)
	}
	
	Immobilie getImmobilie() {
		if(mietvertrag) return mietvertrag.mietsache.immobilie 
		if(kredit) return kredit.verwendung
		if(dienstleistungsvertrag) return dienstleistungsvertrag.immobilie
		if(rechnung) return rechnung.immobilie
	}
	
	Boolean getUmlagefaehig () {
		if (mietvertrag || kredit) false
		else
			if (dienstleistungsvertrag) dienstleistungsvertrag.umlagefaehig
			else
				if (rechnung) rechnung.umlagefaehig
	}
	
	
	int compareTo(obj) {
		if (datum.compareTo(obj.datum) < 0)
			return -1
		else
			if (datum.compareTo(obj.datum) > 0)
				return 1
			else
				return id.compareTo(obj.id) * (-1)
	}
	
	String zPlus() {
		def nbsp = "\u2007"
		def String bText = bankumsatz?nbsp+bankumsatz.buchungstext:''
		def String bZ = bankumsatz?StringUtils.substring(bankumsatz.beguenstigterZahlungspflichtiger,0,25):''
		toString()+bText+','+nbsp+bZ
	}
	
	String toString() {
		def nbsp = "\u2007"
		def btr =betrag.toString().replace('.',',').padLeft(10,nbsp)
		"${this.datum.getDateString()}$btr"
	}
	
	static List <Zahlung> umlagefaehigZuImmo (String iId) {
		int immoId = new Integer (iId)
		List <Zahlung> zList = []
		String s = "from Zahlung as z where (z.rechnung is not null or z.dienstleistungsvertrag is not null)"
		Zahlung.findAll(s).each { 
			if(it.immobilie.id == immoId && it.umlagefaehig) zList << it
		}
		zList.sort{a,b ->a.rechnung <=> b.rechnung ?: a.dienstleistungsvertrag?.id <=> b.dienstleistungsvertrag?.id ?: a.datum <=> b.datum}
	}
	
	static List getZahlweiseNum() {
		List zw = []
		Holders.config.zahlweise.each {
			zw << it.key
			}
		zw
	}
	
	static void printZuordnungen (PrintWriter zOut) {
		List zListPlus = []
		List <Zahlung> zList = Zahlung.findAll("from Zahlung where buchungsjahr = 2014")
		zList.each {z ->
			def Immobilie immobilie
			def String kategorie
			if (z.mietvertrag) {
				immobilie = z.mietvertrag.mietsache.immobilie
				kategorie = 'Miete'
			}
			if (z.kredit) {
				immobilie = z.kredit.verwendung
				kategorie = 'Kredit'
			}
			if (z.dienstleistungsvertrag) {
				immobilie = z.dienstleistungsvertrag.immobilie
				if (z.dienstleistungsvertrag.umlagefaehig)
					kategorie = 'umlagefähig'
				else
					kategorie = 'nicht umlagefähig'
			}
			if (z.rechnung) {
				immobilie = z.rechnung.immobilie
				if (z.rechnung.umlagefaehig)
				kategorie = 'umlagefähig'
			else
				kategorie = 'nicht umlagefähig'
			}
			def Calendar cal = Calendar.getInstance();
			cal.setTime(z.datum)
			String ob1 = immobilie.hausadresse.postleitzahl+immobilie.hausadresse.strasse+immobilie.hausadresse.hausnummer
			String ob2 = kategorie+cal.get(Calendar.YEAR)+StringUtils.leftPad(cal.get(Calendar.MONTH).toString(),2,'0')+StringUtils.leftPad(cal.get(Calendar.DAY_OF_MONTH).toString(),2,'0')
			String ob = ob1 + ob2
			List zPlus = [ob,z,immobilie,kategorie,ob1]
			zListPlus << zPlus
		}
		zListPlus.sort {
			a,b ->
			 a[0] <=> b[0]
		}
		
		def String aktOb = ""
		def String aktKat = ""
		def BigDecimal immoSum = 0
		def BigDecimal katSum = 0
		def BigDecimal gesSum = 0
		zListPlus.each {zP ->
			def BigDecimal zBetrag = zP[1].betrag
			def Bankumsatz b = zP[1].bankumsatz
			def Immobilie immo = zP[2]
			def String kategorie = zP[3]
			def String ob1 = zP[4]
			if (ob1 > aktOb) {
				if (aktOb > "") {
					zOut.println(StringUtils.leftPad('Summe '+aktKat+' '+katSum.toString().replace('.',','),114,' '))
					zOut.newLine()
					zOut.println(StringUtils.leftPad('Summe '+aktOb+' '+immoSum.toString().replace('.',','),114,' '))
					zOut.write('\f')
				}
				aktOb = ob1
				immoSum = 0
				katSum = 0
				aktKat = ""
				Date d = new Date()
				zOut.println(StringUtils.rightPad("=============================="+immo+" ==== "+d.getDateString()+" ",113,'='))
			}
			if (ob1 == aktOb && kategorie > aktKat) {
				if (aktKat > "")
				   zOut.println(StringUtils.leftPad('Summe '+aktKat+' '+katSum.toString().replace('.',','),114))
				aktKat = kategorie
				katSum = 0
				zOut.println(StringUtils.rightPad("------------------------------"+kategorie,114,'-'))
			}
			
			String verw = StringUtils.rightPad('',60,' ')
			String beZa = StringUtils.rightPad('',30,' ')
			if (zP[1].mietvertrag) {
				verw = StringUtils.rightPad('Miete bar:'+zP[1].mietvertrag.mietsache.mietsacheKurz,60,' ')
				beZa = StringUtils.rightPad(zP[1].mietvertrag.mieter.partner.toString(),30,' ')
			}
			String valuta = zP[1].datum.getDateString()
			if (b) {
				verw = StringUtils.rightPad(StringUtils.substring(StringUtils.trim(b.verwendungszweck),0,60),60,' ')
				beZa = StringUtils.rightPad(StringUtils.substring(b.beguenstigterZahlungspflichtiger,0,30),30,' ')
				valuta = b.valutadatum.replace('.14', '.2014').replace('.15', '.2015')
			}
			String zBtr = StringUtils.leftPad(zBetrag.toString(),10,' ').replace('.',',')
			zOut.println(' '+valuta+' '+verw+' '+beZa+' '+zBtr)
			immoSum += zBetrag
			katSum += zBetrag
			gesSum += zBetrag
		}
		zOut.println(StringUtils.leftPad('Summe '+aktKat+' '+katSum.toString().replace('.',','),114,' '))
		zOut.newLine()
		zOut.println(StringUtils.leftPad('Summe '+aktOb+' '+immoSum.toString().replace('.',','),114,' '))
		zOut.write('\f')
		zOut.println(StringUtils.leftPad('GesamtSumme '+gesSum.toString().replace('.',','),113,' '))
	}
}
