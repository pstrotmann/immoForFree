
<%@ page import="org.strotmann.immos.Dienstleistungsvertrag" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'dienstleistungsvertrag.label', default: 'Dienstleistungsvertrag')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-dienstleistungsvertrag" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-dienstleistungsvertrag" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
						<th><g:message code="dienstleistungsvertrag.dienstleister.label" default="Dienstleister" /></th>
					
						<th><g:message code="dienstleistungsvertrag.immobilie.label" default="Immobilie" /></th>
					
						<g:sortableColumn property="dienstleistungsart" title="${message(code: 'dienstleistungsvertrag.dienstleistungsart.label', default: 'Art')}" />
						
						<th><g:message code="dienstleistungsvertrag.immobilie.label" default="Kd.Nr,Vertr.Nr.,Ref" /></th>
						
						<th><g:message code="dienstleistungsvertrag.zahlweise.label" default="Zahlweise" /></th>
						
						<th><div align = right><g:message code="dienstleistungsvertrag.pauschale.label" default="Pauschale" /></th>
						
						<th><g:message code="dienstleistungsvertrag.gueAb.label" default="gültig ab" /></th>
					</tr>
				</thead>
				<tbody>
				<g:each in="${dienstleistungsvertragInstanceList}" status="i" var="dienstleistungsvertragInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${dienstleistungsvertragInstance.id}">${fieldValue(bean: dienstleistungsvertragInstance, field: "dienstleister.partner.name")}</g:link></td>
					
						<td>${fieldValue(bean: dienstleistungsvertragInstance, field: "immobilie")}</td>
					
						<td>${fieldValue(bean: dienstleistungsvertragInstance, field: "dienstleistungsart")}</td>
					
						<td>${fieldValue(bean: dienstleistungsvertragInstance, field: "referenzen")}</td>

						<td>${fieldValue(bean: dienstleistungsvertragInstance, field: "zahlweiseKlar")}</td>

						<td><div align = right><g:formatNumber number="${dienstleistungsvertragInstance.pauschale}" type="number" minFractionDigits="2" format="#,###.##"/></div></td>
						
						<td><g:formatDate date="${dienstleistungsvertragInstance.vstand}" format="dd.MM.yyyy"/></td>
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${dienstleistungsvertragInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
