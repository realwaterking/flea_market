package com.chzu.servlet;

import com.chzu.bean.Product;
import com.chzu.dao.impl.ElecProductDaoImpl;
import com.chzu.dao.impl.LiveProductDaoImpl;
import com.chzu.dao.impl.OtherProductDaoImpl;
import com.chzu.dao.impl.StudyProductDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/search_quantityServlet")
public class Search_quantityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product_id = request.getParameter("product_id");
        String table = request.getParameter("table");

        ElecProductDaoImpl elecProductDao = new ElecProductDaoImpl();
        LiveProductDaoImpl liveProductDao = new LiveProductDaoImpl();
        OtherProductDaoImpl otherProductDao = new OtherProductDaoImpl();
        StudyProductDaoImpl studyProductDao = new StudyProductDaoImpl();

        int point = 0;

        if ("1".equals(table)) {
            Product product = liveProductDao.getById(Integer.parseInt(product_id));
            point = product.getProduct_quantity();
        } else if ("2".equals(table)) {
            Product product = studyProductDao.getById(Integer.parseInt(product_id));
            point = product.getProduct_quantity();
        } else if ("3".equals(table)) {
            Product product = elecProductDao.getById(Integer.parseInt(product_id));
            point = product.getProduct_quantity();
        } else if ("4".equals(table)) {
            Product product = otherProductDao.getById(Integer.parseInt(product_id));
            point = product.getProduct_quantity();
        }

        response.getWriter().append(String.valueOf(point));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
