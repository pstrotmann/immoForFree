package org.strotmann.immos

import org.springframework.dao.DataIntegrityViolationException

class KreditstandController {
	def scaffold = true
	
	def list(Integer max) {
		params.max = Math.min(max ?: 100, 1000)
		[kreditstandInstanceList: Kreditstand.staende, kreditstandInstanceTotal: Kreditstand.count()]
	}
}
