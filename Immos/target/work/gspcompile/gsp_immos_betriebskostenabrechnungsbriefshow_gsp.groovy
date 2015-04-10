import org.strotmann.immos.Betriebskostenabrechnungsbrief
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_betriebskostenabrechnungsbriefshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/betriebskostenabrechnungsbrief/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'betriebskostenabrechnungsbrief.label', default: 'Betriebskostenabrechnungsbrief'))],-1)
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
invokeTag('captureHead','sitemesh',53,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('message','g',55,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(6)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(7)
invokeTag('message','g',58,['code':("default.home.label")],-1)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',59,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',59,['class':("list"),'action':("index")],2)
printHtmlPart(9)
createTagBody(2, {->
invokeTag('message','g',60,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',60,['class':("create"),'action':("create")],2)
printHtmlPart(10)
invokeTag('message','g',64,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(11)
if(true && (flash.message)) {
printHtmlPart(12)
expressionOut.print(flash.message)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (betriebskostenabrechnungsbriefInstance?.betriebskostenabrechnung)) {
printHtmlPart(15)
invokeTag('message','g',72,['code':("betriebskostenabrechnungsbrief.betriebskostenabrechnung.label"),'default':("Betriebskostenabrechnung")],-1)
printHtmlPart(16)
createTagBody(3, {->
expressionOut.print(betriebskostenabrechnungsbriefInstance?.betriebskostenabrechnung?.encodeAsHTML())
})
invokeTag('link','g',74,['controller':("betriebskostenabrechnung"),'action':("show"),'id':(betriebskostenabrechnungsbriefInstance?.betriebskostenabrechnung?.id)],3)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (betriebskostenabrechnungsbriefInstance?.jahr)) {
printHtmlPart(19)
invokeTag('message','g',81,['code':("betriebskostenabrechnungsbrief.jahr.label"),'default':("Jahr")],-1)
printHtmlPart(20)
invokeTag('fieldValue','g',83,['bean':(betriebskostenabrechnungsbriefInstance),'field':("jahr")],-1)
printHtmlPart(17)
}
printHtmlPart(21)
if(true && (betriebskostenabrechnungsbriefInstance?.briefDatum)) {
printHtmlPart(22)
invokeTag('message','g',90,['code':("betriebskostenabrechnungsbrief.briefDatum.label"),'default':("Brief Datum")],-1)
printHtmlPart(23)
invokeTag('fieldValue','g',92,['bean':(betriebskostenabrechnungsbriefInstance),'field':("briefDatum")],-1)
printHtmlPart(17)
}
printHtmlPart(24)
if(true && (betriebskostenabrechnungsbriefInstance?.adressAnrede)) {
printHtmlPart(25)
invokeTag('message','g',99,['code':("betriebskostenabrechnungsbrief.adressAnrede.label"),'default':("Adress Anrede")],-1)
printHtmlPart(26)
invokeTag('fieldValue','g',101,['bean':(betriebskostenabrechnungsbriefInstance),'field':("adressAnrede")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (betriebskostenabrechnungsbriefInstance?.adressName)) {
printHtmlPart(27)
invokeTag('message','g',108,['code':("betriebskostenabrechnungsbrief.adressName.label"),'default':("Adress Name")],-1)
printHtmlPart(28)
invokeTag('fieldValue','g',110,['bean':(betriebskostenabrechnungsbriefInstance),'field':("adressName")],-1)
printHtmlPart(17)
}
printHtmlPart(21)
if(true && (betriebskostenabrechnungsbriefInstance?.strHnr)) {
printHtmlPart(29)
invokeTag('message','g',117,['code':("betriebskostenabrechnungsbrief.strHnr.label"),'default':("Str Hnr")],-1)
printHtmlPart(30)
invokeTag('fieldValue','g',119,['bean':(betriebskostenabrechnungsbriefInstance),'field':("strHnr")],-1)
printHtmlPart(17)
}
printHtmlPart(21)
if(true && (betriebskostenabrechnungsbriefInstance?.plzOrt)) {
printHtmlPart(31)
invokeTag('message','g',126,['code':("betriebskostenabrechnungsbrief.plzOrt.label"),'default':("Plz Ort")],-1)
printHtmlPart(32)
invokeTag('fieldValue','g',128,['bean':(betriebskostenabrechnungsbriefInstance),'field':("plzOrt")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (betriebskostenabrechnungsbriefInstance?.briefAnrede1)) {
printHtmlPart(33)
invokeTag('message','g',135,['code':("betriebskostenabrechnungsbrief.briefAnrede1.label"),'default':("Brief Anrede1")],-1)
printHtmlPart(34)
invokeTag('fieldValue','g',137,['bean':(betriebskostenabrechnungsbriefInstance),'field':("briefAnrede1")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (betriebskostenabrechnungsbriefInstance?.anredeName)) {
printHtmlPart(35)
invokeTag('message','g',144,['code':("betriebskostenabrechnungsbrief.anredeName.label"),'default':("Anrede Name")],-1)
printHtmlPart(36)
invokeTag('fieldValue','g',146,['bean':(betriebskostenabrechnungsbriefInstance),'field':("anredeName")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (betriebskostenabrechnungsbriefInstance?.briefAnrede2)) {
printHtmlPart(37)
invokeTag('message','g',153,['code':("betriebskostenabrechnungsbrief.briefAnrede2.label"),'default':("Brief Anrede2")],-1)
printHtmlPart(38)
invokeTag('fieldValue','g',155,['bean':(betriebskostenabrechnungsbriefInstance),'field':("briefAnrede2")],-1)
printHtmlPart(17)
}
printHtmlPart(39)
if(true && (betriebskostenabrechnungsbriefInstance?.erstattung)) {
printHtmlPart(40)
invokeTag('message','g',162,['code':("betriebskostenabrechnungsbrief.erstattung.label"),'default':("Erstattung")],-1)
printHtmlPart(41)
invokeTag('fieldValue','g',164,['bean':(betriebskostenabrechnungsbriefInstance),'field':("erstattung")],-1)
printHtmlPart(17)
}
printHtmlPart(21)
if(true && (betriebskostenabrechnungsbriefInstance?.mitKonto)) {
printHtmlPart(42)
invokeTag('message','g',171,['code':("betriebskostenabrechnungsbrief.mitKonto.label"),'default':("Mit Konto")],-1)
printHtmlPart(43)
invokeTag('fieldValue','g',173,['bean':(betriebskostenabrechnungsbriefInstance),'field':("mitKonto")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (betriebskostenabrechnungsbriefInstance?.bankname)) {
printHtmlPart(44)
invokeTag('message','g',180,['code':("betriebskostenabrechnungsbrief.bankname.label"),'default':("Bankname")],-1)
printHtmlPart(45)
invokeTag('fieldValue','g',182,['bean':(betriebskostenabrechnungsbriefInstance),'field':("bankname")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (betriebskostenabrechnungsbriefInstance?.blz)) {
printHtmlPart(46)
invokeTag('message','g',189,['code':("betriebskostenabrechnungsbrief.blz.label"),'default':("Blz")],-1)
printHtmlPart(47)
invokeTag('fieldValue','g',191,['bean':(betriebskostenabrechnungsbriefInstance),'field':("blz")],-1)
printHtmlPart(17)
}
printHtmlPart(21)
if(true && (betriebskostenabrechnungsbriefInstance?.kto)) {
printHtmlPart(48)
invokeTag('message','g',198,['code':("betriebskostenabrechnungsbrief.kto.label"),'default':("Kto")],-1)
printHtmlPart(49)
invokeTag('fieldValue','g',200,['bean':(betriebskostenabrechnungsbriefInstance),'field':("kto")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (betriebskostenabrechnungsbriefInstance?.kontoinhaber)) {
printHtmlPart(50)
invokeTag('message','g',207,['code':("betriebskostenabrechnungsbrief.kontoinhaber.label"),'default':("Kontoinhaber")],-1)
printHtmlPart(51)
invokeTag('fieldValue','g',209,['bean':(betriebskostenabrechnungsbriefInstance),'field':("kontoinhaber")],-1)
printHtmlPart(17)
}
printHtmlPart(52)
createTagBody(2, {->
printHtmlPart(53)
createTagBody(3, {->
invokeTag('message','g',217,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',217,['class':("edit"),'action':("edit"),'resource':(betriebskostenabrechnungsbriefInstance)],3)
printHtmlPart(54)
invokeTag('actionSubmit','g',218,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(55)
invokeTag('createLink','g',219,['action':("renderFormPDF"),'id':(betriebskostenabrechnungsbriefInstance?.id)],-1)
printHtmlPart(56)
})
invokeTag('form','g',221,['url':([resource:betriebskostenabrechnungsbriefInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(57)
})
invokeTag('captureBody','sitemesh',223,[:],1)
printHtmlPart(58)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1413050280000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
