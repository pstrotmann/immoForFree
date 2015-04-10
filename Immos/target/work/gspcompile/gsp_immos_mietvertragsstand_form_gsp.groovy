import org.strotmann.immos.Mietvertragsstand
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_mietvertragsstand_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mietvertragsstand/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: mietvertragsstandInstance, field: 'mietvertrag', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("mietvertragsstand.mietvertrag.label"),'default':("Mietvertrag")],-1)
printHtmlPart(2)
invokeTag('select','g',10,['id':("mietvertrag"),'name':("mietvertrag.id"),'from':(mietvertragsstandInstance.mietvertrag),'optionKey':("id"),'required':(""),'value':(mietvertragsstandInstance?.mietvertrag?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: mietvertragsstandInstance, field: 'gueltigAb', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("mietvertragsstand.gueltigAb.label"),'default':("Gueltig Ab")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',18,['name':("gueltigAb"),'precision':("day"),'value':(mietvertragsstandInstance?.gueltigAb)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: mietvertragsstandInstance, field: 'grundmiete', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("mietvertragsstand.grundmiete.label"),'default':("Grundmiete")],-1)
printHtmlPart(2)
invokeTag('field','g',26,['name':("grundmiete"),'value':(fieldValue(bean: mietvertragsstandInstance, field: 'grundmiete')),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: mietvertragsstandInstance, field: 'qmMiete', 'error'))
printHtmlPart(6)
invokeTag('message','g',31,['code':("mietvertragsstand.qmMiete.label"),'default':("Qm Miete")],-1)
printHtmlPart(2)
invokeTag('field','g',34,['name':("qmMiete"),'value':(fieldValue(bean: mietvertragsstandInstance, field: 'qmMiete')),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: mietvertragsstandInstance, field: 'nebenkostenpauschale', 'error'))
printHtmlPart(7)
invokeTag('message','g',39,['code':("mietvertragsstand.nebenkostenpauschale.label"),'default':("Nebenkostenpauschale")],-1)
printHtmlPart(2)
invokeTag('field','g',42,['name':("nebenkostenpauschale"),'value':(fieldValue(bean: mietvertragsstandInstance, field: 'nebenkostenpauschale')),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: mietvertragsstandInstance, field: 'heizkostenpauschale', 'error'))
printHtmlPart(8)
invokeTag('message','g',47,['code':("mietvertragsstand.heizkostenpauschale.label"),'default':("Heizkostenpauschale")],-1)
printHtmlPart(2)
invokeTag('field','g',50,['name':("heizkostenpauschale"),'value':(fieldValue(bean: mietvertragsstandInstance, field: 'heizkostenpauschale')),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: mietvertragsstandInstance, field: 'zusatzmiete', 'error'))
printHtmlPart(9)
invokeTag('message','g',55,['code':("mietvertragsstand.zusatzmiete.label"),'default':(mietvertragsstandInstance.mietvertrag?.zusatzMietsache ? mietvertragsstandInstance.mietvertrag.zusatzMietsache.art : 'Zusatz')],-1)
printHtmlPart(2)
invokeTag('field','g',58,['name':("zusatzmiete"),'value':(fieldValue(bean: mietvertragsstandInstance, field: 'zusatzmiete')),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: mietvertragsstandInstance, field: 'anzahlPersonen', 'error'))
printHtmlPart(10)
invokeTag('message','g',63,['code':("mietvertragsstand.anzahlPersonen.label"),'default':("Anzahl Personen")],-1)
printHtmlPart(2)
invokeTag('field','g',66,['name':("anzahlPersonen"),'type':("number"),'max':("6"),'value':(mietvertragsstandInstance.anzahlPersonen),'required':("")],-1)
printHtmlPart(11)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1407334336000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
