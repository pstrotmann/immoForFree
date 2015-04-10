<%@ page import="org.strotmann.immos.Bank" %>

<div class="fieldcontain ${hasErrors(bean: bankInstance, field: 'bic', 'error')} ">
	<label for="bic">
		<g:message code="bank.bic.label" default="Bic" />
		
	</label>
	<g:textField name="bic"  value="${bankInstance?.bic}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: bankInstance, field: 'blz', 'error')} ">
	<label for="blz">
		<g:message code="bank.blz.label" default="Blz" />
		
	</label>
	<g:field name="blz" type="number" value="${bankInstance.blz}" />

</div>

<div class="fieldcontain ${hasErrors(bean: bankInstance, field: 'bankname', 'error')} ">
	<label for="bankname">
		<g:message code="bank.bankname.label" default="Bankname" />
		
	</label>
	<g:textField name="bankname"  value="${bankInstance?.bankname}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: bankInstance, field: 'plz', 'error')} ">
	<label for="plz">
		<g:message code="bank.plz.label" default="Plz" />
		
	</label>
	<g:field name="plz" type="number" value="${bankInstance.plz}" />

</div>

<div class="fieldcontain ${hasErrors(bean: bankInstance, field: 'ort', 'error')} ">
	<label for="ort">
		<g:message code="bank.ort.label" default="Ort" />
		
	</label>
	<g:textField name="ort"  value="${bankInstance?.ort}"/>

</div>

