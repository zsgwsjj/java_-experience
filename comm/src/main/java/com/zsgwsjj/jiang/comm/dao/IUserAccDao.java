package com.zsgwsjj.jiang.comm.dao;

import com.zsgwsjj.jiang.model.User;

/**
 * @author : jiang
 * @time : 2018/1/30 17:09
 */
public interface IUserAccDao {

    User getUserByName(String userName);

    void addNewUser(User user);
}
