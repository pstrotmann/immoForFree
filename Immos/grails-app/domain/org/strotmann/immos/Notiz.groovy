package org.strotmann.immos

import java.util.Date;
import java.util.List;
import java.util.Map;

import grails.util.Holders
import grails.plugins.rest.client.*

class Notiz {

	Date anlagetermin
	Date wiedervorlagetermin
	String notiztext
	String referenz
		
	static constraints = {
    }
	
	String toString() {"${this.notiztext}"}
	
	long getRefId() {
		referenz.split(":")[1].split(" ")[0].toLong()
	}
	
	String getRefDomain() {
		referenz.split("\\.")[0].toUpperCase()
	}
	
	boolean refDomIs (String domName) {
		referenz.split("\\.")[0].toUpperCase() == domName.toUpperCase()
	}
	
	static List getMatches(Map params) { 
		params.notiztext = '%'+params.notiztext+'%'
		params.referenz = params.referenz+'%'
		String anlOp = params.notizInstance.anlOp
		String wvOp = params.notizInstance.wvOp
		Date wiedervorlage = params.wiedervorlagetermin
		Date anlage = params.anlagetermin
		def opMap = [ '<': 'lt', '<=': 'lte', '=': 'eq', '>': 'gt', '>=': 'gte' ]
		def c = Notiz.createCriteria()
		c.list {
			if (anlOp in opMap.keySet())
				"${opMap[anlOp]}"("anlagetermin", anlage)
			ilike("notiztext", params.notiztext)
			ilike("referenz", params.referenz)
			if (wvOp in opMap.keySet())
				"${opMap[wvOp]}"("wiedervorlagetermin", wiedervorlage)
		}
	}
	
	static List getRefs(String domName) {
		List refList = []
		List l
		if (domName && domName != ' ') {
			switch(domName){
				case "Dienstleistungsvertrag" : l = Dienstleistungsvertrag.findAll("from Dienstleistungsvertrag as x order by x.id") ; break
				case "Immobilie" : l = Immobilie.findAll("from Immobilie as x order by x.id") ; break
				case "Kredit" : l = Kredit.findAll("from Kredit as x order by x.id") ; break
				case "Mietsache" : l = Mietsache.findAll("from Mietsache as x order by x.id") ; break
				case "Mietvertrag" : l = Mietvertrag.findAll("from Mietvertrag as x order by x.id") ; break
				case "Organisation" : l = Organisation.findAll("from Organisation as x order by x.name") ; break
				case "Person" : l = Person.findAll("from Person as x order by x.name") ; break
				case "Rechnung" : l = Rechnung.findAll("from Rechnung as x order by x.rechnungsdatum") ; break
			}
			l.each {item -> refList << "${domName}.id:${item.id} ${item.toString()}"}
		}
		else {
			l = Dienstleistungsvertrag.findAll("from Dienstleistungsvertrag as i order by i.id")
			l.each {item -> refList << "Dienstleistungsvertrag.id:${item.id} ${item.toString()}"}
			l = Immobilie.findAll("from Immobilie as i order by i.id")
			l.each {item -> refList << "Immobilie.id:${item.id} ${item.toString()}"}
			l = Kredit.findAll("from Kredit as i order by i.id")
			l.each {item -> refList << "Kredit.id:${item.id} ${item.toString()}"}
			l = Mietsache.findAll("from Mietsache as i order by i.id")
			l.each {item -> refList << "Mietsache.id:${item.id} ${item.toString()}"}
			l = Mietvertrag.findAll("from Mietvertrag as i order by i.id")
			l.each {item -> refList << "Mietvertrag.id:${item.id} ${item.toString()}"}
			l = Organisation.findAll("from Organisation as o order by o.name")
			l.each {item -> refList << "Organisation.id:${item.id} ${item.toString()}"}
			l = Person.findAll("from Person as p order by p.name")
			l.each {item -> refList << "Person.id:${item.id} ${item.toString()}"}
			l = Rechnung.findAll("from Rechnung as i order by i.rechnungsdatum")
			l.each {item -> refList << "Rechnung.id:${item.id} ${item.toString()}"}
			
		}
		refList
	}
	
	static List getDomNamen () {
		grails.util.Holders.config.domname
	}
	
	static List <Notiz> getNotizen (String domName, Object id) {
		if (id == null)
			return []
		String r = "${domName}.id:${id.toString()} %"
		def c = Notiz.createCriteria()
		c.list {
			ilike("referenz",  "${r}")
		}
	}
}
