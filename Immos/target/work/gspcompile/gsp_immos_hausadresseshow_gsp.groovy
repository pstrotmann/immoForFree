import org.strotmann.immos.Hausadresse
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_hausadresseshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/hausadresse/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'hausadresse.label', default: 'Hausadresse'))],-1)
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
if(true && (hausadresseInstance?.strasse)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("hausadresse.strasse.label"),'default':("Strasse")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',30,['bean':(hausadresseInstance),'field':("strasse")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (hausadresseInstance?.hausnummer)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("hausadresse.hausnummer.label"),'default':("Hausnummer")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',39,['bean':(hausadresseInstance),'field':("hausnummer")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (hausadresseInstance?.zusatz)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("hausadresse.zusatz.label"),'default':("Zusatz")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',48,['bean':(hausadresseInstance),'field':("zusatz")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (hausadresseInstance?.postleitzahl)) {
printHtmlPart(22)
invokeTag('message','g',55,['code':("hausadresse.postleitzahl.label"),'default':("Postleitzahl")],-1)
printHtmlPart(23)
invokeTag('fieldValue','g',57,['bean':(hausadresseInstance),'field':("postleitzahl")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (hausadresseInstance?.ort)) {
printHtmlPart(24)
invokeTag('message','g',64,['code':("hausadresse.ort.label"),'default':("Ort")],-1)
printHtmlPart(25)
invokeTag('fieldValue','g',66,['bean':(hausadresseInstance),'field':("ort")],-1)
printHtmlPart(16)
}
printHtmlPart(26)
if(true && (flash?.partner)) {
printHtmlPart(27)
invokeTag('message','g',73,['code':("hausadresse.partner.label"),'default':("Partner")],-1)
printHtmlPart(28)
if(true && (flash.person)) {
printHtmlPart(29)
createTagBody(4, {->
expressionOut.print(flash.partner.encodeAsHTML())
})
invokeTag('link','g',76,['controller':("person"),'action':("show"),'id':(flash.partner.id)],4)
printHtmlPart(30)
}
printHtmlPart(30)
if(true && (flash.organisation)) {
printHtmlPart(29)
createTagBody(4, {->
expressionOut.print(flash.partner.encodeAsHTML())
})
invokeTag('link','g',79,['controller':("Organisation"),'action':("show"),'id':(flash.partner.id)],4)
printHtmlPart(30)
}
printHtmlPart(31)
}
printHtmlPart(32)
createTagBody(2, {->
printHtmlPart(33)
invokeTag('hiddenField','g',88,['name':("id"),'value':(hausadresseInstance?.id)],-1)
printHtmlPart(34)
createTagBody(3, {->
invokeTag('message','g',89,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',89,['class':("edit"),'action':("edit"),'id':(hausadresseInstance?.id)],3)
printHtmlPart(34)
invokeTag('actionSubmit','g',90,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(35)
})
invokeTag('form','g',92,['url':([resource:hausadresseInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(36)
})
invokeTag('captureBody','sitemesh',94,[:],1)
printHtmlPart(37)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1412150328000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
