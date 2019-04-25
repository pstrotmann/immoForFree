<%@ page import="org.strotmann.immos.Betriebskostenabrechnungsbrief" %>



<div class="fieldcontain ${hasErrors(bean: betriebskostenabrechnungsbriefInstance, field: 'adressAnrede', 'error')} required">
	<label for="adressAnrede">
		<g:message code="betriebskostenabrechnungsbrief.adressAnrede.label" default="Adress Anrede" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="adressAnrede" required="" value="${betriebskostenabrechnungsbriefInstance?.adressAnrede}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: betriebskostenabrechnungsbriefInstance, field: 'adressName', 'error')} required">
	<label for="adressName">
		<g:message code="betriebskostenabrechnungsbrief.adressName.label" default="Adress Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="adressName" required="" value="${betriebskostenabrechnungsbriefInstance?.adressName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: betriebskostenabrechnungsbriefInstance, field: 'anredeName', 'error')} required">
	<label for="anredeName">
		<g:message code="betriebskostenabrechnungsbrief.anredeName.label" default="Anrede Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="anredeName" required="" value="${betriebskostenabrechnungsbriefInstance?.anredeName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: betriebskostenabrechnungsbriefInstance, field: 'bankname', 'error')} required">
	<label for="bankname">
		<g:message code="betriebskostenabrechnungsbrief.bankname.label" default="Bankname" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="bankname" required="" value="${betriebskostenabrechnungsbriefInstance?.bankname}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: betriebskostenabrechnungsbriefInstance, field: 'betriebskostenabrechnung', 'error')} required">
	<label for="betriebskostenabrechnung">
		<g:message code="betriebskostenabrechnungsbrief.betriebskostenabrechnung.label" default="Betriebskostenabrechnung" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="betriebskostenabrechnung" name="betriebskostenabrechnung.id" from="${org.strotmann.immos.Betriebskostenabrechnung.list()}" optionKey="id" required="" value="${betriebskostenabrechnungsbriefInstance?.betriebskostenabrechnung?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: betriebskostenabrechnungsbriefInstance, field: 'blz', 'error')} required">
	<label for="blz">
		<g:message code="betriebskostenabrechnungsbrief.blz.label" default="Blz" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="blz" required="" value="${betriebskostenabrechnungsbriefInstance?.blz}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: betriebskostenabrechnungsbriefInstance, field: 'briefAnrede1', 'error')} required">
	<label for="briefAnrede1">
		<g:message code="betriebskostenabrechnungsbrief.briefAnrede1.label" default="Brief Anrede1" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="briefAnrede1" required="" value="${betriebskostenabrechnungsbriefInstance?.briefAnrede1}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: betriebskostenabrechnungsbriefInstance, field: 'briefAnrede2', 'error')} required">
	<label for="briefAnrede2">
		<g:message code="betriebskostenabrechnungsbrief.briefAnrede2.label" default="Brief Anrede2" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="briefAnrede2" required="" value="${betriebskostenabrechnungsbriefInstance?.briefAnrede2}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: betriebskostenabrechnungsbriefInstance, field: 'briefDatum', 'error')} required">
	<label for="briefDatum">
		<g:message code="betriebskostenabrechnungsbrief.briefDatum.label" default="Brief Datum" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="briefDatum" required="" value="${betriebskostenabrechnungsbriefInstance?.briefDatum}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: betriebskostenabrechnungsbriefInstance, field: 'nebenkostenvorauszahlung', 'error')} required">
	<label for="nebenkostenvorauszahlung">
		<g:message code="betriebskostenabrechnungsbrief.nebenkostenvorauszahlung.label" default="Nebenkostenvorauszahlung" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nebenkostenvorauszahlung" required="" value="${betriebskostenabrechnungsbriefInstance?.nebenkostenvorauszahlung}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: betriebskostenabrechnungsbriefInstance, field: 'nebenkosten', 'error')} required">
	<label for="nebenkosten">
		<g:message code="betriebskostenabrechnungsbrief.nebenkosten.label" default="Nebenkosten" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nebenkosten" required="" value="${betriebskostenabrechnungsbriefInstance?.nebenkosten}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: betriebskostenabrechnungsbriefInstance, field: 'heizkostenvorauszahlung', 'error')} required">
	<label for="heizkostenvorauszahlung">
		<g:message code="betriebskostenabrechnungsbrief.heizkostenvorauszahlung.label" default="Heizkostenvorauszahlung" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="heizkostenvorauszahlung" required="" value="${betriebskostenabrechnungsbriefInstance?.heizkostenvorauszahlung}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: betriebskostenabrechnungsbriefInstance, field: 'heizkosten', 'error')} required">
	<label for="heizkosten">
		<g:message code="betriebskostenabrechnungsbrief.heizkosten.label" default="Heizkosten" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="heizkosten" required="" value="${betriebskostenabrechnungsbriefInstance?.heizkosten}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: betriebskostenabrechnungsbriefInstance, field: 'saldo', 'error')} required">
	<label for="saldo">
		<g:message code="betriebskostenabrechnungsbrief.saldo.label" default="Saldo" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="saldo" required="" value="${betriebskostenabrechnungsbriefInstance?.saldo}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: betriebskostenabrechnungsbriefInstance, field: 'erstattung', 'error')} required">
	<label for="erstattung">
		<g:message code="betriebskostenabrechnungsbrief.erstattung.label" default="Erstattung" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="erstattung" required="" value="${betriebskostenabrechnungsbriefInstance?.erstattung}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: betriebskostenabrechnungsbriefInstance, field: 'jahr', 'error')} required">
	<label for="jahr">
		<g:message code="betriebskostenabrechnungsbrief.jahr.label" default="Jahr" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="jahr" required="" value="${betriebskostenabrechnungsbriefInstance?.jahr}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: betriebskostenabrechnungsbriefInstance, field: 'kontoinhaber', 'error')} required">
	<label for="kontoinhaber">
		<g:message code="betriebskostenabrechnungsbrief.kontoinhaber.label" default="Kontoinhaber" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="kontoinhaber" required="" value="${betriebskostenabrechnungsbriefInstance?.kontoinhaber}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: betriebskostenabrechnungsbriefInstance, field: 'kto', 'error')} required">
	<label for="kto">
		<g:message code="betriebskostenabrechnungsbrief.kto.label" default="Kto" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="kto" required="" value="${betriebskostenabrechnungsbriefInstance?.kto}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: betriebskostenabrechnungsbriefInstance, field: 'mitKonto', 'error')} required">
	<label for="mitKonto">
		<g:message code="betriebskostenabrechnungsbrief.mitKonto.label" default="Mit Konto" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="mitKonto" required="" value="${betriebskostenabrechnungsbriefInstance?.mitKonto}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: betriebskostenabrechnungsbriefInstance, field: 'plzOrt', 'error')} required">
	<label for="plzOrt">
		<g:message code="betriebskostenabrechnungsbrief.plzOrt.label" default="Plz Ort" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="plzOrt" required="" value="${betriebskostenabrechnungsbriefInstance?.plzOrt}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: betriebskostenabrechnungsbriefInstance, field: 'strHnr', 'error')} required">
	<label for="strHnr">
		<g:message code="betriebskostenabrechnungsbrief.strHnr.label" default="Str Hnr" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="strHnr" required="" value="${betriebskostenabrechnungsbriefInstance?.strHnr}"/>

</div>

