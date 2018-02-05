package org.strotmann.immos

import grails.transaction.Transactional;

import org.springframework.dao.DataIntegrityViolationException

class RechnungController {

    def scaffold = true
	
	def list(Integer max) {
		params.max = Math.min(max ?: 100, 1000)
		[rechnungInstanceList: Rechnung.getRechnungen(), rechnungInstanceTotal: Rechnung.count()]
	}
    
    def create() {
		flash.rolle1 = flash.rolle
		flash.partner1 = flash.partner
		def partnerrolleInstance = new Partnerrolle(rolle:flash.rolle, partner:flash.partner)
        [rechnungInstance: new Rechnung(params)]
    }

    def save() {
        def rechnungInstance = new Rechnung(params)
		if (flash.partner1)
		rechnungInstance.rechnungssteller = new Partnerrolle(rolle:flash.rolle1, partner:flash.partner1).save(flush: true)
		if (params.partner) {
			def partnerInstance = Partner.get(params.partner.id)
			rechnungInstance.rechnungssteller = new Partnerrolle(rolle:"Rechnungssteller", partner:partnerInstance).save(flush: true)
		}
		
        if (!rechnungInstance.save(flush: true)) {
            render(view: "create", model: [rechnungInstance: rechnungInstance])
            return
        }
		
		def partnerrolleInstance = Partnerrolle.get(rechnungInstance.rechnungssteller.id)
		partnerrolleInstance.rechnung = rechnungInstance
		partnerrolleInstance.save(flush: true)

        flash.message = message(code: 'default.created.message', args: [message(code: 'rechnung.label', default: 'Rechnung'), rechnungInstance.id])
        redirect(action: "show", id: rechnungInstance.id)
    }
	
	@Transactional
	def update(Rechnung rechnungInstance) {
		if (rechnungInstance == null) {
			notFound()
			return
		}

		if (rechnungInstance.hasErrors()) {
			respond rechnungInstance.errors, view:'edit'
			return
		}

		Partnerrolle rechnungssteller = rechnungInstance.rechnungssteller
		rechnungssteller.partner = Partner.get(params.partner.id)
		rechnungssteller.save flush:true
		
		rechnungInstance.rechnungssteller = rechnungssteller
		rechnungInstance.save flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.updated.message', args: [message(code: 'Rechnung.label', default: 'Rechnung'), rechnungInstance.id])
				redirect rechnungInstance
			}
			'*'{ respond rechnungInstance, [status: OK] }
		}
	}
	
	def delete(Rechnung rechnungInstance) {
		
		if (rechnungInstance == null) {
			notFound()
			return
		}

		def partnerrolleInstance = Partnerrolle.get(rechnungInstance.rechnungssteller.id)
		partnerrolleInstance.rechnung = null
		if(partnerrolleInstance.save())
			partnerrolleInstance.delete()
		else
			partnerrolleInstance.errors.each {
				println it
			}
		
		rechnungInstance.delete flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.deleted.message', args: [message(code: 'Rechnung.label', default: 'Rechnung'), rechnungInstance.id])
				redirect action:"index", method:"GET"
			}
			'*'{ render status: NO_CONTENT }
		}
	}
	
}
