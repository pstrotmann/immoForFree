import org.strotmann.immos.Umlage
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_umlage_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/umlage/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: umlageInstance, field: 'kostenart', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("umlage.kostenart.label"),'default':("Kostenart")],-1)
printHtmlPart(2)
invokeTag('select','g',10,['name':("kostenart"),'from':(umlageInstance.constraints.kostenart.inList),'value':(umlageInstance?.kostenart),'valueMessagePrefix':("umlage.kostenart"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: umlageInstance, field: 'umlageschluessel', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("umlage.umlageschluessel.label"),'default':("Umlageschlüssel")],-1)
printHtmlPart(2)
invokeTag('select','g',18,['name':("umlageschluessel"),'from':(Umlage.umlageschluessels),'value':(umlageInstance?.umlageschluessel),'valueMessagePrefix':("umlage.umlageschluessel"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: umlageInstance, field: 'betrag', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("umlage.betrag.label"),'default':("Betrag")],-1)
printHtmlPart(6)
invokeTag('field','g',26,['name':("betrag"),'value':(fieldValue(bean: umlageInstance, field: 'betrag')),'required':("")],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: umlageInstance, field: 'immoabrechnung', 'error'))
printHtmlPart(8)
invokeTag('message','g',32,['code':("umlage.immoabrechnung.label"),'default':("Immoabrechnung")],-1)
printHtmlPart(6)
invokeTag('select','g',35,['id':("immoabrechnung"),'name':("immoabrechnung.id"),'from':(org.strotmann.immos.Immoabrechnung.list()),'optionKey':("id"),'required':(""),'value':(umlageInstance?.immoabrechnung?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: umlageInstance, field: 'zaehler', 'error'))
printHtmlPart(9)
invokeTag('message','g',40,['code':("umlage.zaehler.label"),'default':("Zähler")],-1)
printHtmlPart(10)
invokeTag('select','g',42,['id':("zaehler"),'name':("zaehler.id"),'from':(umlageInstance.zaehlers),'optionKey':("id"),'required':(""),'value':(umlageInstance?.zaehler?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: umlageInstance, field: 'umlageanteile', 'error'))
printHtmlPart(11)
invokeTag('message','g',47,['code':("umlage.umlageanteile.label"),'default':("Umlageanteile")],-1)
printHtmlPart(12)
for( u in (umlageInstance?.umlageanteile) ) {
printHtmlPart(13)
createTagBody(2, {->
expressionOut.print(u?.encodeAsHTML())
})
invokeTag('link','g',53,['controller':("umlageanteil"),'action':("show"),'id':(u.id)],2)
printHtmlPart(14)
}
printHtmlPart(15)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'umlageanteil.label', default: 'Umlageanteil')]))
})
invokeTag('link','g',56,['controller':("umlageanteil"),'action':("create"),'params':(['umlage.id': umlageInstance?.id])],1)
printHtmlPart(16)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1402906298000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
