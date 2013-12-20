package com.zchen.controller;

import com.zchen.util.TestUtils;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * @author Zhouce Chen
 * @version Dec 11, 2013
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/resources/*.xml")
public class SignInTest {
    private MockMvc mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;


    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @BeforeClass
    public static void beforeClass() {
        TestUtils.clean("users");
    }

    @AfterClass
    public static void afterClass() {
        TestUtils.clean("users");
    }

    @Test
    public void success() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/account/signIn")
                .param("username", "chenzhouce@gmail.com")
                .param("password", "32633263"))
                .andExpect(redirectedUrl("/login"));
    }

    @Test
    public void fail() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/account/signIn")
                .param("username", "chenzhouce@gmail.com")
                .param("password", "32633263"))
                .andExpect(view().name("main/signIn"));
    }


}
