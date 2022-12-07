package com.chzu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter({"/client_elecProduct.jsp", "/client_liveProduct.jsp", "/client_marketProfile.jsp", "/client_myProduct.jsp", "/client_myProfile.jsp", "/client_otherProduct.jsp", "/client_studyProduct.jsp"})
public class Client_loginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        Object username = req.getSession().getAttribute("client_username");
        Object password = req.getSession().getAttribute("client_password");

        if (username != null && password != null) {
            chain.doFilter(request,response);
        } else {
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }
}
