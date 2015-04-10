import org.strotmann.immos.Kredit
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_kreditshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/kredit/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'kredit.label', default: 'Kredit'))],-1)
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
if(true && (kreditInstance?.kreditgeber)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("kredit.kreditgeber.label"),'default':("Kreditgeber")],-1)
printHtmlPart(15)
createTagBody(3, {->
expressionOut.print(kreditInstance?.kreditgeber?.partner.name)
})
invokeTag('link','g',30,['controller':("partnerrolle"),'action':("show"),'id':(kreditInstance?.kreditgeber?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (kreditInstance?.verwendung)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("kredit.verwendung.label"),'default':("Verwendung")],-1)
printHtmlPart(19)
createTagBody(3, {->
expressionOut.print(kreditInstance?.verwendung?.encodeAsHTML())
})
invokeTag('link','g',39,['controller':("immobilie"),'action':("show"),'id':(kreditInstance?.verwendung?.id)],3)
printHtmlPart(16)
}
printHtmlPart(20)
if(true && (kreditInstance?.grundschuld)) {
printHtmlPart(21)
invokeTag('message','g',46,['code':("kredit.grundschuld.label"),'default':("Grundschuld")],-1)
printHtmlPart(22)
createTagBody(3, {->
expressionOut.print(kreditInstance?.grundschuld?.encodeAsHTML())
})
invokeTag('link','g',48,['controller':("grundschuld"),'action':("show"),'id':(kreditInstance?.grundschuld?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (kreditInstance?.vertragsnummer)) {
printHtmlPart(23)
invokeTag('message','g',55,['code':("kredit.vertragsnummer.label"),'default':("Vertragsnummer")],-1)
printHtmlPart(24)
invokeTag('fieldValue','g',57,['bean':(kreditInstance),'field':("vertragsnummer")],-1)
printHtmlPart(16)
}
printHtmlPart(25)
invokeTag('message','g',63,['code':("kredit.kreditsaldo.label"),'default':("Kreditsaldo")],-1)
printHtmlPart(26)
invokeTag('formatNumber','g',65,['number':(kreditInstance.kreditsaldo),'type':("number"),'minFractionDigits':("2"),'maxFractionDigits':("2"),'format':("#,##0.00")],-1)
printHtmlPart(27)
if(true && (kreditInstance?.zahlweise)) {
printHtmlPart(28)
invokeTag('message','g',71,['code':("kredit.zahlweise.label"),'default':("Zahlweise")],-1)
printHtmlPart(29)
invokeTag('fieldValue','g',73,['bean':(kreditInstance),'field':("zahlweiseKlar")],-1)
printHtmlPart(16)
}
printHtmlPart(20)
if(true && (kreditInstance?.kreditstaende)) {
printHtmlPart(30)
invokeTag('message','g',80,['code':("kredit.kreditstaende.label"),'default':("Kreditstaende")],-1)
printHtmlPart(31)
for( k in (kreditInstance.kreditstaende) ) {
printHtmlPart(32)
createTagBody(4, {->
expressionOut.print(k?.encodeAsHTML())
})
invokeTag('link','g',83,['controller':("kreditstand"),'action':("show"),'id':(k.id)],4)
printHtmlPart(33)
}
printHtmlPart(34)
}
printHtmlPart(17)
if(true && (kreditInstance?.zahlungen)) {
printHtmlPart(35)
invokeTag('message','g',91,['code':("kredit.zahlungen.label"),'default':("Zahlungen")],-1)
printHtmlPart(31)
for( z in (kreditInstance.zahlungen) ) {
printHtmlPart(36)
createTagBody(4, {->
expressionOut.print(z?.encodeAsHTML())
})
invokeTag('link','g',94,['controller':("zahlung"),'action':("show"),'id':(z.id)],4)
printHtmlPart(33)
}
printHtmlPart(34)
}
printHtmlPart(37)
invokeTag('message','g',101,['code':("kredit.notizen.label"),'default':("Notizen")],-1)
printHtmlPart(31)
for( n in (org.strotmann.immos.Notiz.getNotizen('Kredit',kreditInstance.id)) ) {
printHtmlPart(38)
createTagBody(3, {->
expressionOut.print(n)
})
invokeTag('link','g',104,['controller':("notiz"),'action':("show"),'id':(n.id)],3)
printHtmlPart(33)
}
printHtmlPart(39)
createTagBody(2, {->
printHtmlPart(40)
invokeTag('hiddenField','g',111,['name':("id"),'value':(kreditInstance?.id)],-1)
printHtmlPart(41)
createTagBody(3, {->
invokeTag('message','g',112,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',112,['class':("edit"),'action':("edit"),'id':(kreditInstance?.id)],3)
printHtmlPart(41)
invokeTag('actionSubmit','g',113,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(42)
})
invokeTag('form','g',115,[:],2)
printHtmlPart(43)
})
invokeTag('captureBody','sitemesh',117,[:],1)
printHtmlPart(44)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1412526340000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
