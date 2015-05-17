<%@ page import="org.strotmann.immos.Zwischenzaehlerstand" %>
<%@ page import="org.strotmann.immos.Umlageinfo" %>

<div class="fieldcontain ${hasErrors(bean: zwischenzaehlerstandInstance, field: 'ablesedatum', 'error')} required">
	<label for="ablesedatum">
		<g:message code="zwischenzaehlerstand.ablesedatum.label" default="Ablesedatum" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="ablesedatum" precision="day"  value="${zwischenzaehlerstandInstance?.ablesedatum?:Umlageinfo.endeVorjahr}" years="${2011..2025}" />
</div>

<div class="fieldcontain ${hasErrors(bean: zwischenzaehlerstandInstance, field: 'wert', 'error')} required">
	<label for="wert">
		<g:message code="zwischenzaehlerstand.wert.label" default="Wert" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="wert" value="${fieldValue(bean: zwischenzaehlerstandInstance, field: 'wert')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: zwischenzaehlerstandInstance, field: 'zz', 'error')} required">
	<label for="zz">
		<g:message code="zwischenzaehlerstand.zz.label" default="Zwischenzähler" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="zz" name="zz.id" from="${flash.zwischenzaehler}" optionKey="id" required="" value="${zwischenzaehlerstandInstance?.zz?.id}" class="many-to-one"/>
</div>

