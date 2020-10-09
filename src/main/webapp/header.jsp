<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aron
  Date: 22/09/2020
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <h1>
        <span>XXX</span>
    </h1>
<nav>
    <ul>

        <li><a href="Controller?command=IndexHandler">Home</a></li>
        <li><a href="Controller?command=OverviewHandler">Overview</a></li>
        <li><a href="Controller?command=RegisterHandler">Register</a></li>
        <c:if test="${user != null}">
        <li><a href="Controller?command=StatusHandler">Status</a></li>
        </c:if>
    </ul>
</nav>
<h2>${param.page}</h2>

</header>