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
        <li id="actual"><a href="Controller">Home</a></li>
        <li><a href="Controller?command=OverviewHandler">Overview</a></li>
        <li><a href="Controller?command=RegisterHandler">Register</a></li>
    </ul>
</nav>
<h2>${param.page}</h2>

</header>