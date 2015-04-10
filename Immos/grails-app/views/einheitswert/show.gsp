
<%@ page import="org.strotmann.immos.Einheitswert" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'einheitswert.label', default: 'Einheitswert')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-einheitswert" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-einheitswert" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list einheitswert">
			
				<g:if test="${einheitswertInstance?.ewNummer}">
				<li class="fieldcontain">
					<span id="ewNummer-label" class="property-label"><g:message code="einheitswert.ewNummer.label" default="Ew Nummer" /></span>
					
						<span class="property-value" aria-labelledby="ewNummer-label"><g:fieldValue bean="${einheitswertInstance}" field="ewNummer"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${einheitswertInstance?.gueltigAb}">
				<li class="fieldcontain">
					<span id="gueltigAb-label" class="property-label"><g:message code="einheitswert.gueltigAb.label" default="Gueltig Ab" /></span>
					
						<span class="property-value" aria-labelledby="gueltigAb-label"><g:formatDate date="${einheitswertInstance?.gueltigAb}" format="dd.MM.yyyy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${einheitswertInstance?.wert}">
				<li class="fieldcontain">
					<span id="wert-label" class="property-label"><g:message code="einheitswert.wert.label" default="Wert" /></span>
					
						<span class="property-value" aria-labelledby="wert-label"><g:fieldValue bean="${einheitswertInstance}" field="wert"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${einheitswertInstance?.immobilie}">
				<li class="fieldcontain">
					<span id="immobilie-label" class="property-label"><g:message code="einheitswert.immobilie.label" default="Immobilie" /></span>
					
						<span class="property-value" aria-labelledby="immobilie-label"><g:link controller="immobilie" action="show" id="${einheitswertInstance?.immobilie?.id}">${einheitswertInstance?.immobilie?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${einheitswertInstance?.id}" />
					<g:link class="edit" action="edit" id="${einheitswertInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
