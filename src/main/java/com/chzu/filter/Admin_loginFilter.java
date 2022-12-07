package com.chzu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter({"/admin_client.jsp", "/admin_elecProduct.jsp", "/admin_liveProduct.jsp", "/admin_main.jsp", "/admin_otherProduct.jsp", "/admin_studyProduct.jsp"})
public class Admin_loginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        Object username = req.getSession().getAttribute("admin_username");
        Object password = req.getSession().getAttribute("admin_password");

        if (username != null && password != null) {
            chain.doFilter(request,response);
        } else {
            req.getRequestDispatcher("admin_login.jsp").forward(req,resp);
        }
    }
}
