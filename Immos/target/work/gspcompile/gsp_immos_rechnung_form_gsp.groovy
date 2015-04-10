import org.strotmann.immos.Rechnung
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_rechnung_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/rechnung/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: rechnungInstance, field: 'rechnungssteller', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("rechnung.rechnungssteller.label"),'default':("Rechnungssteller")],-1)
printHtmlPart(2)
if(true && (flash.partner)) {
printHtmlPart(3)
invokeTag('select','g',11,['id':("partner"),'name':("partner.id"),'from':(flash.partner),'optionKey':("id"),'required':(""),'value':(rechnungInstance?.rechnungssteller?.id),'class':("many-to-one")],-1)
printHtmlPart(4)
}
printHtmlPart(4)
if(true && (rechnungInstance?.rechnungssteller)) {
printHtmlPart(3)
invokeTag('fieldValue','g',14,['bean':(rechnungInstance?.rechnungssteller?.partner),'field':("name")],-1)
printHtmlPart(4)
}
printHtmlPart(4)
if(true && (!flash.partner && !rechnungInstance?.rechnungssteller)) {
printHtmlPart(3)
invokeTag('select','g',17,['id':("partner"),'name':("partner.id"),'from':(org.strotmann.immos.Rechnung.getRechnungsstellerList()),'optionKey':("id"),'required':(""),'value':(rechnungInstance?.rechnungssteller?.id),'class':("many-to-one")],-1)
printHtmlPart(4)
}
printHtmlPart(5)
expressionOut.print(hasErrors(bean: rechnungInstance, field: 'immobilie', 'error'))
printHtmlPart(6)
invokeTag('message','g',22,['code':("rechnung.immobilie.label"),'default':("Immobilie")],-1)
printHtmlPart(2)
invokeTag('select','g',25,['id':("immobilie"),'name':("immobilie.id"),'from':(org.strotmann.immos.Immobilie.immobilien),'optionKey':("id"),'required':(""),'value':(rechnungInstance?.immobilie?.id),'class':("many-to-one")],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: rechnungInstance, field: 'rechnungsdatum', 'error'))
printHtmlPart(8)
invokeTag('message','g',30,['code':("rechnung.rechnungsdatum.label"),'default':("Rechnungsdatum")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',33,['name':("rechnungsdatum"),'precision':("day"),'value':(rechnungInstance?.rechnungsdatum)],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: rechnungInstance, field: 'betrag', 'error'))
printHtmlPart(9)
invokeTag('message','g',38,['code':("rechnung.betrag.label"),'default':("Betrag")],-1)
printHtmlPart(2)
invokeTag('field','g',41,['name':("betrag"),'value':(fieldValue(bean: rechnungInstance, field: 'betrag')),'required':("")],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: rechnungInstance, field: 'bruttoBetrag', 'error'))
printHtmlPart(10)
invokeTag('message','g',46,['code':("rechnung.bruttoBetrag.label"),'default':("Brutto Betrag")],-1)
printHtmlPart(11)
invokeTag('field','g',49,['name':("bruttoBetrag"),'value':(fieldValue(bean: rechnungInstance, field: 'bruttoBetrag'))],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: rechnungInstance, field: 'nettoBetrag', 'error'))
printHtmlPart(12)
invokeTag('message','g',54,['code':("rechnung.nettoBetrag.label"),'default':("Netto Betrag")],-1)
printHtmlPart(11)
invokeTag('field','g',57,['name':("nettoBetrag"),'value':(fieldValue(bean: rechnungInstance, field: 'nettoBetrag'))],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: rechnungInstance, field: 'mehrwertsteuerSatz', 'error'))
printHtmlPart(13)
invokeTag('message','g',62,['code':("rechnung.mehrwertsteuerSatz.label"),'default':("Mehrwertsteuer Satz")],-1)
printHtmlPart(11)
invokeTag('field','g',65,['name':("mehrwertsteuerSatz"),'value':(fieldValue(bean: rechnungInstance, field: 'mehrwertsteuerSatz'))],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: rechnungInstance, field: 'mehrwertsteuer', 'error'))
printHtmlPart(14)
invokeTag('message','g',70,['code':("rechnung.mehrwertsteuer.label"),'default':("Mehrwertsteuer")],-1)
printHtmlPart(11)
invokeTag('field','g',73,['name':("mehrwertsteuer"),'value':(fieldValue(bean: rechnungInstance, field: 'mehrwertsteuer'))],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: rechnungInstance, field: 'skontoSatz', 'error'))
printHtmlPart(15)
invokeTag('message','g',78,['code':("rechnung.skontoSatz.label"),'default':("Skonto Satz")],-1)
printHtmlPart(11)
invokeTag('field','g',81,['name':("skontoSatz"),'value':(fieldValue(bean: rechnungInstance, field: 'skontoSatz'))],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: rechnungInstance, field: 'skonto', 'error'))
printHtmlPart(16)
invokeTag('message','g',86,['code':("rechnung.skonto.label"),'default':("Skonto")],-1)
printHtmlPart(11)
invokeTag('field','g',89,['name':("skonto"),'value':(fieldValue(bean: rechnungInstance, field: 'skonto'))],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: rechnungInstance, field: 'auftragsnummer', 'error'))
printHtmlPart(17)
invokeTag('message','g',94,['code':("rechnung.auftragsnummer.label"),'default':("Auftragsnummer")],-1)
printHtmlPart(11)
invokeTag('textField','g',97,['name':("auftragsnummer"),'value':(rechnungInstance?.auftragsnummer)],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: rechnungInstance, field: 'kundennummer', 'error'))
printHtmlPart(18)
invokeTag('message','g',102,['code':("rechnung.kundennummer.label"),'default':("Kundennummer")],-1)
printHtmlPart(11)
invokeTag('textField','g',105,['name':("kundennummer"),'value':(rechnungInstance?.kundennummer)],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: rechnungInstance, field: 'rechnungsgegenstand', 'error'))
printHtmlPart(19)
invokeTag('message','g',110,['code':("rechnung.rechnungsgegenstand.label"),'default':("Rechnungsgegenstand")],-1)
printHtmlPart(11)
invokeTag('textField','g',113,['name':("rechnungsgegenstand"),'value':(rechnungInstance?.rechnungsgegenstand)],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: rechnungInstance, field: 'rechnungsnummer', 'error'))
printHtmlPart(20)
invokeTag('message','g',118,['code':("rechnung.rechnungsnummer.label"),'default':("Rechnungsnummer")],-1)
printHtmlPart(11)
invokeTag('textField','g',121,['name':("rechnungsnummer"),'value':(rechnungInstance?.rechnungsnummer)],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: rechnungInstance, field: 'umlagefaehig', 'error'))
printHtmlPart(21)
invokeTag('message','g',126,['code':("rechnung.umlagefaehig.label"),'default':("Umlagefähig")],-1)
printHtmlPart(11)
invokeTag('checkBox','g',129,['name':("umlagefaehig"),'value':(rechnungInstance?.umlagefaehig)],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: rechnungInstance, field: 'notizen', 'error'))
printHtmlPart(22)
invokeTag('message','g',134,['code':("rechnung.notizen.label"),'default':("Notizen")],-1)
printHtmlPart(23)
for( n in (org.strotmann.immos.Notiz.getNotizen('Rechnung',rechnungInstance.id)) ) {
printHtmlPart(24)
createTagBody(2, {->
expressionOut.print(n)
})
invokeTag('link','g',140,['controller':("notiz"),'action':("show"),'id':(n.id)],2)
printHtmlPart(25)
}
printHtmlPart(26)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'notiz.label', default: 'Notiz')]))
})
invokeTag('link','g',143,['controller':("notiz"),'action':("create"),'params':(['rechnung.id': rechnungInstance?.id])],1)
printHtmlPart(27)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1412530528000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
