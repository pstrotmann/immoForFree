<%@ page import="org.strotmann.immos.Zaehler" %>



<div class="fieldcontain ${hasErrors(bean: zaehlerInstance, field: 'zaehlernummer', 'error')} ">
	<label for="zaehlernummer">
		<g:message code="zaehler.zaehlernummer.label" default="Zählernummer" />
		
	</label>
	<g:textField name="zaehlernummer" value="${zaehlerInstance?.zaehlernummer}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: zaehlerInstance, field: 'zaehlertyp', 'error')} ">
	<label for="zaehlertyp">
		<g:message code="zaehler.zaehlertyp.label" default="Zählertyp" />
		
	</label>
	<g:select name="zaehlertyp" from="${zaehlerInstance.constraints.zaehlertyp.inList}" value="${zaehlerInstance?.zaehlertyp}" valueMessagePrefix="zaehler.zaehlertyp" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: zaehlerInstance, field: 'zaehlereinheit', 'error')} ">
	<label for="zaehlereinheit">
		<g:message code="zaehler.zaehlereinheit.label" default="Zählereinheit" />
		
	</label>
	<g:select name="zaehlereinheit" from="${zaehlerInstance.constraints.zaehlereinheit.inList}" value="${zaehlerInstance?.zaehlereinheit}" valueMessagePrefix="zaehler.zaehlereinheit" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: zaehlerInstance, field: 'immobilie', 'error')} required">
	<label for="immobilie">
		<g:message code="zaehler.immobilie.label" default="Immobilie" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="immobilie" name="immobilie.id" from="${org.strotmann.immos.Immobilie.list()}" optionKey="id" required="" value="${zaehlerInstance?.immobilie?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: zaehlerInstance, field: 'zaehlerstaende', 'error')} ">
	<label for="zaehlerstaende">
		<g:message code="zaehler.zaehlerstaende.label" default="Zählerstände" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${zaehlerInstance?.zaehlerstaende?}" var="z">
    <li><g:link controller="zaehlerstand" action="show" id="${z.id}">${z?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="zaehlerstand" action="create" params="['zaehler.id': zaehlerInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'zaehlerstand.label', default: 'Zählerstand')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: zaehlerInstance, field: 'zwischenzaehlers', 'error')} ">
	<label for="zwischenzaehlers">
		<g:message code="zaehler.zwischenzaehlers.label" default="Zwischenzähler" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${zaehlerInstance?.zwischenzaehlers?}" var="z">
    <li><g:link controller="zwischenzaehler" action="show" id="${z.id}">${z?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="zwischenzaehler" action="create" params="['zaehler.id': zaehlerInstance?.id,'immobilie.id':zaehlerInstance?.immobilie.id]">${message(code: 'default.add.label', args: [message(code: 'zwischenzaehler.label', default: 'Zwischenzähler')])}</g:link>
</li>
</ul>

</div>

