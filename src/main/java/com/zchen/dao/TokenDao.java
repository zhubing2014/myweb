package com.zchen.dao;

import java.util.Date;

/**
 * @author Zhouce Chen
 * @version Nov 19, 2013
 */
public interface TokenDao {

    public void insert(String token, String username);

    public void delete(String username);

    public String findByToken(String token);

    public void deleteBeforeTime(Date date);

}
