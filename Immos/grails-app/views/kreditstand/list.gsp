
<%@ page import="org.strotmann.immos.Kreditstand" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'kreditstand.label', default: 'Kreditstand')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-kreditstand" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-kreditstand" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="laufzeitAb" title="${message(code: 'kreditstand.laufzeitAb.label', default: 'Laufzeit Ab')}" />
					
						<g:sortableColumn property="laufzeitBis" title="${message(code: 'kreditstand.laufzeitBis.label', default: 'Laufzeit Bis')}" />
					
						<g:sortableColumn property="kreditsumme" title="${message(code: 'kreditstand.kreditsumme.label', default: 'Kreditsumme')}" />
					
						<g:sortableColumn property="zinssatz" title="${message(code: 'kreditstand.zinssatz.label', default: 'Zinssatz')}" />
					
						<g:sortableColumn property="tilgungssatz" title="${message(code: 'kreditstand.tilgungssatz.label', default: 'Tilgungssatz')}" />
					
						<th><g:message code="kreditstand.kredit.label" default="Kredit" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${kreditstandInstanceList}" status="i" var="kreditstandInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${kreditstandInstance.id}"><g:formatDate date="${kreditstandInstance.laufzeitAb}" format="dd.MM.yyyy"/></g:link></td>
					
						<td><g:formatDate date="${kreditstandInstance.laufzeitBis}" format="dd.MM.yyyy"/></td>
					
						<td>${fieldValue(bean: kreditstandInstance, field: "kreditsumme")}</td>
					
						<td>${fieldValue(bean: kreditstandInstance, field: "zinssatz")}</td>
					
						<td>${fieldValue(bean: kreditstandInstance, field: "tilgungssatz")}</td>
					
						<td>${fieldValue(bean: kreditstandInstance, field: "kredit")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${kreditstandInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
