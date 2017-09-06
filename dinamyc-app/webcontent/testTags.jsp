<%--
  Created by IntelliJ IDEA.
  User: white
  Date: 05.09.17
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ownTag" uri="WEB-INF/tags/implicit.tld" %>
<html>
<head>
    <title>own tags testing</title>
</head>
<body>
<ownTag:dtFmt format="MM-dd-yyyy"/>
<p>format yes</p>
<ownTag:dtFmt format="" />
<p>format no</p>
<c:url value="index.html" var="newUrl" />
<a href='<c:out value="${ newUrl }"/>'>go</a>

<ownTag:repeat countInt="5"> Text on repeat! </ownTag:repeat>
<ownTag:bodyRgstr register="up"> Text to upper case. </ownTag:bodyRgstr>
<ownTag:bodyRgstr register="low" > Text to LOWER CASE.  </ownTag:bodyRgstr>
<ownTag:bodyRgstr register=""> Text With default CASE.  </ownTag:bodyRgstr>
<%--<ownTag:error message="${code}" color="red"> This is new Errrorres!</ownTag:error>--%>
</body>
</html>
