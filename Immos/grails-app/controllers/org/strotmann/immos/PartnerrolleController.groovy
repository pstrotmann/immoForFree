package org.strotmann.immos

import org.springframework.dao.DataIntegrityViolationException

class PartnerrolleController {

    def scaffold = true
	
	def edit(Long id) {
		def partnerrolleInstance = Partnerrolle.get(id)
		flash.partner = partnerrolleInstance.partner
		flash.rolle = partnerrolleInstance.rolle
		
		if (!partnerrolleInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'partnerrolle.label', default: 'Partnerrolle'), id])
			redirect(action: "list")
			return
		}

		[partnerrolleInstance: partnerrolleInstance]
	}
}
