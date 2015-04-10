<%@ page import="org.strotmann.immos.Umlageanteil" %>



<div class="fieldcontain ${hasErrors(bean: umlageanteilInstance, field: 'kostenart', 'error')} ">
	<label for="kostenart">
		<g:message code="umlageanteil.kostenart.label" default="Kostenart" />
		
	</label>
	<g:select name="kostenart" from="${umlageanteilInstance.constraints.kostenart.inList}" value="${umlageanteilInstance?.kostenart}" valueMessagePrefix="umlageanteil.kostenart" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: umlageanteilInstance, field: 'umlageschluessel', 'error')} ">
	<label for="umlageschluessel">
		<g:message code="umlageanteil.umlageschluessel.label" default="Umlageschluessel" />
		
	</label>
	<g:select name="umlageschluessel" from="${umlageanteilInstance.constraints.umlageschluessel.inList}" value="${umlageanteilInstance?.umlageschluessel}" valueMessagePrefix="umlageanteil.umlageschluessel" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: umlageanteilInstance, field: 'betrag', 'error')} required">
	<label for="betrag">
		<g:message code="umlageanteil.betrag.label" default="Betrag" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="betrag" value="${fieldValue(bean: umlageanteilInstance, field: 'betrag')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: umlageanteilInstance, field: 'nebenkostenabrechnung', 'error')} required">
	<label for="nebenkostenabrechnung">
		<g:message code="umlageanteil.nebenkostenabrechnung.label" default="Nebenkostenabrechnung" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="nebenkostenabrechnung" name="nebenkostenabrechnung.id" from="${org.strotmann.immos.Nebenkostenabrechnung.list()}" optionKey="id" required="" value="${umlageanteilInstance?.nebenkostenabrechnung?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: umlageanteilInstance, field: 'umlage', 'error')} required">
	<label for="umlage">
		<g:message code="umlageanteil.umlage.label" default="Umlage" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="umlage" name="umlage.id" from="${org.strotmann.immos.Umlage.list()}" optionKey="id" required="" value="${umlageanteilInstance?.umlage?.id}" class="many-to-one"/>
</div>

