
<%@ page import="org.strotmann.immos.Dienstleistungsvertrag" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'dienstleistungsvertrag.label', default: 'Dienstleistungsvertrag')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-dienstleistungsvertrag" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-dienstleistungsvertrag" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list dienstleistungsvertrag">
			
				<g:if test="${dienstleistungsvertragInstance?.dienstleister}">
				<li class="fieldcontain">
					<span id="partnerrolle-label" class="property-label"><g:message code="dienstleistungsvertrag.dienstleister.label" default="Dienstleister" /></span>
					
						<span class="property-value" aria-labelledby="dienstleister-label">
						<g:if test="${dienstleistungsvertragInstance?.dienstleister?.partner instanceof org.strotmann.immos.Person}">
							<g:link controller="person" action="show" id="${dienstleistungsvertragInstance?.dienstleister?.partner.id}">${dienstleistungsvertragInstance?.dienstleister?.partner.name.encodeAsHTML()}</g:link>
						</g:if>
						<g:if test="${dienstleistungsvertragInstance?.dienstleister?.partner instanceof org.strotmann.immos.Organisation}">
							<g:link controller="organisation" action="show" id="${dienstleistungsvertragInstance?.dienstleister?.partner.id}">${dienstleistungsvertragInstance?.dienstleister?.partner.name.encodeAsHTML()}</g:link>
						</g:if>
						</span>
					
				</li>
				</g:if>
			
				<g:if test="${dienstleistungsvertragInstance?.immobilie}">
				<li class="fieldcontain">
					<span id="immobilie-label" class="property-label"><g:message code="dienstleistungsvertrag.immobilie.label" default="Immobilie" /></span>
					
						<span class="property-value" aria-labelledby="immobilie-label"><g:link controller="immobilie" action="show" id="${dienstleistungsvertragInstance?.immobilie?.id}">${dienstleistungsvertragInstance?.immobilie?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${dienstleistungsvertragInstance?.dienstleistungsart}">
				<li class="fieldcontain">
					<span id="dienstleistungsart-label" class="property-label"><g:message code="dienstleistungsvertrag.dienstleistungsart.label" default="Dienstleistungsart" /></span>
					
						<span class="property-value" aria-labelledby="dienstleistungsart-label"><g:fieldValue bean="${dienstleistungsvertragInstance}" field="dienstleistungsart"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${dienstleistungsvertragInstance?.vertragsnummer}">
				<li class="fieldcontain">
					<span id="vertragsnummer-label" class="property-label"><g:message code="dienstleistungsvertrag.vertragsnummer.label" default="Vertragsnummer" /></span>
					
						<span class="property-value" aria-labelledby="vertragsnummer-label"><g:fieldValue bean="${dienstleistungsvertragInstance}" field="vertragsnummer"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${dienstleistungsvertragInstance?.kundennummer}">
				<li class="fieldcontain">
					<span id="kundennummer-label" class="property-label"><g:message code="dienstleistungsvertrag.kundennummer.label" default="Kundennummer" /></span>
					
						<span class="property-value" aria-labelledby="kundennummer-label"><g:fieldValue bean="${dienstleistungsvertragInstance}" field="kundennummer"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${dienstleistungsvertragInstance?.referenz}">
				<li class="fieldcontain">
					<span id="referenz-label" class="property-label"><g:message code="dienstleistungsvertrag.referenz.label" default="Referenz" /></span>
					
						<span class="property-value" aria-labelledby="referenz-label"><g:fieldValue bean="${dienstleistungsvertragInstance}" field="referenz"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${dienstleistungsvertragInstance?.vertragsbeginn}">
				<li class="fieldcontain">
					<span id="vertragsbeginn-label" class="property-label"><g:message code="dienstleistungsvertrag.vertragsbeginn.label" default="Vertragsbeginn" /></span>
					
						<span class="property-value" aria-labelledby="vertragsbeginn-label"><g:formatDate date="${dienstleistungsvertragInstance?.vertragsbeginn}" format="dd.MM.yyyy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${dienstleistungsvertragInstance?.vertragsende}">
				<li class="fieldcontain">
					<span id="vertragsende-label" class="property-label"><g:message code="dienstleistungsvertrag.vertragsende.label" default="Vertragsende" /></span>
					
						<span class="property-value" aria-labelledby="vertragsende-label"><g:formatDate date="${dienstleistungsvertragInstance?.vertragsende}" format="dd.MM.yyyy"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${dienstleistungsvertragInstance?.autoVerlJahre}">
				<li class="fieldcontain">
					<span id="autoVerlJahre-label" class="property-label"><g:message code="dienstleistungsvertrag.autoVerlJahre.label" default="automatische Verlängerung in Jahren" /></span>
					
						<span class="property-value" aria-labelledby="autoVerlJahre-label"><g:fieldValue bean="${dienstleistungsvertragInstance}" field="autoVerlJahre"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${dienstleistungsvertragInstance?.kueWochen}">
				<li class="fieldcontain">
					<span id="kueWochen-label" class="property-label"><g:message code="dienstleistungsvertrag.kueWochen.label" default="Kündigung vor Ablauf in Wochen" /></span>
					
						<span class="property-value" aria-labelledby="kueWochen-label"><g:fieldValue bean="${dienstleistungsvertragInstance}" field="kueWochen"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${dienstleistungsvertragInstance?.zahlweise}">
				<li class="fieldcontain">
					<span id="zahlweise-label" class="property-label"><g:message code="dienstleistungsvertrag.zahlweise.label" default="Zahlweise" /></span>
					
						<span class="property-value" aria-labelledby="zahlweise-label"><g:fieldValue bean="${dienstleistungsvertragInstance}" field="zahlweiseKlar"/></span>
					
				</li>
				</g:if>
				
				<li class="fieldcontain">
					<span id="umlagefaehig-label" class="property-label"><g:message code="rechnung.umlagefaehig.label" default="Umlagefähig" /></span>
					
						<span class="property-value" aria-labelledby="umlagefaehig-label"><g:formatBoolean boolean="${dienstleistungsvertragInstance?.umlagefaehig}" false="Nein" true="ja"/></span>
					
				</li>
				
				<g:if test="${dienstleistungsvertragInstance?.vertragsstaende}">
				<li class="fieldcontain">
					<span id="vertragsstaende-label" class="property-label"><g:message code="dienstleistungsvertrag.vertragsstaende.label" default="Vertragsstaende" /></span>
					
						<g:each in="${dienstleistungsvertragInstance.vertragsstaende}" var="v">
						<span class="property-value" aria-labelledby="vertragsstaende-label"><g:link controller="dienstleistungsvertragsstand" action="show" id="${v.id}">${v?.vstandKurz}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${dienstleistungsvertragInstance?.zahlungen}">
				<li class="fieldcontain">
					<span id="zahlungen-label" class="property-label"><g:message code="dienstleistungsvertrag.zahlungen.label" default="Zahlungen" /></span>
					
						<g:each in="${dienstleistungsvertragInstance.zahlungen}" var="z">
						<span class="property-value" aria-labelledby="zahlungen-label"><g:link controller="zahlung" action="show" id="${z.id}">${z?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
				
				<li class="fieldcontain">
					<span id="notizen-label" class="property-label"><g:message code="dienstleistungsvertrag.notizen.label" default="Notizen" /></span>
					
						<g:each in="${org.strotmann.immos.Notiz.getNotizen('Dienstleistungsvertrag',dienstleistungsvertragInstance.id)}" var="n">
						<span class="property-value" aria-labelledby="notizen-label"><g:link controller="notiz" action="show" id="${n.id}">${n}</g:link></span>
						</g:each>
				</li>
				
			</ol>
			<g:form url="[resource:dienstleistungsvertragInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${dienstleistungsvertragInstance?.id}" />
					<g:link class="edit" action="edit" id="${dienstleistungsvertragInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit method="delete" class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
