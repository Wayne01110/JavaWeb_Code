package com.Wayne.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //1. 放行前，对 request数据进行处理
        System.out.println("1. FilterDemo...");

        // 放行
        filterChain.doFilter(servletRequest, servletResponse);

        //2. 放行后，对Response 数据进行处理
        System.out.println("5.FilterDemo...");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
