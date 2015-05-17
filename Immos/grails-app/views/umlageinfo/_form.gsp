<%@ page import="org.strotmann.immos.Umlageinfo" %>
<%@ page import="org.strotmann.immos.Umlage" %>
<%@ page import="org.strotmann.immos.Dienstleistungsvertrag" %>
<%@ page import="org.strotmann.immos.Mietsache" %>
<%@ page import="org.strotmann.immos.Rechnung" %>
<%@ page import="org.strotmann.immos.Immobilie" %>

<g:if test="${flash.rechnung}">
<div class="fieldcontain ${hasErrors(bean: umlageinfoInstance, field: 'rechnung', 'error')} required">
	<label for="rechnung">
		<g:message code="umlageinfo.rechnung.label" default="Rechnung" />
	</label>
		<g:select id="rechnung" name="rechnung.id" from="${flash.rechnung}" optionKey="id" value="${umlageinfoInstance?.rechnung?.id}" class="many-to-one"/>
</div>
</g:if>
<g:elseif test="${flash.dienstleistungsvertrag}">
<div class="fieldcontain ${hasErrors(bean: umlageinfoInstance, field: 'dienstleistungsvertrag', 'error')} required">
	<label for="dienstleistungsvertrag">
		<g:message code="umlageinfo.dienstleistungsvertrag.label" default="Dienstleistungsvertrag" />
	</label>
		<g:select id="dienstleistungsvertrag" name="dienstleistungsvertrag.id" from="${flash.dienstleistungsvertrag}" optionKey="id" required="" value="${umlageinfoInstance?.dienstleistungsvertrag?.id}" class="many-to-one"/>
</div>
</g:elseif>
<g:else>
<div class="fieldcontain ${hasErrors(bean: umlageinfoInstance, field: 'rechnung', 'error')}">
	<label for="rechnung">
		<g:message code="umlageinfo.rechnung.label" default="Rechnung" />
	</label>
		<g:select id="rechnung" name="rechnung.id" from="${Rechnung.rechnungen}" optionKey="id" value="${umlageinfoInstance?.rechnung?.id}" class="many-to-one" noSelection="['': '']"/>
</div>
<div class="fieldcontain ${hasErrors(bean: umlageinfoInstance, field: 'dienstleistungsvertrag', 'error')}">
	<label for="dienstleistungsvertrag">
		<g:message code="umlageinfo.dienstleistungsvertrag.label" default="Dienstleistungsvertrag" />
	</label>
		<g:select id="dienstleistungsvertrag" name="dienstleistungsvertrag.id" from="${Dienstleistungsvertrag.dienstleistungsvertraege}" optionKey="id" value="${umlageinfoInstance?.dienstleistungsvertrag?.id}" class="many-to-one" noSelection="['': '']"/>
</div>
</g:else>

<div class="fieldcontain ${hasErrors(bean: umlageinfoInstance, field: 'art', 'error')} ">
	<label for="art">
		<g:message code="umlageinfo.art.label" default="Art" />
		
	</label>
	<g:select name="art" from="${umlageinfoInstance.constraints.art.inList}" value="${umlageinfoInstance?.art}" valueMessagePrefix="umlageinfo.art" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: umlageinfoInstance, field: 'von', 'error')} required">
	<label for="von">
		<g:message code="umlageinfo.von.label" default="Von" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="von" precision="day"  value="${umlageinfoInstance.von?:Umlageinfo.anfangVorjahr}" years="${2010..2020}" />
</div>

<div class="fieldcontain ${hasErrors(bean: umlageinfoInstance, field: 'bis', 'error')} required">
	<label for="bis">
		<g:message code="umlageinfo.bis.label" default="Bis" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="bis" precision="day"  value="${umlageinfoInstance.bis?:Umlageinfo.endeVorjahr}" years="${2010..2020}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: umlageinfoInstance, field: 'kostenart', 'error')} required">
	<label for="kostenart">
		<g:message code="umlageinfo.kostenart.label" default="Kostenart" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="kostenart" from="${Umlage.kostenarten}" value="${umlageinfoInstance?.kostenart}" valueMessagePrefix="umlageinfo.kostenart" noSelection="['': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: umlageinfoInstance, field: 'umlageschluessel', 'error')} required">
	<label for="umlageschluessel">
		<g:message code="umlageinfo.umlageschluessel.label" default="Umlageschluessel" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="umlageschluessel" from="${umlageinfoInstance.constraints.umlageschluessel.inList}" required="" value="${umlageinfoInstance?.umlageschluessel}" valueMessagePrefix="umlageinfo.umlageschluessel"/>

</div>

<div class="fieldcontain ${hasErrors(bean: umlageinfoInstance, field: 'verbrauch', 'error')} ">
	<label for="verbrauch">
		<g:message code="umlageinfo.verbrauch.label" default="Verbrauch" />
		
	</label>
	<g:field name="verbrauch" value="${fieldValue(bean: umlageinfoInstance, field: 'verbrauch')}" type="number"/>
</div>

<div class="fieldcontain ${hasErrors(bean: umlageinfoInstance, field: 'einheit', 'error')} ">
	<label for="einheit">
		<g:message code="umlageinfo.einheit.label" default="Einheit" />
		
	</label>
	<g:select name="einheit" from="${Umlageinfo.einheiten}" value="${umlageinfoInstance?.einheit}" valueMessagePrefix="umlageinfo.einheit" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: umlageinfoInstance, field: 'umlageAuf', 'error')} ">
	<label for="umlageAuf">
		<g:message code="umlageinfo.umlageAuf.label" default="Umlage Auf" />
		
	</label>
	<g:if test="${flash.rechnung}">
	<g:select id="umlageAuf" name="umlageAuf.id" from="${Mietsache.mietsachenZuImmo(flash.rechnung.immobilie.id)}" optionKey="id" value="${umlageinfoInstance?.umlageAuf?.id}" class="many-to-one" noSelection="['null': '']"/>
	</g:if>
	<g:if test="${flash.dienstleistungsvertrag}">
	<g:select id="umlageAuf" name="umlageAuf.id" from="${Mietsache.mietsachenZuImmo(flash.dienstleistungsvertrag.immobilie.id)}" optionKey="id" value="${umlageinfoInstance?.umlageAuf?.id}" class="many-to-one" noSelection="['null': '']"/>
	</g:if>
</div>

<div class="fieldcontain ${hasErrors(bean: umlageinfoInstance, field: 'abrDatum', 'error')} ">
	<label for="abrDatum">
		<g:message code="umlageinfo.abrDatum" default="Abrechnungsdatum" />
	</label>
	<g:datePicker name="abrDatum" value="${umlageinfoInstance?.abrDatum}" precision="day" years="${2010..2020}" />

</div>

<div class="fieldcontain ${hasErrors(bean: umlageinfoInstance, field: 'abrBetrag', 'error')} ">
	<label for="abrBetrag">
		<g:message code="umlageinfo.abrBetrag" default="Abrechnungsbetrag" />
	</label>
	<g:field name="abrBetrag" value="${fieldValue(bean: umlageinfoInstance, field: 'abrBetrag')}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: umlageinfoInstance, field: 'abrGegenstand', 'error')} ">
	<label for="abrGegenstand">
		<g:message code="umlageinfo.abrGegenstand" default="Abrechnungsgegenstand" />
	</label>
	<g:textField name="abrGegenstand" maxlength="50"  value="${umlageinfoInstance?.abrGegenstand}"/>

</div>




