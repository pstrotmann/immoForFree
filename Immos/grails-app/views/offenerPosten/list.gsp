
<%@ page import="org.strotmann.immos.OffenerPosten" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'offenerPosten.label', default: 'OffenerPosten')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-offenerPosten" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-offenerPosten" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="faelligkeit" title="${message(code: 'offenerPosten.faelligkeit.label', default: 'Faelligkeit')}" />
					
						<g:sortableColumn property="grund" title="${message(code: 'offenerPosten.grund.label', default: 'Grund')}" />
					
						<g:sortableColumn property="betrag" title="${message(code: 'offenerPosten.betrag.label', default: 'Betrag')}" />
					
						<th><g:message code="offenerPosten.mietvertrag.label" default="Mietvertrag" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${offenerPostenInstanceList}" status="i" var="offenerPostenInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${offenerPostenInstance.id}"><g:formatDate date="${offenerPostenInstance.faelligkeit}" format="dd.MM.yyyy" /></g:link></td>
					
						<td>${fieldValue(bean: offenerPostenInstance, field: "grund")}</td>
					
						<td>${fieldValue(bean: offenerPostenInstance, field: "betrag")}</td>
					
						<td>${fieldValue(bean: offenerPostenInstance, field: "mietvertrag")}</td>
						
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${offenerPostenInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
