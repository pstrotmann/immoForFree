<%@ page import="org.strotmann.immos.Postfachadresse" %>



<div class="fieldcontain ${hasErrors(bean: postfachadresseInstance, field: 'postfach', 'error')} required">
	<label for="postfach">
		<g:message code="postfachadresse.postfach.label" default="Postfach" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="postfach" type="number" value="${postfachadresseInstance.postfach}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: postfachadresseInstance, field: 'postleitzahl', 'error')} required">
	<label for="postleitzahl">
		<g:message code="postfachadresse.postleitzahl.label" default="Postleitzahl" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="postleitzahl" type="number" min="1000" max="99999" value="${postfachadresseInstance.postleitzahl}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: postfachadresseInstance, field: 'ort', 'error')} required">
	<label for="ort">
		<g:message code="postfachadresse.ort.label" default="Ort" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="ort" required="" value="${postfachadresseInstance?.ort}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: postfachadresseInstance, field: 'organisation', 'error')} required">
	<label for="organisation">
		<g:message code="postfachadresse.organisation.label" default="Organisation" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="organisation" name="organisation.id" from="${flash.partner}" optionKey="id" required="" value="${postfachadresseInstance?.organisation?.id}" class="many-to-one"/>
</div>

