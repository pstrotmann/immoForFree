import org.strotmann.immos.Grundschuld
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_grundschuldshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/grundschuld/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'grundschuld.label', default: 'Grundschuld'))],-1)
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
if(true && (grundschuldInstance?.eintragAm)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("grundschuld.eintragAm.label"),'default':("Eintrag Am")],-1)
printHtmlPart(15)
invokeTag('formatDate','g',30,['date':(grundschuldInstance?.eintragAm),'format':("dd.MM.yyyy")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (grundschuldInstance?.loeschungAm)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("grundschuld.loeschungAm.label"),'default':("Loeschung Am")],-1)
printHtmlPart(19)
invokeTag('formatDate','g',39,['date':(grundschuldInstance?.loeschungAm),'format':("dd.MM.yyyy")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (grundschuldInstance?.betrag)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("grundschuld.betrag.label"),'default':("Betrag")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',48,['bean':(grundschuldInstance),'field':("betrag")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (grundschuldInstance?.rang)) {
printHtmlPart(22)
invokeTag('message','g',55,['code':("grundschuld.rang.label"),'default':("Rang")],-1)
printHtmlPart(23)
invokeTag('fieldValue','g',57,['bean':(grundschuldInstance),'field':("rang")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (grundschuldInstance?.glaeubiger)) {
printHtmlPart(24)
invokeTag('message','g',64,['code':("grundschuld.glaeubiger.label"),'default':("Glaeubiger")],-1)
printHtmlPart(25)
createTagBody(3, {->
expressionOut.print(grundschuldInstance?.glaeubiger?.encodeAsHTML())
})
invokeTag('link','g',66,['controller':("organisation"),'action':("show"),'id':(grundschuldInstance?.glaeubiger?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (grundschuldInstance?.immobilie)) {
printHtmlPart(26)
invokeTag('message','g',73,['code':("grundschuld.immobilie.label"),'default':("Immobilie")],-1)
printHtmlPart(27)
createTagBody(3, {->
expressionOut.print(grundschuldInstance?.immobilie?.encodeAsHTML())
})
invokeTag('link','g',75,['controller':("immobilie"),'action':("show"),'id':(grundschuldInstance?.immobilie?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (grundschuldInstance?.kredite)) {
printHtmlPart(28)
invokeTag('message','g',82,['code':("grundschuld.kredite.label"),'default':("Kredite")],-1)
printHtmlPart(29)
for( k in (grundschuldInstance.kredite) ) {
printHtmlPart(30)
createTagBody(4, {->
expressionOut.print(k?.encodeAsHTML())
})
invokeTag('link','g',85,['controller':("kredit"),'action':("show"),'id':(k.id)],4)
printHtmlPart(31)
}
printHtmlPart(32)
}
printHtmlPart(33)
createTagBody(2, {->
printHtmlPart(34)
invokeTag('hiddenField','g',94,['name':("id"),'value':(grundschuldInstance?.id)],-1)
printHtmlPart(35)
createTagBody(3, {->
invokeTag('message','g',95,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',95,['class':("edit"),'action':("edit"),'id':(grundschuldInstance?.id)],3)
printHtmlPart(35)
invokeTag('actionSubmit','g',96,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(36)
})
invokeTag('form','g',98,[:],2)
printHtmlPart(37)
})
invokeTag('captureBody','sitemesh',100,[:],1)
printHtmlPart(38)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1398081966000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
