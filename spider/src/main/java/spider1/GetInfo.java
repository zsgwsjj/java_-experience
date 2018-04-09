package spider1;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;

import java.util.List;

/**
 * @author : jiang
 * @time : 2018/4/4 16:48
 */
public class GetInfo {

    private static String lastTopic;
    private static String thisTopic;

    @Test
    public void getInfo() {
        try {
            OkHttpClient client = new OkHttpClient();
            for (int i = 1; i < 9; i++) {
                Request request = new Request.Builder()
                        .url("https://www.52pojie.cn/forum.php?mod=guide&view=newthread&page=" + i)
                        .build();
                Response response = client.newCall(request).execute();
                System.out.println(response.toString());
                if (response.isSuccessful()) {
                    String responseStr = response.body().string();
                    ParseHtml parseHtml = new ParseHtml();
                    List<Item> items = parseHtml.getCurrentPageItems(responseStr, lastTopic);
//                    testInsert(items);
                    for (int j = 0; j < items.size(); j++) {
                        System.out.println(items.get(j));
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

//    public void testInsert(List<Item> items){
//        try {
//            InputStream stream=Resource.getRe
//        }
//
//    }
}















