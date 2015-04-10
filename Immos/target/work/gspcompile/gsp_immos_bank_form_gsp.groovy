import org.strotmann.immos.Bank
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_bank_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/bank/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: bankInstance, field: 'bic', 'error'))
printHtmlPart(1)
invokeTag('message','g',5,['code':("bank.bic.label"),'default':("Bic")],-1)
printHtmlPart(2)
invokeTag('textField','g',8,['name':("bic"),'value':(bankInstance?.bic)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: bankInstance, field: 'blz', 'error'))
printHtmlPart(4)
invokeTag('message','g',14,['code':("bank.blz.label"),'default':("Blz")],-1)
printHtmlPart(2)
invokeTag('field','g',17,['name':("blz"),'type':("number"),'value':(bankInstance.blz)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: bankInstance, field: 'bankname', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("bank.bankname.label"),'default':("Bankname")],-1)
printHtmlPart(2)
invokeTag('textField','g',26,['name':("bankname"),'value':(bankInstance?.bankname)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: bankInstance, field: 'plz', 'error'))
printHtmlPart(6)
invokeTag('message','g',32,['code':("bank.plz.label"),'default':("Plz")],-1)
printHtmlPart(2)
invokeTag('field','g',35,['name':("plz"),'type':("number"),'value':(bankInstance.plz)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: bankInstance, field: 'ort', 'error'))
printHtmlPart(7)
invokeTag('message','g',41,['code':("bank.ort.label"),'default':("Ort")],-1)
printHtmlPart(2)
invokeTag('textField','g',44,['name':("ort"),'value':(bankInstance?.ort)],-1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1411746738000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
