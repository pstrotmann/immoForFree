import org.strotmann.immos.Notiz
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_notizshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/notiz/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'notiz.label', default: 'Notiz'))],-1)
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
invokeTag('link','g',15,['class':("list"),'action':("index")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('actionSubmit','g',20,['action':("create"),'value':("Notiz anlegen für")],-1)
printHtmlPart(10)
invokeTag('select','g',21,['name':("domName"),'from':(Notiz.domNamen),'value':("it")],-1)
printHtmlPart(11)
})
invokeTag('form','g',23,['action':("index")],2)
printHtmlPart(12)
invokeTag('message','g',29,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(13)
if(true && (flash.message)) {
printHtmlPart(14)
expressionOut.print(flash.message)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (notizInstance?.anlagetermin)) {
printHtmlPart(17)
invokeTag('message','g',37,['code':("notiz.anlagetermin.label"),'default':("Anlagetermin")],-1)
printHtmlPart(18)
invokeTag('formatDate','g',39,['date':(notizInstance?.anlagetermin),'format':("dd.MM.yyyy")],-1)
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (notizInstance?.notiztext)) {
printHtmlPart(21)
invokeTag('message','g',46,['code':("notiz.notiztext.label"),'default':("Notiztext")],-1)
printHtmlPart(22)
invokeTag('fieldValue','g',48,['bean':(notizInstance),'field':("notiztext")],-1)
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (notizInstance?.referenz)) {
printHtmlPart(23)
invokeTag('message','g',55,['code':("notiz.referenz.label"),'default':("Referenz")],-1)
printHtmlPart(24)
if(true && (notizInstance?.refDomIs('dienstleistungsvertrag'))) {
printHtmlPart(25)
createTagBody(4, {->
expressionOut.print(notizInstance.referenz)
})
invokeTag('link','g',59,['controller':("Dienstleistungsvertrag"),'action':("show"),'id':(notizInstance.refId)],4)
printHtmlPart(10)
}
printHtmlPart(10)
if(true && (notizInstance?.refDomIs('kredit'))) {
printHtmlPart(25)
createTagBody(4, {->
expressionOut.print(notizInstance.referenz)
})
invokeTag('link','g',62,['controller':("Kredit"),'action':("show"),'id':(notizInstance.refId)],4)
printHtmlPart(10)
}
printHtmlPart(10)
if(true && (notizInstance?.refDomIs('mietsache'))) {
printHtmlPart(25)
createTagBody(4, {->
expressionOut.print(notizInstance.referenz)
})
invokeTag('link','g',65,['controller':("Mietsache"),'action':("show"),'id':(notizInstance.refId)],4)
printHtmlPart(10)
}
printHtmlPart(10)
if(true && (notizInstance?.refDomIs('mietvertrag'))) {
printHtmlPart(25)
createTagBody(4, {->
expressionOut.print(notizInstance.referenz)
})
invokeTag('link','g',68,['controller':("Mietvertrag"),'action':("show"),'id':(notizInstance.refId)],4)
printHtmlPart(10)
}
printHtmlPart(10)
if(true && (notizInstance?.refDomIs('immobilie'))) {
printHtmlPart(25)
createTagBody(4, {->
expressionOut.print(notizInstance.referenz)
})
invokeTag('link','g',71,['controller':("Immobilie"),'action':("show"),'id':(notizInstance.refId)],4)
printHtmlPart(10)
}
printHtmlPart(10)
if(true && (notizInstance?.refDomIs('organisation'))) {
printHtmlPart(25)
createTagBody(4, {->
expressionOut.print(notizInstance.referenz)
})
invokeTag('link','g',74,['controller':("Organisation"),'action':("show"),'id':(notizInstance.refId)],4)
printHtmlPart(10)
}
printHtmlPart(10)
if(true && (notizInstance?.refDomIs('person'))) {
printHtmlPart(25)
createTagBody(4, {->
expressionOut.print(notizInstance.referenz)
})
invokeTag('link','g',77,['controller':("Person"),'action':("show"),'id':(notizInstance.refId)],4)
printHtmlPart(10)
}
printHtmlPart(10)
if(true && (notizInstance?.refDomIs('rechnung'))) {
printHtmlPart(25)
createTagBody(4, {->
expressionOut.print(notizInstance.referenz)
})
invokeTag('link','g',80,['controller':("Rechnung"),'action':("show"),'id':(notizInstance.refId)],4)
printHtmlPart(10)
}
printHtmlPart(26)
}
printHtmlPart(20)
if(true && (notizInstance?.wiedervorlagetermin)) {
printHtmlPart(27)
invokeTag('message','g',89,['code':("notiz.wiedervorlagetermin.label"),'default':("Wiedervorlagetermin")],-1)
printHtmlPart(28)
invokeTag('formatDate','g',91,['date':(notizInstance?.wiedervorlagetermin),'format':("dd.MM.yyyy")],-1)
printHtmlPart(19)
}
printHtmlPart(29)
createTagBody(2, {->
printHtmlPart(30)
createTagBody(3, {->
invokeTag('message','g',99,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',99,['class':("edit"),'action':("edit"),'resource':(notizInstance)],3)
printHtmlPart(31)
invokeTag('actionSubmit','g',100,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(32)
})
invokeTag('form','g',102,['url':([resource:notizInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(33)
})
invokeTag('captureBody','sitemesh',104,[:],1)
printHtmlPart(34)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1412522372000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
