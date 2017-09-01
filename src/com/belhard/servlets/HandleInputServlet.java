package com.belhard.servlets;

import com.belhard.utils.Connector;
import com.belhard.utils.DatabaseUsers;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/handleServlet.do")
public class HandleInputServlet extends HttpServlet{

    private static final String LOGIN = "txt_user_login";

    private static final String PASSWORD = "txt_user_password";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Cookie[] cookies = req.getCookies();
        String login;
        String password;
        String name;

        if (cookies != null) {
            login = getLoginCookies(cookies);
            password = getPasswordCookies(cookies);
            name = getNameCookies(cookies);
            if (checkUser(login, password) != null) {
                ordinaryEnter(name, req, resp);
            } else {
                failEnter(req, resp);
            }

        } else {
             login = req.getParameter(LOGIN);
             password = req.getParameter(PASSWORD);
             name = checkUser(login, password);
            if (name != null) {
                firstEnter(name, login, password, req, resp);
            } else {
                failEnter(req, resp);
            }
        }
    }

    private String getLoginCookies(Cookie[] cookies) {
        for (Cookie cook :
                cookies) {
            String cookString = cook.getName();
            if (cookString.equals("login")) {
                return cook.getValue();
            }
        }
        return null;
    }

    private String getPasswordCookies(Cookie[] cookies) {
        for (Cookie cook :
                cookies) {
            String cookString = cook.getName();
            if (cookString.equals("password")) {
                return cook.getValue();

            }
        }
        return null;
    }

    private String getNameCookies(Cookie[] cookies) {
        for (Cookie cook :
                cookies) {
            String cookString = cook.getName();
            if (cookString.equals("name")) {
                return cook.getValue();

            }
        }
        return null;
    }

    private void ordinaryEnter(String name, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("userName", name);
        req.setAttribute("loginStatus", "true");
        req.getRequestDispatcher("/afterLoginSuccess.jsp").forward(req, resp);

    }

    private void firstEnter(String name, String login, String password, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie loginCookie = new Cookie("login", login);
        Cookie passCookie = new Cookie("password", password);
        Cookie nameCookie = new Cookie("name", name);
        resp.addCookie(loginCookie);
        resp.addCookie(passCookie);
        resp.addCookie(nameCookie);
        req.setAttribute("loginStatus", "true");

        req.getRequestDispatcher("/afterLoginSuccess.jsp").forward(req, resp);
    }

    private void failEnter(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/afterLoginFail.jsp").forward(req, resp);
    }

    private String checkUser(String login, String password) {
        String name = "anon";
        try {
            Connector connector = new Connector();
            PreparedStatement statementResponse =connector.getConnection().prepareStatement(
                    "SELECT `name` FROM Forum.users WHERE login = ? AND password = ?");
            statementResponse.setString(1,login);
            statementResponse.setString(2,password);
            ResultSet resultSet = statementResponse.executeQuery();
            while (resultSet.next()) {
                name =  resultSet.getString("name");
                break;
            }
    } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }
}
