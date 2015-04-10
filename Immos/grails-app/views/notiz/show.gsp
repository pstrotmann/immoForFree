
<%@ page import="org.strotmann.immos.Notiz" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'notiz.label', default: 'Notiz')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-notiz" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li>
				<div class="fieldcontain" >
					<g:form action="index" >
						<fieldset class="form">
							<g:actionSubmit action= "create" value="Notiz anlegen für" />
							<g:select name="domName" from="${Notiz.domNamen}" value="it"/>
						</fieldset>	
					</g:form>
				</div>
				</li>
			</ul>
		</div>
		<div id="show-notiz" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list notiz">
			
				<g:if test="${notizInstance?.anlagetermin}">
				<li class="fieldcontain">
					<span id="anlagetermin-label" class="property-label"><g:message code="notiz.anlagetermin.label" default="Anlagetermin" /></span>
					
						<span class="property-value" aria-labelledby="anlagetermin-label"><g:formatDate date="${notizInstance?.anlagetermin}" format="dd.MM.yyyy" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${notizInstance?.notiztext}">
				<li class="fieldcontain">
					<span id="notiztext-label" class="property-label"><g:message code="notiz.notiztext.label" default="Notiztext" /></span>
					
						<span class="property-value" aria-labelledby="notiztext-label"><g:fieldValue bean="${notizInstance}" field="notiztext"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${notizInstance?.referenz}">
				<li class="fieldcontain">
					<span id="referenz-label" class="property-label"><g:message code="notiz.referenz.label" default="Referenz" /></span>
					
						<span class="property-value" aria-labelledby="referenz-label">
							<g:if test="${notizInstance?.refDomIs('dienstleistungsvertrag')}">
								<g:link controller="Dienstleistungsvertrag" action="show" id="${notizInstance.refId}">${notizInstance.referenz}</g:link>
							</g:if>
							<g:if test="${notizInstance?.refDomIs('kredit')}">
								<g:link controller="Kredit" action="show" id="${notizInstance.refId}">${notizInstance.referenz}</g:link>
							</g:if>
							<g:if test="${notizInstance?.refDomIs('mietsache')}">
								<g:link controller="Mietsache" action="show" id="${notizInstance.refId}">${notizInstance.referenz}</g:link>
							</g:if>
							<g:if test="${notizInstance?.refDomIs('mietvertrag')}">
								<g:link controller="Mietvertrag" action="show" id="${notizInstance.refId}">${notizInstance.referenz}</g:link>
							</g:if>
							<g:if test="${notizInstance?.refDomIs('immobilie')}">
								<g:link controller="Immobilie" action="show" id="${notizInstance.refId}">${notizInstance.referenz}</g:link>
							</g:if>
							<g:if test="${notizInstance?.refDomIs('organisation')}">
								<g:link controller="Organisation" action="show" id="${notizInstance.refId}">${notizInstance.referenz}</g:link>
							</g:if>
							<g:if test="${notizInstance?.refDomIs('person')}">
								<g:link controller="Person" action="show" id="${notizInstance.refId}">${notizInstance.referenz}</g:link>
							</g:if>
							<g:if test="${notizInstance?.refDomIs('rechnung')}">
								<g:link controller="Rechnung" action="show" id="${notizInstance.refId}">${notizInstance.referenz}</g:link>
							</g:if>
						</span>
					
				</li>
				</g:if>
			
				<g:if test="${notizInstance?.wiedervorlagetermin}">
				<li class="fieldcontain">
					<span id="wiedervorlagetermin-label" class="property-label"><g:message code="notiz.wiedervorlagetermin.label" default="Wiedervorlagetermin" /></span>
					
						<span class="property-value" aria-labelledby="wiedervorlagetermin-label"><g:formatDate date="${notizInstance?.wiedervorlagetermin}" format="dd.MM.yyyy" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:notizInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${notizInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
