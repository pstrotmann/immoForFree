
<%@ page import="org.strotmann.immos.Mietsache" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'mietsache.label', default: 'Mietsache')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-mietsache" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-mietsache" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list mietsache">
			
				<g:if test="${mietsacheInstance?.lage}">
				<li class="fieldcontain">
					<span id="lage-label" class="property-label"><g:message code="mietsache.lage.label" default="Lage" /></span>
					
						<span class="property-value" aria-labelledby="lage-label"><g:fieldValue bean="${mietsacheInstance}" field="lage"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${mietsacheInstance?.art}">
				<li class="fieldcontain">
					<span id="art-label" class="property-label"><g:message code="mietsache.art.label" default="Art" /></span>
					
						<span class="property-value" aria-labelledby="art-label"><g:fieldValue bean="${mietsacheInstance}" field="art"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${mietsacheInstance?.wohnflaeche}">
				<li class="fieldcontain">
					<span id="wohnflaeche-label" class="property-label"><g:message code="mietsache.wohnflaeche.label" default="Wohnflaeche" /></span>
					
						<span class="property-value" aria-labelledby="wohnflaeche-label"><g:fieldValue bean="${mietsacheInstance}" field="wohnflaeche"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${mietsacheInstance?.aufteilung}">
				<li class="fieldcontain">
					<span id="aufteilung-label" class="property-label"><g:message code="mietsache.aufteilung.label" default="Aufteilung" /></span>
					
						<span class="property-value" aria-labelledby="aufteilung-label"><g:fieldValue bean="${mietsacheInstance}" field="aufteilung"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${mietsacheInstance?.immobilie}">
				<li class="fieldcontain">
					<span id="immobilie-label" class="property-label"><g:message code="mietsache.immobilie.label" default="Immobilie" /></span>
					
						<span class="property-value" aria-labelledby="immobilie-label"><g:link controller="immobilie" action="show" id="${mietsacheInstance?.immobilie?.id}">${mietsacheInstance?.immobilie?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${mietsacheInstance?.mietvertraege}">
				<li class="fieldcontain">
					<span id="mietvertraege-label" class="property-label"><g:message code="mietsache.mietvertraege.label" default="Mietvertraege" /></span>
					
						<g:each in="${mietsacheInstance.mietvertraege}" var="m">
						<span class="property-value" aria-labelledby="mietvertraege-label"><g:link controller="mietvertrag" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
				
				<g:if test="${mietsacheInstance?.zwischenzaehlers}">
				<li class="fieldcontain">
					<span id="zwischenzaehlers-label" class="property-label"><g:message code="mietsache.zwischenzaehlers.label" default="Zwischenzähler" /></span>
					
						<g:each in="${mietsacheInstance.zwischenzaehlers}" var="z">
						<span class="property-value" aria-labelledby="zwischenzaehlers-label"><g:link controller="zwischenzaehler" action="show" id="${z.id}">${z?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
				
				<li class="fieldcontain">
					<span id="notizen-label" class="property-label"><g:message code="mietsache.notizen.label" default="Notizen" /></span>
					
						<g:each in="${org.strotmann.immos.Notiz.getNotizen('Mietsache',mietsacheInstance.id)}" var="n">
						<span class="property-value" aria-labelledby="notizen-label"><g:link controller="notiz" action="show" id="${n.id}">${n}</g:link></span>
						</g:each>
				</li>
			
			</ol>
			<g:form url="[resource:mietsacheInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${mietsacheInstance?.id}" />
					<g:link class="edit" action="edit" id="${mietsacheInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit method="delete" class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
