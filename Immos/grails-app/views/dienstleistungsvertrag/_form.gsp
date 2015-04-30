<%@ page import="org.strotmann.immos.Dienstleistungsvertrag" %>

<div class="fieldcontain ${hasErrors(bean: mdienstleistungsvertragInstance, field: 'partnerrolle', 'error')} required">
	<label for="partnerrolle">
		<g:message code="dienstleistungsvertrag?.dienstleister.label" default="Dienstleister" />
		<span class="required-indicator">*</span>
	</label>
	<g:if test="${flash.partner}">
		<g:fieldValue bean="${flash.partner}" field="name" />
	</g:if>
	<g:if test="${dienstleistungsvertragInstance?.dienstleister}">
		<g:fieldValue bean="${dienstleistungsvertragInstance?.dienstleister?.partner}" field="name" />
	</g:if>
	<g:if test="${!flash.partner && !dienstleistungsvertragInstance?.dienstleister}">
		<g:select id="partner" name="partner.id" from="${org.strotmann.immos.Dienstleistungsvertrag.getDienstleisterList()}" optionKey="id" required="" value="${dienstleistungsvertragInstance?.dienstleister?.id}" class="many-to-one"/>
	</g:if>
</div>

<div class="fieldcontain ${hasErrors(bean: dienstleistungsvertragInstance, field: 'immobilie', 'error')} required">
	<label for="immobilie">
		<g:message code="dienstleistungsvertrag.immobilie.label" default="Immobilie" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="immobilie" name="immobilie.id" from="${org.strotmann.immos.Immobilie.immobilien}" optionKey="id" required="" value="${dienstleistungsvertragInstance?.immobilie?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: dienstleistungsvertragInstance, field: 'dienstleistungsart', 'error')} ">
	<label for="dienstleistungsart">
		<g:message code="dienstleistungsvertrag.dienstleistungsart.label" default="Dienstleistungsart" />
		
	</label>
	<g:select name="dienstleistungsart" from="${Dienstleistungsvertrag.getArten()}" value="${dienstleistungsvertragInstance?.dienstleistungsart}" valueMessagePrefix="dienstleistungsvertrag.dienstleistungsart" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: dienstleistungsvertragInstance, field: 'vertragsnummer', 'error')} ">
	<label for="vertragsnummer">
		<g:message code="dienstleistungsvertrag.vertragsnummer.label" default="Vertragsnummer" />
		
	</label>
	<g:textField name="vertragsnummer" value="${dienstleistungsvertragInstance?.vertragsnummer}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: dienstleistungsvertragInstance, field: 'kundennummer', 'error')} ">
	<label for="kundennummer">
		<g:message code="dienstleistungsvertrag.kundennummer.label" default="Kundennummer" />
		
	</label>
	<g:textField name="kundennummer" value="${dienstleistungsvertragInstance?.kundennummer}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: dienstleistungsvertragInstance, field: 'referenz', 'error')} ">
	<label for="referenz">
		<g:message code="dienstleistungsvertrag.referenz.label" default="referenz" />
		
	</label>
	<g:textField name="referenz" value="${dienstleistungsvertragInstance?.referenz}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: dienstleistungsvertragInstance, field: 'vertragsbeginn', 'error')} required">
	<label for="vertragsbeginn">
		<g:message code="dienstleistungsvertrag.vertragsbeginn.label" default="Vertragsbeginn" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="vertragsbeginn" precision="day" years="${2013..2023}" value="${dienstleistungsvertragInstance?.vertragsbeginn}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: dienstleistungsvertragInstance, field: 'vertragsende', 'error')} ">
	<label for="vertragsende">
		<g:message code="dienstleistungsvertrag.vertragsende.label" default="Vertragsende" />
		
	</label>
	<g:datePicker name="vertragsende" precision="day" years="${2013..2023}" value="${dienstleistungsvertragInstance?.vertragsende}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: dienstleistungsvertragInstance, field: 'autoVerlJahre', 'error')} ">
	<label for="autoVerlJahre">
		<g:message code="dienstleistungsvertrag.autoVerlJahre.label" default="automatische Verlängerung in Jahren" />
		
	</label>
	<g:select name="autoVerlJahre" from="${1..2}" value="${dienstleistungsvertragInstance?.autoVerlJahre}" noSelection="['':'']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: dienstleistungsvertragInstance, field: 'kueWochen', 'error')} ">
	<label for="kueWochen">
		<g:message code="dienstleistungsvertrag.kueWochen.label" default="Kündigung vor Ablauf in Wochen" />
		
	</label>
	<g:select name="kueWochen" from="${[4,6,12]}" value="${dienstleistungsvertragInstance?.kueWochen}" noSelection="['':'']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: dienstleistungsvertragInstance, field: 'zahlweise', 'error')} required">
	<label for="zahlweise">
		<g:message code="dienstleistungsvertrag.zahlweise.label" default="Zahlweise" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="zahlweise" from="${dienstleistungsvertragInstance.constraints.zahlweise.inList}" value="${dienstleistungsvertragInstance?.zahlweise}"valueMessagePrefix="zahlweise.category" />
