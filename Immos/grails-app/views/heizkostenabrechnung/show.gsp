
<%@ page import="org.strotmann.immos.Heizkostenabrechnung" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'heizkostenabrechnung.label', default: 'Heizkostenabrechnung')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-heizkostenabrechnung" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-heizkostenabrechnung" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list heizkostenabrechnung">
			
				<g:if test="${heizkostenabrechnungInstance?.von}">
				<li class="fieldcontain">
					<span id="von-label" class="property-label"><g:message code="heizkostenabrechnung.von.label" default="Von" /></span>
					
						<span class="property-value" aria-labelledby="von-label"><g:formatDate date="${heizkostenabrechnungInstance?.von}" format="dd.MM.yyyy" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${heizkostenabrechnungInstance?.bis}">
				<li class="fieldcontain">
					<span id="bis-label" class="property-label"><g:message code="heizkostenabrechnung.bis.label" default="Bis" /></span>
					
						<span class="property-value" aria-labelledby="bis-label"><g:formatDate date="${heizkostenabrechnungInstance?.bis}" format="dd.MM.yyyy" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${heizkostenabrechnungInstance?.betrag}">
				<li class="fieldcontain">
					<span id="betrag-label" class="property-label"><g:message code="heizkostenabrechnung.betrag.label" default="Betrag" /></span>
					
						<span class="property-value" aria-labelledby="betrag-label"><g:fieldValue bean="${heizkostenabrechnungInstance}" field="betrag"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${heizkostenabrechnungInstance?.betriebskostenabrechnung}">
				<li class="fieldcontain">
					<span id="betriebskostenabrechnung-label" class="property-label"><g:message code="heizkostenabrechnung.betriebskostenabrechnung.label" default="Betriebskostenabrechnung" /></span>
					
						<span class="property-value" aria-labelledby="betriebskostenabrechnung-label"><g:link controller="betriebskostenabrechnung" action="show" id="${heizkostenabrechnungInstance?.betriebskostenabrechnung?.id}">${heizkostenabrechnungInstance?.betriebskostenabrechnung?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:heizkostenabrechnungInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${heizkostenabrechnungInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
