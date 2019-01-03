<!DOCTYPE html>
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
		<div id="page-body" role="main">
			<h1>Immobilienverwaltung</h1>
			<div id="controller-list" role="navigation">
				<h2></h2>
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
						<li class="controller"><g:link controller="druck" action="printMietjournal">Mietjournal drucken</g:link></li>
						<li class="controller"><g:link controller="kredit" action="list">Kredit</g:link></li>
						<li class="controller"><g:link controller="dienstleistungsvertrag" action="list">Dienstleistungsvertrag</g:link></li>
						<li class="controller"><g:link controller="rechnung" action="list">Rechnung</g:link></li>
					</ul>
					<h3>Aktionen:</h3>
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
						<li><g:message code="bankumsatz.offen.code" default="offene Bankumsätze anzeigen"/>
							<g:form controller="bankumsatz">
						    	<g:actionSubmit action="listOffen" value="Anzeige für" />
						    	<label for="year">Jahr:</label>
						    	<input type="text" id="year" name="jahr" />
							</g:form>
						</li>
						<li><g:message code="bankumsatz.zugeordnet.code" default="zugeordnete Bankumsätze anzeigen"/>
							<g:form controller="bankumsatz">
						    	<g:actionSubmit action="listZugeordnet" value="Anzeige für" />
						    	<label for="year">Jahr:</label>
						    	<input type="text" id="year" name="jahr" />
							</g:form>
						</li>
						<li><g:message code="bankumsatz.offen.code" default="offene Bankumsätze drucken"/>
							<g:form controller="druck">
						    	<g:actionSubmit action="printOffeneUmsaetze" value="Drucken für" />
						    	<label for="year">Jahr:</label>
						    	<input type="text" id="year" name="jahr" />
							</g:form>
						</li>
						<li><g:message code="bankumsatz.zuordnung.code" default="Zuordnung der Zahlungen drucken"/>
							<g:form controller="druck">
						    	<g:actionSubmit action="printZuordnungen" value="Drucken für" />
						    	<label for="year">Jahr:</label>
						    	<input type="text" id="year" name="jahr" />
							</g:form>
						</li>
						<li class="controller"><g:link controller="immoabrechnung" action="list">Immobilienabrechnung(Betriebskosten=Heiz- und Nebenkosten)</g:link></li>
						<g:if test="${flash.messageN}">
							<div class="message">${flash.messageN}</div>
						</g:if>
					</ul>
					<h3>Services:</h3>
					<ul>
						<li class="controller"><g:link controller="bank" >Banken</g:link></li>
						<li class="controller"><g:link controller="notiz" >Notizen</g:link></li>
					</ul>
				</ul>
			</div>
		</div>
	</body>
</html>
