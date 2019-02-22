package com.nhnent.edu.spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhnent.edu.spring_boot.properties.EduProperties;

@RestController
@SpringBootApplication
// TODO : #1 @EnableConfigurationProperties
@EnableConfigurationProperties(EduProperties.class)
public class App
{
    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }
    
    @GetMapping("/hello")
    public String hello() {
    	return "hello";
    }
    
    @Autowired
    private EduProperties eduProperties;

    @GetMapping("/student/count/max")
    public Long studentMaxCount(){
        return eduProperties.getStudentMaxCount();
    }
    
}
