import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;

/**
 * @author : jiang
 * @time : 2018/4/2 16:22
 */
public class ElasticsearchTest1 {
//    private static final Logger LOGGER = LoggerFactory.getLogger(ElasticsearchTest1.class);

    public static final String HOST = "127.0.0.1";

    public static final int PORT = 9300;

    private TransportClient client;

    @Before
    public void getConnect() throws UnknownHostException {
        client = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(
                new TransportAddress(InetAddress.getByName(HOST), PORT)
        );
        System.out.println("连接信息" + client.toString());
    }

    @After
    public void closeConnect() throws UnknownHostException {
        if (null != client) {
            System.out.println("关闭连接...");
            client.close();
        }
    }

    @Test
    public void addIndex1() throws IOException {
        IndexResponse response = client.prepareIndex("msg", "lalala", "1").setSource(XContentFactory.jsonBuilder()
                .startObject().field("username", "江江")
                .field("msg", "你好啦啦啦")
                .endObject()).get();
        System.out.println("索引名称:" + response.getIndex() + "\n类型:" + response.getType()
                + "\n文档ID:" + response.getId() + "\n当前实例状态:" + response.status());
    }

    @Test
    public void addIndex2() {
        HashMap<String, Object> params = new HashMap<>();
        params.put("username", "张三");
        params.put("sendDate", "2-18-04-03");
        params.put("msg", "你好李四");
        String jsonString = JSONObject.toJSONString(params);
        IndexResponse response = client.prepareIndex("weixin", "lalala").setSource(jsonString, XContentType.JSON).get();
        System.out.println("json索引名称:" + response.getIndex() + "\njson类型:" + response.getType()
                + "\njson文档ID:" + response.getId() + "\n当前实例json状态:" + response.status());
    }

    @Test
    public void addIndex3() {
        HashMap<String, Object> params = new HashMap<>();
        params.put("username", "张三");
        params.put("sendDate", "2-18-04-03");
        params.put("msg", "你好李四");
        IndexResponse response = client.prepareIndex("momo", "lalala").setSource(params).get();
        System.out.println("json索引名称:" + response.getIndex() + "\njson类型:" + response.getType()
                + "\njson文档ID:" + response.getId() + "\n当前实例json状态:" + response.status());

    }

    @Test
    public void getData() {
        GetResponse getResponse = client.prepareGet("momo", "lalala", "cbnMhWIB-P5axXG7k97a").get();
        System.out.println("data: "+getResponse.getSourceAsString());
    }

}
