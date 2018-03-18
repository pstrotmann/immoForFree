package org.strotmann.immos

import org.springframework.dao.DataIntegrityViolationException

class BankverbindungController {
	
	def scaffold = true
	
	def list(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		[bankverbindungInstanceList: Bankverbindung.getBankverbindungen(), bankverbindungInstanceTotal: Bank.count()]
	}
	
	def show(Long id) {
		def bankverbindungInstance = Bankverbindung.get(id)
		flash.person = bankverbindungInstance.getPerson()
		flash.partner = bankverbindungInstance.partner
		if (!bankverbindungInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'bankverbindung.label', default: 'Bankverbindung'), id])
			redirect(action: "list")
			return
		}

		[bankverbindungInstance: bankverbindungInstance]
	}
	
	def create() {
		flash.partner = Partner.get(params.organisation?params.organisation.id:params.person.id)
        [bankverbindungInstance: new Bankverbindung(params)]
    }
	
	def edit(Long id) {
		def bankverbindungInstance = Bankverbindung.get(id)
		flash.person = bankverbindungInstance.getPerson()
		flash.partner = bankverbindungInstance.partner
		if (!bankverbindungInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'bankverbindung.label', default: 'Bankverbindung'), id])
			redirect(action: "list")
			return
		}
		[bankverbindungInstance: bankverbindungInstance]
	}
}
