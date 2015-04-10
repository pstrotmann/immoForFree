package org.strotmann.immos

import org.springframework.dao.DataIntegrityViolationException

class ZahlungController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [zahlungInstanceList: Zahlung.list(params), zahlungInstanceTotal: Zahlung.count()]
    }

    def create() {
        [zahlungInstance: new Zahlung(params)]
    }

    def save() {
        def zahlungInstance = new Zahlung(params)
        if (!zahlungInstance.save(flush: true)) {
            render(view: "create", model: [zahlungInstance: zahlungInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'zahlung.label', default: 'Zahlung'), zahlungInstance.id])
        redirect(action: "show", id: zahlungInstance.id)
    }

    def show(Long id) {
        def zahlungInstance = Zahlung.get(id)
        if (!zahlungInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'zahlung.label', default: 'Zahlung'), id])
            redirect(action: "list")
            return
        }

        [zahlungInstance: zahlungInstance]
    }

    def edit(Long id) {
        def zahlungInstance = Zahlung.get(id)
        if (!zahlungInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'zahlung.label', default: 'Zahlung'), id])
            redirect(action: "list")
            return
        }

        [zahlungInstance: zahlungInstance]
    }

    def update(Long id, Long version) {
        def zahlungInstance = Zahlung.get(id)
        if (!zahlungInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'zahlung.label', default: 'Zahlung'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (zahlungInstance.version > version) {
                zahlungInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'zahlung.label', default: 'Zahlung')] as Object[],
                          "Another user has updated this Zahlung while you were editing")
                render(view: "edit", model: [zahlungInstance: zahlungInstance])
                return
            }
        }

        zahlungInstance.properties = params

        if (!zahlungInstance.save(flush: true)) {
            render(view: "edit", model: [zahlungInstance: zahlungInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'zahlung.label', default: 'Zahlung'), zahlungInstance.id])
        redirect(action: "show", id: zahlungInstance.id)
    }

    def delete(Long id) {
        def zahlungInstance = Zahlung.get(id)
        if (!zahlungInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'zahlung.label', default: 'Zahlung'), id])
            redirect(action: "list")
            return
        }

        try {
            zahlungInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'zahlung.label', default: 'Zahlung'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'zahlung.label', default: 'Zahlung'), id])
            redirect(action: "show", id: id)
        }
    }
}
