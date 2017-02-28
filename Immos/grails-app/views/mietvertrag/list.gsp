
<%@ page import="org.strotmann.immos.Mietvertrag" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'mietvertrag.label', default: 'Mietvertrag')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-mietvertrag" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-mietvertrag" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="mietvertrag.mieter.label" default="Mieter" /></th>
					
						<th><g:message code="mietvertrag.mietsache.label" default="Mietsache" /></th>
						
						<g:sortableColumn property="mietbeginn" title="${message(code: 'mietvertrag.mietbeginn.label', default: 'Mietbeginn')}" />
						
						<th><div align = right><g:message code="mietvertrag.grundmiete.label" default="Grundmiete" /></div></th>
						
						<th><div align = right><g:message code="mietvertrag.bruttomiete.label" default="Bruttomiete" /></div></th>
						
						<th><div align = right><g:message code="mietvertrag.mietsaldo.label" default="Saldo" /></div></th>
						
					</tr>
				</thead>
				<tbody>
				<g:each in="${Mietvertrag.mietvertraege}" status="i" var="mietvertragInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${mietvertragInstance.id}">${fieldValue(bean: mietvertragInstance, field: "mieter.partner.name")}</g:link></td>
					
						<td>${fieldValue(bean: mietvertragInstance, field: "mietsache")}</td>
						
						<td><g:formatDate date="${mietvertragInstance.mietbeginn}" format="dd.MM.yyyy" /></td>
						
						<td><div align = right><g:formatNumber number="${mietvertragInstance.grundmiete}" type="number" minFractionDigits="2" format="#,##0.00"/></div></td>
						
						<td><div align = right><g:formatNumber number="${mietvertragInstance.bruttomiete}" type="number" minFractionDigits="2" format="#,##0.00"/></div></td>
						
						<td><div align = right>
							<g:if test="${mietvertragInstance.mietsaldo < 0}">
    							<span style="color:red;"><g:formatNumber number="${mietvertragInstance.mietsaldo}" type="number" minFractionDigits="2" format="#,##0.00"/></span>
							</g:if>
							<g:if test="${mietvertragInstance.mietsaldo > 0}">
    							<g:formatNumber number="${mietvertragInstance.mietsaldo}" type="number" minFractionDigits="2" format="#,##0.00"/>
							</g:if>
						</div></td>
						
					</tr>
				</g:each>
				</tbody>
				<tfoot>
					<tr>
						<td></td>
					
						<td><div align = right><g:message code="Mietvertrag.summe.label" default="Summen:" /></div></td>
					
						<td></td>
						
						<td><div align = right><g:formatNumber number="${Mietvertrag.sumMtlGrund}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>
						
						<td><div align = right><g:formatNumber number="${Mietvertrag.sumMtlBrutto}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>
						
						<td><div align = right><span style="color:red;"><g:formatNumber number="${Mietvertrag.sumSaldo}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></span></div></td>
						
					</tr>
				</tfoot>
			</table>
			<div class="pagination">
				<g:paginate total="${mietvertragInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
