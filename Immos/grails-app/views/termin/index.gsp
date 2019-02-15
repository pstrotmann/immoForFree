
<%@ page import="org.strotmann.immos.Termin" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'termin.label', default: 'Termin')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-termin" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-termin" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="termin.vorlage.label" default="Vorlage" /></th>
						
						<th><g:message code="termin.grund.label" default="Grund" /></th>
						
						<th><g:message code="termin.referenz.label" default="Referenz" /></th>
					
						<th><g:message code="termin.erledigung.label" default="Erledigung" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${Termin.termine}" status="i" var="terminInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td>
							<g:link action="show" id="${terminInstance.id}"><g:formatDate date="${terminInstance.vorlage}" format="dd.MM.yyyy" /></g:link>
						</td>
					
						<td>
							<g:if test="${terminInstance.vorlage <= new Date()}">
									<span style="color:red;">${fieldValue(bean: terminInstance, field: "grund")}</span>
							</g:if>
							<g:if test="${terminInstance.vorlage > new Date()}">
									${fieldValue(bean: terminInstance, field: "grund")}
							</g:if>
						</td>
						
						<td>${fieldValue(bean: terminInstance, field: "referenz")}</td>
					
						<td><g:formatDate date="${terminInstance.erledigung}" format="dd.MM.yyyy" /></td>
					
					</tr>
				</g:each>
				</tbody>
				<tfoot>
					<tr>
						<td>${message(code: 'termin.Count.label', default: 'Anzahl Termine:')}</td>
						<td><g:formatNumber number="${Termin.count()}" type="number"  format="#,##0"/></td>
						<td></td>
						<td></td>
					</tr>
				</tfoot>
			</table>

		</div>
	</body>
</html>
