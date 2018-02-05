
<%@ page import="org.strotmann.immos.Rechnung" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'rechnung.label', default: 'Rechnung')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-rechnung" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-rechnung" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list rechnung">
			
				<g:if test="${rechnungInstance?.rechnungssteller}">
				<li class="fieldcontain">
					<span id="rechnungssteller-label" class="property-label"><g:message code="rechnung.rechnungssteller.label" default="Rechnungssteller" /></span>
					
						<span class="property-value" aria-labelledby="rechnungssteller-label">
						<g:if test="${rechnungInstance?.rechnungssteller?.partner instanceof org.strotmann.immos.Person}">
							<g:link controller="person" action="show" id="${rechnungInstance?.rechnungssteller?.partner.id}">${rechnungInstance?.rechnungssteller?.partner.name.encodeAsHTML()}</g:link>
						</g:if>
						<g:if test="${rechnungInstance?.rechnungssteller?.partner instanceof org.strotmann.immos.Organisation}">
							<g:link controller="organisation" action="show" id="${rechnungInstance?.rechnungssteller?.partner.id}">${rechnungInstance?.rechnungssteller?.partner.name.encodeAsHTML()}</g:link>
						</g:if>
						</span>
				</li>
				</g:if>
			
				<g:if test="${rechnungInstance?.immobilie}">
				<li class="fieldcontain">
					<span id="immobilie-label" class="property-label"><g:message code="rechnung.immobilie.label" default="Immobilie" /></span>
					
						<span class="property-value" aria-labelledby="immobilie-label"><g:link controller="immobilie" action="show" id="${rechnungInstance?.immobilie?.id}">${rechnungInstance?.immobilie?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${rechnungInstance?.rechnungsdatum}">
				<li class="fieldcontain">
					<span id="rechnungsdatum-label" class="property-label"><g:message code="rechnung.rechnungsdatum.label" default="Rechnungsdatum" /></span>
					
						<span class="property-value" aria-labelledby="rechnungsdatum-label"><g:formatDate date="${rechnungInstance?.rechnungsdatum}" format="dd.MM.yyyy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${rechnungInstance?.rechnungsnummer}">
				<li class="fieldcontain">
					<span id="rechnungsnummer-label" class="property-label"><g:message code="rechnung.rechnungsnummer.label" default="Rechnungsnummer" /></span>
					
						<span class="property-value" aria-labelledby="rechnungsnummer-label"><g:fieldValue bean="${rechnungInstance}" field="rechnungsnummer"/></span>
					
				</li>
				</g:if>
							
				<g:if test="${rechnungInstance?.rechnungsgegenstand}">
				<li class="fieldcontain">
					<span id="rechnungsgegenstand-label" class="property-label"><g:message code="rechnung.rechnungsgegenstand.label" default="Rechnungsgegenstand" /></span>
					
						<span class="property-value" aria-labelledby="rechnungsgegenstand-label"><g:fieldValue bean="${rechnungInstance}" field="rechnungsgegenstand"/></span>
					
				</li>
				</g:if>
								
				<g:if test="${rechnungInstance?.betrag}">
				<li class="fieldcontain">
					<span id="betrag-label" class="property-label"><g:message code="rechnung.betrag.label" default="Betrag" /></span>
					
						<span class="property-value" aria-labelledby="betrag-label"><g:fieldValue bean="${rechnungInstance}" field="betrag"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${rechnungInstance?.bruttoBetrag}">
				<li class="fieldcontain">
					<span id="bruttoBetrag-label" class="property-label"><g:message code="rechnung.bruttoBetrag.label" default="Brutto Betrag" /></span>
					
						<span class="property-value" aria-labelledby="bruttoBetrag-label"><g:fieldValue bean="${rechnungInstance}" field="bruttoBetrag"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${rechnungInstance?.nettoBetrag}">
				<li class="fieldcontain">
					<span id="nettoBetrag-label" class="property-label"><g:message code="rechnung.nettoBetrag.label" default="Netto Betrag" /></span>
					
						<span class="property-value" aria-labelledby="nettoBetrag-label"><g:fieldValue bean="${rechnungInstance}" field="nettoBetrag"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${rechnungInstance?.mehrwertsteuerSatz}">
				<li class="fieldcontain">
					<span id="mehrwertsteuerSatz-label" class="property-label"><g:message code="rechnung.mehrwertsteuerSatz.label" default="Mehrwertsteuer Satz" /></span>
					
						<span class="property-value" aria-labelledby="mehrwertsteuerSatz-label"><g:fieldValue bean="${rechnungInstance}" field="mehrwertsteuerSatz"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${rechnungInstance?.mehrwertsteuer}">
				<li class="fieldcontain">
					<span id="mehrwertsteuer-label" class="property-label"><g:message code="rechnung.mehrwertsteuer.label" default="Mehrwertsteuer" /></span>
					
						<span class="property-value" aria-labelledby="mehrwertsteuer-label"><g:fieldValue bean="${rechnungInstance}" field="mehrwertsteuer"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${rechnungInstance?.skontoSatz}">
				<li class="fieldcontain">
					<span id="skontoSatz-label" class="property-label"><g:message code="rechnung.skontoSatz.label" default="Skonto Satz" /></span>
					
						<span class="property-value" aria-labelledby="skontoSatz-label"><g:fieldValue bean="${rechnungInstance}" field="skontoSatz"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${rechnungInstance?.skonto}">
				<li class="fieldcontain">
					<span id="skonto-label" class="property-label"><g:message code="rechnung.skonto.label" default="Skonto" /></span>
					
						<span class="property-value" aria-labelledby="skonto-label"><g:fieldValue bean="${rechnungInstance}" field="skonto"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${rechnungInstance?.auftragsnummer}">
				<li class="fieldcontain">
					<span id="auftragsnummer-label" class="property-label"><g:message code="rechnung.auftragsnummer.label" default="Auftragsnummer" /></span>
					
						<span class="property-value" aria-labelledby="auftragsnummer-label"><g:fieldValue bean="${rechnungInstance}" field="auftragsnummer"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${rechnungInstance?.kundennummer}">
				<li class="fieldcontain">
					<span id="kundennummer-label" class="property-label"><g:message code="rechnung.kundennummer.label" default="Kundennummer" /></span>
					
						<span class="property-value" aria-labelledby="kundennummer-label"><g:fieldValue bean="${rechnungInstance}" field="kundennummer"/></span>
					
				</li>
				</g:if>
										
				<li class="fieldcontain">
					<span id="umlagefaehig-label" class="property-label"><g:message code="rechnung.umlagefaehig.label" default="Umlagefähig" /></span>
					
						<span class="property-value" aria-labelledby="umlagefaehig-label"><g:formatBoolean boolean="${rechnungInstance?.umlagefaehig}" true="Ja" false="Nein"/></span>
					
				</li>
				
				<g:if test="${rechnungInstance?.umlageinfos}">
				<li class="fieldcontain">
					<span id="umlageinfo-label" class="property-label"><g:message code="rechnung.umlageinfo.label" default="Umlageinfo" /></span>
					
						<g:each in="${rechnungInstance.umlageinfos}" var="u">
						<span class="property-value" aria-labelledby="umlageinfo-label"><g:link controller="umlageinfo" action="show" id="${u.id}">${u?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
				
				<g:if test="${rechnungInstance?.zahlungen}">
				<li class="fieldcontain">
					<span id="zahlungen-label" class="property-label"><g:message code="rechnung.zahlungen.label" default="Zahlungen" /></span>
					
						<g:each in="${rechnungInstance.zahlungen}" var="z">
						<span class="property-value" aria-labelledby="zahlungen-label"><g:link controller="zahlung" action="show" id="${z.id}">${z?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
				
				<li class="fieldcontain">
					<span id="notizen-label" class="property-label"><g:message code="rechnung.notizen.label" default="Notizen" /></span>
					
						<g:each in="${org.strotmann.immos.Notiz.getNotizen('Rechnung',rechnungInstance.id)}" var="n">
						<span class="property-value" aria-labelledby="notizen-label"><g:link controller="notiz" action="show" id="${n.id}">${n}</g:link></span>
						</g:each>
				</li>
			
			</ol>
			<g:form url="[resource:rechnungInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${rechnungInstance?.id}" />
					<g:link class="edit" action="edit" id="${rechnungInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit method="DELETE" class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
