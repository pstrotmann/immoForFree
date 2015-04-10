import org.strotmann.immos.Umlageanteil
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_umlageanteil_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/umlageanteil/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: umlageanteilInstance, field: 'kostenart', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("umlageanteil.kostenart.label"),'default':("Kostenart")],-1)
printHtmlPart(2)
invokeTag('select','g',10,['name':("kostenart"),'from':(umlageanteilInstance.constraints.kostenart.inList),'value':(umlageanteilInstance?.kostenart),'valueMessagePrefix':("umlageanteil.kostenart"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: umlageanteilInstance, field: 'umlageschluessel', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("umlageanteil.umlageschluessel.label"),'default':("Umlageschluessel")],-1)
printHtmlPart(2)
invokeTag('select','g',18,['name':("umlageschluessel"),'from':(umlageanteilInstance.constraints.umlageschluessel.inList),'value':(umlageanteilInstance?.umlageschluessel),'valueMessagePrefix':("umlageanteil.umlageschluessel"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: umlageanteilInstance, field: 'betrag', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("umlageanteil.betrag.label"),'default':("Betrag")],-1)
printHtmlPart(6)
invokeTag('field','g',26,['name':("betrag"),'value':(fieldValue(bean: umlageanteilInstance, field: 'betrag')),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: umlageanteilInstance, field: 'nebenkostenabrechnung', 'error'))
printHtmlPart(7)
invokeTag('message','g',31,['code':("umlageanteil.nebenkostenabrechnung.label"),'default':("Nebenkostenabrechnung")],-1)
printHtmlPart(6)
invokeTag('select','g',34,['id':("nebenkostenabrechnung"),'name':("nebenkostenabrechnung.id"),'from':(org.strotmann.immos.Nebenkostenabrechnung.list()),'optionKey':("id"),'required':(""),'value':(umlageanteilInstance?.nebenkostenabrechnung?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: umlageanteilInstance, field: 'umlage', 'error'))
printHtmlPart(8)
invokeTag('message','g',39,['code':("umlageanteil.umlage.label"),'default':("Umlage")],-1)
printHtmlPart(6)
invokeTag('select','g',42,['id':("umlage"),'name':("umlage.id"),'from':(org.strotmann.immos.Umlage.list()),'optionKey':("id"),'required':(""),'value':(umlageanteilInstance?.umlage?.id),'class':("many-to-one")],-1)
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1402833706000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
