import org.strotmann.immos.Betriebskostenabrechnung
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_betriebskostenabrechnung_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/betriebskostenabrechnung/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: betriebskostenabrechnungInstance, field: 'heizkostenabrechnungen', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("betriebskostenabrechnung.heizkostenabrechnungen.label"),'default':("Heizkostenabrechnungen")],-1)
printHtmlPart(2)
for( h in (betriebskostenabrechnungInstance?.heizkostenabrechnungen) ) {
printHtmlPart(3)
createTagBody(2, {->
expressionOut.print(h?.encodeAsHTML())
})
invokeTag('link','g',13,['controller':("heizkostenabrechnung"),'action':("show"),'id':(h.id)],2)
printHtmlPart(4)
}
printHtmlPart(5)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'heizkostenabrechnung.label', default: 'Heizkostenabrechnung')]))
})
invokeTag('link','g',16,['controller':("heizkostenabrechnung"),'action':("create"),'params':(['betriebskostenabrechnung.id': betriebskostenabrechnungInstance?.id])],1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: betriebskostenabrechnungInstance, field: 'immoabrechnung', 'error'))
printHtmlPart(7)
invokeTag('message','g',25,['code':("betriebskostenabrechnung.immoabrechnung.label"),'default':("Immoabrechnung")],-1)
printHtmlPart(8)
invokeTag('select','g',28,['id':("immoabrechnung"),'name':("immoabrechnung.id"),'from':(org.strotmann.immos.Immoabrechnung.list()),'optionKey':("id"),'required':(""),'value':(betriebskostenabrechnungInstance?.immoabrechnung?.id),'class':("many-to-one")],-1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: betriebskostenabrechnungInstance, field: 'mietvertrag', 'error'))
printHtmlPart(10)
invokeTag('message','g',34,['code':("betriebskostenabrechnung.mietvertrag.label"),'default':("Mietvertrag")],-1)
printHtmlPart(8)
invokeTag('select','g',37,['id':("mietvertrag"),'name':("mietvertrag.id"),'from':(org.strotmann.immos.Mietvertrag.list()),'optionKey':("id"),'required':(""),'value':(betriebskostenabrechnungInstance?.mietvertrag?.id),'class':("many-to-one")],-1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: betriebskostenabrechnungInstance, field: 'nebenkostenabrechnungen', 'error'))
printHtmlPart(11)
invokeTag('message','g',43,['code':("betriebskostenabrechnung.nebenkostenabrechnungen.label"),'default':("Nebenkostenabrechnungen")],-1)
printHtmlPart(2)
for( n in (betriebskostenabrechnungInstance?.nebenkostenabrechnungen) ) {
printHtmlPart(3)
createTagBody(2, {->
expressionOut.print(n?.encodeAsHTML())
})
invokeTag('link','g',49,['controller':("nebenkostenabrechnung"),'action':("show"),'id':(n.id)],2)
printHtmlPart(4)
}
printHtmlPart(5)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'nebenkostenabrechnung.label', default: 'Nebenkostenabrechnung')]))
})
invokeTag('link','g',52,['controller':("nebenkostenabrechnung"),'action':("create"),'params':(['betriebskostenabrechnung.id': betriebskostenabrechnungInstance?.id])],1)
printHtmlPart(12)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1412758677000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
