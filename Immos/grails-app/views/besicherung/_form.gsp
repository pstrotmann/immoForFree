<%@ page import="org.strotmann.immos.Besicherung" %>
<%@ page import="org.strotmann.immos.Kredit" %>
<%@ page import="org.strotmann.immos.Grundschuld" %>

<div class="fieldcontain ${hasErrors(bean: besicherungInstance, field: 'kredit', 'error')} required">
	<label for="kredit">
		<g:message code="besicherung.kredit.label" default="Kredit" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="kredit" name="kredit.id" from="${Kredit.aktiveKredite}" optionKey="id" required="" value="${besicherungInstance?.kredit?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: besicherungInstance, field: 'grundschuld', 'error')} required">
	<label for="grundschuld">
		<g:message code="besicherung.grundschuld.label" default="Grundschuld" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="grundschuld" name="grundschuld.id" from="${Grundschuld.grundschuldList}" optionKey="id" required="" value="${besicherungInstance?.grundschuld?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: besicherungInstance, field: 'betrag', 'error')} required">
	<label for="betrag">
		<g:message code="besicherung.betrag.label" default="Betrag" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="betrag" value="${fieldValue(bean: besicherungInstance, field: 'betrag')}" required=""/>

</div>

