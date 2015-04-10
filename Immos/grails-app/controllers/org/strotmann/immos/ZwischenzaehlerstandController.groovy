package org.strotmann.immos

import org.springframework.dao.DataIntegrityViolationException

class ZwischenzaehlerstandController {

    def scaffold = true

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
