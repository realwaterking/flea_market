package com.chzu.servlet;

import com.chzu.bean.Product;
import com.chzu.dao.impl.StudyProductDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin_studyProductServlet")
public class Admin_studyProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cpage = 1;
        int count = 8;

        String cp = request.getParameter("cp");
        if (cp != null) {
            cpage = Integer.parseInt(cp);
        }

        StudyProductDaoImpl studyProductDao = new StudyProductDaoImpl();
        List<Product> productList = studyProductDao.selectAll(cpage, count);
        int arr[] = studyProductDao.totalpage(count);


        request.getSession().setAttribute("productlist", productList);
        request.getSession().setAttribute("tsum", arr[0]);
        request.getSession().setAttribute("tpage", arr[1]);
        request.getSession().setAttribute("cpage", cpage);

        request.getRequestDispatcher("admin_studyProduct.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
