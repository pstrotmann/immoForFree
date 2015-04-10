package org.strotmann.immos

import org.springframework.dao.DataIntegrityViolationException

class PostfachadresseController {

    def scaffold = true
	
	def create() {
		flash.partner = Partner.get(params.organisation.id)
		[postfachadresseInstance: new Postfachadresse(params)]
	}
	
}
