import org.strotmann.immos.OffenerPosten
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_offenerPosten_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/offenerPosten/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: offenerPostenInstance, field: 'faelligkeit', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("offenerPosten.faelligkeit.label"),'default':("Faelligkeit")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',10,['name':("faelligkeit"),'precision':("day"),'value':(offenerPostenInstance?.faelligkeit)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: offenerPostenInstance, field: 'grund', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("offenerPosten.grund.label"),'default':("Grund")],-1)
printHtmlPart(5)
invokeTag('textField','g',18,['name':("grund"),'value':(offenerPostenInstance?.grund)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: offenerPostenInstance, field: 'betrag', 'error'))
printHtmlPart(6)
invokeTag('message','g',23,['code':("offenerPosten.betrag.label"),'default':("Betrag")],-1)
printHtmlPart(2)
invokeTag('field','g',26,['name':("betrag"),'value':(fieldValue(bean: offenerPostenInstance, field: 'betrag')),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: offenerPostenInstance, field: 'mietvertrag', 'error'))
printHtmlPart(7)
invokeTag('message','g',31,['code':("offenerPosten.mietvertrag.label"),'default':("Mietvertrag")],-1)
printHtmlPart(5)
invokeTag('select','g',34,['id':("mietvertrag"),'name':("mietvertrag.id"),'from':(org.strotmann.immos.Mietvertrag.list()),'optionKey':("id"),'value':(offenerPostenInstance?.mietvertrag?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: offenerPostenInstance, field: 'dienstleistungsvertrag', 'error'))
printHtmlPart(8)
invokeTag('message','g',39,['code':("offenerPosten.dienstleistungsvertrag.label"),'default':("Dienstleistungsvertrag")],-1)
printHtmlPart(5)
invokeTag('select','g',42,['id':("dienstleistungsvertrag"),'name':("dienstleistungsvertrag.id"),'from':(org.strotmann.immos.Dienstleistungsvertrag.list()),'optionKey':("id"),'value':(offenerPostenInstance?.dienstleistungsvertrag?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: offenerPostenInstance, field: 'rechnung', 'error'))
printHtmlPart(9)
invokeTag('message','g',47,['code':("offenerPosten.rechnung.label"),'default':("Rechnung")],-1)
printHtmlPart(5)
invokeTag('select','g',50,['id':("rechnung"),'name':("rechnung.id"),'from':(org.strotmann.immos.Rechnung.list()),'optionKey':("id"),'value':(offenerPostenInstance?.rechnung?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: offenerPostenInstance, field: 'kredit', 'error'))
printHtmlPart(10)
invokeTag('message','g',55,['code':("offenerPosten.kredit.label"),'default':("Kredit")],-1)
printHtmlPart(5)
invokeTag('select','g',58,['id':("kredit"),'name':("kredit.id"),'from':(org.strotmann.immos.Kredit.list()),'optionKey':("id"),'value':(offenerPostenInstance?.kredit?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(11)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1397115008000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
