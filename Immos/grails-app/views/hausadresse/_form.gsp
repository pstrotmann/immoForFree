<%@ page import="org.strotmann.immos.Hausadresse" %>


<div class="fieldcontain ${hasErrors(bean: hausadresseInstance, field: 'strasse', 'error')} required">
	<label for="strasse">
		<g:message code="hausadresse.strasse.label" default="Strasse" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="strasse" maxlength="50" pattern="${hausadresseInstance.constraints.strasse.matches}" required="" value="${hausadresseInstance?.strasse}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hausadresseInstance, field: 'hausnummer', 'error')} required">
	<label for="hausnummer">
		<g:message code="hausadresse.hausnummer.label" default="Hausnummer" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="hausnummer" type="number" min="1" max="1000" value="${hausadresseInstance.hausnummer}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: hausadresseInstance, field: 'zusatz', 'error')} ">
	<label for="zusatz">
		<g:message code="hausadresse.zusatz.label" default="Zusatz" />
		
	</label>
	<g:textField name="zusatz" maxlength="10" value="${hausadresseInstance?.zusatz}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hausadresseInstance, field: 'postleitzahl', 'error')} required">
	<label for="postleitzahl">
		<g:message code="hausadresse.postleitzahl.label" default="Postleitzahl" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="postleitzahl" type="number" min="1000" max="99999" value="${hausadresseInstance.postleitzahl}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: hausadresseInstance, field: 'ort', 'error')} required">
	<label for="ort">
		<g:message code="hausadresse.ort.label" default="Ort" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="ort" maxlength="50" pattern="${hausadresseInstance.constraints.ort.matches}" required="" value="${hausadresseInstance?.ort}"/>
</div>

