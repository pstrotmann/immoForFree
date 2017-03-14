
<%@ page import="org.strotmann.immos.Bankverbindung" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'bankverbindung.label', default: 'Bankverbindung')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-bankverbindung" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-bankverbindung" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list bankverbindung">
			
				<g:if test="${bankverbindungInstance?.iban}">
				<li class="fieldcontain">
					<span id="iban-label" class="property-label"><g:message code="bankverbindung.iban.label" default="Iban" /></span>
						<span class="property-value" aria-labelledby="iban-label">
						<g:fieldValue bean="${bankverbindungInstance}" field="iban"/>
					</span>	
				</li>
				<li class="fieldcontain">
					<span id="bic-label" class="property-label"><g:message code="bankverbindung.bic.label" default="BIC" /></span>
						<span class="property-value" aria-labelledby="bic-label">
						<g:link controller="bank" action="show" id="${bankverbindungInstance?.getBankId()}">${bankverbindungInstance?.BIC}</g:link>
					</span>	
				</li>
				<li class="fieldcontain">
					<span id="leer-label" class="property-label"><g:message default=" " /></span>
						<span class="property-value" aria-labelledby="leer-label">
						<g:fieldValue bean="${bankverbindungInstance}" field="nameUndAdresse"/>
					</span>	
				</li>
				<li class="fieldcontain">
					<span id="Blz-label" class="property-label"><g:message code="bankverbindung.blz.label" default="Blz" /></span>
						<span class="property-value" aria-labelledby="Blz-label">
						<g:fieldValue bean="${bankverbindungInstance}" field="blz"/>
					</span>	
				</li>
				<li class="fieldcontain">
					<span id="KtoNr-label" class="property-label"><g:message code="bankverbindung.ktonr.label" default="KtoNr" /></span>
						<span class="property-value" aria-labelledby="KtoNr-label">
						<g:fieldValue bean="${bankverbindungInstance}" field="ktoNr"/>
					</span>	
				</li>
				</g:if>
				
				<g:if test="${bankverbindungInstance?.partner}">
				<li class="fieldcontain">
					<span id="partner-label" class="property-label"><g:message code="bankverbindung.partner.label" default="Partner" /></span>						
						<span class="property-value" aria-labelledby="partner-label">
							<g:if test="${flash.person}">
								<g:link controller="person" action="show" id="${bankverbindungInstance?.partner?.id}">${bankverbindungInstance?.partner?.encodeAsHTML()}</g:link>
							</g:if>
							<g:if test="${!flash.person}">
								<g:link controller="organisation" action="show" id="${bankverbindungInstance?.partner?.id}">${bankverbindungInstance?.partner?.encodeAsHTML()}</g:link>
							</g:if>
						</span>
						
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:bankverbindungInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${bankverbindungInstance?.id}" />
					<g:link class="edit" action="edit" id="${bankverbindungInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
