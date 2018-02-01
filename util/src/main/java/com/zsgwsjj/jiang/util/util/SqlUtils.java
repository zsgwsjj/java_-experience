package com.zsgwsjj.jiang.util.util;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Optional;

/**
 * @author : jiang
 * @time : 2018/1/31 12:49
 */
public class SqlUtils {

    public static <T> Optional<T> getObjectOp(JdbcTemplate jdbcTemplate, String sql, RowMapper<T> rowMapper, Object... args) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(sql, rowMapper, args));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public static <T> Optional<T> getObjectOp(T object) {
        return Optional.ofNullable(object);
    }
}

