package org.strotmann.immos



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class UmlageinfoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
		params.max = Math.min(max ?: 100, 1000)
		respond model:[umlageinfoInstanceCount: Umlageinfo.count()]
    }

    def show(Umlageinfo umlageinfoInstance) {
        respond umlageinfoInstance
    }

    def create() {
		if (params.rechnung)
			flash.rechnung = Rechnung.get(params.rechnung.id)
		if (params.dienstleistungsvertrag)
			flash.dienstleistungsvertrag = Dienstleistungsvertrag.get(params.dienstleistungsvertrag.id)
		respond new Umlageinfo(params)
    }

    @Transactional
    def save(Umlageinfo umlageinfoInstance) {
		if (umlageinfoInstance == null) {
            notFound()
            return
        }

        if (umlageinfoInstance.hasErrors()) {
            respond umlageinfoInstance.errors, view:'create'
            return
        }

		umlageinfoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'umlageinfo.label', default: 'Umlageinfo'), umlageinfoInstance.id])
                redirect umlageinfoInstance
            }
            '*' { respond umlageinfoInstance, [status: CREATED] }
        }
    }

    def edit(Umlageinfo umlageinfoInstance) {
		flash.rechnung = umlageinfoInstance.rechnung
		flash.dienstleistungsvertrag = umlageinfoInstance.dienstleistungsvertrag
        respond umlageinfoInstance
    }

    @Transactional
    def update(Umlageinfo umlageinfoInstance) {
        if (umlageinfoInstance == null) {
            notFound()
            return
        }

        if (umlageinfoInstance.hasErrors()) {
            respond umlageinfoInstance.errors, view:'edit'
            return
        }

		umlageinfoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Umlageinfo.label', default: 'Umlageinfo'), umlageinfoInstance.id])
                redirect umlageinfoInstance
            }
            '*'{ respond umlageinfoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Umlageinfo umlageinfoInstance) {

        if (umlageinfoInstance == null) {
            notFound()
            return
        }

        umlageinfoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Umlageinfo.label', default: 'Umlageinfo'), umlageinfoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'umlageinfo.label', default: 'Umlageinfo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
