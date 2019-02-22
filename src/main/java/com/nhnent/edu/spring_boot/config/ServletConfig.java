package com.nhnent.edu.spring_boot.config;

import com.nhnent.edu.spring_boot.servlet.Log1Servlet;
import com.nhnent.edu.spring_boot.servlet.Log2Servlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class ServletConfig {
    @Bean
    public ServletRegistrationBean<Log1Servlet> log1ServletRegistrationBean() {
        ServletRegistrationBean<Log1Servlet> servletRegistrationBean = new ServletRegistrationBean<>();
        servletRegistrationBean.setServlet(new Log1Servlet());
        servletRegistrationBean.setUrlMappings(Collections.singletonList("/log1"));

        return servletRegistrationBean;
    }

    @Bean
    public ServletRegistrationBean<Log2Servlet> log2ServletRegistrationBean() {
        ServletRegistrationBean<Log2Servlet> servletRegistrationBean = new ServletRegistrationBean<>();
        servletRegistrationBean.setServlet(new Log2Servlet());
        servletRegistrationBean.setUrlMappings(Collections.singletonList("/log2"));

        return servletRegistrationBean;
    }

}
