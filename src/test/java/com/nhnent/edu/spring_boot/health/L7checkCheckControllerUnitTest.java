package com.nhnent.edu.spring_boot.health;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(L7checkCheckController.class)
public class L7checkCheckControllerUnitTest {
    private static final String L7CHECK = "/l7check";

    @MockBean
    private ChangeableHealthIndicator healthIndicator;


    @Autowired
    private MockMvc mockMvc;


    @Test
    public void down() throws Exception {
        // before.
        when(healthIndicator.health()).thenReturn(new Health.Builder().up().build());
        mockMvc.perform(get(L7CHECK))
               .andExpect(status().isOk());

        // down.
        mockMvc.perform(delete(L7CHECK))
               .andExpect(status().isNoContent());

        ArgumentCaptor<Health> argument = ArgumentCaptor.forClass(Health.class);
        verify(healthIndicator).changeHealth(argument.capture());

        Assert.assertEquals(Status.DOWN, argument.getValue().getStatus());
    }

    @Test
    public void up() throws Exception {
        // before.
        when(healthIndicator.health()).thenReturn(new Health.Builder().down().build());
        mockMvc.perform(get(L7CHECK))
               .andExpect(status().isServiceUnavailable());

        // up.
        mockMvc.perform(post(L7CHECK))
               .andExpect(status().isCreated());

        ArgumentCaptor<Health> argument2 = ArgumentCaptor.forClass(Health.class);
        verify(healthIndicator).changeHealth(argument2.capture());

        Assert.assertEquals(Status.UP, argument2.getValue().getStatus());
    }

}
