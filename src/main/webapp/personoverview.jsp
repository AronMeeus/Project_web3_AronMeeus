<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="UTF-8">
    <title>Overview</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <jsp:include page="header.jsp">
        <jsp:param name="page" value="overview"/>
    </jsp:include>
    <main>
        <c:if test="${personen != null}">
            <table>
                <tr>
                    <th>E-mail</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Status</th>
                </tr>
                <c:forEach var="persoon" items="${personen}">
                    <tr>
                        <td>${persoon.email}</td>
                        <td>${persoon.firstName}</td>
                        <td>${persoon.lastName}</td>
                        <c:choose>
                            <c:when test="${persoon.sick}">
                                <td>sick</td>
                            </c:when>
                            <c:otherwise>
                                <td>healthy</td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </c:forEach>

                <caption>Users Overview</caption>
            </table>
        </c:if>
    </main>
    <footer>
        &copy; Webontwikkeling 3, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>