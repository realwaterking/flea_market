package com.chzu.servlet;

import com.chzu.bean.Client;
import com.chzu.dao.impl.ClientDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Client_loginServlet", value = "/Client_loginServlet")
public class Client_loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String u = request.getParameter("client_username");
        String p = request.getParameter("client_password");

        ClientDaoImpl clientDao = new ClientDaoImpl();
        Client client = new Client();

        client.setClient_username(u);
        client.setClient_password(p);



        if (u.length() <= 0 || p.length() <= 0) {
            request.getSession().setAttribute("msg", "请输入用户名或密码!");
        }

        boolean checkout = clientDao.checkout(client);

        if (checkout) {
            request.getSession().setAttribute("client_username", client.getClient_username());
            request.getSession().setAttribute("client_password", client.getClient_password());
            request.getRequestDispatcher("client_marketProfile.jsp").forward(request,response);
        } else {
            request.getSession().setAttribute("msg", "用户名或密码错误!");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }
}
