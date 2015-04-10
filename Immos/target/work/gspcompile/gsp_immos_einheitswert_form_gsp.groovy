import org.strotmann.immos.Einheitswert
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_einheitswert_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/einheitswert/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: einheitswertInstance, field: 'ewNummer', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("einheitswert.ewNummer.label"),'default':("Ew Nummer")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("ewNummer"),'value':(einheitswertInstance?.ewNummer)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: einheitswertInstance, field: 'gueltigAb', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("einheitswert.gueltigAb.label"),'default':("Gueltig Ab")],-1)
printHtmlPart(5)
invokeTag('datePicker','g',18,['name':("gueltigAb"),'precision':("day"),'value':(einheitswertInstance?.gueltigAb)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: einheitswertInstance, field: 'wert', 'error'))
printHtmlPart(6)
invokeTag('message','g',23,['code':("einheitswert.wert.label"),'default':("Wert")],-1)
printHtmlPart(5)
invokeTag('field','g',26,['name':("wert"),'value':(fieldValue(bean: einheitswertInstance, field: 'wert')),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: einheitswertInstance, field: 'immobilie', 'error'))
printHtmlPart(7)
invokeTag('message','g',31,['code':("einheitswert.immobilie.label"),'default':("Immobilie")],-1)
printHtmlPart(5)
invokeTag('select','g',34,['id':("immobilie"),'name':("immobilie.id"),'from':(org.strotmann.immos.Immobilie.list()),'optionKey':("id"),'required':(""),'value':(einheitswertInstance?.immobilie?.id),'class':("many-to-one")],-1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1394813022000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
