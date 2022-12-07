package com.chzu.servlet;

import com.chzu.bean.Client;
import com.chzu.dao.impl.ClientDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Client_registerServlet", value = "/Client_registerServlet")
public class Client_registerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("client_username");
        String password = request.getParameter("client_password");
        String phoneNumber = request.getParameter("client_phoneNumber");
        String QQ = request.getParameter("client_QQ");

        Client client = new Client();
        ClientDaoImpl clientDao = new ClientDaoImpl();

        boolean b = clientDao.selectByUsername(username);
        System.out.println("bwai" + b);

        if (b) {
            request.getSession().setAttribute("msg", "用户名已存在");
            request.getRequestDispatcher("client_register.jsp").forward(request,response);
            System.out.println("用户名已存在");
            System.out.println(" bnei " + b);
        } else {

            client.setClient_username(username);
            client.setClient_password(password);
            client.setClient_phoneNumber(phoneNumber);
            client.setClient_QQ(QQ);

            boolean insert = clientDao.insert(client);

            if (insert) {
                request.getSession().setAttribute("msg", "注册成功!");
                request.getRequestDispatcher("index.jsp").forward(request,response);
            } else {
                System.out.println("插入失败");
                request.getSession().setAttribute("msg", "系统繁忙，请稍后再试!");
                request.getRequestDispatcher("client_register.jsp").forward(request,response);
            }
        }







    }
}
