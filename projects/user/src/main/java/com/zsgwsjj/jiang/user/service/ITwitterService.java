package com.zsgwsjj.jiang.user.service;

import com.zsgwsjj.jiang.model.Twitter;

import java.util.List;

/**
 * @author : jiang
 * @time : 2018/1/31 19:20
 */
public interface ITwitterService {

    void reportNewTwitter(Twitter twitter);

    List<Twitter> getTwitters(long startTime, long endTime, int uid);
}
