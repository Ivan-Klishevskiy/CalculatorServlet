<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kliis
  Date: 06.11.2021
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin delete</title>
</head>
<body>
<a href="/">Main page</a><br><br>
<h1>history by user id</h1>
<form action="/admin-history" method="post">
    <input type="number" name="id" placeholder="Enter id">
    <button>Submit</button>
</form>
    <ul>
        <c:forEach var="users" items="${requestScope.allUsers}">
            <li><c:out value="${users}"/></li>
        </c:forEach>
    </ul
</body>
</html>