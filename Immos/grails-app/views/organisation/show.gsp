
<%@ page import="org.strotmann.immos.Organisation" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'organisation.label', default: 'Organisation')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-organisation" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-organisation" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list organisation">
			
				<g:if test="${organisationInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="organisation.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${organisationInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${organisationInstance?.nameZusatz}">
				<li class="fieldcontain">
					<span id="nameZusatz-label" class="property-label"><g:message code="organisation.nameZusatz.label" default="Name Zusatz" /></span>
					
						<span class="property-value" aria-labelledby="nameZusatz-label"><g:fieldValue bean="${organisationInstance}" field="nameZusatz"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${organisationInstance?.rechtsform}">
				<li class="fieldcontain">
					<span id="rechtsform-label" class="property-label"><g:message code="organisation.rechtsform.label" default="Rechtsform" /></span>
					
						<span class="property-value" aria-labelledby="rechtsform-label"><g:fieldValue bean="${organisationInstance}" field="rechtsform"/></span>
					
				</li>
				</g:if>
				
				<li class="fieldcontain">
					<span id="partnerrolle-label" class="property-label"><g:message code="organisation.partnerrolle.label" default="Ansprechpartner" /></span>
					
						<g:each in="${organisationInstance.getAspaList()}" var="p">
						<span class="property-value" aria-labelledby="partnerrolle-label"><g:link controller="person" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
			
				
				<g:if test="${organisationInstance?.hausadresse}">
				<li class="fieldcontain">
					<span id="hausadresse-label" class="property-label"><g:message code="organisation.hausadresse.label" default="Hausadresse" /></span>
					
						<span class="property-value" aria-labelledby="hausadresse-label"><g:link controller="hausadresse" action="show" id="${organisationInstance?.hausadresse?.id}">${organisationInstance?.hausadresse?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${organisationInstance?.bankverbindung}">
				<li class="fieldcontain">
					<span id="bankverbindung-label" class="property-label"><g:message code="organisation.bankverbindung.label" default="Bankverbindung" /></span>
					
						<g:each in="${organisationInstance.bankverbindung}" var="b">
						<span class="property-value" aria-labelledby="bankverbindung-label"><g:link controller="bankverbindung" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${organisationInstance?.kommunikation}">
				<li class="fieldcontain">
					<span id="kommunikation-label" class="property-label"><g:message code="organisation.kommunikation.label" default="Kommunikation" /></span>
					
						<g:each in="${organisationInstance.kommunikation}" var="k">
						<span class="property-value" aria-labelledby="kommunikation-label"><g:link controller="kommunikation" action="show" id="${k.id}">${k?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${organisationInstance?.partnerrolle}">
				<li class="fieldcontain">
					<span id="partnerrolle-label" class="property-label"><g:message code="organisation.partnerrolle.label" default="Partnerrolle" /></span>
					
						<g:each in="${organisationInstance.partnerrolle}" var="p">
						<span class="property-value" aria-labelledby="partnerrolle-label"><g:link controller="partnerrolle" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
				
				<g:if test="${organisationInstance?.postfachadresse}">
				<li class="fieldcontain">
					<span id="postfachadresse-label" class="property-label"><g:message code="organisation.postfachadresse.label" default="Postfachadresse" /></span>
					
						<g:each in="${organisationInstance.postfachadresse}" var="p">
						<span class="property-value" aria-labelledby="postfachadresse-label"><g:link controller="postfachadresse" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
				
				<li class="fieldcontain">
					<span id="notizen-label" class="property-label"><g:message code="organisation.notizen.label" default="Notizen" /></span>
					
						<g:each in="${org.strotmann.immos.Notiz.getNotizen('Organisation',organisationInstance.id)}" var="n">
						<span class="property-value" aria-labelledby="notizen-label"><g:link controller="notiz" action="show" id="${n.id}">${n}</g:link></span>
						</g:each>
					
				</li>
			
			</ol>
			<g:form url="[resource:mietsacheInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${organisationInstance?.id}" />
					<g:link class="edit" action="edit" id="${organisationInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit method="DELETE" class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
