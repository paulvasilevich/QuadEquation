<%--
  Created by IntelliJ IDEA.
  User: white
  Date: 01.09.17
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Magazine</title>
</head>
<body>

<div>
    <hr>
    <h1>Super Title fo r this page</h1>
    <c:forEach items="${spisok}" var="entry">
        <c:if test="${not entry.value}">
    x
        </c:if>
    ${entry.key.name} ${entry.key.price}
        <br>
    <c:if test="${entry.value}">
        buy
    </c:if>
    </c:forEach>

<hr>
</div>


</body>
</html>
