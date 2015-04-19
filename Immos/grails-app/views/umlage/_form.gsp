<%@ page import="org.strotmann.immos.Umlage" %>



<div class="fieldcontain ${hasErrors(bean: umlageInstance, field: 'kostenart', 'error')} ">
	<label for="kostenart">
		<g:message code="umlage.kostenart.label" default="Kostenart" />
		
	</label>
	<g:select name="kostenart" from="${Umlage.kostenarten}" value="${umlageInstance?.kostenart}" valueMessagePrefix="umlage.kostenart" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: umlageInstance, field: 'umlageschluessel', 'error')} ">
	<label for="umlageschluessel">
		<g:message code="umlage.umlageschluessel.label" default="Umlageschlüssel" />
		
	</label>
	<g:select name="umlageschluessel" from="${Umlage.umlageschluessels}" value="${umlageInstance?.umlageschluessel}" valueMessagePrefix="umlage.umlageschluessel" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: umlageInstance, field: 'betrag', 'error')} required">
	<label for="betrag">
		<g:message code="umlage.betrag.label" default="Betrag" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="betrag" value="${fieldValue(bean: umlageInstance, field: 'betrag')}" required=""/>
	
</div>

<div class="fieldcontain ${hasErrors(bean: umlageInstance, field: 'immoabrechnung', 'error')} required">
	<label for="immoabrechnung">
		<g:message code="umlage.immoabrechnung.label" default="Immoabrechnung" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="immoabrechnung" name="immoabrechnung.id" from="${org.strotmann.immos.Immoabrechnung.list()}" optionKey="id" required="" value="${umlageInstance?.immoabrechnung?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: umlageInstance, field: 'zaehler', 'error')} ">
	<label for="zaehler">
		<g:message code="umlage.zaehler.label" default="Zähler" />
	</label>
	<g:select id="zaehler" name="zaehler.id" from="${umlageInstance.zaehlers}" optionKey="id" required="" value="${umlageInstance?.zaehler?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: umlageInstance, field: 'umlageanteile', 'error')} ">
	<label for="umlageanteile">
		<g:message code="umlage.umlageanteile.label" default="Umlageanteile" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${umlageInstance?.umlageanteile?}" var="u">
    <li><g:link controller="umlageanteil" action="show" id="${u.id}">${u?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="umlageanteil" action="create" params="['umlage.id': umlageInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'umlageanteil.label', default: 'Umlageanteil')])}</g:link>
</li>
</ul>

</div>


