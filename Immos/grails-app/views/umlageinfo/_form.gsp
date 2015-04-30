<%@ page import="org.strotmann.immos.Umlageinfo" %>
<%@ page import="org.strotmann.immos.Umlage" %>
<%@ page import="org.strotmann.immos.Dienstleistungsvertrag" %>
<%@ page import="org.strotmann.immos.Mietsache" %>

<div class="fieldcontain ${hasErrors(bean: umlageinfoInstance, field: 'rechnung', 'error')} required">
	<label for="rechnung">
		<g:message code="umlageinfo.rechnung.label" default="Rechnung" />
		<span class="required-indicator">*</span>
	</label>
	<g:if test="${flash.rechnung}">
		<g:select id="rechnung" name="rechnung.id" from="${flash.rechnung}" optionKey="id" required="" value="${umlageinfoInstance?.rechnung?.id}" class="many-to-one"/>
	</g:if>
</div>

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
	<g:datePicker name="von" precision="day"  value="${Umlageinfo.anfangVorjahr}" years="${2010..2020}" />

</div>

<div class="fieldcontain ${hasErrors(bean: umlageinfoInstance, field: 'bis', 'error')} required">
	<label for="bis">
		<g:message code="umlageinfo.bis.label" default="Bis" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="bis" precision="day"  value="${Umlageinfo.endeVorjahr}"  />

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
	<g:field name="verbrauch" value="${fieldValue(bean: umlageinfoInstance, field: 'verbrauch')}"/>
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
	<g:select id="umlageAuf" name="umlageAuf.id" from="${Mietsache.mietsachenZuImmo(flash.rechnung)}" optionKey="id" value="${umlageinfoInstance?.umlageAuf?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: umlageinfoInstance, field: 'dienstleistungsvertrag', 'error')} ">
	<label for="dienstleistungsvertrag">
		<g:message code="umlageinfo.dienstleistungsvertrag.label" default="Dienstleistungsvertrag" />
		
	</label>
	<g:select id="dienstleistungsvertrag" name="dienstleistungsvertrag.id" from="${Dienstleistungsvertrag.dienstleistungsvertraegeZuImmo(flash.rechnung)}" optionKey="id" value="${umlageinfoInstance?.dienstleistungsvertrag?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>


