import org.strotmann.immos.Heizkostenabrechnung
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_heizkostenabrechnung_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/heizkostenabrechnung/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: heizkostenabrechnungInstance, field: 'von', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("heizkostenabrechnung.von.label"),'default':("Von")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',10,['name':("von"),'precision':("day"),'value':(heizkostenabrechnungInstance?.von)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: heizkostenabrechnungInstance, field: 'bis', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("heizkostenabrechnung.bis.label"),'default':("Bis")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',19,['name':("bis"),'precision':("day"),'value':(heizkostenabrechnungInstance?.bis)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: heizkostenabrechnungInstance, field: 'betrag', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("heizkostenabrechnung.betrag.label"),'default':("Betrag")],-1)
printHtmlPart(2)
invokeTag('field','g',28,['name':("betrag"),'value':(fieldValue(bean: heizkostenabrechnungInstance, field: 'betrag')),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: heizkostenabrechnungInstance, field: 'betriebskostenabrechnung', 'error'))
printHtmlPart(6)
invokeTag('message','g',34,['code':("heizkostenabrechnung.betriebskostenabrechnung.label"),'default':("Betriebskostenabrechnung")],-1)
printHtmlPart(2)
invokeTag('select','g',37,['id':("betriebskostenabrechnung"),'name':("betriebskostenabrechnung.id"),'from':(org.strotmann.immos.Betriebskostenabrechnung.list()),'optionKey':("id"),'required':(""),'value':(heizkostenabrechnungInstance?.betriebskostenabrechnung?.id),'class':("many-to-one")],-1)
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1410360520000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
