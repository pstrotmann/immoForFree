package immos

class SecurityFilters {

    def filters = {
        loginCheck(controller: 'user', action: 'login', invert: true) {
		    before = {
                if (!session.user && actionName != "login" && !(actionName in ["krSum", "spkSum", "wueSum", "spkZins", "wueZins", "immoSum"])) {
					redirect(controller: "user", action: "login")
                }
            }
        }
    }
}
