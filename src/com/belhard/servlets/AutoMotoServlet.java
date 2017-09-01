package com.belhard.servlets;


import com.belhard.utils.Connector;
import com.belhard.utils.DatabaseUsers;
import com.belhard.utils.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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


    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            loginStatus = getStatusCookies(cookies);
            if (loginStatus) {
                user = (String) req.getAttribute("name");
            }
        }

        Enum room = SuperServlet.roomlist.AUTOMOTO;
        req.setAttribute("roomEnum", room);
        String roomName = room.toString().toLowerCase();
        req.setAttribute("roomname", roomName);
        req.getServletContext().getRequestDispatcher("/room.jsp").forward(req,resp);
//        SuperServlet.getData(out, room,req, resp);
    }

    private boolean getStatusCookies(Cookie[] cookies) {
        for (Cookie cook :
                cookies) {
            String cookString = cook.getName();
            if (cookString.equals("loginStatus")) {
                 return cook.getValue().equals("true");

            }
        }
        return false;
    }
}
