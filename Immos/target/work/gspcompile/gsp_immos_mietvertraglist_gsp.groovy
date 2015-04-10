import org.strotmann.immos.Mietvertrag
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_mietvertraglist_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mietvertrag/list.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'mietvertrag.label', default: 'Mietvertrag'))],-1)
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
invokeTag('message','g',27,['code':("mietvertrag.mieter.label"),'default':("Mieter")],-1)
printHtmlPart(13)
invokeTag('message','g',29,['code':("mietvertrag.mietsache.label"),'default':("Mietsache")],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',31,['property':("mietbeginn"),'title':(message(code: 'mietvertrag.mietbeginn.label', default: 'Mietbeginn'))],-1)
printHtmlPart(15)
invokeTag('message','g',33,['code':("mietvertrag.bruttomiete.label"),'default':("Bruttomiete")],-1)
printHtmlPart(16)
invokeTag('message','g',35,['code':("mietvertrag.mietsaldo.label"),'default':("Saldo")],-1)
printHtmlPart(17)
loop:{
int i = 0
for( mietvertragInstance in (Mietvertrag.mietvertraege) ) {
printHtmlPart(18)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(19)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: mietvertragInstance, field: "mieter.partner.name"))
})
invokeTag('link','g',43,['action':("show"),'id':(mietvertragInstance.id)],3)
printHtmlPart(20)
expressionOut.print(fieldValue(bean: mietvertragInstance, field: "mietsache"))
printHtmlPart(21)
invokeTag('formatDate','g',47,['date':(mietvertragInstance.mietbeginn),'format':("dd.MM.yyyy")],-1)
printHtmlPart(22)
invokeTag('formatNumber','g',49,['number':(mietvertragInstance.bruttomiete),'type':("number"),'minFractionDigits':("2"),'format':("#,##0.00")],-1)
printHtmlPart(23)
if(true && (mietvertragInstance.mietsaldo < 0)) {
printHtmlPart(24)
invokeTag('formatNumber','g',53,['number':(mietvertragInstance.mietsaldo),'type':("number"),'minFractionDigits':("2"),'format':("#,##0.00")],-1)
printHtmlPart(25)
}
printHtmlPart(26)
if(true && (mietvertragInstance.mietsaldo > 0)) {
printHtmlPart(27)
invokeTag('formatNumber','g',56,['number':(mietvertragInstance.mietsaldo),'type':("number"),'minFractionDigits':("2"),'format':("#,##0.00")],-1)
printHtmlPart(26)
}
printHtmlPart(28)
i++
}
}
printHtmlPart(29)
invokeTag('paginate','g',65,['total':(mietvertragInstanceTotal)],-1)
printHtmlPart(30)
})
invokeTag('captureBody','sitemesh',68,[:],1)
printHtmlPart(31)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1420563901000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
