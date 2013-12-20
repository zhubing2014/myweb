package com.zchen.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhouce Chen
 * @version Nov 19, 2013
 */
@Repository
public class TokenDaoImpl implements TokenDao {

    @Resource
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void insert(String token, String username) {
        String sql = "INSERT INTO token(code, username) VALUES(:token, :username)";
        Map<String, String> map = new HashMap<String, String>();
        map.put("token", token);
        map.put("username", username);
        jdbcTemplate.update(sql, map);
    }

    @Override
    public void delete(String username) {
        String sql = "DELETE FROM token WHERE username=:username";
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", username);
        jdbcTemplate.update(sql, map);
    }

    @Override
    public String findByToken(String token) {
        String sql = "SELECT username FROM token WHERE code=:token";
        Map<String, String> map = new HashMap<String, String>();
        map.put("token", token);
        return jdbcTemplate.queryForObject(sql, map, String.class);
    }

    @Override
    public void deleteBeforeTime(Date date) {
        String sql = "DELETE FROM token WHERE time < :time";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("time", date);
        jdbcTemplate.update(sql, map);
    }
}
