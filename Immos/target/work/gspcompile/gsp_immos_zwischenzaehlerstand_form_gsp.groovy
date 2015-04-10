import org.strotmann.immos.Zwischenzaehlerstand
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_zwischenzaehlerstand_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/zwischenzaehlerstand/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: zwischenzaehlerstandInstance, field: 'ablesedatum', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("zwischenzaehlerstand.ablesedatum.label"),'default':("Ablesedatum")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',10,['name':("ablesedatum"),'precision':("day"),'value':(zwischenzaehlerstandInstance?.ablesedatum)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: zwischenzaehlerstandInstance, field: 'wert', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("zwischenzaehlerstand.wert.label"),'default':("Wert")],-1)
printHtmlPart(2)
invokeTag('field','g',18,['name':("wert"),'value':(fieldValue(bean: zwischenzaehlerstandInstance, field: 'wert')),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: zwischenzaehlerstandInstance, field: 'zz', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("zwischenzaehlerstand.zz.label"),'default':("Zwischenzähler")],-1)
printHtmlPart(2)
invokeTag('select','g',26,['id':("zz"),'name':("zz.id"),'from':(flash.zwischenzaehler),'optionKey':("id"),'required':(""),'value':(zwischenzaehlerstandInstance?.zz?.id),'class':("many-to-one")],-1)
printHtmlPart(6)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401869230000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
