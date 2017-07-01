package org.strotmann.immos

class BankumsatzZuordnungController {

    def index() {
		def int anzZahlung = 0
		def int anzBankums = 0
		def List loe =[]
		def Date vor60Tagen
		use (groovy.time.TimeCategory) {
			vor60Tagen = new Date() - 60.days
		}
		def long maxId = Bankumsatz.executeQuery("select max(b.id) from Bankumsatz as b")[0] - 250
		def List umsaetze = Bankumsatz.getZeitraumUms(maxId)
		umsaetze.each {Bankumsatz bUms ->
			anzBankums++
			List <Rechnung> rList = Rechnung.findAllByRechnungsdatumGreaterThan (vor60Tagen)
			rList.each {re ->
				def reRechnungsnummer = re.rechnungsnummer?:'_'
				def reRechnungsgegenstand = re.rechnungsgegenstand?:'_'
				if (bUms.verwendungszweck.contains(reRechnungsnummer))
					{
					def Zahlung zahlung = new Zahlung()
					zahlung.datum = new java.text.SimpleDateFormat("dd.MM.yy").parse(bUms.valutadatum)
					zahlung.betrag = new BigDecimal(bUms.betrag.replace(',', '.'))
					zahlung.bankumsatz = bUms
					zahlung.rechnung = re
					zahlung.save()
					anzZahlung++
					loe << bUms
					}
			}
		}
		umsaetze = umsaetze - loe
		flash.message1 = "Zuordnung auf Rechnungen  : ${anzBankums} Bankumsätze gelesen, ${anzZahlung} Zahlungen geschrieben"
		
		anzZahlung = 0
		anzBankums = 0
		loe =[]
		umsaetze.each {Bankumsatz bUms ->
			anzBankums++
			List <Zahlung> zListe = []
			List <Mietvertrag> mList = Mietvertrag.findAll ("from Mietvertrag as mv where mv.mietende is null")
			mList.each {mv ->
				if (checkBankumsatz (bUms, mv.mieter.partner) && !bUms.verwendungszweck.toUpperCase().contains('HAUSMEISTER'))
					{def Zahlung zahlung = new Zahlung()
					zahlung.datum = new java.text.SimpleDateFormat("dd.MM.yy").parse(bUms.valutadatum)
					zahlung.betrag = new BigDecimal(bUms.betrag.replace(',', '.'))
					zahlung.bankumsatz = bUms
					zahlung.mietvertrag = mv
					zListe << zahlung
					}
			}
			switch (zListe.size())
			{
			case 0 : /* do nothing */ break
					  
			case 1 : /* Eindeutigkeit */
					  zListe[0].save()
					  anzZahlung++
					  loe << bUms
					  break
					  
			default : /* Mehrdeutigkeit */
					zListe.each {zahlung ->
						if (zahlung.mietvertrag.bruttomiete == zahlung.betrag || istOp (zahlung)) {
							zahlung.save()
							anzZahlung++
							loe << bUms
						}
					}
			}
		}
		umsaetze = umsaetze - loe
		flash.message2 = "Zuordnung auf Mietverträge: ${anzBankums} Bankumsätze gelesen, ${anzZahlung} Zahlungen geschrieben"
		
		anzZahlung = 0
		anzBankums = 0
		//Sammelinkasso Westfälische Provinzial ist hart codiert
		bUmsSpez(maxId,"%ZAHLUNGSAUFSTELLUNG%","WESTFAELISCHE PROVINZIAL").each {bUms->
			anzBankums++
			List <Dienstleistungsvertrag> dList = Dienstleistungsvertrag.findAllByReferenz ("ZAHLUNGSAUFSTELLUNG WESTFAELISCHE PROVINZIAL")
			anzZahlung = genZahlungen(dList, bUms, anzZahlung)
		}
		//Sammelinkasso Stadt Bergkamen ist hart codiert
		bUmsSpez(maxId,"%01009000295902000%","Stadt Bergkamen").each {bUms->
			anzBankums++
			List <Dienstleistungsvertrag> dList = Dienstleistungsvertrag.findAllByReferenz ("01009000295902000")
			anzZahlung = genZahlungen(dList, bUms, anzZahlung)
		}
		//der Rest
		loe =[]
		umsaetze.each {Bankumsatz bUms ->
			anzBankums++
			List <Dienstleistungsvertrag> dList = Dienstleistungsvertrag.findAll ("from Dienstleistungsvertrag")
			dList.each {dv ->
				def dvReferenz = dv.referenz?:'_'
				def dvVertragsnummer = dv.vertragsnummer?:'_'
				def dvKundennummer = dv.kundennummer?:'_'
				def dvVertragsnummer0 = dvVertragsnummer.toUpperCase().split('-')[0]
				if (
					(bUms.beguenstigterZahlungspflichtiger.toUpperCase().contains(dvVertragsnummer0)
					 && !bUms.verwendungszweck.toUpperCase().contains('MIETE')
					 && dvVertragsnummer0.length() > 2)
				 || bUms.verwendungszweck.contains(dvVertragsnummer)
				 || bUms.mandatsreferenz.contains(dvVertragsnummer)
				 || bUms.mandatsreferenz.contains(dvReferenz)
				 || bUms.mandatsreferenz.contains(dvKundennummer)
				 || bUms.kundenreferenz.contains(dvKundennummer)
				 || bUms.kundenreferenz.contains(dvVertragsnummer)
					)
					{
					def Zahlung zahlung = new Zahlung()
					zahlung.datum = new java.text.SimpleDateFormat("dd.MM.yy").parse(bUms.valutadatum)
					zahlung.betrag = new BigDecimal(bUms.betrag.replace(',', '.'))
					zahlung.bankumsatz = bUms
					zahlung.dienstleistungsvertrag = dv
					zahlung.save()
					anzZahlung++
					loe << bUms
					}
			}
		}
		umsaetze = umsaetze - loe
		flash.message3 = "Zuordnung auf Dienstleistungsverträge: ${anzBankums} Bankumsätze gelesen, ${anzZahlung} Zahlungen geschrieben"
		
		anzZahlung = 0
		anzBankums = 0
		//Sonderbehandlung Wüstenrot hart codiert
		bUmsSpez(maxId,"%2076596886%","WUESTENROT BAUSPARKASSE AG").each {bUms->
			anzBankums++
			def String s = bUms.verwendungszweck+bUms.kundenreferenz+'00'
			def String[] sTeil = s.split('/')
			sTeil[2..sTeil.length - 1].each {t ->
				def String[] tTeil = t.split(' ')
				def String vnr = tTeil[1]
				Kredit kr = Kredit.findByVertragsnummer(vnr)
				def String btr = tTeil[2].substring(0,tTeil[2].length()-2)
				def Zahlung zahlung = new Zahlung()
				zahlung.datum = new java.text.SimpleDateFormat("dd.MM.yy").parse(bUms.valutadatum)
				zahlung.betrag = new BigDecimal(btr.replace(',', '.')) * (-1)
				zahlung.bankumsatz = bUms
				zahlung.kredit = kr
				zahlung.save()
				anzZahlung++
			}
		}
		//Behandlung Wfa und Sparkasse Do
		loe =[]
		umsaetze.each {Bankumsatz bUms ->
			if (bUms.beguenstigterZahlungspflichtiger != "WUESTENROT BAUSPARKASSE AG") {
				anzBankums++
				List <Kredit> kList = Kredit.findAll ("from Kredit")
				kList.each {kr ->
				def krVertragsnummer = kr.vertragsnummer?:'_'
					if (bUms.verwendungszweck.contains(krVertragsnummer)
							||bUms.kontonummerIBAN.contains(krVertragsnummer))
					{
						def Zahlung zahlung = new Zahlung()
						zahlung.datum = new java.text.SimpleDateFormat("dd.MM.yy").parse(bUms.valutadatum)
						zahlung.betrag = new BigDecimal(bUms.betrag.replace(',', '.'))
						zahlung.bankumsatz = bUms
						zahlung.kredit = kr
						zahlung.save()
						anzZahlung++
						loe << bUms
					}
				}
			}
		}
		umsaetze = umsaetze - loe
		flash.message4 = "Zuordnung auf Kredite: ${anzBankums} Bankumsätze gelesen, ${anzZahlung} Zahlungen geschrieben"
		
		redirect(uri: "/")
	}

