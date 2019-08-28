
<%@ page import="org.strotmann.immos.Bankumsatz" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'bankumsatz.label', default: 'Bankumsatz')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-bankumsatz" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-bankumsatz" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
						<g:sortableColumn property="beguenstigterZahlungspflichtiger" title="${message(code: 'bankumsatz.beguenstigter.label', default: 'Begünstigter')}" />
					
						<g:sortableColumn property="valutadatum" title="${message(code: 'bankumsatz.valutadatum.label', default: 'Valuta')}" />
					
						<g:sortableColumn property="verwendungszweck" title="${message(code: 'bankumsatz.verwendungszweck.label', default: 'Verwendungszweck')}" />
					
						<th><div align = right><g:message code="bankumsatz.betrag.label" default="Betrag" /></div></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${bankumsatzInstanceList}" status="i" var="bankumsatzInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td>
						<g:if test="${bankumsatzInstance.beguenstigterZahlungspflichtiger == ''}" >
							<g:link action="show" id="${bankumsatzInstance.id}">n.n.</g:link>
						</g:if>
						<g:else>
							<g:link action="show" id="${bankumsatzInstance.id}">${fieldValue(bean: bankumsatzInstance, field: "beguenstigterZahlungspflichtiger")}</g:link>
						</g:else>
						</td>
					
						<td>${fieldValue(bean: bankumsatzInstance, field: "valutadatum")}</td>
					
						<g:if test="${bankumsatzInstance.verwendungszweck == ''}" >
							<td>${fieldValue(bean: bankumsatzInstance, field: "buchungstext")}</td>
						</g:if>
						<g:else test="${bankumsatzInstance.verwendungszweck == ''}" >
							<td>${fieldValue(bean: bankumsatzInstance, field: "verwendungszweck")}</td>
						</g:else>
					
						<td><div align = right>${fieldValue(bean: bankumsatzInstance, field: "betrag")}</div></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
		</div>
	</body>
</html>
