<%@ page import="org.strotmann.immos.Umlageinfo" %>



<div class="fieldcontain ${hasErrors(bean: umlageinfoInstance, field: 'von', 'error')} required">
	<label for="von">
		<g:message code="umlageinfo.von.label" default="Von" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="von" precision="day"  value="${umlageinfoInstance?.von}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: umlageinfoInstance, field: 'bis', 'error')} required">
	<label for="bis">
		<g:message code="umlageinfo.bis.label" default="Bis" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="bis" precision="day"  value="${umlageinfoInstance?.bis}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: umlageinfoInstance, field: 'kostenart', 'error')} required">
	<label for="kostenart">
		<g:message code="umlageinfo.kostenart.label" default="Kostenart" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="kostenart" required="" value="${umlageinfoInstance?.kostenart}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: umlageinfoInstance, field: 'umlageschluessel', 'error')} required">
	<label for="umlageschluessel">
		<g:message code="umlageinfo.umlageschluessel.label" default="Umlageschluessel" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="umlageschluessel" from="${umlageinfoInstance.constraints.umlageschluessel.inList}" required="" value="${umlageinfoInstance?.umlageschluessel}" valueMessagePrefix="umlageinfo.umlageschluessel"/>

</div>

<div class="fieldcontain ${hasErrors(bean: umlageinfoInstance, field: 'umlageAuf', 'error')} ">
	<label for="umlageAuf">
		<g:message code="umlageinfo.umlageAuf.label" default="Umlage Auf" />
		
	</label>
	<g:select id="umlageAuf" name="umlageAuf.id" from="${org.strotmann.immos.Mietsache.list()}" optionKey="id" value="${umlageinfoInstance?.umlageAuf?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: umlageinfoInstance, field: 'teilbescheidVon', 'error')} ">
	<label for="teilbescheidVon">
		<g:message code="umlageinfo.teilbescheidVon.label" default="Teilbescheid Von" />
		
	</label>
	<g:select id="teilbescheidVon" name="teilbescheidVon.id" from="${org.strotmann.immos.Dienstleistungsvertrag.list()}" optionKey="id" value="${umlageinfoInstance?.teilbescheidVon?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: umlageinfoInstance, field: 'rechnung', 'error')} required">
	<label for="rechnung">
		<g:message code="umlageinfo.rechnung.label" default="Rechnung" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="rechnung" name="rechnung.id" from="${org.strotmann.immos.Rechnung.list()}" optionKey="id" required="" value="${umlageinfoInstance?.rechnung?.id}" class="many-to-one"/>

</div>

