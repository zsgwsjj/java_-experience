package com.zsgwsjj.jiang.comm.dao;

import com.zsgwsjj.jiang.model.User;

import java.util.Optional;

/**
 * @author : jiang
 * @time : 2018/1/30 17:09
 */
public interface IUserAccDao {

    Optional<User> getUserByName(String userName);
}
