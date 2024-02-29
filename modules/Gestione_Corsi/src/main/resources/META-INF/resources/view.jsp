<%@ include file="/init.jsp" %>
<%@ page import="javax.portlet.RenderRequest" %>
<%@ page import="javax.portlet.RenderResponse" %>


<portlet:defineObjects />

<%
    String nome = (String) request.getAttribute("nome");
    String mail = (String) request.getAttribute("mail");

    if(nome == null){
        nome = "Nome non trovato";
    }
    if(mail == null){
        mail = "Mail non trovata";
    }

%>


<portlet:actionURL var="inviaResourceURL">
	<portlet:param name="javax.portlet.action" value="mostraUtente" />
</portlet:actionURL>



<h2> Dati Utente </h2>
<hr>
<p> nome: ${nome} </p>
<p> mail: ${mail} </p>


<aui:form action="<%=inviaResourceURL%>" method="post">
	<aui:button
			type="submit"
			value="mostraUtente"
	/>
</aui:form>