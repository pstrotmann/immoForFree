import org.strotmann.immos.Zahlung
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_zahlunglist_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/zahlung/list.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'zahlung.label', default: 'Zahlung'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.list.label"),'args':([entityName])],-1)
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
invokeTag('message','g',15,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("create"),'action':("create")],2)
printHtmlPart(8)
invokeTag('message','g',19,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
invokeTag('sortableColumn','g',27,['property':("datum"),'title':(message(code: 'zahlung.datum.label', default: 'Datum'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',29,['property':("betrag"),'title':(message(code: 'zahlung.betrag.label', default: 'Betrag'))],-1)
printHtmlPart(14)
invokeTag('message','g',31,['code':("zahlung.mietvertrag.label"),'default':("Mietvertrag")],-1)
printHtmlPart(15)
invokeTag('message','g',33,['code':("zahlung.rechnung.label"),'default':("Rechnung")],-1)
printHtmlPart(15)
invokeTag('message','g',35,['code':("zahlung.dienstleistungsvertrag.label"),'default':("Dienstleistungsvertrag")],-1)
printHtmlPart(15)
invokeTag('message','g',37,['code':("zahlung.kredit.label"),'default':("Kredit")],-1)
printHtmlPart(16)
loop:{
int i = 0
for( zahlungInstance in (zahlungInstanceList) ) {
printHtmlPart(17)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(18)
createTagBody(3, {->
invokeTag('formatDate','g',45,['date':(zahlungInstance?.datum),'format':("dd.MM.yyyy")],-1)
})
invokeTag('link','g',45,['action':("show"),'id':(zahlungInstance.id)],3)
printHtmlPart(19)
expressionOut.print(fieldValue(bean: zahlungInstance, field: "betrag"))
printHtmlPart(19)
expressionOut.print(fieldValue(bean: zahlungInstance, field: "mietvertrag"))
printHtmlPart(19)
expressionOut.print(fieldValue(bean: zahlungInstance, field: "rechnung"))
printHtmlPart(19)
expressionOut.print(fieldValue(bean: zahlungInstance, field: "dienstleistungsvertrag"))
printHtmlPart(19)
expressionOut.print(fieldValue(bean: zahlungInstance, field: "kredit"))
printHtmlPart(20)
i++
}
}
printHtmlPart(21)
invokeTag('paginate','g',62,['total':(zahlungInstanceTotal)],-1)
printHtmlPart(22)
})
invokeTag('captureBody','sitemesh',65,[:],1)
printHtmlPart(23)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1396862462000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
