package com.nhnent.edu.spring_boot.service.impl;

import com.nhnent.edu.spring_boot.domain.Member;
import com.nhnent.edu.spring_boot.service.MemberService;
import com.nhnent.edu.spring_boot.service.NotificationService;
import org.springframework.stereotype.Service;

// TODO : #2 MemberService implementation.
@Service
public class MemberServiceImpl implements MemberService {
    // TODO : #3 it needs notificationService.
    private final NotificationService notificationService;


    public MemberServiceImpl(NotificationService notificationService) {
        this.notificationService = notificationService;
    }


    @Override
    public boolean subscribe(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("Member is null");
        }

        if (member.getPhoneNumber() != null && !member.getPhoneNumber().isEmpty()) {
            notificationService.sendNotification(member.getPhoneNumber(), "Success to Subscribe");
        }

        return true;

    }

}