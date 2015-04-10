import org.strotmann.immos.Rechnung
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_rechnungshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/rechnung/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'rechnung.label', default: 'Rechnung'))],-1)
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
if(true && (rechnungInstance?.rechnungssteller)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("rechnung.rechnungssteller.label"),'default':("Rechnungssteller")],-1)
printHtmlPart(15)
if(true && (rechnungInstance?.rechnungssteller?.partner instanceof org.strotmann.immos.Person)) {
printHtmlPart(16)
createTagBody(4, {->
expressionOut.print(rechnungInstance?.rechnungssteller?.partner.name.encodeAsHTML())
})
invokeTag('link','g',32,['controller':("person"),'action':("show"),'id':(rechnungInstance?.rechnungssteller?.partner.id)],4)
printHtmlPart(17)
}
printHtmlPart(17)
if(true && (rechnungInstance?.rechnungssteller?.partner instanceof org.strotmann.immos.Organisation)) {
printHtmlPart(16)
createTagBody(4, {->
expressionOut.print(rechnungInstance?.rechnungssteller?.partner.name.encodeAsHTML())
})
invokeTag('link','g',35,['controller':("organisation"),'action':("show"),'id':(rechnungInstance?.rechnungssteller?.partner.id)],4)
printHtmlPart(17)
}
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (rechnungInstance?.immobilie)) {
printHtmlPart(20)
invokeTag('message','g',43,['code':("rechnung.immobilie.label"),'default':("Immobilie")],-1)
printHtmlPart(21)
createTagBody(3, {->
expressionOut.print(rechnungInstance?.immobilie?.encodeAsHTML())
})
invokeTag('link','g',45,['controller':("immobilie"),'action':("show"),'id':(rechnungInstance?.immobilie?.id)],3)
printHtmlPart(22)
}
printHtmlPart(19)
if(true && (rechnungInstance?.rechnungsdatum)) {
printHtmlPart(23)
invokeTag('message','g',52,['code':("rechnung.rechnungsdatum.label"),'default':("Rechnungsdatum")],-1)
printHtmlPart(24)
invokeTag('formatDate','g',54,['date':(rechnungInstance?.rechnungsdatum),'format':("dd.MM.yyyy")],-1)
printHtmlPart(22)
}
printHtmlPart(19)
if(true && (rechnungInstance?.betrag)) {
printHtmlPart(25)
invokeTag('message','g',61,['code':("rechnung.betrag.label"),'default':("Betrag")],-1)
printHtmlPart(26)
invokeTag('fieldValue','g',63,['bean':(rechnungInstance),'field':("betrag")],-1)
printHtmlPart(22)
}
printHtmlPart(19)
if(true && (rechnungInstance?.bruttoBetrag)) {
printHtmlPart(27)
invokeTag('message','g',70,['code':("rechnung.bruttoBetrag.label"),'default':("Brutto Betrag")],-1)
printHtmlPart(28)
invokeTag('fieldValue','g',72,['bean':(rechnungInstance),'field':("bruttoBetrag")],-1)
printHtmlPart(22)
}
printHtmlPart(19)
if(true && (rechnungInstance?.nettoBetrag)) {
printHtmlPart(29)
invokeTag('message','g',79,['code':("rechnung.nettoBetrag.label"),'default':("Netto Betrag")],-1)
printHtmlPart(30)
invokeTag('fieldValue','g',81,['bean':(rechnungInstance),'field':("nettoBetrag")],-1)
printHtmlPart(22)
}
printHtmlPart(19)
if(true && (rechnungInstance?.mehrwertsteuerSatz)) {
printHtmlPart(31)
invokeTag('message','g',88,['code':("rechnung.mehrwertsteuerSatz.label"),'default':("Mehrwertsteuer Satz")],-1)
printHtmlPart(32)
invokeTag('fieldValue','g',90,['bean':(rechnungInstance),'field':("mehrwertsteuerSatz")],-1)
printHtmlPart(22)
}
printHtmlPart(19)
if(true && (rechnungInstance?.mehrwertsteuer)) {
printHtmlPart(33)
invokeTag('message','g',97,['code':("rechnung.mehrwertsteuer.label"),'default':("Mehrwertsteuer")],-1)
printHtmlPart(34)
invokeTag('fieldValue','g',99,['bean':(rechnungInstance),'field':("mehrwertsteuer")],-1)
printHtmlPart(22)
}
printHtmlPart(19)
if(true && (rechnungInstance?.skontoSatz)) {
printHtmlPart(35)
invokeTag('message','g',106,['code':("rechnung.skontoSatz.label"),'default':("Skonto Satz")],-1)
printHtmlPart(36)
invokeTag('fieldValue','g',108,['bean':(rechnungInstance),'field':("skontoSatz")],-1)
printHtmlPart(22)
}
printHtmlPart(19)
if(true && (rechnungInstance?.skonto)) {
printHtmlPart(37)
invokeTag('message','g',115,['code':("rechnung.skonto.label"),'default':("Skonto")],-1)
printHtmlPart(38)
invokeTag('fieldValue','g',117,['bean':(rechnungInstance),'field':("skonto")],-1)
printHtmlPart(22)
}
printHtmlPart(19)
if(true && (rechnungInstance?.auftragsnummer)) {
printHtmlPart(39)
invokeTag('message','g',124,['code':("rechnung.auftragsnummer.label"),'default':("Auftragsnummer")],-1)
printHtmlPart(40)
invokeTag('fieldValue','g',126,['bean':(rechnungInstance),'field':("auftragsnummer")],-1)
printHtmlPart(22)
}
printHtmlPart(19)
if(true && (rechnungInstance?.kundennummer)) {
printHtmlPart(41)
invokeTag('message','g',133,['code':("rechnung.kundennummer.label"),'default':("Kundennummer")],-1)
printHtmlPart(42)
invokeTag('fieldValue','g',135,['bean':(rechnungInstance),'field':("kundennummer")],-1)
printHtmlPart(22)
}
printHtmlPart(19)
if(true && (rechnungInstance?.rechnungsgegenstand)) {
printHtmlPart(43)
invokeTag('message','g',142,['code':("rechnung.rechnungsgegenstand.label"),'default':("Rechnungsgegenstand")],-1)
printHtmlPart(44)
invokeTag('fieldValue','g',144,['bean':(rechnungInstance),'field':("rechnungsgegenstand")],-1)
printHtmlPart(22)
}
printHtmlPart(19)
if(true && (rechnungInstance?.rechnungsnummer)) {
printHtmlPart(45)
invokeTag('message','g',151,['code':("rechnung.rechnungsnummer.label"),'default':("Rechnungsnummer")],-1)
printHtmlPart(46)
invokeTag('fieldValue','g',153,['bean':(rechnungInstance),'field':("rechnungsnummer")],-1)
printHtmlPart(22)
}
printHtmlPart(47)
invokeTag('message','g',160,['code':("rechnung.umlagefaehig.label"),'default':("Umlagefähig")],-1)
printHtmlPart(48)
invokeTag('formatBoolean','g',162,['boolean':(rechnungInstance?.umlagefaehig),'true':("Ja"),'false':("Nein")],-1)
printHtmlPart(49)
if(true && (rechnungInstance?.zahlungen)) {
printHtmlPart(50)
invokeTag('message','g',168,['code':("rechnung.zahlungen.label"),'default':("Zahlungen")],-1)
printHtmlPart(51)
for( z in (rechnungInstance.zahlungen) ) {
printHtmlPart(52)
createTagBody(4, {->
expressionOut.print(z?.encodeAsHTML())
})
invokeTag('link','g',171,['controller':("zahlung"),'action':("show"),'id':(z.id)],4)
printHtmlPart(53)
}
printHtmlPart(54)
}
printHtmlPart(55)
invokeTag('message','g',178,['code':("rechnung.notizen.label"),'default':("Notizen")],-1)
printHtmlPart(51)
for( n in (org.strotmann.immos.Notiz.getNotizen('Rechnung',rechnungInstance.id)) ) {
printHtmlPart(56)
createTagBody(3, {->
expressionOut.print(n)
})
invokeTag('link','g',181,['controller':("notiz"),'action':("show"),'id':(n.id)],3)
printHtmlPart(53)
}
printHtmlPart(57)
createTagBody(2, {->
printHtmlPart(58)
invokeTag('hiddenField','g',188,['name':("id"),'value':(rechnungInstance?.id)],-1)
printHtmlPart(59)
createTagBody(3, {->
invokeTag('message','g',189,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',189,['class':("edit"),'action':("edit"),'id':(rechnungInstance?.id)],3)
printHtmlPart(59)
invokeTag('actionSubmit','g',190,['method':("DELETE"),'class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(60)
})
invokeTag('form','g',192,['url':([resource:rechnungInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(61)
})
invokeTag('captureBody','sitemesh',194,[:],1)
printHtmlPart(62)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1412530558000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
