package org.strotmann.immos



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class VerwendungController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Verwendung.list(params), model:[verwendungInstanceCount: Verwendung.count()]
    }

    def show(Verwendung verwendungInstance) {
        respond verwendungInstance
    }

    def create() {
        respond new Verwendung(params)
    }

    @Transactional
    def save(Verwendung verwendungInstance) {
        if (verwendungInstance == null) {
            notFound()
            return
        }

        if (verwendungInstance.hasErrors()) {
            respond verwendungInstance.errors, view:'create'
            return
        }

        verwendungInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'verwendung.label', default: 'Verwendung'), verwendungInstance.id])
                redirect verwendungInstance
            }
            '*' { respond verwendungInstance, [status: CREATED] }
        }
    }

    def edit(Verwendung verwendungInstance) {
        respond verwendungInstance
    }

    @Transactional
    def update(Verwendung verwendungInstance) {
        if (verwendungInstance == null) {
            notFound()
            return
        }

        if (verwendungInstance.hasErrors()) {
            respond verwendungInstance.errors, view:'edit'
            return
        }

        verwendungInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Verwendung.label', default: 'Verwendung'), verwendungInstance.id])
                redirect verwendungInstance
            }
            '*'{ respond verwendungInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Verwendung verwendungInstance) {

        if (verwendungInstance == null) {
            notFound()
            return
        }

        verwendungInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Verwendung.label', default: 'Verwendung'), verwendungInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'verwendung.label', default: 'Verwendung'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
