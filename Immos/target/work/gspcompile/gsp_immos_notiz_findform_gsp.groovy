import org.strotmann.immos.Notiz
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_notiz_findform_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/notiz/_findform.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: notizInstance, field: 'anlagetermin', 'error'))
printHtmlPart(1)
invokeTag('message','g',5,['code':("notiz.anlagetermin.label"),'default':("Anlagetermin")],-1)
printHtmlPart(2)
invokeTag('select','g',7,['name':("notizInstance.anlOp"),'from':([' ','<','<=','=','>','>='])],-1)
printHtmlPart(3)
invokeTag('datePicker','g',8,['name':("anlagetermin"),'precision':("day"),'value':(notizInstance?.anlagetermin)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: notizInstance, field: 'notiztext', 'error'))
printHtmlPart(5)
invokeTag('message','g',13,['code':("notiz.notiztext.label"),'default':("Notiztext")],-1)
printHtmlPart(2)
invokeTag('textField','g',15,['name':("notiztext"),'value':("")],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: notizInstance, field: 'referenz', 'error'))
printHtmlPart(6)
invokeTag('message','g',20,['code':("notiz.referenz.label"),'default':("Referenz")],-1)
printHtmlPart(2)
invokeTag('textField','g',22,['name':("referenz"),'value':("")],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: notizInstance, field: 'wiedervorlagetermin', 'error'))
printHtmlPart(7)
invokeTag('message','g',27,['code':("notiz.wiedervorlagetermin.label"),'default':("Wiedervorlagetermin")],-1)
printHtmlPart(2)
invokeTag('select','g',29,['name':("notizInstance.wvOp"),'from':([' ','<','<=','=','>','>='])],-1)
printHtmlPart(3)
invokeTag('datePicker','g',30,['name':("wiedervorlagetermin"),'precision':("day"),'value':(notizInstance?.wiedervorlagetermin)],-1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1412347586000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
