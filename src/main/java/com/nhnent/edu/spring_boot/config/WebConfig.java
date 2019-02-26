package com.nhnent.edu.spring_boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// TODO : #7 @EnableWebMvc is set by default.
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // TODO : #14 access http://localhost:8080 by browser.
        registry.addViewController("/").setViewName("index");
        registry.addRedirectViewController("/redirect-index", "/");
    }


    @Bean
    @ConditionalOnMissingBean(ClassPathTldsLoader.class)
    public ClassPathTldsLoader classPathTldsLoader(){
        return new ClassPathTldsLoader();
    }

    public static class ClassPathTldsLoader  {
        private static final String SECURITY_TLD = "/META-INF/security.tld";

        private final List<String> classPathTlds;


        public ClassPathTldsLoader(String... classPathTlds) {
            if(classPathTlds.length == 0) {
                this.classPathTlds = Collections.singletonList(SECURITY_TLD);
            } else {
                this.classPathTlds = Arrays.asList(classPathTlds);
            }
        }

        @Autowired
        private FreeMarkerConfigurer freeMarkerConfigurer;

        @PostConstruct
        public void loadClassPathTlds() {
            freeMarkerConfigurer.getTaglibFactory().setClasspathTlds(classPathTlds);
        }
    }

}
