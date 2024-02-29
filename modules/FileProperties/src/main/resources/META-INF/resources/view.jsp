<%@ include file="/init.jsp" %>
<%@ page import="javax.portlet.RenderRequest" %>
<%@ page import="javax.portlet.RenderResponse" %>


<portlet:defineObjects />


<portlet:resourceURL var="imageResourceURL">
    <portlet:param name="imageURL" value="img" />
</portlet:resourceURL>
${img}
<img src="<%= imageResourceURL %>" alt="Immagine esterna" />

<h2> MAIL : ${mail} </h2>
<h2> PHONE : ${phone} </h2>