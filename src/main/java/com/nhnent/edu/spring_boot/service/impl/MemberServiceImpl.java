package com.nhnent.edu.spring_boot.service.impl;

import com.nhnent.edu.spring_boot.domain.Member;
import com.nhnent.edu.spring_boot.service.MemberService;
import com.nhnent.edu.spring_boot.service.NotificationService;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    private final NotificationService notificationService;


    // TODO : #4 MemberServiceImpl uses a NotificationService.
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
