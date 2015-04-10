
<%@ page import="org.strotmann.immos.Organisation" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'organisation.label', default: 'Organisation')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-organisation" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-organisation" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
						<g:sortableColumn property="name" title="${message(code: 'organisation.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="nameZusatz" title="${message(code: 'organisation.nameZusatz.label', default: 'Name Zusatz')}" />
					
						<g:sortableColumn property="rechtsform" title="${message(code: 'organisation.rechtsform.label', default: 'Rechtsform')}" />
					
						<th><g:message code="organisation.hausadresse.label" default="Hausadresse" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${organisationInstanceList}" status="i" var="organisationInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${organisationInstance.id}">${fieldValue(bean: organisationInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: organisationInstance, field: "nameZusatz")}</td>
					
						<td>${fieldValue(bean: organisationInstance, field: "rechtsform")}</td>
						
						<td>${fieldValue(bean: organisationInstance, field: "hausadresse")}</td>
					
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${organisationInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
