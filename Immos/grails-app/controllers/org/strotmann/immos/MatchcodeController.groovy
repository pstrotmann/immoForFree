package org.strotmann.immos

import org.springframework.dao.DataIntegrityViolationException

class MatchcodeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "create", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [matchcodeInstanceList: Matchcode.getMatches(params), matchcodeInstanceTotal: Matchcode.count()]
    }

    def create() {
        [matchcodeInstance: new Matchcode(params)]		
    }
}
