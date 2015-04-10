
<%@ page import="org.strotmann.immos.Partner" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'partner.label', default: 'Partner')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-partner" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-partner" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list partner">
			
				<g:if test="${partnerInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="partner.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${partnerInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${partnerInstance?.hausadresse}">
				<li class="fieldcontain">
					<span id="hausadresse-label" class="property-label"><g:message code="partner.hausadresse.label" default="Hausadresse" /></span>
					
						<span class="property-value" aria-labelledby="hausadresse-label"><g:link controller="hausadresse" action="show" id="${partnerInstance?.hausadresse?.id}">${partnerInstance?.hausadresse?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${partnerInstance?.bankverbindung}">
				<li class="fieldcontain">
					<span id="bankverbindung-label" class="property-label"><g:message code="partner.bankverbindung.label" default="Bankverbindung" /></span>
					
						<g:each in="${partnerInstance.bankverbindung}" var="b">
						<span class="property-value" aria-labelledby="bankverbindung-label"><g:link controller="bankverbindung" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${partnerInstance?.kommunikation}">
				<li class="fieldcontain">
					<span id="kommunikation-label" class="property-label"><g:message code="partner.kommunikation.label" default="Kommunikation" /></span>
					
						<g:each in="${partnerInstance.kommunikation}" var="k">
						<span class="property-value" aria-labelledby="kommunikation-label"><g:link controller="kommunikation" action="show" id="${k.id}">${k?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${partnerInstance?.partnerrolle}">
				<li class="fieldcontain">
					<span id="partnerrolle-label" class="property-label"><g:message code="partner.partnerrolle.label" default="Partnerrolle" /></span>
					
						<g:each in="${partnerInstance.partnerrolle}" var="p">
						<span class="property-value" aria-labelledby="partnerrolle-label"><g:link controller="partnerrolle" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${partnerInstance?.id}" />
					<g:link class="edit" action="edit" id="${partnerInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
