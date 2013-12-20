package com.zchen.service;

import com.zchen.bean.Account;
import com.zchen.dao.AccountDao;
import com.zchen.dao.TokenDao;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhouce Chen
 * @version Nov 17, 2013
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    AccountDao accountDao;

    @Resource
    TokenDao tokenDao;

    @Resource
    JavaMailSenderImpl javaMailSender;

    @Resource
    VelocityEngine velocityEngine;

    @Override
    public Account login(Account account) {
        return accountDao.login(account);
    }

    @Override
    public void password(Account account) {
        accountDao.password(account, null);
    }

    @Override
    public void password(Account account, String newPassword) {
        accountDao.password(account, newPassword);
    }

    @Override
    public void insert(Account account) {
        accountDao.insert(account);
    }

    @Override
    public void save(Account account) {
        accountDao.update(account);
    }

    @Override
    public void remove(int id) {
        accountDao.remove(id);
    }

    @Override
    public Account findById(int id) {
        return accountDao.findById(id);

    }

    @Override
    public Account findByUserName(String username) {
        return accountDao.findByUserName(username);
    }

    @Override
    public void sendResetPasswordEmail(Account account) {
        final String username = account.getUsername();
        String nickName = account.getNickname();
        String realName = account.getRealname();

        String token = RandomStringUtils.random(30, true, true);
        tokenDao.insert(token, username);

        String name;
        if (realName != null) {
            name = realName;
        } else if (nickName != null) {
            name = nickName;
        } else {
            name = username;
        }
        Map<String, Object> velocityTemplateParams = new HashMap<String, Object>();
        velocityTemplateParams.put("name", name);
        velocityTemplateParams.put("url", "http://localhost:8080/account/setNewPassword?token=" + token);

        final String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "resetPasswordMail.vm", "GBK", velocityTemplateParams);

        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "GBK");
                helper.setFrom(javaMailSender.getUsername());
                helper.setTo(username);
                helper.setSubject("My Web: Reset Password");
                helper.setText(text, true);
            }
        };
        javaMailSender.send(preparator);
    }

    @Override
    public String findByResetPasswordToken(String token) {
        return tokenDao.findByToken(token);
    }

    @Override
    public void deleteResetPasswordToken(String username) {
        tokenDao.delete(username);
    }
}
