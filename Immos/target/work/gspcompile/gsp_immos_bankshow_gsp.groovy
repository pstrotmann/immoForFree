import org.strotmann.immos.Bank
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_bankshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/bank/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'bank.label', default: 'Bank'))],-1)
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
invokeTag('message','g',15,['code':("default.matchcode.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("list"),'action':("index")],2)
printHtmlPart(8)
invokeTag('message','g',19,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (bankInstance?.bic)) {
printHtmlPart(13)
invokeTag('message','g',28,['code':("bank.bic.label"),'default':("Bic")],-1)
printHtmlPart(14)
invokeTag('fieldValue','g',30,['bean':(bankInstance),'field':("bic")],-1)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (bankInstance?.blz)) {
printHtmlPart(17)
invokeTag('message','g',37,['code':("bank.blz.label"),'default':("Blz")],-1)
printHtmlPart(18)
invokeTag('fieldValue','g',39,['bean':(bankInstance),'field':("blz")],-1)
printHtmlPart(15)
}
printHtmlPart(19)
if(true && (bankInstance?.bankname)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("bank.bankname.label"),'default':("Bankname")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',48,['bean':(bankInstance),'field':("bankname")],-1)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (bankInstance?.plz)) {
printHtmlPart(22)
invokeTag('message','g',55,['code':("bank.plz.label"),'default':("Plz")],-1)
printHtmlPart(23)
invokeTag('fieldValue','g',57,['bean':(bankInstance),'field':("plz")],-1)
printHtmlPart(15)
}
printHtmlPart(19)
if(true && (bankInstance?.ort)) {
printHtmlPart(24)
invokeTag('message','g',64,['code':("bank.ort.label"),'default':("Ort")],-1)
printHtmlPart(25)
invokeTag('fieldValue','g',66,['bean':(bankInstance),'field':("ort")],-1)
printHtmlPart(15)
}
printHtmlPart(26)
invokeTag('message','g',72,['code':("bank.bankverbindung.label"),'default':("Bankverbindungen")],-1)
printHtmlPart(27)
for( b in (bankInstance.bankverbindungen) ) {
printHtmlPart(28)
createTagBody(3, {->
expressionOut.print(b?.iban.encodeAsHTML())
printHtmlPart(29)
expressionOut.print(b.partner.name)
})
invokeTag('link','g',75,['controller':("bankverbindung"),'action':("show"),'id':(b.id)],3)
printHtmlPart(30)
}
printHtmlPart(31)
})
invokeTag('captureBody','sitemesh',79,[:],1)
printHtmlPart(32)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1411832798000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
