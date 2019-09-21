
<%@ page import="org.strotmann.immos.Grundschuld" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'grundschuld.label', default: 'Grundschuld')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-grundschuld" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-grundschuld" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list grundschuld">
			
				<g:if test="${grundschuldInstance?.eintragAm}">
				<li class="fieldcontain">
					<span id="eintragAm-label" class="property-label"><g:message code="grundschuld.eintragAm.label" default="Eintrag Am" /></span>
					
						<span class="property-value" aria-labelledby="eintragAm-label"><g:formatDate date="${grundschuldInstance?.eintragAm}" format="dd.MM.yyyy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${grundschuldInstance?.loeschungAm}">
				<li class="fieldcontain">
					<span id="loeschungAm-label" class="property-label"><g:message code="grundschuld.loeschungAm.label" default="Loeschung Am" /></span>
					
						<span class="property-value" aria-labelledby="loeschungAm-label"><g:formatDate date="${grundschuldInstance?.loeschungAm}" format="dd.MM.yyyy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${grundschuldInstance?.betrag}">
				<li class="fieldcontain">
					<span id="betrag-label" class="property-label"><g:message code="grundschuld.betrag.label" default="Betrag" /></span>
					
						<span class="property-value" aria-labelledby="betrag-label"><g:fieldValue bean="${grundschuldInstance}" field="betrag"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${grundschuldInstance?.rang}">
				<li class="fieldcontain">
					<span id="rang-label" class="property-label"><g:message code="grundschuld.rang.label" default="Rang" /></span>
					
						<span class="property-value" aria-labelledby="rang-label"><g:fieldValue bean="${grundschuldInstance}" field="rang"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${grundschuldInstance?.glaeubiger}">
				<li class="fieldcontain">
					<span id="glaeubiger-label" class="property-label"><g:message code="grundschuld.glaeubiger.label" default="Glaeubiger" /></span>
					
						<span class="property-value" aria-labelledby="glaeubiger-label"><g:link controller="organisation" action="show" id="${grundschuldInstance?.glaeubiger?.id}">${grundschuldInstance?.glaeubiger?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${grundschuldInstance?.immobilie}">
				<li class="fieldcontain">
					<span id="immobilie-label" class="property-label"><g:message code="grundschuld.immobilie.label" default="Immobilie" /></span>
					
						<span class="property-value" aria-labelledby="immobilie-label"><g:link controller="immobilie" action="show" id="${grundschuldInstance?.immobilie?.id}">${grundschuldInstance?.immobilie?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
				
				<g:if test="${grundschuldInstance?.besicherungen}">
				<li class="fieldcontain">
					<span id="besicherungen-label" class="property-label"><g:message code="grundschuld.besicherungen.label" default="Besicherungen" /></span>
					
						<g:each in="${grundschuldInstance.besicherungen}" var="b">
						
							<span class="property-value" aria-labelledby="besicherungen-label"><g:link controller="besicherung" action="show" id="${b.id}">${b?.btrString.encodeAsHTML()}</g:link></span>
						
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${grundschuldInstance?.id}" />
					<g:link class="edit" action="edit" id="${grundschuldInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
