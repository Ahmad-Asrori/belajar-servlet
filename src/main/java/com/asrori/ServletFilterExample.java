package com.asrori;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

public class ServletFilterExample implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // init parameter
        String testParam = filterConfig.getInitParameter("test-param");

        //Print init parameter
        System.out.println("Test Param: " + testParam);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            // Get IP address dari client
            String ipAddress = servletRequest.getRemoteAddr();

            // Log IP address and waktu yang sekarang.
            System.out.println("IP "+ ipAddress + ", Time " + new Date().toString());

            // Pass request back down the filter chain
            filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
