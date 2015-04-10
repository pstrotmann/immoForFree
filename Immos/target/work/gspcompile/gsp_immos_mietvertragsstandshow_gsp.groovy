import org.strotmann.immos.Mietvertragsstand
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_mietvertragsstandshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mietvertragsstand/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'mietvertragsstand.label', default: 'Mietvertragsstand'))],-1)
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
if(true && (mietvertragsstandInstance?.mietvertrag)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("mietvertragsstand.mietvertrag.label"),'default':("Mietvertrag")],-1)
printHtmlPart(15)
createTagBody(3, {->
expressionOut.print(mietvertragsstandInstance?.mietvertrag?.mieter.partner.name.encodeAsHTML())
printHtmlPart(16)
expressionOut.print(mietvertragsstandInstance?.mietvertrag?.encodeAsHTML())
})
invokeTag('link','g',31,['controller':("mietvertrag"),'action':("show"),'id':(mietvertragsstandInstance?.mietvertrag?.id)],3)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (mietvertragsstandInstance?.gueltigAb)) {
printHtmlPart(19)
invokeTag('message','g',38,['code':("mietvertragsstand.gueltigAb.label"),'default':("Gueltig Ab")],-1)
printHtmlPart(20)
invokeTag('formatDate','g',40,['date':(mietvertragsstandInstance?.gueltigAb),'format':("dd.MM.yyyy")],-1)
printHtmlPart(17)
}
printHtmlPart(21)
invokeTag('message','g',46,['code':("mietvertragsstand.bruttomiete.label"),'default':("Bruttomiete")],-1)
printHtmlPart(22)
invokeTag('formatNumber','g',48,['number':(mietvertragsstandInstance.bruttomiete),'type':("number"),'minFractionDigits':("2")],-1)
printHtmlPart(23)
if(true && (mietvertragsstandInstance?.grundmiete)) {
printHtmlPart(24)
invokeTag('message','g',54,['code':("mietvertragsstand.grundmiete.label"),'default':("Grundmiete")],-1)
printHtmlPart(25)
invokeTag('formatNumber','g',56,['number':(mietvertragsstandInstance.grundmiete),'type':("number"),'minFractionDigits':("2")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (mietvertragsstandInstance?.qmMiete)) {
printHtmlPart(26)
invokeTag('message','g',63,['code':("mietvertragsstand.qmMiete.label"),'default':("Qm Miete")],-1)
printHtmlPart(27)
invokeTag('formatNumber','g',65,['number':(mietvertragsstandInstance.qmMiete),'type':("number"),'minFractionDigits':("2")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (mietvertragsstandInstance?.nebenkostenpauschale)) {
printHtmlPart(28)
invokeTag('message','g',72,['code':("mietvertragsstand.nebenkostenpauschale.label"),'default':("Nebenkostenpauschale")],-1)
printHtmlPart(29)
invokeTag('formatNumber','g',74,['number':(mietvertragsstandInstance.nebenkostenpauschale),'type':("number"),'minFractionDigits':("2")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (mietvertragsstandInstance?.heizkostenpauschale)) {
printHtmlPart(30)
invokeTag('message','g',81,['code':("mietvertragsstand.heizkostenpauschale.label"),'default':("Heizkostenpauschale")],-1)
printHtmlPart(31)
invokeTag('formatNumber','g',83,['number':(mietvertragsstandInstance.heizkostenpauschale),'type':("number"),'minFractionDigits':("2")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (mietvertragsstandInstance?.zusatzmiete)) {
printHtmlPart(32)
invokeTag('message','g',90,['code':("mietvertragsstand.zusatzmiete.label"),'default':(mietvertragsstandInstance.mietvertrag.zusatzMietsache ? mietvertragsstandInstance.mietvertrag.zusatzMietsache.art : mietvertragsstandInstance.mietvertrag.mietsache.art)],-1)
printHtmlPart(33)
invokeTag('formatNumber','g',92,['number':(mietvertragsstandInstance.zusatzmiete),'type':("number"),'minFractionDigits':("2")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (mietvertragsstandInstance?.anzahlPersonen)) {
printHtmlPart(34)
invokeTag('message','g',99,['code':("mietvertragsstand.anzahlPersonen.label"),'default':("Anzahl Personen")],-1)
printHtmlPart(35)
invokeTag('fieldValue','g',101,['bean':(mietvertragsstandInstance),'field':("anzahlPersonen")],-1)
printHtmlPart(17)
}
printHtmlPart(36)
createTagBody(2, {->
printHtmlPart(37)
invokeTag('hiddenField','g',109,['name':("id"),'value':(mietvertragsstandInstance?.id)],-1)
printHtmlPart(38)
createTagBody(3, {->
invokeTag('message','g',110,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',110,['class':("edit"),'action':("edit"),'id':(mietvertragsstandInstance?.id)],3)
printHtmlPart(38)
invokeTag('actionSubmit','g',111,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(39)
})
invokeTag('form','g',113,['url':([resource:mietvertragsstandInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(40)
})
invokeTag('captureBody','sitemesh',115,[:],1)
printHtmlPart(41)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1407595072000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