	private List<Bankumsatz> bUmsSpez (Long maxId, String verwZweck, String beguenst) {
		Bankumsatz.findAll("from Bankumsatz as b where b.id > ? and not exists (from Zahlung as z where z.bankumsatz = b.id) and b.verwendungszweck like ? and b.beguenstigterZahlungspflichtiger = ?",[maxId,verwZweck,beguenst])
	}
	
	private int genZahlungen(List dList, Bankumsatz bUms, int anzZahlung) {
		dList.each {dv ->
			List <Dienstleistungsvertragsstand> dvsList = Dienstleistungsvertragsstand.findAll("from Dienstleistungsvertragsstand as dvs where dvs.dienstleistungsvertrag = ${dv.id}")
			Dienstleistungsvertragsstand dvs = dvsList.last()
			def Zahlung zahlung = new Zahlung()
			zahlung.datum = new java.text.SimpleDateFormat("dd.MM.yy").parse(bUms.valutadatum)
			zahlung.betrag = dvs.pauschale * (-1)
			zahlung.bankumsatz = bUms
			zahlung.dienstleistungsvertrag = dv
			zahlung.save()
			anzZahlung++
		}
		return anzZahlung
	}
	
	Boolean checkBankumsatz (Bankumsatz bUms, Partner p) {
		
		def suchName1 = p.name.toUpperCase().replace('Ü','UE').replace('Ä','AE').replace('Ö','OE')
		def suchName2 = p.name.toUpperCase().replace('Ü','U').replace('Ä','A').replace('Ö','O')
		def suchName3 = suchName2
		def suchName4 = suchName2
		if (suchName2.contains('-')) {
			suchName3=suchName2.split('-')[0]
			suchName4=suchName2.split('-')[1]
		}
		if (enthaelt(bUms.beguenstigterZahlungspflichtiger.toUpperCase(),suchName1) || enthaelt(bUms.verwendungszweck.toUpperCase(),suchName1)
		 || enthaelt(bUms.beguenstigterZahlungspflichtiger.toUpperCase(),suchName2) || enthaelt(bUms.verwendungszweck.toUpperCase(),suchName2)
		 || enthaelt(bUms.beguenstigterZahlungspflichtiger.toUpperCase(),suchName3) || enthaelt(bUms.verwendungszweck.toUpperCase(),suchName3)
		 || enthaelt(bUms.beguenstigterZahlungspflichtiger.toUpperCase(),suchName4) || enthaelt(bUms.verwendungszweck.toUpperCase(),suchName4)
			 )
			return true	
		else
			return false	
	}
	
	boolean enthaelt (String outer, String inner) {
		if (outer.contains(inner)) {
			def int i = outer.indexOf(inner)
			if (i == 0) return true
			else 
			if (outer.charAt(i-1) == ' ') return true
			else return false
		}
		else return false
	}
	
	boolean istOp (Zahlung z) {
		boolean retV = false
		z.mietvertrag.mietforderungen.each {OffenerPosten op ->
			if (z.betrag.abs() == op.betrag.abs())
			retV = true
		}
		retV
	}
	
	List <String> getVornamen (Partner p) {
		def vList = []		
		if (p instanceof Person) {
			Person person = (Person)p 
			vList << person.vorname
		}
		else {
			Organisation orga = (Organisation)p
			orga.aspaList.each {
				Person person = (Person)it
				vList << person.vorname
			}
		}
		vList
	}
}
