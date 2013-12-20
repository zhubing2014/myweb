package com.zchen.util;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;

/**
 * @author Zhouce Chen
 * @version Nov 20, 2013
 */
public class TestUtils {

    public static NamedParameterJdbcTemplate jdbcTemplate;

    public static BasicDataSource dataSource;

    static {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/myweb");
        dataSource.setUsername("root");
        dataSource.setPassword("32633263");
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public static void clean(String table) {
        jdbcTemplate.update("delete from " + table, new HashMap<String, Object>());
    }


}
