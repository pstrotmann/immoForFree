package org.strotmann.immos

class MietvertragsstandController {

    def scaffold = true
	
	def list(Integer max) {
		params.max = Math.min(max ?: 100, 1000)
		[mietvertragsstandInstanceList: Mietvertragsstand.staende, mietvertragsstandInstanceTotal: Mietvertragsstand.count()]
	}
}
