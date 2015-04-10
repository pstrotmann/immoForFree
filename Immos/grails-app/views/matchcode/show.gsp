
<%@ page import="org.strotmann.immos.Matchcode" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'matchcode.label', default: 'Matchcode')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-matchcode" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-matchcode" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list matchcode">
			
				<g:if test="${matchcodeInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="matchcode.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${matchcodeInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${matchcodeInstance?.vorname}">
				<li class="fieldcontain">
					<span id="vorname-label" class="property-label"><g:message code="matchcode.vorname.label" default="Vorname" /></span>
					
						<span class="property-value" aria-labelledby="vorname-label"><g:fieldValue bean="${matchcodeInstance}" field="vorname"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${matchcodeInstance?.strasse}">
				<li class="fieldcontain">
					<span id="strasse-label" class="property-label"><g:message code="matchcode.strasse.label" default="Strasse" /></span>
					
						<span class="property-value" aria-labelledby="strasse-label"><g:fieldValue bean="${matchcodeInstance}" field="strasse"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${matchcodeInstance?.postleitzahl}">
				<li class="fieldcontain">
					<span id="postleitzahl-label" class="property-label"><g:message code="matchcode.postleitzahl.label" default="Postleitzahl" /></span>
					
						<span class="property-value" aria-labelledby="postleitzahl-label"><g:fieldValue bean="${matchcodeInstance}" field="postleitzahl"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${matchcodeInstance?.ort}">
				<li class="fieldcontain">
					<span id="ort-label" class="property-label"><g:message code="matchcode.ort.label" default="Ort" /></span>
					
						<span class="property-value" aria-labelledby="ort-label"><g:fieldValue bean="${matchcodeInstance}" field="ort"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${matchcodeInstance?.id}" />
					<g:link class="edit" action="edit" id="${matchcodeInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
