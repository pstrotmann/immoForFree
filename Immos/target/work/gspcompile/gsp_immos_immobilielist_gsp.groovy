import org.strotmann.immos.Immobilie
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_immobilielist_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/immobilie/list.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'immobilie.label', default: 'Immobilie'))],-1)
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
invokeTag('message','g',26,['code':("immobilie.hausadresse.label"),'default':("Hausadresse")],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',28,['property':("baujahr"),'title':(message(code: 'immobilie.baujahr.label', default: 'Baujahr'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',30,['property':("eigentumAb"),'title':(message(code: 'immobilie.eigentumAb.label', default: 'Eigentum Ab'))],-1)
printHtmlPart(15)
invokeTag('message','g',32,['code':("immobilie.anschaffungspreis.label"),'default':("Anschaffungspreis")],-1)
printHtmlPart(16)
invokeTag('message','g',34,['code':("immobilie.restschuld.label"),'default':("Restschuld")],-1)
printHtmlPart(17)
loop:{
int i = 0
for( immobilieInstance in (immobilieInstanceList) ) {
printHtmlPart(18)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(19)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: immobilieInstance, field: "hausadresse"))
})
invokeTag('link','g',42,['action':("show"),'id':(immobilieInstance.id)],3)
printHtmlPart(20)
invokeTag('formatNumber','g',44,['number':(immobilieInstance.baujahr.encodeAsHTML())],-1)
printHtmlPart(20)
invokeTag('formatDate','g',46,['date':(immobilieInstance.eigentumAb),'format':("dd.MM.yyyy")],-1)
printHtmlPart(21)
invokeTag('formatNumber','g',48,['number':(immobilieInstance.anschaffungspreis),'type':("number"),'minFractionDigits':("2"),'maxFractionDigits':("2"),'format':("#,##0.00")],-1)
printHtmlPart(22)
invokeTag('formatNumber','g',50,['number':(immobilieInstance.restschuld),'type':("number"),'minFractionDigits':("2"),'maxFractionDigits':("2"),'format':("#,##0.00")],-1)
printHtmlPart(23)
i++
}
}
printHtmlPart(24)
invokeTag('message','g',61,['code':("immobilie.summe.label"),'default':("Summen")],-1)
printHtmlPart(25)
invokeTag('formatNumber','g',63,['number':(Immobilie.anschaffungssumme),'type':("number"),'minFractionDigits':("2"),'maxFractionDigits':("2"),'format':("#,##0.00")],-1)
printHtmlPart(22)
invokeTag('formatNumber','g',65,['number':(Immobilie.summeRestschuld),'type':("number"),'minFractionDigits':("2"),'maxFractionDigits':("2"),'format':("#,##0.00")],-1)
printHtmlPart(26)
})
invokeTag('captureBody','sitemesh',71,[:],1)
printHtmlPart(27)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1399193512000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
