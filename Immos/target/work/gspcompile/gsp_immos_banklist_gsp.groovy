import org.strotmann.immos.Bank
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_banklist_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/bank/list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'bank.label', default: 'Bank'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('message','g',10,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(4)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(5)
invokeTag('message','g',13,['code':("default.home.label")],-1)
printHtmlPart(6)
createTagBody(2, {->
invokeTag('message','g',14,['code':("default.matchcode.label"),'args':([entityName])],-1)
})
invokeTag('link','g',14,['class':("create"),'action':("create")],2)
printHtmlPart(7)
invokeTag('message','g',18,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
invokeTag('sortableColumn','g',25,['property':("bic"),'title':(message(code: 'bank.bic.label', default: 'Bic'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',27,['property':("blz"),'title':(message(code: 'bank.blz.label', default: 'Blz'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',29,['property':("bankname"),'title':(message(code: 'bank.bankname.label', default: 'Bankname'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',31,['property':("plz"),'title':(message(code: 'bank.plz.label', default: 'Plz'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',33,['property':("ort"),'title':(message(code: 'bank.ort.label', default: 'Ort'))],-1)
printHtmlPart(14)
loop:{
int i = 0
for( bankInstance in (bankInstanceList) ) {
printHtmlPart(15)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(16)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: bankInstance, field: "bic"))
})
invokeTag('link','g',41,['action':("show"),'id':(bankInstance.id)],3)
printHtmlPart(17)
expressionOut.print(fieldValue(bean: bankInstance, field: "blz"))
printHtmlPart(18)
expressionOut.print(fieldValue(bean: bankInstance, field: "bankname"))
printHtmlPart(17)
expressionOut.print(fieldValue(bean: bankInstance, field: "plz"))
printHtmlPart(18)
expressionOut.print(fieldValue(bean: bankInstance, field: "ort"))
printHtmlPart(19)
i++
}
}
printHtmlPart(20)
invokeTag('paginate','g',56,['total':(bankInstanceCount ?: 0)],-1)
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',59,[:],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1411746910000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
