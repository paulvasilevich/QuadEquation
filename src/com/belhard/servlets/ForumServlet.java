package com.belhard.servlets;


import com.belhard.utils.DatabaseUsers;
import com.belhard.utils.Main;
import com.belhard.utils.Message;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/forum")
public class ForumServlet extends HttpServlet{




    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

         String user= req.getParameter("user");
         String message = req.getParameter("message");

        if (user == null) {
            user = "Anon";
        }
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
        out.println("<h1>Forum</h1>");
        out.println("</center>");

        for (String s : DatabaseUsers.messagesSport.keySet()) {

            out.println("<p>" + s + ":&nbsp");
            out.println( DatabaseUsers.messagesSport.get(s).getMessage() + ":&nbsp</p>");
            out.println( "<br/>");
            if (DatabaseUsers.messagesSport.size() > 0) {
                out.println("<hr/>");
            }
        }

        out.println("<form action=\"/forum\" method=\"post\">\n" +
                "    <input type=\"text\" name=\"user\"  placeholder=\"User\"/>\n" +
                "    <input type=\"text\" name=\"message\"  placeholder=\"Message...\"/>\n" +
                "    <input type=\"submit\" name=\"submit_message\" value=\"Send\"/>\n" +
                "</form>");
        out.println("</body></html>");



    }

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//
//
//    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
