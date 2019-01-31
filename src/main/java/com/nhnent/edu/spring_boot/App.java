package com.nhnent.edu.spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO : #6 com.nhnent.edu.spring_boot 패키지에 App.java 생성 및 작성.
@RestController
@EnableAutoConfiguration
public class App 
{
    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }
    
    @GetMapping("/hello")
    public String hello() {
    	return "hello";
    }
    
}
