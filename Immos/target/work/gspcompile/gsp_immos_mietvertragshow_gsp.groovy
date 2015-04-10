import org.strotmann.immos.Mietvertrag
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_mietvertragshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mietvertrag/show.gsp" }
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
if(true && (mietvertragInstance?.mieter)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("mietvertrag.mieter.label"),'default':("Mieter")],-1)
printHtmlPart(15)
if(true && (mietvertragInstance?.mieter?.partner instanceof org.strotmann.immos.Person)) {
printHtmlPart(16)
createTagBody(4, {->
expressionOut.print(mietvertragInstance?.mieter?.partner.name.encodeAsHTML())
})
invokeTag('link','g',32,['controller':("person"),'action':("show"),'id':(mietvertragInstance?.mieter?.partner.id)],4)
printHtmlPart(17)
}
printHtmlPart(17)
if(true && (mietvertragInstance?.mieter?.partner instanceof org.strotmann.immos.Organisation)) {
printHtmlPart(16)
createTagBody(4, {->
expressionOut.print(mietvertragInstance?.mieter?.partner.name.encodeAsHTML())
})
invokeTag('link','g',35,['controller':("organisation"),'action':("show"),'id':(mietvertragInstance?.mieter?.partner.id)],4)
printHtmlPart(17)
}
printHtmlPart(18)
}
printHtmlPart(19)
invokeTag('message','g',43,['code':("organisation.mieter.label"),'default':("Mietzahler")],-1)
printHtmlPart(20)
for( p in (mietvertragInstance.getZahlerList()) ) {
printHtmlPart(21)
createTagBody(3, {->
expressionOut.print(p?.encodeAsHTML())
})
invokeTag('link','g',46,['controller':("organisation"),'action':("show"),'id':(p.id)],3)
printHtmlPart(22)
}
printHtmlPart(23)
if(true && (mietvertragInstance?.mietsache)) {
printHtmlPart(24)
invokeTag('message','g',53,['code':("mietvertrag.mietsache.label"),'default':("Mietsache")],-1)
printHtmlPart(25)
createTagBody(3, {->
expressionOut.print(mietvertragInstance?.mietsache?.encodeAsHTML())
})
invokeTag('link','g',55,['controller':("mietsache"),'action':("show"),'id':(mietvertragInstance?.mietsache?.id)],3)
printHtmlPart(26)
}
printHtmlPart(27)
if(true && (mietvertragInstance?.zusatzMietsache)) {
printHtmlPart(28)
invokeTag('message','g',62,['code':("mietvertrag.zusatzMietsache.label"),'default':("Zusatz")],-1)
printHtmlPart(29)
createTagBody(3, {->
expressionOut.print(mietvertragInstance?.zusatzMietsache?.encodeAsHTML())
})
invokeTag('link','g',64,['controller':("mietsache"),'action':("show"),'id':(mietvertragInstance?.zusatzMietsache?.id)],3)
printHtmlPart(26)
}
printHtmlPart(30)
if(true && (mietvertragInstance?.mietbeginn)) {
printHtmlPart(31)
invokeTag('message','g',71,['code':("mietvertrag.mietbeginn.label"),'default':("Mietbeginn")],-1)
printHtmlPart(32)
invokeTag('formatDate','g',73,['date':(mietvertragInstance?.mietbeginn),'format':("dd.MM.yyyy")],-1)
printHtmlPart(26)
}
printHtmlPart(30)
if(true && (mietvertragInstance?.mietende)) {
printHtmlPart(33)
invokeTag('message','g',80,['code':("mietvertrag.mietende.label"),'default':("Mietende")],-1)
printHtmlPart(34)
invokeTag('formatDate','g',82,['date':(mietvertragInstance?.mietende),'format':("dd.MM.yyyy")],-1)
printHtmlPart(26)
}
printHtmlPart(30)
if(true && (mietvertragInstance?.kaution)) {
printHtmlPart(35)
invokeTag('message','g',89,['code':("mietvertrag.kaution.label"),'default':("Kaution")],-1)
printHtmlPart(36)
invokeTag('fieldValue','g',91,['bean':(mietvertragInstance),'field':("kaution")],-1)
printHtmlPart(26)
}
printHtmlPart(30)
if(true && (mietvertragInstance?.zahlweise)) {
printHtmlPart(37)
invokeTag('message','g',98,['code':("mietvertrag.zahlweise.label"),'default':("Zahlweise")],-1)
printHtmlPart(38)
invokeTag('fieldValue','g',101,['bean':(mietvertragInstance),'field':("zahlweiseKlar")],-1)
printHtmlPart(18)
}
printHtmlPart(27)
if(true && (mietvertragInstance?.tuerschluessel)) {
printHtmlPart(39)
invokeTag('message','g',109,['code':("mietvertrag.tuerschluessel.label"),'default':("Tuerschluessel")],-1)
printHtmlPart(40)
invokeTag('fieldValue','g',111,['bean':(mietvertragInstance),'field':("tuerschluessel")],-1)
printHtmlPart(26)
}
printHtmlPart(41)
invokeTag('message','g',117,['code':("mietvertrag.mietsaldo.label"),'default':("Mietsaldo")],-1)
printHtmlPart(42)
invokeTag('formatNumber','g',120,['number':(mietvertragInstance.mietsaldo),'type':("number"),'minFractionDigits':("2"),'format':("#,##0.00")],-1)
printHtmlPart(17)
if(true && (mietvertragInstance.mietsaldo < 0)) {
printHtmlPart(43)
invokeTag('emoticon','g',122,['happy':("false")],-1)
printHtmlPart(22)
}
printHtmlPart(17)
if(true && (mietvertragInstance.mietsaldo > 0)) {
printHtmlPart(44)
invokeTag('emoticon','g',125,['happy':("true")],-1)
printHtmlPart(22)
}
printHtmlPart(45)
if(true && (mietvertragInstance?.vertragsstaende)) {
printHtmlPart(46)
invokeTag('message','g',132,['code':("mietvertrag.vertragsstaende.label"),'default':("Vertragsstände")],-1)
printHtmlPart(20)
for( v in (mietvertragInstance.vertragsstaende) ) {
printHtmlPart(47)
createTagBody(4, {->
expressionOut.print(v?.vstandKurz)
})
invokeTag('link','g',135,['controller':("mietvertragsstand"),'action':("show"),'id':(v.id)],4)
printHtmlPart(22)
}
printHtmlPart(48)
}
printHtmlPart(30)
if(true && (mietvertragInstance?.zahlungen)) {
printHtmlPart(49)
invokeTag('message','g',143,['code':("mietvertrag.zahlungen.label"),'default':("Zahlungen")],-1)
printHtmlPart(20)
for( z in (mietvertragInstance.zahlungen) ) {
printHtmlPart(50)
createTagBody(4, {->
expressionOut.print(z?.zPlus())
})
invokeTag('link','g',147,['controller':("zahlung"),'action':("show"),'id':(z.id)],4)
printHtmlPart(51)
}
printHtmlPart(48)
}
printHtmlPart(30)
if(true && (mietvertragInstance?.mietforderungen)) {
printHtmlPart(52)
invokeTag('message','g',156,['code':("mietvertrag.mietforderungen.label"),'default':("außerordentliche Fälligkeiten")],-1)
printHtmlPart(20)
for( m in (mietvertragInstance.mietforderungen) ) {
printHtmlPart(53)
createTagBody(4, {->
expressionOut.print(m?.encodeAsHTML())
})
invokeTag('link','g',159,['controller':("offenerPosten"),'action':("show"),'id':(m.id)],4)
printHtmlPart(22)
}
printHtmlPart(48)
}
printHtmlPart(27)
if(true && (mietvertragInstance?.betriebskostenabrechnungen)) {
printHtmlPart(54)
invokeTag('message','g',167,['code':("mietvertrag.betriebskostenabrechnungen.label"),'default':("Betriebskostenabrechnungen")],-1)
printHtmlPart(20)
for( n in (mietvertragInstance.betriebskostenabrechnungen) ) {
printHtmlPart(55)
createTagBody(4, {->
expressionOut.print(n?.encodeAsHTML())
})
invokeTag('link','g',170,['controller':("betriebskostenabrechnung"),'action':("show"),'id':(n.id)],4)
printHtmlPart(22)
}
printHtmlPart(48)
}
printHtmlPart(56)
invokeTag('message','g',177,['code':("mietvertrag.notizen.label"),'default':("Notizen")],-1)
printHtmlPart(20)
for( n in (org.strotmann.immos.Notiz.getNotizen('Mietvertrag',mietvertragInstance.id)) ) {
printHtmlPart(57)
createTagBody(3, {->
expressionOut.print(n)
})
invokeTag('link','g',180,['controller':("notiz"),'action':("show"),'id':(n.id)],3)
printHtmlPart(22)
}
printHtmlPart(58)
createTagBody(2, {->
printHtmlPart(59)
invokeTag('hiddenField','g',187,['name':("id"),'value':(mietvertragInstance?.id)],-1)
printHtmlPart(60)
createTagBody(3, {->
invokeTag('message','g',188,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',188,['class':("edit"),'action':("edit"),'id':(mietvertragInstance?.id)],3)
printHtmlPart(60)
invokeTag('actionSubmit','g',189,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(61)
})
invokeTag('form','g',191,[:],2)
printHtmlPart(62)
})
invokeTag('captureBody','sitemesh',193,[:],1)
printHtmlPart(63)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1412530464000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
