package com.belhard.servlets;

import com.belhard.utils.Connector;
import com.belhard.utils.DatabaseUsers;

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

@WebServlet("/sport.room")
public class SportServlet extends HttpServlet {

    private boolean loginStatus = false;
    private String user;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enum room = SuperServlet.roomlist.SPORT;
        req.setAttribute("roomEnum", room);
        String roomName = room.toString().toLowerCase();
        req.setAttribute("roomname", roomName);
        req.getServletContext().getRequestDispatcher("/room.jsp").forward(req,resp);
    }
}

