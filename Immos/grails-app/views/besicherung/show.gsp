
<%@ page import="org.strotmann.immos.Besicherung" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'besicherung.label', default: 'Besicherung')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-besicherung" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-besicherung" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list besicherung">
			
				<g:if test="${besicherungInstance?.kredit}">
				<li class="fieldcontain">
					<span id="kredit-label" class="property-label"><g:message code="besicherung.kredit.label" default="Kredit" /></span>
					
						<span class="property-value" aria-labelledby="kredit-label"><g:link controller="kredit" action="show" id="${besicherungInstance?.kredit?.id}">${besicherungInstance?.kredit?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${besicherungInstance?.grundschuld}">
				<li class="fieldcontain">
					<span id="grundschuld-label" class="property-label"><g:message code="besicherung.grundschuld.label" default="Grundschuld" /></span>
					
						<span class="property-value" aria-labelledby="grundschuld-label"><g:link controller="grundschuld" action="show" id="${besicherungInstance?.grundschuld?.id}">${besicherungInstance?.grundschuld?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${besicherungInstance?.betrag}">
				<li class="fieldcontain">
					<span id="betrag-label" class="property-label"><g:message code="besicherung.betrag.label" default="Betrag" /></span>
					
						<span class="property-value" aria-labelledby="betrag-label"><g:fieldValue bean="${besicherungInstance}" field="betrag"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:besicherungInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${besicherungInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
