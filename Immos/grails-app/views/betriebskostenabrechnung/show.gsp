
<%@ page import="org.strotmann.immos.Betriebskostenabrechnung" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'betriebskostenabrechnung.label', default: 'Betriebskostenabrechnung')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-betriebskostenabrechnung" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-betriebskostenabrechnung" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list betriebskostenabrechnung">
			
				<g:if test="${betriebskostenabrechnungInstance?.heizkostenabrechnungen}">
				<li class="fieldcontain">
					<span id="heizkostenabrechnungen-label" class="property-label"><g:message code="betriebskostenabrechnung.heizkostenabrechnungen.label" default="Heizkostenabrechnungen" /></span>
					
						<g:each in="${betriebskostenabrechnungInstance.heizkostenabrechnungen}" var="h">
						<span class="property-value" aria-labelledby="heizkostenabrechnungen-label"><g:link controller="heizkostenabrechnung" action="show" id="${h.id}">${h?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${betriebskostenabrechnungInstance?.immoabrechnung}">
				<li class="fieldcontain">
					<span id="immoabrechnung-label" class="property-label"><g:message code="betriebskostenabrechnung.immoabrechnung.label" default="Immoabrechnung" /></span>
					
						<span class="property-value" aria-labelledby="immoabrechnung-label"><g:link controller="immoabrechnung" action="show" id="${betriebskostenabrechnungInstance?.immoabrechnung?.id}">${betriebskostenabrechnungInstance?.immoabrechnung?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${betriebskostenabrechnungInstance?.mietvertrag}">
				<li class="fieldcontain">
					<span id="mietvertrag-label" class="property-label"><g:message code="betriebskostenabrechnung.mietvertrag.label" default="Mietvertrag" /></span>
					
						<span class="property-value" aria-labelledby="mietvertrag-label"><g:link controller="mietvertrag" action="show" id="${betriebskostenabrechnungInstance?.mietvertrag?.id}">${betriebskostenabrechnungInstance?.mietvertrag?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${betriebskostenabrechnungInstance?.nebenkostenabrechnungen}">
				<li class="fieldcontain">
					<span id="nebenkostenabrechnungen-label" class="property-label"><g:message code="betriebskostenabrechnung.nebenkostenabrechnungen.label" default="Nebenkostenabrechnung" /></span>
					
						<g:each in="${betriebskostenabrechnungInstance.nebenkostenabrechnungen}" var="n">
						<span class="property-value" aria-labelledby="nebenkostenabrechnungen-label"><g:link controller="nebenkostenabrechnung" action="show" id="${n.id}">${n?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
				
				<g:if test="${betriebskostenabrechnungInstance?.betriebskostenabrechnungsbriefe}">
				<li class="fieldcontain">
					<span id="betriebskostenabrechnungsbriefe-label" class="property-label"><g:message code="betriebskostenabrechnungsbrief.nebenkostenabrechnungen.label" default="Abrechnungsbrief" /></span>
					
						<g:each in="${betriebskostenabrechnungInstance.betriebskostenabrechnungsbriefe}" var="b">
						<span class="property-value" aria-labelledby="betriebskostenabrechnungsbriefe-label"><g:link controller="betriebskostenabrechnungsbrief" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:betriebskostenabrechnungInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${betriebskostenabrechnungInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
