package com.belhard.servlets;

import com.belhard.utils.DatabaseUsers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoggedServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }


        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("UTF-8");

            Object login =  req.getAttribute("userName");
            Object loginStatus = req.getAttribute("loginStatus");

                req.setAttribute("userName", login);
                req.setAttribute("loginStatus", loginStatus);
//            req.getRequestDispatcher("/automoto.room").forward(req, resp);
//            req.getRequestDispatcher("/finance.room").forward(req, resp);
                req.getRequestDispatcher("login.html").forward(req, resp);


                resp.setContentType("text/html");
                resp.setCharacterEncoding("UTF-8");

                PrintWriter output = resp.getWriter();


    }
}
