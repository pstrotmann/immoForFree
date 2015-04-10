import org.strotmann.immos.Rechnung
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_rechnunglist_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/rechnung/list.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'rechnung.label', default: 'Rechnung'))],-1)
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
invokeTag('message','g',27,['code':("rechnung.rechnungssteller.label"),'default':("Rechnungssteller")],-1)
printHtmlPart(13)
invokeTag('message','g',29,['code':("rechnung.immobilie.label"),'default':("Immobilie")],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',31,['property':("rechnungsdatum"),'title':(message(code: 'rechnung.rechnungsdatum.label', default: 'Rechnungsdatum'))],-1)
printHtmlPart(15)
invokeTag('message','g',33,['code':("rechnung.betrag.label"),'default':("Betrag")],-1)
printHtmlPart(16)
loop:{
int i = 0
for( rechnungInstance in (rechnungInstanceList) ) {
printHtmlPart(17)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(18)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: rechnungInstance, field: "rechnungssteller.partner.name"))
})
invokeTag('link','g',41,['action':("show"),'id':(rechnungInstance.id)],3)
printHtmlPart(19)
expressionOut.print(fieldValue(bean: rechnungInstance, field: "immobilie"))
printHtmlPart(19)
invokeTag('formatDate','g',45,['date':(rechnungInstance.rechnungsdatum),'format':("dd.MM.yyyy")],-1)
printHtmlPart(20)
invokeTag('formatNumber','g',47,['number':(rechnungInstance.betrag),'type':("number"),'minFractionDigits':("2"),'format':("#,##0.00")],-1)
printHtmlPart(21)
i++
}
}
printHtmlPart(22)
invokeTag('paginate','g',54,['total':(rechnungInstanceTotal)],-1)
printHtmlPart(23)
})
invokeTag('captureBody','sitemesh',57,[:],1)
printHtmlPart(24)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1399190514000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
