
<%@ page import="org.strotmann.immos.Verwendung" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'verwendung.label', default: 'Verwendung')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-verwendung" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-verwendung" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="verwendung.kredit.label" default="Kredit" /></th>
					
						<th><g:message code="verwendung.immobilie.label" default="Immobilie" /></th>
					
						<g:sortableColumn property="betrag" title="${message(code: 'verwendung.betrag.label', default: 'Betrag')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${verwendungInstanceList}" status="i" var="verwendungInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${verwendungInstance.id}">${fieldValue(bean: verwendungInstance, field: "kredit")}</g:link></td>
					
						<td>${fieldValue(bean: verwendungInstance, field: "immobilie")}</td>
					
						<td>${fieldValue(bean: verwendungInstance, field: "betrag")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${verwendungInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
