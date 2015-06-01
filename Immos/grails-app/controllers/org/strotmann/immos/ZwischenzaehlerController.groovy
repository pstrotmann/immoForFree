package org.strotmann.immos

import org.springframework.dao.DataIntegrityViolationException

class ZwischenzaehlerController {

    def scaffold = true
	
	def create() {
		flash.immobilie = Immobilie.get(params.immobilie.id)
		respond new Zwischenzaehler(params)
	}
	
	def edit(Long id) {
		def zwischenzaehlerInstance = Zwischenzaehler.get(id)
		flash.zwischenzaehler = zwischenzaehlerInstance
		flash.zaehler = zwischenzaehlerInstance.zaehler
		if (!zwischenzaehlerInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'zwischenzaehler.label', default: 'Zwischenzaehler'), id])
			redirect(action: "list")
			return
		}

		[zwischenzaehlerInstance: zwischenzaehlerInstance]
	}
}
