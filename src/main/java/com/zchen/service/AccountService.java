package com.zchen.service;

import com.zchen.bean.Account;

/**
 * @author Zhouce Chen
 * @version Nov 17, 2013
 */
public interface AccountService {

    public Account login(Account account);

    public void password(Account account);

    public void password(Account account, String newPassword);

    public void insert(Account account);

    public void save(Account account);

    public void remove(int id);

    public Account findById(int id);

    public Account findByUserName(String username);

    public void sendResetPasswordEmail(Account account);

    public String findByResetPasswordToken(String token);

    public void deleteResetPasswordToken(String username);
}
