
<%@ page import="org.strotmann.immos.Zwischenzaehler" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'zwischenzaehler.label', default: 'Zwischenzähler')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-zwischenzaehler" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-zwischenzaehler" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list zwischenzaehler">
			
				<g:if test="${zwischenzaehlerInstance?.zaehlernummer}">
				<li class="fieldcontain">
					<span id="zaehlernummer-label" class="property-label"><g:message code="zwischenzaehler.zaehlernummer.label" default="Zählernummer" /></span>
					
						<span class="property-value" aria-labelledby="zaehlernummer-label"><g:fieldValue bean="${zwischenzaehlerInstance}" field="zaehlernummer"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${zwischenzaehlerInstance?.mietsache}">
				<li class="fieldcontain">
					<span id="mietsache-label" class="property-label"><g:message code="zwischenzaehler.mietsache.label" default="Mietsache" /></span>
					
						<span class="property-value" aria-labelledby="mietsache-label"><g:link controller="mietsache" action="show" id="${zwischenzaehlerInstance?.mietsache?.id}">${zwischenzaehlerInstance?.mietsache?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
				
				<g:if test="${zwischenzaehlerInstance?.stattZaehler}">
    			<li class="fieldcontain">
					<span id="stattZaehler-label" class="property-label"><g:message code="zwischenzaehler.stattZaehler.label" default="statt Zähler"/></span>

						<span class="property-value" aria-labelledby="stattZaehler-label"><g:formatBoolean boolean="${zwischenzaehlerInstance?.stattZaehler}" true="ja" false="nein"/></span>
					  
    			</li>
				</g:if>
			
				<g:if test="${zwischenzaehlerInstance?.zaehler}">
				<li class="fieldcontain">
					<span id="zaehler-label" class="property-label"><g:message code="zwischenzaehler.zaehler.label" default="Zähler" /></span>
					
						<span class="property-value" aria-labelledby="zaehler-label"><g:link controller="zaehler" action="show" id="${zwischenzaehlerInstance?.zaehler?.id}">${zwischenzaehlerInstance?.zaehler?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${zwischenzaehlerInstance?.zwischenzaehlerstaende}">
				<li class="fieldcontain">
					<span id="zwischenzaehlerstaende-label" class="property-label"><g:message code="zwischenzaehler.zwischenzaehlerstaende.label" default="Zwischenzählerstände" /></span>
					
						<g:each in="${zwischenzaehlerInstance.zwischenzaehlerstaende}" var="z">
						<span class="property-value" aria-labelledby="zwischenzaehlerstaende-label"><g:link controller="zwischenzaehlerstand" action="show" id="${z.id}">${z?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${zwischenzaehlerInstance?.id}" />
					<g:link class="edit" action="edit" id="${zwischenzaehlerInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
