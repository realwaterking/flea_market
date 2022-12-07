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

@WebServlet("/Client_manageServlet")
public class Client_manageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //client对象的六个属性的获取。
        String client_id = request.getParameter("client_id");
        String client_username = request.getParameter("client_username");
        String client_password = request.getParameter("client_password");

        //操作数的获取
        String operate = request.getParameter("operate");

        //页面数和每页展示条数值
        int cpage = 1;
        int count = 8;

        //创建数据层的实例
        Client client = new Client();
        ClientDaoImpl clientDao = new ClientDaoImpl();

        /**
         * 0 对应的是添加用户的功能
         * 1 对应的是更新用户信息的功能
         * 2 对应的是获取所有用户信息的功能
         * 3 对应的是根据id删除指定用户的功能
         * 4 对应的是根据id获取指定用户的功能
         */
        if ("0".equals(operate)) {
            if ("".equals(client_username) && "".equals(client_password)) {
                clientDao.insert(client);
            }
        } else if ("1".equals(operate)) {
            clientDao.update(client);
        } else if ("2".equals(operate)) {
            clientDao.selectAll(cpage,count);
        } else if ("3".equals(operate)) {
            clientDao.delete(Integer.parseInt(client_id));
        } else if ("4".equals(operate)) {
            clientDao.getById(Integer.parseInt(client_id));
        } else {
            request.setAttribute("msg","系统繁忙! 请稍后再试");
        }


        //右下角的分页功能
        String cp =request.getParameter("cp");

        if (cp != null) {
            cpage = Integer.parseInt(cp);
        }

        List<Client> list = clientDao.selectAll(cpage,count);

        int arr[]=clientDao.totalpage(count);

        request.setAttribute("userlist",list);
        request.setAttribute("tsum", arr[0]);
        request.setAttribute("tpage", arr[1]);
        request.setAttribute("cpage", cpage);

    }
}
