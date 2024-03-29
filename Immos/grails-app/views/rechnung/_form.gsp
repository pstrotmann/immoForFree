<%@ page import="org.strotmann.immos.Rechnung" %>



<div class="fieldcontain ${hasErrors(bean: rechnungInstance, field: 'rechnungssteller', 'error')} required">
	<label for="rechnungssteller">
		<g:message code="rechnung.rechnungssteller.label" default="Rechnungssteller" />
		<span class="required-indicator">*</span>
	</label>
	<g:if test="${flash.partner}">
		<g:select id="partner" name="partner.id" from="${flash.partner}" optionKey="id" required="" value="${rechnungInstance?.rechnungssteller?.id}" class="many-to-one"/>
	</g:if>
	<g:if test="${rechnungInstance?.rechnungssteller}">
		<g:select id="partner" name="partner.id" from="${org.strotmann.immos.Rechnung.rechnungsstellerList}" optionKey="id" required="" value="${rechnungInstance?.rechnungssteller?.partner?.id}" class="many-to-one"/>
		<%--		<g:fieldValue bean="${rechnungInstance?.rechnungssteller?.partner}" field="name" />--%>
	</g:if>
	<g:if test="${!flash.partner && !rechnungInstance?.rechnungssteller}">
		<g:select id="partner" name="partner.id" from="${org.strotmann.immos.Rechnung.getRechnungsstellerList()}" optionKey="id" required="" value="${rechnungInstance?.rechnungssteller?.id}" class="many-to-one"/>
	</g:if></div>

<div class="fieldcontain ${hasErrors(bean: rechnungInstance, field: 'immobilie', 'error')} required">
	<label for="immobilie">
		<g:message code="rechnung.immobilie.label" default="Immobilie" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="immobilie" name="immobilie.id" from="${org.strotmann.immos.Immobilie.immobilien}" optionKey="id" required="" value="${rechnungInstance?.immobilie?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: rechnungInstance, field: 'rechnungsdatum', 'error')} required">
	<label for="rechnungsdatum">
		<g:message code="rechnung.rechnungsdatum.label" default="Rechnungsdatum" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="rechnungsdatum" precision="day"  value="${rechnungInstance?.rechnungsdatum}" years="${new Date().getYear()+1895..new Date().getYear() + 1901}" />
</div>

<div class="fieldcontain ${hasErrors(bean: rechnungInstance, field: 'rechnungsnummer', 'error')} ">
	<label for="rechnungsnummer">
		<g:message code="rechnung.rechnungsnummer.label" default="Rechnungsnummer" />
		
	</label>
	<g:field name="rechnungsnummer" style="width:120px" type="text" value="${rechnungInstance?.rechnungsnummer}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: rechnungInstance, field: 'rechnungsgegenstand', 'error')} ">
	<label for="rechnungsgegenstand">
		<g:message code="rechnung.rechnungsgegenstand.label" default="Rechnungsgegenstand" />
		
	</label>
	<g:textField name="rechnungsgegenstand" style="width:500px" value="${rechnungInstance?.rechnungsgegenstand}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: rechnungInstance, field: 'betrag', 'error')} required">
	<label for="betrag">
		<g:message code="rechnung.betrag.label" default="Betrag" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="betrag" style="width:80px" type="text"  value="${fieldValue(bean: rechnungInstance, field: 'betrag')}" required=""/>
</div>

<%--<div class="fieldcontain ${hasErrors(bean: rechnungInstance, field: 'kundennummer', 'error')} ">--%>
<%--	<label for="kundennummer">--%>
<%--		<g:message code="rechnung.kundennummer.label" default="Kundennummer" />--%>
<%--		--%>
<%--	</label>--%>
<%--	<g:field name="kundennummer" style="width:120px" type="text" value="${rechnungInstance?.kundennummer}"/>--%>
<%--</div>--%>

<div class="fieldcontain ${hasErrors(bean: rechnungInstance, field: 'umlagefaehig', 'error')} ">
	<label for="umlagefaehig">
		<g:message code="rechnung.umlagefaehig.label" default="Umlagefähig" />
		
	</label>
	<g:checkBox name="umlagefaehig" value="${rechnungInstance?.umlagefaehig}" />
</div>

<div class="fieldcontain ${hasErrors(bean: rechnungInstance, field: 'umlageinfo', 'error')} ">
<label for="umlageinfo">
	<g:message code="rechnung.umlageinfo.label" default="Umlageinfo" />
</label>
<g:if test="${rechnungInstance?.umlageinfos}">
	<g:each in="${rechnungInstance.umlageinfos}" var="u">
		<g:link controller="umlageinfo" action="show" id="${u.id}">${u?.encodeAsHTML()}</g:link>
	</g:each>
</g:if>
<g:else>
	<g:link controller="umlageinfo" action="create" params="['rechnung.id': rechnungInstance?.id]"><g:message code="rechnung.anlegen.label" default="Anlegen" /></g:link>
</g:else>
</div>

<div class="fieldcontain ${hasErrors(bean: rechnungInstance, field: 'notizen', 'error')} ">
	<label for="notizen">
		<g:message code="rechnung.notizen.label" default="Notizen" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${org.strotmann.immos.Notiz.getNotizen('Rechnung',rechnungInstance.id)}" var="n">
    <li><g:link controller="notiz" action="show" id="${n.id}">${n}</g:link></li>
</g:each>
<li class="add">
<g:link controller="notiz" action="create" params="['rechnung.id': rechnungInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'notiz.label', default: 'Notiz')])}</g:link>
</li>
</ul>

</div>

