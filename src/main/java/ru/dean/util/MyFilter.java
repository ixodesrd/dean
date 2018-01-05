package ru.dean.util;

import javax.servlet.*;
import java.io.IOException;
public class MyFilter implements Filter {
    public void init(FilterConfig arg0) throws ServletException {}
    public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException{
        response.setContentType("text/html;charset=UTF-8");
        chain.doFilter(request, response);
    }
    public void destroy() {}
}
