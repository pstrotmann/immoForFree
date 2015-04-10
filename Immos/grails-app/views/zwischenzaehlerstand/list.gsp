
<%@ page import="org.strotmann.immos.Zwischenzaehlerstand" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'zwischenzaehlerstand.label', default: 'Zwischenzählerstand')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-zwischenzaehlerstand" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-zwischenzaehlerstand" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="ablesedatum" title="${message(code: 'zwischenzaehlerstand.ablesedatum.label', default: 'Ablesedatum')}" />
					
						<g:sortableColumn property="wert" title="${message(code: 'zwischenzaehlerstand.wert.label', default: 'Wert')}" />
					
						<th><g:message code="zwischenzaehlerstand.zz.label" default="Zz" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${zwischenzaehlerstandInstanceList}" status="i" var="zwischenzaehlerstandInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${zwischenzaehlerstandInstance.id}"><g:formatDate date="${zwischenzaehlerstandInstance?.ablesedatum}" format="dd.MM.yyyy"/></g:link></td>
					
						<td>${fieldValue(bean: zwischenzaehlerstandInstance, field: "wert")}</td>
					
						<td>${fieldValue(bean: zwischenzaehlerstandInstance, field: "zz")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${zwischenzaehlerstandInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
