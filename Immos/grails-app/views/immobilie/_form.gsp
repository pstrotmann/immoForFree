<%@ page import="org.strotmann.immos.Immobilie" %>



<div class="fieldcontain ${hasErrors(bean: immobilieInstance, field: 'hausadresse', 'error')} required">
	<label for="hausadresse">
		<g:message code="immobilie.hausadresse.label" default="Hausadresse" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="hausadresse" name="hausadresse.id" from="${org.strotmann.immos.Hausadresse.getMiniList()}" optionKey="id" required="" value="${immobilieInstance?.hausadresse?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: immobilieInstance, field: 'grundbuch', 'error')} ">
	<label for="grundbuch">
		<g:message code="immobilie.grundbuch.label" default="Grundbuch" />
		
	</label>
	<g:textField name="grundbuch" value="${immobilieInstance?.grundbuch}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: immobilieInstance, field: 'baujahr', 'error')} required">
	<label for="baujahr">
		<g:message code="immobilie.baujahr.label" default="Baujahr" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="baujahr" type="number" value="${immobilieInstance.baujahr}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: immobilieInstance, field: 'eigentumAb', 'error')} ">
	<label for="eigentumAb">
		<g:message code="immobilie.eigentumAb.label" default="Eigentum Ab" />
		
	</label>
	<g:datePicker name="eigentumAb" precision="day"  value="${immobilieInstance?.eigentumAb}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: immobilieInstance, field: 'eigentumBis', 'error')} ">
	<label for="eigentumBis">
		<g:message code="immobilie.eigentumBis.label" default="Eigentum Bis" />
		
	</label>
	<g:datePicker name="eigentumBis" precision="day"  value="${immobilieInstance?.eigentumBis}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: immobilieInstance, field: 'anschaffungspreis', 'error')} ">
	<label for="anschaffungspreis">
		<g:message code="immobilie.anschaffungspreis.label" default="Anschaffungspreis" />
		
	</label>
	<g:field name="anschaffungspreis" value="${fieldValue(bean: immobilieInstance, field: 'anschaffungspreis')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: immobilieInstance, field: 'verkaufspreis', 'error')} ">
	<label for="verkaufspreis">
		<g:message code="immobilie.verkaufspreis.label" default="Verkaufspreis" />
		
	</label>
	<g:field name="verkaufspreis" value="${fieldValue(bean: immobilieInstance, field: 'verkaufspreis')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: immobilieInstance, field: 'grundstueckspreis', 'error')} ">
	<label for="grundstueckspreis">
		<g:message code="immobilie.grundstueckspreis.label" default="Grundstueckspreis" />
		
	</label>
	<g:field name="grundstueckspreis" value="${fieldValue(bean: immobilieInstance, field: 'grundstueckspreis')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: immobilieInstance, field: 'grundstuecksgroesse', 'error')} ">
	<label for="grundstuecksgroesse">
		<g:message code="immobilie.grundstuecksgroesse.label" default="Grundstuecksgroesse" />
		
	</label>
	<g:field name="grundstuecksgroesse" value="${fieldValue(bean: immobilieInstance, field: 'grundstuecksgroesse')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: immobilieInstance, field: 'erhoehteAbschreibung', 'error')} ">
	<label for="erhoehteAbschreibung">
		<g:message code="immobilie.erhoehteAbschreibung.label" default="Erhoehte Abschreibung" />
		
	</label>
	<g:checkBox name="erhoehteAbschreibung" value="${immobilieInstance?.erhoehteAbschreibung}" />
</div>

<div class="fieldcontain ${hasErrors(bean: immobilieInstance, field: 'sozialerWohnungsbau', 'error')} ">
	<label for="sozialerWohnungsbau">
		<g:message code="immobilie.sozialerWohnungsbau.label" default="SozialerWohnungsbau" />
		
	</label>
	<g:checkBox name="sozialerWohnungsbau" value="${immobilieInstance?.sozialerWohnungsbau}" />
</div>

