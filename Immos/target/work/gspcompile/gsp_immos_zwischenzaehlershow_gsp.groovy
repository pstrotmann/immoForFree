import org.strotmann.immos.Zwischenzaehler
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_zwischenzaehlershow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/zwischenzaehler/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'zwischenzaehler.label', default: 'Zwischenzähler'))],-1)
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
if(true && (zwischenzaehlerInstance?.zaehlernummer)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("zwischenzaehler.zaehlernummer.label"),'default':("Zählernummer")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',30,['bean':(zwischenzaehlerInstance),'field':("zaehlernummer")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (zwischenzaehlerInstance?.mietsache)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("zwischenzaehler.mietsache.label"),'default':("Mietsache")],-1)
printHtmlPart(19)
createTagBody(3, {->
expressionOut.print(zwischenzaehlerInstance?.mietsache?.encodeAsHTML())
})
invokeTag('link','g',39,['controller':("mietsache"),'action':("show"),'id':(zwischenzaehlerInstance?.mietsache?.id)],3)
printHtmlPart(16)
}
printHtmlPart(20)
if(true && (zwischenzaehlerInstance?.stattZaehler)) {
printHtmlPart(21)
invokeTag('message','g',46,['code':("zwischenzaehler.stattZaehler.label"),'default':("statt Zähler")],-1)
printHtmlPart(22)
invokeTag('formatBoolean','g',48,['boolean':(zwischenzaehlerInstance?.stattZaehler),'true':("ja"),'false':("nein")],-1)
printHtmlPart(23)
}
printHtmlPart(17)
if(true && (zwischenzaehlerInstance?.zaehler)) {
printHtmlPart(24)
invokeTag('message','g',55,['code':("zwischenzaehler.zaehler.label"),'default':("Zähler")],-1)
printHtmlPart(25)
createTagBody(3, {->
expressionOut.print(zwischenzaehlerInstance?.zaehler?.encodeAsHTML())
})
invokeTag('link','g',57,['controller':("zaehler"),'action':("show"),'id':(zwischenzaehlerInstance?.zaehler?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (zwischenzaehlerInstance?.zwischenzaehlerstaende)) {
printHtmlPart(26)
invokeTag('message','g',64,['code':("zwischenzaehler.zwischenzaehlerstaende.label"),'default':("Zwischenzählerstände")],-1)
printHtmlPart(27)
for( z in (zwischenzaehlerInstance.zwischenzaehlerstaende) ) {
printHtmlPart(28)
createTagBody(4, {->
expressionOut.print(z?.encodeAsHTML())
})
invokeTag('link','g',67,['controller':("zwischenzaehlerstand"),'action':("show"),'id':(z.id)],4)
printHtmlPart(29)
}
printHtmlPart(30)
}
printHtmlPart(31)
createTagBody(2, {->
printHtmlPart(32)
invokeTag('hiddenField','g',76,['name':("id"),'value':(zwischenzaehlerInstance?.id)],-1)
printHtmlPart(33)
createTagBody(3, {->
invokeTag('message','g',77,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',77,['class':("edit"),'action':("edit"),'id':(zwischenzaehlerInstance?.id)],3)
printHtmlPart(33)
invokeTag('actionSubmit','g',78,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(34)
})
invokeTag('form','g',80,[:],2)
printHtmlPart(35)
})
invokeTag('captureBody','sitemesh',82,[:],1)
printHtmlPart(36)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1404565884000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
