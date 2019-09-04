
<%@ page import="org.strotmann.immos.Rechnung" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'rechnung.label', default: 'Rechnung')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		</head>
	<body>
		<a href="#list-rechnung" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-rechnung" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
				
			<g:form class="list" controller="rechnung">
		    	<g:actionSubmit action="setImmobilie" value="Selektieren für" />
		    	<g:if test="${session.immobilie == null}">
		    		<g:select id="immobilie" name="immobilie.id" from="${org.strotmann.immos.Immobilie.immobilien}" optionKey="id" required="" value="${session.immobilie}" class="many-to-one" noSelection="['null': '']"/>
		   		</g:if>
		   		<g:else>
		    		${session.immobilie}
		   		</g:else>
		    </g:form>
				
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="rechnung.rechnungssteller.label" default="Rechnungssteller" /></th>
					
						<th><g:message code="rechnung.immobilie.label" default="Immobilie" /></th>
					
						<g:sortableColumn property="rechnungsdatum" title="${message(code: 'rechnung.rechnungsdatum.label', default: 'Rechnungsdatum')}" />
					
						<th><div align = right><g:message code="rechnung.betrag.label" default="Betrag" /></div></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${rechnungInstanceList}" status="i" var="rechnungInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${rechnungInstance.id}">${fieldValue(bean: rechnungInstance, field: "rechnungssteller.partner.name")}</g:link></td>
					
						<td>${fieldValue(bean: rechnungInstance, field: "immobilie")}</td>
					
						<td><g:formatDate date="${rechnungInstance.rechnungsdatum}" format="dd.MM.yyyy"/></td>
					
						<td><div align = right><g:formatNumber number="${rechnungInstance.betrag}" type="number" minFractionDigits="2" format="#,##0.00"/></div></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${rechnungInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
