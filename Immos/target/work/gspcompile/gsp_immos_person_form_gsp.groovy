import org.strotmann.immos.Person
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_person_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/person/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: personInstance, field: 'name', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("person.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("name"),'maxlength':("30"),'pattern':(personInstance.constraints.name.matches),'required':(""),'value':(personInstance?.name)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: personInstance, field: 'hausadresse', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("person.hausadresse.label"),'default':("Hausadresse")],-1)
printHtmlPart(5)
invokeTag('select','g',18,['id':("hausadresse"),'name':("hausadresse.id"),'from':(org.strotmann.immos.Hausadresse.getMiniList()),'optionKey':("id"),'value':(personInstance?.hausadresse?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(6)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'hausadresse.label', default: 'Hausadresse')]))
})
invokeTag('link','g',19,['controller':("hausadresse"),'action':("create"),'params':(['person.id': personInstance?.id])],1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: personInstance, field: 'titel', 'error'))
printHtmlPart(7)
invokeTag('message','g',24,['code':("person.titel.label"),'default':("Titel")],-1)
printHtmlPart(5)
invokeTag('textField','g',27,['name':("titel"),'maxlength':("20"),'pattern':(personInstance.constraints.titel.matches),'value':(personInstance?.titel)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: personInstance, field: 'vorname', 'error'))
printHtmlPart(8)
invokeTag('message','g',32,['code':("person.vorname.label"),'default':("Vorname")],-1)
printHtmlPart(5)
invokeTag('textField','g',35,['name':("vorname"),'maxlength':("30"),'pattern':(personInstance.constraints.vorname.matches),'value':(personInstance?.vorname)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: personInstance, field: 'geschlecht', 'error'))
printHtmlPart(9)
invokeTag('message','g',40,['code':("person.geschlecht.label"),'default':("Geschlecht")],-1)
printHtmlPart(5)
invokeTag('select','g',43,['name':("geschlecht"),'from':(personInstance.constraints.geschlecht.inList),'value':(personInstance?.geschlecht),'valueMessagePrefix':("person.geschlecht"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: personInstance, field: 'geburtsdatum', 'error'))
printHtmlPart(10)
invokeTag('message','g',48,['code':("person.geburtsdatum.label"),'default':("Geburtsdatum")],-1)
printHtmlPart(5)
invokeTag('datePicker','g',51,['name':("geburtsdatum"),'precision':("day"),'value':(personInstance?.geburtsdatum),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: personInstance, field: 'persoenlicheAnrede', 'error'))
printHtmlPart(11)
invokeTag('message','g',56,['code':("person.persoenlicheAnrede.label"),'default':("persönliche Anrede")],-1)
printHtmlPart(5)
invokeTag('checkBox','g',59,['name':("persoenlicheAnrede"),'value':(personInstance?.persoenlicheAnrede)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: personInstance, field: 'bankverbindung', 'error'))
printHtmlPart(12)
invokeTag('message','g',64,['code':("person.bankverbindung.label"),'default':("Bankverbindung")],-1)
printHtmlPart(13)
for( b in (personInstance?.bankverbindung) ) {
printHtmlPart(14)
createTagBody(2, {->
expressionOut.print(b?.encodeAsHTML())
})
invokeTag('link','g',70,['controller':("bankverbindung"),'action':("show"),'id':(b.id)],2)
printHtmlPart(15)
}
printHtmlPart(16)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'bankverbindung.label', default: 'Bankverbindung')]))
})
invokeTag('link','g',73,['controller':("bankverbindung"),'action':("create"),'params':(['person.id': personInstance?.id])],1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: personInstance, field: 'kommunikation', 'error'))
printHtmlPart(18)
invokeTag('message','g',81,['code':("person.kommunikation.label"),'default':("Kommunikation")],-1)
printHtmlPart(13)
for( k in (personInstance?.kommunikation) ) {
printHtmlPart(14)
createTagBody(2, {->
expressionOut.print(k?.encodeAsHTML())
})
invokeTag('link','g',87,['controller':("kommunikation"),'action':("show"),'id':(k.id)],2)
printHtmlPart(15)
}
printHtmlPart(19)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'kommunikation.label', default: 'Kommunikation')]))
})
invokeTag('link','g',91,['controller':("kommunikation"),'action':("create"),'params':(['person.id': personInstance?.id])],1)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: personInstance, field: 'partnerrolle', 'error'))
printHtmlPart(21)
invokeTag('message','g',100,['code':("person.partnerrolle.label"),'default':("Partnerrolle")],-1)
printHtmlPart(13)
for( p in (personInstance?.partnerrolle) ) {
printHtmlPart(14)
createTagBody(2, {->
expressionOut.print(p?.encodeAsHTML())
})
invokeTag('link','g',106,['controller':("partnerrolle"),'action':("show"),'id':(p.id)],2)
printHtmlPart(15)
}
printHtmlPart(22)
invokeTag('select','g',110,['name':("partnerrolleInstance.rolle"),'from':(flash.rollenliste),'value':(partnerrolleInstance?.rolle),'valueMessagePrefix':("partnerrolle.rolle")],-1)
printHtmlPart(6)
invokeTag('actionSubmit','g',111,['action':("toRolle"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(23)
expressionOut.print(hasErrors(bean: personInstance, field: 'notizen', 'error'))
printHtmlPart(24)
invokeTag('message','g',120,['code':("person.notizen.label"),'default':("Notizen")],-1)
printHtmlPart(13)
for( n in (org.strotmann.immos.Notiz.getNotizen('Person',personInstance.id)) ) {
printHtmlPart(14)
createTagBody(2, {->
expressionOut.print(n)
})
invokeTag('link','g',126,['controller':("notiz"),'action':("show"),'id':(n.id)],2)
printHtmlPart(15)
}
printHtmlPart(16)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'notiz.label', default: 'Notiz')]))
})
invokeTag('link','g',129,['controller':("notiz"),'action':("create"),'params':(['person.id': personInstance?.id])],1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1412704196000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
