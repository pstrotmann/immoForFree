
<%@ page import="org.strotmann.immos.Nebenkostenabrechnung" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'nebenkostenabrechnung.label', default: 'Nebenkostenabrechnung')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-nebenkostenabrechnung" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-nebenkostenabrechnung" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list nebenkostenabrechnung">
			
				<g:if test="${nebenkostenabrechnungInstance?.betriebskostenabrechnung}">
				<li class="fieldcontain">
					<span id="betriebskostenabrechnung-label" class="property-label"><g:message code="nebenkostenabrechnung.betriebskostenabrechnung.label" default="Betriebskostenabrechnung" /></span>
					
						<span class="property-value" aria-labelledby="betriebskostenabrechnung-label"><g:link controller="betriebskostenabrechnung" action="show" id="${nebenkostenabrechnungInstance?.betriebskostenabrechnung?.id}">${nebenkostenabrechnungInstance?.betriebskostenabrechnung?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${nebenkostenabrechnungInstance?.umlageanteile}">
				<li class="fieldcontain">
					<span id="umlageanteile-label" class="property-label"><g:message code="nebenkostenabrechnung.umlageanteile.label" default="Umlageanteile" /></span>
					
						<g:each in="${nebenkostenabrechnungInstance.umlageanteile}" var="u">
						<span class="property-value" aria-labelledby="umlageanteile-label"><g:link controller="umlageanteil" action="show" id="${u.id}">${u?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:nebenkostenabrechnungInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${nebenkostenabrechnungInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
