package org.strotmann.immos

import org.springframework.dao.DataIntegrityViolationException

class NebenkostenabrechnungController {

	def scaffold = true
    
    def create() {
        [nebenkostenabrechnungInstance: new Nebenkostenabrechnung(params)]
    }

    def save() {
        def nebenkostenabrechnungInstance = new Nebenkostenabrechnung(params)
        if (!nebenkostenabrechnungInstance.save(flush: true)) {
            render(view: "create", model: [nebenkostenabrechnungInstance: nebenkostenabrechnungInstance])
            return
        }
		Mietvertrag mv = nebenkostenabrechnungInstance.betriebskostenabrechnung.mietvertrag
		Mietsache ms = nebenkostenabrechnungInstance.betriebskostenabrechnung.mietvertrag.mietsache
		Immoabrechnung imab = nebenkostenabrechnungInstance.betriebskostenabrechnung.immoabrechnung
		imab.umlagen.each {Umlage u ->
			//erzeuge umlageanteil
			Umlageanteil ua = new Umlageanteil()
			ua.nebenkostenabrechnung = nebenkostenabrechnungInstance
			ua.umlage = u
			ua.kostenart = u.kostenart
			boolean msHatZZ = false
			ms.zwischenzaehlers.each {msHatZZ = true}
			Umlageanteil uaZ = null
			if (u.zzVerbrauch && msHatZZ) {
				uaZ = new Umlageanteil()
				uaZ.nebenkostenabrechnung = nebenkostenabrechnungInstance
				uaZ.umlage = u
				uaZ.kostenart = u.kostenart
				uaZ.umlageschluessel = 'Zähler'
				uaZ.betrag = (u.zzVerbrauch / u.ZVerbrauch) * u.betrag
				uaZ.save(failOnError: true)
			}
			
			boolean uHatStattZZ = false
			if (u.zaehler) {
				u.zaehler.zwischenzaehlers.each {Zwischenzaehler zz ->
					if (zz.stattZaehler)
						uHatStattZZ = true
				}
			}
			
			if (!(uHatStattZZ && uaZ)) {
				ua.umlageschluessel = u.umlageschluessel
				def Map koartAb = imab.koartAbschlaege
				def abWf = koartAb."${u.kostenart}"?koartAb."${u.kostenart}"[0]:0
				def abPers = koartAb."${u.kostenart}"?koartAb."${u.kostenart}"[1]:0
				switch (u.umlageschluessel) {
					case 'qm' : ua.betrag = (ms.wohnflaeche/(imab.immobilie.wohnflaeche - abWf)) * u.betragOhneZZ 
								break
					case 'Personen': ua.betrag = (mv.anzahlPersonen/(imab.immobilie.anzahlPersonen - abPers)) * u.betragOhneZZ
								break
					case 'Haushalt' : ua.betrag = (1/imab.immobilie.anzahlHaushalte) * u.betragOhneZZ
								break
				}
				ua.save(failOnError: true)
			}
		}
        flash.message = message(code: 'default.created.message', args: [message(code: 'nebenkostenabrechnung.label', default: 'Nebenkostenabrechnung'), nebenkostenabrechnungInstance.id])
        redirect(action: "show", id: nebenkostenabrechnungInstance.id)
    }
}
