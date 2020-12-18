package com.secbro2.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author zzs
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArgumentControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testLevel1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/level1").header("token", "token_abc"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("1")))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testLevel2() throws Exception {
        // 拦截器无法通过单元测试进行测试
    }
}
