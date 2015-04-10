import org.strotmann.immos.Zaehlerstand
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_zaehlerstand_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/zaehlerstand/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: zaehlerstandInstance, field: 'ablesedatum', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("zaehlerstand.ablesedatum.label"),'default':("Ablesedatum")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',10,['name':("ablesedatum"),'precision':("day"),'value':(zaehlerstandInstance?.ablesedatum)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: zaehlerstandInstance, field: 'wert', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("zaehlerstand.wert.label"),'default':("Wert")],-1)
printHtmlPart(2)
invokeTag('field','g',18,['name':("wert"),'value':(fieldValue(bean: zaehlerstandInstance, field: 'wert')),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: zaehlerstandInstance, field: 'z', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("zaehlerstand.z.label"),'default':("Zähler")],-1)
printHtmlPart(2)
invokeTag('select','g',26,['id':("z"),'name':("z.id"),'from':(flash.zaehler),'optionKey':("id"),'required':(""),'value':(zaehlerstandInstance?.z?.id),'class':("many-to-one")],-1)
printHtmlPart(6)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401818744000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
