package com.nhnent.edu.spring_boot.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

// TODO : #4 Filter 예제 1.
public class Log1Filter extends GenericFilterBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(Log1Filter.class);


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOGGER.info("Log1Filter!!!");
        chain.doFilter(request, response);
    }

}
