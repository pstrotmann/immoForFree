
<%@ page import="org.strotmann.immos.Zaehler" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'zaehler.label', default: 'Zähler')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-zaehler" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-zaehler" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list zaehler">
			
				<g:if test="${zaehlerInstance?.zaehlernummer}">
				<li class="fieldcontain">
					<span id="zaehlernummer-label" class="property-label"><g:message code="zaehler.zaehlernummer.label" default="Zählernummer" /></span>
					
						<span class="property-value" aria-labelledby="zaehlernummer-label"><g:fieldValue bean="${zaehlerInstance}" field="zaehlernummer"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${zaehlerInstance?.zaehlertyp}">
				<li class="fieldcontain">
					<span id="zaehlertyp-label" class="property-label"><g:message code="zaehler.zaehlertyp.label" default="Zählertyp" /></span>
					
						<span class="property-value" aria-labelledby="zaehlertyp-label"><g:fieldValue bean="${zaehlerInstance}" field="zaehlertyp"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${zaehlerInstance?.zaehlereinheit}">
				<li class="fieldcontain">
					<span id="zaehlereinheit-label" class="property-label"><g:message code="zaehler.zaehlereinheit.label" default="Zählereinheit" /></span>
					
						<span class="property-value" aria-labelledby="zaehlereinheit-label"><g:fieldValue bean="${zaehlerInstance}" field="zaehlereinheit"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${zaehlerInstance?.immobilie}">
				<li class="fieldcontain">
					<span id="immobilie-label" class="property-label"><g:message code="zaehler.immobilie.label" default="Immobilie" /></span>
					
						<span class="property-value" aria-labelledby="immobilie-label"><g:link controller="immobilie" action="show" id="${zaehlerInstance?.immobilie?.id}">${zaehlerInstance?.immobilie?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${zaehlerInstance?.zaehlerstaende}">
				<li class="fieldcontain">
					<span id="zaehlerstaende-label" class="property-label"><g:message code="zaehler.zaehlerstaende.label" default="Zählerstände" /></span>
					
						<g:each in="${zaehlerInstance.zaehlerstaende}" var="z">
						<span class="property-value" aria-labelledby="zaehlerstaende-label"><g:link controller="zaehlerstand" action="show" id="${z.id}">${z?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
				
				<g:if test="${zaehlerInstance?.zwischenzaehler}">
				<li class="fieldcontain">
					<span id="zwischenzaehler-label" class="property-label"><g:message code="zaehler.zwischenzaehler.label" default="Zwischenzähler" /></span>
					
						<g:each in="${zaehlerInstance.zwischenzaehler}" var="z">
						<span class="property-value" aria-labelledby="zwischenzaehler-label"><g:link controller="zwischenzaehler" action="show" id="${z.id}">${z?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${zaehlerInstance?.id}" />
					<g:link class="edit" action="edit" id="${zaehlerInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
