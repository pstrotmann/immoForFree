package org.strotmann.immos



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MietsacheController {

    def scaffold = true
	
	def list(Integer max) {
		params.max = Math.min(max ?: 100, 1000)
		[mietsacheInstanceList: Mietsache.mietsachen, mietsacheInstanceTotal: Mietsache.count()]
	}
}
