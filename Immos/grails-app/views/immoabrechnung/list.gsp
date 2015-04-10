
<%@ page import="org.strotmann.immos.Immoabrechnung" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'immoabrechnung.label', default: 'Immoabrechnung')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-immoabrechnung" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-immoabrechnung" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="jahr" title="${message(code: 'immoabrechnung.jahr.label', default: 'Jahr')}" />
					
						<g:sortableColumn property="datum" title="${message(code: 'immoabrechnung.datum.label', default: 'Datum')}" />
					
						<th><g:message code="immoabrechnung.immobilie.label" default="Immobilie" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${immoabrechnungInstanceList}" status="i" var="immoabrechnungInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${immoabrechnungInstance.id}"><g:formatNumber number="${immoabrechnungInstance?.jahr.encodeAsHTML()}"/></g:link></td>
					
						<td><g:formatDate date="${immoabrechnungInstance?.datum}" format="dd.MM.yyyy" /></td>
					
						<td>${fieldValue(bean: immoabrechnungInstance, field: "immobilie")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${immoabrechnungInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
