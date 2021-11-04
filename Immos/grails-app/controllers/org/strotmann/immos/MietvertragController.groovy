package org.strotmann.immos

import org.springframework.dao.DataIntegrityViolationException

class MietvertragController {

    def scaffold = true
	
	def list(Integer max) {
        params.max = Math.min(max ?: 100, 1000)
		flash.sumSaldo = Mietvertrag.sumSaldo
        [mietvertragInstanceList: Mietvertrag.mietvertraegeUndSummen, mietvertragInstanceTotal: Mietvertrag.count()]
    }
    
    def create() {
		flash.rolle1 = flash.rolle
		flash.partner1 = flash.partner
		flash.create = "true"
		def partnerrolleInstance = new Partnerrolle(rolle:flash.rolle, partner:flash.partner)
        [mietvertragInstance: new Mietvertrag(params)]
    }

    def save() {
        def mietvertragInstance = new Mietvertrag(params)
		if (flash.partner1)
		    mietvertragInstance.mieter = new Partnerrolle(rolle:flash.rolle1, partner:flash.partner1, mietvertrag:mietvertragInstance).save()
		if (params.partner) {
			def partnerInstance = Partner.get(params.partner.id)
			mietvertragInstance.mieter = new Partnerrolle(rolle:"Mieter", partner:partnerInstance, mietvertrag:mietvertragInstance).save()
		}
		
        if (!mietvertragInstance.save(flush: true)) {
            render(view: "create", model: [mietvertragInstance: mietvertragInstance])
            return
        }
		
		def partnerrolleInstance = Partnerrolle.get(mietvertragInstance.mieter.id)
		partnerrolleInstance.mietvertrag = mietvertragInstance
		partnerrolleInstance.save()

        flash.message = message(code: 'default.created.message', args: [message(code: 'mietvertrag.label', default: 'Mietvertrag'), mietvertragInstance.id])
        redirect(action: "show", id: mietvertragInstance.id)
    }
}
