package immos

class SecurityFilters {

    def filters = {
        loginCheck(controller: 'user', action: 'login', invert: true) {
		    before = {
                if (!session.user && actionName != "login") {
					redirect(controller: "user", action: "login")
                }
            }
        }
    }
}
