package com.chzu.servlet;

import com.chzu.bean.Product;
import com.chzu.dao.impl.LiveProductDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/client_liveProductServlet")
public class Client_liveProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int cpage = 1;
        int count = 8;

        String cp = request.getParameter("cp");
        if (cp != null) {
            cpage = Integer.parseInt(cp);
        }

        LiveProductDaoImpl liveProductDao = new LiveProductDaoImpl();
        List<Product> productList = liveProductDao.selectAll(cpage, count);
        int arr[] = liveProductDao.totalpage(count);




        request.getSession().setAttribute("productlist", productList);
        request.getSession().setAttribute("tsum", arr[0]);
        request.getSession().setAttribute("tpage", arr[1]);
        request.getSession().setAttribute("cpage", cpage);

        request.getRequestDispatcher("client_liveProduct.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
