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
	
	def update(Long id, Long version) {
		def immobilieInstance = Immobilie.get(id)
		if (!immobilieInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'immobilie.label', default: 'Immobilie'), id])
			redirect(action: "list")
			return
		}

		if (version != null) {
			if (immobilieInstance.version > version) {
				immobilieInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						  [message(code: 'immobilie.label', default: 'Immobilie')] as Object[],
						  "Another user has updated this Immobilie while you were editing")
				render(view: "edit", model: [immobilieInstance: immobilieInstance])
				return
			}
		}

		immobilieInstance.properties = params

		if (!immobilieInstance.save(flush: true)) {
			render(view: "edit", model: [immobilieInstance: immobilieInstance])
			return
		}

		flash.message = message(code: 'default.updated.message', args: [message(code: 'immobilie.label', default: 'Immobilie'), immobilieInstance.id])
		redirect(action: "show", id: immobilieInstance.id)
	}
	
	def immoSum() {render sum()}
	
	String sum () {
		String s = Immobilie.immobilienUndSummen.sumVerkauf.toString().replace('.', ',')
	}
	
}
