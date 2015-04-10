import org.strotmann.immos.Zahlung
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_zahlung_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/zahlung/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: zahlungInstance, field: 'datum', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("zahlung.datum.label"),'default':("Datum")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',10,['name':("datum"),'precision':("day"),'value':(zahlungInstance?.datum)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: zahlungInstance, field: 'betrag', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("zahlung.buchungsjahr.label"),'default':("Buchungsjahr")],-1)
printHtmlPart(2)
invokeTag('field','g',18,['name':("buchungsjahr"),'value':(fieldValue(bean: zahlungInstance, field: 'buchungsjahr')),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: zahlungInstance, field: 'betrag', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("zahlung.betrag.label"),'default':("Betrag")],-1)
printHtmlPart(2)
invokeTag('field','g',26,['name':("betrag"),'value':(fieldValue(bean: zahlungInstance, field: 'betrag')),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: zahlungInstance, field: 'mietvertrag', 'error'))
printHtmlPart(6)
invokeTag('message','g',31,['code':("zahlung.mietvertrag.label"),'default':("Mietvertrag")],-1)
printHtmlPart(7)
invokeTag('select','g',34,['id':("mietvertrag"),'name':("mietvertrag.id"),'from':(org.strotmann.immos.Mietvertrag.list()),'optionKey':("id"),'value':(zahlungInstance?.mietvertrag?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: zahlungInstance, field: 'rechnung', 'error'))
printHtmlPart(8)
invokeTag('message','g',39,['code':("zahlung.rechnung.label"),'default':("Rechnung")],-1)
printHtmlPart(7)
invokeTag('select','g',42,['id':("rechnung"),'name':("rechnung.id"),'from':(org.strotmann.immos.Rechnung.list()),'optionKey':("id"),'value':(zahlungInstance?.rechnung?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: zahlungInstance, field: 'dienstleistungsvertrag', 'error'))
printHtmlPart(9)
invokeTag('message','g',47,['code':("zahlung.dienstleistungsvertrag.label"),'default':("Dienstleistungsvertrag")],-1)
printHtmlPart(7)
invokeTag('select','g',50,['id':("dienstleistungsvertrag"),'name':("dienstleistungsvertrag.id"),'from':(org.strotmann.immos.Dienstleistungsvertrag.list()),'optionKey':("id"),'value':(zahlungInstance?.dienstleistungsvertrag?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: zahlungInstance, field: 'kredit', 'error'))
printHtmlPart(10)
invokeTag('message','g',55,['code':("zahlung.kredit.label"),'default':("Kredit")],-1)
printHtmlPart(7)
invokeTag('select','g',58,['id':("kredit"),'name':("kredit.id"),'from':(org.strotmann.immos.Kredit.list()),'optionKey':("id"),'value':(zahlungInstance?.kredit?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: zahlungInstance, field: 'bankumsatz', 'error'))
printHtmlPart(11)
invokeTag('message','g',63,['code':("zahlung.bankumsatz.label"),'default':("Bankumsatz")],-1)
printHtmlPart(7)
invokeTag('select','g',66,['id':("bankumsatz"),'name':("bankumsatz.id"),'from':(org.strotmann.immos.Bankumsatz.getUmsaetze()),'optionKey':("id"),'value':(zahlungInstance?.bankumsatz?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(12)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1420212432000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
