package com.zsgwsjj.jiang.spider1.dao;


import com.zsgwsjj.jiang.model.Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author : jiang
 * @time : 2018/4/11 17:32
 */
public interface IResourcesDao {

    void insertRes(@Param("item") Item item);

    Item selectRes();

    void cleanUp();

    Item getLastOne();

    List<Map<String, String>> getNewestOne();

    void updateStatus(@Param("id") Integer id);
}
