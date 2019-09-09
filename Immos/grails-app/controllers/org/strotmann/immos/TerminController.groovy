package org.strotmann.immos



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TerminController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Termin.list(params), model:[terminInstanceCount: Termin.count()]
    }

    def show(Termin terminInstance) {
        respond terminInstance
    }

    def create() {
        respond new Termin(params)
    }

    @Transactional
    def save(Termin terminInstance) {
        if (terminInstance == null) {
            notFound()
            return
        }

        if (terminInstance.hasErrors()) {
            respond terminInstance.errors, view:'create'
            return
        }

        terminInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'termin.label', default: 'Termin'), terminInstance.id])
                redirect terminInstance
            }
            '*' { respond terminInstance, [status: CREATED] }
        }
    }

    def edit(Termin terminInstance) {
		respond terminInstance
    }

    @Transactional
    def update(Termin terminInstance) {
        if (terminInstance == null) {
            notFound()
            return
        }

        if (terminInstance.hasErrors()) {
            respond terminInstance.errors, view:'edit'
            return
        }

        terminInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Termin.label', default: 'Termin'), terminInstance.id])
                redirect terminInstance
            }
            '*'{ respond terminInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Termin terminInstance) {

        if (terminInstance == null) {
            notFound()
            return
        }

        terminInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Termin.label', default: 'Termin'), terminInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'termin.label', default: 'Termin'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
