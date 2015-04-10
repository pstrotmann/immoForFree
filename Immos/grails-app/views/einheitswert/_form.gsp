<%@ page import="org.strotmann.immos.Einheitswert" %>



<div class="fieldcontain ${hasErrors(bean: einheitswertInstance, field: 'ewNummer', 'error')} ">
	<label for="ewNummer">
		<g:message code="einheitswert.ewNummer.label" default="Ew Nummer" />
		
	</label>
	<g:textField name="ewNummer" value="${einheitswertInstance?.ewNummer}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: einheitswertInstance, field: 'gueltigAb', 'error')} required">
	<label for="gueltigAb">
		<g:message code="einheitswert.gueltigAb.label" default="Gueltig Ab" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="gueltigAb" precision="day"  value="${einheitswertInstance?.gueltigAb}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: einheitswertInstance, field: 'wert', 'error')} required">
	<label for="wert">
		<g:message code="einheitswert.wert.label" default="Wert" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="wert" value="${fieldValue(bean: einheitswertInstance, field: 'wert')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: einheitswertInstance, field: 'immobilie', 'error')} required">
	<label for="immobilie">
		<g:message code="einheitswert.immobilie.label" default="Immobilie" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="immobilie" name="immobilie.id" from="${org.strotmann.immos.Immobilie.list()}" optionKey="id" required="" value="${einheitswertInstance?.immobilie?.id}" class="many-to-one"/>
</div>

