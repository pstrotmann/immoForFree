import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immosindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',88,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('message','g',90,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(6)
createClosureForHtmlPart(7, 2)
invokeTag('link','g',98,['controller':("matchcode")],2)
printHtmlPart(8)
createClosureForHtmlPart(9, 2)
invokeTag('link','g',99,['controller':("person"),'action':("list")],2)
printHtmlPart(8)
createClosureForHtmlPart(10, 2)
invokeTag('link','g',100,['controller':("organisation"),'action':("list")],2)
printHtmlPart(11)
createClosureForHtmlPart(12, 2)
invokeTag('link','g',104,['controller':("immobilie"),'action':("list")],2)
printHtmlPart(8)
createClosureForHtmlPart(13, 2)
invokeTag('link','g',105,['controller':("mietvertrag"),'action':("list")],2)
printHtmlPart(8)
createClosureForHtmlPart(14, 2)
invokeTag('link','g',106,['controller':("druck"),'action':("printMietjournal")],2)
printHtmlPart(8)
createClosureForHtmlPart(15, 2)
invokeTag('link','g',107,['controller':("kredit"),'action':("list")],2)
printHtmlPart(8)
createClosureForHtmlPart(16, 2)
invokeTag('link','g',108,['controller':("dienstleistungsvertrag"),'action':("list")],2)
printHtmlPart(8)
createClosureForHtmlPart(17, 2)
invokeTag('link','g',109,['controller':("rechnung"),'action':("list")],2)
printHtmlPart(18)
invokeTag('message','g',113,['code':("bankumsatz.import.code"),'default':("Bankumsätze importieren")],-1)
printHtmlPart(19)
createClosureForHtmlPart(20, 2)
invokeTag('uploadForm','g',117,['controller':("bankumsatzImport")],2)
printHtmlPart(19)
if(true && (flash.messageF)) {
printHtmlPart(21)
expressionOut.print(flash.messageF)
printHtmlPart(22)
}
printHtmlPart(23)
if(true && (flash.message)) {
printHtmlPart(21)
expressionOut.print(flash.message)
printHtmlPart(22)
}
printHtmlPart(24)
createClosureForHtmlPart(25, 2)
invokeTag('link','g',126,['controller':("bankumsatzZuordnung")],2)
printHtmlPart(26)
if(true && (flash.message1)) {
printHtmlPart(21)
expressionOut.print(flash.message1)
printHtmlPart(27)
expressionOut.print(flash.message2)
printHtmlPart(27)
expressionOut.print(flash.message3)
printHtmlPart(27)
expressionOut.print(flash.message4)
printHtmlPart(22)
}
printHtmlPart(24)
createClosureForHtmlPart(28, 2)
invokeTag('link','g',133,['controller':("bankumsatz"),'action':("listOffen")],2)
printHtmlPart(8)
createClosureForHtmlPart(29, 2)
invokeTag('link','g',134,['controller':("druck"),'action':("printOffeneUmsaetze")],2)
printHtmlPart(8)
createClosureForHtmlPart(30, 2)
invokeTag('link','g',135,['controller':("bankumsatz"),'action':("listZugeordnet")],2)
printHtmlPart(8)
createClosureForHtmlPart(31, 2)
invokeTag('link','g',136,['controller':("druck"),'action':("printZuordnungen")],2)
printHtmlPart(32)
createClosureForHtmlPart(33, 2)
invokeTag('link','g',138,['controller':("immoabrechnung"),'action':("list")],2)
printHtmlPart(26)
if(true && (flash.messageN)) {
printHtmlPart(21)
expressionOut.print(flash.messageN)
printHtmlPart(22)
}
printHtmlPart(34)
createClosureForHtmlPart(35, 2)
invokeTag('link','g',145,['controller':("bank")],2)
printHtmlPart(8)
createClosureForHtmlPart(36, 2)
invokeTag('link','g',146,['controller':("notiz")],2)
printHtmlPart(37)
})
invokeTag('captureBody','sitemesh',151,[:],1)
printHtmlPart(38)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1423140904000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
