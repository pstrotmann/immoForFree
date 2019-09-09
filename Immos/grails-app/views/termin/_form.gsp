<%@ page import="org.strotmann.immos.Termin" %>
<%@ page import="org.strotmann.util.Datum" %>

<h3>Termindaten</h3>

<div class="fieldcontain ${hasErrors(bean: terminInstance, field: 'vorlage', 'error')} required">
	<label for="vorlage">
		<g:message code="termin.vorlage.label" default="Vorlage" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="vorlage" years="${Datum.aktJahr..Datum.aktJahr + 10}" value="${terminInstance?.vorlage}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: terminInstance, field: 'grund', 'error')} required">
	<label for="grund">
		<g:message code="termin.grund.label" default="Grund" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="grund" required="" value="${terminInstance?.grund}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: terminInstance, field: 'erledigung', 'error')} ">
	<label for="erledigung">
		<g:message code="termin.erledigung.label" default="Erledigung" />
		
	</label>
	<g:datePicker name="erledigung" precision="day" years="${Datum.aktJahr..Datum.aktJahr + 10}" value="${terminInstance?.erledigung}" default="none" noSelection="['': '']" />

</div>

<h3>Referenz</h3>

<div class="fieldcontain ${hasErrors(bean: terminInstance, field: 'dienstleistungsvertrag', 'error')} ">
	<label for="dienstleistungsvertrag">
		<g:message code="termin.dienstleistungsvertrag.label" default="Dienstleistungsvertrag" />
		
	</label>
	<g:select id="dienstleistungsvertrag" name="dienstleistungsvertrag.id" from="${org.strotmann.immos.Dienstleistungsvertrag.dienstleistungsvertraege}" optionKey="id" value="${terminInstance?.dienstleistungsvertrag?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: terminInstance, field: 'organisation', 'error')} ">
	<label for="organisation">
		<g:message code="termin.organisation.label" default="Organisation" />
		
	</label>
	<g:select id="organisation" name="organisation.id" from="${org.strotmann.immos.Organisation.miniList}" optionKey="id" value="${terminInstance?.organisation?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: terminInstance, field: 'person', 'error')} ">
	<label for="person">
		<g:message code="termin.person.label" default="Person" />
		
	</label>
	<g:select id="person" name="person.id" from="${org.strotmann.immos.Person.personList}" optionKey="id" value="${terminInstance?.person?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: terminInstance, field: 'immobilie', 'error')} ">
	<label for="immobilie">
		<g:message code="termin.immobilie.label" default="Immobilie" />
		
	</label>
	<g:select id="immobilie" name="immobilie.id" from="${org.strotmann.immos.Immobilie.immobilien}" optionKey="id" value="${terminInstance?.immobilie?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: terminInstance, field: 'grundschuld', 'error')} ">
	<label for="grundschuld">
		<g:message code="termin.grundschuld.label" default="Grundschuld" />
		
	</label>
	<g:select id="grundschuld" name="grundschuld.id" from="${org.strotmann.immos.Grundschuld.list()}" optionKey="id" value="${terminInstance?.grundschuld?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: terminInstance, field: 'mietvertrag', 'error')} ">
	<label for="mietvertrag">
		<g:message code="termin.mietvertrag.label" default="Mietvertrag" />
		
	</label>
	<g:select id="mietvertrag" name="mietvertrag.id" from="${org.strotmann.immos.Mietvertrag.mietvertraege}" optionKey="id" value="${terminInstance?.mietvertrag?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: terminInstance, field: 'kredit', 'error')} ">
	<label for="kredit">
		<g:message code="termin.kredit.label" default="Kredit" />
		
	</label>
	<g:select id="kredit" name="kredit.id" from="${org.strotmann.immos.Kredit.aktiveKredite}" optionKey="id" value="${terminInstance?.kredit?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: terminInstance, field: 'rechnung', 'error')} ">
	<label for="rechnung">
		<g:message code="termin.rechnung.label" default="Rechnung" />
		
	</label>
	<g:select id="rechnung" name="rechnung.id" from="${org.strotmann.immos.Rechnung.list()}" optionKey="id" value="${terminInstance?.rechnung?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>



