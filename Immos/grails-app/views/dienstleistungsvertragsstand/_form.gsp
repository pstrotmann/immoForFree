<%@ page import="org.strotmann.immos.Dienstleistungsvertragsstand" %>



<div class="fieldcontain ${hasErrors(bean: dienstleistungsvertragsstandInstance, field: 'gueltigAb', 'error')} required">
	<label for="gueltigAb">
		<g:message code="dienstleistungsvertragsstand.gueltigAb.label" default="Gueltig Ab" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="gueltigAb" precision="day"  value="${dienstleistungsvertragsstandInstance?.gueltigAb}" years="${2020..2030}" />
</div>

<div class="fieldcontain ${hasErrors(bean: dienstleistungsvertragsstandInstance, field: 'pauschale', 'error')} required">
	<label for="pauschale">
		<g:message code="dienstleistungsvertragsstand.pauschale.label" default="Pauschale" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="pauschale" value="${fieldValue(bean: dienstleistungsvertragsstandInstance, field: 'pauschale')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: dienstleistungsvertragsstandInstance, field: 'dienstleistungsvertrag', 'error')} required">
	<label for="dienstleistungsvertrag">
		<g:message code="dienstleistungsvertragsstand.dienstleistungsvertrag.label" default="Dienstleistungsvertrag" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="dienstleistungsvertrag" name="dienstleistungsvertrag.id" from="${org.strotmann.immos.Dienstleistungsvertrag.list()}" optionKey="id" required="" value="${dienstleistungsvertragsstandInstance?.dienstleistungsvertrag?.id}" class="many-to-one"/>
</div>

