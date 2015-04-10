
<%@ page import="org.strotmann.immos.Umlageanteil" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'umlageanteil.label', default: 'Umlageanteil')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-umlageanteil" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-umlageanteil" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list umlageanteil">
			
				<g:if test="${umlageanteilInstance?.kostenart}">
				<li class="fieldcontain">
					<span id="kostenart-label" class="property-label"><g:message code="umlageanteil.kostenart.label" default="Kostenart" /></span>
					
						<span class="property-value" aria-labelledby="kostenart-label"><g:fieldValue bean="${umlageanteilInstance}" field="kostenart"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${umlageanteilInstance?.umlageschluessel}">
				<li class="fieldcontain">
					<span id="umlageschluessel-label" class="property-label"><g:message code="umlageanteil.umlageschluessel.label" default="Umlageschluessel" /></span>
					
						<span class="property-value" aria-labelledby="umlageschluessel-label"><g:fieldValue bean="${umlageanteilInstance}" field="umlageschluessel"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${umlageanteilInstance?.betrag}">
				<li class="fieldcontain">
					<span id="betrag-label" class="property-label"><g:message code="umlageanteil.betrag.label" default="Betrag" /></span>
					
						<span class="property-value" aria-labelledby="betrag-label"><g:fieldValue bean="${umlageanteilInstance}" field="betrag"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${umlageanteilInstance?.nebenkostenabrechnung}">
				<li class="fieldcontain">
					<span id="nebenkostenabrechnung-label" class="property-label"><g:message code="umlageanteil.nebenkostenabrechnung.label" default="Nebenkostenabrechnung" /></span>
					
						<span class="property-value" aria-labelledby="nebenkostenabrechnung-label"><g:link controller="nebenkostenabrechnung" action="show" id="${umlageanteilInstance?.nebenkostenabrechnung?.id}">${umlageanteilInstance?.nebenkostenabrechnung?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
				
				<g:if test="${umlageanteilInstance?.umlage}">
				<li class="fieldcontain">
					<span id="umlage-label" class="property-label"><g:message code="umlageanteil.umlage.label" default="Umlage" /></span>
					
						<span class="property-value" aria-labelledby="umlage-label"><g:link controller="umlage" action="show" id="${umlageanteilInstance?.umlage?.id}">${umlageanteilInstance?.umlage?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:umlageanteilInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${umlageanteilInstance?.id}" />
					<g:link class="edit" action="edit" id="${umlageanteilInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
