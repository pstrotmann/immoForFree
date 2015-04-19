<%@ page import="org.strotmann.immos.Kostenart" %>



<div class="fieldcontain ${hasErrors(bean: kostenartInstance, field: 'bezeichnung', 'error')} required">
	<label for="bezeichnung">
		<g:message code="kostenart.bezeichnung.label" default="Bezeichnung" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="bezeichnung" required="" value="${kostenartInstance?.bezeichnung}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: kostenartInstance, field: 'kommunal', 'error')} ">
	<label for="kommunal">
		<g:message code="kostenart.kommunal.label" default="Kommunal" />
		
	</label>
	<g:checkBox name="kommunal" value="${kostenartInstance?.kommunal}" />

</div>

