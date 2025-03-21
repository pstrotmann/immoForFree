<!DOCTYPE html>
<%@ page import="org.strotmann.util.*" %>
<%@ page import="org.strotmann.immos.*" %>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Immobilienverwaltung</title>
		<style type="text/css" media="screen">
			#status {
				background-color: #eee;
				border: .2em solid #fff;
				margin: 2em 2em 1em;
				padding: 1em;
				width: 12em;
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
			}

			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}

			#status ul {
				font-size: 0.9em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}

			#status li {
				line-height: 1.3;
			}

			#status h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
			}

			#page-body {
				margin: 2em 1em 1.25em 18em;
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}
			
			h3 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				line-height: 1.5;
				margin: 0.25em 0;
			}

			#controller-list ul {
				list-style-position: inside;
			}

			#controller-list li {
				line-height: 1.3;
				list-style-position: inside;
				margin: 0.25em 0;
			}

			@media screen and (max-width: 480px) {
				#status {
					display: none;
				}

				#page-body {
					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
			}
		</style>
	</head>
	<body>
		<a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="logout" controller="user" action="logout">Logout User: ${session.user}</g:link></li>
			</ul>
		</div>
		<div id="page-body" role="main">
			<h1>Immobilienverwaltung</h1>
			<div id="controller-list" role="navigation">
					
				<ul>
					<h3>Stammdaten:</h3>
					<ul>
						<li class="controller"><g:link controller="matchcode">Matchcode</g:link></li>
						<li class="controller"><g:link controller="person" action="list">Person</g:link></li>
						<li class="controller"><g:link controller="organisation" action="list">Organisation</g:link></li>
					</ul>
					<h3>Immobiliendaten:</h3>
					<ul>
						<li class="controller"><g:link controller="immobilie" action="list">Immobilie</g:link></li>
						<li class="controller"><g:link controller="grundschuld" action="list">Grundschuld</g:link></li>
						<li class="controller"><g:link controller="mietvertrag" action="list">Mietvertrag</g:link></li>
						<li class="controller"><g:link controller="kredit" action="list">Kredit</g:link></li>
						<li class="controller"><g:link controller="dienstleistungsvertrag" action="list">Dienstleistungsvertrag</g:link></li>
						<li class="controller"><g:link controller="rechnung" action="list">Rechnung</g:link></li>
					</ul>
					<h3>
					Aktionen:
					<g:form controller="druck">
				    	<g:actionSubmit action="setAuswJahr" value="für Jahr" />
				    	<g:if test="${session.jahr == null}">
				    		<input type="number" id="year" name="jahr" value="${Datum.aktJahr}"/>
				    	</g:if>
				    	<g:if test="${session.jahr}">
				    		<input type="number" id="year" name="jahr" value="${session.jahr}"/>
				    	</g:if>
				    </g:form>
					</h3>
					<ul>
						<li><g:message code="bankumsatz.import.code" default="Bankumsätze importieren"/>
						<g:uploadForm controller='bankumsatzImport'>
    						<input type='file' name='file'/>
    						<input type='submit'/>
						</g:uploadForm>
						<g:if test="${flash.messageF}">
							<div class="message">${flash.messageF}</div>
						</g:if>
						</li>
						
						<g:if test="${flash.message}">
							<div class="message">${flash.message}</div>
						</g:if>
						<li class="controller"><g:link controller="bankumsatzZuordnung">Bankumsätze zuordnen</g:link></li>
						<g:if test="${flash.message1}">
							<div class="message">${flash.message1}</div>
							<div class="message">${flash.message2}</div>
							<div class="message">${flash.message3}</div>
							<div class="message">${flash.message4}</div>
						</g:if>
						<li class="controller"><g:link controller="bankumsatz" action="listOffen">offene Bankumsätze anzeigen</g:link></li>
						<li class="controller"><g:link controller="bankumsatz" action="listZugeordnet">zugeordnete Bankumsätze anzeigen</g:link></li>
						<li class="controller"><g:link controller="druck" action="printOffeneUmsaetze">offene Bankumsätze drucken</g:link></li>
						<li class="controller"><g:link controller="druck" action="printZuordnungen">Zuordnung der Zahlungen drucken</g:link></li>
						<li class="controller"><g:link controller="druck" action="printMietjournal">Mietjournal drucken</g:link></li>
						<li class="controller"><g:link controller="immoabrechnung" action="list">Heiz- und Nebenkostenabrechnung</g:link></li>
						<g:if test="${flash.messageN}">
							<div class="message">${flash.messageN}</div>
						</g:if>
					</ul>
					<h3>Services:</h3>
					<ul>
						<li class="controller"><g:link controller="termin" >Termine</g:link></li>
						<li class="controller"><g:link controller="notiz" >Notizen</g:link></li>
						<li class="controller"><g:link controller="bank" >Banken</g:link></li>
						
					</ul>
					<h3>Summen:</h3>
					<ul>
						<li class="controller">
							<span id="sumZahlg-label" class="property-label"><g:message code="partner.sumZahlg.label" default="Summe Zahlungen" /></span>
							<span class="property-value" aria-labelledby="sumZahlg-label">
								<g:formatNumber number="${Partner.sumZahlgGesP}" type="number" minFractionDigits="2" format="#.##0,00"/>
							</span>
						</li>
						<li class="controller">
							<span id="summen-label" class="property-label"><g:message code="partner.summen.label" default="Summen/Jahr" /></span>
							<ul>
							<g:each in="${Partner.sumZahlgYearP}" var="k">
								<li>
									<g:formatNumber number="${k.key}" />
									<g:message message=":" />
									<g:formatNumber number="${k.value}" type="number" minFractionDigits="2"format="#.##0,00"/>
								</li>
							</g:each>
							</ul>
						</li>
					</ul>
				</ul>
			</div>
		</div>
	</body>
</html>
