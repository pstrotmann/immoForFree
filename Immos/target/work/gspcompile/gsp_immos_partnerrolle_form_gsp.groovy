import org.strotmann.immos.Partnerrolle
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_partnerrolle_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/partnerrolle/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: partnerrolleInstance, field: 'partner', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("partnerrolle.partner.label"),'default':("Partner")],-1)
printHtmlPart(2)
invokeTag('select','g',10,['id':("partner"),'name':("partner.id"),'from':(flash.partner),'optionKey':("id"),'required':(""),'value':(partnerrolleInstance?.partner?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: partnerrolleInstance, field: 'rolle', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("partnerrolle.rolle.label"),'default':("Rolle")],-1)
printHtmlPart(5)
invokeTag('textField','g',18,['name':("rolle"),'value':(flash.rolle)],-1)
printHtmlPart(6)
if(true && (flash.rolle == 'Mieter')) {
printHtmlPart(7)
expressionOut.print(hasErrors(bean: partnerrolleInstance, field: 'mietvertrag', 'error'))
printHtmlPart(8)
invokeTag('message','g',24,['code':("partnerrolle.mietvertrag.label"),'default':("Mietvertrag")],-1)
printHtmlPart(5)
invokeTag('select','g',27,['id':("mietvertrag"),'name':("mietvertrag.id"),'from':(org.strotmann.immos.Mietvertrag.list()),'optionKey':("id"),'value':(partnerrolleInstance?.mietvertrag?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (flash.rolle == 'Mietzahler')) {
printHtmlPart(7)
expressionOut.print(hasErrors(bean: partnerrolleInstance, field: 'mietvertrag', 'error'))
printHtmlPart(8)
invokeTag('message','g',34,['code':("partnerrolle.mietvertrag.label"),'default':("Mietvertrag")],-1)
printHtmlPart(5)
invokeTag('select','g',37,['id':("mietvertrag"),'name':("mietvertrag.id"),'from':(org.strotmann.immos.Mietvertrag.list()),'optionKey':("id"),'value':(partnerrolleInstance?.mietvertrag?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (flash.rolle == 'Kreditgeber')) {
printHtmlPart(7)
expressionOut.print(hasErrors(bean: partnerrolleInstance, field: 'kredit', 'error'))
printHtmlPart(11)
invokeTag('message','g',44,['code':("partnerrolle.kredit.label"),'default':("Kredit")],-1)
printHtmlPart(5)
invokeTag('select','g',47,['id':("kredit"),'name':("kredit.id"),'from':(org.strotmann.immos.Kredit.list()),'optionKey':("id"),'value':(partnerrolleInstance?.kredit?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (flash.rolle == 'Dienstleister')) {
printHtmlPart(7)
expressionOut.print(hasErrors(bean: partnerrolleInstance, field: 'dienstleistungsvertrag', 'error'))
printHtmlPart(12)
invokeTag('message','g',54,['code':("partnerrolle.dienstleistungsvertrag.label"),'default':("Dienstleistungsvertrag")],-1)
printHtmlPart(5)
invokeTag('select','g',57,['id':("dienstleistungsvertrag"),'name':("dienstleistungsvertrag.id"),'from':(org.strotmann.immos.Dienstleistungsvertrag.list()),'optionKey':("id"),'value':(partnerrolleInstance?.dienstleistungsvertrag?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (flash.rolle == 'Rechnungssteller')) {
printHtmlPart(7)
expressionOut.print(hasErrors(bean: partnerrolleInstance, field: 'rechnung', 'error'))
printHtmlPart(13)
invokeTag('message','g',64,['code':("partnerrolle.rechnung.label"),'default':("Rechnung")],-1)
printHtmlPart(5)
invokeTag('select','g',67,['id':("rechnung"),'name':("rechnung.id"),'from':(org.strotmann.immos.Rechnung.list()),'optionKey':("id"),'value':(partnerrolleInstance?.rechnung?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (flash.rolle == 'Ansprechpartner')) {
printHtmlPart(7)
expressionOut.print(hasErrors(bean: partnerrolleInstance, field: 'organisation', 'error'))
printHtmlPart(14)
invokeTag('message','g',74,['code':("partnerrolle.organisation.label"),'default':("Organisation")],-1)
printHtmlPart(5)
invokeTag('select','g',77,['id':("organisation"),'name':("organisation.id"),'from':(org.strotmann.immos.Organisation.getMiniList()),'optionKey':("id"),'value':(partnerrolleInstance?.organisation?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(9)
}
printHtmlPart(10)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1396280276000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
