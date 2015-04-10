import org.strotmann.immos.Kredit
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_kredit_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/kredit/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: kreditInstance, field: 'kreditgeber', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("kredit.kreditgeber.label"),'default':("Kreditgeber")],-1)
printHtmlPart(2)
if(true && (flash.partner)) {
printHtmlPart(3)
invokeTag('fieldValue','g',11,['bean':(flash.partner),'field':("name")],-1)
printHtmlPart(4)
}
printHtmlPart(4)
if(true && (kreditInstance?.kreditgeber)) {
printHtmlPart(3)
invokeTag('fieldValue','g',14,['bean':(kreditInstance?.kreditgeber?.partner),'field':("name")],-1)
printHtmlPart(4)
}
printHtmlPart(4)
if(true && (!flash.partner && !kreditInstance?.kreditgeber)) {
printHtmlPart(3)
invokeTag('select','g',17,['id':("partner"),'name':("partner.id"),'from':(org.strotmann.immos.Kredit.getKreditgeberList()),'optionKey':("id"),'required':(""),'value':(kreditInstance?.kreditgeber?.id),'class':("many-to-one")],-1)
printHtmlPart(4)
}
printHtmlPart(5)
expressionOut.print(hasErrors(bean: kreditInstance, field: 'verwendung', 'error'))
printHtmlPart(6)
invokeTag('message','g',23,['code':("kredit.verwendung.label"),'default':("Verwendung")],-1)
printHtmlPart(2)
invokeTag('select','g',26,['id':("verwendung"),'name':("verwendung.id"),'from':(org.strotmann.immos.Immobilie.list()),'optionKey':("id"),'required':(""),'value':(kreditInstance?.verwendung?.id),'class':("many-to-one")],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: kreditInstance, field: 'grundschuld', 'error'))
printHtmlPart(7)
invokeTag('message','g',31,['code':("kredit.grundschuld.label"),'default':("Grundschuld")],-1)
printHtmlPart(2)
invokeTag('select','g',34,['id':("grundschuld"),'name':("grundschuld.id"),'from':(org.strotmann.immos.Grundschuld.list()),'optionKey':("id"),'required':(""),'value':(kreditInstance?.grundschuld?.id),'class':("many-to-one")],-1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: kreditInstance, field: 'vertragsnummer', 'error'))
printHtmlPart(9)
invokeTag('message','g',41,['code':("kredit.vertragsnummer.label"),'default':("Vertragsnummer")],-1)
printHtmlPart(10)
invokeTag('textField','g',44,['name':("vertragsnummer"),'value':(kreditInstance?.vertragsnummer)],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: kreditInstance, field: 'zahlweise', 'error'))
printHtmlPart(11)
invokeTag('message','g',49,['code':("kredit.zahlweise.label"),'default':("Zahlweise")],-1)
printHtmlPart(2)
invokeTag('select','g',52,['name':("zahlweise"),'from':(kreditInstance.constraints.zahlweise.inList),'value':(kreditInstance?.zahlweise),'valueMessagePrefix':("zahlweise.category")],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: kreditInstance, field: 'kreditstaende', 'error'))
printHtmlPart(12)
invokeTag('message','g',57,['code':("kredit.kreditstaende.label"),'default':("Kreditstaende")],-1)
printHtmlPart(13)
for( k in (kreditInstance?.kreditstaende) ) {
printHtmlPart(14)
createTagBody(2, {->
expressionOut.print(k?.encodeAsHTML())
})
invokeTag('link','g',63,['controller':("kreditstand"),'action':("show"),'id':(k.id)],2)
printHtmlPart(15)
}
printHtmlPart(16)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'kreditstand.label', default: 'Kreditstand')]))
})
invokeTag('link','g',66,['controller':("kreditstand"),'action':("create"),'params':(['kredit.id': kreditInstance?.id])],1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: kreditInstance, field: 'zahlungen', 'error'))
printHtmlPart(18)
invokeTag('message','g',74,['code':("kredit.zahlungen.label"),'default':("Zahlungen")],-1)
printHtmlPart(13)
for( z in (kreditInstance?.zahlungen) ) {
printHtmlPart(14)
createTagBody(2, {->
expressionOut.print(z?.encodeAsHTML())
})
invokeTag('link','g',80,['controller':("zahlung"),'action':("show"),'id':(z.id)],2)
printHtmlPart(15)
}
printHtmlPart(16)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'zahlung.label', default: 'Zahlung')]))
})
invokeTag('link','g',83,['controller':("zahlung"),'action':("create"),'params':(['kredit.id': kreditInstance?.id])],1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: immobilieInstance, field: 'notizen', 'error'))
printHtmlPart(19)
invokeTag('message','g',91,['code':("kredit.notizen.label"),'default':("Notizen")],-1)
printHtmlPart(13)
for( n in (org.strotmann.immos.Notiz.getNotizen('Kredit',kreditInstance.id)) ) {
printHtmlPart(14)
createTagBody(2, {->
expressionOut.print(n)
})
invokeTag('link','g',97,['controller':("notiz"),'action':("show"),'id':(n.id)],2)
printHtmlPart(15)
}
printHtmlPart(16)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'notiz.label', default: 'Notiz')]))
})
invokeTag('link','g',100,['controller':("notiz"),'action':("create"),'params':(['kredit.id': kreditInstance?.id])],1)
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1412526252000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
