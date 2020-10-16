package com.example.weekopk.filter;

import com.example.weekopk.model.User;
import com.example.weekopk.service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpReq = (HttpServletRequest) request;

        System.out.println("doFilter");


        if(httpReq.getUserPrincipal() != null && httpReq.getSession().getAttribute("user") == null) {
            saveUserInSession(httpReq);
        }
        chain.doFilter(request, resp);
    }

    private void saveUserInSession(HttpServletRequest request) {
        UserService userService = new UserService();
        String username = request.getUserPrincipal().getName();
        User userByUsername = userService.getUserByUsername(username);
        request.getSession(true).setAttribute("user", userByUsername);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
