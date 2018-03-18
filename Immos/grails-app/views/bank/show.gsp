
<%@ page import="org.strotmann.immos.Bank" %>
<%@ page import="org.strotmann.util.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'bank.label', default: 'Bank')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-bank" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.matchcode.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-bank" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list bank">
			
				
				<g:if test="${bankInstance?.bic}">
				<li class="fieldcontain">
					<span id="bic-label" class="property-label"><g:message code="bank.bic.label" default="Bic" /></span>
					
						<span class="property-value" aria-labelledby="bic-label"><g:fieldValue bean="${bankInstance}" field="bic"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bankInstance?.blz}">
				<li class="fieldcontain">
					<span id="blz-label" class="property-label"><g:message code="bank.blz.label" default="Blz" /></span>
					
						<span class="property-value" aria-labelledby="blz-label"><g:fieldValue bean="${bankInstance}" field="blz"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${bankInstance?.bankname}">
				<li class="fieldcontain">
					<span id="bankname-label" class="property-label"><g:message code="bank.bankname.label" default="Bankname" /></span>
					
						<span class="property-value" aria-labelledby="bankname-label"><g:fieldValue bean="${bankInstance}" field="bankname"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bankInstance?.plz}">
				<li class="fieldcontain">
					<span id="plz-label" class="property-label"><g:message code="bank.plz.label" default="Plz" /></span>
					
						<span class="property-value" aria-labelledby="plz-label"><g:fieldValue bean="${bankInstance}" field="plz"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${bankInstance?.ort}">
				<li class="fieldcontain">
					<span id="ort-label" class="property-label"><g:message code="bank.ort.label" default="Ort" /></span>
					
						<span class="property-value" aria-labelledby="ort-label"><g:fieldValue bean="${bankInstance}" field="ort"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<span id="bankverbindung-label" class="property-label"><g:message code="bank.bankverbindung.label" default="Bankverbindungen" /></span>
					
			<g:each in="${bankInstance.bankverbindungen}" var="b">
			<p><span class="property-value" aria-labelledby="bankverbindung-label"><g:link controller="bankverbindung" action="show" id="${b.id}">${IBAN.ibanForm(b?.iban).encodeAsHTML()} ${b.partner.name}</g:link></span></p>
			</g:each>
			
			</div>
	</body>
</html>
