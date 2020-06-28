package org.strotmann.immos

import org.springframework.dao.DataIntegrityViolationException

class KreditController {

    def scaffold = true
	
	def list(Integer max) {
		params.max = Math.min(max ?: 100, 1000)
		//[kreditInstanceList: Kredit.kredite, kreditInstanceTotal: Kredit.count()]
		[kreditInstanceList: Kredit.krediteUndSummen, kreditInstanceTotal: Kredit.count()]
	}
    
    def create() {
		flash.rolle1 = flash.rolle
		flash.partner1 = flash.partner
		def partnerrolleInstance = new Partnerrolle(rolle:flash.rolle, partner:flash.partner)
        [kreditInstance: new Kredit(params)]
    }

    def save() {
        def kreditInstance = new Kredit(params)
		if (flash.partner1)
		kreditInstance.kreditgeber = new Partnerrolle(rolle:flash.rolle1, partner:flash.partner1).save()
		if (params.partner) {
			def partnerInstance = Partner.get(params.partner.id)
			kreditInstance.kreditgeber = new Partnerrolle(rolle:"Kreditgeber", partner:partnerInstance).save()
		}
		
        if (!kreditInstance.save(flush: true)) {
            render(view: "create", model: [kreditInstance: kreditInstance])
            return
        }
		
		def partnerrolleInstance = Partnerrolle.get(kreditInstance.kreditgeber.id)
		partnerrolleInstance.kredit = kreditInstance
		partnerrolleInstance.save()

        flash.message = message(code: 'default.created.message', args: [message(code: 'kredit.label', default: 'Kredit'), kreditInstance.id])
        redirect(action: "show", id: kreditInstance.id)
    }
	
	def krSum() {
		render sum(0)
	}
	
	def spkSum() {
		render sum(2)
	}
	
	def wueSum() {
		render sum(3)
	}
	
	String sum (int i) {
		Kredit.krediteUndSummen.summen[i].toString().replace('.', ',')
	}
}
