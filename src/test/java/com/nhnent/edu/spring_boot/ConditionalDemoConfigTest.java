package com.nhnent.edu.spring_boot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConditionalDemoConfigTest {
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void sayYesComponent() {
        Assert.assertTrue(containsBean("sayYesComponent"));
    }

    @Test
    public void sayYesComponentWeb() {
        Assert.assertTrue(containsBean("sayYesComponentWeb"));
    }

    @Test
    public void sayYesComponentNotWeb() {
        Assert.assertFalse(containsBean("sayYesComponentNotWeb"));
    }

    @Test
    public void sayYesComponentOnBean() {
        Assert.assertTrue(containsBean("sayYesComponentOnBean"));
    }

    @Test
    public void sayYesComponentOnMissingBean() {
        Assert.assertFalse(containsBean("sayYesComponentOnMissingBean"));
    }

    @Test
    public void sayYesComponentOnClass() {
        Assert.assertTrue(containsBean("sayYesComponentOnClass"));
    }

    @Test
    public void sayYesComponentOnMissingClass() {
        Assert.assertTrue(containsBean("sayYesComponentOnMissingClass"));
    }

    @Test
    public void sayYesComponentOnProperty() {
        Assert.assertTrue(containsBean("sayYesComponentOnProperty"));
    }

    @Test
    public void sayYesComponentOnResource() {
        Assert.assertTrue(containsBean("sayYesComponentOnResource"));
    }

    private boolean containsBean(String beanName) {
        return applicationContext.containsBean(beanName);
    }

}
