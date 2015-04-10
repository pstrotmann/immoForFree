
<%@ page import="org.strotmann.immos.Umlage" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'umlage.label', default: 'Umlage')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-umlage" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-umlage" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="kostenart" title="${message(code: 'umlage.kostenart.label', default: 'Kostenart')}" />
					
						<g:sortableColumn property="umlageschluessel" title="${message(code: 'umlage.umlageschluessel.label', default: 'Umlageschluessel')}" />
					
						<g:sortableColumn property="betrag" title="${message(code: 'umlage.betrag.label', default: 'Betrag')}" />
					
						<th><g:message code="umlage.immoabrechnung.label" default="Immoabrechnung" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${umlageInstanceList}" status="i" var="umlageInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${umlageInstance.id}">${fieldValue(bean: umlageInstance, field: "kostenart")}</g:link></td>
					
						<td>${fieldValue(bean: umlageInstance, field: "umlageschluessel")}</td>
					
						<td>${fieldValue(bean: umlageInstance, field: "betrag")}</td>
					
						<td>${fieldValue(bean: umlageInstance, field: "immoabrechnung")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${umlageInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
