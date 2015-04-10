<%@ page import="org.strotmann.immos.Mietvertragsstand" %>



<div class="fieldcontain ${hasErrors(bean: mietvertragsstandInstance, field: 'mietvertrag', 'error')} required">
	<label for="mietvertrag">
		<g:message code="mietvertragsstand.mietvertrag.label" default="Mietvertrag" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="mietvertrag" name="mietvertrag.id" from="${mietvertragsstandInstance.mietvertrag}" optionKey="id" required="" value="${mietvertragsstandInstance?.mietvertrag?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mietvertragsstandInstance, field: 'gueltigAb', 'error')} required">
	<label for="gueltigAb">
		<g:message code="mietvertragsstand.gueltigAb.label" default="Gueltig Ab" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="gueltigAb" precision="day"  value="${mietvertragsstandInstance?.gueltigAb}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: mietvertragsstandInstance, field: 'grundmiete', 'error')} required">
	<label for="grundmiete">
		<g:message code="mietvertragsstand.grundmiete.label" default="Grundmiete" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="grundmiete" value="${fieldValue(bean: mietvertragsstandInstance, field: 'grundmiete')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: mietvertragsstandInstance, field: 'qmMiete', 'error')} required">
	<label for="qmMiete">
		<g:message code="mietvertragsstand.qmMiete.label" default="Qm Miete" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="qmMiete" value="${fieldValue(bean: mietvertragsstandInstance, field: 'qmMiete')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: mietvertragsstandInstance, field: 'nebenkostenpauschale', 'error')} required">
	<label for="nebenkostenpauschale">
		<g:message code="mietvertragsstand.nebenkostenpauschale.label" default="Nebenkostenpauschale" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="nebenkostenpauschale" value="${fieldValue(bean: mietvertragsstandInstance, field: 'nebenkostenpauschale')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: mietvertragsstandInstance, field: 'heizkostenpauschale', 'error')} required">
	<label for="heizkostenpauschale">
		<g:message code="mietvertragsstand.heizkostenpauschale.label" default="Heizkostenpauschale" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="heizkostenpauschale" value="${fieldValue(bean: mietvertragsstandInstance, field: 'heizkostenpauschale')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: mietvertragsstandInstance, field: 'zusatzmiete', 'error')} required">
	<label for="zusatzmiete">
		<g:message code="mietvertragsstand.zusatzmiete.label" default="${mietvertragsstandInstance.mietvertrag?.zusatzMietsache ? mietvertragsstandInstance.mietvertrag.zusatzMietsache.art : 'Zusatz'}" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="zusatzmiete" value="${fieldValue(bean: mietvertragsstandInstance, field: 'zusatzmiete')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: mietvertragsstandInstance, field: 'anzahlPersonen', 'error')} required">
	<label for="anzahlPersonen">
		<g:message code="mietvertragsstand.anzahlPersonen.label" default="Anzahl Personen" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="anzahlPersonen" type="number" max="6" value="${mietvertragsstandInstance.anzahlPersonen}" required=""/>
</div>

