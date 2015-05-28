<%@ page import="org.strotmann.immos.Zaehlerstand" %>



<div class="fieldcontain ${hasErrors(bean: zaehlerstandInstance, field: 'ablesedatum', 'error')} required">
	<label for="ablesedatum">
		<g:message code="zaehlerstand.ablesedatum.label" default="Ablesedatum" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="ablesedatum" precision="day"  value="${zaehlerstandInstance?.ablesedatum}" years="${2011..2025}" />
</div>

<div class="fieldcontain ${hasErrors(bean: zaehlerstandInstance, field: 'wert', 'error')} required">
	<label for="wert">
		<g:message code="zaehlerstand.wert.label" default="Wert" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="wert" value="${fieldValue(bean: zaehlerstandInstance, field: 'wert')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: zaehlerstandInstance, field: 'z', 'error')} required">
	<label for="z">
		<g:message code="zaehlerstand.z.label" default="Zähler" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="z" name="z.id" from="${flash.zaehler}" optionKey="id" required="" value="${zaehlerstandInstance?.z?.id}" class="many-to-one"/>
</div>

