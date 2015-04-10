
<%@ page import="org.strotmann.immos.Hausadresse" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'hausadresse.label', default: 'Hausadresse')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-hausadresse" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-hausadresse" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="strasse" title="${message(code: 'hausadresse.strasse.label', default: 'Strasse')}" />
					
						<g:sortableColumn property="hausnummer" title="${message(code: 'hausadresse.hausnummer.label', default: 'Hausnummer')}" />
					
						<g:sortableColumn property="zusatz" title="${message(code: 'hausadresse.zusatz.label', default: 'Zusatz')}" />
					
						<g:sortableColumn property="postleitzahl" title="${message(code: 'hausadresse.postleitzahl.label', default: 'Postleitzahl')}" />
					
						<g:sortableColumn property="ort" title="${message(code: 'hausadresse.ort.label', default: 'Ort')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${hausadresseInstanceList}" status="i" var="hausadresseInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${hausadresseInstance.id}">${fieldValue(bean: hausadresseInstance, field: "strasse")}</g:link></td>
					
						<td>${fieldValue(bean: hausadresseInstance, field: "hausnummer")}</td>
					
						<td>${fieldValue(bean: hausadresseInstance, field: "zusatz")}</td>
					
						<td>${fieldValue(bean: hausadresseInstance, field: "postleitzahl")}</td>
					
						<td>${fieldValue(bean: hausadresseInstance, field: "ort")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${hausadresseInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
