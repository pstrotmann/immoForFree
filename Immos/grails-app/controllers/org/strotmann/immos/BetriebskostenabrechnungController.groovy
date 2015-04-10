package org.strotmann.immos



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class BetriebskostenabrechnungController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Betriebskostenabrechnung.list(params), model:[betriebskostenabrechnungInstanceCount: Betriebskostenabrechnung.count()]
    }

    def show(Betriebskostenabrechnung betriebskostenabrechnungInstance) {
        respond betriebskostenabrechnungInstance
    }

    def create() {
        respond new Betriebskostenabrechnung(params)
    }

    @Transactional
    def save(Betriebskostenabrechnung betriebskostenabrechnungInstance) {
        if (betriebskostenabrechnungInstance == null) {
            notFound()
            return
        }

        if (betriebskostenabrechnungInstance.hasErrors()) {
            respond betriebskostenabrechnungInstance.errors, view:'create'
            return
        }

        betriebskostenabrechnungInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'betriebskostenabrechnung.label', default: 'Betriebskostenabrechnung'), betriebskostenabrechnungInstance.id])
                redirect betriebskostenabrechnungInstance
            }
            '*' { respond betriebskostenabrechnungInstance, [status: CREATED] }
        }
    }

    def edit(Betriebskostenabrechnung betriebskostenabrechnungInstance) {
        respond betriebskostenabrechnungInstance
    }

    @Transactional
    def update(Betriebskostenabrechnung betriebskostenabrechnungInstance) {
        if (betriebskostenabrechnungInstance == null) {
            notFound()
            return
        }

        if (betriebskostenabrechnungInstance.hasErrors()) {
            respond betriebskostenabrechnungInstance.errors, view:'edit'
            return
        }

        betriebskostenabrechnungInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Betriebskostenabrechnung.label', default: 'Betriebskostenabrechnung'), betriebskostenabrechnungInstance.id])
                redirect betriebskostenabrechnungInstance
            }
            '*'{ respond betriebskostenabrechnungInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Betriebskostenabrechnung betriebskostenabrechnungInstance) {

        if (betriebskostenabrechnungInstance == null) {
            notFound()
            return
        }

        betriebskostenabrechnungInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Betriebskostenabrechnung.label', default: 'Betriebskostenabrechnung'), betriebskostenabrechnungInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'betriebskostenabrechnung.label', default: 'Betriebskostenabrechnung'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
