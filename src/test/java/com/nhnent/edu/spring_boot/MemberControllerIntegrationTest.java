package com.nhnent.edu.spring_boot;

import com.nhnent.edu.spring_boot.domain.Member;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;

// TODO : #6 run this test case with profile dev/production.
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MemberControllerIntegrationTest {
    @Autowired
    TestRestTemplate restTemplate;


    @Test
    public void test() throws Exception {
        Member member = new Member("김병부", "01099499102");
        ResponseEntity<Object> res = restTemplate.postForEntity("/member/subscribe", member, Object.class);
        Assert.assertThat(res.getStatusCode(), is(HttpStatus.OK));
    }

}
