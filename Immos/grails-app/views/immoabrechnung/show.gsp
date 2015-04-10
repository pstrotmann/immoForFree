
<%@ page import="org.strotmann.immos.Immoabrechnung" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'immoabrechnung.label', default: 'Immoabrechnung')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-immoabrechnung" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li><g:link class="list" action="abrechnenNebko" params="[id:immoabrechnungInstance?.id]"><g:message code="default.nebko.label"  /></g:link></li>
				<li>
				<g:link class="list" controller="druck" action="serienbriefe" params="[id:immoabrechnungInstance?.id]">
					<g:message code="default.excel.label"/>
				</g:link>
				</li>
			</ul>
		</div>
		<div id="show-immoabrechnung" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list immoabrechnung">
			
				<g:if test="${immoabrechnungInstance?.jahr}">
				<li class="fieldcontain">
					<span id="jahr-label" class="property-label"><g:message code="immoabrechnung.jahr.label" default="Jahr" /></span>
					
						<span class="property-value" aria-labelledby="jahr-label"><g:formatNumber number="${immoabrechnungInstance?.jahr.encodeAsHTML()}"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${immoabrechnungInstance?.datum}">
				<li class="fieldcontain">
					<span id="datum-label" class="property-label"><g:message code="immoabrechnung.datum.label" default="Datum" /></span>
					
						<span class="property-value" aria-labelledby="datum-label"><g:formatDate date="${immoabrechnungInstance?.datum}" format="dd.MM.yyyy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${immoabrechnungInstance?.immobilie}">
				<li class="fieldcontain">
					<span id="immobilie-label" class="property-label"><g:message code="immoabrechnung.immobilie.label" default="Immobilie" /></span>
					
						<span class="property-value" aria-labelledby="immobilie-label"><g:link controller="immobilie" action="show" id="${immoabrechnungInstance?.immobilie?.id}">${immoabrechnungInstance?.immobilie?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${immoabrechnungInstance?.betriebskostenabrechnungen}">
				<li class="fieldcontain">
					<span id="betriebskostenabrechnungen-label" class="property-label"><g:message code="immoabrechnung.betriebskostenabrechnungen.label" default="Betriebskostenabrechnungen" /></span>
					
						<g:each in="${immoabrechnungInstance.betriebskostenabrechnungen}" var="b">
						<span class="property-value" aria-labelledby="betriebskostenabrechnungen-label"><g:link controller="betriebskostenabrechnung" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${immoabrechnungInstance?.umlagen}">
				<li class="fieldcontain">
					<span id="umlagen-label" class="property-label"><g:message code="immoabrechnung.umlagen.label" default="Umlagen" /></span>
						<table cellspacing = "0">
							<thead>
								<tr>
									<th><g:message code="umlage.kostenart.label" default="Kostenart" /></th>
									<th><div align = right><g:message code="umlage.betrag.label" default="Betrag" /></div></th>
									<th><div align = right><g:message code="umlage.betrag.label" default="ohneZZ" /></div></th>
									<th><g:message code="umlage.umlageschluessel.label" default="Umlageschlüssel" /></th>
									<th><div align = right><g:message code="umlage.betrag.label" default="Verbrauch" /></div></th>
									<th><div align = right><g:message code="umlage.betrag.label" default="zzVerbrauch" /></div></th>
								</tr>
							</thead>
							<tbody>
								<g:each in="${immoabrechnungInstance.umlagen}" status="i" var="u">
									<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
										<td><g:link controller="umlage" action="show" id="${u.id}">${fieldValue(bean: u, field: "kostenart")}</g:link></td>
										<td><div align = right><g:formatNumber number="${u.betrag}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>
										<td><div align = right><g:formatNumber number="${u.betragOhneZZ}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>
										<td>${fieldValue(bean: u, field: "umlageschluessel")}</td>
										<td><div align = right><g:formatNumber number="${u.ZVerbrauch}" type="number" /> <g:fieldValue bean="${u}" field="zaehler.zaehlereinheit"/></div></td>
									</tr>
								</g:each>
							</tbody>
							<tfoot>
								<tr>
									<td><g:message code="umlage.zwischensumme.label" default="Summe Umlagen" /></td>
									<td><div align = right><g:formatNumber number="${immoabrechnungInstance.summeUmlagen}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td><g:message code="umlage.summe.label" default="davon Kommunalabgaben" /></td>
									<td><div align = right><g:formatNumber number="${immoabrechnungInstance.summeKommunalabgaben}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
							</tfoot>
						</table>
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${immoabrechnungInstance?.id}" />
					<g:link class="edit" action="edit" id="${immoabrechnungInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
