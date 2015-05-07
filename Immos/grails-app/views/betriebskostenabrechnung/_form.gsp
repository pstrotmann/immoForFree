<%@ page import="org.strotmann.immos.Betriebskostenabrechnung" %>





<div class="fieldcontain ${hasErrors(bean: betriebskostenabrechnungInstance, field: 'immoabrechnung', 'error')} required">
	<label for="immoabrechnung">
		<g:message code="betriebskostenabrechnung.immoabrechnung.label" default="Immoabrechnung" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="immoabrechnung" name="immoabrechnung.id" from="${org.strotmann.immos.Immoabrechnung.list()}" optionKey="id" required="" value="${betriebskostenabrechnungInstance?.immoabrechnung?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: betriebskostenabrechnungInstance, field: 'mietvertrag', 'error')} required">
	<label for="mietvertrag">
		<g:message code="betriebskostenabrechnung.mietvertrag.label" default="Mietvertrag" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="mietvertrag" name="mietvertrag.id" from="${org.strotmann.immos.Mietvertrag.list()}" optionKey="id" required="" value="${betriebskostenabrechnungInstance?.mietvertrag?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: betriebskostenabrechnungInstance, field: 'nebenkostenabrechnungen', 'error')} ">
	<label for="nebenkostenabrechnungen">
		<g:message code="betriebskostenabrechnung.nebenkostenabrechnungen.label" default="Nebenkostenabrechnung" />
		
	</label>
	
<ul class="one-to-many">
<g:if test="${betriebskostenabrechnungInstance?.nebenkostenabrechnung}">
	<li><g:link controller="nebenkostenabrechnung" action="show" id="${betriebskostenabrechnungInstance?.nebenkostenabrechnung.id}">${betriebskostenabrechnungInstance?.nebenkostenabrechnung?.encodeAsHTML()}</g:link></li>
</g:if>
<g:else>
<li class="add">
<g:link controller="nebenkostenabrechnung" action="create" params="['betriebskostenabrechnung.id': betriebskostenabrechnungInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'nebenkostenabrechnung.label', default: 'Nebenkostenabrechnung')])}</g:link>
</li>
</g:else>
</ul>
</div>

<div class="fieldcontain ${hasErrors(bean: betriebskostenabrechnungInstance, field: 'heizkostenabrechnungen', 'error')} ">
	<label for="heizkostenabrechnungen">
		<g:message code="betriebskostenabrechnung.heizkostenabrechnungen.label" default="Heizkostenabrechnung" />
		
	</label>
	
<ul class="one-to-many">
<g:if test="${betriebskostenabrechnungInstance?.heizkostenabrechnung}">
	<li><g:link controller="heizkostenabrechnung" action="show" id="${betriebskostenabrechnungInstance?.heizkostenabrechnung.id}">${betriebskostenabrechnungInstance?.heizkostenabrechnung?.encodeAsHTML()}</g:link></li>
</g:if>
<g:else>
<li class="add">
<g:link controller="heizkostenabrechnung" action="create" params="['betriebskostenabrechnung.id': betriebskostenabrechnungInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'heizkostenabrechnung.label', default: 'Heizkostenabrechnung')])}</g:link>
</li>
</g:else>
</ul>


</div>

