<%@ page import="org.strotmann.immos.Partner" %>



<div class="fieldcontain ${hasErrors(bean: partnerInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="partner.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${partnerInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: partnerInstance, field: 'hausadresse', 'error')} ">
	<label for="hausadresse">
		<g:message code="partner.hausadresse.label" default="Hausadresse" />
		
	</label>
	<g:select id="hausadresse" name="hausadresse.id" from="${org.strotmann.immos.Hausadresse.getMinilist()}" optionKey="id" value="${partnerInstance?.hausadresse?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: partnerInstance, field: 'bankverbindung', 'error')} ">
	<label for="bankverbindung">
		<g:message code="partner.bankverbindung.label" default="Bankverbindung" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${partnerInstance?.bankverbindung?}" var="b">
    <li><g:link controller="bankverbindung" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="bankverbindung" action="create" params="['partner.id': partnerInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'bankverbindung.label', default: 'Bankverbindung')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: partnerInstance, field: 'kommunikation', 'error')} ">
	<label for="kommunikation">
		<g:message code="partner.kommunikation.label" default="Kommunikation" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${partnerInstance?.kommunikation?}" var="k">
    <li><g:link controller="kommunikation" action="show" id="${k.id}">${k?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="kommunikation" action="create" params="['partner.id': partnerInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'kommunikation.label', default: 'Kommunikation')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: partnerInstance, field: 'partnerrolle', 'error')} ">
	<label for="partnerrolle">
		<g:message code="partner.partnerrolle.label" default="Partnerrolle" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${partnerInstance?.partnerrolle?}" var="p">
    <li><g:link controller="partnerrolle" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="partnerrolle" action="create" params="['partner.id': partnerInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'partnerrolle.label', default: 'Partnerrolle')])}</g:link>
</li>
</ul>

</div>

