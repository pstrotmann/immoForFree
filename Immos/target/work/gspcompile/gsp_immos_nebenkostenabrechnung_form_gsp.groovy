import org.strotmann.immos.Nebenkostenabrechnung
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_nebenkostenabrechnung_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/nebenkostenabrechnung/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: nebenkostenabrechnungInstance, field: 'betriebskostenabrechnung', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("nebenkostenabrechnung.betriebskostenabrechnung.label"),'default':("Betriebskostenabrechnung")],-1)
printHtmlPart(2)
invokeTag('select','g',10,['id':("betriebskostenabrechnung"),'name':("betriebskostenabrechnung.id"),'from':(org.strotmann.immos.Betriebskostenabrechnung.list()),'optionKey':("id"),'required':(""),'value':(nebenkostenabrechnungInstance?.betriebskostenabrechnung?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: nebenkostenabrechnungInstance, field: 'umlageanteile', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("nebenkostenabrechnung.umlageanteile.label"),'default':("Umlageanteile")],-1)
printHtmlPart(5)
for( u in (nebenkostenabrechnungInstance?.umlageanteile) ) {
printHtmlPart(6)
createTagBody(2, {->
expressionOut.print(u?.encodeAsHTML())
})
invokeTag('link','g',22,['controller':("umlageanteil"),'action':("show"),'id':(u.id)],2)
printHtmlPart(7)
}
printHtmlPart(8)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'umlageanteil.label', default: 'Umlageanteil')]))
})
invokeTag('link','g',25,['controller':("umlageanteil"),'action':("create"),'params':(['nebenkostenabrechnung.id': nebenkostenabrechnungInstance?.id])],1)
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1412759382000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
