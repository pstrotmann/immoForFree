
<%@ page import="org.strotmann.immos.Termin" %>
<%@ page import="org.strotmann.util.Datum" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'termin.label', default: 'Termin')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-termin" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-termin" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list termin">
			
				<g:if test="${terminInstance?.vorlage}">
				<li class="fieldcontain">
					<span id="vorlage-label" class="property-label"><g:message code="termin.vorlage.label" default="Vorlage" /></span>
					
						<span class="property-value" aria-labelledby="vorlage-label">
							<g:if test="${terminInstance.vorlage.hours == 0}">
								<g:formatDate date="${terminInstance.vorlage}" format="dd.MM.yyyy"/>
							</g:if>
							<g:elseif test="true">
								<g:formatDate date="${terminInstance.vorlage}" format="dd.MM.yyyy hh:mm" />
							</g:elseif>
						</span>
					
				</li>
				</g:if>
				
				<g:if test="${terminInstance?.grund}">
				<li class="fieldcontain">
					<span id="grund-label" class="property-label"><g:message code="termin.grund.label" default="Grund" /></span>
						<g:if test="${terminInstance.vorlage <= Datum.plusTage (new Date(), 1) && !terminInstance.erledigung}">
							<span style="color:red;" class="property-value" aria-labelledby="grund-label"><g:fieldValue bean="${terminInstance}" field="grund"/></span>
						</g:if>
						<g:elseif test="true">
							<span class="property-value" aria-labelledby="grund-label"><g:fieldValue bean="${terminInstance}" field="grund"/></span>
						</g:elseif>
					
				</li>
				</g:if>
				
				<g:if test="${terminInstance?.erledigung}">
				<li class="fieldcontain">
					<span id="erledigung-label" class="property-label"><g:message code="termin.erledigung.label" default="Erledigung" /></span>
					
						<span class="property-value" aria-labelledby="erledigung-label"><g:formatDate date="${terminInstance?.erledigung}" format="dd.MM.yyyy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${terminInstance?.organisation}">
				<li class="fieldcontain">
					<span id="organisation-label" class="property-label"><g:message code="termin.organisation.label" default="Organisation" /></span>
					
						<span class="property-value" aria-labelledby="organisation-label"><g:link controller="organisation" action="show" id="${terminInstance?.organisation?.id}">${terminInstance?.organisation?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${terminInstance?.person}">
				<li class="fieldcontain">
					<span id="person-label" class="property-label"><g:message code="termin.person.label" default="Person" /></span>
					
						<span class="property-value" aria-labelledby="person-label"><g:link controller="person" action="show" id="${terminInstance?.person?.id}">${terminInstance?.person?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${terminInstance?.immobilie}">
				<li class="fieldcontain">
					<span id="immobilie-label" class="property-label"><g:message code="termin.immobilie.label" default="Immobilie" /></span>
					
						<span class="property-value" aria-labelledby="immobilie-label"><g:link controller="immobilie" action="show" id="${terminInstance?.immobilie?.id}">${terminInstance?.immobilie?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${terminInstance?.grundschuld}">
				<li class="fieldcontain">
					<span id="grundschuld-label" class="property-label"><g:message code="termin.grundschuld.label" default="Grundschuld" /></span>
					
						<span class="property-value" aria-labelledby="grundschuld-label"><g:link controller="grundschuld" action="show" id="${terminInstance?.grundschuld?.id}">${terminInstance?.grundschuld?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${terminInstance?.mietvertrag}">
				<li class="fieldcontain">
					<span id="mietvertrag-label" class="property-label"><g:message code="termin.mietvertrag.label" default="Mietvertrag" /></span>
					
						<span class="property-value" aria-labelledby="mietvertrag-label"><g:link controller="mietvertrag" action="show" id="${terminInstance?.mietvertrag?.id}">${terminInstance?.mietvertrag?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${terminInstance?.kredit}">
				<li class="fieldcontain">
					<span id="kredit-label" class="property-label"><g:message code="termin.kredit.label" default="Kredit" /></span>
					
						<span class="property-value" aria-labelledby="kredit-label"><g:link controller="kredit" action="show" id="${terminInstance?.kredit?.id}">${terminInstance?.kredit?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${terminInstance?.dienstleistungsvertrag}">
				<li class="fieldcontain">
					<span id="dienstleistungsvertrag-label" class="property-label"><g:message code="termin.dienstleistungsvertrag.label" default="Dienstleistungsvertrag" /></span>
					
						<span class="property-value" aria-labelledby="dienstleistungsvertrag-label"><g:link controller="dienstleistungsvertrag" action="show" id="${terminInstance?.dienstleistungsvertrag?.id}">${terminInstance?.dienstleistungsvertrag?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${terminInstance?.rechnung}">
				<li class="fieldcontain">
					<span id="rechnung-label" class="property-label"><g:message code="termin.rechnung.label" default="Rechnung" /></span>
					
						<span class="property-value" aria-labelledby="rechnung-label"><g:link controller="rechnung" action="show" id="${terminInstance?.rechnung?.id}">${terminInstance?.rechnung?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
											
			</ol>
			<g:form url="[resource:terminInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${terminInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
