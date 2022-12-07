package com.chzu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin_loginServlet")
public class Admin_loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            this.doPost(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("u");
        String password = request.getParameter("p");



        if (username.length() <= 0 || password.length() <= 0) {
            request.getSession().setAttribute("msg", "请输入用户名和密码!");
            request.getRequestDispatcher("admin_login.jsp").forward(request,response);
        } else {
            if ("admin".equals(username) && "admin".equals(password)) {
                request.getSession().setAttribute("admin_username", username);
                request.getSession().setAttribute("admin_password", password);
                request.getRequestDispatcher("admin_main.jsp").forward(request,response);
            } else {
                request.setAttribute("msg", "非管理员账户，请重新输入!");
                request.getRequestDispatcher("admin_login.jsp").forward(request,response);
            }
        }
    }
}
