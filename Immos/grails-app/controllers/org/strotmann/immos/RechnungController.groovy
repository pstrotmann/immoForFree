package org.strotmann.immos

import grails.transaction.Transactional;
import org.strotmann.util.*

import org.springframework.dao.DataIntegrityViolationException

class RechnungController {

    def scaffold = true
	
	def list(Integer max) {
		session.umlSelektors = [new UmlageSel(1,'ja'), new UmlageSel(2,'nein')]
		session.jahrSelektors = []
		for(i in 0..10)
		session.jahrSelektors << new JahrSel(i,Datum.aktJahr+1-i)
		params.max = Math.min(max ?: 1000, 10000)
		def List <Rechnung> rechnungen
		if (session.immobilie || session.umlage || session.reJahr) {
			rechnungen = Rechnung.getRechnungen(session.immobilie, session.umlage, session.reJahr)
			[rechnungInstanceList: rechnungen, rechnungInstanceTotal: rechnungen.size()]	
		}		
		else
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
		def Partnerrolle recycle = Partnerrolle.nullRolle
		if (flash.partner1)
			rechnungInstance.rechnungssteller = new Partnerrolle(rolle:flash.rolle1, partner:flash.partner1).save(flush: true)
		if (params.partner) {
			def partnerInstance = Partner.get(params.partner.id)
			if (recycle) {
				recycle.rolle = "Rechnungssteller"
				recycle.partner = partnerInstance
				rechnungInstance.rechnungssteller = recycle.save(flush: true)
			}
			else
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
	
	def setSelKrit () {
		session.immobilie = params.immobilie.id == 'null'?null:Immobilie.get(params.immobilie.id)
		session.umlage = params.umlageSel.id == 'null'?null:UmlageSel.getUmlage(session.umlSelektors, params.umlageSel.id)
		session.reJahr = params.jahrSel.id == 'null'?null:JahrSel.getJahr(session.jahrSelektors, params.jahrSel.id)
		
		def dummy = null
		redirect(uri: "/rechnung/list")
	}
	
}
