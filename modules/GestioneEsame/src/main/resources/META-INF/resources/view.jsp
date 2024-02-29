<%@ include file="/init.jsp" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects />

<portlet:actionURL var="addExamURL" name="addEsame" />

<aui:form action="<%= addExamURL %>" method="post" name="addExamForm" id="addExamForm">
    <aui:fieldset>
        <aui:input name="nomeEsame" label="Nome Esame" type="text" />
        <aui:input name="<portlet:namespace></portlet:namespace>data" label="Data Esame" type="date" />
    </aui:fieldset>

    <aui:button type="submit" value="AGGIUNGI" />
</aui:form>