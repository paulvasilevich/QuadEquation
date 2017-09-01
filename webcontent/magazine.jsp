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
            <form action="/shop" method="post">
                <input type="submit" value="x">
                <input name="product" value="${entry.key.name}" style="display: none">
                <input  name = "x" value="false" style="display: none">
            </form>
        </c:if>
     ${entry.key.name} ${entry.key.price}

    <c:if test="${entry.value}">
        <form action="/shop" method="post">
            <input type="submit"  value="buy">
            <input name="product" value="${entry.key.name}" style="display: none">
            <input  name = "buy" value="true" style="display: none">
        </form>
        <hr>
        <br>
    </c:if>
    </c:forEach>


</div>



</body>
</html>
