
<%@ page import="org.strotmann.immos.OffenerPosten" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'offenerPosten.label', default: 'OffenerPosten')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-offenerPosten" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-offenerPosten" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list offenerPosten">
			
				<g:if test="${offenerPostenInstance?.faelligkeit}">
				<li class="fieldcontain">
					<span id="faelligkeit-label" class="property-label"><g:message code="offenerPosten.faelligkeit.label" default="Faelligkeit" /></span>
					
						<span class="property-value" aria-labelledby="faelligkeit-label"><g:formatDate date="${offenerPostenInstance?.faelligkeit}" format="dd.MM.yyyy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${offenerPostenInstance?.grund}">
				<li class="fieldcontain">
					<span id="grund-label" class="property-label"><g:message code="offenerPosten.grund.label" default="Grund" /></span>
					
						<span class="property-value" aria-labelledby="grund-label"><g:fieldValue bean="${offenerPostenInstance}" field="grund"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${offenerPostenInstance?.betrag}">
				<li class="fieldcontain">
					<span id="betrag-label" class="property-label"><g:message code="offenerPosten.betrag.label" default="Betrag" /></span>
					
						<span class="property-value" aria-labelledby="betrag-label"><g:fieldValue bean="${offenerPostenInstance}" field="betrag"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${offenerPostenInstance?.mietvertrag}">
				<li class="fieldcontain">
					<span id="mietvertrag-label" class="property-label"><g:message code="offenerPosten.mietvertrag.label" default="Mietvertrag" /></span>
					
						<span class="property-value" aria-labelledby="mietvertrag-label"><g:link controller="mietvertrag" action="show" id="${offenerPostenInstance?.mietvertrag?.id}">${offenerPostenInstance?.mietvertrag?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${offenerPostenInstance?.dienstleistungsvertrag}">
				<li class="fieldcontain">
					<span id="dienstleistungsvertrag-label" class="property-label"><g:message code="offenerPosten.dienstleistungsvertrag.label" default="Dienstleistungsvertrag" /></span>
					
						<span class="property-value" aria-labelledby="dienstleistungsvertrag-label"><g:link controller="dienstleistungsvertrag" action="show" id="${offenerPostenInstance?.dienstleistungsvertrag?.id}">${offenerPostenInstance?.dienstleistungsvertrag?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${offenerPostenInstance?.rechnung}">
				<li class="fieldcontain">
					<span id="rechnung-label" class="property-label"><g:message code="offenerPosten.rechnung.label" default="Rechnung" /></span>
					
						<span class="property-value" aria-labelledby="rechnung-label"><g:link controller="rechnung" action="show" id="${offenerPostenInstance?.rechnung?.id}">${offenerPostenInstance?.rechnung?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${offenerPostenInstance?.kredit}">
				<li class="fieldcontain">
					<span id="kredit-label" class="property-label"><g:message code="offenerPosten.kredit.label" default="Kredit" /></span>
					
						<span class="property-value" aria-labelledby="kredit-label"><g:link controller="kredit" action="show" id="${offenerPostenInstance?.kredit?.id}">${offenerPostenInstance?.kredit?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:offenerPostenInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${offenerPostenInstance?.id}" />
					<g:link class="edit" action="edit" id="${offenerPostenInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
