package org.strotmann.immos

import org.springframework.dao.DataIntegrityViolationException

class ImmoabrechnungController {

	def scaffold = true
	
	def list(Integer max) {
		params.max = Math.min(max ?: 100, 1000)
		[immoabrechnungInstanceList: Immoabrechnung.list(params), immoabrechnungInstanceTotal: Immoabrechnung.count()]
	}
	
	def show(Long id) {
		def immoabrechnungInstance = Immoabrechnung.get(id)
		if (!immoabrechnungInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'immoabrechnung.label', default: 'Immoabrechnung'), id])
			redirect(action: "list")
			return
		}
		flash.id = id
		[immoabrechnungInstance: immoabrechnungInstance]
	}
	
	def edit(Long id) {
		def immoabrechnungInstance = Immoabrechnung.get(id)
		flash.immoabrechnung = immoabrechnungInstance
		if (!immoabrechnungInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'immoabrechnung.label', default: 'Immoabrechnung'), id])
			redirect(action: "list")
			return
		}

		[immoabrechnungInstance: immoabrechnungInstance]
	}
	
	def abrechnenNebko() {
		def id = params.id
		def immoabrechnungInstance = Immoabrechnung.get(id)
		immoabrechnungInstance.abrechnenNebko();
		redirect(action: "show", id: id)
	}
	
	def umlCreate() {
		println params
		println "Umlagen werden aus Umlageinfos erzeugt"
		def id = params.id
		def immoabrechnungInstance = Immoabrechnung.get(id)
		immoabrechnungInstance.erzeugeUmlagen()
		println "Umlagen wurden aus Umlageinfos erzeugt"
		redirect(action: "show", id: id)
	}
}
