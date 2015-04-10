
<%@ page import="org.strotmann.immos.Zwischenzaehler" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'zwischenzaehler.label', default: 'Zwischenzähler')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-zwischenzaehler" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-zwischenzaehler" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="zaehlernummer" title="${message(code: 'zwischenzaehler.zaehlernummer.label', default: 'Zählernummer')}" />
					
						<th><g:message code="zwischenzaehler.mietsache.label" default="Mietsache" /></th>
					
						<th><g:message code="zwischenzaehler.zaehler.label" default="Zähler" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${zwischenzaehlerInstanceList}" status="i" var="zwischenzaehlerInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${zwischenzaehlerInstance.id}">${fieldValue(bean: zwischenzaehlerInstance, field: "zaehlernummer")}</g:link></td>
					
						<td>${fieldValue(bean: zwischenzaehlerInstance, field: "mietsache")}</td>
					
						<td>${fieldValue(bean: zwischenzaehlerInstance, field: "zaehler")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${zwischenzaehlerInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
