import org.strotmann.immos.Mietsache
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_mietsache_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mietsache/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: mietsacheInstance, field: 'lage', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("mietsache.lage.label"),'default':("Lage")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("lage"),'value':(mietsacheInstance?.lage)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: mietsacheInstance, field: 'art', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("mietsache.art.label"),'default':("Art")],-1)
printHtmlPart(2)
invokeTag('select','g',18,['name':("art"),'from':(Mietsache.getArten()),'value':(mietsacheInstance?.art),'valueMessagePrefix':("mietsache.art"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: mietsacheInstance, field: 'wohnflaeche', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("mietsache.wohnflaeche.label"),'default':("Wohnflaeche")],-1)
printHtmlPart(2)
invokeTag('field','g',26,['name':("wohnflaeche"),'value':(fieldValue(bean: mietsacheInstance, field: 'wohnflaeche'))],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: mietsacheInstance, field: 'aufteilung', 'error'))
printHtmlPart(6)
invokeTag('message','g',31,['code':("mietsache.aufteilung.label"),'default':("Aufteilung")],-1)
printHtmlPart(2)
invokeTag('textField','g',34,['name':("aufteilung"),'value':(mietsacheInstance?.aufteilung)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: mietsacheInstance, field: 'zwischenzaehlers', 'error'))
printHtmlPart(7)
invokeTag('message','g',39,['code':("mietsache.zwischenzaehlers.label"),'default':("Zwischenzähler")],-1)
printHtmlPart(8)
for( z in (mietsacheInstance?.zwischenzaehlers) ) {
printHtmlPart(9)
createTagBody(2, {->
expressionOut.print(z?.encodeAsHTML())
})
invokeTag('link','g',45,['controller':("zaehler"),'action':("show"),'id':(z.id)],2)
printHtmlPart(10)
}
printHtmlPart(11)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'zwischenzaehler.label', default: 'Zwischenzähler')]))
})
invokeTag('link','g',48,['controller':("zwischenzaehler"),'action':("create"),'params':(['mietsache.id': mietsacheInstance?.id])],1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: mietsacheInstance, field: 'immobilie', 'error'))
printHtmlPart(13)
invokeTag('message','g',56,['code':("mietsache.immobilie.label"),'default':("Immobilie")],-1)
printHtmlPart(14)
invokeTag('select','g',59,['id':("immobilie"),'name':("immobilie.id"),'from':(org.strotmann.immos.Immobilie.list()),'optionKey':("id"),'required':(""),'value':(mietsacheInstance?.immobilie?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: mietsacheInstance, field: 'notizen', 'error'))
printHtmlPart(15)
invokeTag('message','g',64,['code':("mietsache.notizen.label"),'default':("Notizen")],-1)
printHtmlPart(8)
for( n in (org.strotmann.immos.Notiz.getNotizen('Mietsache',mietsacheInstance.id)) ) {
printHtmlPart(9)
createTagBody(2, {->
expressionOut.print(n)
})
invokeTag('link','g',70,['controller':("notiz"),'action':("show"),'id':(n.id)],2)
printHtmlPart(10)
}
printHtmlPart(11)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'notiz.label', default: 'Notiz')]))
})
invokeTag('link','g',73,['controller':("notiz"),'action':("create"),'params':(['mietsache.id': mietsacheInstance?.id])],1)
printHtmlPart(16)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1412526736000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
