
<%@ page import="org.strotmann.immos.Zahlung" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'zahlung.label', default: 'Zahlung')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-zahlung" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-zahlung" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list zahlung">
			
				<g:if test="${zahlungInstance?.datum}">
				<li class="fieldcontain">
					<span id="datum-label" class="property-label"><g:message code="zahlung.datum.label" default="Datum" /></span>
					
						<span class="property-value" aria-labelledby="datum-label"><g:formatDate date="${zahlungInstance?.datum}" format="dd.MM.yyyy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${zahlungInstance?.buchungsjahr}">
				<li class="fieldcontain">
					<span id="betrag-label" class="property-label"><g:message code="zahlung.buchungsjahr.label" default="Buchungsjahr" /></span>
					
						<span class="property-value" aria-labelledby="buchungsjahr-label"><g:fieldValue bean="${zahlungInstance}" field="buchungsjahr" /></span>
					
				</li>
				</g:if>
				
				<g:if test="${zahlungInstance?.betrag}">
				<li class="fieldcontain">
					<span id="betrag-label" class="property-label"><g:message code="zahlung.betrag.label" default="Betrag" /></span>
					
						<span class="property-value" aria-labelledby="betrag-label"><g:fieldValue bean="${zahlungInstance}" field="betrag" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${zahlungInstance?.mietvertrag}">
				<li class="fieldcontain">
					<span id="mietvertrag-label" class="property-label"><g:message code="zahlung.mietvertrag.label" default="Mietvertrag" /></span>
					
						<span class="property-value" aria-labelledby="mietvertrag-label"><g:link controller="mietvertrag" action="show" id="${zahlungInstance?.mietvertrag?.id}">${zahlungInstance?.mietvertrag?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${zahlungInstance?.rechnung}">
				<li class="fieldcontain">
					<span id="rechnung-label" class="property-label"><g:message code="zahlung.rechnung.label" default="Rechnung" /></span>
					
						<span class="property-value" aria-labelledby="rechnung-label"><g:link controller="rechnung" action="show" id="${zahlungInstance?.rechnung?.id}">${zahlungInstance?.rechnung?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${zahlungInstance?.dienstleistungsvertrag}">
				<li class="fieldcontain">
					<span id="dienstleistungsvertrag-label" class="property-label"><g:message code="zahlung.dienstleistungsvertrag.label" default="Dienstleistungsvertrag" /></span>
					
						<span class="property-value" aria-labelledby="dienstleistungsvertrag-label"><g:link controller="dienstleistungsvertrag" action="show" id="${zahlungInstance?.dienstleistungsvertrag?.id}">${zahlungInstance?.dienstleistungsvertrag?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${zahlungInstance?.kredit}">
				<li class="fieldcontain">
					<span id="kredit-label" class="property-label"><g:message code="zahlung.kredit.label" default="Kredit" /></span>
					
						<span class="property-value" aria-labelledby="kredit-label"><g:link controller="kredit" action="show" id="${zahlungInstance?.kredit?.id}">${zahlungInstance?.kredit?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${zahlungInstance?.bankumsatz}">
				<li class="fieldcontain">
					<span id="bankumsatz-label" class="property-label"><g:message code="zahlung.bankumsatz.label" default="Bankumsatz" /></span>
					
						<span class="property-value" aria-labelledby="bankumsatz-label"><g:link controller="bankumsatz" action="show" id="${zahlungInstance?.bankumsatz?.id}">${zahlungInstance?.bankumsatz?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${zahlungInstance?.id}" />
					<g:link class="edit" action="edit" id="${zahlungInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
