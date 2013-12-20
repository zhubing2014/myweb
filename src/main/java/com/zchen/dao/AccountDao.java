package com.zchen.dao;

import com.zchen.bean.Account;

/**
 * @author Zhouce Chen
 * @version Nov 17, 2013
 */
public interface AccountDao {

    public Account login(Account account);

    public void password(Account account, String newPassword);

    public void insert(Account account);

    public void remove(int id);

    public void update(Account account);

    public Account findById(int id);

    public Account findByUserName(String username);


}
