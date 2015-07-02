<%@ page import="org.strotmann.immos.Zwischenzaehler" %>



<div class="fieldcontain ${hasErrors(bean: zwischenzaehlerInstance, field: 'zaehlernummer', 'error')} ">
	<label for="zaehlernummer">
		<g:message code="zwischenzaehler.zaehlernummer.label" default="Zählernummer" />
		
	</label>
	<g:textField name="zaehlernummer" value="${zwischenzaehlerInstance?.zaehlernummer}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: zwischenzaehlerInstance, field: 'mietsache', 'error')} required">
	<label for="mietsache">
		<g:message code="zwischenzaehler.mietsache.label" default="Mietsache" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="mietsache" name="mietsache.id" from="${zwischenzaehlerInstance?.mietsache}" optionKey="id" required="" value="${zwischenzaehlerInstance?.mietsache?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: zwischenzaehlerInstance, field: 'stattZaehler', 'error')} ">
	<label for="stattZaehler">
		<g:message code="zwischenzaehler.stattZaehler.label" default="statt Zähler abrechnen" />
		
	</label>
	<g:checkBox name="stattZaehler" value="${zwischenzaehlerInstance?.stattZaehler}" />
</div>

<div class="fieldcontain ${hasErrors(bean: zwischenzaehlerInstance, field: 'zaehler', 'error')} required">
	<label for="zaehler">
		<g:message code="zwischenzaehler.zaehler.label" default="Zähler" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="zaehler" name="zaehler.id" from="${org.strotmann.immos.Zaehler.list()}" optionKey="id" required="" value="${zwischenzaehlerInstance?.zaehler?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: zwischenzaehlerInstance, field: 'zwischenzaehlerstaende', 'error')} ">
	<label for="zwischenzaehlerstaende">
		<g:message code="zwischenzaehler.zwischenzaehlerstaende.label" default="Zwischenzählerstände" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${zwischenzaehlerInstance?.zwischenzaehlerstaende?}" var="z">
    <li><g:link controller="zwischenzaehlerstand" action="show" id="${z.id}">${z?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="zwischenzaehlerstand" action="create" params="['zwischenzaehler.id': zwischenzaehlerInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'zwischenzaehlerstand.label', default: 'Zwischenzählerstand')])}</g:link>
</li>
</ul>

</div>

