
<%@ page import="org.strotmann.immos.Umlage" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'umlage.label', default: 'Umlage')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-umlage" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-umlage" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list umlage">
			
				<g:if test="${umlageInstance?.kostenart}">
				<li class="fieldcontain">
					<span id="kostenart-label" class="property-label"><g:message code="umlage.kostenart.label" default="Kostenart" /></span>
					
						<span class="property-value" aria-labelledby="kostenart-label"><g:fieldValue bean="${umlageInstance}" field="kostenart"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${umlageInstance?.umlageschluessel}">
				<li class="fieldcontain">
					<span id="umlageschluessel-label" class="property-label"><g:message code="umlage.umlageschluessel.label" default="Umlageschluessel" /></span>
					
						<span class="property-value" aria-labelledby="umlageschluessel-label"><g:fieldValue bean="${umlageInstance}" field="umlageschluessel"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${umlageInstance?.betrag}">
				<li class="fieldcontain">
					<span id="betrag-label" class="property-label"><g:message code="umlage.betrag.label" default="Betrag" /></span>
					
						<span class="property-value" aria-labelledby="betrag-label"><g:formatNumber number="${umlageInstance.betrag}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${umlageInstance?.betragOhneZZ}">
				<li class="fieldcontain">
					<span id="betragOhneZZ-label" class="property-label"><g:message code="umlage.betragOhneZZ.label" default="Betrag ohne Zwischenzähler" /></span>
					
						<span class="property-value" aria-labelledby="betragOhneZZ-label"><g:formatNumber number="${umlageInstance.betragOhneZZ}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${umlageInstance?.ZVerbrauch}">
				<li class="fieldcontain">
					<span id="ZVerbrauch-label" class="property-label"><g:message code="umlage.ZVerbrauch.label" default="Verbrauch" /></span>
					
						<span class="property-value" aria-labelledby="ZVerbrauch-label"><g:fieldValue bean="${umlageInstance}" field="ZVerbrauch"/> <g:fieldValue bean="${umlageInstance}" field="zaehler.zaehlereinheit"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${umlageInstance?.zzVerbrauch}">
				<li class="fieldcontain">
					<span id="zzVerbrauch-label" class="property-label"><g:message code="umlage.zzVerbrauch.label" default="Verbrauch Zwischenzähler" /></span>
					
						<span class="property-value" aria-labelledby="zzVerbrauch-label"><g:fieldValue bean="${umlageInstance}" field="zzVerbrauch"/> <g:fieldValue bean="${umlageInstance}" field="zaehler.zaehlereinheit"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${umlageInstance?.zaehler}">
				<li class="fieldcontain">
					<span id="zaehler-label" class="property-label"><g:message code="umlage.zaehler.label" default="Zähler" /></span>
					
						<span class="property-value" aria-labelledby="zaehler-label"><g:link controller="zaehler" action="show" id="${umlageInstance?.zaehler?.id}">${umlageInstance?.zaehler?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${umlageInstance?.immoabrechnung}">
				<li class="fieldcontain">
					<span id="immoabrechnung-label" class="property-label"><g:message code="umlage.immoabrechnung.label" default="Immoabrechnung" /></span>
					
						<span class="property-value" aria-labelledby="immoabrechnung-label"><g:link controller="immoabrechnung" action="show" id="${umlageInstance?.immoabrechnung?.id}">${umlageInstance?.immoabrechnung?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
				
				<g:if test="${umlageInstance?.umlageanteile}">
				<li class="fieldcontain">
					<span id="umlageanteile-label" class="property-label"><g:message code="umlage.umlageanteile.label" default="umlageanteile" /></span>
					
						<g:each in="${umlageInstance.umlageanteile}" var="n">
						<span class="property-value" aria-labelledby="umlageanteile-label"><g:link controller="nebenkostenabrechnung" action="show" id="${n.id}">${n?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:umlageInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${umlageInstance?.id}" />
					<g:link class="edit" action="edit" id="${umlageInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
