<%@ page import="org.strotmann.immos.Person" %>



<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="person.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="30" pattern="${personInstance.constraints.name.matches}" required="" value="${personInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'hausadresse', 'error')} ">
	<label for="hausadresse">
		<g:message code="person.hausadresse.label" default="Hausadresse" />
		
	</label>
	<g:select id="hausadresse" name="hausadresse.id" from="${org.strotmann.immos.Hausadresse.getMiniList()}" optionKey="id" value="${personInstance?.hausadresse?.id}" class="many-to-one" noSelection="['null': '']"/>
	<g:link controller="hausadresse" action="create" params="['person.id': personInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'hausadresse.label', default: 'Hausadresse')])}</g:link>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'titel', 'error')} ">
	<label for="titel">
		<g:message code="person.titel.label" default="Titel" />
		
	</label>
	<g:textField name="titel" maxlength="20" pattern="${personInstance.constraints.titel.matches}" value="${personInstance?.titel}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'vorname', 'error')} ">
	<label for="vorname">
		<g:message code="person.vorname.label" default="Vorname" />
		
	</label>
	<g:textField name="vorname" maxlength="30" pattern="${personInstance.constraints.vorname.matches}" value="${personInstance?.vorname}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'geschlecht', 'error')} ">
	<label for="geschlecht">
		<g:message code="person.geschlecht.label" default="Geschlecht" />
		
	</label>
	<g:select name="geschlecht" from="${personInstance.constraints.geschlecht.inList}" value="${personInstance?.geschlecht}" valueMessagePrefix="person.geschlecht" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'geburtsdatum', 'error')} ">
	<label for="geburtsdatum">
		<g:message code="person.geburtsdatum.label" default="Geburtsdatum" />
		
	</label>
	<g:datePicker name="geburtsdatum" precision="day" years="${new Date().getYear()+1800..new Date().getYear() + 1900}" value="${personInstance?.geburtsdatum}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'persoenlicheAnrede', 'error')} ">
	<label for="persoenlicheAnrede">
		<g:message code="person.persoenlicheAnrede.label" default="persönliche Anrede" />
		
	</label>
	<g:checkBox name="persoenlicheAnrede" value="${personInstance?.persoenlicheAnrede}" />
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'bankverbindung', 'error')} ">
	<label for="bankverbindung">
		<g:message code="person.bankverbindung.label" default="Bankverbindung" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${personInstance?.bankverbindung?}" var="b">
    <li><g:link controller="bankverbindung" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="bankverbindung" action="create" params="['person.id': personInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'bankverbindung.label', default: 'Bankverbindung')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'kommunikation', 'error')} ">
	<label for="kommunikation">
		<g:message code="person.kommunikation.label" default="Kommunikation" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${personInstance?.kommunikation?}" var="k">
    <li><g:link controller="kommunikation" action="show" id="${k.id}">${k?.encodeAsHTML()}</g:link></li>
</g:each>

<li class="add">
<g:link controller="kommunikation" action="create" params="['person.id': personInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'kommunikation.label', default: 'Kommunikation')])}</g:link>
</li>

</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'partnerrolle', 'error')} ">
	<label for="partnerrolle">
		<g:message code="person.partnerrolle.label" default="Partnerrolle" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${personInstance?.partnerrolle?}" var="p">
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

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'notizen', 'error')} ">
	<label for="notizen">
		<g:message code="person.notizen.label" default="Notizen" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${org.strotmann.immos.Notiz.getNotizen('Person',personInstance.id)}" var="n">
    <li><g:link controller="notiz" action="show" id="${n.id}">${n}</g:link></li>
</g:each>
<li class="add">
<g:link controller="notiz" action="create" params="['person.id': personInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'notiz.label', default: 'Notiz')])}</g:link>
</li>
</ul>

</div>
