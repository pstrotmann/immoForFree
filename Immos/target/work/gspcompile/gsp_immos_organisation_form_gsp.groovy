import org.strotmann.immos.Organisation
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_immos_organisation_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/organisation/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: organisationInstance, field: 'name', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("organisation.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("name"),'maxlength':("80"),'pattern':(organisationInstance.constraints.name.matches),'required':(""),'value':(organisationInstance?.name)],-1)
printHtmlPart(3)
if(true && (organisationInstance.getAspaList())) {
printHtmlPart(4)
invokeTag('message','g',15,['code':("organisation.partnerrolle.label"),'default':("Ansprechpartner")],-1)
printHtmlPart(5)
for( p in (organisationInstance.getAspaList()) ) {
printHtmlPart(6)
createTagBody(3, {->
expressionOut.print(p?.encodeAsHTML())
})
invokeTag('link','g',18,['controller':("person"),'action':("show"),'id':(p.id)],3)
printHtmlPart(7)
}
printHtmlPart(8)
}
printHtmlPart(9)
expressionOut.print(hasErrors(bean: organisationInstance, field: 'hausadresse', 'error'))
printHtmlPart(10)
invokeTag('message','g',25,['code':("organisation.hausadresse.label"),'default':("Hausadresse")],-1)
printHtmlPart(11)
invokeTag('select','g',28,['id':("hausadresse"),'name':("hausadresse.id"),'from':(org.strotmann.immos.Hausadresse.getMiniList()),'optionKey':("id"),'value':(organisationInstance?.hausadresse?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(8)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'hausadresse.label', default: 'Hausadresse')]))
})
invokeTag('link','g',29,['controller':("hausadresse"),'action':("create"),'params':(['organisation.id': organisationInstance?.id])],1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: organisationInstance, field: 'nameZusatz', 'error'))
printHtmlPart(13)
invokeTag('message','g',34,['code':("organisation.nameZusatz.label"),'default':("Name Zusatz")],-1)
printHtmlPart(11)
invokeTag('textField','g',37,['name':("nameZusatz"),'maxlength':("50"),'pattern':(organisationInstance.constraints.nameZusatz.matches),'value':(organisationInstance?.nameZusatz)],-1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: organisationInstance, field: 'rechtsform', 'error'))
printHtmlPart(14)
invokeTag('message','g',42,['code':("organisation.rechtsform.label"),'default':("Rechtsform")],-1)
printHtmlPart(11)
invokeTag('select','g',45,['name':("rechtsform"),'from':(organisationInstance.constraints.rechtsform.inList),'value':(organisationInstance?.rechtsform),'valueMessagePrefix':("organisation.rechtsform"),'noSelection':(['': ''])],-1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: organisationInstance, field: 'bankverbindung', 'error'))
printHtmlPart(15)
invokeTag('message','g',50,['code':("organisation.bankverbindung.label"),'default':("Bankverbindung")],-1)
printHtmlPart(16)
for( b in (organisationInstance?.bankverbindung) ) {
printHtmlPart(17)
createTagBody(2, {->
expressionOut.print(b?.encodeAsHTML())
})
invokeTag('link','g',56,['controller':("bankverbindung"),'action':("show"),'id':(b.id)],2)
printHtmlPart(18)
}
printHtmlPart(19)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'bankverbindung.label', default: 'Bankverbindung')]))
})
invokeTag('link','g',59,['controller':("bankverbindung"),'action':("create"),'params':(['organisation.id': organisationInstance?.id])],1)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: organisationInstance, field: 'kommunikation', 'error'))
printHtmlPart(21)
invokeTag('message','g',67,['code':("organisation.kommunikation.label"),'default':("Kommunikation")],-1)
printHtmlPart(16)
for( k in (organisationInstance?.kommunikation) ) {
printHtmlPart(17)
createTagBody(2, {->
expressionOut.print(k?.encodeAsHTML())
})
invokeTag('link','g',73,['controller':("kommunikation"),'action':("show"),'id':(k.id)],2)
printHtmlPart(18)
}
printHtmlPart(19)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'kommunikation.label', default: 'Kommunikation')]))
})
invokeTag('link','g',76,['controller':("kommunikation"),'action':("create"),'params':(['organisation.id': organisationInstance?.id])],1)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: organisationInstance, field: 'partnerrolle', 'error'))
printHtmlPart(22)
invokeTag('message','g',84,['code':("organisation.partnerrolle.label"),'default':("Partnerrolle")],-1)
printHtmlPart(23)
for( p in (organisationInstance?.partnerrolle) ) {
printHtmlPart(17)
createTagBody(2, {->
expressionOut.print(p?.encodeAsHTML())
})
invokeTag('link','g',89,['controller':("partnerrolle"),'action':("show"),'id':(p.id)],2)
printHtmlPart(18)
}
printHtmlPart(24)
invokeTag('select','g',94,['name':("partnerrolleInstance.rolle"),'from':(flash.rollenliste),'value':(partnerrolleInstance?.rolle),'valueMessagePrefix':("partnerrolle.rolle")],-1)
printHtmlPart(8)
invokeTag('actionSubmit','g',95,['action':("toRolle"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(25)
expressionOut.print(hasErrors(bean: organisationInstance, field: 'postfachadresse', 'error'))
printHtmlPart(26)
invokeTag('message','g',103,['code':("organisation.postfachadresse.label"),'default':("Postfachadresse")],-1)
printHtmlPart(16)
for( p in (organisationInstance?.postfachadresse) ) {
printHtmlPart(17)
createTagBody(2, {->
expressionOut.print(p?.encodeAsHTML())
})
invokeTag('link','g',109,['controller':("postfachadresse"),'action':("show"),'id':(p.id)],2)
printHtmlPart(18)
}
printHtmlPart(19)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'postfachadresse.label', default: 'Postfachadresse')]))
})
invokeTag('link','g',112,['controller':("postfachadresse"),'action':("create"),'params':(['organisation.id': organisationInstance?.id])],1)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: organisationInstance, field: 'notizen', 'error'))
printHtmlPart(27)
invokeTag('message','g',120,['code':("organisation.notizen.label"),'default':("Notizen")],-1)
printHtmlPart(16)
for( n in (org.strotmann.immos.Notiz.getNotizen('Organisation',organisationInstance.id)) ) {
printHtmlPart(17)
createTagBody(2, {->
expressionOut.print(n)
})
invokeTag('link','g',126,['controller':("notiz"),'action':("show"),'id':(n.id)],2)
printHtmlPart(18)
}
printHtmlPart(19)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'notiz.label', default: 'Notiz')]))
})
invokeTag('link','g',129,['controller':("notiz"),'action':("create"),'params':(['organisation.id': organisationInstance?.id])],1)
printHtmlPart(28)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1412506370000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
