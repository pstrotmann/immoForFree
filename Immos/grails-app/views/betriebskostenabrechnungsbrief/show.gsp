
<%@ page import="org.strotmann.immos.Betriebskostenabrechnungsbrief" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'betriebskostenabrechnungsbrief.label', default: 'Betriebskostenabrechnungsbrief')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
		
	</head>
	<body>
		<a href="#show-betriebskostenabrechnungsbrief" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-betriebskostenabrechnungsbrief" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list betriebskostenabrechnungsbrief">
			
				<g:if test="${betriebskostenabrechnungsbriefInstance?.betriebskostenabrechnung}">
				<li class="fieldcontain">
					<span id="betriebskostenabrechnung-label" class="property-label"><g:message code="betriebskostenabrechnungsbrief.betriebskostenabrechnung.label" default="Betriebskostenabrechnung" /></span>
					
						<span class="property-value" aria-labelledby="betriebskostenabrechnung-label"><g:link controller="betriebskostenabrechnung" action="show" id="${betriebskostenabrechnungsbriefInstance?.betriebskostenabrechnung?.id}">${betriebskostenabrechnungsbriefInstance?.betriebskostenabrechnung?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${betriebskostenabrechnungsbriefInstance?.jahr}">
				<li class="fieldcontain">
					<span id="jahr-label" class="property-label"><g:message code="betriebskostenabrechnungsbrief.jahr.label" default="Jahr" /></span>
					
						<span class="property-value" aria-labelledby="jahr-label"><g:fieldValue bean="${betriebskostenabrechnungsbriefInstance}" field="jahr"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${betriebskostenabrechnungsbriefInstance?.briefDatum}">
				<li class="fieldcontain">
					<span id="briefDatum-label" class="property-label"><g:message code="betriebskostenabrechnungsbrief.briefDatum.label" default="Brief Datum" /></span>
					
						<span class="property-value" aria-labelledby="briefDatum-label"><g:fieldValue bean="${betriebskostenabrechnungsbriefInstance}" field="briefDatum"/></span>
					
				</li>
				</g:if>
						
				<g:if test="${betriebskostenabrechnungsbriefInstance?.adressAnrede}">
				<li class="fieldcontain">
					<span id="adressAnrede-label" class="property-label"><g:message code="betriebskostenabrechnungsbrief.adressAnrede.label" default="Adress Anrede" /></span>
					
						<span class="property-value" aria-labelledby="adressAnrede-label"><g:fieldValue bean="${betriebskostenabrechnungsbriefInstance}" field="adressAnrede"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${betriebskostenabrechnungsbriefInstance?.adressName}">
				<li class="fieldcontain">
					<span id="adressName-label" class="property-label"><g:message code="betriebskostenabrechnungsbrief.adressName.label" default="Adress Name" /></span>
					
						<span class="property-value" aria-labelledby="adressName-label"><g:fieldValue bean="${betriebskostenabrechnungsbriefInstance}" field="adressName"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${betriebskostenabrechnungsbriefInstance?.strHnr}">
				<li class="fieldcontain">
					<span id="strHnr-label" class="property-label"><g:message code="betriebskostenabrechnungsbrief.strHnr.label" default="Str Hnr" /></span>
					
						<span class="property-value" aria-labelledby="strHnr-label"><g:fieldValue bean="${betriebskostenabrechnungsbriefInstance}" field="strHnr"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${betriebskostenabrechnungsbriefInstance?.plzOrt}">
				<li class="fieldcontain">
					<span id="plzOrt-label" class="property-label"><g:message code="betriebskostenabrechnungsbrief.plzOrt.label" default="Plz Ort" /></span>
					
						<span class="property-value" aria-labelledby="plzOrt-label"><g:fieldValue bean="${betriebskostenabrechnungsbriefInstance}" field="plzOrt"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${betriebskostenabrechnungsbriefInstance?.briefAnrede1}">
				<li class="fieldcontain">
					<span id="briefAnrede1-label" class="property-label"><g:message code="betriebskostenabrechnungsbrief.briefAnrede1.label" default="Brief Anrede1" /></span>
					
						<span class="property-value" aria-labelledby="briefAnrede1-label"><g:fieldValue bean="${betriebskostenabrechnungsbriefInstance}" field="briefAnrede1"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${betriebskostenabrechnungsbriefInstance?.anredeName}">
				<li class="fieldcontain">
					<span id="anredeName-label" class="property-label"><g:message code="betriebskostenabrechnungsbrief.anredeName.label" default="Anrede Name" /></span>
					
						<span class="property-value" aria-labelledby="anredeName-label"><g:fieldValue bean="${betriebskostenabrechnungsbriefInstance}" field="anredeName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${betriebskostenabrechnungsbriefInstance?.briefAnrede2}">
				<li class="fieldcontain">
					<span id="briefAnrede2-label" class="property-label"><g:message code="betriebskostenabrechnungsbrief.briefAnrede2.label" default="Brief Anrede2" /></span>
					
						<span class="property-value" aria-labelledby="briefAnrede2-label"><g:fieldValue bean="${betriebskostenabrechnungsbriefInstance}" field="briefAnrede2"/></span>
					
				</li>
				</g:if>
								
				<g:if test="${betriebskostenabrechnungsbriefInstance?.saldo}">
				<li class="fieldcontain">
					<span id="saldo-label" class="property-label"><g:message code="betriebskostenabrechnungsbrief.saldo.label" default="Saldo" /></span>
					
						<span class="property-value" aria-labelledby="saldo-label"><g:fieldValue bean="${betriebskostenabrechnungsbriefInstance}" field="saldo"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${betriebskostenabrechnungsbriefInstance?.mietsaldo}">
				<li class="fieldcontain">
					<span id="mietsaldo-label" class="property-label"><g:message code="betriebskostenabrechnungsbrief.mietsaldo.label" default="Mietsaldo" /></span>
					
						<span class="property-value" aria-labelledby="mietsaldo-label"><g:fieldValue bean="${betriebskostenabrechnungsbriefInstance}" field="mietsaldo"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${betriebskostenabrechnungsbriefInstance?.erstattung}">
				<li class="fieldcontain">
					<span id="erstattung-label" class="property-label"><g:message code="betriebskostenabrechnungsbrief.erstattung.label" default="Erstattung" /></span>
					
						<span class="property-value" aria-labelledby="erstattung-label"><g:fieldValue bean="${betriebskostenabrechnungsbriefInstance}" field="erstattung"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${betriebskostenabrechnungsbriefInstance?.nebenkostenvorauszahlung}">
				<li class="fieldcontain">
					<span id="nebenkostenvorauszahlung-label" class="property-label"><g:message code="betriebskostenabrechnungsbrief.nebenkostenvorauszahlung.label" default="Nebenkostenvorauszahlung" /></span>
					
						<span class="property-value" aria-labelledby="nebenkostenvorauszahlung-label"><g:fieldValue bean="${betriebskostenabrechnungsbriefInstance}" field="nebenkostenvorauszahlung"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${betriebskostenabrechnungsbriefInstance?.heizkostenvorauszahlung}">
				<li class="fieldcontain">
					<span id="heizkostenvorauszahlung-label" class="property-label"><g:message code="betriebskostenabrechnungsbrief.heizkostenvorauszahlung.label" default="Heizkostenvorauszahlung" /></span>
					
						<span class="property-value" aria-labelledby="heizkostenvorauszahlung-label"><g:fieldValue bean="${betriebskostenabrechnungsbriefInstance}" field="heizkostenvorauszahlung"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${betriebskostenabrechnungsbriefInstance?.nebenkosten}">
				<li class="fieldcontain">
					<span id="nebenkosten-label" class="property-label"><g:message code="betriebskostenabrechnungsbrief.nebenkosten.label" default="Nebenkosten" /></span>
					
						<span class="property-value" aria-labelledby="nebenkosten-label"><g:fieldValue bean="${betriebskostenabrechnungsbriefInstance}" field="nebenkosten"/></span>
					
				</li>
				</g:if>
												
				<g:if test="${betriebskostenabrechnungsbriefInstance?.heizkosten}">
				<li class="fieldcontain">
					<span id="heizkosten-label" class="property-label"><g:message code="betriebskostenabrechnungsbrief.heizkosten.label" default="Heizkosten" /></span>
					
						<span class="property-value" aria-labelledby="heizkosten-label"><g:fieldValue bean="${betriebskostenabrechnungsbriefInstance}" field="heizkosten"/></span>
					
				</li>
								
				<li class="fieldcontain">
					<span id="heizVon-label" class="property-label"><g:message code="betriebskostenabrechnungsbrief.heizVon.label" default="Heizkosten von" /></span>
					
						<span class="property-value" aria-labelledby="heizVon-label"><g:fieldValue bean="${betriebskostenabrechnungsbriefInstance}" field="heizVon"/></span>
					
				</li>
				<li class="fieldcontain">
					<span id="heizBis-label" class="property-label"><g:message code="betriebskostenabrechnungsbrief.heizBis.label" default="Heizkosten bis" /></span>
					
						<span class="property-value" aria-labelledby="heizBis-label"><g:fieldValue bean="${betriebskostenabrechnungsbriefInstance}" field="heizBis"/></span>
					
				</li>
				</g:if>
							
				<g:if test="${betriebskostenabrechnungsbriefInstance?.umlageausfallwagnis}">
				<li class="fieldcontain">
					<span id="umlageausfallwagnis-label" class="property-label"><g:message code="betriebskostenabrechnungsbrief.umlageausfallwagnis.label" default="2% Umlageausfallwagnis" /></span>
					
						<span class="property-value" aria-labelledby="umlageausfallwagnis-label"><g:fieldValue bean="${betriebskostenabrechnungsbriefInstance}" field="umlageausfallwagnis"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${betriebskostenabrechnungsbriefInstance?.kontoinhaber}">
				<li class="fieldcontain">
					<span id="kontoinhaber-label" class="property-label"><g:message code="betriebskostenabrechnungsbrief.kontoinhaber.label" default="Kontoinhaber" /></span>
					
						<span class="property-value" aria-labelledby="kontoinhaber-label"><g:fieldValue bean="${betriebskostenabrechnungsbriefInstance}" field="kontoinhaber"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${betriebskostenabrechnungsbriefInstance?.bankname}">
				<li class="fieldcontain">
					<span id="bankname-label" class="property-label"><g:message code="betriebskostenabrechnungsbrief.bankname.label" default="Bankname" /></span>
					
						<span class="property-value" aria-labelledby="bankname-label"><g:fieldValue bean="${betriebskostenabrechnungsbriefInstance}" field="bankname"/></span>
					
				</li>
				</g:if>
			
							
				<g:if test="${betriebskostenabrechnungsbriefInstance?.iban}">
				<li class="fieldcontain">
					<span id="iban-label" class="property-label"><g:message code="betriebskostenabrechnungsbrief.iban.label" default="IBAN" /></span>
					
						<span class="property-value" aria-labelledby="iban-label"><g:fieldValue bean="${betriebskostenabrechnungsbriefInstance}" field="iban"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:betriebskostenabrechnungsbriefInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${betriebskostenabrechnungsbriefInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
					<a id="pdf-link" class="print" href="#pdf-link" onClick="javascript:window.open('<g:createLink action="renderFormPDF" id="${betriebskostenabrechnungsbriefInstance?.id}"/>','_blank','width=1000, height=1200')">Drucken</a>
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
