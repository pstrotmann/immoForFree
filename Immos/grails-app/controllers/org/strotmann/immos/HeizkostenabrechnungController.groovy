package org.strotmann.immos



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class HeizkostenabrechnungController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Heizkostenabrechnung.list(params), model:[heizkostenabrechnungInstanceCount: Heizkostenabrechnung.count()]
    }

    def show(Heizkostenabrechnung heizkostenabrechnungInstance) {
        respond heizkostenabrechnungInstance
    }

    def create() {
        respond new Heizkostenabrechnung(params)
    }

    @Transactional
    def save(Heizkostenabrechnung heizkostenabrechnungInstance) {
        if (heizkostenabrechnungInstance == null) {
            notFound()
            return
        }

        if (heizkostenabrechnungInstance.hasErrors()) {
            respond heizkostenabrechnungInstance.errors, view:'create'
            return
        }

        heizkostenabrechnungInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'heizkostenabrechnung.label', default: 'Heizkostenabrechnung'), heizkostenabrechnungInstance.id])
                redirect heizkostenabrechnungInstance
            }
            '*' { respond heizkostenabrechnungInstance, [status: CREATED] }
        }
    }

    def edit(Heizkostenabrechnung heizkostenabrechnungInstance) {
        respond heizkostenabrechnungInstance
    }

    @Transactional
    def update(Heizkostenabrechnung heizkostenabrechnungInstance) {
        if (heizkostenabrechnungInstance == null) {
            notFound()
            return
        }

        if (heizkostenabrechnungInstance.hasErrors()) {
            respond heizkostenabrechnungInstance.errors, view:'edit'
            return
        }

        heizkostenabrechnungInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Heizkostenabrechnung.label', default: 'Heizkostenabrechnung'), heizkostenabrechnungInstance.id])
                redirect heizkostenabrechnungInstance
            }
            '*'{ respond heizkostenabrechnungInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Heizkostenabrechnung heizkostenabrechnungInstance) {

        if (heizkostenabrechnungInstance == null) {
            notFound()
            return
        }

        heizkostenabrechnungInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Heizkostenabrechnung.label', default: 'Heizkostenabrechnung'), heizkostenabrechnungInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'heizkostenabrechnung.label', default: 'Heizkostenabrechnung'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
