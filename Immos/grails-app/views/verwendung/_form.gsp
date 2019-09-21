<%@ page import="org.strotmann.immos.Verwendung" %>



<div class="fieldcontain ${hasErrors(bean: verwendungInstance, field: 'kredit', 'error')} required">
	<label for="kredit">
		<g:message code="verwendung.kredit.label" default="Kredit" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="kredit" name="kredit.id" from="${org.strotmann.immos.Kredit.list()}" optionKey="id" required="" value="${verwendungInstance?.kredit?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: verwendungInstance, field: 'immobilie', 'error')} required">
	<label for="immobilie">
		<g:message code="verwendung.immobilie.label" default="Immobilie" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="immobilie" name="immobilie.id" from="${org.strotmann.immos.Immobilie.list()}" optionKey="id" required="" value="${verwendungInstance?.immobilie?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: verwendungInstance, field: 'betrag', 'error')} required">
	<label for="betrag">
		<g:message code="verwendung.betrag.label" default="Betrag" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="betrag" value="${fieldValue(bean: verwendungInstance, field: 'betrag')}" required=""/>

</div>

