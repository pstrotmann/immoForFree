package org.strotmann.immos

import java.util.List;
import java.util.Properties;

class Organisation extends Partner {
	
	String nameZusatz = ''
	String rechtsform = ''
	String steuernummer = ''
	
	static mappedBy = [partnerrolle:'organisation']
	
	static hasMany = [postfachadresse:Postfachadresse]
	
	static constraints = {
		name(blank:false,size:1..80,matches:"[a-zäöüßA-ZÄÖÜ0-9\\- .&,()/+]+", unique:['nameZusatz','rechtsform'])
		nameZusatz (size:1..50,matches:"[a-zäöüßA-ZÄÖÜ0-9\\- .&,()+]+",nullable:true)
		rechtsform (inList:rechtsformen,nullable:true)
		hausadresse (nullable:true)
		steuernummer (nullable:true,matches:"[0-9\\/]+")
    }
	
	static List getMiniList () {
		return(Organisation.findAll("from Organisation as o order by o.name"))
	}
	
	static List getRechnungssteller () {
		return(Organisation.findAll("from Organisation as o"+
									" where not o.rechtsform = 'Personengemeinschaft'"+
									" and exists (from Partnerrolle as paro where paro.rolle = 'Rechnungssteller' and paro.partner =o.id)"+
									" order by o.name"
			))
	}
	
	List getAspaList () {
		def List paroList = Partnerrolle.findAll("from Partnerrolle as paro where paro.organisation = ${id} and paro.rolle = 'Ansprechpartner'")
		def pList = []
		paroList.each {def Partnerrolle paro = it
			pList << Partner.get(paro.partner.id)}
		return(pList)
	}
	
	static List getRechtsformen () {
		grails.util.Holders.config.rechtsform
	}
	
}
