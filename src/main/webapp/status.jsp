<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">

    <jsp:include page="header.jsp">
        <jsp:param name="page" value="status"/>
    </jsp:include>
    <c:if test="${loginError != null}">
        <div class="alert-danger">
            <ul>
                <li>${loginError}</li>
            </ul>
        </div>
    </c:if>


    <main>
        <c:if test="${user == null}">
            <p>je bent niet ingelogd dus je kan je status niet veranderen</p>

        </c:if>
        <c:if test="${user != null}">
            <p>welkom ${user.firstName}</p>

            <c:if test="${user.sick}">
                <p>je bent momenteel ziek</p>
            </c:if>
            <c:if test="${!user.sick}">
                <p>je bent momenteel gezond</p>
            </c:if>

            <p>druk op de knop om je status te veranderen</p>
            <a href="Controller?command=ChangeStatusHandler&userid=${user.userid}">Verander status</a>
        </c:if>
    </main>
    <footer> &copy; Webontwikkeling 3, UC Leuven-Limburg</footer>
</div>
</body>
</html>