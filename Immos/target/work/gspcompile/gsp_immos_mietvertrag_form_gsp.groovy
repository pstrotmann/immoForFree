import org.strotmann.immos.Mietvertrag
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_mietvertrag_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mietvertrag/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: mietvertragInstance, field: 'partnerrolle', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("mietvertrag?.mieter.label"),'default':("Mieter")],-1)
printHtmlPart(2)
if(true && (flash.partner)) {
printHtmlPart(3)
invokeTag('fieldValue','g',11,['bean':(flash.partner),'field':("name")],-1)
printHtmlPart(4)
}
printHtmlPart(4)
if(true && (mietvertragInstance?.mieter)) {
printHtmlPart(3)
invokeTag('fieldValue','g',14,['bean':(mietvertragInstance?.mieter?.partner),'field':("name")],-1)
printHtmlPart(4)
}
printHtmlPart(4)
if(true && (!flash.partner && !mietvertragInstance?.mieter)) {
printHtmlPart(3)
invokeTag('select','g',17,['id':("partner"),'name':("partner.id"),'from':(org.strotmann.immos.Mietvertrag.getMieterList()),'optionKey':("id"),'required':(""),'value':(mietvertragInstance?.mieter?.id),'class':("many-to-one")],-1)
printHtmlPart(4)
}
printHtmlPart(5)
expressionOut.print(hasErrors(bean: mietvertragInstance, field: 'mietsache', 'error'))
printHtmlPart(6)
invokeTag('message','g',23,['code':("mietvertrag.mietsache.label"),'default':("Mietsache")],-1)
printHtmlPart(2)
invokeTag('select','g',26,['id':("mietsache"),'name':("mietsache.id"),'from':(org.strotmann.immos.Mietsache.list()),'optionKey':("id"),'required':(""),'value':(mietvertragInstance?.mietsache?.id),'class':("many-to-one")],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: mietvertragInstance, field: 'zusatzMietsache', 'error'))
printHtmlPart(7)
invokeTag('message','g',31,['code':("mietvertrag.zusatzMietsache.label"),'default':("Zusatz")],-1)
printHtmlPart(8)
invokeTag('select','g',34,['id':("zusatzMietsache"),'name':("zusatzMietsache.id"),'from':(org.strotmann.immos.Mietsache.list()),'optionKey':("id"),'value':(mietvertragInstance?.zusatzMietsache?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: mietvertragInstance, field: 'mietbeginn', 'error'))
printHtmlPart(9)
invokeTag('message','g',39,['code':("mietvertrag.mietbeginn.label"),'default':("Mietbeginn")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',42,['name':("mietbeginn"),'precision':("day"),'value':(mietvertragInstance?.mietbeginn)],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: mietvertragInstance, field: 'mietende', 'error'))
printHtmlPart(10)
invokeTag('message','g',47,['code':("mietvertrag.mietende.label"),'default':("Mietende")],-1)
printHtmlPart(8)
invokeTag('datePicker','g',50,['name':("mietende"),'precision':("day"),'value':(mietvertragInstance?.mietende),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: mietvertragInstance, field: 'kaution', 'error'))
printHtmlPart(11)
invokeTag('message','g',55,['code':("mietvertrag.kaution.label"),'default':("Kaution")],-1)
printHtmlPart(8)
invokeTag('field','g',58,['name':("kaution"),'value':(fieldValue(bean: mietvertragInstance, field: 'kaution'))],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: mietvertragInstance, field: 'zahlweise', 'error'))
printHtmlPart(12)
invokeTag('message','g',63,['code':("mietvertrag.zahlweise.label"),'default':("Zahlweise")],-1)
printHtmlPart(2)
invokeTag('select','g',66,['name':("zahlweise"),'from':(mietvertragInstance.constraints.zahlweise.inList),'valueMessagePrefix':("zahlweise.category")],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: mietvertragInstance, field: 'tuerschluessel', 'error'))
printHtmlPart(13)
invokeTag('message','g',71,['code':("mietvertrag.tuerschluessel.label"),'default':("Tuerschluessel")],-1)
printHtmlPart(8)
invokeTag('textField','g',74,['name':("tuerschluessel"),'value':(mietvertragInstance?.tuerschluessel)],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: mietvertragInstance, field: 'vertragsstaende', 'error'))
printHtmlPart(14)
invokeTag('message','g',79,['code':("mietvertrag.vertragsstaende.label"),'default':("Vertragsstände")],-1)
printHtmlPart(15)
for( v in (mietvertragInstance?.vertragsstaende) ) {
printHtmlPart(16)
createTagBody(2, {->
expressionOut.print(v?.vstandKurz.encodeAsHTML())
})
invokeTag('link','g',85,['controller':("mietvertragsstand"),'action':("show"),'id':(v.id)],2)
printHtmlPart(17)
}
printHtmlPart(18)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'mietvertragsstand.label', default: 'Mietvertragsstand')]))
})
invokeTag('link','g',88,['controller':("mietvertragsstand"),'action':("create"),'params':(['mietvertrag.id': mietvertragInstance?.id])],1)
printHtmlPart(19)
expressionOut.print(hasErrors(bean: mietvertragInstance, field: 'zahlungen', 'error'))
printHtmlPart(20)
invokeTag('message','g',96,['code':("mietvertrag.zahlungen.label"),'default':("Zahlungen")],-1)
printHtmlPart(15)
for( z in (mietvertragInstance?.zahlungen) ) {
printHtmlPart(16)
createTagBody(2, {->
expressionOut.print(z?.encodeAsHTML())
})
invokeTag('link','g',102,['controller':("zahlung"),'action':("show"),'id':(z.id)],2)
printHtmlPart(17)
}
printHtmlPart(18)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'zahlung.label', default: 'Zahlung')]))
})
invokeTag('link','g',105,['controller':("zahlung"),'action':("create"),'params':(['mietvertrag.id': mietvertragInstance?.id])],1)
printHtmlPart(19)
expressionOut.print(hasErrors(bean: mietvertragInstance, field: 'mietforderungen', 'error'))
printHtmlPart(21)
invokeTag('message','g',113,['code':("mietvertrag.mietforderungen.label"),'default':("Mietforderungen")],-1)
printHtmlPart(15)
for( m in (mietvertragInstance?.mietforderungen) ) {
printHtmlPart(16)
createTagBody(2, {->
expressionOut.print(m?.encodeAsHTML())
})
invokeTag('link','g',119,['controller':("offenerPosten"),'action':("show"),'id':(m.id)],2)
printHtmlPart(17)
}
printHtmlPart(18)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'offenerPosten.label', default: 'OffenerPosten')]))
})
invokeTag('link','g',122,['controller':("offenerPosten"),'action':("create"),'params':(['mietvertrag.id': mietvertragInstance?.id])],1)
printHtmlPart(19)
expressionOut.print(hasErrors(bean: mietvertragInstance, field: 'notizen', 'error'))
printHtmlPart(22)
invokeTag('message','g',130,['code':("mietvertrag.notizen.label"),'default':("Notizen")],-1)
printHtmlPart(15)
for( n in (org.strotmann.immos.Notiz.getNotizen('Mietvertrag',mietvertragInstance.id)) ) {
printHtmlPart(16)
createTagBody(2, {->
expressionOut.print(n)
})
invokeTag('link','g',136,['controller':("notiz"),'action':("show"),'id':(n.id)],2)
printHtmlPart(17)
}
printHtmlPart(18)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'notiz.label', default: 'Notiz')]))
})
invokeTag('link','g',139,['controller':("notiz"),'action':("create"),'params':(['mietvertrag.id': mietvertragInstance?.id])],1)
printHtmlPart(23)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1412530466000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
