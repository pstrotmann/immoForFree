package org.strotmann.immos

import org.springframework.dao.DataIntegrityViolationException

class ZaehlerstandController {
    
	def scaffold = true
	
	def create() {
		flash.zaehler = Zaehler.get(params.zaehler.id)
		respond new Zaehlerstand(params)
	}
	
	def edit(Long id) {
		def zaehlerstandInstance = Zaehlerstand.get(id)
		flash.zaehlerstand = zaehlerstandInstance
		[zaehlerstandInstance: zaehlerstandInstance]
	}
	
	def show(Long id) {
        def zaehlerstandInstance = Zaehlerstand.get(id)
		flash.zaehler = zaehlerstandInstance.z
        if (!zaehlerstandInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'zaehlerstand.label', default: 'Zaehlerstand'), id])
            redirect(action: "list")
            return
        }

        [zaehlerstandInstance: zaehlerstandInstance]
    }
}
