<%@ page import="org.strotmann.immos.Mietsache" %>



<div class="fieldcontain ${hasErrors(bean: mietsacheInstance, field: 'lage', 'error')} ">
	<label for="lage">
		<g:message code="mietsache.lage.label" default="Lage" />
		
	</label>
	<g:textField name="lage" value="${mietsacheInstance?.lage}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mietsacheInstance, field: 'art', 'error')} ">
	<label for="art">
		<g:message code="mietsache.art.label" default="Art" />
		
	</label>
	<g:select name="art" from="${Mietsache.getArten()}" value="${mietsacheInstance?.art}" valueMessagePrefix="mietsache.art" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mietsacheInstance, field: 'wohnflaeche', 'error')} ">
	<label for="wohnflaeche">
		<g:message code="mietsache.wohnflaeche.label" default="Wohnflaeche" />
		
	</label>
	<g:field name="wohnflaeche" value="${fieldValue(bean: mietsacheInstance, field: 'wohnflaeche')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mietsacheInstance, field: 'aufteilung', 'error')} ">
	<label for="aufteilung">
		<g:message code="mietsache.aufteilung.label" default="Aufteilung" />
		
	</label>
	<g:textField name="aufteilung" value="${mietsacheInstance?.aufteilung}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mietsacheInstance, field: 'anzRauchmelder', 'error')} required">
	<label for="anzRauchmelder">
		<g:message code="mietsache.anzRauchmelder.label" default="Anzahl Rauchmelder" />
		
	</label>
	<g:field name="anzRauchmelder" type="number" value="${mietsacheInstance.anzRauchmelder}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: mietsacheInstance, field: 'zwischenzaehlers', 'error')} ">
	<label for="zwischenzaehlers">
		<g:message code="mietsache.zwischenzaehlers.label" default="Zwischenzähler" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${mietsacheInstance?.zwischenzaehlers?}" var="z">
    <li><g:link controller="zwischenzaehler" action="show" id="${z.id}">${z?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="zwischenzaehler" action="create" params="['mietsache.id': mietsacheInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'zwischenzaehler.label', default: 'Zwischenzähler')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: mietsacheInstance, field: 'immobilie', 'error')} required">
	<label for="immobilie">
		<g:message code="mietsache.immobilie.label" default="Immobilie" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="immobilie" name="immobilie.id" from="${org.strotmann.immos.Immobilie.list()}" optionKey="id" required="" value="${mietsacheInstance?.immobilie?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mietsacheInstance, field: 'notizen', 'error')} ">
	<label for="notizen">
		<g:message code="mietsache.notizen.label" default="Notizen" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${org.strotmann.immos.Notiz.getNotizen('Mietsache',mietsacheInstance.id)}" var="n">
    <li><g:link controller="notiz" action="show" id="${n.id}">${n}</g:link></li>
</g:each>
<li class="add">
<g:link controller="notiz" action="create" params="['mietsache.id': mietsacheInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'notiz.label', default: 'Notiz')])}</g:link>
</li>
</ul>

</div>

