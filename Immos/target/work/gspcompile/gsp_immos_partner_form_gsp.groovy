import org.strotmann.immos.Partner
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_partner_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/partner/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: partnerInstance, field: 'name', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("partner.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("name"),'value':(partnerInstance?.name)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: partnerInstance, field: 'hausadresse', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("partner.hausadresse.label"),'default':("Hausadresse")],-1)
printHtmlPart(2)
invokeTag('select','g',18,['id':("hausadresse"),'name':("hausadresse.id"),'from':(org.strotmann.immos.Hausadresse.getMinilist()),'optionKey':("id"),'value':(partnerInstance?.hausadresse?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: partnerInstance, field: 'bankverbindung', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("partner.bankverbindung.label"),'default':("Bankverbindung")],-1)
printHtmlPart(6)
for( b in (partnerInstance?.bankverbindung) ) {
printHtmlPart(7)
createTagBody(2, {->
expressionOut.print(b?.encodeAsHTML())
})
invokeTag('link','g',29,['controller':("bankverbindung"),'action':("show"),'id':(b.id)],2)
printHtmlPart(8)
}
printHtmlPart(9)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'bankverbindung.label', default: 'Bankverbindung')]))
})
invokeTag('link','g',32,['controller':("bankverbindung"),'action':("create"),'params':(['partner.id': partnerInstance?.id])],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: partnerInstance, field: 'kommunikation', 'error'))
printHtmlPart(11)
invokeTag('message','g',40,['code':("partner.kommunikation.label"),'default':("Kommunikation")],-1)
printHtmlPart(6)
for( k in (partnerInstance?.kommunikation) ) {
printHtmlPart(7)
createTagBody(2, {->
expressionOut.print(k?.encodeAsHTML())
})
invokeTag('link','g',46,['controller':("kommunikation"),'action':("show"),'id':(k.id)],2)
printHtmlPart(8)
}
printHtmlPart(9)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'kommunikation.label', default: 'Kommunikation')]))
})
invokeTag('link','g',49,['controller':("kommunikation"),'action':("create"),'params':(['partner.id': partnerInstance?.id])],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: partnerInstance, field: 'partnerrolle', 'error'))
printHtmlPart(12)
invokeTag('message','g',57,['code':("partner.partnerrolle.label"),'default':("Partnerrolle")],-1)
printHtmlPart(6)
for( p in (partnerInstance?.partnerrolle) ) {
printHtmlPart(7)
createTagBody(2, {->
expressionOut.print(p?.encodeAsHTML())
})
invokeTag('link','g',63,['controller':("partnerrolle"),'action':("show"),'id':(p.id)],2)
printHtmlPart(8)
}
printHtmlPart(9)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'partnerrolle.label', default: 'Partnerrolle')]))
})
invokeTag('link','g',66,['controller':("partnerrolle"),'action':("create"),'params':(['partner.id': partnerInstance?.id])],1)
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1392831848000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
