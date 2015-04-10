
<%@ page import="org.strotmann.immos.Heizkostenabrechnung" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'heizkostenabrechnung.label', default: 'Heizkostenabrechnung')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-heizkostenabrechnung" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-heizkostenabrechnung" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="von" title="${message(code: 'heizkostenabrechnung.von.label', default: 'Von')}" />
					
						<g:sortableColumn property="bis" title="${message(code: 'heizkostenabrechnung.bis.label', default: 'Bis')}" />
					
						<g:sortableColumn property="betrag" title="${message(code: 'heizkostenabrechnung.betrag.label', default: 'Betrag')}" />
					
						<th><g:message code="heizkostenabrechnung.betriebskostenabrechnung.label" default="Betriebskostenabrechnung" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${heizkostenabrechnungInstanceList}" status="i" var="heizkostenabrechnungInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${heizkostenabrechnungInstance.id}"><g:formatDate date="${heizkostenabrechnungInstance.von}" format="dd.MM.yyyy"/></g:link></td>
					
						<td><g:formatDate date="${heizkostenabrechnungInstance.bis}" format="dd.MM.yyyy"/></td>
					
						<td>${fieldValue(bean: heizkostenabrechnungInstance, field: "betrag")}</td>
					
						<td>${fieldValue(bean: heizkostenabrechnungInstance, field: "betriebskostenabrechnung")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${heizkostenabrechnungInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
