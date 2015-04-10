import org.strotmann.immos.Organisation
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_organisationshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/organisation/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'organisation.label', default: 'Organisation'))],-1)
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
if(true && (organisationInstance?.name)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("organisation.name.label"),'default':("Name")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',30,['bean':(organisationInstance),'field':("name")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (organisationInstance?.nameZusatz)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("organisation.nameZusatz.label"),'default':("Name Zusatz")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',39,['bean':(organisationInstance),'field':("nameZusatz")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (organisationInstance?.rechtsform)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("organisation.rechtsform.label"),'default':("Rechtsform")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',48,['bean':(organisationInstance),'field':("rechtsform")],-1)
printHtmlPart(16)
}
printHtmlPart(22)
invokeTag('message','g',54,['code':("organisation.partnerrolle.label"),'default':("Ansprechpartner")],-1)
printHtmlPart(23)
for( p in (organisationInstance.getAspaList()) ) {
printHtmlPart(24)
createTagBody(3, {->
expressionOut.print(p?.encodeAsHTML())
})
invokeTag('link','g',57,['controller':("person"),'action':("show"),'id':(p.id)],3)
printHtmlPart(25)
}
printHtmlPart(26)
if(true && (organisationInstance?.hausadresse)) {
printHtmlPart(27)
invokeTag('message','g',65,['code':("organisation.hausadresse.label"),'default':("Hausadresse")],-1)
printHtmlPart(28)
createTagBody(3, {->
expressionOut.print(organisationInstance?.hausadresse?.encodeAsHTML())
})
invokeTag('link','g',67,['controller':("hausadresse"),'action':("show"),'id':(organisationInstance?.hausadresse?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (organisationInstance?.bankverbindung)) {
printHtmlPart(29)
invokeTag('message','g',74,['code':("organisation.bankverbindung.label"),'default':("Bankverbindung")],-1)
printHtmlPart(23)
for( b in (organisationInstance.bankverbindung) ) {
printHtmlPart(30)
createTagBody(4, {->
expressionOut.print(b?.encodeAsHTML())
})
invokeTag('link','g',77,['controller':("bankverbindung"),'action':("show"),'id':(b.id)],4)
printHtmlPart(25)
}
printHtmlPart(31)
}
printHtmlPart(17)
if(true && (organisationInstance?.kommunikation)) {
printHtmlPart(32)
invokeTag('message','g',85,['code':("organisation.kommunikation.label"),'default':("Kommunikation")],-1)
printHtmlPart(23)
for( k in (organisationInstance.kommunikation) ) {
printHtmlPart(33)
createTagBody(4, {->
expressionOut.print(k?.encodeAsHTML())
})
invokeTag('link','g',88,['controller':("kommunikation"),'action':("show"),'id':(k.id)],4)
printHtmlPart(25)
}
printHtmlPart(31)
}
printHtmlPart(17)
if(true && (organisationInstance?.partnerrolle)) {
printHtmlPart(34)
invokeTag('message','g',96,['code':("organisation.partnerrolle.label"),'default':("Partnerrolle")],-1)
printHtmlPart(23)
for( p in (organisationInstance.partnerrolle) ) {
printHtmlPart(24)
createTagBody(4, {->
expressionOut.print(p?.encodeAsHTML())
})
invokeTag('link','g',99,['controller':("partnerrolle"),'action':("show"),'id':(p.id)],4)
printHtmlPart(25)
}
printHtmlPart(31)
}
printHtmlPart(35)
if(true && (organisationInstance?.postfachadresse)) {
printHtmlPart(36)
invokeTag('message','g',107,['code':("organisation.postfachadresse.label"),'default':("Postfachadresse")],-1)
printHtmlPart(23)
for( p in (organisationInstance.postfachadresse) ) {
printHtmlPart(37)
createTagBody(4, {->
expressionOut.print(p?.encodeAsHTML())
})
invokeTag('link','g',110,['controller':("postfachadresse"),'action':("show"),'id':(p.id)],4)
printHtmlPart(25)
}
printHtmlPart(31)
}
printHtmlPart(38)
invokeTag('message','g',117,['code':("organisation.notizen.label"),'default':("Notizen")],-1)
printHtmlPart(23)
for( n in (org.strotmann.immos.Notiz.getNotizen('Organisation',organisationInstance.id)) ) {
printHtmlPart(39)
createTagBody(3, {->
expressionOut.print(n)
})
invokeTag('link','g',120,['controller':("notiz"),'action':("show"),'id':(n.id)],3)
printHtmlPart(25)
}
printHtmlPart(40)
createTagBody(2, {->
printHtmlPart(41)
invokeTag('hiddenField','g',128,['name':("id"),'value':(organisationInstance?.id)],-1)
printHtmlPart(42)
createTagBody(3, {->
invokeTag('message','g',129,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',129,['class':("edit"),'action':("edit"),'id':(organisationInstance?.id)],3)
printHtmlPart(42)
invokeTag('actionSubmit','g',130,['method':("DELETE"),'class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(43)
})
invokeTag('form','g',132,['url':([resource:mietsacheInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(44)
})
invokeTag('captureBody','sitemesh',134,[:],1)
printHtmlPart(45)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1412506162000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
