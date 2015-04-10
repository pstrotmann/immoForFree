
<%@ page import="org.strotmann.immos.Notiz" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'notiz.label', default: 'Notiz')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-notiz" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="show" action="find"><g:message code="default.mcSuch.label" args="[entityName]" /></g:link></li>
				<li>
					<div class="fieldcontain" >
						<g:form action="index" >
							<fieldset class="form">
								<g:actionSubmit action= "create" value="Notiz anlegen für" />
								<g:select name="domName" from="${Notiz.domNamen}" value="it"/>
							</fieldset>	
						</g:form>
					</div>
				</li>
			</ul>
		</div>
		
		<div id="list-notiz" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="anlagetermin" title="${message(code: 'notiz.anlagetermin.label', default: 'Anlagetermin')}" />
					
						<g:sortableColumn property="notiztext" title="${message(code: 'notiz.notiztext.label', default: 'Notiztext')}" />
					
						<g:sortableColumn property="referenz" title="${message(code: 'notiz.referenz.label', default: 'Referenz')}" />
					
						<g:sortableColumn property="wiedervorlagetermin" title="${message(code: 'notiz.wiedervorlagetermin.label', default: 'Wiedervorlagetermin')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${notizInstanceList}" status="i" var="notizInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${notizInstance.id}"><g:formatDate date="${notizInstance.anlagetermin}" format="dd.MM.yyyy" /></g:link></td>
					
						<td>${fieldValue(bean: notizInstance, field: "notiztext")}</td>
					
						<td>${fieldValue(bean: notizInstance, field: "referenz")}</td>
					
						<td><g:formatDate date="${notizInstance.wiedervorlagetermin}" format="dd.MM.yyyy" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${notizInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
