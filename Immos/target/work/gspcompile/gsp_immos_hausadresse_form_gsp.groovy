import org.strotmann.immos.Hausadresse
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_hausadresse_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/hausadresse/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: hausadresseInstance, field: 'strasse', 'error'))
printHtmlPart(1)
invokeTag('message','g',6,['code':("hausadresse.strasse.label"),'default':("Strasse")],-1)
printHtmlPart(2)
invokeTag('textField','g',9,['name':("strasse"),'maxlength':("50"),'pattern':(hausadresseInstance.constraints.strasse.matches),'required':(""),'value':(hausadresseInstance?.strasse)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: hausadresseInstance, field: 'hausnummer', 'error'))
printHtmlPart(4)
invokeTag('message','g',14,['code':("hausadresse.hausnummer.label"),'default':("Hausnummer")],-1)
printHtmlPart(2)
invokeTag('field','g',17,['name':("hausnummer"),'type':("number"),'min':("1"),'max':("1000"),'value':(hausadresseInstance.hausnummer),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: hausadresseInstance, field: 'zusatz', 'error'))
printHtmlPart(5)
invokeTag('message','g',22,['code':("hausadresse.zusatz.label"),'default':("Zusatz")],-1)
printHtmlPart(6)
invokeTag('textField','g',25,['name':("zusatz"),'maxlength':("10"),'value':(hausadresseInstance?.zusatz)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: hausadresseInstance, field: 'postleitzahl', 'error'))
printHtmlPart(7)
invokeTag('message','g',30,['code':("hausadresse.postleitzahl.label"),'default':("Postleitzahl")],-1)
printHtmlPart(2)
invokeTag('field','g',33,['name':("postleitzahl"),'type':("number"),'min':("1000"),'max':("99999"),'value':(hausadresseInstance.postleitzahl),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: hausadresseInstance, field: 'ort', 'error'))
printHtmlPart(8)
invokeTag('message','g',38,['code':("hausadresse.ort.label"),'default':("Ort")],-1)
printHtmlPart(2)
invokeTag('textField','g',41,['name':("ort"),'maxlength':("50"),'pattern':(hausadresseInstance.constraints.ort.matches),'required':(""),'value':(hausadresseInstance?.ort)],-1)
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1414598923000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
