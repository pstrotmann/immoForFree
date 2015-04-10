import org.strotmann.immos.Immoabrechnung
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_immoabrechnung_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/immoabrechnung/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: immoabrechnungInstance, field: 'jahr', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("immoabrechnung.jahr.label"),'default':("Jahr")],-1)
printHtmlPart(2)
invokeTag('field','g',10,['name':("jahr"),'type':("number"),'value':(immoabrechnungInstance.jahr),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: immoabrechnungInstance, field: 'datum', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("immoabrechnung.datum.label"),'default':("Datum")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',18,['name':("datum"),'precision':("day"),'value':(immoabrechnungInstance?.datum)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: immoabrechnungInstance, field: 'immobilie', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("immoabrechnung.immobilie.label"),'default':("Immobilie")],-1)
printHtmlPart(2)
invokeTag('select','g',26,['id':("immobilie"),'name':("immobilie.id"),'from':(org.strotmann.immos.Immobilie.immobilien),'optionKey':("id"),'required':(""),'value':(immoabrechnungInstance?.immobilie?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: immoabrechnungInstance, field: 'betriebskostenabrechnungen', 'error'))
printHtmlPart(6)
invokeTag('message','g',31,['code':("immoabrechnung.betriebskostenabrechnungen.label"),'default':("Betriebskostenabrechnungen")],-1)
printHtmlPart(7)
for( n in (immoabrechnungInstance?.betriebskostenabrechnungen) ) {
printHtmlPart(8)
createTagBody(2, {->
expressionOut.print(n?.encodeAsHTML())
})
invokeTag('link','g',37,['controller':("betriebskostenabrechnung"),'action':("show"),'id':(n.id)],2)
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'betriebskostenabrechnung.label', default: 'Betriebskostenabrechnung')]))
})
invokeTag('link','g',40,['controller':("betriebskostenabrechnung"),'action':("create"),'params':(['immoabrechnung.id': immoabrechnungInstance?.id])],1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: immoabrechnungInstance, field: 'umlagen', 'error'))
printHtmlPart(12)
invokeTag('message','g',48,['code':("immoabrechnung.umlagen.label"),'default':("Umlagen")],-1)
printHtmlPart(7)
for( u in (immoabrechnungInstance?.umlagen) ) {
printHtmlPart(8)
createTagBody(2, {->
expressionOut.print(u?.encodeAsHTML())
})
invokeTag('link','g',54,['controller':("umlage"),'action':("show"),'id':(u.id)],2)
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'umlage.label', default: 'Umlage')]))
})
invokeTag('link','g',57,['controller':("umlage"),'action':("create"),'params':(['immoabrechnung.id': immoabrechnungInstance?.id])],1)
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1406629518000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
