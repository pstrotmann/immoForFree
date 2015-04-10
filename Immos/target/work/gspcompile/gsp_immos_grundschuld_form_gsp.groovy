import org.strotmann.immos.Grundschuld
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_grundschuld_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/grundschuld/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: grundschuldInstance, field: 'eintragAm', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("grundschuld.eintragAm.label"),'default':("Eintrag Am")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',10,['name':("eintragAm"),'precision':("day"),'value':(grundschuldInstance?.eintragAm)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: grundschuldInstance, field: 'loeschungAm', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("grundschuld.loeschungAm.label"),'default':("Loeschung Am")],-1)
printHtmlPart(5)
invokeTag('datePicker','g',18,['name':("loeschungAm"),'precision':("day"),'value':(grundschuldInstance?.loeschungAm),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: grundschuldInstance, field: 'betrag', 'error'))
printHtmlPart(6)
invokeTag('message','g',23,['code':("grundschuld.betrag.label"),'default':("Betrag")],-1)
printHtmlPart(2)
invokeTag('field','g',26,['name':("betrag"),'value':(fieldValue(bean: grundschuldInstance, field: 'betrag')),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: grundschuldInstance, field: 'rang', 'error'))
printHtmlPart(7)
invokeTag('message','g',31,['code':("grundschuld.rang.label"),'default':("Rang")],-1)
printHtmlPart(2)
invokeTag('field','g',34,['name':("rang"),'type':("number"),'value':(grundschuldInstance.rang),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: grundschuldInstance, field: 'glaeubiger', 'error'))
printHtmlPart(8)
invokeTag('message','g',39,['code':("grundschuld.glaeubiger.label"),'default':("Glaeubiger")],-1)
printHtmlPart(2)
invokeTag('select','g',42,['id':("glaeubiger"),'name':("glaeubiger.id"),'from':(org.strotmann.immos.Organisation.miniList),'optionKey':("id"),'required':(""),'value':(grundschuldInstance?.glaeubiger?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: grundschuldInstance, field: 'immobilie', 'error'))
printHtmlPart(9)
invokeTag('message','g',47,['code':("grundschuld.immobilie.label"),'default':("Immobilie")],-1)
printHtmlPart(2)
invokeTag('select','g',50,['id':("immobilie"),'name':("immobilie.id"),'from':(org.strotmann.immos.Immobilie.list()),'optionKey':("id"),'required':(""),'value':(grundschuldInstance?.immobilie?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: grundschuldInstance, field: 'kredite', 'error'))
printHtmlPart(10)
invokeTag('message','g',55,['code':("grundschuld.kredite.label"),'default':("Kredite")],-1)
printHtmlPart(11)
for( k in (grundschuldInstance?.kredite) ) {
printHtmlPart(12)
createTagBody(2, {->
expressionOut.print(k?.encodeAsHTML())
})
invokeTag('link','g',61,['controller':("kredit"),'action':("show"),'id':(k.id)],2)
printHtmlPart(13)
}
printHtmlPart(14)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'kredit.label', default: 'Kredit')]))
})
invokeTag('link','g',64,['controller':("kredit"),'action':("create"),'params':(['grundschuld.id': grundschuldInstance?.id])],1)
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1398082706000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
