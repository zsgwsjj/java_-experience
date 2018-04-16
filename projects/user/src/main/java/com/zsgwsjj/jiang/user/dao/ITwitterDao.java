package com.zsgwsjj.jiang.user.dao;

import com.zsgwsjj.jiang.model.Twitter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : jiang
 * @time : 2018/1/31 22:28
 */
public interface ITwitterDao {

    void insertNewTwitter(Twitter twitter);

    List<Twitter> queryTwitters(@Param("id") int uid, @Param("start_time") long startTime, @Param("end_time") long endTime);
}
