package com.example.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/users/*")
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String user = servletRequest.getParameter("user");
        if (user == null || user.isEmpty()) {
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
        }
    }
}