</div>

<div class="fieldcontain ${hasErrors(bean: dienstleistungsvertragInstance, field: 'umlagefaehig', 'error')} ">
	<label for="umlagefaehig">
		<g:message code="dienstleistungsvertrag.umlagefaehig.label" default="Umlagefähig" />
		
	</label>
	<g:checkBox name="umlagefaehig" value="${dienstleistungsvertragInstance?.umlagefaehig}" />
</div>

<div class="fieldcontain ${hasErrors(bean: dienstleistungsvertragInstance, field: 'umlageinfo', 'error')} ">
<label for="umlageinfo">
	<g:message code="dienstleistungsvertrag.umlageinfo.label" default="Umlageinfo" />
</label>
<ul class="one-to-many">
	<g:each in="${dienstleistungsvertragInstance.umlageinfos}" var="u">
		<li><g:link controller="umlageinfo" action="show" id="${u.id}">${u?.encodeAsHTML()}</g:link></li>
	</g:each>
<li class="add">
<g:link controller="umlageinfo" action="create" params="['dienstleistungsvertrag.id': dienstleistungsvertragInstance?.id]"><g:message code="dienstleistungsvertrag.anlegen.label" default="Anlegen" /></g:link>
</li>
</ul>
</div>

<div class="fieldcontain ${hasErrors(bean: dienstleistungsvertragInstance, field: 'vertragsstaende', 'error')} ">
	<label for="vertragsstaende">
		<g:message code="dienstleistungsvertrag.vertragsstaende.label" default="Vertragsstaende" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${dienstleistungsvertragInstance?.vertragsstaende?}" var="v">
    <li><g:link controller="dienstleistungsvertragsstand" action="show" id="${v.id}">${v?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="dienstleistungsvertragsstand" action="create" params="['dienstleistungsvertrag.id': dienstleistungsvertragInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'dienstleistungsvertragsstand.label', default: 'Dienstleistungsvertragsstand')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: dienstleistungsvertragInstance, field: 'zahlungen', 'error')} ">
	<label for="zahlungen">
		<g:message code="dienstleistungsvertrag.zahlungen.label" default="Zahlungen" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${dienstleistungsvertragInstance?.zahlungen?}" var="z">
    <li><g:link controller="zahlung" action="show" id="${z.id}">${z?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="zahlung" action="create" params="['dienstleistungsvertrag.id': dienstleistungsvertragInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'zahlung.label', default: 'Zahlung')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: immobilieInstance, field: 'notizen', 'error')} ">
	<label for="notizen">
		<g:message code="immobilie.notizen.label" default="Notizen" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${org.strotmann.immos.Notiz.getNotizen('Dienstleistungsvertrag',dienstleistungsvertragInstance.id)}" var="n">
    <li><g:link controller="notiz" action="show" id="${n.id}">${n}</g:link></li>
</g:each>
<li class="add">
<g:link controller="notiz" action="create" params="['dienstleistungsvertrag.id': dienstleistungsvertragInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'notiz.label', default: 'Notiz')])}</g:link>
</li>
</ul>

</div>

