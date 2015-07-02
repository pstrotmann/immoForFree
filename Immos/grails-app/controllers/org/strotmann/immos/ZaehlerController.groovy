package org.strotmann.immos

import org.springframework.dao.DataIntegrityViolationException

class ZaehlerController {

    def scaffold = true
	
	def edit(Long id) {
		def zaehlerInstance = Zaehler.get(id)
		flash.zaehler = zaehlerInstance
		flash.immobilie = zaehlerInstance.immobilie
		if (!zaehlerInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'zaehler.label', default: 'Zaehler'), id])
			redirect(action: "list")
			return
		}

		[zaehlerInstance: zaehlerInstance]
	}
}
