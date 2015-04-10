import org.strotmann.immos.Immobilie
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_immobilie_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/immobilie/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: immobilieInstance, field: 'hausadresse', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("immobilie.hausadresse.label"),'default':("Hausadresse")],-1)
printHtmlPart(2)
invokeTag('select','g',10,['id':("hausadresse"),'name':("hausadresse.id"),'from':(org.strotmann.immos.Hausadresse.getMiniList()),'optionKey':("id"),'required':(""),'value':(immobilieInstance?.hausadresse?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: immobilieInstance, field: 'grundbuch', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("immobilie.grundbuch.label"),'default':("Grundbuch")],-1)
printHtmlPart(5)
invokeTag('textField','g',18,['name':("grundbuch"),'value':(immobilieInstance?.grundbuch)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: immobilieInstance, field: 'baujahr', 'error'))
printHtmlPart(6)
invokeTag('message','g',23,['code':("immobilie.baujahr.label"),'default':("Baujahr")],-1)
printHtmlPart(2)
invokeTag('field','g',26,['name':("baujahr"),'type':("number"),'value':(immobilieInstance.baujahr),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: immobilieInstance, field: 'eigentumAb', 'error'))
printHtmlPart(7)
invokeTag('message','g',31,['code':("immobilie.eigentumAb.label"),'default':("Eigentum Ab")],-1)
printHtmlPart(5)
invokeTag('datePicker','g',34,['name':("eigentumAb"),'precision':("day"),'value':(immobilieInstance?.eigentumAb),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: immobilieInstance, field: 'eigentumBis', 'error'))
printHtmlPart(8)
invokeTag('message','g',39,['code':("immobilie.eigentumBis.label"),'default':("Eigentum Bis")],-1)
printHtmlPart(5)
invokeTag('datePicker','g',42,['name':("eigentumBis"),'precision':("day"),'value':(immobilieInstance?.eigentumBis),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: immobilieInstance, field: 'anschaffungspreis', 'error'))
printHtmlPart(9)
invokeTag('message','g',47,['code':("immobilie.anschaffungspreis.label"),'default':("Anschaffungspreis")],-1)
printHtmlPart(5)
invokeTag('field','g',50,['name':("anschaffungspreis"),'value':(fieldValue(bean: immobilieInstance, field: 'anschaffungspreis'))],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: immobilieInstance, field: 'verkaufspreis', 'error'))
printHtmlPart(10)
invokeTag('message','g',55,['code':("immobilie.verkaufspreis.label"),'default':("Verkaufspreis")],-1)
printHtmlPart(5)
invokeTag('field','g',58,['name':("verkaufspreis"),'value':(fieldValue(bean: immobilieInstance, field: 'verkaufspreis'))],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: immobilieInstance, field: 'grundstueckspreis', 'error'))
printHtmlPart(11)
invokeTag('message','g',63,['code':("immobilie.grundstueckspreis.label"),'default':("Grundstueckspreis")],-1)
printHtmlPart(5)
invokeTag('field','g',66,['name':("grundstueckspreis"),'value':(fieldValue(bean: immobilieInstance, field: 'grundstueckspreis'))],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: immobilieInstance, field: 'grundstuecksgroesse', 'error'))
printHtmlPart(12)
invokeTag('message','g',71,['code':("immobilie.grundstuecksgroesse.label"),'default':("Grundstuecksgroesse")],-1)
printHtmlPart(5)
invokeTag('field','g',74,['name':("grundstuecksgroesse"),'value':(fieldValue(bean: immobilieInstance, field: 'grundstuecksgroesse'))],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: immobilieInstance, field: 'erhoehteAbschreibung', 'error'))
printHtmlPart(13)
invokeTag('message','g',79,['code':("immobilie.erhoehteAbschreibung.label"),'default':("Erhoehte Abschreibung")],-1)
printHtmlPart(5)
invokeTag('checkBox','g',82,['name':("erhoehteAbschreibung"),'value':(immobilieInstance?.erhoehteAbschreibung)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: immobilieInstance, field: 'sozialerWohnungsbau', 'error'))
printHtmlPart(14)
invokeTag('message','g',87,['code':("immobilie.sozialerWohnungsbau.label"),'default':("SozialerWohnungsbau")],-1)
printHtmlPart(5)
invokeTag('checkBox','g',90,['name':("sozialerWohnungsbau"),'value':(immobilieInstance?.sozialerWohnungsbau)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: immobilieInstance, field: 'mietsachen', 'error'))
printHtmlPart(15)
invokeTag('message','g',95,['code':("immobilie.mietsachen.label"),'default':("Mietsachen")],-1)
printHtmlPart(16)
for( m in (immobilieInstance?.mietsachen) ) {
printHtmlPart(17)
createTagBody(2, {->
expressionOut.print(m?.encodeAsHTML())
})
invokeTag('link','g',101,['controller':("mietsache"),'action':("show"),'id':(m.id)],2)
printHtmlPart(18)
}
printHtmlPart(19)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'mietsache.label', default: 'Mietsache')]))
})
invokeTag('link','g',104,['controller':("mietsache"),'action':("create"),'params':(['immobilie.id': immobilieInstance?.id])],1)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: immobilieInstance, field: 'zaehlers', 'error'))
printHtmlPart(21)
invokeTag('message','g',112,['code':("immobilie.zaehlers.label"),'default':("Zähler")],-1)
printHtmlPart(16)
for( z in (immobilieInstance?.zaehlers) ) {
printHtmlPart(17)
createTagBody(2, {->
expressionOut.print(z?.encodeAsHTML())
})
invokeTag('link','g',118,['controller':("zaehler"),'action':("show"),'id':(z.id)],2)
printHtmlPart(18)
}
printHtmlPart(19)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'zaehler.label', default: 'Zähler')]))
})
invokeTag('link','g',121,['controller':("zaehler"),'action':("create"),'params':(['immobilie.id': immobilieInstance?.id])],1)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: immobilieInstance, field: 'kredite', 'error'))
printHtmlPart(22)
invokeTag('message','g',129,['code':("immobilie.kredite.label"),'default':("Kredite")],-1)
printHtmlPart(16)
for( z in (immobilieInstance?.kredite) ) {
printHtmlPart(17)
createTagBody(2, {->
expressionOut.print(z?.encodeAsHTML())
})
invokeTag('link','g',135,['controller':("kredit"),'action':("show"),'id':(z.id)],2)
printHtmlPart(18)
}
printHtmlPart(19)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'kredit.label', default: 'Kredit')]))
})
invokeTag('link','g',138,['controller':("kredit"),'action':("create"),'params':(['immobilie.id': immobilieInstance?.id])],1)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: immobilieInstance, field: 'dienstleistungsvertraege', 'error'))
printHtmlPart(23)
invokeTag('message','g',146,['code':("dienstleistungs.dienstleistungsvertraege.label"),'default':("Dienstleistungsverträge")],-1)
printHtmlPart(16)
for( z in (immobilieInstance?.dienstleistungsvertraege) ) {
printHtmlPart(17)
createTagBody(2, {->
expressionOut.print(z?.encodeAsHTML())
})
invokeTag('link','g',152,['controller':("dienstleistungsvertrag"),'action':("show"),'id':(z.id)],2)
printHtmlPart(18)
}
printHtmlPart(19)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'dienstleistungsvertrag.label', default: 'Dienstleistungsvertrag')]))
})
invokeTag('link','g',155,['controller':("dienstleistungsvertrag"),'action':("create"),'params':(['immobilie.id': immobilieInstance?.id])],1)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: immobilieInstance, field: 'rechnungen', 'error'))
printHtmlPart(24)
invokeTag('message','g',163,['code':("immobilie.rechnungen.label"),'default':("Rechnungen")],-1)
printHtmlPart(16)
for( r in (immobilieInstance?.rechnungen) ) {
printHtmlPart(17)
createTagBody(2, {->
expressionOut.print(r?.encodeAsHTML())
})
invokeTag('link','g',169,['controller':("rechnung"),'action':("show"),'id':(r.id)],2)
printHtmlPart(18)
}
printHtmlPart(19)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'rechnung.label', default: 'Rechnung')]))
})
invokeTag('link','g',172,['controller':("rechnung"),'action':("create"),'params':(['immobilie.id': immobilieInstance?.id])],1)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: immobilieInstance, field: 'immoabrechnungen', 'error'))
printHtmlPart(25)
invokeTag('message','g',180,['code':("immobilie.immoabrechnungen.label"),'default':("Immoabrechnungen")],-1)
printHtmlPart(16)
for( r in (immobilieInstance?.immoabrechnungen) ) {
printHtmlPart(17)
createTagBody(2, {->
expressionOut.print(r?.encodeAsHTML())
})
invokeTag('link','g',186,['controller':("rechnung"),'action':("show"),'id':(r.id)],2)
printHtmlPart(18)
}
printHtmlPart(19)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'Immoabrechnung.label', default: 'Immoabrechnung')]))
})
invokeTag('link','g',189,['controller':("Immoabrechnung"),'action':("create"),'params':(['immobilie.id': immobilieInstance?.id])],1)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: immobilieInstance, field: 'einheitswerte', 'error'))
printHtmlPart(26)
invokeTag('message','g',197,['code':("immobilie.einheitswerte.label"),'default':("Einheitswerte")],-1)
printHtmlPart(16)
for( e in (immobilieInstance?.einheitswerte) ) {
printHtmlPart(17)
createTagBody(2, {->
expressionOut.print(e?.encodeAsHTML())
})
invokeTag('link','g',203,['controller':("einheitswert"),'action':("show"),'id':(e.id)],2)
printHtmlPart(18)
}
printHtmlPart(19)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'einheitswert.label', default: 'Einheitswert')]))
})
invokeTag('link','g',206,['controller':("einheitswert"),'action':("create"),'params':(['immobilie.id': immobilieInstance?.id])],1)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: immobilieInstance, field: 'grundschulden', 'error'))
printHtmlPart(27)
invokeTag('message','g',214,['code':("immobilie.grundschulden.label"),'default':("Grundschulden")],-1)
printHtmlPart(16)
for( g in (immobilieInstance?.grundschulden) ) {
printHtmlPart(17)
createTagBody(2, {->
expressionOut.print(g?.encodeAsHTML())
})
invokeTag('link','g',220,['controller':("grundschuld"),'action':("show"),'id':(g.id)],2)
printHtmlPart(18)
}
printHtmlPart(19)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'grundschuld.label', default: 'Grundschuld')]))
})
invokeTag('link','g',223,['controller':("grundschuld"),'action':("create"),'params':(['immobilie.id': immobilieInstance?.id])],1)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: immobilieInstance, field: 'notizen', 'error'))
printHtmlPart(28)
invokeTag('message','g',231,['code':("immobilie.notizen.label"),'default':("Notizen")],-1)
printHtmlPart(16)
for( n in (org.strotmann.immos.Notiz.getNotizen('Immobilie',immobilieInstance.id)) ) {
printHtmlPart(17)
createTagBody(2, {->
expressionOut.print(n)
})
invokeTag('link','g',237,['controller':("notiz"),'action':("show"),'id':(n.id)],2)
printHtmlPart(18)
}
printHtmlPart(19)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'notiz.label', default: 'Notiz')]))
})
invokeTag('link','g',240,['controller':("notiz"),'action':("create"),'params':(['immobilie.id': immobilieInstance?.id])],1)
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1412841646000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
