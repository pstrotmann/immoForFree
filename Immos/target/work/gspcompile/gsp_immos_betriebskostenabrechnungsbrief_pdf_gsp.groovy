import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_betriebskostenabrechnungsbrief_pdf_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/betriebskostenabrechnungsbrief/_pdf.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',21,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
expressionOut.print(form?.briefDatum)
printHtmlPart(5)
expressionOut.print(form?.adressAnrede)
printHtmlPart(6)
expressionOut.print(form?.adressName)
printHtmlPart(6)
expressionOut.print(form?.strHnr)
printHtmlPart(6)
expressionOut.print(form?.plzOrt)
printHtmlPart(7)
expressionOut.print(form?.briefAnrede1)
printHtmlPart(8)
expressionOut.print(form?.anredeName)
printHtmlPart(9)
expressionOut.print(form?.briefAnrede2)
printHtmlPart(10)
expressionOut.print(form?.jahr)
printHtmlPart(11)
expressionOut.print(form?.erstattung)
printHtmlPart(12)
if(true && (form?.mitKonto == 'ja')) {
printHtmlPart(13)
expressionOut.print(form?.kto)
printHtmlPart(14)
expressionOut.print(form?.blz)
printHtmlPart(15)
}
else {
printHtmlPart(16)
}
printHtmlPart(17)
})
invokeTag('captureBody','sitemesh',76,[:],1)
printHtmlPart(18)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1413205412000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
