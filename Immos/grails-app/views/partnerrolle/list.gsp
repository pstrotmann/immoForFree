
<%@ page import="org.strotmann.immos.Partnerrolle" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'partnerrolle.label', default: 'Partnerrolle')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-partnerrolle" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-partnerrolle" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="partnerrolle.partner.label" default="Partner" /></th>
					
						<g:sortableColumn property="rolle" title="${message(code: 'partnerrolle.rolle.label', default: 'Rolle')}" />
					
						<th><g:message code="partnerrolle.mietvertrag.label" default="Mietvertrag" /></th>
					
						<th><g:message code="partnerrolle.kredit.label" default="Kredit" /></th>
					
						<th><g:message code="partnerrolle.dienstleistungsvertrag.label" default="Dienstleistungsvertrag" /></th>
					
						<th><g:message code="partnerrolle.rechnung.label" default="Rechnung" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${partnerrolleInstanceList}" status="i" var="partnerrolleInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${partnerrolleInstance.id}">${fieldValue(bean: partnerrolleInstance, field: "partner")}</g:link></td>
					
						<td>${fieldValue(bean: partnerrolleInstance, field: "rolle")}</td>
					
						<td>${fieldValue(bean: partnerrolleInstance, field: "mietvertrag")}</td>
					
						<td>${fieldValue(bean: partnerrolleInstance, field: "kredit")}</td>
					
						<td>${fieldValue(bean: partnerrolleInstance, field: "dienstleistungsvertrag")}</td>
					
						<td>${fieldValue(bean: partnerrolleInstance, field: "rechnung")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${partnerrolleInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
