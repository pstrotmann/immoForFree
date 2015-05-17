package org.strotmann.immos

import org.springframework.dao.DataIntegrityViolationException

class ZwischenzaehlerstandController {

    def scaffold = true

	def create() {
		flash.zwischenzaehler = Zwischenzaehler.get(params.zwischenzaehler.id)
		respond new Zwischenzaehlerstand(params)
	}
	
	def edit(Long id) {
		def zwischenzaehlerstandInstance = Zwischenzaehlerstand.get(id)
		flash.zwischenzaehlerstand = zwischenzaehlerstandInstance
		flash.zwischenzaehler = zwischenzaehlerstandInstance.zz
		[zwischenzaehlerstandInstance: zwischenzaehlerstandInstance]
	}
	
	def show(Long id) {
        def zwischenzaehlerstandInstance = Zwischenzaehlerstand.get(id)
		flash.zwischenzaehler = zwischenzaehlerstandInstance.zz
        if (!zwischenzaehlerstandInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'zwischenzaehlerstand.label', default: 'Zwischenzaehlerstand'), id])
            redirect(action: "list")
            return
        }

        [zwischenzaehlerstandInstance: zwischenzaehlerstandInstance]
    }
}
