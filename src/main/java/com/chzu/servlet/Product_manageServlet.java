package com.chzu.servlet;

import com.chzu.bean.Product;
import com.chzu.dao.impl.LiveProductDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Product_manageServlet", value = "/Product_manageServlet")
public class Product_manageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //product对象的五个属性的获取
        String product_id = request.getParameter("product_id");
        String product_name = request.getParameter("product_name");
        String product_price = request.getParameter("product_price");
        String product_description = request.getParameter("product_description");
        String product_quantity = request.getParameter("product_quantity");

        //操作数的获取
        String operate = request.getParameter("operate");

        //数据层的实例化
        Product product = new Product(Integer.parseInt(product_id), product_name, product_price, product_description
                , Integer.parseInt(product_quantity));
        LiveProductDaoImpl liveProductDao = new LiveProductDaoImpl();

        //初始页面数和每页展示数
        int cpage =1;
        int count =8;


        /**
         * 0 对应的是添加商品的功能
         * 1 对应的是更新商品信息的功能
         * 2 对应的是获取所有商品信息的功能
         * 3 对应的是根据id删除指定商品的功能
         * 4 对应的是根据id获取指定商品新的的功能
         */
        if ("0".equals(operate)) {
            if ("".equals(product_name) && "".equals(product_price)) {
                liveProductDao.insert(product);
            }
        } else if ("1".equals(operate)) {
            liveProductDao.update(product);
        } else if ("2".equals(operate)) {
            liveProductDao.selectAll(cpage,count);
        } else if ("3".equals(operate)) {
            liveProductDao.delete(Integer.parseInt(product_id));
        } else if ("4".equals(operate)) {
            liveProductDao.getById(Integer.parseInt(product_id));
        } else {
            request.setAttribute("msg","系统繁忙! 请稍后再试");
        }



        //右下角分页功能
        String cp =request.getParameter("cp");

        if (cp != null) {
            cpage = Integer.parseInt(cp);
        }

        List<Product> list = liveProductDao.selectAll(cpage,count);

        int arr[]= liveProductDao.totalpage(count);

        request.setAttribute("userlist",list);
        request.setAttribute("tsum", arr[0]);
        request.setAttribute("tpage", arr[1]);
        request.setAttribute("cpage", cpage);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
