import org.strotmann.immos.OffenerPosten
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_offenerPostenshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/offenerPosten/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'offenerPosten.label', default: 'OffenerPosten'))],-1)
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
if(true && (offenerPostenInstance?.faelligkeit)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("offenerPosten.faelligkeit.label"),'default':("Faelligkeit")],-1)
printHtmlPart(15)
invokeTag('formatDate','g',30,['date':(offenerPostenInstance?.faelligkeit),'format':("dd.MM.yyyy")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (offenerPostenInstance?.grund)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("offenerPosten.grund.label"),'default':("Grund")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',39,['bean':(offenerPostenInstance),'field':("grund")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (offenerPostenInstance?.betrag)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("offenerPosten.betrag.label"),'default':("Betrag")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',48,['bean':(offenerPostenInstance),'field':("betrag")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (offenerPostenInstance?.mietvertrag)) {
printHtmlPart(22)
invokeTag('message','g',55,['code':("offenerPosten.mietvertrag.label"),'default':("Mietvertrag")],-1)
printHtmlPart(23)
createTagBody(3, {->
expressionOut.print(offenerPostenInstance?.mietvertrag?.encodeAsHTML())
})
invokeTag('link','g',57,['controller':("mietvertrag"),'action':("show"),'id':(offenerPostenInstance?.mietvertrag?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (offenerPostenInstance?.dienstleistungsvertrag)) {
printHtmlPart(24)
invokeTag('message','g',64,['code':("offenerPosten.dienstleistungsvertrag.label"),'default':("Dienstleistungsvertrag")],-1)
printHtmlPart(25)
createTagBody(3, {->
expressionOut.print(offenerPostenInstance?.dienstleistungsvertrag?.encodeAsHTML())
})
invokeTag('link','g',66,['controller':("dienstleistungsvertrag"),'action':("show"),'id':(offenerPostenInstance?.dienstleistungsvertrag?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (offenerPostenInstance?.rechnung)) {
printHtmlPart(26)
invokeTag('message','g',73,['code':("offenerPosten.rechnung.label"),'default':("Rechnung")],-1)
printHtmlPart(27)
createTagBody(3, {->
expressionOut.print(offenerPostenInstance?.rechnung?.encodeAsHTML())
})
invokeTag('link','g',75,['controller':("rechnung"),'action':("show"),'id':(offenerPostenInstance?.rechnung?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (offenerPostenInstance?.kredit)) {
printHtmlPart(28)
invokeTag('message','g',82,['code':("offenerPosten.kredit.label"),'default':("Kredit")],-1)
printHtmlPart(29)
createTagBody(3, {->
expressionOut.print(offenerPostenInstance?.kredit?.encodeAsHTML())
})
invokeTag('link','g',84,['controller':("kredit"),'action':("show"),'id':(offenerPostenInstance?.kredit?.id)],3)
printHtmlPart(16)
}
printHtmlPart(30)
createTagBody(2, {->
printHtmlPart(31)
invokeTag('hiddenField','g',92,['name':("id"),'value':(offenerPostenInstance?.id)],-1)
printHtmlPart(32)
createTagBody(3, {->
invokeTag('message','g',93,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',93,['class':("edit"),'action':("edit"),'id':(offenerPostenInstance?.id)],3)
printHtmlPart(32)
invokeTag('actionSubmit','g',94,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(33)
})
invokeTag('form','g',96,['url':([resource:offenerPostenInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(34)
})
invokeTag('captureBody','sitemesh',98,[:],1)
printHtmlPart(35)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1427626118000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
