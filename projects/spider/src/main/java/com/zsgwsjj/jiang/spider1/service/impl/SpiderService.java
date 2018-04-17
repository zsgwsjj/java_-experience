package com.zsgwsjj.jiang.spider1.service.impl;

import com.zsgwsjj.jiang.model.Item;
import com.zsgwsjj.jiang.spider1.dao.IResourcesDao;
import com.zsgwsjj.jiang.spider1.service.ISpiderService;
import okhttp3.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author : jiang
 * @time : 2018/4/12 16:28
 */
@Service
public class SpiderService implements ISpiderService {

    private Logger logger = LogManager.getLogger(SpiderService.class);

    @Autowired
    private IResourcesDao resourcesDao;

    @Override
    public void cleanUp() {
        resourcesDao.cleanUp();
    }

    @Override
    public void checkLastOne() throws IOException {
        Item item = resourcesDao.getLastOne();
        String[] links = item.getLinks();
        for (String link : links) {
            Response response = HttpRequest.httpRequest(link);
            if (response.isSuccessful()) {
                String responseStr;
                responseStr = response.body().string();
                logger.info(responseStr);
            }
        }
    }
}
