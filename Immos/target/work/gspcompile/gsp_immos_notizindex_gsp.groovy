import org.strotmann.immos.Notiz
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_notizindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/notiz/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'notiz.label', default: 'Notiz'))],-1)
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
invokeTag('message','g',15,['code':("default.mcSuch.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("show"),'action':("find")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('actionSubmit','g',20,['action':("create"),'value':("Notiz anlegen für")],-1)
printHtmlPart(10)
invokeTag('select','g',21,['name':("domName"),'from':(Notiz.domNamen),'value':("it")],-1)
printHtmlPart(11)
})
invokeTag('form','g',23,['action':("index")],2)
printHtmlPart(12)
invokeTag('message','g',30,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(13)
if(true && (flash.message)) {
printHtmlPart(14)
expressionOut.print(flash.message)
printHtmlPart(15)
}
printHtmlPart(16)
invokeTag('sortableColumn','g',38,['property':("anlagetermin"),'title':(message(code: 'notiz.anlagetermin.label', default: 'Anlagetermin'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',40,['property':("notiztext"),'title':(message(code: 'notiz.notiztext.label', default: 'Notiztext'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',42,['property':("referenz"),'title':(message(code: 'notiz.referenz.label', default: 'Referenz'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',44,['property':("wiedervorlagetermin"),'title':(message(code: 'notiz.wiedervorlagetermin.label', default: 'Wiedervorlagetermin'))],-1)
printHtmlPart(18)
loop:{
int i = 0
for( notizInstance in (notizInstanceList) ) {
printHtmlPart(19)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(20)
createTagBody(3, {->
invokeTag('formatDate','g',52,['date':(notizInstance.anlagetermin),'format':("dd.MM.yyyy")],-1)
})
invokeTag('link','g',52,['action':("show"),'id':(notizInstance.id)],3)
printHtmlPart(21)
expressionOut.print(fieldValue(bean: notizInstance, field: "notiztext"))
printHtmlPart(21)
expressionOut.print(fieldValue(bean: notizInstance, field: "referenz"))
printHtmlPart(21)
invokeTag('formatDate','g',58,['date':(notizInstance.wiedervorlagetermin),'format':("dd.MM.yyyy")],-1)
printHtmlPart(22)
i++
}
}
printHtmlPart(23)
invokeTag('paginate','g',65,['total':(notizInstanceCount ?: 0)],-1)
printHtmlPart(24)
})
invokeTag('captureBody','sitemesh',68,[:],1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1412434574000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
