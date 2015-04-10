

<%@ page import="org.strotmann.immos.User" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="user.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${flash.name?:''}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'passwort', 'error')} ">
	<label for="passwort">
		<g:message code="user.passwort.label" default="Passwort" />
		
	</label>
	<g:passwordField name="passwort" value="${userInstance?.passwort}"/>
</div>

