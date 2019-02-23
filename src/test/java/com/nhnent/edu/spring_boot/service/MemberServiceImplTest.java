package com.nhnent.edu.spring_boot.service;

import com.nhnent.edu.spring_boot.domain.Member;
import com.nhnent.edu.spring_boot.service.impl.SmsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

// TODO : #7 MemberServiceImpl test.
@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberServiceImplTest {
    // TODO : #8 @TestConfiguration w/ using SmsServiceImpl as NotificationService.
    @TestConfiguration
    static class MemberServiceImplTestContextConfiguration {
        @Bean
        public NotificationService notificationService() {
            return new SmsServiceImpl();
        }
    }

    @Autowired
    private MemberService memberService;


    // TODO : #9 run this test case.
    @Test
    public void test() throws Exception {
        memberService.subscribe(new Member("zibum", "000-111-2222"));
    }

}
