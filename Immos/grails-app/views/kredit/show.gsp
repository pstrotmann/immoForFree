
<%@ page import="org.strotmann.immos.Kredit" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'kredit.label', default: 'Kredit')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-kredit" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-kredit" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list kredit">
			
				<g:if test="${kreditInstance?.kreditgeber}">
				<li class="fieldcontain">
					<span id="kreditgeber-label" class="property-label"><g:message code="kredit.kreditgeber.label" default="Kreditgeber" /></span>
					
						<span class="property-value" aria-labelledby="kreditgeber-label"><g:link controller="partnerrolle" action="show" id="${kreditInstance?.kreditgeber?.id}">${kreditInstance?.kreditgeber?.partner.name}</g:link></span>
					
				</li>
				</g:if>
		
				<g:if test="${kreditInstance?.verwendungen}">
				<li class="fieldcontain">
					<span id="verwendungen-label" class="property-label"><g:message code="kredit.verwendungen.label" default="Verwendungen" /></span>
					
						<g:each in="${kreditInstance.verwendungen}" var="v">
						<span class="property-value" aria-labelledby="verwendungen-label"><g:link controller="verwendung" action="show" id="${v.id}">${v?.immoString.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
				
				<g:if test="${kreditInstance?.besicherungen}">
				<li class="fieldcontain">
					<span id="besicherungen-label" class="property-label"><g:message code="kredit.besicherungen.label" default="Besicherungen" /></span>
					
						<g:each in="${kreditInstance.besicherungen}" var="b">
						<span class="property-value" aria-labelledby="besicherungen-label"><g:link controller="besicherung" action="show" id="${b.id}">${b?.grString.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
				
				<g:if test="${kreditInstance?.vertragsnummer}">
				<li class="fieldcontain">
					<span id="vertragsnummer-label" class="property-label"><g:message code="kredit.vertragsnummer.label" default="Vertragsnummer" /></span>
					
						<span class="property-value" aria-labelledby="vertragsnummer-label"><g:fieldValue bean="${kreditInstance}" field="vertragsnummer"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${kreditInstance?.betrag}">
				<li class="fieldcontain">
					<span id="betrag-label" class="property-label"><g:message code="kredit.betrag.label" default="bewilligtes Darlehen" /></span>
					
						<span class="property-value" aria-labelledby="betrag-label"><g:fieldValue bean="${kreditInstance}" field="betrag"/></span>
					
				</li>
				</g:if>
				
				<li class="fieldcontain">
					<span id="kreditsaldo-label" class="property-label"><g:message code="kredit.kreditsaldo.label" default="Kreditsaldo" /></span>
					
						<span class="property-value" aria-labelledby="kreditsaldo-label"><g:formatNumber number="${kreditInstance.kreditsaldo}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></span>
					
				</li>
			
				<g:if test="${kreditInstance?.zahlweise}">
				<li class="fieldcontain">
					<span id="zahlweise-label" class="property-label"><g:message code="kredit.zahlweise.label" default="Zahlweise" /></span>
					
						<span class="property-value" aria-labelledby="zahlweise-label"><g:fieldValue bean="${kreditInstance}" field="zahlweiseKlar"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${kreditInstance?.kreditstaende}">
				<li class="fieldcontain">
					<span id="kreditstaende-label" class="property-label"><g:message code="kredit.kreditstaende.label" default="Kreditstaende" /></span>
					
						<g:each in="${kreditInstance.kreditstaende}" var="k">
						<span class="property-value" aria-labelledby="kreditstaende-label"><g:link controller="kreditstand" action="show" id="${k.id}">${k?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${kreditInstance?.zahlungen}">
				<li class="fieldcontain">
					<span id="zahlungen-label" class="property-label"><g:message code="kredit.zahlungen.label" default="Zahlungen" /></span>
					
						<g:each in="${kreditInstance.zahlungen}" var="z">
						<span class="property-value" aria-labelledby="zahlungen-label"><g:link controller="zahlung" action="show" id="${z.id}">${z?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
				
				<li class="fieldcontain">
					<span id="notizen-label" class="property-label"><g:message code="kredit.notizen.label" default="Notizen" /></span>
					
						<g:each in="${org.strotmann.immos.Notiz.getNotizen('Kredit',kreditInstance.id)}" var="n">
						<span class="property-value" aria-labelledby="notizen-label"><g:link controller="notiz" action="show" id="${n.id}">${n}</g:link></span>
						</g:each>
				</li>
				
			</ol>
			<g:form url="[resource:partnerrolleInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${kreditInstance?.id}" />
					<g:link class="edit" action="edit" id="${kreditInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
