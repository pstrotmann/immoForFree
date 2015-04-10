package org.strotmann.immos

import org.springframework.dao.DataIntegrityViolationException

class ZwischenzaehlerController {

    def scaffold = true
	
	def edit(Long id) {
		def zwischenzaehlerInstance = Zwischenzaehler.get(id)
		flash.zwischenzaehler = zwischenzaehlerInstance
		if (!zwischenzaehlerInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'zwischenzaehler.label', default: 'Zwischenzaehler'), id])
			redirect(action: "list")
			return
		}

		[zwischenzaehlerInstance: zwischenzaehlerInstance, partnerrolleInstance: new Partnerrolle()]
	}
}
