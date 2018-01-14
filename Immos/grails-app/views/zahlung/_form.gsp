<%@ page import="org.strotmann.immos.Zahlung" %>



<div class="fieldcontain ${hasErrors(bean: zahlungInstance, field: 'datum', 'error')} required">
	<label for="datum">
		<g:message code="zahlung.datum.label" default="Datum" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="datum" precision="day"  value="${zahlungInstance?.datum}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: zahlungInstance, field: 'betrag', 'error')} required">
	<label for="buchungsjahr">
		<g:message code="zahlung.buchungsjahr.label" default="Buchungsjahr" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="buchungsjahr" value="${fieldValue(bean: zahlungInstance, field: 'buchungsjahr')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: zahlungInstance, field: 'betrag', 'error')} required">
	<label for="betrag">
		<g:message code="zahlung.betrag.label" default="Betrag" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="betrag" value="${fieldValue(bean: zahlungInstance, field: 'betrag')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: zahlungInstance, field: 'mietvertrag', 'error')} ">
	<label for="mietvertrag">
		<g:message code="zahlung.mietvertrag.label" default="Mietvertrag" />
		
	</label>
	<g:select id="mietvertrag" name="mietvertrag.id" from="${org.strotmann.immos.Mietvertrag.list()}" optionKey="id" value="${zahlungInstance?.mietvertrag?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: zahlungInstance, field: 'rechnung', 'error')} ">
	<label for="rechnung">
		<g:message code="zahlung.rechnung.label" default="Rechnung" />
		
	</label>
	<g:select id="rechnung" name="rechnung.id" from="${org.strotmann.immos.Rechnung.list()}" optionKey="id" value="${zahlungInstance?.rechnung?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: zahlungInstance, field: 'dienstleistungsvertrag', 'error')} ">
	<label for="dienstleistungsvertrag">
		<g:message code="zahlung.dienstleistungsvertrag.label" default="Dienstleistungsvertrag" />
		
	</label>
	<g:select id="dienstleistungsvertrag" name="dienstleistungsvertrag.id" from="${org.strotmann.immos.Dienstleistungsvertrag.list()}" optionKey="id" value="${zahlungInstance?.dienstleistungsvertrag?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: zahlungInstance, field: 'kredit', 'error')} ">
	<label for="kredit">
		<g:message code="zahlung.kredit.label" default="Kredit" />
		
	</label>
	<g:select id="kredit" name="kredit.id" from="${org.strotmann.immos.Kredit.list()}" optionKey="id" value="${zahlungInstance?.kredit?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: zahlungInstance, field: 'bankumsatz', 'error')} ">
	<label for="bankumsatz">
		<g:message code="zahlung.bankumsatz.label" default="Bankumsatz" />
		
	</label>
	<g:select id="bankumsatz" name="bankumsatz.id" from="${org.strotmann.immos.Bankumsatz.getUmsaetze()}" optionKey="id" value="${zahlungInstance?.bankumsatz?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: immobilieInstance, field: 'notizen', 'error')} ">
	<label for="notizen">
		<g:message code="zahlung.notizen.label" default="Notizen" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${org.strotmann.immos.Notiz.getNotizen('Zahlung',zahlungInstance.id)}" var="n">
    <li><g:link controller="notiz" action="show" id="${n.id}">${n}</g:link></li>
</g:each>
<li class="add">
<g:link controller="notiz" action="create" params="['zahlung.id': zahlungInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'notiz.label', default: 'Notiz')])}</g:link>
</li>
</ul>

</div>

