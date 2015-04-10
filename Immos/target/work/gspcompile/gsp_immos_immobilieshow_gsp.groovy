import org.strotmann.immos.Immobilie
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_immobilieshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/immobilie/show.gsp" }
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
if(true && (immobilieInstance?.hausadresse)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("immobilie.hausadresse.label"),'default':("Hausadresse")],-1)
printHtmlPart(15)
createTagBody(3, {->
expressionOut.print(immobilieInstance?.hausadresse?.encodeAsHTML())
})
invokeTag('link','g',30,['controller':("hausadresse"),'action':("show"),'id':(immobilieInstance?.hausadresse?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (immobilieInstance?.grundbuch)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("immobilie.grundbuch.label"),'default':("Grundbuch")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',39,['bean':(immobilieInstance),'field':("grundbuch")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (immobilieInstance?.baujahr)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("immobilie.baujahr.label"),'default':("Baujahr")],-1)
printHtmlPart(21)
invokeTag('formatNumber','g',48,['number':(immobilieInstance?.baujahr.encodeAsHTML())],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (immobilieInstance?.eigentumAb)) {
printHtmlPart(22)
invokeTag('message','g',55,['code':("immobilie.eigentumAb.label"),'default':("Eigentum Ab")],-1)
printHtmlPart(23)
invokeTag('formatDate','g',57,['date':(immobilieInstance?.eigentumAb),'format':("dd.MM.yyyy")],-1)
printHtmlPart(16)
}
printHtmlPart(24)
if(true && (immobilieInstance?.eigentumBis)) {
printHtmlPart(25)
invokeTag('message','g',64,['code':("immobilie.eigentumBis.label"),'default':("Eigentum Bis")],-1)
printHtmlPart(26)
invokeTag('formatDate','g',66,['date':(immobilieInstance?.eigentumBis),'format':("dd.MM.yyyy")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (immobilieInstance?.anschaffungspreis)) {
printHtmlPart(27)
invokeTag('message','g',73,['code':("immobilie.anschaffungspreis.label"),'default':("Anschaffungspreis")],-1)
printHtmlPart(28)
invokeTag('formatNumber','g',75,['number':(immobilieInstance.anschaffungspreis),'type':("number"),'minFractionDigits':("2"),'maxFractionDigits':("2"),'format':("#,##0.00")],-1)
printHtmlPart(16)
}
printHtmlPart(24)
if(true && (immobilieInstance?.verkaufspreis)) {
printHtmlPart(29)
invokeTag('message','g',82,['code':("immobilie.verkaufspreis.label"),'default':("Verkaufspreis")],-1)
printHtmlPart(30)
invokeTag('formatNumber','g',84,['number':(immobilieInstance.verkaufspreis),'type':("number"),'minFractionDigits':("2"),'maxFractionDigits':("2"),'format':("#,##0.00")],-1)
printHtmlPart(16)
}
printHtmlPart(31)
invokeTag('message','g',90,['code':("immobilie.restschuld.label"),'default':("Restschuld")],-1)
printHtmlPart(32)
invokeTag('formatNumber','g',92,['number':(immobilieInstance.restschuld),'type':("number"),'minFractionDigits':("2"),'maxFractionDigits':("2"),'format':("#,##0.00")],-1)
printHtmlPart(33)
if(true && (immobilieInstance?.grundstueckspreis)) {
printHtmlPart(34)
invokeTag('message','g',98,['code':("immobilie.grundstueckspreis.label"),'default':("Grundstueckspreis")],-1)
printHtmlPart(35)
invokeTag('fieldValue','g',100,['bean':(immobilieInstance),'field':("grundstueckspreis")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (immobilieInstance?.grundstuecksgroesse)) {
printHtmlPart(36)
invokeTag('message','g',107,['code':("immobilie.grundstuecksgroesse.label"),'default':("Grundstuecksgroesse")],-1)
printHtmlPart(37)
invokeTag('fieldValue','g',109,['bean':(immobilieInstance),'field':("grundstuecksgroesse")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (immobilieInstance?.erhoehteAbschreibung)) {
printHtmlPart(38)
invokeTag('message','g',116,['code':("immobilie.erhoehteAbschreibung.label"),'default':("Erhoehte Abschreibung")],-1)
printHtmlPart(39)
invokeTag('formatBoolean','g',118,['boolean':(immobilieInstance?.erhoehteAbschreibung)],-1)
printHtmlPart(16)
}
printHtmlPart(24)
if(true && (immobilieInstance?.sozialerWohnungsbau)) {
printHtmlPart(40)
invokeTag('message','g',125,['code':("immobilie.sozialerWohnungsbau.label"),'default':("SozialerWohnungsbau")],-1)
printHtmlPart(41)
invokeTag('formatBoolean','g',127,['boolean':(immobilieInstance?.sozialerWohnungsbau)],-1)
printHtmlPart(16)
}
printHtmlPart(24)
if(true && (immobilieInstance?.mietsachen)) {
printHtmlPart(42)
invokeTag('message','g',134,['code':("immobilie.mietsachen.label"),'default':("Mietsachen")],-1)
printHtmlPart(43)
for( m in (immobilieInstance.mietsachen) ) {
printHtmlPart(44)
createTagBody(4, {->
expressionOut.print(m?.mietsacheKurz)
})
invokeTag('link','g',137,['controller':("mietsache"),'action':("show"),'id':(m.id)],4)
printHtmlPart(45)
}
printHtmlPart(46)
}
printHtmlPart(24)
if(true && (flash.teilsummen)) {
printHtmlPart(47)
invokeTag('message','g',145,['code':("immobilie.teilsummen.label"),'default':("Teilsummen")],-1)
printHtmlPart(43)
for( t in (flash.teilsummen) ) {
printHtmlPart(48)
invokeTag('message','g',148,['message':(t)],-1)
printHtmlPart(45)
}
printHtmlPart(46)
}
printHtmlPart(24)
if(true && (immobilieInstance?.zaehlers)) {
printHtmlPart(49)
invokeTag('message','g',156,['code':("immobilie.zaehlers.label"),'default':("Zähler")],-1)
printHtmlPart(43)
for( z in (immobilieInstance.zaehlers) ) {
printHtmlPart(50)
createTagBody(4, {->
expressionOut.print(z?.encodeAsHTML())
})
invokeTag('link','g',159,['controller':("zaehler"),'action':("show"),'id':(z.id)],4)
printHtmlPart(45)
}
printHtmlPart(46)
}
printHtmlPart(17)
if(true && (immobilieInstance?.kredite)) {
printHtmlPart(51)
invokeTag('message','g',167,['code':("immobilie.kredite.label"),'default':("Kredite")],-1)
printHtmlPart(43)
for( k in (immobilieInstance.kredite) ) {
printHtmlPart(52)
createTagBody(4, {->
expressionOut.print(k?.encodeAsHTML())
})
invokeTag('link','g',170,['controller':("kredit"),'action':("show"),'id':(k.id)],4)
printHtmlPart(45)
}
printHtmlPart(46)
}
printHtmlPart(17)
if(true && (immobilieInstance?.dienstleistungsvertraege)) {
printHtmlPart(53)
invokeTag('message','g',178,['code':("immobilie.dienstleistungsvertraege.label"),'default':("Dienstleistungsvertraege")],-1)
printHtmlPart(43)
for( d in (immobilieInstance.dienstleistungsvertraege) ) {
printHtmlPart(54)
createTagBody(4, {->
expressionOut.print(d?.dvKurz)
})
invokeTag('link','g',181,['controller':("dienstleistungsvertrag"),'action':("show"),'id':(d.id)],4)
printHtmlPart(45)
}
printHtmlPart(46)
}
printHtmlPart(17)
if(true && (immobilieInstance?.rechnungen)) {
printHtmlPart(55)
invokeTag('message','g',189,['code':("immobilie.rechnungen.label"),'default':("Rechnungen")],-1)
printHtmlPart(43)
for( r in (immobilieInstance.rechnungen) ) {
printHtmlPart(56)
createTagBody(4, {->
expressionOut.print(r?.reLang)
})
invokeTag('link','g',192,['controller':("rechnung"),'action':("show"),'id':(r.id)],4)
printHtmlPart(45)
}
printHtmlPart(46)
}
printHtmlPart(24)
if(true && (immobilieInstance?.immoabrechnungen)) {
printHtmlPart(57)
invokeTag('message','g',200,['code':("immobilie.immoabrechnungen.label"),'default':("Immoabrechnungen")],-1)
printHtmlPart(43)
for( ia in (immobilieInstance.immoabrechnungen) ) {
printHtmlPart(58)
createTagBody(4, {->
expressionOut.print(ia?.abrKurz)
})
invokeTag('link','g',203,['controller':("immoabrechnung"),'action':("show"),'id':(ia.id)],4)
printHtmlPart(45)
}
printHtmlPart(46)
}
printHtmlPart(17)
if(true && (immobilieInstance?.einheitswerte)) {
printHtmlPart(59)
invokeTag('message','g',211,['code':("immobilie.einheitswerte.label"),'default':("Einheitswerte")],-1)
printHtmlPart(43)
for( e in (immobilieInstance.einheitswerte) ) {
printHtmlPart(60)
createTagBody(4, {->
expressionOut.print(e?.encodeAsHTML())
})
invokeTag('link','g',214,['controller':("einheitswert"),'action':("show"),'id':(e.id)],4)
printHtmlPart(45)
}
printHtmlPart(46)
}
printHtmlPart(24)
if(true && (immobilieInstance?.grundschulden)) {
printHtmlPart(61)
invokeTag('message','g',222,['code':("immobilie.grundschulden.label"),'default':("Grundschulden")],-1)
printHtmlPart(43)
for( e in (immobilieInstance.grundschulden) ) {
printHtmlPart(62)
createTagBody(4, {->
expressionOut.print(e?.encodeAsHTML())
})
invokeTag('link','g',225,['controller':("grundschuld"),'action':("show"),'id':(e.id)],4)
printHtmlPart(45)
}
printHtmlPart(46)
}
printHtmlPart(63)
invokeTag('message','g',232,['code':("immobilie.notizen.label"),'default':("Notizen")],-1)
printHtmlPart(43)
for( n in (org.strotmann.immos.Notiz.getNotizen('Immobilie',immobilieInstance.id)) ) {
printHtmlPart(64)
createTagBody(3, {->
expressionOut.print(n)
})
invokeTag('link','g',235,['controller':("notiz"),'action':("show"),'id':(n.id)],3)
printHtmlPart(45)
}
printHtmlPart(65)
createTagBody(2, {->
printHtmlPart(66)
invokeTag('hiddenField','g',242,['name':("id"),'value':(immobilieInstance?.id)],-1)
printHtmlPart(67)
createTagBody(3, {->
invokeTag('message','g',243,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',243,['class':("edit"),'action':("edit"),'id':(immobilieInstance?.id)],3)
printHtmlPart(67)
invokeTag('actionSubmit','g',244,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(68)
})
invokeTag('form','g',246,[:],2)
printHtmlPart(69)
})
invokeTag('captureBody','sitemesh',248,[:],1)
printHtmlPart(70)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1412841766000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
