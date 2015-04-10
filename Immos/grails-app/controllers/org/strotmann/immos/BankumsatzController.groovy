package org.strotmann.immos

import org.springframework.dao.DataIntegrityViolationException

class BankumsatzController {

    def scaffold = true

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
		[bankumsatzInstanceList: Bankumsatz.getUmsaetze(), bankumsatzInstanceTotal: Bankumsatz.count()]
	}
	
	def listOffen(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		render (view:"list", model:[bankumsatzInstanceList: Bankumsatz.getOffeneUmsaetze()])
	}
	
	def listZugeordnet(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		render (view:"list", model:[bankumsatzInstanceList: Bankumsatz.getZugeordneteUmsaetze()])
	}
}
