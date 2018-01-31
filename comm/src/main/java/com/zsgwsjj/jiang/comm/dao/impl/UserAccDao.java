package com.zsgwsjj.jiang.comm.dao.impl;

import com.zsgwsjj.jiang.comm.dao.IUserAccDao;
import com.zsgwsjj.jiang.user.ctrl.User;
import com.zsgwsjj.jiang.util.util.SqlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

/**
 * @author : jiang
 * @time : 2018/1/30 17:10
 */
public class UserAccDao implements IUserAccDao {

    private static final String TABLE = " user ";
    private static final String ALL_COLUMNS = " id,user_name,password,create_time,update_time ";
    private static final String GET_BY_NAME = " SELECT " + ALL_COLUMNS + " FROM " + TABLE + " WHERE user_name=? ";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserAccDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<User> getUserByName(String userName) {
        return SqlUtils.getObjectOp(jdbcTemplate, GET_BY_NAME, new UserRowMapper(), userName);
    }

    private class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            return new User(
                    resultSet.getInt("id"),
                    resultSet.getString("user_name"),
                    resultSet.getString("password"),
                    resultSet.getLong("create_time"),
                    resultSet.getLong("update_time")
            );
        }
    }
}
