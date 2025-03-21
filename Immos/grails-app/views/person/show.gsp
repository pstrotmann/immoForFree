
<%@ page import="org.strotmann.immos.Person" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-person" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li><a href="${createLink(uri: '/matchcode/create')}"><g:message code="default.mcSuch.label"/></a></li>
			</ul>
		</div>
		<div id="show-person" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list person">
			
				<g:if test="${personInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="person.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${personInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.titel}">
				<li class="fieldcontain">
					<span id="titel-label" class="property-label"><g:message code="person.titel.label" default="Titel" /></span>
					
						<span class="property-value" aria-labelledby="titel-label"><g:fieldValue bean="${personInstance}" field="titel"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.vorname}">
				<li class="fieldcontain">
					<span id="vorname-label" class="property-label"><g:message code="person.vorname.label" default="Vorname" /></span>
					
						<span class="property-value" aria-labelledby="vorname-label"><g:fieldValue bean="${personInstance}" field="vorname"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.geschlecht}">
				<li class="fieldcontain">
					<span id="geschlecht-label" class="property-label"><g:message code="person.geschlecht.label" default="Geschlecht" /></span>
					
						<span class="property-value" aria-labelledby="geschlecht-label"><g:fieldValue bean="${personInstance}" field="geschlecht"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.persoenlicheAnrede}">
    			<li class="fieldcontain">
					<span id="persoenlicheAnrede-label" class="property-label"><g:message code="person.persoenlicheAnrede.label" default="Anrede"/></span>

						<span class="property-value" aria-labelledby="persoenlicheAnrede-label"><g:formatBoolean boolean="${personInstance?.persoenlicheAnrede}" true="persönlich" false="formal"/></span>
					  
    			</li>
				</g:if>
			
				<g:if test="${personInstance?.geburtsdatum}">
				<li class="fieldcontain">
					<span id="geburtsdatum-label" class="property-label"><g:message code="person.geburtsdatum.label" default="Geburtsdatum" /></span>
					
						<span class="property-value" aria-labelledby="geburtsdatum-label"><g:formatDate date="${personInstance?.geburtsdatum}" format="dd.MM.yyyy"/></span>
					
				</li>
				</g:if>
						
				<g:if test="${personInstance?.hausadresse}">
				<li class="fieldcontain">
					<span id="hausadresse-label" class="property-label"><g:message code="person.hausadresse.label" default="Hausadresse" /></span>
					
						<span class="property-value" aria-labelledby="hausadresse-label"><g:link controller="hausadresse" action="show" id="${personInstance?.hausadresse?.id}">${personInstance?.hausadresse?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
				
				<g:if test="${personInstance?.bankverbindung}">
				<li class="fieldcontain">
					<span id="bankverbindung-label" class="property-label"><g:message code="person.bankverbindung.label" default="Bankverbindung" /></span>
					
						<g:each in="${personInstance.bankverbindung}" var="b">
						<span class="property-value" aria-labelledby="bankverbindung-label"><g:link controller="bankverbindung" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
				
				<li class="fieldcontain">
					<span id="sumZahlg-label" class="property-label"><g:message code="person.sumZahlg.label" default="Summe Zahlungen" /></span>
					<span class="property-value" aria-labelledby="sumZahlg-label">
						<g:formatNumber number="${personInstance.sumZahlgGes}" type="number" minFractionDigits="2" format="#,##0.00"/>
					</span>
				</li>
				
				<li class="fieldcontain">
				<span id="summen-label" class="property-label"><g:message code="person.summen.label" default="Summen/Jahr" /></span>
				<g:each in="${personInstance.sumZahlgYear}" var="k">
					<span class="property-value" aria-labelledby="sumZahlg-label">
						<g:formatNumber number="${k.key}" />
						<g:message message=":" />
						<g:formatNumber number="${k.value}" type="number" minFractionDigits="2"format="#,##0.00"/>
					</span>
				</g:each>
				</li>
			
				<g:if test="${personInstance?.kommunikation}">
				<li class="fieldcontain">
					<span id="kommunikation-label" class="property-label"><g:message code="person.kommunikation.label" default="Kommunikation" /></span>
					
						<g:each in="${personInstance.kommunikation}" var="k">
						<span class="property-value" aria-labelledby="kommunikation-label"><g:link controller="kommunikation" action="show" id="${k.id}">${k?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>			

				<g:if test="${personInstance?.mietvertraege}">
				<li class="fieldcontain">
					<span id="mietvertraege-label" class="property-label"><g:message code="person.mietvertrag.label" default="Mietvertrag" /></span>
					
						<g:each in="${personInstance.mietvertraege}" var="m">
						<span class="property-value" aria-labelledby="mietvertraege-label"><g:link controller="mietvertrag" action="show" id="${m.id}">${m?.mietvertragKlar}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
				
				<g:if test="${personInstance?.ansprechpartner}">
				<li class="fieldcontain">
					<span id="ansprechpartner-label" class="property-label"><g:message code="person.ansprechpartner.label" default="Ansprechpartner" /></span>
					
						<g:each in="${personInstance.ansprechpartner}" var="a">
						<span class="property-value" aria-labelledby="ansprechpartner-label"><g:link controller="organisation" action="show" id="${a.id}">${a}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
				
				<li class="fieldcontain">
					<span id="notizen-label" class="property-label"><g:message code="person.notizen.label" default="Notizen" /></span>
					
						<g:each in="${org.strotmann.immos.Notiz.getNotizen('Person',personInstance.id)}" var="n">
						<span class="property-value" aria-labelledby="notizen-label"><g:link controller="notiz" action="show" id="${n.id}">${n}</g:link></span>
						</g:each>
					
				</li>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${personInstance?.id}" />
					<g:link class="edit" action="edit" id="${personInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
