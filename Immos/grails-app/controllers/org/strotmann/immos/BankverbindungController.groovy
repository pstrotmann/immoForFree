package org.strotmann.immos

import grails.transaction.Transactional;
import org.strotmann.util.IBAN

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
		
		bankverbindungInstance.iban = IBAN.ibanForm(bankverbindungInstance.iban)
		[bankverbindungInstance: bankverbindungInstance]
	}
	
	@Transactional
	def save(Bankverbindung bankverbindungInstance) {
		if (bankverbindungInstance == null) {
			notFound()
			return
		}

		if (bankverbindungInstance.hasErrors()) {
			respond bankverbindungInstance.errors, view:'create'
			return
		}

		bankverbindungInstance.iban = IBAN.ibanRein(bankverbindungInstance.iban)
		bankverbindungInstance.save flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.created.message', args: [message(code: 'bankverbindung.label', default: 'Bank'), bankverbindungInstance.id])
				redirect bankverbindungInstance
			}
			'*' { respond bankverbindungInstance, [status: CREATED] }
		}
	}

	@Transactional
	def update(Bankverbindung bankverbindungInstance) {
		if (bankverbindungInstance == null) {
			notFound()
			return
		}

		if (bankverbindungInstance.hasErrors()) {
			respond bankverbindungInstance.errors, view:'edit'
			return
		}

		bankverbindungInstance.iban = IBAN.ibanRein(bankverbindungInstance.iban)
		bankverbindungInstance.save flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.updated.message', args: [message(code: 'Bank.label', default: 'Bank'), bankverbindungInstance.id])
				redirect bankverbindungInstance
			}
			'*'{ respond bankverbindungInstance, [status: OK] }
		}
	}
}
