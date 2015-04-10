package org.strotmann.immos



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MietsacheController {

    def scaffold = true
}
