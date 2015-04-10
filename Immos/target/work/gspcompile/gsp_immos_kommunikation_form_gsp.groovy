import org.strotmann.immos.Kommunikation
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_kommunikation_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/kommunikation/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: kommunikationInstance, field: 'art', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("kommunikation.art.label"),'default':("Art")],-1)
printHtmlPart(2)
invokeTag('select','g',10,['name':("art"),'from':(kommunikationInstance.constraints.art.inList),'value':(kommunikationInstance?.art),'valueMessagePrefix':("kommunikation.art"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: kommunikationInstance, field: 'anwahl', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("kommunikation.anwahl.label"),'default':("Anwahl")],-1)
printHtmlPart(5)
invokeTag('textField','g',18,['name':("anwahl"),'required':(""),'value':(kommunikationInstance?.anwahl)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: kommunikationInstance, field: 'zusatz', 'error'))
printHtmlPart(6)
invokeTag('message','g',23,['code':("kommunikation.zusatz.label"),'default':("Zusatz")],-1)
printHtmlPart(2)
invokeTag('textField','g',26,['name':("zusatz"),'value':(kommunikationInstance?.zusatz)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: kommunikationInstance, field: 'partner', 'error'))
printHtmlPart(7)
invokeTag('message','g',31,['code':("kommunikation.partner.label"),'default':("Partner")],-1)
printHtmlPart(5)
if(true && (flash.partner)) {
printHtmlPart(8)
invokeTag('select','g',35,['id':("partner"),'name':("partner.id"),'from':(flash.partner),'optionKey':("id"),'required':(""),'value':(kommunikationInstance?.partner?.id),'class':("many-to-one")],-1)
printHtmlPart(9)
}
else {
printHtmlPart(8)
invokeTag('select','g',38,['id':("partner"),'name':("partner.id"),'from':(kommunikationInstance?.partner),'optionKey':("id"),'required':(""),'value':(kommunikationInstance?.partner?.id),'class':("many-to-one")],-1)
printHtmlPart(9)
}
printHtmlPart(10)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1411550232000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
