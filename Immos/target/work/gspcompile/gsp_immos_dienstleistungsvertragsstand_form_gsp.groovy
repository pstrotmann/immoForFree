import org.strotmann.immos.Dienstleistungsvertragsstand
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_dienstleistungsvertragsstand_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/dienstleistungsvertragsstand/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: dienstleistungsvertragsstandInstance, field: 'gueltigAb', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("dienstleistungsvertragsstand.gueltigAb.label"),'default':("Gueltig Ab")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',10,['name':("gueltigAb"),'precision':("day"),'value':(dienstleistungsvertragsstandInstance?.gueltigAb)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: dienstleistungsvertragsstandInstance, field: 'pauschale', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("dienstleistungsvertragsstand.pauschale.label"),'default':("Pauschale")],-1)
printHtmlPart(2)
invokeTag('field','g',18,['name':("pauschale"),'value':(fieldValue(bean: dienstleistungsvertragsstandInstance, field: 'pauschale')),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: dienstleistungsvertragsstandInstance, field: 'dienstleistungsvertrag', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("dienstleistungsvertragsstand.dienstleistungsvertrag.label"),'default':("Dienstleistungsvertrag")],-1)
printHtmlPart(2)
invokeTag('select','g',26,['id':("dienstleistungsvertrag"),'name':("dienstleistungsvertrag.id"),'from':(org.strotmann.immos.Dienstleistungsvertrag.list()),'optionKey':("id"),'required':(""),'value':(dienstleistungsvertragsstandInstance?.dienstleistungsvertrag?.id),'class':("many-to-one")],-1)
printHtmlPart(6)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1397291234000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
