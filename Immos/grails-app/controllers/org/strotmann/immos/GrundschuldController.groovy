package org.strotmann.immos

import org.springframework.dao.DataIntegrityViolationException

class GrundschuldController {

    def scaffold = true
	
	def list(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		[grundschuldInstanceList: Grundschuld.getGrundschuldList (), grundschuldInstanceTotal: Grundschuld.getGrundschuldList ().count({})]
	}
}
