package com.zsgwsjj.jiang.comm.dao;

import com.zsgwsjj.jiang.model.Twitter;

import java.util.List;

/**
 * @author : jiang
 * @time : 2018/1/31 22:28
 */
public interface ITwitterDao {

    void insertNewTwitter(Twitter twitter);

    List<Twitter> queryTwitters(int uid, long startTime, long endTime);
}
