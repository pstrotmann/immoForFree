<%@ page import="org.strotmann.immos.Notiz" %>

<div class="fieldcontain ${hasErrors(bean: notizInstance, field: 'anlagetermin', 'error')} ">
	<label for="anlagetermin">
		<g:message code="notiz.anlagetermin.label" default="Anlagetermin" />
	</label>
	<g:select name="notizInstance.anlOp" from="${[' ','<','<=','=','>','>=']}"/>
	<g:datePicker name="anlagetermin" precision="day"  value="${notizInstance?.anlagetermin}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: notizInstance, field: 'notiztext', 'error')} ">
	<label for="notiztext">
		<g:message code="notiz.notiztext.label" default="Notiztext" />
	</label>
	<g:textField name="notiztext" value=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: notizInstance, field: 'referenz', 'error')} ">
	<label for="referenz">
		<g:message code="notiz.referenz.label" default="Referenz" />
	</label>
	<g:textField name="referenz" value=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: notizInstance, field: 'wiedervorlagetermin', 'error')} ">
	<label for="wiedervorlagetermin">
		<g:message code="notiz.wiedervorlagetermin.label" default="Wiedervorlagetermin" />
	</label>
	<g:select name="notizInstance.wvOp" from="${[' ','<','<=','=','>','>=']}"/>
	<g:datePicker name="wiedervorlagetermin" precision="day"  value="${notizInstance?.wiedervorlagetermin}"  />
</div>