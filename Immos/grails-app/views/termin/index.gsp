
<%@ page import="org.strotmann.immos.Termin" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'termin.label', default: 'Termin')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-termin" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-termin" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="vorlage" title="${message(code: 'termin.vorlage.label', default: 'Vorlage')}" />
					
						<th><g:message code="termin.grund.label" default="Grund" /></th>
					
						<th><g:message code="termin.erledigung.label" default="Erledigung" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${terminInstanceList}" status="i" var="terminInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${terminInstance.id}"><g:formatDate date="${terminInstance.vorlage}" format="dd.MM.yyyy" /></g:link></td>
					
						<td>${fieldValue(bean: terminInstance, field: "grund")}</td>
					
						<td><g:formatDate date="${terminInstance.erledigung}" format="dd.MM.yyyy" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${terminInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
