
<%@ page import="org.strotmann.immos.Matchcode" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'matchcode.label', default: 'Matchcode')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-matchcode" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-matchcode" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
						<g:sortableColumn property="name" title="${message(code: 'matchcode.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="vorname" title="${message(code: 'matchcode.vorname.label', default: ' ')}" />
						
						<g:sortableColumn property="strasse" title="${message(code: 'matchcode.strasse.label', default: 'Strasse')}" />
						
						<g:sortableColumn property="postleitzahl" title="${message(code: 'matchcode.postleitzahl.label', default: 'Plz')}" />
						
						<g:sortableColumn property="ort" title="${message(code: 'matchcode.ort.label', default: 'Ort')}" />
						
					</tr>
				</thead>
				<tbody>
				<g:each in="${matchcodeInstanceList}" status="i" var="matchcodeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td>
						<g:if test="${matchcodeInstance.partnerart == 'p'}">
						<g:link controller="person" action="show" id="${matchcodeInstance.id}">${fieldValue(bean: matchcodeInstance, field: "name")}</g:link>
						</g:if>
						<g:if test="${matchcodeInstance.partnerart == 'o'}">
						<g:link controller="organisation" action="show" id="${matchcodeInstance.id}">${fieldValue(bean: matchcodeInstance, field: "name")}</g:link>
						</g:if>
						</td>
					
						<td>${fieldValue(bean: matchcodeInstance, field: "vorname")}</td>
						
						<td>${fieldValue(bean: matchcodeInstance, field: "strasse")}</td>
						
						<td>${fieldValue(bean: matchcodeInstance, field: "postleitzahl")}</td>
						
						<td>${fieldValue(bean: matchcodeInstance, field: "ort")}</td>
											
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${matchcodeInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
