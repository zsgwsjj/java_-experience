package com.zsgwsjj.jiang.spider1.service.impl;

import com.zsgwsjj.jiang.spider1.dao.IResourcesDao;
import com.zsgwsjj.jiang.spider1.service.ISpiderService;
import okhttp3.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

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
        List<Map<String, String>> checkList = resourcesDao.getNewestOne();
        String linksAndPwds = null;
        String id = null;
        for (Map.Entry<String, String> entry : checkList.get(0).entrySet()) {
            if (entry.getKey().equals("links")) {
                linksAndPwds = entry.getValue();
            }
            if (entry.getKey().equals("id")) {
                id = entry.getValue();
            }
        }
        Map.Entry<String, String> entry = checkList.get(0).entrySet().iterator().next();
        if (linksAndPwds==null){
            return;
        }
        logger.info(linksAndPwds);
        StringTokenizer stringTokenizer = new StringTokenizer(linksAndPwds, ";#");
        List<String> links = new ArrayList<>();
        while (stringTokenizer.hasMoreElements()) {
            String s = stringTokenizer.nextToken();
            if (isLink(s)) {
                links.add(s);
            }
        }
        for (String link : links) {
            Response response = HttpRequest.httpRequest(link);
            if (response.isSuccessful()) {
                String responseStr;
                responseStr = response.body().string();
                if (!responseStr.contains("<title>百度网盘 请输入提取密码</title>")) {
                    return;
                }
            }
        }
        resourcesDao.updateStatus(Integer.valueOf(id));
        logger.info("the resource id :" + id + " has been resolved!");
    }

    private boolean isLink(String st) {
        return st.startsWith("http");
    }
}
