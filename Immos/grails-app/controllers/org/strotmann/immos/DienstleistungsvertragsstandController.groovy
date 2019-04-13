package org.strotmann.immos

import org.springframework.dao.DataIntegrityViolationException

class DienstleistungsvertragsstandController {

    def scaffold = true
	
	def list(Integer max) {
		params.max = Math.min(max ?: 100, 1000)
		[dienstleistungsvertragsstandInstanceList: Dienstleistungsvertragsstand.list(), dienstleistungsvertragsstandInstanceTotal: Dienstleistungsvertragsstand.count()]
	}
}
