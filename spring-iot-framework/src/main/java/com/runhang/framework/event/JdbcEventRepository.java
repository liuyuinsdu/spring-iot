package com.runhang.framework.event;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;

/**
 * @author runhang
 * @create 2018-02-10 上午7:55
 **/
public class JdbcEventRepository implements EventRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcEventRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public <E> int save(E event) {
        return 0;
    }

    @Override
    public <E> int delete(E event) {
        return 0;
    }

    @Override
    public <E> int update(E event) {
        return 0;
    }

    @Override
    public <E> E getById(String id) {
        return null;
    }
}
