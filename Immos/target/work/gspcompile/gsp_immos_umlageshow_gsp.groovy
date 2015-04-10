import org.strotmann.immos.Umlage
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_umlageshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/umlage/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'umlage.label', default: 'Umlage'))],-1)
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
if(true && (umlageInstance?.kostenart)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("umlage.kostenart.label"),'default':("Kostenart")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',30,['bean':(umlageInstance),'field':("kostenart")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (umlageInstance?.umlageschluessel)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("umlage.umlageschluessel.label"),'default':("Umlageschluessel")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',39,['bean':(umlageInstance),'field':("umlageschluessel")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (umlageInstance?.betrag)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("umlage.betrag.label"),'default':("Betrag")],-1)
printHtmlPart(21)
invokeTag('formatNumber','g',48,['number':(umlageInstance.betrag),'type':("number"),'minFractionDigits':("2"),'maxFractionDigits':("2"),'format':("#,##0.00")],-1)
printHtmlPart(16)
}
printHtmlPart(22)
if(true && (umlageInstance?.betragOhneZZ)) {
printHtmlPart(23)
invokeTag('message','g',55,['code':("umlage.betragOhneZZ.label"),'default':("Betrag ohne Zwischenzähler")],-1)
printHtmlPart(24)
invokeTag('formatNumber','g',57,['number':(umlageInstance.betragOhneZZ),'type':("number"),'minFractionDigits':("2"),'maxFractionDigits':("2"),'format':("#,##0.00")],-1)
printHtmlPart(16)
}
printHtmlPart(22)
if(true && (umlageInstance?.ZVerbrauch)) {
printHtmlPart(25)
invokeTag('message','g',64,['code':("umlage.ZVerbrauch.label"),'default':("Verbrauch")],-1)
printHtmlPart(26)
invokeTag('fieldValue','g',66,['bean':(umlageInstance),'field':("ZVerbrauch")],-1)
printHtmlPart(27)
invokeTag('fieldValue','g',66,['bean':(umlageInstance),'field':("zaehler.zaehlereinheit")],-1)
printHtmlPart(16)
}
printHtmlPart(22)
if(true && (umlageInstance?.zzVerbrauch)) {
printHtmlPart(28)
invokeTag('message','g',73,['code':("umlage.zzVerbrauch.label"),'default':("Verbrauch Zwischenzähler")],-1)
printHtmlPart(29)
invokeTag('fieldValue','g',75,['bean':(umlageInstance),'field':("zzVerbrauch")],-1)
printHtmlPart(27)
invokeTag('fieldValue','g',75,['bean':(umlageInstance),'field':("zaehler.zaehlereinheit")],-1)
printHtmlPart(16)
}
printHtmlPart(22)
if(true && (umlageInstance?.zaehler)) {
printHtmlPart(30)
invokeTag('message','g',82,['code':("umlage.zaehler.label"),'default':("Zähler")],-1)
printHtmlPart(31)
createTagBody(3, {->
expressionOut.print(umlageInstance?.zaehler?.encodeAsHTML())
})
invokeTag('link','g',84,['controller':("zaehler"),'action':("show"),'id':(umlageInstance?.zaehler?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (umlageInstance?.immoabrechnung)) {
printHtmlPart(32)
invokeTag('message','g',91,['code':("umlage.immoabrechnung.label"),'default':("Immoabrechnung")],-1)
printHtmlPart(33)
createTagBody(3, {->
expressionOut.print(umlageInstance?.immoabrechnung?.encodeAsHTML())
})
invokeTag('link','g',93,['controller':("immoabrechnung"),'action':("show"),'id':(umlageInstance?.immoabrechnung?.id)],3)
printHtmlPart(16)
}
printHtmlPart(22)
if(true && (umlageInstance?.umlageanteile)) {
printHtmlPart(34)
invokeTag('message','g',100,['code':("umlage.umlageanteile.label"),'default':("umlageanteile")],-1)
printHtmlPart(35)
for( n in (umlageInstance.umlageanteile) ) {
printHtmlPart(36)
createTagBody(4, {->
expressionOut.print(n?.encodeAsHTML())
})
invokeTag('link','g',103,['controller':("nebenkostenabrechnung"),'action':("show"),'id':(n.id)],4)
printHtmlPart(37)
}
printHtmlPart(38)
}
printHtmlPart(39)
createTagBody(2, {->
printHtmlPart(40)
invokeTag('hiddenField','g',112,['name':("id"),'value':(umlageInstance?.id)],-1)
printHtmlPart(41)
createTagBody(3, {->
invokeTag('message','g',113,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',113,['class':("edit"),'action':("edit"),'id':(umlageInstance?.id)],3)
printHtmlPart(41)
invokeTag('actionSubmit','g',114,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(42)
})
invokeTag('form','g',116,['url':([resource:umlageInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(43)
})
invokeTag('captureBody','sitemesh',118,[:],1)
printHtmlPart(44)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1412845012000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
