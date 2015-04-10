import org.strotmann.immos.Betriebskostenabrechnung
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_betriebskostenabrechnungshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/betriebskostenabrechnung/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'betriebskostenabrechnung.label', default: 'Betriebskostenabrechnung'))],-1)
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
if(true && (betriebskostenabrechnungInstance?.heizkostenabrechnungen)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("betriebskostenabrechnung.heizkostenabrechnungen.label"),'default':("Heizkostenabrechnungen")],-1)
printHtmlPart(15)
for( h in (betriebskostenabrechnungInstance.heizkostenabrechnungen) ) {
printHtmlPart(16)
createTagBody(4, {->
expressionOut.print(h?.encodeAsHTML())
})
invokeTag('link','g',31,['controller':("heizkostenabrechnung"),'action':("show"),'id':(h.id)],4)
printHtmlPart(17)
}
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (betriebskostenabrechnungInstance?.immoabrechnung)) {
printHtmlPart(20)
invokeTag('message','g',39,['code':("betriebskostenabrechnung.immoabrechnung.label"),'default':("Immoabrechnung")],-1)
printHtmlPart(21)
createTagBody(3, {->
expressionOut.print(betriebskostenabrechnungInstance?.immoabrechnung?.encodeAsHTML())
})
invokeTag('link','g',41,['controller':("immoabrechnung"),'action':("show"),'id':(betriebskostenabrechnungInstance?.immoabrechnung?.id)],3)
printHtmlPart(22)
}
printHtmlPart(19)
if(true && (betriebskostenabrechnungInstance?.mietvertrag)) {
printHtmlPart(23)
invokeTag('message','g',48,['code':("betriebskostenabrechnung.mietvertrag.label"),'default':("Mietvertrag")],-1)
printHtmlPart(24)
createTagBody(3, {->
expressionOut.print(betriebskostenabrechnungInstance?.mietvertrag?.encodeAsHTML())
})
invokeTag('link','g',50,['controller':("mietvertrag"),'action':("show"),'id':(betriebskostenabrechnungInstance?.mietvertrag?.id)],3)
printHtmlPart(22)
}
printHtmlPart(19)
if(true && (betriebskostenabrechnungInstance?.nebenkostenabrechnungen)) {
printHtmlPart(25)
invokeTag('message','g',57,['code':("betriebskostenabrechnung.nebenkostenabrechnungen.label"),'default':("Nebenkostenabrechnung")],-1)
printHtmlPart(15)
for( n in (betriebskostenabrechnungInstance.nebenkostenabrechnungen) ) {
printHtmlPart(26)
createTagBody(4, {->
expressionOut.print(n?.encodeAsHTML())
})
invokeTag('link','g',60,['controller':("nebenkostenabrechnung"),'action':("show"),'id':(n.id)],4)
printHtmlPart(17)
}
printHtmlPart(18)
}
printHtmlPart(27)
if(true && (betriebskostenabrechnungInstance?.betriebskostenabrechnungsbriefe)) {
printHtmlPart(28)
invokeTag('message','g',68,['code':("betriebskostenabrechnungsbrief.nebenkostenabrechnungen.label"),'default':("Abrechnungsbrief")],-1)
printHtmlPart(15)
for( b in (betriebskostenabrechnungInstance.betriebskostenabrechnungsbriefe) ) {
printHtmlPart(29)
createTagBody(4, {->
expressionOut.print(b?.encodeAsHTML())
})
invokeTag('link','g',71,['controller':("betriebskostenabrechnungsbrief"),'action':("show"),'id':(b.id)],4)
printHtmlPart(17)
}
printHtmlPart(18)
}
printHtmlPart(30)
createTagBody(2, {->
printHtmlPart(31)
createTagBody(3, {->
invokeTag('message','g',80,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',80,['class':("edit"),'action':("edit"),'resource':(betriebskostenabrechnungInstance)],3)
printHtmlPart(32)
invokeTag('actionSubmit','g',81,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(33)
})
invokeTag('form','g',83,['url':([resource:betriebskostenabrechnungInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(34)
})
invokeTag('captureBody','sitemesh',85,[:],1)
printHtmlPart(35)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1413037636000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
