
<%@ page import="org.strotmann.immos.Betriebskostenabrechnungsbrief" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'betriebskostenabrechnungsbrief.label', default: 'Betriebskostenabrechnungsbrief')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-betriebskostenabrechnungsbrief" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-betriebskostenabrechnungsbrief" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="adressAnrede" title="${message(code: 'betriebskostenabrechnungsbrief.adressAnrede.label', default: 'Adress Anrede')}" />
					
						<g:sortableColumn property="adressName" title="${message(code: 'betriebskostenabrechnungsbrief.adressName.label', default: 'Adress Name')}" />
					
						<g:sortableColumn property="anredeName" title="${message(code: 'betriebskostenabrechnungsbrief.anredeName.label', default: 'Anrede Name')}" />
					
						<g:sortableColumn property="bankname" title="${message(code: 'betriebskostenabrechnungsbrief.bankname.label', default: 'Bankname')}" />
					
						<th><g:message code="betriebskostenabrechnungsbrief.betriebskostenabrechnung.label" default="Betriebskostenabrechnung" /></th>
					
						<g:sortableColumn property="blz" title="${message(code: 'betriebskostenabrechnungsbrief.blz.label', default: 'Blz')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${betriebskostenabrechnungsbriefInstanceList}" status="i" var="betriebskostenabrechnungsbriefInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${betriebskostenabrechnungsbriefInstance.id}">${fieldValue(bean: betriebskostenabrechnungsbriefInstance, field: "adressAnrede")}</g:link></td>
					
						<td>${fieldValue(bean: betriebskostenabrechnungsbriefInstance, field: "adressName")}</td>
					
						<td>${fieldValue(bean: betriebskostenabrechnungsbriefInstance, field: "anredeName")}</td>
					
						<td>${fieldValue(bean: betriebskostenabrechnungsbriefInstance, field: "bankname")}</td>
					
						<td>${fieldValue(bean: betriebskostenabrechnungsbriefInstance, field: "betriebskostenabrechnung")}</td>
					
						<td>${fieldValue(bean: betriebskostenabrechnungsbriefInstance, field: "blz")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${betriebskostenabrechnungsbriefInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
