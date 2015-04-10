package org.strotmann.immos

import org.springframework.dao.DataIntegrityViolationException

class DienstleistungsvertragController {

    def scaffold = true
	
	def list(Integer max) {
		params.max = Math.min(max ?: 100, 1000)
		[dienstleistungsvertragInstanceList: Dienstleistungsvertrag.getDienstleistungsvertraege(), dienstleistungsvertragInstanceTotal: Dienstleistungsvertrag.count()]
	}
    
    def create() {
		flash.rolle1 = flash.rolle
		flash.partner1 = flash.partner
		def partnerrolleInstance = new Partnerrolle(rolle:flash.rolle, partner:flash.partner)
        [dienstleistungsvertragInstance: new Dienstleistungsvertrag(params)]
    }

    def save() {
        def dienstleistungsvertragInstance = new Dienstleistungsvertrag(params)
		if (flash.partner1)
		dienstleistungsvertragInstance.dienstleister = new Partnerrolle(rolle:flash.rolle1, partner:flash.partner1).save(flush: true)
		if (params.partner) {
			def partnerInstance = Partner.get(params.partner.id)
			dienstleistungsvertragInstance.dienstleister = new Partnerrolle(rolle:"Dienstleister", partner:partnerInstance).save(flush: true)
		}
		
        if (!dienstleistungsvertragInstance.save(flush: true)) {
            render(view: "create", model: [dienstleistungsvertragInstance: dienstleistungsvertragInstance])
            return
        }
		
		def partnerrolleInstance = Partnerrolle.get(dienstleistungsvertragInstance.dienstleister.id)
		partnerrolleInstance.dienstleistungsvertrag = dienstleistungsvertragInstance
		partnerrolleInstance.save(flush: true)

        flash.message = message(code: 'default.created.message', args: [message(code: 'dienstleistungsvertrag.label', default: 'Dienstleistungsvertrag'), dienstleistungsvertragInstance.id])
        redirect(action: "show", id: dienstleistungsvertragInstance.id)
    }
}
