
<%@ page import="org.strotmann.immos.Mietvertragsstand" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'mietvertragsstand.label', default: 'Mietvertragsstand')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-mietvertragsstand" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-mietvertragsstand" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="mietvertragsstand.mietvertrag.label" default="Mietvertrag" /></th>
					
						<g:sortableColumn property="gueltigAb" title="${message(code: 'mietvertragsstand.gueltigAb.label', default: 'Gueltig Ab')}" />
					
						<g:sortableColumn property="bruttomiete" title="${message(code: 'mietvertragsstand.bruttomiete.label', default: 'Bruttomiete')}" />
					
						<g:sortableColumn property="qmMiete" title="${message(code: 'mietvertragsstand.qmMiete.label', default: 'Qm Miete')}" />
					
						<g:sortableColumn property="nebenkostenpauschale" title="${message(code: 'mietvertragsstand.nebenkostenpauschale.label', default: 'Nebenkostenpauschale')}" />
					
						<g:sortableColumn property="heizkostenpauschale" title="${message(code: 'mietvertragsstand.heizkostenpauschale.label', default: 'Heizkostenpauschale')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${mietvertragsstandInstanceList}" status="i" var="mietvertragsstandInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${mietvertragsstandInstance.id}">${fieldValue(bean: mietvertragsstandInstance, field: "mietvertrag")}</g:link></td>
					
						<td><g:formatDate date="${mietvertragsstandInstance.gueltigAb}" format="dd.MM.yyyy"/></td>
					
						<td><g:formatNumber number="${mietvertragsstandInstance.bruttomiete}" type="number" minFractionDigits="2" /></td>
					
						<td><g:formatNumber number="${mietvertragsstandInstance.qmMiete}" type="number" minFractionDigits="2" /></td>
					
						<td><g:formatNumber number="${mietvertragsstandInstance.nebenkostenpauschale}" type="number" minFractionDigits="2" /></td>
					
						<td><g:formatNumber number="${mietvertragsstandInstance.heizkostenpauschale}" type="number" minFractionDigits="2" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${mietvertragsstandInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
