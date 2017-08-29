package com.belhard.servlets;

import com.belhard.utils.DatabaseUsers;
import com.belhard.utils.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registration.do")
public class MyRegistrationServlet extends HttpServlet {

    private static final String LOGIN_PARAM ="txt_user_login";
    private static final String PASSWORD_PARAM ="txt_user_password";
    private static final String FULLNAME_PARAM ="txt_user_fullName";
    private static final String BIRTHDATE_PARAM ="txt_user_birthDate";

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String login = req.getParameter(LOGIN_PARAM);
        String password = req.getParameter(PASSWORD_PARAM);
        String fullName = req.getParameter(FULLNAME_PARAM);
        String birthDate = req.getParameter(BIRTHDATE_PARAM);

        User user = new User(password, fullName, birthDate);
        DatabaseUsers.usersMap.put(login, user);


        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter outputPage = resp.getWriter();

        outputPage.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
        outputPage.println("<html>");
        outputPage.println("<head>");
        outputPage.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
        outputPage.println("<title>Hello Page</title>");
        outputPage.println("</head>");
        outputPage.println("<body>");
        outputPage.println("<center>");
        outputPage.println("<h1>Hello Page</h1>");
        outputPage.println("</center>");
        outputPage.println("<h1>User, " + login + " " + " are register now! Congratulations!" + "</h1>");
        outputPage.println("<a href=\"" + req.getServletContext().getContextPath() + "/index.html\">Go To Index Page</a>");

    }

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
