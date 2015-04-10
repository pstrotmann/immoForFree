import org.strotmann.immos.Dienstleistungsvertrag
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_dienstleistungsvertraglist_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/dienstleistungsvertrag/list.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'dienstleistungsvertrag.label', default: 'Dienstleistungsvertrag'))],-1)
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
invokeTag('message','g',26,['code':("dienstleistungsvertrag.dienstleister.label"),'default':("Dienstleister")],-1)
printHtmlPart(13)
invokeTag('message','g',28,['code':("dienstleistungsvertrag.immobilie.label"),'default':("Immobilie")],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',30,['property':("dienstleistungsart"),'title':(message(code: 'dienstleistungsvertrag.dienstleistungsart.label', default: 'Art'))],-1)
printHtmlPart(15)
invokeTag('message','g',32,['code':("dienstleistungsvertrag.immobilie.label"),'default':("Kd.Nr,Vertr.Nr.,Ref")],-1)
printHtmlPart(16)
invokeTag('message','g',34,['code':("dienstleistungsvertrag.zahlweise.label"),'default':("Zahlweise")],-1)
printHtmlPart(17)
invokeTag('message','g',36,['code':("dienstleistungsvertrag.pauschale.label"),'default':("Pauschale")],-1)
printHtmlPart(18)
loop:{
int i = 0
for( dienstleistungsvertragInstance in (dienstleistungsvertragInstanceList) ) {
printHtmlPart(19)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(20)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: dienstleistungsvertragInstance, field: "dienstleister.partner.name"))
})
invokeTag('link','g',43,['action':("show"),'id':(dienstleistungsvertragInstance.id)],3)
printHtmlPart(21)
expressionOut.print(fieldValue(bean: dienstleistungsvertragInstance, field: "immobilie"))
printHtmlPart(21)
expressionOut.print(fieldValue(bean: dienstleistungsvertragInstance, field: "dienstleistungsart"))
printHtmlPart(21)
expressionOut.print(fieldValue(bean: dienstleistungsvertragInstance, field: "referenzen"))
printHtmlPart(22)
expressionOut.print(fieldValue(bean: dienstleistungsvertragInstance, field: "zahlweiseKlar"))
printHtmlPart(23)
invokeTag('formatNumber','g',53,['number':(dienstleistungsvertragInstance.pauschale),'type':("number"),'minFractionDigits':("2"),'format':("#,###.##")],-1)
printHtmlPart(24)
i++
}
}
printHtmlPart(25)
invokeTag('paginate','g',59,['total':(dienstleistungsvertragInstanceTotal)],-1)
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
public static final long LAST_MODIFIED = 1397820536000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
