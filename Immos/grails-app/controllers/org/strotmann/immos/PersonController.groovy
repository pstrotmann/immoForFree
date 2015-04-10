package org.strotmann.immos

import org.springframework.dao.DataIntegrityViolationException

class PersonController {
	
	def scaffold = true
	
	def list(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		[personInstanceList: Person.getPersonList (), personInstanceTotal: Person.getPersonList().count({})]
	}
	
    def edit(Long id) {
        def personInstance = Person.get(id)
		flash.partner = personInstance
		flash.rollenliste = Partnerrolle.getRollen()
        if (!personInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'person.label', default: 'Person'), id])
            redirect(action: "list")
            return
        }

        [personInstance: personInstance]
    }
	
	def toRolle(Long id) {
		def partnerrolleInstance = params.partnerrolleInstance
		flash.rolle = params.partnerrolleInstance.rolle
		flash.partner = Person.get(id)
		redirect(controller: "partnerrolle", action: "create")
		[partnerrolleInstance: partnerrolleInstance]
	}
}
