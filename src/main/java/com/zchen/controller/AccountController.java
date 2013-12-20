package com.zchen.controller;

import com.zchen.bean.Account;
import com.zchen.service.AccountService;
import com.zchen.utils.Encoder;
import org.apache.log4j.Logger;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;


/**
 * @author Zhouce Chen
 * @version Nov 17, 2013
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    private final Logger logger = Logger.getLogger(AccountController.class);

    @Resource
    AccountService accountService;
    @Resource
    UserDetailsManager userDetailsManager;

    @RequestMapping(value = "signIn", method = RequestMethod.GET)
    public String signIn() {
        return "main/sign_in";
    }

    @RequestMapping(value = "signIn", method = RequestMethod.POST)
    public String signIn(Model model, Account account) {
        account.setPassword(Encoder.standardEncode(account.getPassword()));
        try {
            userDetailsManager.createUser(account);
        } catch (DuplicateKeyException e) {
            model.addAttribute("message", "This username has been existed.");
            return "main/sign_in";
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "password", method = RequestMethod.GET)
    public String password() {
        return "account/password";
    }

    @RequestMapping(value = "password", method = RequestMethod.POST)
    public String password(String oldPassword, String newPassword) {
        userDetailsManager.changePassword(Encoder.standardEncode(oldPassword), Encoder.standardEncode(newPassword));
        return "redirect:/account/password";
    }

    @RequestMapping("/settings")
    public String display(ModelMap map) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        try {
            Account account = accountService.findByUserName(userDetails.getUsername());
            map.put("account", account);
            return "account/settings";
        } catch (EmptyResultDataAccessException e) {
            logger.info("Account [" + userDetails.getUsername() + "] doesn't exist.");
            map.put("message", "This account doesn't exist. May be removed.");
            return "main/error";
        }
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Model model, Account account) {
        accountService.save(account);
        return "redirect:/account/settings";
    }

    @RequestMapping(value = "resetPassword", method = RequestMethod.GET)
    public String resetPassword() {
        return "account/reset_password";
    }

    @RequestMapping(value = "resetPassword", method = RequestMethod.POST)
    public String resetPassword(Model model, final String username) {
        Account account;
        try {
            account = accountService.findByUserName(username);
        } catch (EmptyResultDataAccessException e) {
            model.addAttribute("message", "Username has not been existed.");
            return "account/reset_password";
        }
        accountService.sendResetPasswordEmail(account);
        model.addAttribute("success", "Email has been sent. Please check.");
        return "account/reset_password";
    }

    @RequestMapping(value = "setNewPassword", method = RequestMethod.GET)
    public String setNewPassword(Model model, String token) {
        String username = null;
        try {
            username = accountService.findByResetPasswordToken(token);
        } catch (EmptyResultDataAccessException e) {
            model.addAttribute("message", "The link has been expired.");
            return "main/error";
        }
        model.addAttribute("username", username);
        return "account/set_new_password";
    }

    @RequestMapping(value = "setNewPassword", method = RequestMethod.POST)
    public String setNewPassword(Account account) {
        accountService.password(account);
        accountService.deleteResetPasswordToken(account.getUsername());
        return "redirect:/account/login";
    }

    @RequestMapping(value = "destroy", method = RequestMethod.GET)
    public String toDestroy() {
        return "account/destroy";
    }

    @RequestMapping(value = "destroy", method = RequestMethod.POST)
    public String destroy() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userDetailsManager.deleteUser(userDetails.getUsername());
        logger.info(userDetails.getUsername() + " has destroyed his account.");
        return "redirect:/login";
    }
}
