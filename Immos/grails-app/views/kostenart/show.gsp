
<%@ page import="org.strotmann.immos.Kostenart" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'kostenart.label', default: 'Kostenart')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-kostenart" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-kostenart" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list kostenart">
			
				<g:if test="${kostenartInstance?.bezeichnung}">
				<li class="fieldcontain">
					<span id="bezeichnung-label" class="property-label"><g:message code="kostenart.bezeichnung.label" default="Bezeichnung" /></span>
					
						<span class="property-value" aria-labelledby="bezeichnung-label"><g:fieldValue bean="${kostenartInstance}" field="bezeichnung"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${kostenartInstance?.kommunal}">
				<li class="fieldcontain">
					<span id="kommunal-label" class="property-label"><g:message code="kostenart.kommunal.label" default="Kommunal" /></span>
					
						<span class="property-value" aria-labelledby="kommunal-label"><g:formatBoolean boolean="${kostenartInstance?.kommunal}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:kostenartInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${kostenartInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
