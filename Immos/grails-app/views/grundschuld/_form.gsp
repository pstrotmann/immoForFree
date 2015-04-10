<%@ page import="org.strotmann.immos.Grundschuld" %>



<div class="fieldcontain ${hasErrors(bean: grundschuldInstance, field: 'eintragAm', 'error')} required">
	<label for="eintragAm">
		<g:message code="grundschuld.eintragAm.label" default="Eintrag Am" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="eintragAm" precision="day"  value="${grundschuldInstance?.eintragAm}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: grundschuldInstance, field: 'loeschungAm', 'error')} ">
	<label for="loeschungAm">
		<g:message code="grundschuld.loeschungAm.label" default="Loeschung Am" />
		
	</label>
	<g:datePicker name="loeschungAm" precision="day"  value="${grundschuldInstance?.loeschungAm}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: grundschuldInstance, field: 'betrag', 'error')} required">
	<label for="betrag">
		<g:message code="grundschuld.betrag.label" default="Betrag" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="betrag" value="${fieldValue(bean: grundschuldInstance, field: 'betrag')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: grundschuldInstance, field: 'rang', 'error')} required">
	<label for="rang">
		<g:message code="grundschuld.rang.label" default="Rang" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="rang" type="number" value="${grundschuldInstance.rang}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: grundschuldInstance, field: 'glaeubiger', 'error')} required">
	<label for="glaeubiger">
		<g:message code="grundschuld.glaeubiger.label" default="Glaeubiger" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="glaeubiger" name="glaeubiger.id" from="${org.strotmann.immos.Organisation.miniList}" optionKey="id" required="" value="${grundschuldInstance?.glaeubiger?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: grundschuldInstance, field: 'immobilie', 'error')} required">
	<label for="immobilie">
		<g:message code="grundschuld.immobilie.label" default="Immobilie" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="immobilie" name="immobilie.id" from="${org.strotmann.immos.Immobilie.list()}" optionKey="id" required="" value="${grundschuldInstance?.immobilie?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: grundschuldInstance, field: 'kredite', 'error')} ">
	<label for="kredite">
		<g:message code="grundschuld.kredite.label" default="Kredite" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${grundschuldInstance?.kredite?}" var="k">
    <li><g:link controller="kredit" action="show" id="${k.id}">${k?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="kredit" action="create" params="['grundschuld.id': grundschuldInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'kredit.label', default: 'Kredit')])}</g:link>
</li>
</ul>

</div>

