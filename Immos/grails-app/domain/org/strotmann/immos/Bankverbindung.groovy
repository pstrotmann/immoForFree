package org.strotmann.immos

import org.apache.commons.validator.routines.checkdigit.IBANCheckDigit
import org.strotmann.util.IBAN

class Bankverbindung {
	
	String iban
	String bic //macht die Bankfilliale eindeutig, blz aus IBAN reicht nicht
	
	static belongsTo = [partner:Partner]
	
	static mapping = {
		iban column: "iban", index: "iban"
	}
	
    static constraints = {
		iban(size: 22..22,
			 validator: {String val -> if(!checkIBAN(val)) return "Fehler"}
			 )
		bic(size: 11..11,nullable:true,
			validator: {String val, obj -> if(!checkBIC(val,obj.iban)) return "Fehler"}
			 )
    }
	
	String toString() {"Iban: ${IBAN.ibanForm(this.iban)} BIC: ${this.getBIC()}"}
	
	static boolean checkIBAN (String iban) {
		return new IBANCheckDigit().isValid(iban)
	}
	
	static boolean checkBIC (String bic,iban) {
		if (bic == null)
			return true
		Map bkMap = Bank.bankdaten(null,bic)
		String blz = bkMap["blz"]
		if(blz == iban.substring(4, 12))
			return true
		else
			return false
	}
	
	String getBlz () {
		return this.iban.substring(4, 12)
	}
	
	String getKtoNr () {
		return this.iban.substring(12, 22)
	}
	
	String getBIC () {
		if(this.bic)
			return this.bic
		else
			if (this.iban)
				return Bank.bankdaten(this.iban.substring(4, 12).toInteger(),null)["bic"]
			else
				return ""
	}
	
	String getNameUndAdresse () {
		Map bkMap
		if(this.bic)
			bkMap = Bank.bankdaten(null,bic)
		else
			bkMap = Bank.bankdaten(this.iban.substring(4, 12).toInteger(),null)
			
		bkMap["bankname"]+','+bkMap["plz"]+' '+bkMap["ort"]
	}
	
	Person getPerson () {
		def p
		try {
			p = Person.get(this.partner.id)
		} catch (Exception e) {
		}
		return (p?:null)
	}
	
	Integer getBankId () {
		Bank.getBankId(this.iban.substring(4,12).toInteger())
	}
	
}
