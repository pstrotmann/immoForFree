package org.strotmann.immos

import org.springframework.dao.DataIntegrityViolationException

class HausadresseController {

    def scaffold = true
	
	def list(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		[hausadresseInstanceList: Hausadresse.getMiniList(), hausadresseInstanceTotal: Hausadresse.getMiniList().count({})]
	}
	
	def create() {
		flash.crPartner = flash.partner
		[hausadresseInstance: new Hausadresse(params)]
	}
	
	def save() {
		flash.partner = flash.crPartner
		if (flash.partner instanceof Person)
			flash.person = flash.partner
		else
			flash.organisation = flash.partner;
		def hausadresseInstance = new Hausadresse(params)
		if (!hausadresseInstance.save(flush: true)) {
			render(view: "create", model: [hausadresseInstance: hausadresseInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [message(code: 'hausadresse.label', default: 'Hausadresse'), hausadresseInstance.id])
		redirect(action: "show", id: hausadresseInstance.id)
	}
}
