<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="utente.caption"/></b>
</p>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects />

<!DOCTYPE html>
<html>
<head>
    <title>Utenti e Ruoli</title>
</head>
<body>
    <h1>Elenco degli Utenti e dei loro Ruoli</h1>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>Nome Utente</th>
                <th>Email</th>
                <th>Ruoli</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="entry" items="${userRolesMap}">
                <tr>
                    <td>${entry.key.getFullName()}</td>
                    <td>${entry.key.getEmailAddress()}</td>
                    <td>
                        <ul>
                            <c:forEach var="role" items="${entry.value}">
                                <li>${role.getName()}</li>
                            </c:forEach>
                        </ul>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
