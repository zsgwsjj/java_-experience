package com.zsgwsjj.jiang.comm.dao.impl;

import com.zsgwsjj.jiang.comm.dao.ITwitterDao;
import com.zsgwsjj.jiang.model.Twitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author : jiang
 * @time : 2018/1/31 22:29
 */
public class TwitterDao implements ITwitterDao {

    private static final String TABLE = " twitter ";
    private static final String INSERT_COLUMNS = " uid,content,create_time,update_time ";
    private static final String INSERT_NEW = " INSERT INTO " + TABLE + " (" + INSERT_COLUMNS + ") VALUES (?,?,?,?) ";
    private static final String QUERY_BY_TIME = " SELECT " + INSERT_COLUMNS + " FROM " + TABLE + " WHERE uid=? AND create_time>? " +
            "AND create_time<? ";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TwitterDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertNewTwitter(Twitter twitter) {
        jdbcTemplate.update(INSERT_NEW, twitter.getUid(), twitter.getContent(), twitter.getCreateTime(), twitter.getUpdateTime());
    }

    @Override
    public List<Twitter> queryTwitters(int uid, long startTime, long endTime) {
        return jdbcTemplate.query(QUERY_BY_TIME, new TwitterRowMapper(), uid, startTime, endTime);
    }

    private class TwitterRowMapper implements RowMapper<Twitter> {

        @Override
        public Twitter mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Twitter(
                    resultSet.getInt("uid"),
                    resultSet.getString("content"),
                    resultSet.getLong("create_time"),
                    resultSet.getLong("update_time")
            );
        }
    }
}
