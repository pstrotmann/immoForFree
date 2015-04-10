<%@ page import="org.strotmann.immos.Bankumsatz" %>



<div class="fieldcontain ${hasErrors(bean: bankumsatzInstance, field: 'auftragskonto', 'error')} ">
	<label for="auftragskonto">
		<g:message code="bankumsatz.auftragskonto.label" default="Auftragskonto" />
		
	</label>
	<g:textField name="auftragskonto" value="${bankumsatzInstance?.auftragskonto}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bankumsatzInstance, field: 'buchungstag', 'error')} ">
	<label for="buchungstag">
		<g:message code="bankumsatz.buchungstag.label" default="Buchungstag" />
		
	</label>
	<g:textField name="buchungstag" value="${bankumsatzInstance?.buchungstag}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bankumsatzInstance, field: 'valutadatum', 'error')} ">
	<label for="valutadatum">
		<g:message code="bankumsatz.valutadatum.label" default="Valutadatum" />
		
	</label>
	<g:textField name="valutadatum" value="${bankumsatzInstance?.valutadatum}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bankumsatzInstance, field: 'buchungstext', 'error')} ">
	<label for="buchungstext">
		<g:message code="bankumsatz.buchungstext.label" default="Buchungstext" />
		
	</label>
	<g:textField name="buchungstext" value="${bankumsatzInstance?.buchungstext}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bankumsatzInstance, field: 'verwendungszweck', 'error')} ">
	<label for="verwendungszweck">
		<g:message code="bankumsatz.verwendungszweck.label" default="Verwendungszweck" />
		
	</label>
	<g:textField name="verwendungszweck" value="${bankumsatzInstance?.verwendungszweck}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bankumsatzInstance, field: 'glaeubigerId', 'error')} ">
	<label for="glaeubigerId">
		<g:message code="bankumsatz.glaeubigerId.label" default="Glaeubiger Id" />
		
	</label>
	<g:textField name="glaeubigerId" value="${bankumsatzInstance?.glaeubigerId}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bankumsatzInstance, field: 'mandatsreferenz', 'error')} ">
	<label for="mandatsreferenz">
		<g:message code="bankumsatz.mandatsreferenz.label" default="Mandatsreferenz" />
		
	</label>
	<g:textField name="mandatsreferenz" value="${bankumsatzInstance?.mandatsreferenz}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bankumsatzInstance, field: 'kundenreferenz', 'error')} ">
	<label for="kundenreferenz">
		<g:message code="bankumsatz.kundenreferenz.label" default="Kundenreferenz" />
		
	</label>
	<g:textField name="kundenreferenz" value="${bankumsatzInstance?.kundenreferenz}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bankumsatzInstance, field: 'sammlerreferenz', 'error')} ">
	<label for="sammlerreferenz">
		<g:message code="bankumsatz.sammlerreferenz.label" default="Sammlerreferenz" />
		
	</label>
	<g:textField name="sammlerreferenz" value="${bankumsatzInstance?.sammlerreferenz}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bankumsatzInstance, field: 'lastschriftUrsprungsbetrag', 'error')} ">
	<label for="lastschriftUrsprungsbetrag">
		<g:message code="bankumsatz.lastschriftUrsprungsbetrag.label" default="Lastschrift Ursprungsbetrag" />
		
	</label>
	<g:textField name="lastschriftUrsprungsbetrag" value="${bankumsatzInstance?.lastschriftUrsprungsbetrag}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bankumsatzInstance, field: 'auslagenersatzRuecklastschrift', 'error')} ">
	<label for="auslagenersatzRuecklastschrift">
		<g:message code="bankumsatz.auslagenersatzRuecklastschrift.label" default="Auslagenersatz Ruecklastschrift" />
		
	</label>
	<g:textField name="auslagenersatzRuecklastschrift" value="${bankumsatzInstance?.auslagenersatzRuecklastschrift}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bankumsatzInstance, field: 'beguenstigterZahlungspflichtiger', 'error')} ">
	<label for="beguenstigterZahlungspflichtiger">
		<g:message code="bankumsatz.beguenstigterZahlungspflichtiger.label" default="Beguenstigter Zahlungspflichtiger" />
		
	</label>
	<g:textField name="beguenstigterZahlungspflichtiger" value="${bankumsatzInstance?.beguenstigterZahlungspflichtiger}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bankumsatzInstance, field: 'kontonummerIBAN', 'error')} ">
	<label for="kontonummerIBAN">
		<g:message code="bankumsatz.kontonummerIBAN.label" default="Kontonummer IBAN" />
		
	</label>
	<g:textField name="kontonummerIBAN" value="${bankumsatzInstance?.kontonummerIBAN}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bankumsatzInstance, field: 'bic', 'error')} ">
	<label for="bic">
		<g:message code="bankumsatz.bic.label" default="Bic" />
		
	</label>
	<g:textField name="bic" value="${bankumsatzInstance?.bic}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bankumsatzInstance, field: 'betrag', 'error')} ">
	<label for="betrag">
		<g:message code="bankumsatz.betrag.label" default="Betrag" />
		
	</label>
	<g:textField name="betrag" value="${bankumsatzInstance?.betrag}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bankumsatzInstance, field: 'waehrung', 'error')} ">
	<label for="waehrung">
		<g:message code="bankumsatz.waehrung.label" default="Waehrung" />
		
	</label>
	<g:textField name="waehrung" value="${bankumsatzInstance?.waehrung}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bankumsatzInstance, field: 'info', 'error')} ">
	<label for="info">
		<g:message code="bankumsatz.info.label" default="Info" />
		
	</label>
	<g:textField name="info" value="${bankumsatzInstance?.info}"/>
</div>



