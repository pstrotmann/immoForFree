
<%@ page import="org.strotmann.immos.Partnerrolle" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'partnerrolle.label', default: 'Partnerrolle')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-partnerrolle" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-partnerrolle" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list partnerrolle">
			
				<g:if test="${partnerrolleInstance?.partner}">
				<li class="fieldcontain">
					<span id="partner-label" class="property-label"><g:message code="partnerrolle.partner.label" default="Partner" /></span>
					
						<span class="property-value" aria-labelledby="partner-label">
						<g:if test="${partnerrolleInstance?.partner instanceof org.strotmann.immos.Person}">
							<g:link controller="person" action="show" id="${partnerrolleInstance?.partner?.id}">${partnerrolleInstance?.partner?.encodeAsHTML()}</g:link>
						</g:if>
						<g:if test="${partnerrolleInstance?.partner instanceof org.strotmann.immos.Organisation}">
							<g:link controller="organisation" action="show" id="${partnerrolleInstance?.partner?.id}">${partnerrolleInstance?.partner?.encodeAsHTML()}</g:link>
						</g:if>
						
					</span>
					
				</li>
				</g:if>
			
				<g:if test="${partnerrolleInstance?.rolle}">
				<li class="fieldcontain">
					<span id="rolle-label" class="property-label"><g:message code="partnerrolle.rolle.label" default="Rolle" /></span>
					
						<span class="property-value" aria-labelledby="rolle-label"><g:fieldValue bean="${partnerrolleInstance}" field="rolle"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${partnerrolleInstance?.mietvertrag}">
				<li class="fieldcontain">
					<span id="mietvertrag-label" class="property-label"><g:message code="partnerrolle.mietvertrag.label" default="Mietvertrag" /></span>
					
						<span class="property-value" aria-labelledby="mietvertrag-label"><g:link controller="mietvertrag" action="show" id="${partnerrolleInstance?.mietvertrag?.id}">${partnerrolleInstance?.mietvertrag?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${partnerrolleInstance?.kredit}">
				<li class="fieldcontain">
					<span id="kredit-label" class="property-label"><g:message code="partnerrolle.kredit.label" default="Kredit" /></span>
					
						<span class="property-value" aria-labelledby="kredit-label"><g:link controller="kredit" action="show" id="${partnerrolleInstance?.kredit?.id}">${partnerrolleInstance?.kredit?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${partnerrolleInstance?.dienstleistungsvertrag}">
				<li class="fieldcontain">
					<span id="dienstleistungsvertrag-label" class="property-label"><g:message code="partnerrolle.dienstleistungsvertrag.label" default="Dienstleistungsvertrag" /></span>
					
						<span class="property-value" aria-labelledby="dienstleistungsvertrag-label"><g:link controller="dienstleistungsvertrag" action="show" id="${partnerrolleInstance?.dienstleistungsvertrag?.id}">${partnerrolleInstance?.dienstleistungsvertrag?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${partnerrolleInstance?.rechnung}">
				<li class="fieldcontain">
					<span id="rechnung-label" class="property-label"><g:message code="partnerrolle.rechnung.label" default="Rechnung" /></span>
					
						<span class="property-value" aria-labelledby="rechnung-label"><g:link controller="rechnung" action="show" id="${partnerrolleInstance?.rechnung?.id}">${partnerrolleInstance?.rechnung?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${partnerrolleInstance?.organisation}">
				<li class="fieldcontain">
					<span id="organisation-label" class="property-label"><g:message code="partnerrolle.organisation.label" default="Organisation" /></span>
					
						<span class="property-value" aria-labelledby="organisation-label"><g:link controller="organisation" action="show" id="${partnerrolleInstance?.organisation?.id}">${partnerrolleInstance?.organisation?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:partnerrolleInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${partnerrolleInstance?.id}" />
					<g:link class="edit" action="edit" id="${partnerrolleInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit method="delete" class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
