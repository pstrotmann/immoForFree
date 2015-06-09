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
		    margin: 0.25in;
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
				<td>Gabriele und Peter Strotmann</td>
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
		<p></p><p></p><p></p><p></p><p></p><p></p>
		<p></p><p></p><p></p><p></p><p></p><p></p>
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
		<p></p><p></p><p></p><p></p><p></p><p></p>
		<p></p><p></p><p></p><p></p><p></p><p></p>
		<p>${form?.briefAnrede1} ${form?.anredeName},</p>
		<p></p><p></p>
		<p>als Anlage senden wir ${form?.briefAnrede2} die Betriebskostenabrechnung für das Jahr ${form?.jahr}.</p>
		<p>Ihre Erstatung beträgt ${form?.erstattung}€</p>
		<p>
			<g:if test="${form?.mitKonto == 'ja'}">
     			Wir überweisen auf:
     			<p>${form?.kto},${form?.blz}</p> 
			</g:if>
			<g:else>
     			Bitte geben Sie Ihre Bankverbindung an.
			</g:else>
		</p>		
	</div>
</body>
</html>