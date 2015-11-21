<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html [
    <!ENTITY auml "ä">
    <!ENTITY ouml "ö">
    <!ENTITY uuml "ü">
    <!ENTITY Auml "Ä">
    <!ENTITY Ouml "Ö">
    <!ENTITY Uuml "Ü">
    <!ENTITY szlig "ß">
]>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="layout" content="main"/>
	<style>
		@page {
		    /*size: 8.5in 11.65in;   width height */
		    size: 210mm 297mm;  /* width height */
		    margin: 1.00in;
		}
		body{
			font-family: "Times New Roman",Georgia,Serif;
		}
		
		.briefDatum{
			font-size: 15pt;
		}
		
	</style>
</head>
<body>
  <div class="body">
  		<table style="width:100%">
			<tr>
				<td><b>Gabriele und Peter Strotmann</b></td>
			    <td>              </td>
			    <td>              </td>
			    <td>Tel.: 0231-803441</td>
			</tr>
			<tr>
				<td>Am Gulloh 49</td>
			    <td>              </td>
			    <td>              </td>
			    <td>              </td>
			</tr>
			<tr>
				<td>44339 Dortmund</td>
				<td> </td>
				<td> </td>
			    <td>${form?.briefDatum}</td>
			</tr>
		</table>
		<p><br></br><br></br></p>

		<table>
			<tr>
				<td>${form?.adressAnrede}</td>
			</tr>
			<tr>
				<td>${form?.adressName}</td>
			</tr>
			<tr>
				<td>${form?.strHnr}</td>
			</tr>
			<tr>
				<td>${form?.plzOrt}</td>
			</tr>
		</table>
		<p><br></br><br></br></p>
		<p>${form?.briefAnrede1} ${form?.anredeName},</p>
		<g:if test="${form?.heizkosten > 0}">
			<p>
			als Anlagen senden wir ${form?.briefAnrede2} Ihre Heizkostenabrechnung für den Zeitraum ${form?.heizVon}-${form?.heizBis} und Ihre Nebenkostenabrechnung für das Jahr ${form?.jahr}.
			Unter Berücksichtigung Ihrer Vorauszahlungen ergibt das folgende Betriebskostenabrechnung:
			</p>
		</g:if>
		<g:else>
			<p>
			als Anlagen senden wir ${form?.briefAnrede2} Ihre Nebenkostenabrechnung für das Jahr ${form?.jahr}.
			Unter Berücksichtigung Ihrer Vorauszahlungen ergibt das folgenden Saldo:
			</p>
		</g:else>
		<table>
			<tr>
				<td>    </td><td>Nebenkosten(-)</td><td></td><td><div align = "right"><g:formatNumber number="${form?.nebenkosten}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/> €</div></td>
			</tr>
			<tr>
				<td>    </td><td>Vorauszahlung(+)</td><td></td><td><div align = "right"><g:formatNumber number="${form?.nebenkostenvorauszahlung}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/> €</div></td>
			</tr>
			<g:if test="${form?.heizkosten > 0}">
				<tr>
					<td>    </td><td>Heizkosten(-)</td><td></td><td><div align = "right"><g:formatNumber number="${form?.heizkosten}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/> €</div></td>
				</tr>
				<tr>
					<td>    </td><td>Vorauszahlung(+)</td><td></td><td><div align = "right"><g:formatNumber number="${form?.heizkostenvorauszahlung}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/> €</div></td>
				</tr>
			</g:if>
			<g:if test="${form?.umlageausfallwagnis > 0}">
				<tr>
					<td>    </td><td>2% Umlageausfallwagnis(-)</td><td></td><td><div align = "right"><g:formatNumber number="${form?.umlageausfallwagnis}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/> €</div></td>
				</tr>
			</g:if>
			<tr>
				<td>    </td><td>Saldo</td><td></td><td><div align = "right"><b><g:formatNumber number="${form?.saldo}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/> €</b></div></td>
			</tr>
		</table>
		
		<g:if test="${form?.saldo > 0}">
			<p>
				<g:if test="${form?.mitKonto == 'ja'}">
	     			<p>Ihre Erstatung von <g:formatNumber number= "${form?.saldo.abs()}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/> € überweisen wir an:</p>
	     			<table>
	     			<tr>
	     				<td>Kontoinhaber</td><td>${form?.kontoinhaber}</td> 
	     			</tr>
	     			<tr>
	     				<td>bei</td><td>${form?.bankname}</td> 
	     			</tr>
	     			<tr>
	     				<td>IBAN</td><td>${form?.iban}</td> 
	     			</tr>
	     			</table>
				</g:if>
				<g:else>
	     			<p>Damit wir Ihnen Ihre Erstattung von <g:formatNumber number= "${form?.saldo.abs()}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/> € überweisen können, teilen Sie uns bitte Ihre Bankverbindung mit.</p>
				</g:else>
			</p>
		</g:if>	
		<g:else>
			<p>Bitte überweisen Sie <g:formatNumber number= "${form?.saldo.abs()}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/> € bis zum <g:formatDate format="dd.MM.yyyy" date="${form?.zahlungsziel}"/> an:</p>
			<table>
     			<tr>
     				<td>Kontoinhaber</td><td>Gabriele und Peter Strotmann</td> 
     			</tr>
     			<tr>
     				<td>bei</td><td>Sparkasse Dortmund</td> 
     			</tr>
     			<tr>
     				<td>IBAN</td><td>DE03 4405 0199 0492 0379 07</td> 
     			</tr>
	     	</table>
	     	<g:if test="${form?.bruttomietErhoehung}">
	     		<p>
	     		Auf Grund der gestiegenen Betriebskosten erhöht sich ab <g:formatDate format="dd.MM.yyyy" date="${form?.naechsterErster}"/> Ihre monatliche Vorauszahlung.
	     		<g:if test="${form?.hkErhoehung > 0}">
	     			Ihre Heizkostenvorauszahlung erhöht sich um <g:formatNumber number= "${form?.hkErhoehung}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/> €.
	     		</g:if>
	     		<g:if test="${form?.nkErhoehung > 0}">
	     			Ihre Nebenkostenvorauszahlung erhöht sich um <g:formatNumber number= "${form?.nkErhoehung}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/> €.
	     		</g:if>
	     		Ihre Bruttomiete setzt sich nun wie folgt zusammen:
	     		</p>
	     		<table>
	     			<tr>
						<td>    </td><td>Grundmiete</td><td></td><td><div align = "right"><g:formatNumber number="${form?.grundmiete}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/> €</div></td>
					</tr>
					<g:if test="${form?.heizkosten > 0}">
						<tr>
							<td>    </td><td>Heizkostenvorauszahlung</td><td></td><td><div align = "right"><g:formatNumber number="${form?.heizkostenNeu}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/> €</div></td>
						</tr>
					</g:if>
					<tr>
						<td>    </td><td>Nebenkostenvorauszahlung</td><td></td><td><div align = "right"><g:formatNumber number="${form?.nebenkostenNeu}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/> €</div></td>
					</tr>
					<tr>
						<td>    </td><td>Bruttomiete</td><td></td><td><div align = "right"><b><g:formatNumber number="${form?.bruttomieteNeu}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/> €</b></div></td>
					</tr>
	     		</table>
	     		<p>Bitte passen Sie Ihren Dauerauftrag zum <g:formatDate format="dd.MM.yyyy" date="${form?.naechsterErster}"/> entsprechend an.</p>
	     	</g:if>
		</g:else>
		<p>Mit freundlichen Grüßen</p>	
	</div>
</body>
</html>