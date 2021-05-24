package org.strotmann.immos

import org.springframework.dao.DataIntegrityViolationException

class OrganisationController {
	
	def scaffold = true

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [organisationInstanceList: Organisation.getMiniList(), organisationInstanceTotal: Organisation.getMiniList().count({})]
    }

    def edit(Long id) {
        def organisationInstance = Organisation.get(id)
		flash.partner = organisationInstance
		flash.rollenliste = Partnerrolle.getRollen()
        if (!organisationInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'organisation.label', default: 'Organisation'), id])
            redirect(action: "list")
            return
        }

        [organisationInstance: organisationInstance, partnerrolleInstance: new Partnerrolle()]
    }
	
	def toRolle(Long id) {
		def partnerrolleInstance = params.partnerrolleInstance
		flash.rolle = params.partnerrolleInstance.rolle
		flash.partner = Organisation.get(id)
		partnerrolleInstance.partner = flash.partner
		flash.partnerrolleInstance = partnerrolleInstance
		redirect(controller: grails.util.Holders.config.rolle[flash.rolle], action: "create")
		[partnerrolleInstance: partnerrolleInstance]
	}
}