<div class="fieldcontain ${hasErrors(bean: immobilieInstance, field: 'mietsachen', 'error')} ">
	<label for="mietsachen">
		<g:message code="immobilie.mietsachen.label" default="Mietsachen" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${immobilieInstance?.mietsachen?}" var="m">
    <li><g:link controller="mietsache" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="mietsache" action="create" params="['immobilie.id': immobilieInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'mietsache.label', default: 'Mietsache')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: immobilieInstance, field: 'anzRauchmelder', 'error')} required">
	<label for="anzRauchmelder">
		<g:message code="immobilie.anzRauchmelder.label" default="Anzahl Rauchmelder" />
		
	</label>
	<g:field name="anzRauchmelder" type="number" value="${immobilieInstance.anzRauchmelder}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: immobilieInstance, field: 'zaehlers', 'error')} ">
	<label for="zaehlers">
		<g:message code="immobilie.zaehlers.label" default="Zähler" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${immobilieInstance?.zaehlers?}" var="z">
    <li><g:link controller="zaehler" action="show" id="${z.id}">${z?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="zaehler" action="create" params="['immobilie.id': immobilieInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'zaehler.label', default: 'Zähler')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: immobilieInstance, field: 'kredite', 'error')} ">
	<label for="kredite">
		<g:message code="immobilie.kredite.label" default="Kredite" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${immobilieInstance?.kredite?}" var="z">
    <li><g:link controller="kredit" action="show" id="${z.id}">${z?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="kredit" action="create" params="['immobilie.id': immobilieInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'kredit.label', default: 'Kredit')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: immobilieInstance, field: 'dienstleistungsvertraege', 'error')} ">
	<label for="dienstleistungsvertraege">
		<g:message code="dienstleistungs.dienstleistungsvertraege.label" default="Dienstleistungsverträge" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${immobilieInstance?.dienstleistungsvertraege?}" var="z">
    <li><g:link controller="dienstleistungsvertrag" action="show" id="${z.id}">${z?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="dienstleistungsvertrag" action="create" params="['immobilie.id': immobilieInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'dienstleistungsvertrag.label', default: 'Dienstleistungsvertrag')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: immobilieInstance, field: 'rechnungen', 'error')} ">
	<label for="rechnungen">
		<g:message code="immobilie.rechnungen.label" default="Rechnungen" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${immobilieInstance?.rechnungen?}" var="r">
    <li><g:link controller="rechnung" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="rechnung" action="create" params="['immobilie.id': immobilieInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'rechnung.label', default: 'Rechnung')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: immobilieInstance, field: 'immoabrechnungen', 'error')} ">
	<label for="immoabrechnungen">
		<g:message code="immobilie.immoabrechnungen.label" default="Immoabrechnungen" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${immobilieInstance?.immoabrechnungen?}" var="r">
    <li><g:link controller="rechnung" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="Immoabrechnung" action="create" params="['immobilie.id': immobilieInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'Immoabrechnung.label', default: 'Immoabrechnung')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: immobilieInstance, field: 'einheitswerte', 'error')} ">
	<label for="einheitswerte">
		<g:message code="immobilie.einheitswerte.label" default="Einheitswerte" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${immobilieInstance?.einheitswerte?}" var="e">
    <li><g:link controller="einheitswert" action="show" id="${e.id}">${e?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="einheitswert" action="create" params="['immobilie.id': immobilieInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'einheitswert.label', default: 'Einheitswert')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: immobilieInstance, field: 'notizen', 'error')} ">
	<label for="notizen">
		<g:message code="immobilie.notizen.label" default="Notizen" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${org.strotmann.immos.Notiz.getNotizen('Immobilie',immobilieInstance.id)}" var="n">
    <li><g:link controller="notiz" action="show" id="${n.id}">${n}</g:link></li>
</g:each>
<li class="add">
<g:link controller="notiz" action="create" params="['immobilie.id': immobilieInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'notiz.label', default: 'Notiz')])}</g:link>
</li>
</ul>

</div>

