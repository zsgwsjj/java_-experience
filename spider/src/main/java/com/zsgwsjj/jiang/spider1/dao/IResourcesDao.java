package com.zsgwsjj.jiang.spider1.dao;

import com.zsgwsjj.jiang.spider1.model.Item;
import org.apache.ibatis.annotations.Param;

/**
 * @author : jiang
 * @time : 2018/4/11 17:32
 */
public interface IResourcesDao {

    void insertRes(@Param("item") Item item, @Param("sql") String sql);

}
