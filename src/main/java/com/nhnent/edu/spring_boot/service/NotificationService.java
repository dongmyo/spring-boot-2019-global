package com.nhnent.edu.spring_boot.service;

// TODO : #4 NotificationService interface.
public interface NotificationService {
    String getType();

    boolean sendNotification(String phoneNumber, String message);

}
