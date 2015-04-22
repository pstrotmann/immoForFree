<%@ page import="org.strotmann.immos.Rechnung" %>



<div class="fieldcontain ${hasErrors(bean: rechnungInstance, field: 'rechnungssteller', 'error')} required">
	<label for="rechnungssteller">
		<g:message code="rechnung.rechnungssteller.label" default="Rechnungssteller" />
		<span class="required-indicator">*</span>
	</label>
	<g:if test="${flash.partner}">
		<g:select id="partner" name="partner.id" from="${flash.partner}" optionKey="id" required="" value="${rechnungInstance?.rechnungssteller?.id}" class="many-to-one"/>
	</g:if>
	<g:if test="${rechnungInstance?.rechnungssteller}">
		<g:fieldValue bean="${rechnungInstance?.rechnungssteller?.partner}" field="name" />
	</g:if>
	<g:if test="${!flash.partner && !rechnungInstance?.rechnungssteller}">
		<g:select id="partner" name="partner.id" from="${org.strotmann.immos.Rechnung.getRechnungsstellerList()}" optionKey="id" required="" value="${rechnungInstance?.rechnungssteller?.id}" class="many-to-one"/>
	</g:if></div>

<div class="fieldcontain ${hasErrors(bean: rechnungInstance, field: 'immobilie', 'error')} required">
	<label for="immobilie">
		<g:message code="rechnung.immobilie.label" default="Immobilie" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="immobilie" name="immobilie.id" from="${org.strotmann.immos.Immobilie.immobilien}" optionKey="id" required="" value="${rechnungInstance?.immobilie?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: rechnungInstance, field: 'rechnungsdatum', 'error')} required">
	<label for="rechnungsdatum">
		<g:message code="rechnung.rechnungsdatum.label" default="Rechnungsdatum" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="rechnungsdatum" precision="day"  value="${rechnungInstance?.rechnungsdatum}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: rechnungInstance, field: 'betrag', 'error')} required">
	<label for="betrag">
		<g:message code="rechnung.betrag.label" default="Betrag" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="betrag" value="${fieldValue(bean: rechnungInstance, field: 'betrag')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: rechnungInstance, field: 'bruttoBetrag', 'error')} ">
	<label for="bruttoBetrag">
		<g:message code="rechnung.bruttoBetrag.label" default="Brutto Betrag" />
		
	</label>
	<g:field name="bruttoBetrag" value="${fieldValue(bean: rechnungInstance, field: 'bruttoBetrag')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: rechnungInstance, field: 'nettoBetrag', 'error')} ">
	<label for="nettoBetrag">
		<g:message code="rechnung.nettoBetrag.label" default="Netto Betrag" />
		
	</label>
	<g:field name="nettoBetrag" value="${fieldValue(bean: rechnungInstance, field: 'nettoBetrag')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: rechnungInstance, field: 'mehrwertsteuerSatz', 'error')} ">
	<label for="mehrwertsteuerSatz">
		<g:message code="rechnung.mehrwertsteuerSatz.label" default="Mehrwertsteuer Satz" />
		
	</label>
	<g:field name="mehrwertsteuerSatz" value="${fieldValue(bean: rechnungInstance, field: 'mehrwertsteuerSatz')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: rechnungInstance, field: 'mehrwertsteuer', 'error')} ">
	<label for="mehrwertsteuer">
		<g:message code="rechnung.mehrwertsteuer.label" default="Mehrwertsteuer" />
		
	</label>
	<g:field name="mehrwertsteuer" value="${fieldValue(bean: rechnungInstance, field: 'mehrwertsteuer')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: rechnungInstance, field: 'skontoSatz', 'error')} ">
	<label for="skontoSatz">
		<g:message code="rechnung.skontoSatz.label" default="Skonto Satz" />
		
	</label>
	<g:field name="skontoSatz" value="${fieldValue(bean: rechnungInstance, field: 'skontoSatz')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: rechnungInstance, field: 'skonto', 'error')} ">
	<label for="skonto">
		<g:message code="rechnung.skonto.label" default="Skonto" />
		
	</label>
	<g:field name="skonto" value="${fieldValue(bean: rechnungInstance, field: 'skonto')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: rechnungInstance, field: 'auftragsnummer', 'error')} ">
	<label for="auftragsnummer">
		<g:message code="rechnung.auftragsnummer.label" default="Auftragsnummer" />
		
	</label>
	<g:textField name="auftragsnummer" value="${rechnungInstance?.auftragsnummer}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: rechnungInstance, field: 'kundennummer', 'error')} ">
	<label for="kundennummer">
		<g:message code="rechnung.kundennummer.label" default="Kundennummer" />
		
	</label>
	<g:textField name="kundennummer" value="${rechnungInstance?.kundennummer}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: rechnungInstance, field: 'rechnungsgegenstand', 'error')} ">
	<label for="rechnungsgegenstand">
		<g:message code="rechnung.rechnungsgegenstand.label" default="Rechnungsgegenstand" />
		
	</label>
	<g:textField name="rechnungsgegenstand" value="${rechnungInstance?.rechnungsgegenstand}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: rechnungInstance, field: 'rechnungsnummer', 'error')} ">
	<label for="rechnungsnummer">
		<g:message code="rechnung.rechnungsnummer.label" default="Rechnungsnummer" />
		
	</label>
	<g:textField name="rechnungsnummer" value="${rechnungInstance?.rechnungsnummer}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: rechnungInstance, field: 'umlagefaehig', 'error')} ">
	<label for="umlagefaehig">
		<g:message code="rechnung.umlagefaehig.label" default="Umlagefähig" />
		
	</label>
	<g:checkBox name="umlagefaehig" value="${rechnungInstance?.umlagefaehig}" />
</div>

<div class="fieldcontain ${hasErrors(bean: rechnungInstance, field: 'umlageinfo', 'error')} ">
	<label for="umlageinfo">
		<g:message code="rechnung.umlageinfo.label" default="Umlageinfo" />
	</label>
	<g:link controller="umlageinfo" action="create" params="['rechnung.id': rechnungInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'umlageinfo.label', default: 'Umlageinfo')])}</g:link>
</div>

<div class="fieldcontain ${hasErrors(bean: rechnungInstance, field: 'notizen', 'error')} ">
	<label for="notizen">
		<g:message code="rechnung.notizen.label" default="Notizen" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${org.strotmann.immos.Notiz.getNotizen('Rechnung',rechnungInstance.id)}" var="n">
    <li><g:link controller="notiz" action="show" id="${n.id}">${n}</g:link></li>
</g:each>
<li class="add">
<g:link controller="notiz" action="create" params="['rechnung.id': rechnungInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'notiz.label', default: 'Notiz')])}</g:link>
</li>
</ul>

</div>

