package com.nhnent.edu.spring_boot;

import com.nhnent.edu.spring_boot.dto.ItemDto;
import com.nhnent.edu.spring_boot.entity.Item;
import com.sun.glass.ui.delegate.MenuItemDelegate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;

// TODO : #10 run this test case (webmvc, jpa)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIntegrationTest {
    @Autowired
    TestRestTemplate restTemplate;


    @Test
    public void test() throws Exception {
        ResponseEntity<List<ItemDto>> result = restTemplate.exchange(
                "/items?pg=0&sz=3", HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<ItemDto>>() {
        });
        Assert.assertThat(result.getStatusCode(), is(HttpStatus.OK));
        Assert.assertNotNull(result.getBody());
        Assert.assertEquals(3, result.getBody().size());
    }

}
