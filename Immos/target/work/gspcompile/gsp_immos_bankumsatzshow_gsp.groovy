import org.strotmann.immos.Bankumsatz
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_bankumsatzshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/bankumsatz/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'bankumsatz.label', default: 'Bankumsatz'))],-1)
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
if(true && (bankumsatzInstance?.auftragskonto)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("bankumsatz.auftragskonto.label"),'default':("Auftragskonto")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',30,['bean':(bankumsatzInstance),'field':("auftragskonto")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (bankumsatzInstance?.buchungstag)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("bankumsatz.buchungstag.label"),'default':("Buchungstag")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',39,['bean':(bankumsatzInstance),'field':("buchungstag")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (bankumsatzInstance?.valutadatum)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("bankumsatz.valutadatum.label"),'default':("Valutadatum")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',48,['bean':(bankumsatzInstance),'field':("valutadatum")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (bankumsatzInstance?.buchungstext)) {
printHtmlPart(22)
invokeTag('message','g',55,['code':("bankumsatz.buchungstext.label"),'default':("Buchungstext")],-1)
printHtmlPart(23)
invokeTag('fieldValue','g',57,['bean':(bankumsatzInstance),'field':("buchungstext")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (bankumsatzInstance?.verwendungszweck)) {
printHtmlPart(24)
invokeTag('message','g',64,['code':("bankumsatz.verwendungszweck.label"),'default':("Verwendungszweck")],-1)
printHtmlPart(25)
invokeTag('fieldValue','g',66,['bean':(bankumsatzInstance),'field':("verwendungszweck")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (bankumsatzInstance?.glaeubigerId)) {
printHtmlPart(26)
invokeTag('message','g',73,['code':("bankumsatz.glaeubigerId.label"),'default':("Glaeubiger Id")],-1)
printHtmlPart(27)
invokeTag('fieldValue','g',75,['bean':(bankumsatzInstance),'field':("glaeubigerId")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (bankumsatzInstance?.mandatsreferenz)) {
printHtmlPart(28)
invokeTag('message','g',82,['code':("bankumsatz.mandatsreferenz.label"),'default':("Mandatsreferenz")],-1)
printHtmlPart(29)
invokeTag('fieldValue','g',84,['bean':(bankumsatzInstance),'field':("mandatsreferenz")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (bankumsatzInstance?.kundenreferenz)) {
printHtmlPart(30)
invokeTag('message','g',91,['code':("bankumsatz.kundenreferenz.label"),'default':("Kundenreferenz")],-1)
printHtmlPart(31)
invokeTag('fieldValue','g',93,['bean':(bankumsatzInstance),'field':("kundenreferenz")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (bankumsatzInstance?.sammlerreferenz)) {
printHtmlPart(32)
invokeTag('message','g',100,['code':("bankumsatz.sammlerreferenz.label"),'default':("Sammlerreferenz")],-1)
printHtmlPart(33)
invokeTag('fieldValue','g',102,['bean':(bankumsatzInstance),'field':("sammlerreferenz")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (bankumsatzInstance?.lastschriftUrsprungsbetrag)) {
printHtmlPart(34)
invokeTag('message','g',109,['code':("bankumsatz.lastschriftUrsprungsbetrag.label"),'default':("Lastschrift Ursprungsbetrag")],-1)
printHtmlPart(35)
invokeTag('fieldValue','g',111,['bean':(bankumsatzInstance),'field':("lastschriftUrsprungsbetrag")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (bankumsatzInstance?.auslagenersatzRuecklastschrift)) {
printHtmlPart(36)
invokeTag('message','g',118,['code':("bankumsatz.auslagenersatzRuecklastschrift.label"),'default':("Auslagenersatz Ruecklastschrift")],-1)
printHtmlPart(37)
invokeTag('fieldValue','g',120,['bean':(bankumsatzInstance),'field':("auslagenersatzRuecklastschrift")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (bankumsatzInstance?.beguenstigterZahlungspflichtiger)) {
printHtmlPart(38)
invokeTag('message','g',127,['code':("bankumsatz.beguenstigterZahlungspflichtiger.label"),'default':("Beguenstigter Zahlungspflichtiger")],-1)
printHtmlPart(39)
invokeTag('fieldValue','g',129,['bean':(bankumsatzInstance),'field':("beguenstigterZahlungspflichtiger")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (bankumsatzInstance?.kontonummerIBAN)) {
printHtmlPart(40)
invokeTag('message','g',136,['code':("bankumsatz.kontonummerIBAN.label"),'default':("Kontonummer IBAN")],-1)
printHtmlPart(41)
invokeTag('fieldValue','g',138,['bean':(bankumsatzInstance),'field':("kontonummerIBAN")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (bankumsatzInstance?.bic)) {
printHtmlPart(42)
invokeTag('message','g',145,['code':("bankumsatz.bic.label"),'default':("Bic")],-1)
printHtmlPart(43)
invokeTag('fieldValue','g',147,['bean':(bankumsatzInstance),'field':("bic")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (bankumsatzInstance?.betrag)) {
printHtmlPart(44)
invokeTag('message','g',154,['code':("bankumsatz.betrag.label"),'default':("Betrag")],-1)
printHtmlPart(45)
invokeTag('fieldValue','g',156,['bean':(bankumsatzInstance),'field':("betrag")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (bankumsatzInstance?.waehrung)) {
printHtmlPart(46)
invokeTag('message','g',163,['code':("bankumsatz.waehrung.label"),'default':("Waehrung")],-1)
printHtmlPart(47)
invokeTag('fieldValue','g',165,['bean':(bankumsatzInstance),'field':("waehrung")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (bankumsatzInstance?.info)) {
printHtmlPart(48)
invokeTag('message','g',172,['code':("bankumsatz.info.label"),'default':("Info")],-1)
printHtmlPart(49)
invokeTag('fieldValue','g',174,['bean':(bankumsatzInstance),'field':("info")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (bankumsatzInstance?.zahlungen)) {
printHtmlPart(50)
invokeTag('message','g',181,['code':("bankumsatz.zahlungen.label"),'default':("Zahlungen")],-1)
printHtmlPart(51)
for( z in (bankumsatzInstance.zahlungen) ) {
printHtmlPart(52)
createTagBody(4, {->
expressionOut.print(z?.encodeAsHTML())
})
invokeTag('link','g',184,['controller':("zahlung"),'action':("show"),'id':(z.id)],4)
printHtmlPart(53)
}
printHtmlPart(54)
}
printHtmlPart(55)
createTagBody(2, {->
printHtmlPart(56)
invokeTag('hiddenField','g',193,['name':("id"),'value':(bankumsatzInstance?.id)],-1)
printHtmlPart(57)
createTagBody(3, {->
invokeTag('message','g',194,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',194,['class':("edit"),'action':("edit"),'id':(bankumsatzInstance?.id)],3)
printHtmlPart(57)
invokeTag('actionSubmit','g',195,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(58)
})
invokeTag('form','g',197,['url':([resource:bankumsatzInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(59)
})
invokeTag('captureBody','sitemesh',199,[:],1)
printHtmlPart(60)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1418738343000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
