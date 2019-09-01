
<%@ page import="org.strotmann.immos.Mietsache" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'mietsache.label', default: 'Mietsache')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-mietsache" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-mietsache" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="mietsache.immobilie.label" default="Immobilie" /></th>
					
						<g:sortableColumn property="lage" title="${message(code: 'mietsache.lage.label', default: 'Lage')}" />
					
						<g:sortableColumn property="art" title="${message(code: 'mietsache.art.label', default: 'Art')}" />
					
						<g:sortableColumn property="wohnflaeche" title="${message(code: 'mietsache.wohnflaeche.label', default: 'Wohnflaeche')}" />
					
						<g:sortableColumn property="aufteilung" title="${message(code: 'mietsache.aufteilung.label', default: 'Aufteilung')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${mietsacheInstanceList}" status="i" var="mietsacheInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td>${fieldValue(bean: mietsacheInstance, field: "immobilie")}</td>
						
						<td><g:link action="show" id="${mietsacheInstance.id}">${fieldValue(bean: mietsacheInstance, field: "lage")}</g:link></td>
					
						<td>${fieldValue(bean: mietsacheInstance, field: "art")}</td>
					
						<td>${fieldValue(bean: mietsacheInstance, field: "wohnflaeche")}</td>
					
						<td>${fieldValue(bean: mietsacheInstance, field: "aufteilung")}</td>
					
						
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${mietsacheInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
