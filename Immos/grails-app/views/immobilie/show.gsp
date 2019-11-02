
<%@ page import="org.strotmann.immos.Immobilie" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'immobilie.label', default: 'Immobilie')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-immobilie" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-immobilie" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list immobilie">
			
				<g:if test="${immobilieInstance?.hausadresse}">
				<li class="fieldcontain">
					<span id="hausadresse-label" class="property-label"><g:message code="immobilie.hausadresse.label" default="Hausadresse" /></span>
					
						<span class="property-value" aria-labelledby="hausadresse-label"><g:link controller="hausadresse" action="show" id="${immobilieInstance?.hausadresse?.id}">${immobilieInstance?.hausadresse?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${immobilieInstance?.grundbuch}">
				<li class="fieldcontain">
					<span id="grundbuch-label" class="property-label"><g:message code="immobilie.grundbuch.label" default="Grundbuch" /></span>
					
						<span class="property-value" aria-labelledby="grundbuch-label"><g:fieldValue bean="${immobilieInstance}" field="grundbuch"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${immobilieInstance?.grundschulden}">
				<li class="fieldcontain">
					<span id="grundschulden-label" class="property-label"><g:message code="immobilie.grundschulden.label" default="Grundschulden" /></span>
					<g:each in="${immobilieInstance?.grundschuldenAktiv?}" var="g">
	    				<span class="property-value" aria-labelledby="grundschulden-label"><g:link controller="grundschuld" action="show" id="${g.id}">${g?.noImmo}</g:link></span>
					</g:each>
				</li>
				</g:if>
			
				<g:if test="${immobilieInstance?.baujahr}">
				<li class="fieldcontain">
					<span id="baujahr-label" class="property-label"><g:message code="immobilie.baujahr.label" default="Baujahr" /></span>
					
						<span class="property-value" aria-labelledby="baujahr-label"><g:formatNumber number="${immobilieInstance?.baujahr.encodeAsHTML()}"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${immobilieInstance?.eigentumAb}">
				<li class="fieldcontain">
					<span id="eigentumAb-label" class="property-label"><g:message code="immobilie.eigentumAb.label" default="Eigentum Ab" /></span>
					
						<span class="property-value" aria-labelledby="eigentumAb-label"><g:formatDate date="${immobilieInstance?.eigentumAb}" format="dd.MM.yyyy" /></span>
					
				</li>
				</g:if>
				
				<g:if test="${immobilieInstance?.eigentumBis}">
				<li class="fieldcontain">
					<span id="eigentumBis-label" class="property-label"><g:message code="immobilie.eigentumBis.label" default="Eigentum Bis" /></span>
					
						<span class="property-value" aria-labelledby="eigentumBis-label"><g:formatDate date="${immobilieInstance?.eigentumBis}" format="dd.MM.yyyy" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${immobilieInstance?.anschaffungspreis}">
				<li class="fieldcontain">
					<span id="anschaffungspreis-label" class="property-label"><g:message code="immobilie.anschaffungspreis.label" default="Anschaffungspreis" /></span>
					
						<span class="property-value" aria-labelledby="anschaffungspreis-label"><g:formatNumber number="${immobilieInstance.anschaffungspreis}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${immobilieInstance?.verkaufspreis}">
				<li class="fieldcontain">
					<span id="verkaufspreis-label" class="property-label"><g:message code="immobilie.verkaufspreis.label" default="Verkaufspreis" /></span>
					
						<span class="property-value" aria-labelledby="verkaufspreis-label"><g:formatNumber number="${immobilieInstance.verkaufspreis}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></span>
					
				</li>
				</g:if>
				
				<li class="fieldcontain">
					<span id="restschuld-label" class="property-label"><g:message code="immobilie.restschuld.label" default="Restschuld" /></span>
					
						<span class="property-value" aria-labelledby="restschuld-label"><g:formatNumber number="${immobilieInstance.restschuld}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></span>
					
				</li>
			
				<g:if test="${immobilieInstance?.grundstueckspreis}">
				<li class="fieldcontain">
					<span id="grundstueckspreis-label" class="property-label"><g:message code="immobilie.grundstueckspreis.label" default="Grundstueckspreis" /></span>
					
						<span class="property-value" aria-labelledby="grundstueckspreis-label"><g:fieldValue bean="${immobilieInstance}" field="grundstueckspreis"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${immobilieInstance?.grundstuecksgroesse}">
				<li class="fieldcontain">
					<span id="grundstuecksgroesse-label" class="property-label"><g:message code="immobilie.grundstuecksgroesse.label" default="Grundstuecksgroesse" /></span>
					
						<span class="property-value" aria-labelledby="grundstuecksgroesse-label"><g:fieldValue bean="${immobilieInstance}" field="grundstuecksgroesse"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${immobilieInstance?.erhoehteAbschreibung}">
				<li class="fieldcontain">
					<span id="erhoehteAbschreibung-label" class="property-label"><g:message code="immobilie.erhoehteAbschreibung.label" default="Erhoehte Abschreibung" /></span>
					
						<span class="property-value" aria-labelledby="erhoehteAbschreibung-label"><g:formatBoolean boolean="${immobilieInstance?.erhoehteAbschreibung}" /></span>
					
				</li>
				</g:if>
				
				<g:if test="${immobilieInstance?.sozialerWohnungsbau}">
				<li class="fieldcontain">
					<span id="sozialerWohnungsbau-label" class="property-label"><g:message code="immobilie.sozialerWohnungsbau.label" default="SozialerWohnungsbau" /></span>
					
						<span class="property-value" aria-labelledby="sozialerWohnungsbau-label"><g:formatBoolean boolean="${immobilieInstance?.sozialerWohnungsbau}" /></span>
					
				</li>
				</g:if>
				
				<g:if test="${immobilieInstance?.mietsachen}">
				<li class="fieldcontain">
					<span id="mietsachen-label" class="property-label"><g:message code="immobilie.mietsachen.label" default="Mietsachen" /></span>
					
						<g:each in="${immobilieInstance.mietsachen}" var="m">
						<span class="property-value" aria-labelledby="mietsachen-label"><g:link controller="mietsache" action="show" id="${m.id}">${m?.mietsacheKurz}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
				
				<g:if test="${flash.teilsummen}">
				<li class="fieldcontain">
					<span id="teilsummen-label" class="property-label"><g:message code="immobilie.teilsummen.label" default="[Nettomiete,Umlage]/Jahr" /></span>
					
						<g:each in="${flash.teilsummen}" var="t">
						<span class="property-value" aria-labelledby="teilsummen-label"><g:message message="${t}" /></span>
						</g:each>
				</li>
				
				<li class="fieldcontain">
					<span id="mietflaeche-label" class="property-label"><g:message code="immobilie.mietflaeche.label" default="Mietfläche" /></span>
					
						<span class="property-value" aria-labelledby="mietflaeche-label"><g:fieldValue bean="${immobilieInstance}" field="wohnflaeche"/></span>
					
				</li>
				
				<li class="fieldcontain">
					<span id="jahresnettomiete-label" class="property-label"><g:message code="immobilie.jahresnettomiete.label" default="Jahresnettomiete" /></span>
					
						<span class="property-value" aria-labelledby="jahresnettomiete-label"><g:fieldValue bean="${immobilieInstance}" field="jahresnettomiete"/></span>
					
				</li>
				<li class="fieldcontain">
					<span id="jahresumlage-label" class="property-label"><g:message code="immobilie.jahresumlage.label" default="Jahresumlage" /></span>
					
						<span class="property-value" aria-labelledby="jahresumlage-label"><g:fieldValue bean="${immobilieInstance}" field="jahresumlage"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${immobilieInstance?.anzRauchmelder}">
				<li class="fieldcontain">
					<span id="anzRauchmelder-label" class="property-label"><g:message code="immobilie.anzRauchmelder.label" default="Anzahl Rauchmelder" /></span>
					
						<span class="property-value" aria-labelledby="anzRauchmelder-label"><g:formatNumber number="${immobilieInstance?.anzRauchmelder}"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${immobilieInstance?.anzahlPersonen}">
				<li class="fieldcontain">
					<span id="anzRauchmelder-label" class="property-label"><g:message code="immobilie.anzahlPersonen.label" default="Anzahl Personen" /></span>
					
						<span class="property-value" aria-labelledby="anzahlPersonen-label"><g:formatNumber number="${immobilieInstance?.anzahlPersonen}"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${immobilieInstance?.zaehlers}">
				<li class="fieldcontain">
					<span id="zaehlers-label" class="property-label"><g:message code="immobilie.zaehlers.label" default="Zähler" /></span>
					
						<g:each in="${immobilieInstance.zaehlers}" var="z">
						<span class="property-value" aria-labelledby="zaehlers-label"><g:link controller="zaehler" action="show" id="${z.id}">${z?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${immobilieInstance?.kredite}">
				<li class="fieldcontain">
					<span id="kredite-label" class="property-label"><g:message code="immobilie.kredite.label" default="Kredite" /></span>
					
						<g:each in="${immobilieInstance.verwKredite}" var="k">
						<g:if test="${k.kreditsaldo > 0}">
							<span class="property-value" aria-labelledby="kredite-label"><g:link controller="kredit" action="show" id="${k.id}">${k?.encodeAsHTML()}</g:link></span>
						</g:if>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${immobilieInstance?.dienstleistungsvertraege}">
				<li class="fieldcontain">
					<span id="dienstleistungsvertraege-label" class="property-label"><g:message code="immobilie.dienstleistungsvertraege.label" default="Dienstleistungsvertraege" /></span>
					
						<g:each in="${immobilieInstance.dienstleistungsvertraege}" var="d">
						<span class="property-value" aria-labelledby="dienstleistungsvertraege-label"><g:link controller="dienstleistungsvertrag" action="show" id="${d.id}">${d?.dvKurz}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${immobilieInstance?.rechnungen}">
				<li class="fieldcontain">
					<span id="rechnungen-label" class="property-label"><g:message code="immobilie.rechnungen.label" default="Rechnungen" /></span>
					
						<g:each in="${immobilieInstance.rechnungen}" var="r">
						<span class="property-value" aria-labelledby="rechnungen-label"><g:link controller="rechnung" action="show" id="${r.id}">${r?.reLang}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
				
				<g:if test="${immobilieInstance?.umlageinfos}">
				<li class="fieldcontain">
					<span id="umlageinfo-label" class="property-label"><g:message code="immobilie.umlageinfo.label" default="Umlageinfo" /></span>
						<span class="property-value" aria-labelledby="umlageinfo-label">
							<g:link uri="/umlageinfo/index?art=nk&immoId=${immobilieInstance?.id}">Nebenkosten</g:link>
						</span>
						<span class="property-value" aria-labelledby="umlageinfo-label">
							<g:link uri="/umlageinfo/index?art=hk&immoId=${immobilieInstance?.id}">Heizkosten</g:link>
						</span>
				</li>
				</g:if>
				
				<g:if test="${immobilieInstance?.immoabrechnungen}">
				<li class="fieldcontain">
					<span id="immoabrechnungen-label" class="property-label"><g:message code="immobilie.immoabrechnungen.label" default="Immoabrechnungen" /></span>
					
						<g:each in="${immobilieInstance.immoabrechnungen}" var="ia">
						<span class="property-value" aria-labelledby="immoabrechnungen-label"><g:link controller="immoabrechnung" action="show" id="${ia.id}">${ia?.abrKurz}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${immobilieInstance?.einheitswerte}">
				<li class="fieldcontain">
					<span id="einheitswerte-label" class="property-label"><g:message code="immobilie.einheitswerte.label" default="Einheitswerte" /></span>
					
						<g:each in="${immobilieInstance.einheitswerte}" var="e">
						<span class="property-value" aria-labelledby="einheitswerte-label"><g:link controller="einheitswert" action="show" id="${e.id}">${e?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
				
				<g:if test="${immobilieInstance?.grundschuldenAktiv}">
				<li class="fieldcontain">
					<span id="grundschulden-label" class="property-label"><g:message code="immobilie.grundschulden.label" default="Grundschulden" /></span>
					
						<g:each in="${immobilieInstance.grundschuldenAktiv}" var="e">
						<span class="property-value" aria-labelledby="grundschulden-label"><g:link controller="grundschuld" action="show" id="${e.id}">${e?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
				
				<li class="fieldcontain">
					<span id="notizen-label" class="property-label"><g:message code="immobilie.notizen.label" default="Notizen" /></span>
					
						<g:each in="${org.strotmann.immos.Notiz.getNotizen('Immobilie',immobilieInstance.id)}" var="n">
						<span class="property-value" aria-labelledby="notizen-label"><g:link controller="notiz" action="show" id="${n.id}">${n}</g:link></span>
						</g:each>
				</li>
				
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${immobilieInstance?.id}" />
					<g:link class="edit" action="edit" id="${immobilieInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
