<%@ page import="org.strotmann.immos.Mietvertrag" %>



<div class="fieldcontain ${hasErrors(bean: mietvertragInstance, field: 'partnerrolle', 'error')} required">
	<label for="partnerrolle">
		<g:message code="mietvertrag?.mieter.label" default="Mieter" />
		<span class="required-indicator">*</span>
	</label>
	<g:if test="${flash.partner}">
		<g:fieldValue bean="${flash.partner}" field="name" />
	</g:if>
	<g:if test="${mietvertragInstance?.mieter}">
		<g:fieldValue bean="${mietvertragInstance?.mieter?.partner}" field="name" />
	</g:if>
	<g:if test="${!flash.partner && !mietvertragInstance?.mieter}">
		<g:select id="partner" name="partner.id" from="${org.strotmann.immos.Mietvertrag.getMieterList()}" optionKey="id" required="" value="${mietvertragInstance?.mieter?.id}" class="many-to-one"/>
	</g:if>
</div>

<div class="fieldcontain ${hasErrors(bean: mietvertragInstance, field: 'mietsache', 'error')} required">
	<label for="mietsache">
		<g:message code="mietvertrag.mietsache.label" default="Mietsache" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="mietsache" name="mietsache.id" from="${org.strotmann.immos.Mietsache.mietsachen}" optionKey="id" required="" value="${mietvertragInstance?.mietsache?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mietvertragInstance, field: 'zusatzMietsache', 'error')} ">
	<label for="zusatzMietsache">
		<g:message code="mietvertrag.zusatzMietsache.label" default="Zusatz" />
		
	</label>
	<g:select id="zusatzMietsache" name="zusatzMietsache.id" from="${org.strotmann.immos.Mietsache.list()}" optionKey="id" value="${mietvertragInstance?.zusatzMietsache?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mietvertragInstance, field: 'mietbeginn', 'error')} required">
	<label for="mietbeginn">
		<g:message code="mietvertrag.mietbeginn.label" default="Mietbeginn" />
		<span class="required-indicator">*</span>
	</label>
	<g:if test="${flash.create}">
		<g:datePicker name="mietbeginn" precision="day" years="${new Date().getYear()+1899..new Date().getYear() + 1901}" value="${mietvertragInstance?.mietbeginn}"  />
	</g:if>
	<g:else>
		<g:datePicker name="mietbeginn" precision="day" value="${mietvertragInstance?.mietbeginn}"  />
	</g:else>
</div>

<div class="fieldcontain ${hasErrors(bean: mietvertragInstance, field: 'mietende', 'error')} ">
	<label for="mietende">
		<g:message code="mietvertrag.mietende.label" default="Mietende" />
		
	</label>
	<g:datePicker name="mietende" precision="day" years="${new Date().getYear()+1899..new Date().getYear() + 1901}" value="${mietvertragInstance?.mietende}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: mietvertragInstance, field: 'kaution', 'error')} ">
	<label for="kaution">
		<g:message code="mietvertrag.kaution.label" default="Kaution" />
		
	</label>
	<g:field name="kaution" value="${fieldValue(bean: mietvertragInstance, field: 'kaution')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mietvertragInstance, field: 'zahlweise', 'error')} required">
	<label for="zahlweise">
		<g:message code="mietvertrag.zahlweise.label" default="Zahlweise" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="zahlweise" from="${mietvertragInstance.constraints.zahlweise.inList}" value="${mietvertragInstance?.zahlweise}" valueMessagePrefix="zahlweise.category" />
</div>

<div class="fieldcontain ${hasErrors(bean: mietvertragInstance, field: 'tuerschluessel', 'error')} ">
	<label for="tuerschluessel">
		<g:message code="mietvertrag.tuerschluessel.label" default="Tuerschluessel" />
		
	</label>
	<g:textField name="tuerschluessel" value="${mietvertragInstance?.tuerschluessel}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mietvertragInstance, field: 'vertragsstaende', 'error')} ">
	<label for="vertragsstaende">
		<g:message code="mietvertrag.vertragsstaende.label" default="Vertragsstände" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${mietvertragInstance?.vertragsstaende?}" var="v">
    <li><g:link controller="mietvertragsstand" action="show" id="${v.id}">${v?.vstandKurz.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="mietvertragsstand" action="create" params="['mietvertrag.id': mietvertragInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'mietvertragsstand.label', default: 'Mietvertragsstand')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: mietvertragInstance, field: 'zahlungen', 'error')} ">
	<label for="zahlungen">
		<g:message code="mietvertrag.zahlungen.label" default="Zahlungen" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${mietvertragInstance?.zahlungen?}" var="z">
    <li><g:link controller="zahlung" action="show" id="${z.id}">${z?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="zahlung" action="create" params="['mietvertrag.id': mietvertragInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'zahlung.label', default: 'Zahlung')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: mietvertragInstance, field: 'mietforderungen', 'error')} ">
	<label for="mietforderungen">
		<g:message code="mietvertrag.mietforderungen.label" default="außerordentliche Fälligkeiten" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${mietvertragInstance?.mietforderungen?}" var="m">
    <li><g:link controller="offenerPosten" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="offenerPosten" action="create" params="['mietvertrag.id': mietvertragInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'offenerPosten.label', default: 'OffenerPosten')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: mietvertragInstance, field: 'notizen', 'error')} ">
	<label for="notizen">
		<g:message code="mietvertrag.notizen.label" default="Notizen" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${org.strotmann.immos.Notiz.getNotizen('Mietvertrag',mietvertragInstance.id)}" var="n">
    <li><g:link controller="notiz" action="show" id="${n.id}">${n}</g:link></li>
</g:each>
<li class="add">
<g:link controller="notiz" action="create" params="['mietvertrag.id': mietvertragInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'notiz.label', default: 'Notiz')])}</g:link>
</li>
</ul>

</div>

