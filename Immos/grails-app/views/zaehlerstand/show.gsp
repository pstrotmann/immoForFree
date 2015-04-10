
<%@ page import="org.strotmann.immos.Zaehlerstand" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'zaehlerstand.label', default: 'Zählerstand')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-zaehlerstand" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-zaehlerstand" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list zaehlerstand">
			
				<g:if test="${zaehlerstandInstance?.ablesedatum}">
				<li class="fieldcontain">
					<span id="ablesedatum-label" class="property-label"><g:message code="zaehlerstand.ablesedatum.label" default="Ablesedatum" /></span>
					
						<span class="property-value" aria-labelledby="ablesedatum-label"><g:formatDate date="${zaehlerstandInstance?.ablesedatum}" format="dd.MM.yyyy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${zaehlerstandInstance?.wert}">
				<li class="fieldcontain">
					<span id="wert-label" class="property-label"><g:message code="zaehlerstand.wert.label" default="Wert" /></span>
					
						<span class="property-value" aria-labelledby="wert-label"><g:formatNumber number="${zaehlerstandInstance?.wert}" type="number" minFractionDigits="3" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${zaehlerstandInstance?.z}">
				<li class="fieldcontain">
					<span id="z-label" class="property-label"><g:message code="zaehlerstand.z.label" default="Zähler" /></span>
					
						<span class="property-value" aria-labelledby="z-label"><g:link controller="zaehler" action="show" id="${zaehlerstandInstance?.z?.id}">${zaehlerstandInstance?.z?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${zaehlerstandInstance?.id}" />
					<g:link class="edit" action="edit" id="${zaehlerstandInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
