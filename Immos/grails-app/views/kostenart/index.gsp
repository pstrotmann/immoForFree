
<%@ page import="org.strotmann.immos.Kostenart" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'kostenart.label', default: 'Kostenart')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-kostenart" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-kostenart" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="bezeichnung" title="${message(code: 'kostenart.bezeichnung.label', default: 'Bezeichnung')}" />
					
						<g:sortableColumn property="kommunal" title="${message(code: 'kostenart.kommunal.label', default: 'Kommunal')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${kostenartInstanceList}" status="i" var="kostenartInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${kostenartInstance.id}">${fieldValue(bean: kostenartInstance, field: "bezeichnung")}</g:link></td>
					
						<td><g:formatBoolean boolean="${kostenartInstance.kommunal}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${kostenartInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
