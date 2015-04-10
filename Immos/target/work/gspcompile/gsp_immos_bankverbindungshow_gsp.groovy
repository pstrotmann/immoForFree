import org.strotmann.immos.Bankverbindung
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_bankverbindungshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/bankverbindung/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'bankverbindung.label', default: 'Bankverbindung'))],-1)
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
if(true && (bankverbindungInstance?.iban)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("bankverbindung.iban.label"),'default':("Iban")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',30,['bean':(bankverbindungInstance),'field':("iban")],-1)
printHtmlPart(16)
invokeTag('message','g',34,['code':("bankverbindung.bic.label"),'default':("BIC")],-1)
printHtmlPart(17)
createTagBody(3, {->
expressionOut.print(bankverbindungInstance?.BIC)
})
invokeTag('link','g',36,['controller':("bank"),'action':("show"),'id':(bankverbindungInstance?.getBankId())],3)
printHtmlPart(18)
invokeTag('message','g',40,['default':(" ")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',42,['bean':(bankverbindungInstance),'field':("nameUndAdresse")],-1)
printHtmlPart(20)
invokeTag('message','g',46,['code':("bankverbindung.blz.label"),'default':("Blz")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',48,['bean':(bankverbindungInstance),'field':("blz")],-1)
printHtmlPart(22)
invokeTag('message','g',52,['code':("bankverbindung.ktonr.label"),'default':("KtoNr")],-1)
printHtmlPart(23)
invokeTag('fieldValue','g',54,['bean':(bankverbindungInstance),'field':("ktoNr")],-1)
printHtmlPart(24)
}
printHtmlPart(25)
if(true && (bankverbindungInstance?.partner)) {
printHtmlPart(26)
invokeTag('message','g',61,['code':("bankverbindung.partner.label"),'default':("Partner")],-1)
printHtmlPart(27)
if(true && (flash.person)) {
printHtmlPart(28)
createTagBody(4, {->
expressionOut.print(bankverbindungInstance?.partner?.encodeAsHTML())
})
invokeTag('link','g',64,['controller':("person"),'action':("show"),'id':(bankverbindungInstance?.partner?.id)],4)
printHtmlPart(29)
}
printHtmlPart(29)
if(true && (!flash.person)) {
printHtmlPart(28)
createTagBody(4, {->
expressionOut.print(bankverbindungInstance?.partner?.encodeAsHTML())
})
invokeTag('link','g',67,['controller':("organisation"),'action':("show"),'id':(bankverbindungInstance?.partner?.id)],4)
printHtmlPart(29)
}
printHtmlPart(30)
}
printHtmlPart(31)
createTagBody(2, {->
printHtmlPart(32)
invokeTag('hiddenField','g',77,['name':("id"),'value':(bankverbindungInstance?.id)],-1)
printHtmlPart(33)
createTagBody(3, {->
invokeTag('message','g',78,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',78,['class':("edit"),'action':("edit"),'id':(bankverbindungInstance?.id)],3)
printHtmlPart(33)
invokeTag('actionSubmit','g',79,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(34)
})
invokeTag('form','g',81,[:],2)
printHtmlPart(35)
})
invokeTag('captureBody','sitemesh',83,[:],1)
printHtmlPart(36)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1411832568000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
