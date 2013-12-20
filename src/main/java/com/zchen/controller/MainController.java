package com.zchen.controller;

import com.zchen.service.AccountService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * @author Zhouce Chen
 * @version Nov 18, 2013
 */

@Controller
@RequestMapping("/")
public class MainController {
    private static Logger logger = Logger.getLogger(MainController.class);
    @Resource
    AccountService accountService;

    @RequestMapping("")
    public String index() {
        return "main/index";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "main/login";
    }
}
