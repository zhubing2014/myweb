package com.zchen.controller;

import com.zchen.util.TestUtils;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;

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
public class SaveAccountTest {
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

    @Before
    public void before() {
        TestUtils.jdbcTemplate.update("INSERT INTO users(id, username) VALUES(1, 'chenzhouce@gmail.com')", new HashMap<String, Object>());
    }

    @After
    public void after() {
        TestUtils.clean("users");
    }

    @Test
    public void simple() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/account/save")
                .param("id", "1")
                .param("username", "chenzhouce@gmail.com"))
                .andExpect(redirectedUrl("/account/settings"));
    }

    @Test
    public void full() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/account/save")
                .param("id", "1")
                .param("username", "chenzhouce@gmail.com")
                .param("nickname", "chenzhouce1")
//                .param("realname", "chenzhouce") //TODO unit test bug for birthday param
                .param("birthday", "1987-03-31")
                .param("email", "chenzhouce@gmail.com"))
                .andExpect(redirectedUrl("/account/settings"));
    }

    @Test
    public void accountNotExist() throws Exception {
        TestUtils.clean("users");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/account/save")
                .param("id", "1")
                .param("username", "chenzhouce@gmail.com"))
                .andExpect(view().name("account/settings"));
    }

    @Test
    public void updateEmptyBirthday() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/account/save")
                .param("id", "1")
                .param("birthday", ""))
                .andExpect(redirectedUrl("/account/settings"));
    }


}
