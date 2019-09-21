package org.strotmann.immos



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class BesicherungController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Besicherung.list(params), model:[besicherungInstanceCount: Besicherung.count()]
    }

    def show(Besicherung besicherungInstance) {
        respond besicherungInstance
    }

    def create() {
        respond new Besicherung(params)
    }

    @Transactional
    def save(Besicherung besicherungInstance) {
        if (besicherungInstance == null) {
            notFound()
            return
        }

        if (besicherungInstance.hasErrors()) {
            respond besicherungInstance.errors, view:'create'
            return
        }

        besicherungInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'besicherung.label', default: 'Besicherung'), besicherungInstance.id])
                redirect besicherungInstance
            }
            '*' { respond besicherungInstance, [status: CREATED] }
        }
    }

    def edit(Besicherung besicherungInstance) {
        respond besicherungInstance
    }

    @Transactional
    def update(Besicherung besicherungInstance) {
        if (besicherungInstance == null) {
            notFound()
            return
        }

        if (besicherungInstance.hasErrors()) {
            respond besicherungInstance.errors, view:'edit'
            return
        }

        besicherungInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Besicherung.label', default: 'Besicherung'), besicherungInstance.id])
                redirect besicherungInstance
            }
            '*'{ respond besicherungInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Besicherung besicherungInstance) {

        if (besicherungInstance == null) {
            notFound()
            return
        }

        besicherungInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Besicherung.label', default: 'Besicherung'), besicherungInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'besicherung.label', default: 'Besicherung'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
