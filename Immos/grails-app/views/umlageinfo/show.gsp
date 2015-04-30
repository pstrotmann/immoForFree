
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
			
				<g:if test="${umlageinfoInstance?.rechnung}">
				<li class="fieldcontain">
					<span id="rechnung-label" class="property-label"><g:message code="umlageinfo.rechnung.label" default="Rechnung" /></span>
					<span class="property-value" aria-labelledby="rechnung-label"><g:link controller="rechnung" action="show" id="${umlageinfoInstance?.rechnung.id}">${umlageinfoInstance?.rechnung.reLang}</g:link></span>
				</li>
				</g:if>
				
				<li class="fieldcontain">
					<span id="von-label" class="property-label"><g:message code="umlageinfo.art.label" default="Art" /></span>
					
						<span class="property-value" aria-labelledby="art-label"><g:fieldValue bean="${umlageinfoInstance}" field="art"/></span>
				</li>
				
				<g:if test="${umlageinfoInstance?.von}">
				<li class="fieldcontain">
					<span id="von-label" class="property-label"><g:message code="umlageinfo.von.label" default="Von" /></span>
					
						<span class="property-value" aria-labelledby="von-label"><g:formatDate date="${umlageinfoInstance?.von}" format="dd.MM.yyyy" /></span>
				</li>
				</g:if>
			
				<g:if test="${umlageinfoInstance?.bis}">
				<li class="fieldcontain">
					<span id="bis-label" class="property-label"><g:message code="umlageinfo.bis.label" default="Bis" /></span>
					
						<span class="property-value" aria-labelledby="bis-label"><g:formatDate date="${umlageinfoInstance?.bis}" format="dd.MM.yyyy" /></span>
					
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
				
				<g:if test="${umlageinfoInstance?.verbrauch}">
				<li class="fieldcontain">
					<span id="verbrauch-label" class="property-label"><g:message code="umlageinfo.verbrauch.label" default="Verbrauch" /></span>
					
						<span class="property-value" aria-labelledby="verbrauch-label"><g:fieldValue bean="${umlageinfoInstance}" field="verbrauch"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${umlageinfoInstance?.einheit}">
				<li class="fieldcontain">
					<span id="einheit-label" class="property-label"><g:message code="umlageinfo.einheit.label" default="Einheit" /></span>
					
						<span class="property-value" aria-labelledby="einheit-label"><g:fieldValue bean="${umlageinfoInstance}" field="einheit"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${umlageinfoInstance?.umlageAuf}">
				<li class="fieldcontain">
					<span id="umlageAuf-label" class="property-label"><g:message code="umlageinfo.umlageAuf.label" default="Umlage Auf" /></span>
					
						<span class="property-value" aria-labelledby="umlageAuf-label"><g:link controller="mietsache" action="show" id="${umlageinfoInstance?.umlageAuf?.id}">${umlageinfoInstance?.umlageAuf?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${umlageinfoInstance?.dienstleistungsvertrag}">
				<li class="fieldcontain">
					<span id="dienstleistungsvertrag-label" class="property-label"><g:message code="umlageinfo.dienstleistungsvertrag.label" default="Dienstleistungsvertrag" /></span>
					
						<span class="property-value" aria-labelledby="dienstleistungsvertrag-label"><g:link controller="dienstleistungsvertrag" action="show" id="${umlageinfoInstance?.dienstleistungsvertrag?.id}">${umlageinfoInstance?.dienstleistungsvertrag?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
				
				<g:if test="${umlageinfoInstance?.abrDatum}">
				<li class="fieldcontain">
					<span id="abrDatum-label" class="property-label"><g:message code="umlageinfo.abrDatum.label" default="Abrechnungsdatum" /></span>
					<span class="property-value" aria-labelledby="abrDatum-label"><g:formatDate date="${umlageinfoInstance?.abrDatum}" format="dd.MM.yyyy" /></span>
				</li>
				</g:if>
				
				<g:if test="${umlageinfoInstance?.abrBetrag}">
				<li class="fieldcontain">
					<span id="abrBetrag-label" class="property-label"><g:message code="umlageinfo.abrBetrag.label" default="Abrechnungbetrag" /></span>
					<span class="property-value" aria-labelledby="abrBetrag-label"><g:fieldValue bean="${umlageinfoInstance}" field="abrBetrag"/></span>
				</li>
				</g:if>
				
				<g:if test="${umlageinfoInstance?.abrGegenstand}">
				<li class="fieldcontain">
					<span id="abrGegenstand-label" class="property-label"><g:message code="umlageinfo.abrGegenstand.label" default="Abrechnungsgegenstand" /></span>
					<span class="property-value" aria-labelledby="abrGegenstand-label"><g:fieldValue bean="${umlageinfoInstance}" field="abrGegenstand"/></span>
				</li>
				</g:if>
				
				<li class="fieldcontain">
					<span id="notizen-label" class="property-label"><g:message code="umlageinfo.notizen.label" default="Notizen" /></span>
					
						<g:each in="${org.strotmann.immos.Notiz.getNotizen('Umlageinfo',umlageinfoInstance.id)}" var="n">
						<span class="property-value" aria-labelledby="notizen-label"><g:link controller="notiz" action="show" id="${n.id}">${n}</g:link></span>
						</g:each>
					
				</li>
			
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
