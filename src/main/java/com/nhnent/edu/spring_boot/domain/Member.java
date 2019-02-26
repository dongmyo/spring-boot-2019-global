package com.nhnent.edu.spring_boot.domain;

public class Member {
    private final String name;
    private final String phoneNumber;


    public Member(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }


    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public String toString() {
        return "name=" + this.name + ",phoneNumber=" + this.phoneNumber;
    }

}
