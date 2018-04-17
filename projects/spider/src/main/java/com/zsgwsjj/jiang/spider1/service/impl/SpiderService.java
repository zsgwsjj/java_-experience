package com.zsgwsjj.jiang.spider1.service.impl;

import com.zsgwsjj.jiang.model.Item;
import com.zsgwsjj.jiang.spider1.dao.IResourcesDao;
import com.zsgwsjj.jiang.spider1.service.ISpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : jiang
 * @time : 2018/4/12 16:28
 */
@Service
public class SpiderService implements ISpiderService {

    @Autowired
    private IResourcesDao resourcesDao;

    @Override
    public void cleanUp() {
        resourcesDao.cleanUp();
    }

    @Override
    public Item checkLastOne() {
        return resourcesDao.getLastOne();
    }
}
