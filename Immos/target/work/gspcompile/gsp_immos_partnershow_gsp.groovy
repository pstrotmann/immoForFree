import org.strotmann.immos.Partner
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_partnershow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/partner/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'partner.label', default: 'Partner'))],-1)
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
if(true && (partnerInstance?.name)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("partner.name.label"),'default':("Name")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',30,['bean':(partnerInstance),'field':("name")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (partnerInstance?.hausadresse)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("partner.hausadresse.label"),'default':("Hausadresse")],-1)
printHtmlPart(19)
createTagBody(3, {->
expressionOut.print(partnerInstance?.hausadresse?.encodeAsHTML())
})
invokeTag('link','g',39,['controller':("hausadresse"),'action':("show"),'id':(partnerInstance?.hausadresse?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (partnerInstance?.bankverbindung)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("partner.bankverbindung.label"),'default':("Bankverbindung")],-1)
printHtmlPart(21)
for( b in (partnerInstance.bankverbindung) ) {
printHtmlPart(22)
createTagBody(4, {->
expressionOut.print(b?.encodeAsHTML())
})
invokeTag('link','g',49,['controller':("bankverbindung"),'action':("show"),'id':(b.id)],4)
printHtmlPart(23)
}
printHtmlPart(24)
}
printHtmlPart(17)
if(true && (partnerInstance?.kommunikation)) {
printHtmlPart(25)
invokeTag('message','g',57,['code':("partner.kommunikation.label"),'default':("Kommunikation")],-1)
printHtmlPart(21)
for( k in (partnerInstance.kommunikation) ) {
printHtmlPart(26)
createTagBody(4, {->
expressionOut.print(k?.encodeAsHTML())
})
invokeTag('link','g',60,['controller':("kommunikation"),'action':("show"),'id':(k.id)],4)
printHtmlPart(23)
}
printHtmlPart(24)
}
printHtmlPart(17)
if(true && (partnerInstance?.partnerrolle)) {
printHtmlPart(27)
invokeTag('message','g',68,['code':("partner.partnerrolle.label"),'default':("Partnerrolle")],-1)
printHtmlPart(21)
for( p in (partnerInstance.partnerrolle) ) {
printHtmlPart(28)
createTagBody(4, {->
expressionOut.print(p?.encodeAsHTML())
})
invokeTag('link','g',71,['controller':("partnerrolle"),'action':("show"),'id':(p.id)],4)
printHtmlPart(23)
}
printHtmlPart(24)
}
printHtmlPart(29)
createTagBody(2, {->
printHtmlPart(30)
invokeTag('hiddenField','g',80,['name':("id"),'value':(partnerInstance?.id)],-1)
printHtmlPart(31)
createTagBody(3, {->
invokeTag('message','g',81,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',81,['class':("edit"),'action':("edit"),'id':(partnerInstance?.id)],3)
printHtmlPart(31)
invokeTag('actionSubmit','g',82,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(32)
})
invokeTag('form','g',84,[:],2)
printHtmlPart(33)
})
invokeTag('captureBody','sitemesh',86,[:],1)
printHtmlPart(34)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1392645634000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
