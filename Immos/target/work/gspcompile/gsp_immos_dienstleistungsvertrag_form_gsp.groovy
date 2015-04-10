import org.strotmann.immos.Dienstleistungsvertrag
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_dienstleistungsvertrag_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/dienstleistungsvertrag/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: mdienstleistungsvertragInstance, field: 'partnerrolle', 'error'))
printHtmlPart(1)
invokeTag('message','g',5,['code':("dienstleistungsvertrag?.dienstleister.label"),'default':("Dienstleister")],-1)
printHtmlPart(2)
if(true && (flash.partner)) {
printHtmlPart(3)
invokeTag('fieldValue','g',9,['bean':(flash.partner),'field':("name")],-1)
printHtmlPart(4)
}
printHtmlPart(4)
if(true && (dienstleistungsvertragInstance?.dienstleister)) {
printHtmlPart(3)
invokeTag('fieldValue','g',12,['bean':(dienstleistungsvertragInstance?.dienstleister?.partner),'field':("name")],-1)
printHtmlPart(4)
}
printHtmlPart(4)
if(true && (!flash.partner && !dienstleistungsvertragInstance?.dienstleister)) {
printHtmlPart(3)
invokeTag('select','g',15,['id':("partner"),'name':("partner.id"),'from':(org.strotmann.immos.Dienstleistungsvertrag.getDienstleisterList()),'optionKey':("id"),'required':(""),'value':(dienstleistungsvertragInstance?.dienstleister?.id),'class':("many-to-one")],-1)
printHtmlPart(4)
}
printHtmlPart(5)
expressionOut.print(hasErrors(bean: dienstleistungsvertragInstance, field: 'immobilie', 'error'))
printHtmlPart(6)
invokeTag('message','g',21,['code':("dienstleistungsvertrag.immobilie.label"),'default':("Immobilie")],-1)
printHtmlPart(2)
invokeTag('select','g',24,['id':("immobilie"),'name':("immobilie.id"),'from':(org.strotmann.immos.Immobilie.immobilien),'optionKey':("id"),'required':(""),'value':(dienstleistungsvertragInstance?.immobilie?.id),'class':("many-to-one")],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: dienstleistungsvertragInstance, field: 'dienstleistungsart', 'error'))
printHtmlPart(7)
invokeTag('message','g',29,['code':("dienstleistungsvertrag.dienstleistungsart.label"),'default':("Dienstleistungsart")],-1)
printHtmlPart(8)
invokeTag('select','g',32,['name':("dienstleistungsart"),'from':(Dienstleistungsvertrag.getArten()),'value':(dienstleistungsvertragInstance?.dienstleistungsart),'valueMessagePrefix':("dienstleistungsvertrag.dienstleistungsart"),'noSelection':(['': ''])],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: dienstleistungsvertragInstance, field: 'vertragsnummer', 'error'))
printHtmlPart(9)
invokeTag('message','g',37,['code':("dienstleistungsvertrag.vertragsnummer.label"),'default':("Vertragsnummer")],-1)
printHtmlPart(8)
invokeTag('textField','g',40,['name':("vertragsnummer"),'value':(dienstleistungsvertragInstance?.vertragsnummer)],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: dienstleistungsvertragInstance, field: 'kundennummer', 'error'))
printHtmlPart(10)
invokeTag('message','g',45,['code':("dienstleistungsvertrag.kundennummer.label"),'default':("Kundennummer")],-1)
printHtmlPart(8)
invokeTag('textField','g',48,['name':("kundennummer"),'value':(dienstleistungsvertragInstance?.kundennummer)],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: dienstleistungsvertragInstance, field: 'referenz', 'error'))
printHtmlPart(11)
invokeTag('message','g',53,['code':("dienstleistungsvertrag.referenz.label"),'default':("referenz")],-1)
printHtmlPart(8)
invokeTag('textField','g',56,['name':("referenz"),'value':(dienstleistungsvertragInstance?.referenz)],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: dienstleistungsvertragInstance, field: 'vertragsbeginn', 'error'))
printHtmlPart(12)
invokeTag('message','g',61,['code':("dienstleistungsvertrag.vertragsbeginn.label"),'default':("Vertragsbeginn")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',64,['name':("vertragsbeginn"),'precision':("day"),'years':(2013..2023),'value':(dienstleistungsvertragInstance?.vertragsbeginn)],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: dienstleistungsvertragInstance, field: 'vertragsende', 'error'))
printHtmlPart(13)
invokeTag('message','g',69,['code':("dienstleistungsvertrag.vertragsende.label"),'default':("Vertragsende")],-1)
printHtmlPart(8)
invokeTag('datePicker','g',72,['name':("vertragsende"),'precision':("day"),'years':(2013..2023),'value':(dienstleistungsvertragInstance?.vertragsende),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: dienstleistungsvertragInstance, field: 'autoVerlJahre', 'error'))
printHtmlPart(14)
invokeTag('message','g',77,['code':("dienstleistungsvertrag.autoVerlJahre.label"),'default':("automatische Verlängerung in Jahren")],-1)
printHtmlPart(8)
invokeTag('select','g',80,['name':("autoVerlJahre"),'from':(1..2),'value':(dienstleistungsvertragInstance?.autoVerlJahre),'noSelection':(['':''])],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: dienstleistungsvertragInstance, field: 'kueWochen', 'error'))
printHtmlPart(15)
invokeTag('message','g',85,['code':("dienstleistungsvertrag.kueWochen.label"),'default':("Kündigung vor Ablauf in Wochen")],-1)
printHtmlPart(8)
invokeTag('select','g',88,['name':("kueWochen"),'from':([4,6,12]),'value':(dienstleistungsvertragInstance?.kueWochen),'noSelection':(['':''])],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: dienstleistungsvertragInstance, field: 'zahlweise', 'error'))
printHtmlPart(16)
invokeTag('message','g',93,['code':("dienstleistungsvertrag.zahlweise.label"),'default':("Zahlweise")],-1)
printHtmlPart(2)
invokeTag('select','g',96,['name':("zahlweise"),'from':(dienstleistungsvertragInstance.constraints.zahlweise.inList),'value':(dienstleistungsvertragInstance?.zahlweise),'valueMessagePrefix':("zahlweise.category")],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: dienstleistungsvertragInstance, field: 'umlagefaehig', 'error'))
printHtmlPart(17)
invokeTag('message','g',101,['code':("dienstleistungsvertrag.umlagefaehig.label"),'default':("Umlagefähig")],-1)
printHtmlPart(8)
invokeTag('checkBox','g',104,['name':("umlagefaehig"),'value':(dienstleistungsvertragInstance?.umlagefaehig)],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: dienstleistungsvertragInstance, field: 'vertragsstaende', 'error'))
printHtmlPart(18)
invokeTag('message','g',109,['code':("dienstleistungsvertrag.vertragsstaende.label"),'default':("Vertragsstaende")],-1)
printHtmlPart(19)
for( v in (dienstleistungsvertragInstance?.vertragsstaende) ) {
printHtmlPart(20)
createTagBody(2, {->
expressionOut.print(v?.encodeAsHTML())
})
invokeTag('link','g',115,['controller':("dienstleistungsvertragsstand"),'action':("show"),'id':(v.id)],2)
printHtmlPart(21)
}
printHtmlPart(22)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'dienstleistungsvertragsstand.label', default: 'Dienstleistungsvertragsstand')]))
})
invokeTag('link','g',118,['controller':("dienstleistungsvertragsstand"),'action':("create"),'params':(['dienstleistungsvertrag.id': dienstleistungsvertragInstance?.id])],1)
printHtmlPart(23)
expressionOut.print(hasErrors(bean: dienstleistungsvertragInstance, field: 'zahlungen', 'error'))
printHtmlPart(24)
invokeTag('message','g',126,['code':("dienstleistungsvertrag.zahlungen.label"),'default':("Zahlungen")],-1)
printHtmlPart(19)
for( z in (dienstleistungsvertragInstance?.zahlungen) ) {
printHtmlPart(20)
createTagBody(2, {->
expressionOut.print(z?.encodeAsHTML())
})
invokeTag('link','g',132,['controller':("zahlung"),'action':("show"),'id':(z.id)],2)
printHtmlPart(21)
}
printHtmlPart(22)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'zahlung.label', default: 'Zahlung')]))
})
invokeTag('link','g',135,['controller':("zahlung"),'action':("create"),'params':(['dienstleistungsvertrag.id': dienstleistungsvertragInstance?.id])],1)
printHtmlPart(23)
expressionOut.print(hasErrors(bean: immobilieInstance, field: 'notizen', 'error'))
printHtmlPart(25)
invokeTag('message','g',143,['code':("immobilie.notizen.label"),'default':("Notizen")],-1)
printHtmlPart(19)
for( n in (org.strotmann.immos.Notiz.getNotizen('Dienstleistungsvertrag',dienstleistungsvertragInstance.id)) ) {
printHtmlPart(20)
createTagBody(2, {->
expressionOut.print(n)
})
invokeTag('link','g',149,['controller':("notiz"),'action':("show"),'id':(n.id)],2)
printHtmlPart(21)
}
printHtmlPart(22)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'notiz.label', default: 'Notiz')]))
})
invokeTag('link','g',152,['controller':("notiz"),'action':("create"),'params':(['dienstleistungsvertrag.id': dienstleistungsvertragInstance?.id])],1)
printHtmlPart(26)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1412502546000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
