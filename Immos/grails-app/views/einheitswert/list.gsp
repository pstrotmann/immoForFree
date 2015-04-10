
<%@ page import="org.strotmann.immos.Einheitswert" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'einheitswert.label', default: 'Einheitswert')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-einheitswert" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-einheitswert" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="ewNummer" title="${message(code: 'einheitswert.ewNummer.label', default: 'Ew Nummer')}" />
					
						<g:sortableColumn property="gueltigAb" title="${message(code: 'einheitswert.gueltigAb.label', default: 'Gueltig Ab')}" />
					
						<g:sortableColumn property="wert" title="${message(code: 'einheitswert.wert.label', default: 'Wert')}" />
					
						<th><g:message code="einheitswert.immobilie.label" default="Immobilie" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${einheitswertInstanceList}" status="i" var="einheitswertInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${einheitswertInstance.id}">${fieldValue(bean: einheitswertInstance, field: "ewNummer")}</g:link></td>
					
						<td><g:formatDate date="${einheitswertInstance.gueltigAb}" format="dd.MM.yyyy"/></td>
					
						<td>${fieldValue(bean: einheitswertInstance, field: "wert")}</td>
					
						<td>${fieldValue(bean: einheitswertInstance, field: "immobilie")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${einheitswertInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
