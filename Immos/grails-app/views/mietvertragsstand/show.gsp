
<%@ page import="org.strotmann.immos.Mietvertragsstand" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'mietvertragsstand.label', default: 'Mietvertragsstand')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-mietvertragsstand" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-mietvertragsstand" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list mietvertragsstand">
			
				<g:if test="${mietvertragsstandInstance?.mietvertrag}">
				<li class="fieldcontain">
					<span id="mietvertrag-label" class="property-label"><g:message code="mietvertragsstand.mietvertrag.label" default="Mietvertrag" /></span>
					
						<span class="property-value" aria-labelledby="mietvertrag-label">
						<g:link controller="mietvertrag" action="show" id="${mietvertragsstandInstance?.mietvertrag?.id}">${mietvertragsstandInstance?.mietvertrag?.mieter.partner.name.encodeAsHTML()}:${mietvertragsstandInstance?.mietvertrag?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${mietvertragsstandInstance?.gueltigAb}">
				<li class="fieldcontain">
					<span id="gueltigAb-label" class="property-label"><g:message code="mietvertragsstand.gueltigAb.label" default="Gueltig Ab" /></span>
					
						<span class="property-value" aria-labelledby="gueltigAb-label"><g:formatDate date="${mietvertragsstandInstance?.gueltigAb}" format="dd.MM.yyyy"/></span>
					
				</li>
				</g:if>
				
				<li class="fieldcontain">
					<span id="bruttomiete-label" class="property-label"><g:message code="mietvertragsstand.bruttomiete.label" default="Bruttomiete" /></span>
					
						<span class="property-value" aria-labelledby="bruttomiete-label"><g:formatNumber number="${mietvertragsstandInstance.bruttomiete}" type="number" minFractionDigits="2" /></span>
					
				</li>
			
				<g:if test="${mietvertragsstandInstance?.grundmiete}">
				<li class="fieldcontain">
					<span id="grundmiete-label" class="property-label"><g:message code="mietvertragsstand.grundmiete.label" default="Grundmiete" /></span>
					
						<span class="property-value" aria-labelledby="grundmiete-label"><g:formatNumber number="${mietvertragsstandInstance.grundmiete}" type="number" minFractionDigits="2" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${mietvertragsstandInstance?.qmMiete}">
				<li class="fieldcontain">
					<span id="qmMiete-label" class="property-label"><g:message code="mietvertragsstand.qmMiete.label" default="Qm Miete" /></span>
					
						<span class="property-value" aria-labelledby="qmMiete-label"><g:formatNumber number="${mietvertragsstandInstance.qmMiete}" type="number" minFractionDigits="2" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${mietvertragsstandInstance?.nebenkostenpauschale}">
				<li class="fieldcontain">
					<span id="nebenkostenpauschale-label" class="property-label"><g:message code="mietvertragsstand.nebenkostenpauschale.label" default="Nebenkostenpauschale" /></span>
					
						<span class="property-value" aria-labelledby="nebenkostenpauschale-label"><g:formatNumber number="${mietvertragsstandInstance.nebenkostenpauschale}" type="number" minFractionDigits="2" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${mietvertragsstandInstance?.heizkostenpauschale}">
				<li class="fieldcontain">
					<span id="heizkostenpauschale-label" class="property-label"><g:message code="mietvertragsstand.heizkostenpauschale.label" default="Heizkostenpauschale" /></span>
					
						<span class="property-value" aria-labelledby="heizkostenpauschale-label"><g:formatNumber number="${mietvertragsstandInstance.heizkostenpauschale}" type="number" minFractionDigits="2" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${mietvertragsstandInstance?.zusatzmiete}">
				<li class="fieldcontain">
					<span id="zusatzmiete-label" class="property-label"><g:message code="mietvertragsstand.zusatzmiete.label" default="${mietvertragsstandInstance.mietvertrag.zusatzMietsache ? mietvertragsstandInstance.mietvertrag.zusatzMietsache.art : mietvertragsstandInstance.mietvertrag.mietsache.art}" /></span>
					
						<span class="property-value" aria-labelledby="zusatzmiete-label"><g:formatNumber number="${mietvertragsstandInstance.zusatzmiete}" type="number" minFractionDigits="2" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${mietvertragsstandInstance?.anzahlPersonen}">
				<li class="fieldcontain">
					<span id="anzahlPersonen-label" class="property-label"><g:message code="mietvertragsstand.anzahlPersonen.label" default="Anzahl Personen" /></span>
					
						<span class="property-value" aria-labelledby="anzahlPersonen-label"><g:fieldValue bean="${mietvertragsstandInstance}" field="anzahlPersonen"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:mietvertragsstandInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${mietvertragsstandInstance?.id}" />
					<g:link class="edit" action="edit" id="${mietvertragsstandInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
