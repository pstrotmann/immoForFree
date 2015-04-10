import org.strotmann.immos.Mietsache
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_mietsacheshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mietsache/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'mietsache.label', default: 'Mietsache'))],-1)
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
if(true && (mietsacheInstance?.lage)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("mietsache.lage.label"),'default':("Lage")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',30,['bean':(mietsacheInstance),'field':("lage")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (mietsacheInstance?.art)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("mietsache.art.label"),'default':("Art")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',39,['bean':(mietsacheInstance),'field':("art")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (mietsacheInstance?.wohnflaeche)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("mietsache.wohnflaeche.label"),'default':("Wohnflaeche")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',48,['bean':(mietsacheInstance),'field':("wohnflaeche")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (mietsacheInstance?.aufteilung)) {
printHtmlPart(22)
invokeTag('message','g',55,['code':("mietsache.aufteilung.label"),'default':("Aufteilung")],-1)
printHtmlPart(23)
invokeTag('fieldValue','g',57,['bean':(mietsacheInstance),'field':("aufteilung")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (mietsacheInstance?.immobilie)) {
printHtmlPart(24)
invokeTag('message','g',64,['code':("mietsache.immobilie.label"),'default':("Immobilie")],-1)
printHtmlPart(25)
createTagBody(3, {->
expressionOut.print(mietsacheInstance?.immobilie?.encodeAsHTML())
})
invokeTag('link','g',66,['controller':("immobilie"),'action':("show"),'id':(mietsacheInstance?.immobilie?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (mietsacheInstance?.mietvertraege)) {
printHtmlPart(26)
invokeTag('message','g',73,['code':("mietsache.mietvertraege.label"),'default':("Mietvertraege")],-1)
printHtmlPart(27)
for( m in (mietsacheInstance.mietvertraege) ) {
printHtmlPart(28)
createTagBody(4, {->
expressionOut.print(m?.encodeAsHTML())
})
invokeTag('link','g',76,['controller':("mietvertrag"),'action':("show"),'id':(m.id)],4)
printHtmlPart(29)
}
printHtmlPart(30)
}
printHtmlPart(31)
if(true && (mietsacheInstance?.zwischenzaehlers)) {
printHtmlPart(32)
invokeTag('message','g',84,['code':("mietsache.zwischenzaehlers.label"),'default':("Zwischenzähler")],-1)
printHtmlPart(27)
for( z in (mietsacheInstance.zwischenzaehlers) ) {
printHtmlPart(33)
createTagBody(4, {->
expressionOut.print(z?.encodeAsHTML())
})
invokeTag('link','g',87,['controller':("zwischenzaehler"),'action':("show"),'id':(z.id)],4)
printHtmlPart(29)
}
printHtmlPart(30)
}
printHtmlPart(34)
invokeTag('message','g',94,['code':("mietsache.notizen.label"),'default':("Notizen")],-1)
printHtmlPart(27)
for( n in (org.strotmann.immos.Notiz.getNotizen('Mietsache',mietsacheInstance.id)) ) {
printHtmlPart(35)
createTagBody(3, {->
expressionOut.print(n)
})
invokeTag('link','g',97,['controller':("notiz"),'action':("show"),'id':(n.id)],3)
printHtmlPart(29)
}
printHtmlPart(36)
createTagBody(2, {->
printHtmlPart(37)
invokeTag('hiddenField','g',104,['name':("id"),'value':(mietsacheInstance?.id)],-1)
printHtmlPart(38)
createTagBody(3, {->
invokeTag('message','g',105,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',105,['class':("edit"),'action':("edit"),'id':(mietsacheInstance?.id)],3)
printHtmlPart(38)
invokeTag('actionSubmit','g',106,['method':("delete"),'class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(39)
})
invokeTag('form','g',108,['url':([resource:mietsacheInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(40)
})
invokeTag('captureBody','sitemesh',110,[:],1)
printHtmlPart(41)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1412526766000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
