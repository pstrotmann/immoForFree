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
		<p>als Anlagen senden wir ${form?.briefAnrede2} Ihre Heizkostenabrechnung für den Zeitraum ${form?.heizVon}-${form?.heizBis} und Ihre Nebenkostenabrechnung für das Jahr ${form?.jahr}.</p>
		<p>Unter Berücksichtigung Ihrer Vorauszahlungen ergibt das folgende Betriebskostenabrechnung:</p>
		
		<table>
			<tr>
				<td>    </td><td>Nebenkosten</td><td></td><td><div align = "right"><g:formatNumber number="${form?.nebenkosten}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/> €</div></td>
			</tr>
			<tr>
				<td>    </td><td> - vorauszahlung</td><td></td><td><div align = "right"><g:formatNumber number="${form?.nebenkostenvorauszahlung}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/> €</div></td>
			</tr>
			<tr>
				<td>    </td><td>Heizkosten</td><td></td><td><div align = "right"><g:formatNumber number="${form?.heizkosten}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/> €</div></td>
			</tr>
			<tr>
				<td>    </td><td> - vorauszahlung</td><td></td><td><div align = "right"><g:formatNumber number="${form?.heizkostenvorauszahlung}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/> €</div></td>
			</tr>
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
	     				<td>Bankleitzahl</td><td>${form?.blz}</td> 
	     			</tr>
	     			<tr>
	     				<td>Konto</td><td>${form?.kto}</td> 
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
			<p>Bitte überweisen Sie <g:formatNumber number= "${form?.saldo.abs()}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/> € an:</p>
			<table>
	     			<tr>
	     				<td>Kontoinhaber</td><td>Gabriele und Peter Strotmann</td> 
	     			</tr>
	     			<tr>
	     				<td>bei</td><td>Sparkasse Dortmund</td> 
	     			</tr>
	     			<tr>
	     				<td>Bankleitzahl</td><td>440 501 99</td> 
	     			</tr>
	     			<tr>
	     				<td>Konto</td><td>492 037 907</td> 
	     			</tr>
	     			<tr>
	     				<td>IBAN</td><td>DE03 4405 0199 0492 0379 07</td> 
	     			</tr>
	     			</table>
		</g:else>	
	</div>
</body>
</html>