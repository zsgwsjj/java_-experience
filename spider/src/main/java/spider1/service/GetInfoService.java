package spider1.service;

import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spider1.dao.IResourcesDao;
import spider1.model.Item;
import spider1.util.HttpRequest;

import java.util.List;

/**
 * @author : jiang
 * @time : 2018/4/4 16:48
 */
@Service
public class GetInfoService {

    private static String lastTopic;
    private static String thisTopic;

    @Autowired
    private IResourcesDao resourcesDao;

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
                        resourcesDao.insertRes(item);
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















