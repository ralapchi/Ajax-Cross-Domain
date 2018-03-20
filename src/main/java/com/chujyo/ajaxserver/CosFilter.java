package com.chujyo.ajaxserver;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by qidd on 2018-3-20
 */
public class CosFilter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String origin = httpServletRequest.getHeader("Origin");
        if (!org.springframework.util.StringUtils.isEmpty(origin)) {
            response.addHeader("Access-Control-Allow-Origin", origin);
        }


        //带cookie时，origin只能用全域匹配，不能用*

        response.addHeader("Access-Control-Allow-Methods", "*");

        String headers = httpServletRequest.getHeader("Access-Control-Request-Headers");
        if (!org.springframework.util.StringUtils.isEmpty(headers)) {
            response.addHeader("Access-Control-Allow-Headers", headers);
        }

        response.addHeader("Access-Control-Max-Age", "3600");
        response.addHeader("Access-Control-Allow-Credentials", "true");
        filterChain.doFilter(servletRequest, response);
    }

    @Override
    public void destroy() {

    }
}
