import org.strotmann.immos.Person
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_personshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/person/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'person.label', default: 'Person'))],-1)
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
expressionOut.print(createLink(uri: '/matchcode/create'))
printHtmlPart(6)
invokeTag('message','g',17,['code':("default.mcSuch.label")],-1)
printHtmlPart(10)
invokeTag('message','g',21,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(11)
if(true && (flash.message)) {
printHtmlPart(12)
expressionOut.print(flash.message)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (personInstance?.name)) {
printHtmlPart(15)
invokeTag('message','g',29,['code':("person.name.label"),'default':("Name")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',31,['bean':(personInstance),'field':("name")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (personInstance?.titel)) {
printHtmlPart(19)
invokeTag('message','g',38,['code':("person.titel.label"),'default':("Titel")],-1)
printHtmlPart(20)
invokeTag('fieldValue','g',40,['bean':(personInstance),'field':("titel")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (personInstance?.vorname)) {
printHtmlPart(21)
invokeTag('message','g',47,['code':("person.vorname.label"),'default':("Vorname")],-1)
printHtmlPart(22)
invokeTag('fieldValue','g',49,['bean':(personInstance),'field':("vorname")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (personInstance?.geschlecht)) {
printHtmlPart(23)
invokeTag('message','g',56,['code':("person.geschlecht.label"),'default':("Geschlecht")],-1)
printHtmlPart(24)
invokeTag('fieldValue','g',58,['bean':(personInstance),'field':("geschlecht")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (personInstance?.persoenlicheAnrede)) {
printHtmlPart(25)
invokeTag('message','g',65,['code':("person.persoenlicheAnrede.label"),'default':("Anrede")],-1)
printHtmlPart(26)
invokeTag('formatBoolean','g',67,['boolean':(personInstance?.persoenlicheAnrede),'true':("persönlich"),'false':("formal")],-1)
printHtmlPart(27)
}
printHtmlPart(18)
if(true && (personInstance?.geburtsdatum)) {
printHtmlPart(28)
invokeTag('message','g',74,['code':("person.geburtsdatum.label"),'default':("Geburtsdatum")],-1)
printHtmlPart(29)
invokeTag('formatDate','g',76,['date':(personInstance?.geburtsdatum),'format':("dd.MM.yyyy")],-1)
printHtmlPart(17)
}
printHtmlPart(30)
if(true && (personInstance?.hausadresse)) {
printHtmlPart(31)
invokeTag('message','g',83,['code':("person.hausadresse.label"),'default':("Hausadresse")],-1)
printHtmlPart(32)
createTagBody(3, {->
expressionOut.print(personInstance?.hausadresse?.encodeAsHTML())
})
invokeTag('link','g',85,['controller':("hausadresse"),'action':("show"),'id':(personInstance?.hausadresse?.id)],3)
printHtmlPart(17)
}
printHtmlPart(33)
if(true && (personInstance?.bankverbindung)) {
printHtmlPart(34)
invokeTag('message','g',92,['code':("person.bankverbindung.label"),'default':("Bankverbindung")],-1)
printHtmlPart(35)
for( b in (personInstance.bankverbindung) ) {
printHtmlPart(36)
createTagBody(4, {->
expressionOut.print(b?.encodeAsHTML())
})
invokeTag('link','g',95,['controller':("bankverbindung"),'action':("show"),'id':(b.id)],4)
printHtmlPart(37)
}
printHtmlPart(38)
}
printHtmlPart(18)
if(true && (personInstance?.kommunikation)) {
printHtmlPart(39)
invokeTag('message','g',103,['code':("person.kommunikation.label"),'default':("Kommunikation")],-1)
printHtmlPart(35)
for( k in (personInstance.kommunikation) ) {
printHtmlPart(40)
createTagBody(4, {->
expressionOut.print(k?.encodeAsHTML())
})
invokeTag('link','g',106,['controller':("kommunikation"),'action':("show"),'id':(k.id)],4)
printHtmlPart(37)
}
printHtmlPart(38)
}
printHtmlPart(18)
if(true && (personInstance?.partnerrolle)) {
printHtmlPart(41)
invokeTag('message','g',114,['code':("person.partnerrolle.label"),'default':("Partnerrolle")],-1)
printHtmlPart(35)
for( p in (personInstance.partnerrolle) ) {
printHtmlPart(42)
createTagBody(4, {->
expressionOut.print(p?.encodeAsHTML())
})
invokeTag('link','g',117,['controller':("partnerrolle"),'action':("show"),'id':(p.id)],4)
printHtmlPart(37)
}
printHtmlPart(38)
}
printHtmlPart(43)
invokeTag('message','g',124,['code':("person.notizen.label"),'default':("Notizen")],-1)
printHtmlPart(35)
for( n in (org.strotmann.immos.Notiz.getNotizen('Person',personInstance.id)) ) {
printHtmlPart(44)
createTagBody(3, {->
expressionOut.print(n)
})
invokeTag('link','g',127,['controller':("notiz"),'action':("show"),'id':(n.id)],3)
printHtmlPart(37)
}
printHtmlPart(45)
createTagBody(2, {->
printHtmlPart(46)
invokeTag('hiddenField','g',135,['name':("id"),'value':(personInstance?.id)],-1)
printHtmlPart(47)
createTagBody(3, {->
invokeTag('message','g',136,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',136,['class':("edit"),'action':("edit"),'id':(personInstance?.id)],3)
printHtmlPart(47)
invokeTag('actionSubmit','g',137,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(48)
})
invokeTag('form','g',139,[:],2)
printHtmlPart(49)
})
invokeTag('captureBody','sitemesh',141,[:],1)
printHtmlPart(50)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1412506468000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
