
<%@ page import="org.strotmann.immos.Umlageinfo" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'umlageinfo.label', default: 'Umlageinfo')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-umlageinfo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-umlageinfo" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list umlageinfo">
			
				<g:if test="${umlageinfoInstance?.von}">
				<li class="fieldcontain">
					<span id="von-label" class="property-label"><g:message code="umlageinfo.von.label" default="Von" /></span>
					
						<span class="property-value" aria-labelledby="von-label"><g:formatDate date="${umlageinfoInstance?.von}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${umlageinfoInstance?.bis}">
				<li class="fieldcontain">
					<span id="bis-label" class="property-label"><g:message code="umlageinfo.bis.label" default="Bis" /></span>
					
						<span class="property-value" aria-labelledby="bis-label"><g:formatDate date="${umlageinfoInstance?.bis}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${umlageinfoInstance?.kostenart}">
				<li class="fieldcontain">
					<span id="kostenart-label" class="property-label"><g:message code="umlageinfo.kostenart.label" default="Kostenart" /></span>
					
						<span class="property-value" aria-labelledby="kostenart-label"><g:fieldValue bean="${umlageinfoInstance}" field="kostenart"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${umlageinfoInstance?.umlageschluessel}">
				<li class="fieldcontain">
					<span id="umlageschluessel-label" class="property-label"><g:message code="umlageinfo.umlageschluessel.label" default="Umlageschluessel" /></span>
					
						<span class="property-value" aria-labelledby="umlageschluessel-label"><g:fieldValue bean="${umlageinfoInstance}" field="umlageschluessel"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${umlageinfoInstance?.umlageAuf}">
				<li class="fieldcontain">
					<span id="umlageAuf-label" class="property-label"><g:message code="umlageinfo.umlageAuf.label" default="Umlage Auf" /></span>
					
						<span class="property-value" aria-labelledby="umlageAuf-label"><g:link controller="mietsache" action="show" id="${umlageinfoInstance?.umlageAuf?.id}">${umlageinfoInstance?.umlageAuf?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${umlageinfoInstance?.teilbescheidVon}">
				<li class="fieldcontain">
					<span id="teilbescheidVon-label" class="property-label"><g:message code="umlageinfo.teilbescheidVon.label" default="Teilbescheid Von" /></span>
					
						<span class="property-value" aria-labelledby="teilbescheidVon-label"><g:link controller="dienstleistungsvertrag" action="show" id="${umlageinfoInstance?.teilbescheidVon?.id}">${umlageinfoInstance?.teilbescheidVon?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${umlageinfoInstance?.rechnung}">
				<li class="fieldcontain">
					<span id="rechnung-label" class="property-label"><g:message code="umlageinfo.rechnung.label" default="Rechnung" /></span>
					
						<span class="property-value" aria-labelledby="rechnung-label"><g:link controller="rechnung" action="show" id="${umlageinfoInstance?.rechnung?.id}">${umlageinfoInstance?.rechnung?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:umlageinfoInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${umlageinfoInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
