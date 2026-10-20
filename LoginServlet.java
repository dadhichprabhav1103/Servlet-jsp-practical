package com.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("student".equals(username) && "1234".equals(password)) {

            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            response.sendRedirect("home");
        } else {
            response.setContentType("text/html");
            response.getWriter().println("<h2>Invalid Username or Password</h2>");
        }
    }
}