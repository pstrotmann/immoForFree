<%@ page import="org.strotmann.immos.Betriebskostenabrechnung" %>



<div class="fieldcontain ${hasErrors(bean: betriebskostenabrechnungInstance, field: 'heizkostenabrechnungen', 'error')} ">
	<label for="heizkostenabrechnungen">
		<g:message code="betriebskostenabrechnung.heizkostenabrechnungen.label" default="Heizkostenabrechnungen" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${betriebskostenabrechnungInstance?.heizkostenabrechnungen?}" var="h">
    <li><g:link controller="heizkostenabrechnung" action="show" id="${h.id}">${h?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="heizkostenabrechnung" action="create" params="['betriebskostenabrechnung.id': betriebskostenabrechnungInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'heizkostenabrechnung.label', default: 'Heizkostenabrechnung')])}</g:link>
</li>
</ul>


</div>

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
		<g:message code="betriebskostenabrechnung.nebenkostenabrechnungen.label" default="Nebenkostenabrechnungen" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${betriebskostenabrechnungInstance?.nebenkostenabrechnungen?}" var="n">
    <li><g:link controller="nebenkostenabrechnung" action="show" id="${n.id}">${n?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="nebenkostenabrechnung" action="create" params="['betriebskostenabrechnung.id': betriebskostenabrechnungInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'nebenkostenabrechnung.label', default: 'Nebenkostenabrechnung')])}</g:link>
</li>
</ul>


</div>

