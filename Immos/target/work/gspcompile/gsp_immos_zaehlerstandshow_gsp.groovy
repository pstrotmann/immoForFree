import org.strotmann.immos.Zaehlerstand
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_zaehlerstandshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/zaehlerstand/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'zaehlerstand.label', default: 'Zählerstand'))],-1)
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
if(true && (zaehlerstandInstance?.ablesedatum)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("zaehlerstand.ablesedatum.label"),'default':("Ablesedatum")],-1)
printHtmlPart(15)
invokeTag('formatDate','g',30,['date':(zaehlerstandInstance?.ablesedatum),'format':("dd.MM.yyyy")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (zaehlerstandInstance?.wert)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("zaehlerstand.wert.label"),'default':("Wert")],-1)
printHtmlPart(19)
invokeTag('formatNumber','g',39,['number':(zaehlerstandInstance?.wert),'type':("number"),'minFractionDigits':("3")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (zaehlerstandInstance?.z)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("zaehlerstand.z.label"),'default':("Zähler")],-1)
printHtmlPart(21)
createTagBody(3, {->
expressionOut.print(zaehlerstandInstance?.z?.encodeAsHTML())
})
invokeTag('link','g',48,['controller':("zaehler"),'action':("show"),'id':(zaehlerstandInstance?.z?.id)],3)
printHtmlPart(16)
}
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(23)
invokeTag('hiddenField','g',56,['name':("id"),'value':(zaehlerstandInstance?.id)],-1)
printHtmlPart(24)
createTagBody(3, {->
invokeTag('message','g',57,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',57,['class':("edit"),'action':("edit"),'id':(zaehlerstandInstance?.id)],3)
printHtmlPart(24)
invokeTag('actionSubmit','g',58,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(25)
})
invokeTag('form','g',60,[:],2)
printHtmlPart(26)
})
invokeTag('captureBody','sitemesh',62,[:],1)
printHtmlPart(27)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401636930000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
