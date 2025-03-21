
<%@ page import="org.strotmann.immos.Person" %>
<%@ page import="org.strotmann.immos.Organisation" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'organisation.label', default: 'Organisation')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-organisation" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-organisation" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list organisation">
			
				<g:if test="${organisationInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="organisation.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${organisationInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${organisationInstance?.nameZusatz}">
				<li class="fieldcontain">
					<span id="nameZusatz-label" class="property-label"><g:message code="organisation.nameZusatz.label" default="Name Zusatz" /></span>
					
						<span class="property-value" aria-labelledby="nameZusatz-label"><g:fieldValue bean="${organisationInstance}" field="nameZusatz"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${organisationInstance?.rechtsform}">
				<li class="fieldcontain">
					<span id="rechtsform-label" class="property-label"><g:message code="organisation.rechtsform.label" default="Rechtsform" /></span>
					
						<span class="property-value" aria-labelledby="rechtsform-label"><g:fieldValue bean="${organisationInstance}" field="rechtsform"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${organisationInstance?.steuernummer}">
				<li class="fieldcontain">
					<span id="nameZusatz-label" class="property-label"><g:message code="organisation.steuernummer.label" default="Steuernummer" /></span>
					
						<span class="property-value" aria-labelledby="steuernummer-label"><g:fieldValue bean="${organisationInstance}" field="steuernummer"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${organisationInstance?.kundennummer}">
				<li class="fieldcontain">
					<span id="nameZusatz-label" class="property-label"><g:message code="organisation.kundennummer.label" default="(unsere)Kundennummer" /></span>
					
						<span class="property-value" aria-labelledby="kundennummer-label"><g:fieldValue bean="${organisationInstance}" field="kundennummer"/></span>
					
				</li>
				</g:if>
				
				<li class="fieldcontain">
					<span id="partnerrolle-label" class="property-label"><g:message code="organisation.partnerrolle.label" default="Ansprechpartner" /></span>
					
						<g:each in="${organisationInstance.getAspaList()}" var="p">
							<g:if test="${p instanceof Person }">
								<span class="property-value" aria-labelledby="partnerrolle-label"><g:link controller="person" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
							</g:if>
							<g:else>
								<span class="property-value" aria-labelledby="partnerrolle-label"><g:link controller="organisation" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
							</g:else>
						</g:each>
					
				</li>
			
				
				<g:if test="${organisationInstance?.hausadresse}">
				<li class="fieldcontain">
					<span id="hausadresse-label" class="property-label"><g:message code="organisation.hausadresse.label" default="Hausadresse" /></span>
					
						<span class="property-value" aria-labelledby="hausadresse-label"><g:link controller="hausadresse" action="show" id="${organisationInstance?.hausadresse?.id}">${organisationInstance?.hausadresse?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${organisationInstance?.bankverbindung}">
				<li class="fieldcontain">
					<span id="bankverbindung-label" class="property-label"><g:message code="organisation.bankverbindung.label" default="Bankverbindung" /></span>
					
						<g:each in="${organisationInstance.bankverbindung}" var="b">
						<span class="property-value" aria-labelledby="bankverbindung-label"><g:link controller="bankverbindung" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
				
				<li class="fieldcontain">
					<span id="sumZahlg-label" class="property-label"><g:message code="organisation.sumZahlg.label" default="Summe Zahlungen" /></span>
					<span class="property-value" aria-labelledby="sumZahlg-label">
						<g:formatNumber number="${organisationInstance.sumZahlgGesP}" type="number" minFractionDigits="2" format="#,##0.00"/>
					</span>
				</li>
				
				<li class="fieldcontain">
				<span id="summen-label" class="property-label"><g:message code="organisation.summen.label" default="Summen/Jahr" /></span>
				<g:each in="${organisationInstance.sumZahlgYearP}" var="k">
					<span class="property-value" aria-labelledby="sumZahlg-label">
						<g:formatNumber number="${k.key}" />
						<g:message message=":" />
						<g:formatNumber number="${k.value}" type="number" minFractionDigits="2"format="#,##0.00"/>
					</span>
				</g:each>
				</li>
			
				<g:if test="${organisationInstance?.kommunikation}">
				<li class="fieldcontain">
					<span id="kommunikation-label" class="property-label"><g:message code="organisation.kommunikation.label" default="Kommunikation" /></span>
					
						<g:each in="${organisationInstance.kommunikation}" var="k">
						<span class="property-value" aria-labelledby="kommunikation-label"><g:link controller="kommunikation" action="show" id="${k.id}">${k?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>			
				
				<g:if test="${organisationInstance?.dienstleistungsvertraege}">
				<li class="fieldcontain">
					<span id="dienstleistungsvertraege-label" class="property-label"><g:message code="organisation.dienstleistungsvertraege.label" default="Dienstleistungsverträge" /></span>
					
						<g:each in="${organisationInstance.dienstleistungsvertraege}" var="d">
						<span class="property-value" aria-labelledby="dienstleistungsvertraege-label"><g:link controller="dienstleistungsvertrag" action="show" id="${d.id}">${d}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
				
				<g:if test="${organisationInstance?.kredite}">
				<li class="fieldcontain">
					<span id="kredit-label" class="property-label"><g:message code="organisation.kredit.label" default="Kredite" /></span>
					
						<g:each in="${organisationInstance.kredite}" var="k">
						<span class="property-value" aria-labelledby="kredit-label"><g:link controller="kredit" action="show" id="${k.id}">${k?.kreditKurz}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
				
				<g:if test="${organisationInstance?.mietvertraege}">
				<li class="fieldcontain">
					<span id="mietvertraege-label" class="property-label"><g:message code="organisation.mietvertrag.label" default="Mietvertrag" /></span>
					
						<g:each in="${organisationInstance.mietvertraege}" var="m">
						<span class="property-value" aria-labelledby="mietvertraege-label"><g:link controller="mietvertrag" action="show" id="${m.id}">${m?.mietvertragKlar}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
				
				<g:if test="${organisationInstance?.rechnungen}">
				<li class="fieldcontain">
					<span id="rechnungen-label" class="property-label"><g:message code="organisation.rechnungen.label" default="Rechnungen" /></span>
					
						<g:each in="${organisationInstance.rechnungen}" var="r">
						<span class="property-value" aria-labelledby="rechnungen-label"><g:link controller="rechnung" action="show" id="${r.id}">${r?.reLang}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
				
				<g:if test="${organisationInstance?.postfachadresse}">
				<li class="fieldcontain">
					<span id="postfachadresse-label" class="property-label"><g:message code="organisation.postfachadresse.label" default="Postfachadresse" /></span>
					
						<g:each in="${organisationInstance.postfachadresse}" var="p">
						<span class="property-value" aria-labelledby="postfachadresse-label"><g:link controller="postfachadresse" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
				
				<li class="fieldcontain">
					<span id="notizen-label" class="property-label"><g:message code="organisation.notizen.label" default="Notizen" /></span>
					
						<g:each in="${org.strotmann.immos.Notiz.getNotizen('Organisation',organisationInstance.id)}" var="n">
						<span class="property-value" aria-labelledby="notizen-label"><g:link controller="notiz" action="show" id="${n.id}">${n}</g:link></span>
						</g:each>
					
				</li>
			
			</ol>
			<g:form url="[resource:mietsacheInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${organisationInstance?.id}" />
					<g:link class="edit" action="edit" id="${organisationInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit method="DELETE" class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
