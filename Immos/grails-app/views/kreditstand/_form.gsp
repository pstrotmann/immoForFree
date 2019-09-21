<%@ page import="org.strotmann.immos.Kreditstand" %>



<div class="fieldcontain ${hasErrors(bean: kreditstandInstance, field: 'laufzeitAb', 'error')} required">
	<label for="laufzeitAb">
		<g:message code="kreditstand.laufzeitAb.label" default="Laufzeit Ab" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="laufzeitAb" precision="day"  value="${kreditstandInstance?.laufzeitAb}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: kreditstandInstance, field: 'laufzeitBis', 'error')} required">
	<label for="laufzeitBis">
		<g:message code="kreditstand.laufzeitBis.label" default="Laufzeit Bis" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="laufzeitBis" precision="day"  value="${kreditstandInstance?.laufzeitBis}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: kreditstandInstance, field: 'kreditsumme', 'error')} required">
	<label for="kreditsumme">
		<g:message code="kreditstand.kreditsumme.label" default="Kreditsumme" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="kreditsumme" value="${fieldValue(bean: kreditstandInstance, field: 'kreditsumme')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: kreditstandInstance, field: 'zinssatz', 'error')} ">
	<label for="zinssatz">
		<g:message code="kreditstand.zinssatz.label" default="Zinssatz" />
	</label>
	<g:field name="zinssatz" value="${fieldValue(bean: kreditstandInstance, field: 'zinssatz')}" />
</div>

<div class="fieldcontain ${hasErrors(bean: kreditstandInstance, field: 'tilgungssatz', 'error')} ">
	<label for="tilgungssatz">
		<g:message code="kreditstand.tilgungssatz.label" default="Tilgungssatz" />
	</label>
	<g:field name="tilgungssatz" value="${fieldValue(bean: kreditstandInstance, field: 'tilgungssatz')}" />
</div>

<div class="fieldcontain ${hasErrors(bean: kreditstandInstance, field: 'annuitaet', 'error')} ">
	<label for="annuitaet">
		<g:message code="kreditstand.annuitaet.label" default="Annuität" />
	</label>
	<g:field name="annuitaet" value="${fieldValue(bean: kreditstandInstance, field: 'annuitaet')}" />
</div>

<div class="fieldcontain ${hasErrors(bean: kreditstandInstance, field: 'zinsbetrag', 'error')} ">
	<label for="zinsbetrag">
		<g:message code="kreditstand.zinsbetrag.label" default="Zinsbetrag" />
		
	</label>
	<g:field name="zinsbetrag" value="${fieldValue(bean: kreditstandInstance, field: 'zinsbetrag')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: kreditstandInstance, field: 'tilgungsbetrag', 'error')} ">
	<label for="tilgungsbetrag">
		<g:message code="kreditstand.tilgungsbetrag.label" default="Tilgungsbetrag" />
		
	</label>
	<g:field name="tilgungsbetrag" value="${fieldValue(bean: kreditstandInstance, field: 'tilgungsbetrag')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: kreditstandInstance, field: 'verwKostenbetrag', 'error')} ">
	<label for="verwKostenbetrag">
		<g:message code="kreditstand.verwKostenbetrag.label" default="Verw Kostenbetrag" />
		
	</label>
	<g:field name="verwKostenbetrag" value="${fieldValue(bean: kreditstandInstance, field: 'verwKostenbetrag')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: kreditstandInstance, field: 'sondertilgung', 'error')} ">
	<label for="sondertilgung">
		<g:message code="kreditstand.sondertilgung.label" default="Sondertilgung" />
		
	</label>
	<g:field name="sondertilgung" value="${fieldValue(bean: kreditstandInstance, field: 'sondertilgung')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: kreditstandInstance, field: 'kredit', 'error')} required">
	<label for="kredit">
		<g:message code="kreditstand.kredit.label" default="Kredit" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="kredit" name="kredit.id" from="${org.strotmann.immos.Kredit.list()}" optionKey="id" required="" value="${kreditstandInstance?.kredit?.id}" class="many-to-one"/>
</div>

