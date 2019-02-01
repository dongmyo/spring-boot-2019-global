package com.nhnent.edu.spring_boot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

// TODO : #0 아래 테스트 케이스들을 모두 성공하세요.
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConditionalDemoConfigTest {
    @Autowired
    private ApplicationContext applicationContext;

    // 이 테스트를 성공하려면 TODO #1을 수행하세요.
    @Test
    public void sayYesComponent() {
        Assert.assertTrue(containsBean("sayYesComponent"));
    }

    // 이 테스트를 성공하려면 TODO #2을 수행하세요.
    @Test
    public void sayYesComponentWeb() {
        Assert.assertTrue(containsBean("sayYesComponentWeb"));
    }

    // 이 테스트를 성공하려면 TODO #2을 수행하세요.
    @Test
    public void sayYesComponentNotWeb() {
        Assert.assertFalse(containsBean("sayYesComponentNotWeb"));
    }

    // 이 테스트를 성공하려면 TODO #3을 수행하세요.
    @Test
    public void sayYesComponentOnBean() {
        Assert.assertTrue(containsBean("sayYesComponentOnBean"));
    }

    // 이 테스트를 성공하려면 TODO #3을 수행하세요.
    @Test
    public void sayYesComponentOnMissingBean() {
        Assert.assertFalse(containsBean("sayYesComponentOnMissingBean"));
    }

    // 이 테스트를 성공하려면 TODO #4을 수행하세요.
    @Test
    public void sayYesComponentOnClass() {
        Assert.assertTrue(containsBean("sayYesComponentOnClass"));
    }

    // 이 테스트를 성공하려면 TODO #4을 수행하세요.
    @Test
    public void sayYesComponentOnMissingClass() {
        Assert.assertTrue(containsBean("sayYesComponentOnMissingClass"));
    }

    // 이 테스트를 성공하려면 TODO #5을 수행하세요.
    @Test
    public void sayYesComponentOnProperty() {
        Assert.assertTrue(containsBean("sayYesComponentOnProperty"));
    }

    // 이 테스트를 성공하려면 TODO #6을 수행하세요.
    @Test
    public void sayYesComponentOnResource() {
        Assert.assertTrue(containsBean("sayYesComponentOnResource"));
    }

    private boolean containsBean(String beanName) {
        return applicationContext.containsBean(beanName);
    }

}
