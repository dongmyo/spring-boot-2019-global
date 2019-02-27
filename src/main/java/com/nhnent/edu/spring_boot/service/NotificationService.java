package com.nhnent.edu.spring_boot.service;

public interface NotificationService {
    String getType();

    boolean sendNotification(String phoneNumber, String message);

}
