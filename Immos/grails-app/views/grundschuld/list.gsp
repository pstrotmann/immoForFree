
<%@ page import="org.strotmann.immos.Grundschuld" %>
<%@ page import="org.strotmann.immos.Kredit" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'grundschuld.label', default: 'Grundschuld')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-grundschuld" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-grundschuld" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
						<th><g:message code="grundschuld.immobilie.label" default="Immobilie" /></th>
						
						<th><g:message code="grundschuld.rang.label" default="Rang" /></th>
						
						<th><g:message code="grundschuld.glaeubiger.label" default="Gläubiger" /></th>
						
						<th><g:message code="grundschuld.eintragAm.label" default="eingetragen am" /></th>
					
						<th><div align = right><g:message code="grundschuld.grundschuld.label" default="Grundschuld" /></div></th>
						
						<th><div align = right><g:message code="grundschuld.saldo.label" default="Restschuld" /></div></th>
					</tr>
				</thead>
				<tbody>
				<g:each in="${grundschuldInstanceList}" status="i" var="grundschuldInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${grundschuldInstance.id}">${fieldValue(bean: grundschuldInstance, field: "immobilie")}</g:link></td>
						
						<td>${fieldValue(bean: grundschuldInstance, field: "rang")}</td>
						
						<td>${fieldValue(bean: grundschuldInstance, field: "glaeubiger")}</td>
					
						<td><g:formatDate date="${grundschuldInstance.eintragAm}" format="dd.MM.yyyy" /></td>
						
						<td><div align = right><g:formatNumber number="${grundschuldInstance.betrag}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>
					
						<td><div align = right><g:formatNumber number="${grundschuldInstance.saldo}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>
						
					</tr>
				</g:each>
				</tbody>
				<tfoot>
					<tr>
						<td></td>
					
						<td></td>
						
						<td></td>
					
						<td><div align = right><g:message code="kredit.summe.label" default="Summen:" /></div></td>
					
						<td><div align = right><g:formatNumber number="${Grundschuld.grundschuldSumme}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>
					
						<td><div align = right><g:formatNumber number="${Kredit.saldoSumme}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>
					
					</tr>
				</tfoot>
			</table>
			<div class="pagination">
				<g:paginate total="${grundschuldInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
