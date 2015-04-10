<%@ page import="org.strotmann.immos.Organisation" %>



<div class="fieldcontain ${hasErrors(bean: organisationInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="organisation.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="80" pattern="${organisationInstance.constraints.name.matches}" required="" value="${organisationInstance?.name}"/>
</div>

<div class="fieldcontain">
	<g:if test="${organisationInstance.getAspaList()}">
	<span id="partnerrolle-label" class="property-label"><g:message code="organisation.partnerrolle.label" default="Ansprechpartner" /></span>
					
	<g:each in="${organisationInstance.getAspaList()}" var="p">
	<span class="property-value" aria-labelledby="partnerrolle-label"><g:link controller="person" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
	</g:each>
	</g:if>				
</div>

<div class="fieldcontain ${hasErrors(bean: organisationInstance, field: 'hausadresse', 'error')} ">
	<label for="hausadresse">
		<g:message code="organisation.hausadresse.label" default="Hausadresse" />
		
	</label>
	<g:select id="hausadresse" name="hausadresse.id" from="${org.strotmann.immos.Hausadresse.getMiniList()}" optionKey="id" value="${organisationInstance?.hausadresse?.id}" class="many-to-one" noSelection="['null': '']"/>
	<g:link controller="hausadresse" action="create" params="['organisation.id': organisationInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'hausadresse.label', default: 'Hausadresse')])}</g:link>
</div>

<div class="fieldcontain ${hasErrors(bean: organisationInstance, field: 'nameZusatz', 'error')} ">
	<label for="nameZusatz">
		<g:message code="organisation.nameZusatz.label" default="Name Zusatz" />
		
	</label>
	<g:textField name="nameZusatz" maxlength="50" pattern="${organisationInstance.constraints.nameZusatz.matches}" value="${organisationInstance?.nameZusatz}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: organisationInstance, field: 'rechtsform', 'error')} ">
	<label for="rechtsform">
		<g:message code="organisation.rechtsform.label" default="Rechtsform" />
		
	</label>
	<g:select name="rechtsform" from="${organisationInstance.constraints.rechtsform.inList}" value="${organisationInstance?.rechtsform}" valueMessagePrefix="organisation.rechtsform" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: organisationInstance, field: 'bankverbindung', 'error')} ">
	<label for="bankverbindung">
		<g:message code="organisation.bankverbindung.label" default="Bankverbindung" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${organisationInstance?.bankverbindung?}" var="b">
    <li><g:link controller="bankverbindung" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="bankverbindung" action="create" params="['organisation.id': organisationInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'bankverbindung.label', default: 'Bankverbindung')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: organisationInstance, field: 'kommunikation', 'error')} ">
	<label for="kommunikation">
		<g:message code="organisation.kommunikation.label" default="Kommunikation" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${organisationInstance?.kommunikation?}" var="k">
    <li><g:link controller="kommunikation" action="show" id="${k.id}">${k?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="kommunikation" action="create" params="['organisation.id': organisationInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'kommunikation.label', default: 'Kommunikation')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: organisationInstance, field: 'partnerrolle', 'error')} ">
	<label for="partnerrolle">
		<g:message code="organisation.partnerrolle.label" default="Partnerrolle" />
	</label>
	
<ul class="one-to-many">
<g:each in="${organisationInstance?.partnerrolle?}" var="p">
    <li><g:link controller="partnerrolle" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>

<li class="add">
<fieldset class="buttons">
	<g:select name="partnerrolleInstance.rolle" from="${flash.rollenliste}" value="${partnerrolleInstance?.rolle}" valueMessagePrefix="partnerrolle.rolle" />
	<g:actionSubmit action="toRolle" value="${message(code: 'default.button.create.label', default: 'Create')}" />
</fieldset>
</li>
</ul>
</div>

<div class="fieldcontain ${hasErrors(bean: organisationInstance, field: 'postfachadresse', 'error')} ">
	<label for="postfachadresse">
		<g:message code="organisation.postfachadresse.label" default="Postfachadresse" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${organisationInstance?.postfachadresse?}" var="p">
    <li><g:link controller="postfachadresse" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="postfachadresse" action="create" params="['organisation.id': organisationInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'postfachadresse.label', default: 'Postfachadresse')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: organisationInstance, field: 'notizen', 'error')} ">
	<label for="notizen">
		<g:message code="organisation.notizen.label" default="Notizen" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${org.strotmann.immos.Notiz.getNotizen('Organisation',organisationInstance.id)}" var="n">
    <li><g:link controller="notiz" action="show" id="${n.id}">${n}</g:link></li>
</g:each>
<li class="add">
<g:link controller="notiz" action="create" params="['organisation.id': organisationInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'notiz.label', default: 'Notiz')])}</g:link>
</li>
</ul>

</div>

