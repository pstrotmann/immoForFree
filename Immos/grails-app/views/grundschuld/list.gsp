
<%@ page import="org.strotmann.immos.Grundschuld" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'grundschuld.label', default: 'Grundschuld')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-grundschuld" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-grundschuld" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="eintragAm" title="${message(code: 'grundschuld.eintragAm.label', default: 'Eintrag Am')}" />
					
						<g:sortableColumn property="loeschungAm" title="${message(code: 'grundschuld.loeschungAm.label', default: 'Loeschung Am')}" />
					
						<g:sortableColumn property="betrag" title="${message(code: 'grundschuld.betrag.label', default: 'Betrag')}" />
					
						<g:sortableColumn property="rang" title="${message(code: 'grundschuld.rang.label', default: 'Rang')}" />
					
						<th><g:message code="grundschuld.glaeubiger.label" default="Glaeubiger" /></th>
					
						<th><g:message code="grundschuld.immobilie.label" default="Immobilie" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${grundschuldInstanceList}" status="i" var="grundschuldInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${grundschuldInstance.id}"><g:formatDate date="${grundschuldInstance.eintragAm}" format="dd.MM.yyyy" /></g:link></td>
					
						<td><g:formatDate date="${grundschuldInstance.loeschungAm}" format="dd.MM.yyyy" /></td>
					
						<td>${fieldValue(bean: grundschuldInstance, field: "betrag")}</td>
					
						<td>${fieldValue(bean: grundschuldInstance, field: "rang")}</td>
					
						<td>${fieldValue(bean: grundschuldInstance, field: "glaeubiger")}</td>
					
						<td>${fieldValue(bean: grundschuldInstance, field: "immobilie")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${grundschuldInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
