
<%@ page import="org.strotmann.immos.Zaehler" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'zaehler.label', default: 'Zähler')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-zaehler" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-zaehler" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="zaehlernummer" title="${message(code: 'zaehler.zaehlernummer.label', default: 'Zählernummer')}" />
					
						<g:sortableColumn property="zaehlertyp" title="${message(code: 'zaehler.zaehlertyp.label', default: 'Zählertyp')}" />
					
						<g:sortableColumn property="zaehlereinheit" title="${message(code: 'zaehler.zaehlereinheit.label', default: 'Zählereinheit')}" />
					
						<th><g:message code="zaehler.immobilie.label" default="Immobilie" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${zaehlerInstanceList}" status="i" var="zaehlerInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${zaehlerInstance.id}">${fieldValue(bean: zaehlerInstance, field: "zaehlernummer")}</g:link></td>
					
						<td>${fieldValue(bean: zaehlerInstance, field: "zaehlertyp")}</td>
					
						<td>${fieldValue(bean: zaehlerInstance, field: "zaehlereinheit")}</td>
					
						<td>${fieldValue(bean: zaehlerInstance, field: "immobilie")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${zaehlerInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
