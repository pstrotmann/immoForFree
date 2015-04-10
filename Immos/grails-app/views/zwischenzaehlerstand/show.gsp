
<%@ page import="org.strotmann.immos.Zwischenzaehlerstand" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'zwischenzaehlerstand.label', default: 'Zwischenzählerstand')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-zwischenzaehlerstand" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-zwischenzaehlerstand" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list zwischenzaehlerstand">
			
				<g:if test="${zwischenzaehlerstandInstance?.ablesedatum}">
				<li class="fieldcontain">
					<span id="ablesedatum-label" class="property-label"><g:message code="zwischenzaehlerstand.ablesedatum.label" default="Ablesedatum" /></span>
					
						<span class="property-value" aria-labelledby="ablesedatum-label"><g:formatDate date="${zwischenzaehlerstandInstance?.ablesedatum}" format="dd.MM.yyyy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${zwischenzaehlerstandInstance?.wert}">
				<li class="fieldcontain">
					<span id="wert-label" class="property-label"><g:message code="zwischenzaehlerstand.wert.label" default="Wert" /></span>
					
						<span class="property-value" aria-labelledby="wert-label"><g:fieldValue bean="${zwischenzaehlerstandInstance}" field="wert"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${zwischenzaehlerstandInstance?.zz}">
				<li class="fieldcontain">
					<span id="zz-label" class="property-label"><g:message code="zwischenzaehlerstand.zz.label" default="Zwischenzähler" /></span>
					
						<span class="property-value" aria-labelledby="zz-label"><g:link controller="zwischenzaehler" action="show" id="${zwischenzaehlerstandInstance?.zz?.id}">${zwischenzaehlerstandInstance?.zz?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${zwischenzaehlerstandInstance?.id}" />
					<g:link class="edit" action="edit" id="${zwischenzaehlerstandInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
