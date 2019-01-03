package org.strotmann.immos

import org.springframework.dao.DataIntegrityViolationException

class BankumsatzController {

    def scaffold = true

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
		[bankumsatzInstanceList: Bankumsatz.getUmsaetze(), bankumsatzInstanceTotal: Bankumsatz.count()]
	}
	
	def listOffen(Integer max) {
		def int jahr 
		if (params.jahr)
			jahr = params.jahr.toString().toInteger()
		else {
			Calendar calendar = Calendar.getInstance()
			calendar.setTime(new Date())
			jahr = calendar.get(Calendar.YEAR)
		}
		params.max = Math.min(max ?: 10, 100)
		render (view:"list", model:[bankumsatzInstanceList: Bankumsatz.getOffeneUmsaetze(jahr)])
	}
	
	def listZugeordnet(Integer max) {
		def int jahr
		if (params.jahr)
			jahr = params.jahr.toString().toInteger()
		else {
			Calendar calendar = Calendar.getInstance()
			calendar.setTime(new Date())
			jahr = calendar.get(Calendar.YEAR)
		}
		params.max = Math.min(max ?: 10, 100)
		render (view:"list", model:[bankumsatzInstanceList: Bankumsatz.getZugeordneteUmsaetze(jahr)])
	}
}
