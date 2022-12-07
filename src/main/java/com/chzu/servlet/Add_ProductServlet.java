package com.chzu.servlet;

import com.chzu.bean.Product;
import com.chzu.dao.impl.ElecProductDaoImpl;
import com.chzu.dao.impl.LiveProductDaoImpl;
import com.chzu.dao.impl.OtherProductDaoImpl;
import com.chzu.dao.impl.StudyProductDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Add_ProductServlet")
public class Add_ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        String product_name = request.getParameter("product_name");
        String product_price = request.getParameter("product_price");
        String product_description = request.getParameter("product_description");
        String product_quantity = request.getParameter("product_quantity");

        Product product = new Product();

        product.setProduct_name(product_name);
        product.setProduct_price(product_price);
        product.setProduct_description(product_description);
        product.setProduct_quantity(Integer.parseInt(product_quantity));

        if ("0".equals(type)) {
            LiveProductDaoImpl liveProductDao = new LiveProductDaoImpl();
            liveProductDao.insert(product);
        } else if ("1".equals(type)) {
            StudyProductDaoImpl studyProductDao = new StudyProductDaoImpl();
            studyProductDao.insert(product);

        } else if ("2".equals(type)) {
            ElecProductDaoImpl elecProductDao = new ElecProductDaoImpl();
            elecProductDao.insert(product);
        } else {
            OtherProductDaoImpl otherProductDao = new OtherProductDaoImpl();
            otherProductDao.insert(product);
        }
        request.getRequestDispatcher("client_myProduct.jsp").forward(request,response);
    }
}
