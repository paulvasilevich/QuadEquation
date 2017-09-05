<%@ page import="com.belhard.servlets.SuperServlet" %><%--
  Created by IntelliJ IDEA.
  User: white
  Date: 30.08.17
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${roomname}</title>
    <style>
        body{
            background-color: #74839d


        }

        h1{

            color: #d6e294;
            padding-top: 1cm;
        }

        input{

            border:2px solid #e296b6 ;

            height: 10px ;
            border-radius:25px;


            padding:10px 5px 15px 20px

        ;
            width: 125px;
            margin-left: 5px;
            /*background-color: #e296b6*/

        }

        .rows{
            color: #d6e294;
            margin-left: 20px;
            border: solid;
            border-collapse: collapse;
        }
        .users {
            font-family: TakaoPGothic;
            font-style: italic;
            font-size: large;
            color: chartreuse;
        }

    </style>
</head>
<body>

<div class="divElements">
    <table>
        <%
            Enum room = (Enum) request.getAttribute("roomEnum");
            SuperServlet.getData(out, room, request, response);
        %>
    </table>
</div>

<%
    Cookie[] cookies = request.getCookies();
    for (Cookie c :
            cookies) {
        if (c.getName().equals("loginStatus") && c.getValue().equals("true")) {
            out.println("<form action=\"${roomname}.room\" method=\"post\">\n" +
                    "    <input type=\"text\" name=\"message\"  placeholder=\"Message...\"/>\n" +
                    "    <input type=\"submit\" name=\"submit_message\" value=\"Send\"/>\n" +
                    "</form>");
        }
    }

%>
<%--<form action="${roomname}.room" method="post">--%>
    <%--<input type="text" name="message"  placeholder="Message..."/>--%>
    <%--<input type="submit" name="submit_message" value="Send"/>--%>
<%--</form>--%>

</body>
</html>
