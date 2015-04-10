import org.strotmann.immos.Partnerrolle
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_partnerrolleshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/partnerrolle/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'partnerrolle.label', default: 'Partnerrolle'))],-1)
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
if(true && (partnerrolleInstance?.partner)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("partnerrolle.partner.label"),'default':("Partner")],-1)
printHtmlPart(15)
if(true && (partnerrolleInstance?.partner instanceof org.strotmann.immos.Person)) {
printHtmlPart(16)
createTagBody(4, {->
expressionOut.print(partnerrolleInstance?.partner?.encodeAsHTML())
})
invokeTag('link','g',32,['controller':("person"),'action':("show"),'id':(partnerrolleInstance?.partner?.id)],4)
printHtmlPart(17)
}
printHtmlPart(17)
if(true && (partnerrolleInstance?.partner instanceof org.strotmann.immos.Organisation)) {
printHtmlPart(16)
createTagBody(4, {->
expressionOut.print(partnerrolleInstance?.partner?.encodeAsHTML())
})
invokeTag('link','g',35,['controller':("organisation"),'action':("show"),'id':(partnerrolleInstance?.partner?.id)],4)
printHtmlPart(17)
}
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (partnerrolleInstance?.rolle)) {
printHtmlPart(20)
invokeTag('message','g',45,['code':("partnerrolle.rolle.label"),'default':("Rolle")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',47,['bean':(partnerrolleInstance),'field':("rolle")],-1)
printHtmlPart(22)
}
printHtmlPart(19)
if(true && (partnerrolleInstance?.mietvertrag)) {
printHtmlPart(23)
invokeTag('message','g',54,['code':("partnerrolle.mietvertrag.label"),'default':("Mietvertrag")],-1)
printHtmlPart(24)
createTagBody(3, {->
expressionOut.print(partnerrolleInstance?.mietvertrag?.encodeAsHTML())
})
invokeTag('link','g',56,['controller':("mietvertrag"),'action':("show"),'id':(partnerrolleInstance?.mietvertrag?.id)],3)
printHtmlPart(22)
}
printHtmlPart(19)
if(true && (partnerrolleInstance?.kredit)) {
printHtmlPart(25)
invokeTag('message','g',63,['code':("partnerrolle.kredit.label"),'default':("Kredit")],-1)
printHtmlPart(26)
createTagBody(3, {->
expressionOut.print(partnerrolleInstance?.kredit?.encodeAsHTML())
})
invokeTag('link','g',65,['controller':("kredit"),'action':("show"),'id':(partnerrolleInstance?.kredit?.id)],3)
printHtmlPart(22)
}
printHtmlPart(19)
if(true && (partnerrolleInstance?.dienstleistungsvertrag)) {
printHtmlPart(27)
invokeTag('message','g',72,['code':("partnerrolle.dienstleistungsvertrag.label"),'default':("Dienstleistungsvertrag")],-1)
printHtmlPart(28)
createTagBody(3, {->
expressionOut.print(partnerrolleInstance?.dienstleistungsvertrag?.encodeAsHTML())
})
invokeTag('link','g',74,['controller':("dienstleistungsvertrag"),'action':("show"),'id':(partnerrolleInstance?.dienstleistungsvertrag?.id)],3)
printHtmlPart(22)
}
printHtmlPart(19)
if(true && (partnerrolleInstance?.rechnung)) {
printHtmlPart(29)
invokeTag('message','g',81,['code':("partnerrolle.rechnung.label"),'default':("Rechnung")],-1)
printHtmlPart(30)
createTagBody(3, {->
expressionOut.print(partnerrolleInstance?.rechnung?.encodeAsHTML())
})
invokeTag('link','g',83,['controller':("rechnung"),'action':("show"),'id':(partnerrolleInstance?.rechnung?.id)],3)
printHtmlPart(22)
}
printHtmlPart(19)
if(true && (partnerrolleInstance?.organisation)) {
printHtmlPart(31)
invokeTag('message','g',90,['code':("partnerrolle.organisation.label"),'default':("Organisation")],-1)
printHtmlPart(32)
createTagBody(3, {->
expressionOut.print(partnerrolleInstance?.organisation?.encodeAsHTML())
})
invokeTag('link','g',92,['controller':("organisation"),'action':("show"),'id':(partnerrolleInstance?.organisation?.id)],3)
printHtmlPart(22)
}
printHtmlPart(33)
createTagBody(2, {->
printHtmlPart(34)
invokeTag('hiddenField','g',100,['name':("id"),'value':(partnerrolleInstance?.id)],-1)
printHtmlPart(35)
createTagBody(3, {->
invokeTag('message','g',101,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',101,['class':("edit"),'action':("edit"),'id':(partnerrolleInstance?.id)],3)
printHtmlPart(35)
invokeTag('actionSubmit','g',102,['method':("delete"),'class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(36)
})
invokeTag('form','g',104,['url':([resource:partnerrolleInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(37)
})
invokeTag('captureBody','sitemesh',106,[:],1)
printHtmlPart(38)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1406030198000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
