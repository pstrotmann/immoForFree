import org.strotmann.immos.Kreditstand
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_kreditstand_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/kreditstand/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: kreditstandInstance, field: 'laufzeitAb', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("kreditstand.laufzeitAb.label"),'default':("Laufzeit Ab")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',10,['name':("laufzeitAb"),'precision':("day"),'value':(kreditstandInstance?.laufzeitAb)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: kreditstandInstance, field: 'laufzeitBis', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("kreditstand.laufzeitBis.label"),'default':("Laufzeit Bis")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',18,['name':("laufzeitBis"),'precision':("day"),'value':(kreditstandInstance?.laufzeitBis)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: kreditstandInstance, field: 'kreditsumme', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("kreditstand.kreditsumme.label"),'default':("Kreditsumme")],-1)
printHtmlPart(2)
invokeTag('field','g',26,['name':("kreditsumme"),'value':(fieldValue(bean: kreditstandInstance, field: 'kreditsumme')),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: kreditstandInstance, field: 'bewilligt', 'error'))
printHtmlPart(6)
invokeTag('message','g',31,['code':("kreditstand.bewilligt.label"),'default':("bewilligtes Darlehen")],-1)
printHtmlPart(7)
invokeTag('field','g',33,['name':("bewilligt"),'value':(fieldValue(bean: kreditstandInstance, field: 'bewilligt'))],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: kreditstandInstance, field: 'zinssatz', 'error'))
printHtmlPart(8)
invokeTag('message','g',38,['code':("kreditstand.zinssatz.label"),'default':("Zinssatz")],-1)
printHtmlPart(7)
invokeTag('field','g',40,['name':("zinssatz"),'value':(fieldValue(bean: kreditstandInstance, field: 'zinssatz'))],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: kreditstandInstance, field: 'tilgungssatz', 'error'))
printHtmlPart(9)
invokeTag('message','g',45,['code':("kreditstand.tilgungssatz.label"),'default':("Tilgungssatz")],-1)
printHtmlPart(7)
invokeTag('field','g',47,['name':("tilgungssatz"),'value':(fieldValue(bean: kreditstandInstance, field: 'tilgungssatz'))],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: kreditstandInstance, field: 'annuitaet', 'error'))
printHtmlPart(10)
invokeTag('message','g',52,['code':("kreditstand.annuitaet.label"),'default':("Annuität")],-1)
printHtmlPart(7)
invokeTag('field','g',54,['name':("annuitaet"),'value':(fieldValue(bean: kreditstandInstance, field: 'annuitaet'))],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: kreditstandInstance, field: 'zinsbetrag', 'error'))
printHtmlPart(11)
invokeTag('message','g',59,['code':("kreditstand.zinsbetrag.label"),'default':("Zinsbetrag")],-1)
printHtmlPart(12)
invokeTag('field','g',62,['name':("zinsbetrag"),'value':(fieldValue(bean: kreditstandInstance, field: 'zinsbetrag'))],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: kreditstandInstance, field: 'tilgungsbetrag', 'error'))
printHtmlPart(13)
invokeTag('message','g',67,['code':("kreditstand.tilgungsbetrag.label"),'default':("Tilgungsbetrag")],-1)
printHtmlPart(12)
invokeTag('field','g',70,['name':("tilgungsbetrag"),'value':(fieldValue(bean: kreditstandInstance, field: 'tilgungsbetrag'))],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: kreditstandInstance, field: 'verwKostenbetrag', 'error'))
printHtmlPart(14)
invokeTag('message','g',75,['code':("kreditstand.verwKostenbetrag.label"),'default':("Verw Kostenbetrag")],-1)
printHtmlPart(12)
invokeTag('field','g',78,['name':("verwKostenbetrag"),'value':(fieldValue(bean: kreditstandInstance, field: 'verwKostenbetrag'))],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: kreditstandInstance, field: 'sondertilgung', 'error'))
printHtmlPart(15)
invokeTag('message','g',83,['code':("kreditstand.sondertilgung.label"),'default':("Sondertilgung")],-1)
printHtmlPart(12)
invokeTag('field','g',86,['name':("sondertilgung"),'value':(fieldValue(bean: kreditstandInstance, field: 'sondertilgung'))],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: kreditstandInstance, field: 'kredit', 'error'))
printHtmlPart(16)
invokeTag('message','g',91,['code':("kreditstand.kredit.label"),'default':("Kredit")],-1)
printHtmlPart(2)
invokeTag('select','g',94,['id':("kredit"),'name':("kredit.id"),'from':(org.strotmann.immos.Kredit.list()),'optionKey':("id"),'required':(""),'value':(kreditstandInstance?.kredit?.id),'class':("many-to-one")],-1)
printHtmlPart(17)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1397995486000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
