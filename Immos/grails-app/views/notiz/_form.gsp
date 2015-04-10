<%@ page import="org.strotmann.immos.Notiz" %>



<div class="fieldcontain ${hasErrors(bean: notizInstance, field: 'anlagetermin', 'error')} required">
	<label for="anlagetermin">
		<g:message code="notiz.anlagetermin.label" default="Anlagetermin" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="anlagetermin" precision="day"  value="${notizInstance?.anlagetermin}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: notizInstance, field: 'notiztext', 'error')} required">
	<label for="notiztext">
		<g:message code="notiz.notiztext.label" default="Notiztext" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="notiztext" required="" value="${notizInstance?.notiztext}" rows="2" cols="80"/>

</div>

<div class="fieldcontain ${hasErrors(bean: notizInstance, field: 'referenz', 'error')} required">
	<label for="referenz">
		<g:message code="notiz.referenz.label" default="Referenz" />
		<span class="required-indicator">*</span>
	</label>
	<g:if test="${flash.referenz}">
		<g:if test="${flash.domref}">
			<g:textArea name="referenz" required="" value="${flash.referenz} ${flash.domref.toString()}" rows="2" cols="80"/>
		</g:if>
		<g:else>
			<g:select name="referenz" from="${Notiz.getRefs(flash.domName)}"/>
		</g:else>
	</g:if>
	<g:else>
		<g:textArea name="referenz" required="" value="${notizInstance?.referenz}" rows="2" cols="80"/>
	</g:else>

</div>

<div class="fieldcontain ${hasErrors(bean: notizInstance, field: 'wiedervorlagetermin', 'error')} required">
	<label for="wiedervorlagetermin">
		<g:message code="notiz.wiedervorlagetermin.label" default="Wiedervorlagetermin" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="wiedervorlagetermin" precision="day"  value="${notizInstance?.wiedervorlagetermin}"  />

</div>

