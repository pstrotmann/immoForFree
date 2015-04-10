import org.strotmann.immos.User
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_user_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/user/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: userInstance, field: 'name', 'error'))
printHtmlPart(2)
invokeTag('message','g',9,['code':("user.name.label"),'default':("Name")],-1)
printHtmlPart(3)
invokeTag('textField','g',12,['name':("name"),'value':(flash.name?:'')],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: userInstance, field: 'passwort', 'error'))
printHtmlPart(5)
invokeTag('message','g',17,['code':("user.passwort.label"),'default':("Passwort")],-1)
printHtmlPart(3)
invokeTag('passwordField','g',20,['name':("passwort"),'value':(userInstance?.passwort)],-1)
printHtmlPart(6)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1399291506000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
