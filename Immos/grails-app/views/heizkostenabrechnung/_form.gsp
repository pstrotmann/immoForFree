<%@ page import="org.strotmann.immos.Heizkostenabrechnung" %>



<div class="fieldcontain ${hasErrors(bean: heizkostenabrechnungInstance, field: 'von', 'error')} required">
	<label for="von">
		<g:message code="heizkostenabrechnung.von.label" default="Von" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="von" precision="day"  value="${heizkostenabrechnungInstance?.von}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: heizkostenabrechnungInstance, field: 'bis', 'error')} required">
	<label for="bis">
		<g:message code="heizkostenabrechnung.bis.label" default="Bis" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="bis" precision="day"  value="${heizkostenabrechnungInstance?.bis}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: heizkostenabrechnungInstance, field: 'betrag', 'error')} required">
	<label for="betrag">
		<g:message code="heizkostenabrechnung.betrag.label" default="Betrag" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="betrag" value="${fieldValue(bean: heizkostenabrechnungInstance, field: 'betrag')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: heizkostenabrechnungInstance, field: 'betriebskostenabrechnung', 'error')} required">
	<label for="betriebskostenabrechnung">
		<g:message code="heizkostenabrechnung.betriebskostenabrechnung.label" default="Betriebskostenabrechnung" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="betriebskostenabrechnung" name="betriebskostenabrechnung.id" from="${org.strotmann.immos.Betriebskostenabrechnung.list()}" optionKey="id" required="" value="${heizkostenabrechnungInstance?.betriebskostenabrechnung?.id}" class="many-to-one"/>

</div>

