import org.strotmann.immos.Zwischenzaehler
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_zwischenzaehler_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/zwischenzaehler/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: zwischenzaehlerInstance, field: 'zaehlernummer', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("zwischenzaehler.zaehlernummer.label"),'default':("Zählernummer")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("zaehlernummer"),'value':(zwischenzaehlerInstance?.zaehlernummer)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: zwischenzaehlerInstance, field: 'mietsache', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("zwischenzaehler.mietsache.label"),'default':("Mietsache")],-1)
printHtmlPart(5)
invokeTag('select','g',18,['id':("mietsache"),'name':("mietsache.id"),'from':(org.strotmann.immos.Mietsache.list()),'optionKey':("id"),'required':(""),'value':(zwischenzaehlerInstance?.mietsache?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: zwischenzaehlerInstance, field: 'stattZaehler', 'error'))
printHtmlPart(6)
invokeTag('message','g',23,['code':("zwischenzaehler.stattZaehler.label"),'default':("statt Zähler abrechnen")],-1)
printHtmlPart(2)
invokeTag('checkBox','g',26,['name':("stattZaehler"),'value':(zwischenzaehlerInstance?.stattZaehler)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: zwischenzaehlerInstance, field: 'zaehler', 'error'))
printHtmlPart(7)
invokeTag('message','g',31,['code':("zwischenzaehler.zaehler.label"),'default':("Zähler")],-1)
printHtmlPart(5)
invokeTag('select','g',34,['id':("zaehler"),'name':("zaehler.id"),'from':(org.strotmann.immos.Zaehler.list()),'optionKey':("id"),'required':(""),'value':(zwischenzaehlerInstance?.zaehler?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: zwischenzaehlerInstance, field: 'zwischenzaehlerstaende', 'error'))
printHtmlPart(8)
invokeTag('message','g',39,['code':("zwischenzaehler.zwischenzaehlerstaende.label"),'default':("Zwischenzählerstände")],-1)
printHtmlPart(9)
for( z in (zwischenzaehlerInstance?.zwischenzaehlerstaende) ) {
printHtmlPart(10)
createTagBody(2, {->
expressionOut.print(z?.encodeAsHTML())
})
invokeTag('link','g',45,['controller':("zwischenzaehlerstand"),'action':("show"),'id':(z.id)],2)
printHtmlPart(11)
}
printHtmlPart(12)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'zwischenzaehlerstand.label', default: 'Zwischenzählerstand')]))
})
invokeTag('link','g',48,['controller':("zwischenzaehlerstand"),'action':("create"),'params':(['zwischenzaehler.id': zwischenzaehlerInstance?.id])],1)
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1404565508000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
