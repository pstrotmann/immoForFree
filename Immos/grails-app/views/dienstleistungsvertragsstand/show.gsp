
<%@ page import="org.strotmann.immos.Dienstleistungsvertragsstand" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'dienstleistungsvertragsstand.label', default: 'Dienstleistungsvertragsstand')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-dienstleistungsvertragsstand" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-dienstleistungsvertragsstand" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list dienstleistungsvertragsstand">
			
				<g:if test="${dienstleistungsvertragsstandInstance?.gueltigAb}">
				<li class="fieldcontain">
					<span id="gueltigAb-label" class="property-label"><g:message code="dienstleistungsvertragsstand.gueltigAb.label" default="Gueltig Ab" /></span>
					
						<span class="property-value" aria-labelledby="gueltigAb-label"><g:formatDate date="${dienstleistungsvertragsstandInstance?.gueltigAb}" format="dd.MM.yyyy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${dienstleistungsvertragsstandInstance?.pauschale}">
				<li class="fieldcontain">
					<span id="pauschale-label" class="property-label"><g:message code="dienstleistungsvertragsstand.pauschale.label" default="Pauschale" /></span>
					
						<span class="property-value" aria-labelledby="pauschale-label"><g:formatNumber number="${dienstleistungsvertragsstandInstance.pauschale}" type="number" minFractionDigits="2" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${dienstleistungsvertragsstandInstance?.dienstleistungsvertrag}">
				<li class="fieldcontain">
					<span id="dienstleistungsvertrag-label" class="property-label"><g:message code="dienstleistungsvertragsstand.dienstleistungsvertrag.label" default="Dienstleistungsvertrag" /></span>
					
						<span class="property-value" aria-labelledby="dienstleistungsvertrag-label"><g:link controller="dienstleistungsvertrag" action="show" id="${dienstleistungsvertragsstandInstance?.dienstleistungsvertrag?.id}">${dienstleistungsvertragsstandInstance?.dienstleistungsvertrag?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:dienstleistungsvertragsstandInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${dienstleistungsvertragsstandInstance?.id}" />
					<g:link class="edit" action="edit" id="${dienstleistungsvertragsstandInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit method="delete" class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
