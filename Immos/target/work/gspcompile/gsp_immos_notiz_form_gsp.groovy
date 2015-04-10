import org.strotmann.immos.Notiz
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_notiz_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/notiz/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: notizInstance, field: 'anlagetermin', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("notiz.anlagetermin.label"),'default':("Anlagetermin")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',10,['name':("anlagetermin"),'precision':("day"),'value':(notizInstance?.anlagetermin)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: notizInstance, field: 'notiztext', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("notiz.notiztext.label"),'default':("Notiztext")],-1)
printHtmlPart(2)
invokeTag('textArea','g',19,['name':("notiztext"),'required':(""),'value':(notizInstance?.notiztext),'rows':("2"),'cols':("80")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: notizInstance, field: 'referenz', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("notiz.referenz.label"),'default':("Referenz")],-1)
printHtmlPart(2)
if(true && (flash.referenz)) {
printHtmlPart(6)
if(true && (flash.domref)) {
printHtmlPart(7)
invokeTag('textArea','g',30,['name':("referenz"),'required':(""),'value':("${flash.referenz} ${flash.domref.toString()}"),'rows':("2"),'cols':("80")],-1)
printHtmlPart(6)
}
else {
printHtmlPart(7)
invokeTag('select','g',33,['name':("referenz"),'from':(Notiz.getRefs(flash.domName))],-1)
printHtmlPart(6)
}
printHtmlPart(8)
}
else {
printHtmlPart(6)
invokeTag('textArea','g',37,['name':("referenz"),'required':(""),'value':(notizInstance?.referenz),'rows':("2"),'cols':("80")],-1)
printHtmlPart(8)
}
printHtmlPart(3)
expressionOut.print(hasErrors(bean: notizInstance, field: 'wiedervorlagetermin', 'error'))
printHtmlPart(9)
invokeTag('message','g',44,['code':("notiz.wiedervorlagetermin.label"),'default':("Wiedervorlagetermin")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',47,['name':("wiedervorlagetermin"),'precision':("day"),'value':(notizInstance?.wiedervorlagetermin)],-1)
printHtmlPart(10)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1412422640000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
