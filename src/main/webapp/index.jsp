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
        <jsp:param name="page" value="home"/>
    </jsp:include>


    <main><c:if test="${loginError != null}">
        <div class="alert-danger">
            <ul>
                <li>${loginError}</li>
            </ul>
        </div>
    </c:if>
        <c:if test="${user == null}">
            <form action="Controller?command=LoginHandler" method="post">
                <p><label for="userid">User id</label><input type="text" id="userid" name="userid"
                                                             required value=""></p>
                <p><label for="password">Password</label><input type="password" id="password" name="password"
                                                                required value=""></p>
                <p><input type="submit" id="login" value="Login"></p>
            </form>
        </c:if>
        <c:if test="${user != null}">
            <p>welcome ${user.firstName}</p>
            <a href="Controller?command=LogoutHandler">logout</a>
        </c:if>
    </main>
    <footer> &copy; Webontwikkeling 3, UC Leuven-Limburg</footer>
</div>
</body>
</html>