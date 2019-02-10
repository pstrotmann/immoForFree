package org.strotmann.immos

import org.springframework.dao.DataIntegrityViolationException
import org.strotmann.util.*

class BankumsatzController {

    def scaffold = true

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
		[bankumsatzInstanceList: Bankumsatz.getUmsaetze(), bankumsatzInstanceTotal: Bankumsatz.count()]
	}
	
	def listOffen(Integer max) {
		def int jahr 
		if (session.jahr)
			jahr = session.jahr
		else
			jahr = Datum.aktJahr
		params.max = Math.min(max ?: 10, 100)
		render (view:"list", model:[bankumsatzInstanceList: Bankumsatz.getOffeneUmsaetze(jahr)])
	}
	
	def listZugeordnet(Integer max) {
		def int jahr
		if (session.jahr)
			jahr = session.jahr
		else
			jahr = Datum.aktJahr
		params.max = Math.min(max ?: 10, 100)
		render (view:"list", model:[bankumsatzInstanceList: Bankumsatz.getZugeordneteUmsaetze(jahr)])
	}
}
