<%@ page import="org.strotmann.immos.Partnerrolle" %>



<div class="fieldcontain ${hasErrors(bean: partnerrolleInstance, field: 'partner', 'error')} required">
	<label for="partner">
		<g:message code="partnerrolle.partner.label" default="Partner" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="partner" name="partner.id" from="${flash.partner}" optionKey="id" required="" value="${partnerrolleInstance?.partner?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: partnerrolleInstance, field: 'rolle', 'error')} ">
	<label for="rolle">
		<g:message code="partnerrolle.rolle.label" default="Rolle" />
		
	</label>
	<g:textField name="rolle" value="${flash.rolle}" />
</div>

<g:if test="${flash.rolle == 'Mieter'}">
<div class="fieldcontain ${hasErrors(bean: partnerrolleInstance, field: 'mietvertrag', 'error')} ">
	<label for="mietvertrag">
		<g:message code="partnerrolle.mietvertrag.label" default="Mietvertrag" />
		
	</label>
	<g:select id="mietvertrag" name="mietvertrag.id" from="${org.strotmann.immos.Mietvertrag.list()}" optionKey="id" value="${partnerrolleInstance?.mietvertrag?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>
</g:if>

<g:if test="${flash.rolle == 'Mietzahler'}">
<div class="fieldcontain ${hasErrors(bean: partnerrolleInstance, field: 'mietvertrag', 'error')} ">
	<label for="mietvertrag">
		<g:message code="partnerrolle.mietvertrag.label" default="Mietvertrag" />
		
	</label>
	<g:select id="mietvertrag" name="mietvertrag.id" from="${org.strotmann.immos.Mietvertrag.list()}" optionKey="id" value="${partnerrolleInstance?.mietvertrag?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>
</g:if>

<g:if test="${flash.rolle == 'Kreditgeber'}">
<div class="fieldcontain ${hasErrors(bean: partnerrolleInstance, field: 'kredit', 'error')} ">
	<label for="kredit">
		<g:message code="partnerrolle.kredit.label" default="Kredit" />
		
	</label>
	<g:select id="kredit" name="kredit.id" from="${org.strotmann.immos.Kredit.list()}" optionKey="id" value="${partnerrolleInstance?.kredit?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>
</g:if>

<g:if test="${flash.rolle == 'Dienstleister'}">
<div class="fieldcontain ${hasErrors(bean: partnerrolleInstance, field: 'dienstleistungsvertrag', 'error')} ">
	<label for="dienstleistungsvertrag">
		<g:message code="partnerrolle.dienstleistungsvertrag.label" default="Dienstleistungsvertrag" />
		
	</label>
	<g:select id="dienstleistungsvertrag" name="dienstleistungsvertrag.id" from="${org.strotmann.immos.Dienstleistungsvertrag.list()}" optionKey="id" value="${partnerrolleInstance?.dienstleistungsvertrag?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>
</g:if>

<g:if test="${flash.rolle == 'Rechnungssteller'}">
<div class="fieldcontain ${hasErrors(bean: partnerrolleInstance, field: 'rechnung', 'error')} ">
	<label for="rechnung">
		<g:message code="partnerrolle.rechnung.label" default="Rechnung" />
		
	</label>
	<g:select id="rechnung" name="rechnung.id" from="${org.strotmann.immos.Rechnung.list()}" optionKey="id" value="${partnerrolleInstance?.rechnung?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>
</g:if>

<g:if test="${flash.rolle == 'Ansprechpartner'}">
<div class="fieldcontain ${hasErrors(bean: partnerrolleInstance, field: 'organisation', 'error')} ">
	<label for="organisation">
		<g:message code="partnerrolle.organisation.label" default="Organisation" />
		
	</label>
	<g:select id="organisation" name="organisation.id" from="${org.strotmann.immos.Organisation.getMiniList()}" optionKey="id" value="${partnerrolleInstance?.organisation?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>
</g:if>

