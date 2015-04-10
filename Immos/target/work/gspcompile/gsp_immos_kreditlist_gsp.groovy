import org.strotmann.immos.Kredit
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_kreditlist_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/kredit/list.gsp" }
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
invokeTag('message','g',27,['code':("kredit.kreditgeber.label"),'default':("Kreditgeber")],-1)
printHtmlPart(13)
invokeTag('message','g',29,['code':("kredit.verwendung.label"),'default':("Verwendung")],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',31,['property':("vertragsnummer"),'title':(message(code: 'kredit.vertragsnummer.label', default: 'Vertragsnummer'))],-1)
printHtmlPart(15)
invokeTag('message','g',33,['code':("kredit.kreditsaldo.label"),'default':("Saldo")],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',35,['property':("zahlweise"),'title':(message(code: 'kredit.zahlweise.label', default: 'Zahlweise'))],-1)
printHtmlPart(17)
loop:{
int i = 0
for( kreditInstance in (kreditInstanceList) ) {
printHtmlPart(18)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(19)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: kreditInstance, field: "kreditgeber.partner.name"))
})
invokeTag('link','g',43,['action':("show"),'id':(kreditInstance.id)],3)
printHtmlPart(20)
expressionOut.print(fieldValue(bean: kreditInstance, field: "verwendung"))
printHtmlPart(21)
expressionOut.print(fieldValue(bean: kreditInstance, field: "vertragsnummer"))
printHtmlPart(22)
invokeTag('formatNumber','g',49,['number':(kreditInstance.kreditsaldo),'type':("number"),'minFractionDigits':("2"),'maxFractionDigits':("2"),'format':("#,##0.00")],-1)
printHtmlPart(23)
expressionOut.print(fieldValue(bean: kreditInstance, field: "zahlweiseKlar"))
printHtmlPart(24)
i++
}
}
printHtmlPart(25)
invokeTag('message','g',62,['code':("kredit.summe.label"),'default':("Summe")],-1)
printHtmlPart(26)
invokeTag('formatNumber','g',64,['number':(Kredit.kreditsumme),'type':("number"),'minFractionDigits':("2"),'maxFractionDigits':("2"),'format':("#,##0.00")],-1)
printHtmlPart(27)
invokeTag('paginate','g',72,['total':(kreditInstanceTotal)],-1)
printHtmlPart(28)
})
invokeTag('captureBody','sitemesh',75,[:],1)
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1402245796000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
