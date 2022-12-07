package com.chzu.servlet;

import com.chzu.bean.Client;
import com.chzu.dao.impl.ClientDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin_clientServlet")
public class Admin_clientServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cpage = 1;
        int count = 8;

        String cp = request.getParameter("cp");
        if (cp != null) {
            cpage = Integer.parseInt(cp);
        }

        ClientDaoImpl clientDao = new ClientDaoImpl();
        List<Client> clientList = clientDao.selectAll(cpage, count);
        int arr[] = clientDao.totalpage(count);


        request.getSession().setAttribute("clientlist", clientList);
        request.getSession().setAttribute("tsum", arr[0]);
        request.getSession().setAttribute("tpage", arr[1]);
        request.getSession().setAttribute("cpage", cpage);

        request.getRequestDispatcher("admin_client.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
