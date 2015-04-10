
<%@ page import="org.strotmann.immos.Bankumsatz" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'bankumsatz.label', default: 'Bankumsatz')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-bankumsatz" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-bankumsatz" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list bankumsatz">
			
				<g:if test="${bankumsatzInstance?.auftragskonto}">
				<li class="fieldcontain">
					<span id="auftragskonto-label" class="property-label"><g:message code="bankumsatz.auftragskonto.label" default="Auftragskonto" /></span>
					
						<span class="property-value" aria-labelledby="auftragskonto-label"><g:fieldValue bean="${bankumsatzInstance}" field="auftragskonto"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bankumsatzInstance?.buchungstag}">
				<li class="fieldcontain">
					<span id="buchungstag-label" class="property-label"><g:message code="bankumsatz.buchungstag.label" default="Buchungstag" /></span>
					
						<span class="property-value" aria-labelledby="buchungstag-label"><g:fieldValue bean="${bankumsatzInstance}" field="buchungstag"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bankumsatzInstance?.valutadatum}">
				<li class="fieldcontain">
					<span id="valutadatum-label" class="property-label"><g:message code="bankumsatz.valutadatum.label" default="Valutadatum" /></span>
					
						<span class="property-value" aria-labelledby="valutadatum-label"><g:fieldValue bean="${bankumsatzInstance}" field="valutadatum"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bankumsatzInstance?.buchungstext}">
				<li class="fieldcontain">
					<span id="buchungstext-label" class="property-label"><g:message code="bankumsatz.buchungstext.label" default="Buchungstext" /></span>
					
						<span class="property-value" aria-labelledby="buchungstext-label"><g:fieldValue bean="${bankumsatzInstance}" field="buchungstext"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bankumsatzInstance?.verwendungszweck}">
				<li class="fieldcontain">
					<span id="verwendungszweck-label" class="property-label"><g:message code="bankumsatz.verwendungszweck.label" default="Verwendungszweck" /></span>
					
						<span class="property-value" aria-labelledby="verwendungszweck-label"><g:fieldValue bean="${bankumsatzInstance}" field="verwendungszweck"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bankumsatzInstance?.glaeubigerId}">
				<li class="fieldcontain">
					<span id="glaeubigerId-label" class="property-label"><g:message code="bankumsatz.glaeubigerId.label" default="Glaeubiger Id" /></span>
					
						<span class="property-value" aria-labelledby="glaeubigerId-label"><g:fieldValue bean="${bankumsatzInstance}" field="glaeubigerId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bankumsatzInstance?.mandatsreferenz}">
				<li class="fieldcontain">
					<span id="mandatsreferenz-label" class="property-label"><g:message code="bankumsatz.mandatsreferenz.label" default="Mandatsreferenz" /></span>
					
						<span class="property-value" aria-labelledby="mandatsreferenz-label"><g:fieldValue bean="${bankumsatzInstance}" field="mandatsreferenz"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bankumsatzInstance?.kundenreferenz}">
				<li class="fieldcontain">
					<span id="kundenreferenz-label" class="property-label"><g:message code="bankumsatz.kundenreferenz.label" default="Kundenreferenz" /></span>
					
						<span class="property-value" aria-labelledby="kundenreferenz-label"><g:fieldValue bean="${bankumsatzInstance}" field="kundenreferenz"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bankumsatzInstance?.sammlerreferenz}">
				<li class="fieldcontain">
					<span id="sammlerreferenz-label" class="property-label"><g:message code="bankumsatz.sammlerreferenz.label" default="Sammlerreferenz" /></span>
					
						<span class="property-value" aria-labelledby="sammlerreferenz-label"><g:fieldValue bean="${bankumsatzInstance}" field="sammlerreferenz"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bankumsatzInstance?.lastschriftUrsprungsbetrag}">
				<li class="fieldcontain">
					<span id="lastschriftUrsprungsbetrag-label" class="property-label"><g:message code="bankumsatz.lastschriftUrsprungsbetrag.label" default="Lastschrift Ursprungsbetrag" /></span>
					
						<span class="property-value" aria-labelledby="lastschriftUrsprungsbetrag-label"><g:fieldValue bean="${bankumsatzInstance}" field="lastschriftUrsprungsbetrag"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bankumsatzInstance?.auslagenersatzRuecklastschrift}">
				<li class="fieldcontain">
					<span id="auslagenersatzRuecklastschrift-label" class="property-label"><g:message code="bankumsatz.auslagenersatzRuecklastschrift.label" default="Auslagenersatz Ruecklastschrift" /></span>
					
						<span class="property-value" aria-labelledby="auslagenersatzRuecklastschrift-label"><g:fieldValue bean="${bankumsatzInstance}" field="auslagenersatzRuecklastschrift"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bankumsatzInstance?.beguenstigterZahlungspflichtiger}">
				<li class="fieldcontain">
					<span id="beguenstigterZahlungspflichtiger-label" class="property-label"><g:message code="bankumsatz.beguenstigterZahlungspflichtiger.label" default="Beguenstigter Zahlungspflichtiger" /></span>
					
						<span class="property-value" aria-labelledby="beguenstigterZahlungspflichtiger-label"><g:fieldValue bean="${bankumsatzInstance}" field="beguenstigterZahlungspflichtiger"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bankumsatzInstance?.kontonummerIBAN}">
				<li class="fieldcontain">
					<span id="kontonummerIBAN-label" class="property-label"><g:message code="bankumsatz.kontonummerIBAN.label" default="Kontonummer IBAN" /></span>
					
						<span class="property-value" aria-labelledby="kontonummerIBAN-label"><g:fieldValue bean="${bankumsatzInstance}" field="kontonummerIBAN"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bankumsatzInstance?.bic}">
				<li class="fieldcontain">
					<span id="bic-label" class="property-label"><g:message code="bankumsatz.bic.label" default="Bic" /></span>
					
						<span class="property-value" aria-labelledby="bic-label"><g:fieldValue bean="${bankumsatzInstance}" field="bic"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bankumsatzInstance?.betrag}">
				<li class="fieldcontain">
					<span id="betrag-label" class="property-label"><g:message code="bankumsatz.betrag.label" default="Betrag" /></span>
					
						<span class="property-value" aria-labelledby="betrag-label"><g:fieldValue bean="${bankumsatzInstance}" field="betrag"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bankumsatzInstance?.waehrung}">
				<li class="fieldcontain">
					<span id="waehrung-label" class="property-label"><g:message code="bankumsatz.waehrung.label" default="Waehrung" /></span>
					
						<span class="property-value" aria-labelledby="waehrung-label"><g:fieldValue bean="${bankumsatzInstance}" field="waehrung"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bankumsatzInstance?.info}">
				<li class="fieldcontain">
					<span id="info-label" class="property-label"><g:message code="bankumsatz.info.label" default="Info" /></span>
					
						<span class="property-value" aria-labelledby="info-label"><g:fieldValue bean="${bankumsatzInstance}" field="info"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bankumsatzInstance?.zahlungen}">
				<li class="fieldcontain">
					<span id="zahlungen-label" class="property-label"><g:message code="bankumsatz.zahlungen.label" default="Zahlungen" /></span>
					
						<g:each in="${bankumsatzInstance.zahlungen}" var="z">
						<span class="property-value" aria-labelledby="zahlungen-label"><g:link controller="zahlung" action="show" id="${z.id}">${z?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:bankumsatzInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${bankumsatzInstance?.id}" />
					<g:link class="edit" action="edit" id="${bankumsatzInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
