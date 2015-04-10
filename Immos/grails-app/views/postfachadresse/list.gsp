
<%@ page import="org.strotmann.immos.Postfachadresse" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'postfachadresse.label', default: 'Postfachadresse')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-postfachadresse" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-postfachadresse" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="postfach" title="${message(code: 'postfachadresse.postfach.label', default: 'Postfach')}" />
					
						<g:sortableColumn property="postleitzahl" title="${message(code: 'postfachadresse.postleitzahl.label', default: 'Postleitzahl')}" />
					
						<g:sortableColumn property="ort" title="${message(code: 'postfachadresse.ort.label', default: 'Ort')}" />
					
						<th><g:message code="postfachadresse.organisation.label" default="Organisation" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${postfachadresseInstanceList}" status="i" var="postfachadresseInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${postfachadresseInstance.id}">${fieldValue(bean: postfachadresseInstance, field: "postfach")}</g:link></td>
					
						<td>${fieldValue(bean: postfachadresseInstance, field: "postleitzahl")}</td>
					
						<td>${fieldValue(bean: postfachadresseInstance, field: "ort")}</td>
					
						<td>${fieldValue(bean: postfachadresseInstance, field: "organisation")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${postfachadresseInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
