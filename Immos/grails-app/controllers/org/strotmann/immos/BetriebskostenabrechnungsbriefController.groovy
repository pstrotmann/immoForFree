package org.strotmann.immos



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class BetriebskostenabrechnungsbriefController {

	def pdfRenderingService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Betriebskostenabrechnungsbrief.list(params), model:[betriebskostenabrechnungsbriefInstanceCount: Betriebskostenabrechnungsbrief.count()]
    }

    def show(Betriebskostenabrechnungsbrief betriebskostenabrechnungsbriefInstance) {
        respond betriebskostenabrechnungsbriefInstance
    }

    def create() {
        respond new Betriebskostenabrechnungsbrief(params)
    }

    @Transactional
    def save(Betriebskostenabrechnungsbrief betriebskostenabrechnungsbriefInstance) {
        if (betriebskostenabrechnungsbriefInstance == null) {
            notFound()
            return
        }

        if (betriebskostenabrechnungsbriefInstance.hasErrors()) {
            respond betriebskostenabrechnungsbriefInstance.errors, view:'create'
            return
        }

        betriebskostenabrechnungsbriefInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'betriebskostenabrechnungsbrief.label', default: 'Betriebskostenabrechnungsbrief'), betriebskostenabrechnungsbriefInstance.id])
                redirect betriebskostenabrechnungsbriefInstance
            }
            '*' { respond betriebskostenabrechnungsbriefInstance, [status: CREATED] }
        }
    }

    def edit(Betriebskostenabrechnungsbrief betriebskostenabrechnungsbriefInstance) {
        respond betriebskostenabrechnungsbriefInstance
    }

    @Transactional
    def update(Betriebskostenabrechnungsbrief betriebskostenabrechnungsbriefInstance) {
        if (betriebskostenabrechnungsbriefInstance == null) {
            notFound()
            return
        }

        if (betriebskostenabrechnungsbriefInstance.hasErrors()) {
            respond betriebskostenabrechnungsbriefInstance.errors, view:'edit'
            return
        }

        betriebskostenabrechnungsbriefInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Betriebskostenabrechnungsbrief.label', default: 'Betriebskostenabrechnungsbrief'), betriebskostenabrechnungsbriefInstance.id])
                redirect betriebskostenabrechnungsbriefInstance
            }
            '*'{ respond betriebskostenabrechnungsbriefInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Betriebskostenabrechnungsbrief betriebskostenabrechnungsbriefInstance) {

        if (betriebskostenabrechnungsbriefInstance == null) {
            notFound()
            return
        }

        betriebskostenabrechnungsbriefInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Betriebskostenabrechnungsbrief.label', default: 'Betriebskostenabrechnungsbrief'), betriebskostenabrechnungsbriefInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'betriebskostenabrechnungsbrief.label', default: 'Betriebskostenabrechnungsbrief'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
	
	def renderFormPDF(){
		def formInstance = Betriebskostenabrechnungsbrief.get(params.id)
		def args = [template:"pdf", model:[form:formInstance]]
		pdfRenderingService.render(args+[controller:this],response)
	}
}
