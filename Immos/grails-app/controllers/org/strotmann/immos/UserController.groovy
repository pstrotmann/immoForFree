package org.strotmann.immos

import org.springframework.dao.DataIntegrityViolationException

class UserController {

    def scaffold = true
	
	def login() {
		if (request.get) {
			return // render the login view
		}
		def u = User.findByName(params.name)
		if (u) {
			if (u.passwort == params.passwort) {
				session.user = u
				redirect(uri: "/")
			}
			else {
				flash.message = "Passwort falsch"
				render(view: "login")
			}
		}
		else {
			flash.message = "User unbekannt"
			flash.name = params.name
			render(view: "login")
		}
	}
}
