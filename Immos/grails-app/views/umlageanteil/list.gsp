
<%@ page import="org.strotmann.immos.Umlageanteil" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'umlageanteil.label', default: 'Umlageanteil')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-umlageanteil" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-umlageanteil" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="kostenart" title="${message(code: 'umlageanteil.kostenart.label', default: 'Kostenart')}" />
					
						<g:sortableColumn property="umlageschluessel" title="${message(code: 'umlageanteil.umlageschluessel.label', default: 'Umlageschluessel')}" />
					
						<g:sortableColumn property="betrag" title="${message(code: 'umlageanteil.betrag.label', default: 'Betrag')}" />
					
						<th><g:message code="umlageanteil.nebenkostenabrechnung.label" default="Nebenkostenabrechnung" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${umlageanteilInstanceList}" status="i" var="umlageanteilInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${umlageanteilInstance.id}">${fieldValue(bean: umlageanteilInstance, field: "kostenart")}</g:link></td>
					
						<td>${fieldValue(bean: umlageanteilInstance, field: "umlageschluessel")}</td>
					
						<td>${fieldValue(bean: umlageanteilInstance, field: "betrag")}</td>
					
						<td>${fieldValue(bean: umlageanteilInstance, field: "nebenkostenabrechnung")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${umlageanteilInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
