package com.nhnent.edu.spring_boot.config;

import com.nhnent.edu.spring_boot.filter.Log1Filter;
import com.nhnent.edu.spring_boot.filter.Log2Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

// TODO : #6 Filter configuration.
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<Log1Filter> log1FilterRegistrationBean() {
        FilterRegistrationBean<Log1Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new Log1Filter());
        filterRegistrationBean.setUrlPatterns(Collections.singletonList("/*"));
        filterRegistrationBean.setOrder(1000);

        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<Log2Filter> log2FilterRegistrationBean() {
        FilterRegistrationBean<Log2Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new Log2Filter());
        filterRegistrationBean.setUrlPatterns(Collections.singletonList("/*"));
        filterRegistrationBean.setOrder(1000);

        return filterRegistrationBean;
    }

}
