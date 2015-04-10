import org.strotmann.immos.Kommunikation
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_kommunikationshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/kommunikation/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'kommunikation.label', default: 'Kommunikation'))],-1)
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
if(true && (kommunikationInstance?.art)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("kommunikation.art.label"),'default':("Art")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',30,['bean':(kommunikationInstance),'field':("art")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (kommunikationInstance?.anwahl)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("kommunikation.anwahl.label"),'default':("Anwahl")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',39,['bean':(kommunikationInstance),'field':("anwahl")],-1)
printHtmlPart(16)
}
printHtmlPart(20)
if(true && (kommunikationInstance?.zusatz)) {
printHtmlPart(21)
invokeTag('message','g',46,['code':("kommunikation.zusatz.label"),'default':("Zusatz")],-1)
printHtmlPart(22)
invokeTag('fieldValue','g',48,['bean':(kommunikationInstance),'field':("zusatz")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (kommunikationInstance?.partner)) {
printHtmlPart(23)
invokeTag('message','g',55,['code':("kommunikation.partner.label"),'default':("Partner")],-1)
printHtmlPart(24)
if(true && (flash.person)) {
printHtmlPart(25)
createTagBody(4, {->
expressionOut.print(kommunikationInstance?.partner?.encodeAsHTML())
})
invokeTag('link','g',58,['controller':("person"),'action':("show"),'id':(kommunikationInstance?.partner?.id)],4)
printHtmlPart(26)
}
printHtmlPart(26)
if(true && (!flash.person)) {
printHtmlPart(25)
createTagBody(4, {->
expressionOut.print(kommunikationInstance?.partner?.encodeAsHTML())
})
invokeTag('link','g',61,['controller':("organisation"),'action':("show"),'id':(kommunikationInstance?.partner?.id)],4)
printHtmlPart(26)
}
printHtmlPart(27)
}
printHtmlPart(28)
createTagBody(2, {->
printHtmlPart(29)
invokeTag('hiddenField','g',70,['name':("id"),'value':(kommunikationInstance?.id)],-1)
printHtmlPart(30)
createTagBody(3, {->
invokeTag('message','g',71,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',71,['class':("edit"),'action':("edit"),'id':(kommunikationInstance?.id)],3)
printHtmlPart(30)
invokeTag('actionSubmit','g',72,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(31)
})
invokeTag('form','g',74,['url':([resource:kommunikationInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(32)
})
invokeTag('captureBody','sitemesh',76,[:],1)
printHtmlPart(33)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1410949528000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
