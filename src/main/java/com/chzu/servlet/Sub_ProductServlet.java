package com.chzu.servlet;

import com.chzu.bean.Client;
import com.chzu.bean.Product;
import com.chzu.dao.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sub_ProductServlet")
public class Sub_ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int count = 8;

        LiveProductDaoImpl liveProductDao = new LiveProductDaoImpl();
        ElecProductDaoImpl elecProductDao = new ElecProductDaoImpl();
        StudyProductDaoImpl studyProductDao = new StudyProductDaoImpl();
        OtherProductDaoImpl otherProductDao = new OtherProductDaoImpl();
        ClientDaoImpl clientDao = new ClientDaoImpl();

        String buy = request.getParameter("liveProduct_id");
        request.removeAttribute("liveProduct_id");

        String db = request.getParameter("db");

        if ("1".equals(db)) {
            Product product = liveProductDao.getById(Integer.parseInt(buy));
            if (product.getProduct_quantity() > 0) {
                product.setProduct_quantity(product.getProduct_quantity() - 1);
                boolean update = liveProductDao.update(product);
                liveProductDao.totalpage(count);
            }
        } else if ("2".equals(db)) {
            Product product = studyProductDao.getById(Integer.parseInt(buy));
            if (product.getProduct_quantity() > 0) {
                product.setProduct_quantity(product.getProduct_quantity() - 1);
                boolean update = studyProductDao.update(product);
                studyProductDao.totalpage(count);
            }
        } else if ("3".equals(db)) {
            Product product = elecProductDao.getById(Integer.parseInt(buy));
            if (product.getProduct_quantity() > 0) {
                product.setProduct_quantity(product.getProduct_quantity() - 1);
                boolean update = elecProductDao.update(product);
                elecProductDao.totalpage(count);
            }
        } else if ("4".equals(db)) {
            Product product = otherProductDao.getById(Integer.parseInt(buy));
            if (product.getProduct_quantity() > 0) {
                product.setProduct_quantity(product.getProduct_quantity() - 1);
                boolean update = otherProductDao.update(product);
                otherProductDao.totalpage(count);
            }
        } else if ("21".equals(db)) {
            Product product = liveProductDao.getById(Integer.parseInt(buy));
            product.setProduct_quantity(0);
            boolean update = liveProductDao.update(product);
            liveProductDao.totalpage(count);
        } else if ("22".equals(db)) {
            Product product = studyProductDao.getById(Integer.parseInt(buy));
            product.setProduct_quantity(0);
            boolean update = studyProductDao.update(product);
            studyProductDao.totalpage(count);
        } else if ("23".equals(db)) {
            Product product = elecProductDao.getById(Integer.parseInt(buy));
            product.setProduct_quantity(0);
            boolean update = elecProductDao.update(product);
            elecProductDao.totalpage(count);
        } else if ("24".equals(db)) {
            Product product = otherProductDao.getById(Integer.parseInt(buy));
            product.setProduct_quantity(0);
            boolean update = otherProductDao.update(product);
            otherProductDao.totalpage(count);
        } else if ("31".equals(db)) {
            boolean delete = liveProductDao.delete(Integer.parseInt(buy));
            liveProductDao.totalpage(count);
        } else if ("32".equals(db)) {
            boolean delete = studyProductDao.delete(Integer.parseInt(buy));
            studyProductDao.totalpage(count);
        } else if ("33".equals(db)) {
            boolean delete = elecProductDao.delete(Integer.parseInt(buy));
            elecProductDao.totalpage(count);
        } else if ("34".equals(db)) {
            boolean delete = otherProductDao.delete(Integer.parseInt(buy));
            otherProductDao.totalpage(count);
        } else if ("5".equals(db)) {
            Client client = clientDao.getById(Integer.parseInt(buy));
            boolean delete = clientDao.delete(client.getClient_id());
            clientDao.totalpage(count);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
