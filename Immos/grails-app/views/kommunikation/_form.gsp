<%@ page import="org.strotmann.immos.Kommunikation" %>



<div class="fieldcontain ${hasErrors(bean: kommunikationInstance, field: 'art', 'error')} ">
	<label for="art">
		<g:message code="kommunikation.art.label" default="Art" />
		
	</label>
	<g:select name="art" from="${kommunikationInstance.constraints.art.inList}" value="${kommunikationInstance?.art}" valueMessagePrefix="kommunikation.art" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: kommunikationInstance, field: 'anwahl', 'error')} required">
	<label for="anwahl">
		<g:message code="kommunikation.anwahl.label" default="Anwahl" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="anwahl" required="" value="${kommunikationInstance?.anwahl}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: kommunikationInstance, field: 'zusatz', 'error')} ">
	<label for="zusatz">
		<g:message code="kommunikation.zusatz.label" default="Zusatz" />
		
	</label>
	<g:textField name="zusatz" value="${kommunikationInstance?.zusatz}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: kommunikationInstance, field: 'partner', 'error')} required">
	<label for="partner">
		<g:message code="kommunikation.partner.label" default="Partner" />
		<span class="required-indicator">*</span>
	</label>
	<g:if test="${flash.partner}">
		<g:select id="partner" name="partner.id" from="${flash.partner}" optionKey="id" required="" value="${kommunikationInstance?.partner?.id}" class="many-to-one"/>
	</g:if>
	<g:else>
		<g:select id="partner" name="partner.id" from="${kommunikationInstance?.partner}" optionKey="id" required="" value="${kommunikationInstance?.partner?.id}" class="many-to-one"/>
	</g:else>
</div>

