package com.zchen.dao;

import com.zchen.bean.Account;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhouce Chen
 * @version Nov 17, 2013
 */
@Repository("AccountDao")
public class AccountDaoImpl implements AccountDao {

    @Resource
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Account login(Account account) {
        String sql = "SELECT * FROM users WHERE username=:username AND password=:password";
        SqlParameterSource source = new BeanPropertySqlParameterSource(account);
        return jdbcTemplate.queryForObject(sql, source, new AccountMapper());
    }

    @Override
    public void password(Account account, String newPassword) {
        StringBuilder sb = new StringBuilder("UPDATE users SET password=:newPassword WHERE ");
        Map<String, Object> map = new HashMap<String, Object>();
        if (account.getId() != null) {
            sb.append(" id=:id ");
            map.put("id", account.getId());
        } else if (account.getUsername() != null) {
            sb.append(" username=:username ");
            map.put("username", account.getUsername());
        }
        if (newPassword != null) {
            sb.append(" AND password=:oldPassword ");
            map.put("oldPassword", account.getPassword());
            map.put("newPassword", newPassword);
        } else {
            map.put("newPassword", account.getPassword());
        }

        jdbcTemplate.update(sb.toString(), map);
    }

    @Override
    public void insert(Account account) {
        String sql = "INSERT INTO users(username, password) VALUES(:username,  :password)";
        SqlParameterSource source = new BeanPropertySqlParameterSource(account);
//        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, source);
    }

    @Override
    public void remove(int id) {


    }

    @Override
    public void update(Account account) {
        String sql = "UPDATE users SET realname=:realname, nickname=:nickname, sex=:sex, birthday=:birthday, email=:email WHERE id=:id";
        SqlParameterSource source = new BeanPropertySqlParameterSource(account);
        jdbcTemplate.update(sql, source);

    }

    @Override
    public Account findById(int id) {
        String sql = "SELECT * FROM users WHERE id=:id";
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("id", id);
        return jdbcTemplate.queryForObject(sql, map, new AccountMapper());
    }

    @Override
    public Account findByUserName(String username) {
        String sql = "SELECT * FROM users WHERE username=:username";
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", username);
        return jdbcTemplate.queryForObject(sql, map, new AccountMapper());
    }


    private class AccountMapper implements RowMapper<Account> {
        @Override
        public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
            Account account = new Account();
            account.setId(rs.getInt("id"));
            account.setId(rs.getInt("id"));
            account.setUsername(rs.getString("username"));
            account.setNickname(rs.getString("nickname"));
            account.setRealname(rs.getString("realname"));
            account.setBirthday(rs.getDate("birthday"));
            account.setSex(rs.getInt("sex"));
            account.setEmail(rs.getString("email"));
            return account;
        }
    }


}
