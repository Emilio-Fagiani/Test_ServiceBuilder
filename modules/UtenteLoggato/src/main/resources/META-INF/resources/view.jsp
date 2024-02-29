<%@ include file="/init.jsp" %>

<%@ page import="javax.portlet.RenderRequest" %>
<%@ page import="javax.portlet.RenderResponse" %>


<portlet:defineObjects />

<portlet:actionURL var="inviaResourceURL">
	<portlet:param name="javax.portlet.action" value="utente" />
</portlet:actionURL>

<h2> Dati Utente </h2>
<hr>
<p> nome: ${nome} </p>
<p> mail: ${mail} </p>

<aui:form action="<%=inviaResourceURL%>" method="post">
	<aui:button
			type="submit"
			value="customField"
	/>
</aui:form>