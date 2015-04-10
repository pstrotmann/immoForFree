import org.strotmann.immos.Umlageanteil
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_umlageanteilshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/umlageanteil/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'umlageanteil.label', default: 'Umlageanteil'))],-1)
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
if(true && (umlageanteilInstance?.kostenart)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("umlageanteil.kostenart.label"),'default':("Kostenart")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',30,['bean':(umlageanteilInstance),'field':("kostenart")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (umlageanteilInstance?.umlageschluessel)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("umlageanteil.umlageschluessel.label"),'default':("Umlageschluessel")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',39,['bean':(umlageanteilInstance),'field':("umlageschluessel")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (umlageanteilInstance?.betrag)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("umlageanteil.betrag.label"),'default':("Betrag")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',48,['bean':(umlageanteilInstance),'field':("betrag")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (umlageanteilInstance?.nebenkostenabrechnung)) {
printHtmlPart(22)
invokeTag('message','g',55,['code':("umlageanteil.nebenkostenabrechnung.label"),'default':("Nebenkostenabrechnung")],-1)
printHtmlPart(23)
createTagBody(3, {->
expressionOut.print(umlageanteilInstance?.nebenkostenabrechnung?.encodeAsHTML())
})
invokeTag('link','g',57,['controller':("nebenkostenabrechnung"),'action':("show"),'id':(umlageanteilInstance?.nebenkostenabrechnung?.id)],3)
printHtmlPart(16)
}
printHtmlPart(24)
if(true && (umlageanteilInstance?.umlage)) {
printHtmlPart(25)
invokeTag('message','g',64,['code':("umlageanteil.umlage.label"),'default':("Umlage")],-1)
printHtmlPart(26)
createTagBody(3, {->
expressionOut.print(umlageanteilInstance?.umlage?.encodeAsHTML())
})
invokeTag('link','g',66,['controller':("umlage"),'action':("show"),'id':(umlageanteilInstance?.umlage?.id)],3)
printHtmlPart(16)
}
printHtmlPart(27)
createTagBody(2, {->
printHtmlPart(28)
invokeTag('hiddenField','g',74,['name':("id"),'value':(umlageanteilInstance?.id)],-1)
printHtmlPart(29)
createTagBody(3, {->
invokeTag('message','g',75,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',75,['class':("edit"),'action':("edit"),'id':(umlageanteilInstance?.id)],3)
printHtmlPart(29)
invokeTag('actionSubmit','g',76,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(30)
})
invokeTag('form','g',78,['url':([resource:umlageanteilInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(31)
})
invokeTag('captureBody','sitemesh',80,[:],1)
printHtmlPart(32)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1412866652000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
