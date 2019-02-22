package com.nhnent.edu.spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
// TODO : #3 war로 패키징 한 경우, SpringBootServletInitializer을 상속받아 애플리케이션을 시작해야 함.
// TODO : #3 when packaging is war, App class must be inherited from `SpringBootServletInitializer`. 
public class App extends SpringBootServletInitializer
{
    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(App.class);
    }

    @GetMapping("/hello")
    public String hello() {
    	return "hello";
    }
    
}
