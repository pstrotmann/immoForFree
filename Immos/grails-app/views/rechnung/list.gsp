
<%@ page import="org.strotmann.immos.Rechnung" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'rechnung.label', default: 'Rechnung')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		</head>
	<body>
		<a href="#list-rechnung" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-rechnung" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
				
			<g:form class="list" controller="rechnung">
				&nbsp;&nbsp;&nbsp;&nbsp;
		    	<g:if test="${session.immobilie == null}">
		    		<g:select id="immobilie" name="immobilie.id" from="${org.strotmann.immos.Immobilie.immobilien}" optionKey="id" required="" value="null" class="many-to-one" noSelection="['null': 'Immobilie?']"/>
		   		</g:if>
		   		<g:else>
		    		<g:select id="immobilie" name="immobilie.id" from="${org.strotmann.immos.Immobilie.immobilien}" optionKey="id" required="" value="${session.immobilie.id}" class="many-to-one" noSelection="['null': 'Immobilie?']"/>
		   		</g:else>
		   		
		   		<g:if test="${session.umlage == null}">
		   			<g:select id="umlageSel" name="umlageSel.id" from="${session.umlSelektors}" optionKey="id" required="" value="null" class="many-to-one" noSelection="['null': 'umlagefähig?']"/>
		   		</g:if>
		   		<g:else>
		   			<g:select id="umlageSel" name="umlageSel.id" from="${session.umlSelektors}" optionKey="id" required="" value="${session.umlage.id}" class="many-to-one" noSelection="['null': 'umlagefähig?']"/>
		   		</g:else>
		   		
		   		<g:if test="${session.reJahr == null}">
		   			<g:select id="jahrSel" name="jahrSel.id" from="${session.jahrSelektors}" optionKey="id" required="" value="null" class="many-to-one" noSelection="['null': 'Rechnungsjahr?']"/>
		   		</g:if>
		   		<g:else>
		   			<g:select id="jahrSel" name="jahrSel.id" from="${session.jahrSelektors}" optionKey="id" required="" value="${session.reJahr.id}" class="many-to-one" noSelection="['null': 'Rechnungsjahr?']"/>
		   		</g:else>
		   		
		   		<g:actionSubmitImage action="setSelKrit" value="Auswahl" src="${resource(dir: 'images/skin', file: 'database_table.png')}"/>
		   		
		    </g:form>
				
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="rechnung.rechnungssteller.label" default="Rechnungssteller" /></th>
					
						<g:if test="${session.immobilie == null}">
							<th><g:message code="rechnung.immobilie.label" default="Immobilie" /></th>
						</g:if>
						<g:else>
							<th><g:message code="rechnung.rechnungsgegenstand.label" default="Rechnungsgegenstand" /></th>
						</g:else>
					
						<g:sortableColumn property="rechnungsdatum" title="${message(code: 'rechnung.rechnungsdatum.label', default: 'Rechnungsdatum')}" />
					
						<th><div align = right><g:message code="rechnung.betrag.label" default="Betrag" /></div></th>
						
						<th><div align = right><g:message code="rechnung.umlage.label" default="Umlage" /></div></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${rechnungInstanceList}" status="i" var="rechnungInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${rechnungInstance.id}">${fieldValue(bean: rechnungInstance, field: "rechnungssteller.partner.name")}</g:link></td>
					
						<g:if test="${session.immobilie == null}">
							<td>${fieldValue(bean: rechnungInstance, field: "immobilie")}</td>
						</g:if>
						<g:else>
							<td>${fieldValue(bean: rechnungInstance, field: "rechnungsgegenstand")}</td>
						</g:else>
					
						<td><g:formatDate date="${rechnungInstance.rechnungsdatum}" format="dd.MM.yyyy"/></td>
					
						<td><div align = right><g:formatNumber number="${rechnungInstance.betrag}" type="number" minFractionDigits="2" format="#,##0.00"/></div></td>
						
						<td><div align = right><g:formatBoolean boolean="${rechnungInstance.umlagefaehig}" true="Ja" false="Nein" /></div></td>
					
					</tr>
				</g:each>
				</tbody>
				<tfoot>
					<tr>
						<td></td>
						<td></td>
						<td><div align = right>Summe:</div></td>
						<td><div align = right><g:formatNumber number="${Rechnung.getReSumme(rechnungInstanceList)}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>
						<td></td>
					</tr>
				</tfoot>
			</table>
			<div class="pagination">
				<g:paginate total="${rechnungInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
