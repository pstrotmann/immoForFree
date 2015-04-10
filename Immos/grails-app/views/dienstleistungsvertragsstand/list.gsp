
<%@ page import="org.strotmann.immos.Dienstleistungsvertragsstand" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'dienstleistungsvertragsstand.label', default: 'Dienstleistungsvertragsstand')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-dienstleistungsvertragsstand" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-dienstleistungsvertragsstand" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="gueltigAb" title="${message(code: 'dienstleistungsvertragsstand.gueltigAb.label', default: 'Gueltig Ab')}" />
					
						<g:sortableColumn property="pauschale" title="${message(code: 'dienstleistungsvertragsstand.pauschale.label', default: 'Pauschale')}" />
					
						<th><g:message code="dienstleistungsvertragsstand.dienstleistungsvertrag.label" default="Dienstleistungsvertrag" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${dienstleistungsvertragsstandInstanceList}" status="i" var="dienstleistungsvertragsstandInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${dienstleistungsvertragsstandInstance.id}"><g:formatDate date="${dienstleistungsvertragsstandInstance?.gueltigAb}" format="dd.MM.yyyy"/></g:link></td>
					
						<td>${fieldValue(bean: dienstleistungsvertragsstandInstance, field: "pauschale")}</td>
					
						<td>${fieldValue(bean: dienstleistungsvertragsstandInstance, field: "dienstleistungsvertrag")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${dienstleistungsvertragsstandInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
