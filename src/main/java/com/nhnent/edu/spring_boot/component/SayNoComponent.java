package com.nhnent.edu.spring_boot.component;

public class SayNoComponent {
    private String name;

    
    public SayNoComponent(String name) {
        this.name = name;
    }

    public void sayNo() {
        System.out.println("NO! " + this.name);
    }

}
