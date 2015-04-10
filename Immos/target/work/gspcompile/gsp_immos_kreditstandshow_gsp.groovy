import org.strotmann.immos.Kreditstand
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_kreditstandshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/kreditstand/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'kreditstand.label', default: 'Kreditstand'))],-1)
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
if(true && (kreditstandInstance?.laufzeitAb)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("kreditstand.laufzeitAb.label"),'default':("Laufzeit Ab")],-1)
printHtmlPart(15)
invokeTag('formatDate','g',30,['date':(kreditstandInstance?.laufzeitAb),'format':("dd.MM.yyyy")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (kreditstandInstance?.laufzeitBis)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("kreditstand.laufzeitBis.label"),'default':("Laufzeit Bis")],-1)
printHtmlPart(19)
invokeTag('formatDate','g',39,['date':(kreditstandInstance?.laufzeitBis),'format':("dd.MM.yyyy")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (kreditstandInstance?.kreditsumme)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("kreditstand.kreditsumme.label"),'default':("Kreditsumme")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',48,['bean':(kreditstandInstance),'field':("kreditsumme")],-1)
printHtmlPart(16)
}
printHtmlPart(22)
if(true && (kreditstandInstance?.bewilligt)) {
printHtmlPart(23)
invokeTag('message','g',55,['code':("kreditstand.bewilligt.label"),'default':("bewilligtes Darlehen")],-1)
printHtmlPart(24)
invokeTag('fieldValue','g',57,['bean':(kreditstandInstance),'field':("bewilligt")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (kreditstandInstance?.zinssatz)) {
printHtmlPart(25)
invokeTag('message','g',64,['code':("kreditstand.zinssatz.label"),'default':("Zinssatz")],-1)
printHtmlPart(26)
invokeTag('fieldValue','g',66,['bean':(kreditstandInstance),'field':("zinssatz")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (kreditstandInstance?.tilgungssatz)) {
printHtmlPart(27)
invokeTag('message','g',73,['code':("kreditstand.tilgungssatz.label"),'default':("Tilgungssatz")],-1)
printHtmlPart(28)
invokeTag('fieldValue','g',75,['bean':(kreditstandInstance),'field':("tilgungssatz")],-1)
printHtmlPart(16)
}
printHtmlPart(22)
if(true && (kreditstandInstance?.annuitaet)) {
printHtmlPart(29)
invokeTag('message','g',82,['code':("kreditstand.annuitaet.label"),'default':("Annuität")],-1)
printHtmlPart(30)
invokeTag('fieldValue','g',84,['bean':(kreditstandInstance),'field':("annuitaet")],-1)
printHtmlPart(16)
}
printHtmlPart(22)
if(true && (kreditstandInstance?.zinsbetrag)) {
printHtmlPart(31)
invokeTag('message','g',91,['code':("kreditstand.zinsbetrag.label"),'default':("Zinsbetrag")],-1)
printHtmlPart(32)
invokeTag('fieldValue','g',93,['bean':(kreditstandInstance),'field':("zinsbetrag")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (kreditstandInstance?.tilgungsbetrag)) {
printHtmlPart(33)
invokeTag('message','g',100,['code':("kreditstand.tilgungsbetrag.label"),'default':("Tilgungsbetrag")],-1)
printHtmlPart(34)
invokeTag('fieldValue','g',102,['bean':(kreditstandInstance),'field':("tilgungsbetrag")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (kreditstandInstance?.verwKostenbetrag)) {
printHtmlPart(35)
invokeTag('message','g',109,['code':("kreditstand.verwKostenbetrag.label"),'default':("Verw Kostenbetrag")],-1)
printHtmlPart(36)
invokeTag('fieldValue','g',111,['bean':(kreditstandInstance),'field':("verwKostenbetrag")],-1)
printHtmlPart(16)
}
printHtmlPart(22)
if(true && (kreditstandInstance?.sondertilgung)) {
printHtmlPart(37)
invokeTag('message','g',118,['code':("kreditstand.sondertilgung.label"),'default':("Sondertilgung")],-1)
printHtmlPart(38)
invokeTag('fieldValue','g',120,['bean':(kreditstandInstance),'field':("sondertilgung")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (kreditstandInstance?.kredit)) {
printHtmlPart(39)
invokeTag('message','g',127,['code':("kreditstand.kredit.label"),'default':("Kredit")],-1)
printHtmlPart(40)
createTagBody(3, {->
expressionOut.print(kreditstandInstance?.kredit?.encodeAsHTML())
})
invokeTag('link','g',129,['controller':("kredit"),'action':("show"),'id':(kreditstandInstance?.kredit?.id)],3)
printHtmlPart(16)
}
printHtmlPart(41)
createTagBody(2, {->
printHtmlPart(42)
invokeTag('hiddenField','g',137,['name':("id"),'value':(kreditstandInstance?.id)],-1)
printHtmlPart(43)
createTagBody(3, {->
invokeTag('message','g',138,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',138,['class':("edit"),'action':("edit"),'id':(kreditstandInstance?.id)],3)
printHtmlPart(43)
invokeTag('actionSubmit','g',139,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(44)
})
invokeTag('form','g',141,['url':([resource:kreditstandInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(45)
})
invokeTag('captureBody','sitemesh',143,[:],1)
printHtmlPart(46)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1418993555000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
