
<%@ page import="org.strotmann.immos.Besicherung" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'besicherung.label', default: 'Besicherung')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-besicherung" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-besicherung" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="besicherung.kredit.label" default="Kredit" /></th>
					
						<th><g:message code="besicherung.grundschuld.label" default="Grundschuld" /></th>
					
						<g:sortableColumn property="betrag" title="${message(code: 'besicherung.betrag.label', default: 'Betrag')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${besicherungInstanceList}" status="i" var="besicherungInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${besicherungInstance.id}">${fieldValue(bean: besicherungInstance, field: "kredit")}</g:link></td>
					
						<td>${fieldValue(bean: besicherungInstance, field: "grundschuld")}</td>
					
						<td>${fieldValue(bean: besicherungInstance, field: "betrag")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${besicherungInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
