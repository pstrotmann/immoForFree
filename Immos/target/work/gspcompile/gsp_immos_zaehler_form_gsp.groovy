import org.strotmann.immos.Zaehler
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_zaehler_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/zaehler/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: zaehlerInstance, field: 'zaehlernummer', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("zaehler.zaehlernummer.label"),'default':("Zählernummer")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("zaehlernummer"),'value':(zaehlerInstance?.zaehlernummer)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: zaehlerInstance, field: 'zaehlertyp', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("zaehler.zaehlertyp.label"),'default':("Zählertyp")],-1)
printHtmlPart(2)
invokeTag('select','g',18,['name':("zaehlertyp"),'from':(zaehlerInstance.constraints.zaehlertyp.inList),'value':(zaehlerInstance?.zaehlertyp),'valueMessagePrefix':("zaehler.zaehlertyp"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: zaehlerInstance, field: 'zaehlereinheit', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("zaehler.zaehlereinheit.label"),'default':("Zählereinheit")],-1)
printHtmlPart(2)
invokeTag('select','g',26,['name':("zaehlereinheit"),'from':(zaehlerInstance.constraints.zaehlereinheit.inList),'value':(zaehlerInstance?.zaehlereinheit),'valueMessagePrefix':("zaehler.zaehlereinheit"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: zaehlerInstance, field: 'immobilie', 'error'))
printHtmlPart(6)
invokeTag('message','g',31,['code':("zaehler.immobilie.label"),'default':("Immobilie")],-1)
printHtmlPart(7)
invokeTag('select','g',34,['id':("immobilie"),'name':("immobilie.id"),'from':(org.strotmann.immos.Immobilie.list()),'optionKey':("id"),'required':(""),'value':(zaehlerInstance?.immobilie?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: zaehlerInstance, field: 'zaehlerstaende', 'error'))
printHtmlPart(8)
invokeTag('message','g',39,['code':("zaehler.zaehlerstaende.label"),'default':("Zählerstände")],-1)
printHtmlPart(9)
for( z in (zaehlerInstance?.zaehlerstaende) ) {
printHtmlPart(10)
createTagBody(2, {->
expressionOut.print(z?.encodeAsHTML())
})
invokeTag('link','g',45,['controller':("zaehlerstand"),'action':("show"),'id':(z.id)],2)
printHtmlPart(11)
}
printHtmlPart(12)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'zaehlerstand.label', default: 'Zählerstand')]))
})
invokeTag('link','g',48,['controller':("zaehlerstand"),'action':("create"),'params':(['zaehler.id': zaehlerInstance?.id])],1)
printHtmlPart(13)
expressionOut.print(hasErrors(bean: zaehlerInstance, field: 'zwischenzaehlers', 'error'))
printHtmlPart(14)
invokeTag('message','g',56,['code':("zaehler.zwischenzaehlers.label"),'default':("Zwischenzähler")],-1)
printHtmlPart(9)
for( z in (zaehlerInstance?.zwischenzaehlers) ) {
printHtmlPart(10)
createTagBody(2, {->
expressionOut.print(z?.encodeAsHTML())
})
invokeTag('link','g',62,['controller':("zwischenzaehler"),'action':("show"),'id':(z.id)],2)
printHtmlPart(11)
}
printHtmlPart(12)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'zwischenzaehler.label', default: 'Zählerstand')]))
})
invokeTag('link','g',65,['controller':("zwischenzaehler"),'action':("create"),'params':(['zaehler.id': zaehlerInstance?.id])],1)
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1402856244000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
