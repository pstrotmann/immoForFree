
<%@ page import="org.strotmann.immos.Immobilie" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'immobilie.label', default: 'Immobilie')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-immobilie" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-immobilie" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
						<th><g:message code="immobilie.hausadresse.label" default="Hausadresse" /></th>
						
						<g:sortableColumn property="baujahr" title="${message(code: 'immobilie.baujahr.label', default: 'Baujahr')}" />
					
						<g:sortableColumn property="eigentumAb" title="${message(code: 'immobilie.eigentumAb.label', default: 'Familien-')}" />
						
						<th><div align = right><g:message code="immobilie.eigentuemer.label" default="Eigentümer" /></div></th>
					
						<th><div align = right><g:message code="immobilie.jahresnettomiete.label" default="Nettomiete" /></div></th>
						
						<th><div align = right><g:message code="immobilie.verkaufspreis.label" default="Verkaufs-" /></div></th>
												
						<th><div align = right><g:message code="immobilie.anschaffungspreis.label" default="Wert" /></div></th>
						
						<th><div align = right><g:message code="immobilie.schenkwert.label" default="Schenkwert" /></div></th>
						
						<th><div align = right><g:message code="immobilie.restschuld.label" default="Restschuld" /></div></th>	
						
						<th><div align = right><g:message code="immobilie.annuitaet.label" default="Annuität" /></div></th>					
					</tr>
					<tr>
						<th></th>
						<th></th>
						<th><div align = right><g:message code="immobilie.besitzAb.label" default="Besitz Seit" /></div></th>
						<th></th>
						<th><div align = right><g:message code="immobilie.jahresnettomiete.label" default="/Jahr" /></div></th>
						<th><div align = right><g:message code="immobilie.verkauf.label" default="preis" /></th>
						<th><div align = right><g:message code="immobilie.einstand.label" default="Einstand" /></div></th>
<%--						<th><div align = right><g:message code="immobilie.restschuld.label" default="-Restschuld" /></div></th>--%>
						<th></th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				<g:each in="${immobilieInstanceList.immobilien}" status="i" var="immobilieInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${immobilieInstance[0].id}">${fieldValue(bean: immobilieInstance[0], field: "hausadresse")}</g:link></td>
					
						<td><g:formatNumber number="${immobilieInstance[0].baujahr.encodeAsHTML()}"/></td>
					
						<td><g:formatDate date="${immobilieInstance[0].eigentumAb}" format="dd.MM.yyyy"/></td>
						
						<td><g:link action="show" id="${immobilieInstance[0].id}">${fieldValue(bean: immobilieInstance[0], field: "eigentuemer")}</g:link></td>
						
						<g:if test="${immobilieInstance[6] > 0}">
<%--							<td><div align = right><g:formatNumber number="${immobilieInstance[6]}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>--%>
							<td><div align = right><g:formatNumber number="${immobilieInstance[1]}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>
						</g:if>
						<g:else>
							<td></td>
							<td></td>
						</g:else>
						
						<td><div align = right><g:formatNumber number="${fieldValue(bean: immobilieInstance[0], field: "verkaufspreis")}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>
						
						<td><div align = right><g:formatNumber number="${immobilieInstance[3]}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>
						
						<td><div align = right><g:formatNumber number="${immobilieInstance[7]}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>
						
						<td><div align = right><g:formatNumber number="${immobilieInstance[4]}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>
						
						<td><div align = right><g:formatNumber number="${immobilieInstance[2]}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>
						
					</tr>
				</g:each>
				</tbody>
				<tfoot>
					<tr>
						<td></td>
					
						<td></td>
						
						<td></td>
					
						<td><div align = right><g:message code="immobilie.summe.label" default="Summen" /></div></td>
					
						<td><div align = right><g:formatNumber number="${immobilieInstanceList.sumJahresnetto}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>
						
						<td><div align = right><g:formatNumber number="${immobilieInstanceList.sumVerkauf}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>
						
						<td><div align = right><g:formatNumber number="${immobilieInstanceList.sumAnschaffung}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>
						
						<td><div align = right><g:formatNumber number="${immobilieInstanceList.sumSchenkwert}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>
												
						<td><div align = right><g:formatNumber number="${immobilieInstanceList.sumRestschuld}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>
						
						<td><div align = right><g:formatNumber number="${immobilieInstanceList.sumAnnuitaet}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>
						
					</tr>
				</tfoot>
			</table>
		</div>
	</body>
</html>
