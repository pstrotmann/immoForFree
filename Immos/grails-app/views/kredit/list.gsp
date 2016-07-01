
<%@ page import="org.strotmann.immos.Kredit" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'kredit.label', default: 'Kredit')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-kredit" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-kredit" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="kredit.kreditgeber.label" default="Kreditgeber" /></th>
					
						<th><g:message code="kredit.verwendung.label" default="Verwendung" /></th>
					
						<g:sortableColumn property="vertragsnummer" title="${message(code: 'kredit.vertragsnummer.label', default: 'VertragsNr')}" />
					
						<th><div align = right><g:message code="kredit.kreditsaldo.label" default="Saldo" /></div></th>
						
						<g:sortableColumn property="zahlweise" title="${message(code: 'kredit.zahlweise.label', default: 'Zahlweise')}" />
					
						<th><g:message code="kredit.aktProz.label" default="akt. %" /></th>
						
						<th><g:message code="kredit.festBis.label" default="fest bis" /></th>
						
						<th><g:message code="kredit.mtlRate.label" default="mtl Rate" /></th>
						
						<th><g:message code="kredit.zins.label" default="Zins" /></th>
						
						<th><g:message code="kredit.zins.label" default="Tilgung" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${kreditInstanceList}" status="i" var="kreditInstance">
					<g:if test="${kreditInstance.kreditsaldo > 0}">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${kreditInstance.id}">${fieldValue(bean: kreditInstance, field: "kreditgeber.partner.name")}</g:link></td>
					
						<td>${fieldValue(bean: kreditInstance, field: "verwendung")}</td>
										
						<td>${fieldValue(bean: kreditInstance, field: "vertragsnummer")}</td>
						
						<td><div align = right><g:formatNumber number="${kreditInstance.kreditsaldo}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>
					
						<td>${fieldValue(bean: kreditInstance, field: "zahlweiseKlar")}</td>
						
						<td><div align = center><g:formatNumber number="${kreditInstance.aktProz}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>
											
						<td><div align = right><g:formatDate date="${kreditInstance?.festBis}" format="dd.MM.yyyy"/></div></td>
						
						<td><div align = right><g:formatNumber number="${kreditInstance.mtlRate}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>
					
						<td><div align = right><g:formatNumber number="${kreditInstance.mtlZins}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>
						
						<td><div align = right><g:formatNumber number="${kreditInstance.mtlTilg}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>
					</tr>
					</g:if>
				</g:each>
				</tbody>
				<tfoot>
					<tr>
						<td></td>
					
						<td></td>
					
						<td><div align = right><g:message code="kredit.summe.label" default="Summen:" /></div></td>
					
						<td><div align = right><g:formatNumber number="${Kredit.kreditsumme}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>
						
						<td></td>
						
						<td></td>
						
						<td></td>
						
						<td><div align = right><g:formatNumber number="${Kredit.mtlSumme}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>
						
						<td><div align = right><g:formatNumber number="${Kredit.sumZins}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>
						
						<td><div align = right><g:formatNumber number="${Kredit.sumTilg}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>
						
					</tr>
				</tfoot>
			</table>
			<div class="pagination">
				<g:paginate total="${kreditInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
