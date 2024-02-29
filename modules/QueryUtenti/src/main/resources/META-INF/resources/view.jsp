<%@ include file="/init.jsp" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<portlet:defineObjects />

<!DOCTYPE html>
<html>
<head>
    <title>Elenco degli Alunni</title>
</head>
<body>
    <h1>Elenco degli Alunni</h1>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>Nome</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${alunni}">
                <tr>
                    <td>${user.getFullName()}</td>
                    <td>${user.getEmailAddress()}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
