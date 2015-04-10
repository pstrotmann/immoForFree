
<%@ page import="org.strotmann.immos.Kreditstand" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'kreditstand.label', default: 'Kreditstand')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-kreditstand" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-kreditstand" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list kreditstand">
			
				<g:if test="${kreditstandInstance?.laufzeitAb}">
				<li class="fieldcontain">
					<span id="laufzeitAb-label" class="property-label"><g:message code="kreditstand.laufzeitAb.label" default="Laufzeit Ab" /></span>
					
						<span class="property-value" aria-labelledby="laufzeitAb-label"><g:formatDate date="${kreditstandInstance?.laufzeitAb}" format="dd.MM.yyyy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${kreditstandInstance?.laufzeitBis}">
				<li class="fieldcontain">
					<span id="laufzeitBis-label" class="property-label"><g:message code="kreditstand.laufzeitBis.label" default="Laufzeit Bis" /></span>
					
						<span class="property-value" aria-labelledby="laufzeitBis-label"><g:formatDate date="${kreditstandInstance?.laufzeitBis}" format="dd.MM.yyyy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${kreditstandInstance?.kreditsumme}">
				<li class="fieldcontain">
					<span id="kreditsumme-label" class="property-label"><g:message code="kreditstand.kreditsumme.label" default="Kreditsumme" /></span>
					
						<span class="property-value" aria-labelledby="kreditsumme-label"><g:fieldValue bean="${kreditstandInstance}" field="kreditsumme"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${kreditstandInstance?.bewilligt}">
				<li class="fieldcontain">
					<span id="bewilligt-label" class="property-label"><g:message code="kreditstand.bewilligt.label" default="bewilligtes Darlehen" /></span>
					
						<span class="property-value" aria-labelledby="bewilligt-label"><g:fieldValue bean="${kreditstandInstance}" field="bewilligt"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${kreditstandInstance?.zinssatz}">
				<li class="fieldcontain">
					<span id="zinssatz-label" class="property-label"><g:message code="kreditstand.zinssatz.label" default="Zinssatz" /></span>
					
						<span class="property-value" aria-labelledby="zinssatz-label"><g:fieldValue bean="${kreditstandInstance}" field="zinssatz"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${kreditstandInstance?.tilgungssatz}">
				<li class="fieldcontain">
					<span id="tilgungssatz-label" class="property-label"><g:message code="kreditstand.tilgungssatz.label" default="Tilgungssatz" /></span>
					
						<span class="property-value" aria-labelledby="tilgungssatz-label"><g:fieldValue bean="${kreditstandInstance}" field="tilgungssatz"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${kreditstandInstance?.annuitaet}">
				<li class="fieldcontain">
					<span id="annuitaet-label" class="property-label"><g:message code="kreditstand.annuitaet.label" default="Annuität" /></span>
					
						<span class="property-value" aria-labelledby="annuitaet-label"><g:fieldValue bean="${kreditstandInstance}" field="annuitaet"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${kreditstandInstance?.zinsbetrag}">
				<li class="fieldcontain">
					<span id="zinsbetrag-label" class="property-label"><g:message code="kreditstand.zinsbetrag.label" default="Zinsbetrag" /></span>
					
						<span class="property-value" aria-labelledby="zinsbetrag-label"><g:fieldValue bean="${kreditstandInstance}" field="zinsbetrag"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${kreditstandInstance?.tilgungsbetrag}">
				<li class="fieldcontain">
					<span id="tilgungsbetrag-label" class="property-label"><g:message code="kreditstand.tilgungsbetrag.label" default="Tilgungsbetrag" /></span>
					
						<span class="property-value" aria-labelledby="tilgungsbetrag-label"><g:fieldValue bean="${kreditstandInstance}" field="tilgungsbetrag"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${kreditstandInstance?.verwKostenbetrag}">
				<li class="fieldcontain">
					<span id="verwKostenbetrag-label" class="property-label"><g:message code="kreditstand.verwKostenbetrag.label" default="Verw Kostenbetrag" /></span>
					
						<span class="property-value" aria-labelledby="verwKostenbetrag-label"><g:fieldValue bean="${kreditstandInstance}" field="verwKostenbetrag"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${kreditstandInstance?.sondertilgung}">
				<li class="fieldcontain">
					<span id="sondertilgung-label" class="property-label"><g:message code="kreditstand.sondertilgung.label" default="Sondertilgung" /></span>
					
						<span class="property-value" aria-labelledby="sondertilgung-label"><g:fieldValue bean="${kreditstandInstance}" field="sondertilgung"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${kreditstandInstance?.kredit}">
				<li class="fieldcontain">
					<span id="kredit-label" class="property-label"><g:message code="kreditstand.kredit.label" default="Kredit" /></span>
					
						<span class="property-value" aria-labelledby="kredit-label"><g:link controller="kredit" action="show" id="${kreditstandInstance?.kredit?.id}">${kreditstandInstance?.kredit?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:kreditstandInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${kreditstandInstance?.id}" />
					<g:link class="edit" action="edit" id="${kreditstandInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
