package org.strotmann.immos



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class KostenartController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Kostenart.list(params), model:[kostenartInstanceCount: Kostenart.count()]
    }

    def show(Kostenart kostenartInstance) {
        respond kostenartInstance
    }

    def create() {
        respond new Kostenart(params)
    }

    @Transactional
    def save(Kostenart kostenartInstance) {
        if (kostenartInstance == null) {
            notFound()
            return
        }

        if (kostenartInstance.hasErrors()) {
            respond kostenartInstance.errors, view:'create'
            return
        }

        kostenartInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'kostenart.label', default: 'Kostenart'), kostenartInstance.id])
                redirect kostenartInstance
            }
            '*' { respond kostenartInstance, [status: CREATED] }
        }
    }

    def edit(Kostenart kostenartInstance) {
        respond kostenartInstance
    }

    @Transactional
    def update(Kostenart kostenartInstance) {
        if (kostenartInstance == null) {
            notFound()
            return
        }

        if (kostenartInstance.hasErrors()) {
            respond kostenartInstance.errors, view:'edit'
            return
        }

        kostenartInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Kostenart.label', default: 'Kostenart'), kostenartInstance.id])
                redirect kostenartInstance
            }
            '*'{ respond kostenartInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Kostenart kostenartInstance) {

        if (kostenartInstance == null) {
            notFound()
            return
        }

        kostenartInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Kostenart.label', default: 'Kostenart'), kostenartInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'kostenart.label', default: 'Kostenart'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
