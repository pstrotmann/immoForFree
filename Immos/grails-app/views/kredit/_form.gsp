<%@ page import="org.strotmann.immos.Kredit" %>



<div class="fieldcontain ${hasErrors(bean: kreditInstance, field: 'kreditgeber', 'error')} required">
	<label for="kreditgeber">
		<g:message code="kredit.kreditgeber.label" default="Kreditgeber" />
		<span class="required-indicator">*</span>
	</label>
	<g:if test="${flash.partner}">
		<g:fieldValue bean="${flash.partner}" field="name" />
	</g:if>
	<g:if test="${kreditInstance?.kreditgeber}">
		<g:fieldValue bean="${kreditInstance?.kreditgeber?.partner}" field="name" />
	</g:if>
	<g:if test="${!flash.partner && !kreditInstance?.kreditgeber}">
		<g:select id="partner" name="partner.id" from="${org.strotmann.immos.Kredit.getKreditgeberList()}" optionKey="id" required="" value="${kreditInstance?.kreditgeber?.id}" class="many-to-one"/>
	</g:if>
</div>

<div class="fieldcontain ${hasErrors(bean: kreditInstance, field: 'verwendung', 'error')} required">
	<label for="verwendung">
		<g:message code="kredit.verwendung.label" default="Verwendung" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="verwendung" name="verwendung.id" from="${org.strotmann.immos.Immobilie.list()}" optionKey="id" required="" value="${kreditInstance?.verwendung?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: kreditInstance, field: 'grundschuld', 'error')} required">
	<label for="grundschuld">
		<g:message code="kredit.grundschuld.label" default="Grundschuld" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="grundschuld" name="grundschuld.id" from="${org.strotmann.immos.Grundschuld.list()}" optionKey="id" required="" value="${kreditInstance?.grundschuld?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: kreditInstance, field: 'vertragsnummer', 'error')} ">
	<label for="vertragsnummer">
		<g:message code="kredit.vertragsnummer.label" default="Vertragsnummer" />
		
	</label>
	<g:textField name="vertragsnummer" value="${kreditInstance?.vertragsnummer}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: kreditInstance, field: 'betrag', 'error')} ">
	<label for="bewilligt">
		<g:message code="kredit.betrag.label" default="bewilligtes Darlehen" />
	</label>
	<g:field name="betrag" value="${fieldValue(bean: kreditInstance, field: 'betrag')}" />
</div>

<div class="fieldcontain ${hasErrors(bean: kreditInstance, field: 'zahlweise', 'error')} required">
	<label for="zahlweise">
		<g:message code="kredit.zahlweise.label" default="Zahlweise" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="zahlweise" from="${kreditInstance.constraints.zahlweise.inList}" value="${kreditInstance?.zahlweise}" valueMessagePrefix="zahlweise.category" />
</div>

<div class="fieldcontain ${hasErrors(bean: kreditInstance, field: 'kreditstaende', 'error')} ">
	<label for="kreditstaende">
		<g:message code="kredit.kreditstaende.label" default="Kreditstaende" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${kreditInstance?.kreditstaende?}" var="k">
    <li><g:link controller="kreditstand" action="show" id="${k.id}">${k?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="kreditstand" action="create" params="['kredit.id': kreditInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'kreditstand.label', default: 'Kreditstand')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: kreditInstance, field: 'zahlungen', 'error')} ">
	<label for="zahlungen">
		<g:message code="kredit.zahlungen.label" default="Zahlungen" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${kreditInstance?.zahlungen?}" var="z">
    <li><g:link controller="zahlung" action="show" id="${z.id}">${z?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="zahlung" action="create" params="['kredit.id': kreditInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'zahlung.label', default: 'Zahlung')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: immobilieInstance, field: 'notizen', 'error')} ">
	<label for="notizen">
		<g:message code="kredit.notizen.label" default="Notizen" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${org.strotmann.immos.Notiz.getNotizen('Kredit',kreditInstance.id)}" var="n">
    <li><g:link controller="notiz" action="show" id="${n.id}">${n}</g:link></li>
</g:each>
<li class="add">
<g:link controller="notiz" action="create" params="['kredit.id': kreditInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'notiz.label', default: 'Notiz')])}</g:link>
</li>
</ul>

</div>
