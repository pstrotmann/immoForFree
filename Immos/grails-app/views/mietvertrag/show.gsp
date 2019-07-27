
<%@ page import="org.strotmann.immos.Mietvertrag" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'mietvertrag.label', default: 'Mietvertrag')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-mietvertrag" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-mietvertrag" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list mietvertrag">
			
				<g:if test="${mietvertragInstance?.mieter}">
				<li class="fieldcontain">
					<span id="partnerrolle-label" class="property-label"><g:message code="mietvertrag.mieter.label" default="Mieter" /></span>
					
						<span class="property-value" aria-labelledby="mieter-label">
						<g:if test="${mietvertragInstance?.mieter?.partner instanceof org.strotmann.immos.Person}">
							<g:link controller="person" action="show" id="${mietvertragInstance?.mieter?.partner.id}">${mietvertragInstance?.mieter?.partner.name.encodeAsHTML()}</g:link>
						</g:if>
						<g:if test="${mietvertragInstance?.mieter?.partner instanceof org.strotmann.immos.Organisation}">
							<g:link controller="organisation" action="show" id="${mietvertragInstance?.mieter?.partner.id}">${mietvertragInstance?.mieter?.partner.name.encodeAsHTML()}</g:link>
						</g:if>
						</span>
					
				</li>
				</g:if>
				
				<li class="fieldcontain">
					<span id="partnerrolle-label" class="property-label"><g:message code="organisation.mieter.label" default="Mietzahler" /></span>
					
						<g:each in="${mietvertragInstance.getZahlerList()}" var="p">
						<span class="property-value" aria-labelledby="partnerrolle-label"><g:link controller="organisation" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
			
				<g:if test="${mietvertragInstance?.mietsache}">
				<li class="fieldcontain">
					<span id="mietsache-label" class="property-label"><g:message code="mietvertrag.mietsache.label" default="Mietsache" /></span>
					
						<span class="property-value" aria-labelledby="mietsache-label"><g:link controller="mietsache" action="show" id="${mietvertragInstance?.mietsache?.id}">${mietvertragInstance?.mietsache?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
				
				<g:if test="${mietvertragInstance?.zusatzMietsache}">
				<li class="fieldcontain">
					<span id="zusatzMietsache-label" class="property-label"><g:message code="mietvertrag.zusatzMietsache.label" default="Zusatz" /></span>
					
						<span class="property-value" aria-labelledby="zusatzMietsache-label"><g:link controller="mietsache" action="show" id="${mietvertragInstance?.zusatzMietsache?.id}">${mietvertragInstance?.zusatzMietsache?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${mietvertragInstance?.mietbeginn}">
				<li class="fieldcontain">
					<span id="mietbeginn-label" class="property-label"><g:message code="mietvertrag.mietbeginn.label" default="Mietbeginn" /></span>
					
						<span class="property-value" aria-labelledby="mietbeginn-label"><g:formatDate date="${mietvertragInstance?.mietbeginn}" format="dd.MM.yyyy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${mietvertragInstance?.mietende}">
				<li class="fieldcontain">
					<span id="mietende-label" class="property-label"><g:message code="mietvertrag.mietende.label" default="Mietende" /></span>
					
						<span class="property-value" aria-labelledby="mietende-label"><g:formatDate date="${mietvertragInstance?.mietende}" format="dd.MM.yyyy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${mietvertragInstance?.kaution}">
				<li class="fieldcontain">
					<span id="kaution-label" class="property-label"><g:message code="mietvertrag.kaution.label" default="Kaution" /></span>
					
						<span class="property-value" aria-labelledby="kaution-label"><g:fieldValue bean="${mietvertragInstance}" field="kaution"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${mietvertragInstance?.zahlweise}">
				<li class="fieldcontain">
					<span id="zahlweise-label" class="property-label"><g:message code="mietvertrag.zahlweise.label" default="Zahlweise" /></span>
					
						<span class="property-value" aria-labelledby="zahlweise-label">
							<g:fieldValue bean="${mietvertragInstance}" field="zahlweiseKlar"/>
						</span>
					
				</li>
				</g:if>
				
				<g:if test="${mietvertragInstance?.tuerschluessel}">
				<li class="fieldcontain">
					<span id="tuerschluessel-label" class="property-label"><g:message code="mietvertrag.tuerschluessel.label" default="Tuerschluessel" /></span>
					
						<span class="property-value" aria-labelledby="tuerschluessel-label"><g:fieldValue bean="${mietvertragInstance}" field="tuerschluessel"/></span>
					
				</li>
				</g:if>
				
				<li class="fieldcontain">
					<span id="mietsaldo-label" class="property-label"><g:message code="mietvertrag.mietsaldo.label" default="Mietsaldo" /></span>
					
						<span class="property-value" aria-labelledby="mietsaldo-label">
						<g:formatNumber number="${mietvertragInstance.mietsaldo}" type="number" minFractionDigits="2" format="#,##0.00"/>
						<g:if test="${mietvertragInstance.mietsaldo < 0}">
							<span style="color:red;"><g:emoticon happy="false"></g:emoticon></span>
						</g:if>
						<g:if test="${mietvertragInstance.mietsaldo > 0}">
							<span style="color:green;"><g:emoticon happy="true"></g:emoticon></span>
						</g:if>
						</span>
				</li>
				
				<li class="fieldcontain">
					<span id="vorausNK-label" class="property-label"><g:message code="mietvertrag.vorausNK.label" default="VorauszahlungNK VJ" /></span>
					<span class="property-value" aria-labelledby="vorausNK-label">
						<g:formatNumber number="${mietvertragInstance.nebkoVj}" type="number" minFractionDigits="2" format="#,##0.00"/>
					</span>
				</li>
				
				<li class="fieldcontain">
					<span id="vorausHK-label" class="property-label"><g:message code="mietvertrag.vorausHK.label" default="VorauszahlungHK VJ" /></span>
					<span class="property-value" aria-labelledby="vorausHK-label">
						<g:formatNumber number="${mietvertragInstance.heikoVj}" type="number" minFractionDigits="2" format="#,##0.00"/>
					</span>
				</li>
			
				<g:if test="${mietvertragInstance?.vertragsstaende}">
				<li class="fieldcontain">
					<span id="vertragsstaende-label" class="property-label"><g:message code="mietvertrag.vertragsstaende.label" default="Vertragsstände" /></span>
					
						<g:each in="${mietvertragInstance.vertragsstaende}" var="v">
						<span class="property-value" aria-labelledby="vertragsstaende-label"><g:link controller="mietvertragsstand" action="show" id="${v.id}">${v?.vstandKurz}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${mietvertragInstance?.zahlungen}">
				<li class="fieldcontain">
					<span id="zahlungen-label" class="property-label"><g:message code="mietvertrag.zahlungen.label" default="Zahlungen" /></span>
					
						<g:each in="${mietvertragInstance.zahlungen}" var="z">
							<span class="property-value" aria-labelledby="zahlungen-label">
								<g:link controller="zahlung" action="show" id="${z.id}">${z?.zPlus()}</g:link>
							</span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${mietvertragInstance?.mietforderungen}">
				<li class="fieldcontain">
					<span id="mietforderungen-label" class="property-label"><g:message code="mietvertrag.mietforderungen.label" default="außerordentliche Fälligkeiten" /></span>
					
						<g:each in="${mietvertragInstance.mietforderungen}" var="m">
						<span class="property-value" aria-labelledby="mietforderungen-label"><g:link controller="offenerPosten" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
				
				<li class="fieldcontain">
					<span id="hPausch-label" class="property-label"><g:message code="mietvertrag.hPausch.label" default="HK Pauschale VJ" /></span>
					
						<span class="property-value" aria-labelledby="hPausch-label">
						<g:formatNumber number="${mietvertragInstance.getHeiko(2014)}" type="number" minFractionDigits="2" format="#,##0.00"/>
						
						</span>
				</li>	
				
				<g:if test="${mietvertragInstance?.betriebskostenabrechnungen}">
				<li class="fieldcontain">
					<span id="betriebskostenabrechnungen-label" class="property-label"><g:message code="mietvertrag.betriebskostenabrechnungen.label" default="Betriebskostenabrechnungen" /></span>
					
						<g:each in="${mietvertragInstance.betriebskostenabrechnungen}" var="n">
						<span class="property-value" aria-labelledby="betriebskostenabrechnungen-label"><g:link controller="betriebskostenabrechnung" action="show" id="${n.id}">${n?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
				
				<li class="fieldcontain">
					<span id="notizen-label" class="property-label"><g:message code="mietvertrag.notizen.label" default="Notizen" /></span>
					
						<g:each in="${org.strotmann.immos.Notiz.getNotizen('Mietvertrag',mietvertragInstance.id)}" var="n">
						<span class="property-value" aria-labelledby="notizen-label"><g:link controller="notiz" action="show" id="${n.id}">${n}</g:link></span>
						</g:each>
				</li>
			
			</ol>
			<g:form url="[resource:mietvertragInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${mietvertragInstance?.id}" />
					<g:link class="edit" action="edit" id="${mietvertragInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
