<%@ page import="org.strotmann.immos.Adresse" %>



<div class="fieldcontain ${hasErrors(bean: adresseInstance, field: 'ort', 'error')} ">
	<label for="ort">
		<g:message code="adresse.ort.label" default="Ort" />
		
	</label>
	<g:textField name="ort" value="${adresseInstance?.ort}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: adresseInstance, field: 'postleitzahl', 'error')} required">
	<label for="postleitzahl">
		<g:message code="adresse.postleitzahl.label" default="Postleitzahl" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="postleitzahl" type="number" value="${adresseInstance.postleitzahl}" required=""/>
</div>

