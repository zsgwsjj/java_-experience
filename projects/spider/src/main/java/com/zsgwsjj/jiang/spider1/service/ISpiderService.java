package com.zsgwsjj.jiang.spider1.service;

import com.zsgwsjj.jiang.model.Item;

/**
 * @author : jiang
 * @time : 2018/4/12 16:28
 */
public interface ISpiderService {
    void cleanUp();

    Item checkLastOne();
}
