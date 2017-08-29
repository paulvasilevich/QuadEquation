package com.belhard.servlets;


import com.belhard.utils.Connector;
import com.belhard.utils.DatabaseUsers;
import com.belhard.utils.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/automoto.room")
public class AutoMotoServlet extends HttpServlet {

    private boolean loginStatus = false;
    private String user;



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

         String loginAttribute = (String) req.getAttribute("loginStatus");
        if (!loginAttribute.isEmpty() &&  loginAttribute.equals("true")) {
            loginStatus = true;
             user = (String) req.getAttribute("userName");

        }

        String message = req.getParameter("message");
        if (message != null && !message.isEmpty()) {
            Message newMessage = new Message(message);
            DatabaseUsers.messagesSport.put(user, newMessage);
        }


            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");
            PrintWriter out = resp.getWriter();

            out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            out.println("<title>Forum</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h1>Auto & Moto room our forum.</h1>");
            out.println("</center>");
            out.println("<h2 align = \"right\">You are logged as " + user + "</h2>");

            for (String s : DatabaseUsers.messagesAutoMoto.keySet()) {

            out.println("<p>" + s + ":&nbsp");
            out.println( DatabaseUsers.messagesAutoMoto.get(s).getMessage() + ":&nbsp</p>");
            out.println( "<br/>");
            if (DatabaseUsers.messagesAutoMoto.size() > 0) {
                out.println("<hr/>");
            }
        }

//            try {
//                Connector connector = new Connector();
//                Statement statementResponse = connector.getConnection().createStatement();
//                ResultSet resultSet = statementResponse.executeQuery("SELECT user , message, datatime " +
//                        "FROM Forum.automoto ORDER BY id");
//                while (resultSet.next()) {
//                    out.println("<p>" + resultSet.getString("user") + ":&nbsp");
//                    out.println( resultSet.getString("message") +
//                            resultSet.getString("datatime") + ":&nbsp</p>");
//                    out.println("<hr/>");
//                    out.println( "<br/>");
//
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }

            if (loginStatus) {
                out.println("<form action=\"/automoto.room\" method=\"post\">\n" +
                        "    <input type=\"text\" name=\"message\"  placeholder=\"Message...\"/>\n" +
                        "    <input type=\"submit\" name=\"submit_message\" value=\"Send\"/>\n" +
                        "</form>");
            }
            out.println("</body></html>");





    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

//        String loginAttribute = (String) req.getAttribute("loginStatus");
//        if (!loginAttribute.isEmpty() &&  loginAttribute.equals("true")) {
//            loginStatus = true;
//            user = (String) req.getAttribute("userName");
//
//        }

//        String message = req.getParameter("message");
//        if (message != null && !message.isEmpty()) {
//            Message newMessage = new Message(message);
//            DatabaseUsers.messagesAutomoto.put(user, newMessage);
//        }


        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
        out.println("<title>Forum</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<center>");
        out.println("<h1>Auto & Moto room our forum.</h1>");
        out.println("</center>");
        out.println("<h2 align = \"right\">You are logged as " + user + "</h2>");

        for (String s : DatabaseUsers.messagesAutoMoto.keySet()) {

            out.println("<p>" + s + ":&nbsp");
            out.println( DatabaseUsers.messagesAutoMoto.get(s).getMessage() + ":&nbsp</p>");
            out.println( "<br/>");
            if (DatabaseUsers.messagesAutoMoto.size() > 0) {
                out.println("<hr/>");
            }
        }

//            try {
//                Connector connector = new Connector();
//                Statement statementResponse = connector.getConnection().createStatement();
//                ResultSet resultSet = statementResponse.executeQuery("SELECT user , message, datatime " +
//                        "FROM Forum.automoto ORDER BY id");
//                while (resultSet.next()) {
//                    out.println("<p>" + resultSet.getString("user") + ":&nbsp");
//                    out.println( resultSet.getString("message") +
//                            resultSet.getString("datatime") + ":&nbsp</p>");
//                    out.println("<hr/>");
//                    out.println( "<br/>");
//
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }

        if (loginStatus) {
            out.println("<form action=\"/automoto.room\" method=\"post\">\n" +
                    "    <input type=\"text\" name=\"message\"  placeholder=\"Message...\"/>\n" +
                    "    <input type=\"submit\" name=\"submit_message\" value=\"Send\"/>\n" +
                    "</form>");
        }
        out.println("</body></html>");





    }





}
