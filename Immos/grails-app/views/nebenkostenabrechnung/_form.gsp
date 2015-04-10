<%@ page import="org.strotmann.immos.Nebenkostenabrechnung" %>



<div class="fieldcontain ${hasErrors(bean: nebenkostenabrechnungInstance, field: 'betriebskostenabrechnung', 'error')} required">
	<label for="betriebskostenabrechnung">
		<g:message code="nebenkostenabrechnung.betriebskostenabrechnung.label" default="Betriebskostenabrechnung" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="betriebskostenabrechnung" name="betriebskostenabrechnung.id" from="${org.strotmann.immos.Betriebskostenabrechnung.list()}" optionKey="id" required="" value="${nebenkostenabrechnungInstance?.betriebskostenabrechnung?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: nebenkostenabrechnungInstance, field: 'umlageanteile', 'error')} ">
	<label for="umlageanteile">
		<g:message code="nebenkostenabrechnung.umlageanteile.label" default="Umlageanteile" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${nebenkostenabrechnungInstance?.umlageanteile?}" var="u">
    <li><g:link controller="umlageanteil" action="show" id="${u.id}">${u?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="umlageanteil" action="create" params="['nebenkostenabrechnung.id': nebenkostenabrechnungInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'umlageanteil.label', default: 'Umlageanteil')])}</g:link>
</li>
</ul>


</div>

