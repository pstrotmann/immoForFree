<%@ page import="org.strotmann.immos.Besicherung" %>



<div class="fieldcontain ${hasErrors(bean: besicherungInstance, field: 'kredit', 'error')} required">
	<label for="kredit">
		<g:message code="besicherung.kredit.label" default="Kredit" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="kredit" name="kredit.id" from="${org.strotmann.immos.Kredit.list()}" optionKey="id" required="" value="${besicherungInstance?.kredit?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: besicherungInstance, field: 'grundschuld', 'error')} required">
	<label for="grundschuld">
		<g:message code="besicherung.grundschuld.label" default="Grundschuld" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="grundschuld" name="grundschuld.id" from="${org.strotmann.immos.Grundschuld.list()}" optionKey="id" required="" value="${besicherungInstance?.grundschuld?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: besicherungInstance, field: 'betrag', 'error')} required">
	<label for="betrag">
		<g:message code="besicherung.betrag.label" default="Betrag" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="betrag" value="${fieldValue(bean: besicherungInstance, field: 'betrag')}" required=""/>

</div>

