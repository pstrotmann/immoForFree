package org.strotmann.immos

import org.springframework.dao.DataIntegrityViolationException

class ImmobilieController {

    def scaffold = true
	
	def list(Integer max) {
		params.max = Math.min(max ?: 100, 1000)
		[immobilieInstanceList: Immobilie.immobilienUndSummen, immobilieInstanceTotal: Immobilie.count()]
	}
	
	def show(Long id) {
		def immobilieInstance = Immobilie.get(id)
		if (!immobilieInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'immobilie.label', default: 'Betriebskostenabrechung'), id])
			redirect(action: "list")
			return
		}
		flash.teilsummen = immobilieInstance.teilsummen
		[immobilieInstance: immobilieInstance]
	}
}
