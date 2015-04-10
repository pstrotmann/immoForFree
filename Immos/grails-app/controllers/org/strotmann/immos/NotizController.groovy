package org.strotmann.immos



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class NotizController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
		params.max = Math.min(max ?: 100, 100)
		if (params.size() < 10)
        	respond Notiz.list(params), model:[notizInstanceCount: Notiz.count()]
		else
			respond Notiz.getMatches(params), model:[notizInstanceCount: Notiz.count()]
	}

    def show(Notiz notizInstance) {
        respond notizInstance
    }

    def create() {
		flash.referenz = params.keySet()[0]+':'+params[params.keySet()[0]]
		flash.domref = domRef (flash.referenz)
		flash.domName = params["domName"]
		respond new Notiz(params)
    }
	
	def find() {
		respond new Notiz(params)
	}
	
	@Transactional
    def save(Notiz notizInstance) {
        if (notizInstance == null) {
            notFound()
            return
        }

        if (notizInstance.hasErrors()) {
            respond notizInstance.errors, view:'create'
            return
        }

        notizInstance.save flush:true
		
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'notiz.label', default: 'Notiz'), notizInstance.id])
                redirect notizInstance
            }
            '*' { respond notizInstance, [status: CREATED] }
        }
    }

    def edit(Notiz notizInstance) {
        respond notizInstance
    }

    @Transactional
    def update(Notiz notizInstance) {
        if (notizInstance == null) {
            notFound()
            return
        }

        if (notizInstance.hasErrors()) {
            respond notizInstance.errors, view:'edit'
            return
        }

        notizInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Notiz.label', default: 'Notiz'), notizInstance.id])
                redirect notizInstance
            }
            '*'{ respond notizInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Notiz notizInstance) {

        if (notizInstance == null) {
            notFound()
            return
        }

        notizInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Notiz.label', default: 'Notiz'), notizInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'notiz.label', default: 'Notiz'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
	
	Object domRef (String s)	{
		if (!s.contains ("."))
			return null
		String domName = s.split("\\.id:")[0]
		long domKey = s.split(":")[1].toLong()
		switch(domName.toUpperCase()) {
			case "Dienstleistungsvertrag".toUpperCase() : return Dienstleistungsvertrag.get(domKey)
			case "Immobilie".toUpperCase() : return Immobilie.get(domKey)
			case "Kredit".toUpperCase() : return Kredit.get(domKey)
			case "Mietsache".toUpperCase() : return Mietsache.get(domKey)
			case "Mietvertrag".toUpperCase() : return Mietvertrag.get(domKey)
			case "Organisation".toUpperCase() : return Organisation.get(domKey)
			case "Person".toUpperCase() : return Person.get(domKey)
			case "Rechnung".toUpperCase() : return Rechnung.get(domKey)
		}
	}
}
