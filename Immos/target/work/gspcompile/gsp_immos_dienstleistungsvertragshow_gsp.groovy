import org.strotmann.immos.Dienstleistungsvertrag
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_dienstleistungsvertragshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/dienstleistungsvertrag/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'dienstleistungsvertrag.label', default: 'Dienstleistungsvertrag'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',14,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',15,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("list"),'action':("list")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',16,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',16,['class':("create"),'action':("create")],2)
printHtmlPart(9)
invokeTag('message','g',20,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (dienstleistungsvertragInstance?.dienstleister)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("dienstleistungsvertrag.dienstleister.label"),'default':("Dienstleister")],-1)
printHtmlPart(15)
if(true && (dienstleistungsvertragInstance?.dienstleister?.partner instanceof org.strotmann.immos.Person)) {
printHtmlPart(16)
createTagBody(4, {->
expressionOut.print(dienstleistungsvertragInstance?.dienstleister?.partner.name.encodeAsHTML())
})
invokeTag('link','g',32,['controller':("person"),'action':("show"),'id':(dienstleistungsvertragInstance?.dienstleister?.partner.id)],4)
printHtmlPart(17)
}
printHtmlPart(17)
if(true && (dienstleistungsvertragInstance?.dienstleister?.partner instanceof org.strotmann.immos.Organisation)) {
printHtmlPart(16)
createTagBody(4, {->
expressionOut.print(dienstleistungsvertragInstance?.dienstleister?.partner.name.encodeAsHTML())
})
invokeTag('link','g',35,['controller':("organisation"),'action':("show"),'id':(dienstleistungsvertragInstance?.dienstleister?.partner.id)],4)
printHtmlPart(17)
}
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (dienstleistungsvertragInstance?.immobilie)) {
printHtmlPart(20)
invokeTag('message','g',44,['code':("dienstleistungsvertrag.immobilie.label"),'default':("Immobilie")],-1)
printHtmlPart(21)
createTagBody(3, {->
expressionOut.print(dienstleistungsvertragInstance?.immobilie?.encodeAsHTML())
})
invokeTag('link','g',46,['controller':("immobilie"),'action':("show"),'id':(dienstleistungsvertragInstance?.immobilie?.id)],3)
printHtmlPart(22)
}
printHtmlPart(19)
if(true && (dienstleistungsvertragInstance?.dienstleistungsart)) {
printHtmlPart(23)
invokeTag('message','g',53,['code':("dienstleistungsvertrag.dienstleistungsart.label"),'default':("Dienstleistungsart")],-1)
printHtmlPart(24)
invokeTag('fieldValue','g',55,['bean':(dienstleistungsvertragInstance),'field':("dienstleistungsart")],-1)
printHtmlPart(22)
}
printHtmlPart(19)
if(true && (dienstleistungsvertragInstance?.vertragsnummer)) {
printHtmlPart(25)
invokeTag('message','g',62,['code':("dienstleistungsvertrag.vertragsnummer.label"),'default':("Vertragsnummer")],-1)
printHtmlPart(26)
invokeTag('fieldValue','g',64,['bean':(dienstleistungsvertragInstance),'field':("vertragsnummer")],-1)
printHtmlPart(22)
}
printHtmlPart(19)
if(true && (dienstleistungsvertragInstance?.kundennummer)) {
printHtmlPart(27)
invokeTag('message','g',71,['code':("dienstleistungsvertrag.kundennummer.label"),'default':("Kundennummer")],-1)
printHtmlPart(28)
invokeTag('fieldValue','g',73,['bean':(dienstleistungsvertragInstance),'field':("kundennummer")],-1)
printHtmlPart(22)
}
printHtmlPart(29)
if(true && (dienstleistungsvertragInstance?.referenz)) {
printHtmlPart(30)
invokeTag('message','g',80,['code':("dienstleistungsvertrag.referenz.label"),'default':("Referenz")],-1)
printHtmlPart(31)
invokeTag('fieldValue','g',82,['bean':(dienstleistungsvertragInstance),'field':("referenz")],-1)
printHtmlPart(22)
}
printHtmlPart(19)
if(true && (dienstleistungsvertragInstance?.vertragsbeginn)) {
printHtmlPart(32)
invokeTag('message','g',89,['code':("dienstleistungsvertrag.vertragsbeginn.label"),'default':("Vertragsbeginn")],-1)
printHtmlPart(33)
invokeTag('formatDate','g',91,['date':(dienstleistungsvertragInstance?.vertragsbeginn),'format':("dd.MM.yyyy")],-1)
printHtmlPart(22)
}
printHtmlPart(19)
if(true && (dienstleistungsvertragInstance?.vertragsende)) {
printHtmlPart(34)
invokeTag('message','g',98,['code':("dienstleistungsvertrag.vertragsende.label"),'default':("Vertragsende")],-1)
printHtmlPart(35)
invokeTag('formatDate','g',100,['date':(dienstleistungsvertragInstance?.vertragsende),'format':("dd.MM.yyyy")],-1)
printHtmlPart(22)
}
printHtmlPart(29)
if(true && (dienstleistungsvertragInstance?.autoVerlJahre)) {
printHtmlPart(36)
invokeTag('message','g',107,['code':("dienstleistungsvertrag.autoVerlJahre.label"),'default':("automatische Verlängerung in Jahren")],-1)
printHtmlPart(37)
invokeTag('fieldValue','g',109,['bean':(dienstleistungsvertragInstance),'field':("autoVerlJahre")],-1)
printHtmlPart(22)
}
printHtmlPart(29)
if(true && (dienstleistungsvertragInstance?.kueWochen)) {
printHtmlPart(38)
invokeTag('message','g',116,['code':("dienstleistungsvertrag.kueWochen.label"),'default':("Kündigung vor Ablauf in Wochen")],-1)
printHtmlPart(39)
invokeTag('fieldValue','g',118,['bean':(dienstleistungsvertragInstance),'field':("kueWochen")],-1)
printHtmlPart(22)
}
printHtmlPart(19)
if(true && (dienstleistungsvertragInstance?.zahlweise)) {
printHtmlPart(40)
invokeTag('message','g',125,['code':("dienstleistungsvertrag.zahlweise.label"),'default':("Zahlweise")],-1)
printHtmlPart(41)
invokeTag('fieldValue','g',127,['bean':(dienstleistungsvertragInstance),'field':("zahlweiseKlar")],-1)
printHtmlPart(22)
}
printHtmlPart(29)
if(true && (!dienstleistungsvertragInstance?.umlagefaehig)) {
printHtmlPart(42)
invokeTag('message','g',134,['code':("rechnung.umlagefaehig.label"),'default':("Umlagefähig")],-1)
printHtmlPart(43)
invokeTag('formatBoolean','g',136,['boolean':(dienstleistungsvertragInstance?.umlagefaehig),'false':("Nein")],-1)
printHtmlPart(22)
}
printHtmlPart(19)
if(true && (dienstleistungsvertragInstance?.vertragsstaende)) {
printHtmlPart(44)
invokeTag('message','g',143,['code':("dienstleistungsvertrag.vertragsstaende.label"),'default':("Vertragsstaende")],-1)
printHtmlPart(45)
for( v in (dienstleistungsvertragInstance.vertragsstaende) ) {
printHtmlPart(46)
createTagBody(4, {->
expressionOut.print(v?.vstandKurz)
})
invokeTag('link','g',146,['controller':("dienstleistungsvertragsstand"),'action':("show"),'id':(v.id)],4)
printHtmlPart(47)
}
printHtmlPart(48)
}
printHtmlPart(19)
if(true && (dienstleistungsvertragInstance?.zahlungen)) {
printHtmlPart(49)
invokeTag('message','g',154,['code':("dienstleistungsvertrag.zahlungen.label"),'default':("Zahlungen")],-1)
printHtmlPart(45)
for( z in (dienstleistungsvertragInstance.zahlungen) ) {
printHtmlPart(50)
createTagBody(4, {->
expressionOut.print(z?.encodeAsHTML())
})
invokeTag('link','g',157,['controller':("zahlung"),'action':("show"),'id':(z.id)],4)
printHtmlPart(47)
}
printHtmlPart(48)
}
printHtmlPart(51)
invokeTag('message','g',164,['code':("dienstleistungsvertrag.notizen.label"),'default':("Notizen")],-1)
printHtmlPart(45)
for( n in (org.strotmann.immos.Notiz.getNotizen('Dienstleistungsvertrag',dienstleistungsvertragInstance.id)) ) {
printHtmlPart(52)
createTagBody(3, {->
expressionOut.print(n)
})
invokeTag('link','g',167,['controller':("notiz"),'action':("show"),'id':(n.id)],3)
printHtmlPart(47)
}
printHtmlPart(53)
createTagBody(2, {->
printHtmlPart(54)
invokeTag('hiddenField','g',174,['name':("id"),'value':(dienstleistungsvertragInstance?.id)],-1)
printHtmlPart(55)
createTagBody(3, {->
invokeTag('message','g',175,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',175,['class':("edit"),'action':("edit"),'id':(dienstleistungsvertragInstance?.id)],3)
printHtmlPart(55)
invokeTag('actionSubmit','g',176,['method':("delete"),'class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(56)
})
invokeTag('form','g',178,['url':([resource:dienstleistungsvertragInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(57)
})
invokeTag('captureBody','sitemesh',180,[:],1)
printHtmlPart(58)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1412497530000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
