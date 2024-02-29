
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<portlet:defineObjects />

<portlet:actionURL var="deleteLastExamURL">
    <portlet:param name="action" value="deleteLastExam" />
</portlet:actionURL>

<!DOCTYPE html>
<html>
<head>
    <title>Elenco Esami</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2>Elenco Esami</h2>
    <table>
        <thead>
            <tr>
                <th>ID Esame</th>
                <th>Nome Esame</th>
                <th>Data Esame</th>

            </tr>
        </thead>
        <tbody>
            <c:forEach var="esame" items="${esamiList}">
                <tr>
                    <td>${esame.getEsameId()}</td>
                    <td>${esame.getNomeEsame()}</td>
                    <td>${esame.getDataEsame()}</td>

                </tr>
            </c:forEach>

        </tbody>

    </table>
</body>
</html>


