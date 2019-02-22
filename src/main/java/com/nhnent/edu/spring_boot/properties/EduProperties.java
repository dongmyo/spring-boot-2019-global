package com.nhnent.edu.spring_boot.properties;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

// TODO : #2 @ConfigurationProperties 
@ConfigurationProperties(prefix="nhn.edu")
@Validated
public class EduProperties {
    @NotNull
    @Min(10)
    private Long studentMaxCount = 10L;
    

    public Long getStudentMaxCount() {
        return studentMaxCount;
    }

    public void setStudentMaxCount(Long studentMaxCount) {
        this.studentMaxCount = studentMaxCount;
    }
    
}
