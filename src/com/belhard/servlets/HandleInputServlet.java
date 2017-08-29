package com.belhard.servlets;

import com.belhard.utils.DatabaseUsers;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/handleServlet.do")
public class HandleInputServlet extends HttpServlet{

    private static final String FIRST_NAME_PARAM = "txt_user_login";

    private static final String LAST_NAME_PARAM = "txt_user_password";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String login = req.getParameter(FIRST_NAME_PARAM);

        String password = req.getParameter(LAST_NAME_PARAM);

        if (DatabaseUsers.usersMap.containsKey(login) && DatabaseUsers.usersMap.get(login).getPassword().equals(password)) {

            req.setAttribute("userName", login);
            req.setAttribute("loginStatus", "true");
//            req.getRequestDispatcher("/automoto.room").forward(req, resp);
//            req.getRequestDispatcher("/finance.room").forward(req, resp);
            req.getRequestDispatcher("login.html").forward(req, resp);


            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");

            PrintWriter output = resp.getWriter();

            output.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
            output.println("<html>");
            output.println("<head>");
            output.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            output.println("<title>Hello Page</title>");
            output.println("</head>");
            output.println("<body>");
            output.println("<center>");
            output.println("<h1>Hello Page</h1>");
            output.println("</center>");
            output.println("<h1>You entered as, " + login + " ! " + "</h1>");
            output.println("<h2 align=\"center\"> <a href=\"/automoto.room\" > Auto & Moto room.</a> | <a href=\"/finance.room\">Finance room.</a> | <a href=\"/sport.room\">Sport's room.</a></h2>");
//            output.println("<h3> User name: " + DatabaseUsers.usersMap.get(login).getFullName() + "</h3>");
//            output.println("<h3> User birthdate: " + DatabaseUsers.usersMap.get(login).getDate() + "</h3>");
            output.println("<a href=\"" + req.getServletContext().getContextPath() + "/index.html\">Go To Index Page</a>");
        } else {
            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");

            PrintWriter output = resp.getWriter();

            output.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
            output.println("<html>");
            output.println("<head>");
            output.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            output.println("<title>Hello Page</title>");
            output.println("</head>");
            output.println("<body>");
            output.println("<center>");
            output.println("<h1>Hello Page</h1>");
            output.println("</center>");
            output.println("<h1>Wrong login or password!</h1>");
            output.println("<a href=\"" + req.getServletContext().getContextPath() + "/index.html\">Go To Index Page</a>");

        }
    }


}
