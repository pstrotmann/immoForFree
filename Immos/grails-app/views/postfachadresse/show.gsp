
<%@ page import="org.strotmann.immos.Postfachadresse" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'postfachadresse.label', default: 'Postfachadresse')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-postfachadresse" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-postfachadresse" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list postfachadresse">
			
				<g:if test="${postfachadresseInstance?.postfach}">
				<li class="fieldcontain">
					<span id="postfach-label" class="property-label"><g:message code="postfachadresse.postfach.label" default="Postfach" /></span>
					
						<span class="property-value" aria-labelledby="postfach-label"><g:fieldValue bean="${postfachadresseInstance}" field="postfach"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${postfachadresseInstance?.postleitzahl}">
				<li class="fieldcontain">
					<span id="postleitzahl-label" class="property-label"><g:message code="postfachadresse.postleitzahl.label" default="Postleitzahl" /></span>
					
						<span class="property-value" aria-labelledby="postleitzahl-label"><g:fieldValue bean="${postfachadresseInstance}" field="postleitzahl"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${postfachadresseInstance?.ort}">
				<li class="fieldcontain">
					<span id="ort-label" class="property-label"><g:message code="postfachadresse.ort.label" default="Ort" /></span>
					
						<span class="property-value" aria-labelledby="ort-label"><g:fieldValue bean="${postfachadresseInstance}" field="ort"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${postfachadresseInstance?.organisation}">
				<li class="fieldcontain">
					<span id="organisation-label" class="property-label"><g:message code="postfachadresse.organisation.label" default="Organisation" /></span>						
						<span class="property-value" aria-labelledby="organisation-label">
							<g:link controller="organisation" action="show" id="${postfachadresseInstance?.organisation?.id}">${postfachadresseInstance?.organisation?.encodeAsHTML()}</g:link>
						</span>
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${postfachadresseInstance?.id}" />
					<g:link class="edit" action="edit" id="${postfachadresseInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
