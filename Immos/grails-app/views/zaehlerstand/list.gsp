
<%@ page import="org.strotmann.immos.Zaehlerstand" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'zaehlerstand.label', default: 'Zählerstand')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-zaehlerstand" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-zaehlerstand" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="ablesedatum" title="${message(code: 'zaehlerstand.ablesedatum.label', default: 'Ablesedatum')}" />
					
						<g:sortableColumn property="wert" title="${message(code: 'zaehlerstand.wert.label', default: 'Wert')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${zaehlerstandInstanceList}" status="i" var="zaehlerstandInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${zaehlerstandInstance.id}"><g:formatDate date="${zaehlerstandInstance?.ablesedatum}" format="dd.MM.yyyy"/></g:link></td>
					
						<td>${fieldValue(bean: zaehlerstandInstance, field: "wert")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${zaehlerstandInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
