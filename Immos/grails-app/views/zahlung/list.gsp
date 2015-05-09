
<%@ page import="org.strotmann.immos.Zahlung" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'zahlung.label', default: 'Zahlung')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-zahlung" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-zahlung" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="datum" title="${message(code: 'zahlung.datum.label', default: 'Datum')}" />
					
						<g:sortableColumn property="betrag" title="${message(code: 'zahlung.betrag.label', default: 'Betrag')}" />
					
						<th><g:message code="zahlung.mietvertrag.label" default="Mietvertrag" /></th>
					
						<th><g:message code="zahlung.rechnung.label" default="Rechnung" /></th>
					
						<th><g:message code="zahlung.dienstleistungsvertrag.label" default="Dienstleistungsvertrag" /></th>
					
						<th><g:message code="zahlung.kredit.label" default="Kredit" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${zahlungInstanceList}" status="i" var="zahlungInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${zahlungInstance.id}"><g:formatDate date="${zahlungInstance?.datum}" format="dd.MM.yyyy"/></g:link></td>
					
						<td>${fieldValue(bean: zahlungInstance, field: "betrag")}</td>
					
						<td>${fieldValue(bean: zahlungInstance, field: "mietvertrag")}</td>
					
						<td>${fieldValue(bean: zahlungInstance, field: "rechnung")}</td>
					
						<td>${fieldValue(bean: zahlungInstance, field: "dienstleistungsvertrag")}</td>
					
						<td>${fieldValue(bean: zahlungInstance, field: "kredit")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			
		</div>
	</body>
</html>
