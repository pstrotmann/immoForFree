
<%@ page import="org.strotmann.immos.Umlageinfo" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'umlageinfo.label', default: 'Umlageinfo')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-umlageinfo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-umlageinfo" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="kostenart" title="${message(code: 'umlageinfo.kostenart.label', default: 'Kostenart')}" />
						
						<g:sortableColumn property="art" title="${message(code: 'umlageinfo.art.label', default: 'Art')}" />
					
						<g:sortableColumn property="umlageschluessel" title="${message(code: 'umlageinfo.umlageschluessel.label', default: 'Umlageschluessel')}" />
					
						<g:sortableColumn property="von" title="${message(code: 'umlageinfo.von.label', default: 'Von')}" />
					
						<g:sortableColumn property="bis" title="${message(code: 'umlageinfo.bis.label', default: 'Bis')}" />
						
						<g:sortableColumn property="verbrauch" title="${message(code: 'umlageinfo.verbrauch.label', default: 'Verbrauch')}" />
						
						<g:sortableColumn property="einheit" title="${message(code: 'umlageinfo.einheit.label', default: 'Einheit')}" />
					
						<th><div align = right><g:message code="umlageinfo.betrag.label" default="Betrag" /></div></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${Umlageinfo.infoZuImmoUndArt(params.immoId,params.art)}" status="i" var="umlageinfoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${umlageinfoInstance.id}">${fieldValue(bean: umlageinfoInstance, field: "kostenart")}</g:link></td>
					
						<td>${fieldValue(bean: umlageinfoInstance, field: "art")}</td>
						
						<td>${fieldValue(bean: umlageinfoInstance, field: "umlageschluessel")}</td>
						
						<td><g:formatDate date="${umlageinfoInstance.von}" format="dd.MM.yyyy"/></td>
						
						<td><g:formatDate date="${umlageinfoInstance.bis}" format="dd.MM.yyyy"/></td>
						
						<td>${fieldValue(bean: umlageinfoInstance, field: "verbrauch")}</td>
						
						<td>${fieldValue(bean: umlageinfoInstance, field: "einheit")}</td>
					
						<td><div align = right><g:formatNumber number="${umlageinfoInstance.abrBetrag}" type="number" minFractionDigits="2" format="#,##0.00"/></div></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
		</div>
	</body>
</html>
