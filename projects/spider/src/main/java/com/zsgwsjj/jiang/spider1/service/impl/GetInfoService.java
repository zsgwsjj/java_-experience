package com.zsgwsjj.jiang.spider1.service.impl;

import com.zsgwsjj.jiang.spider1.dao.IResourcesDao;
import com.zsgwsjj.jiang.model.Item;
import com.zsgwsjj.jiang.spider1.service.IGetInfoService;
import com.zsgwsjj.jiang.util.util.MybatisSqlGeneUtil;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : jiang
 * @time : 2018/4/4 16:48
 */
@Service
public class GetInfoService implements IGetInfoService {

    private static String lastTopic;
    private static String thisTopic;

    @Autowired
    private IResourcesDao resourcesDao;

    private Logger logger = LogManager.getLogger(GetInfoService.class);

    @Override
    public void getInfo() {
        try {
            OkHttpClient client = new OkHttpClient();
            for (int i = 1; i < 9; i++) {
                String url = "https://www.52pojie.cn/forum.php?mod=guide&view=newthread&page=" + i;
                Response response = HttpRequest.httpRequest(url);
                System.out.println(response.toString());
                if (response.isSuccessful()) {
                    String responseStr;
                    responseStr = response.body().string();
                    ParseHtml parseHtml = new ParseHtml();
                    List<Item> items = parseHtml.getCurrentPageItems(responseStr, lastTopic);
                    for (Item item : items) {
                        if (item.getLinks() == null) {
                            continue;
                        }
                        String sql = MybatisSqlGeneUtil.geneInsert(item, "resource_spider");
                        logger.info(sql);
//                        resourcesDao.insertRes(item);
                        System.out.println(item);
                    }
                    if (i == 1) {
                        thisTopic = items.get(0).getTitle();
                    }
                    if (parseHtml.isFind()) {
                        break;
                    }
                }
            }
            lastTopic = thisTopic;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}















