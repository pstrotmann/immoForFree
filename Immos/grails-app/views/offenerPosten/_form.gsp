<%@ page import="org.strotmann.immos.OffenerPosten" %>



<div class="fieldcontain ${hasErrors(bean: offenerPostenInstance, field: 'faelligkeit', 'error')} required">
	<label for="faelligkeit">
		<g:message code="offenerPosten.faelligkeit.label" default="Faelligkeit" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="faelligkeit" precision="day"  value="${offenerPostenInstance?.faelligkeit}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: offenerPostenInstance, field: 'grund', 'error')} ">
	<label for="grund">
		<g:message code="offenerPosten.grund.label" default="Grund" />
		
	</label>
	<g:textField name="grund" value="${offenerPostenInstance?.grund}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: offenerPostenInstance, field: 'betrag', 'error')} required">
	<label for="betrag">
		<g:message code="offenerPosten.betrag.label" default="Betrag" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="betrag" value="${fieldValue(bean: offenerPostenInstance, field: 'betrag')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: offenerPostenInstance, field: 'mietvertrag', 'error')} ">
	<label for="mietvertrag">
		<g:message code="offenerPosten.mietvertrag.label" default="Mietvertrag" />
		
	</label>
	<g:select id="mietvertrag" name="mietvertrag.id" from="${org.strotmann.immos.Mietvertrag.list()}" optionKey="id" value="${offenerPostenInstance?.mietvertrag?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: offenerPostenInstance, field: 'dienstleistungsvertrag', 'error')} ">
	<label for="dienstleistungsvertrag">
		<g:message code="offenerPosten.dienstleistungsvertrag.label" default="Dienstleistungsvertrag" />
		
	</label>
	<g:select id="dienstleistungsvertrag" name="dienstleistungsvertrag.id" from="${org.strotmann.immos.Dienstleistungsvertrag.list()}" optionKey="id" value="${offenerPostenInstance?.dienstleistungsvertrag?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: offenerPostenInstance, field: 'rechnung', 'error')} ">
	<label for="rechnung">
		<g:message code="offenerPosten.rechnung.label" default="Rechnung" />
		
	</label>
	<g:select id="rechnung" name="rechnung.id" from="${org.strotmann.immos.Rechnung.list()}" optionKey="id" value="${offenerPostenInstance?.rechnung?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: offenerPostenInstance, field: 'kredit', 'error')} ">
	<label for="kredit">
		<g:message code="offenerPosten.kredit.label" default="Kredit" />
		
	</label>
	<g:select id="kredit" name="kredit.id" from="${org.strotmann.immos.Kredit.list()}" optionKey="id" value="${offenerPostenInstance?.kredit?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

