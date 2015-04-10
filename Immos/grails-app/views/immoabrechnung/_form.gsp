<%@ page import="org.strotmann.immos.Immoabrechnung" %>



<div class="fieldcontain ${hasErrors(bean: immoabrechnungInstance, field: 'jahr', 'error')} required">
	<label for="jahr">
		<g:message code="immoabrechnung.jahr.label" default="Jahr" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="jahr" type="number"  value="${immoabrechnungInstance.jahr}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: immoabrechnungInstance, field: 'datum', 'error')} required">
	<label for="datum">
		<g:message code="immoabrechnung.datum.label" default="Datum" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="datum" precision="day"  value="${immoabrechnungInstance?.datum}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: immoabrechnungInstance, field: 'immobilie', 'error')} required">
	<label for="immobilie">
		<g:message code="immoabrechnung.immobilie.label" default="Immobilie" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="immobilie" name="immobilie.id" from="${org.strotmann.immos.Immobilie.immobilien}" optionKey="id" required="" value="${immoabrechnungInstance?.immobilie?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: immoabrechnungInstance, field: 'betriebskostenabrechnungen', 'error')} ">
	<label for="betriebskostenabrechnungen">
		<g:message code="immoabrechnung.betriebskostenabrechnungen.label" default="Betriebskostenabrechnungen" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${immoabrechnungInstance?.betriebskostenabrechnungen?}" var="n">
    <li><g:link controller="betriebskostenabrechnung" action="show" id="${n.id}">${n?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="betriebskostenabrechnung" action="create" params="['immoabrechnung.id': immoabrechnungInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'betriebskostenabrechnung.label', default: 'Betriebskostenabrechnung')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: immoabrechnungInstance, field: 'umlagen', 'error')} ">
	<label for="umlagen">
		<g:message code="immoabrechnung.umlagen.label" default="Umlagen" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${immoabrechnungInstance?.umlagen?}" var="u">
    <li><g:link controller="umlage" action="show" id="${u.id}">${u?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="umlage" action="create" params="['immoabrechnung.id': immoabrechnungInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'umlage.label', default: 'Umlage')])}</g:link>
</li>
</ul>

</div>

