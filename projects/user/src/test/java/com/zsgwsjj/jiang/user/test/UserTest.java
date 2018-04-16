package com.zsgwsjj.jiang.user.test;

import com.alibaba.fastjson.JSONObject;
import com.zsgwsjj.jiang.util.base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import redis.clients.jedis.Jedis;

import java.util.HashMap;

/**
 * @author : jiang
 * @time : 2018/01/30 22:56
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:context.xml"})
public class UserTest extends BaseTest {

    private HashMap<String, Object> params = new HashMap<>();
    private String url;
    @Autowired
    private RedisCacheManager redisCacheManager;

    private static final Logger LOGGER = LogManager.getLogger(UserTest.class);

    @Test
    public void loginTest() throws Exception {
        url = "/login";
        params.clear();
        params.put("username", "yaoamei");
        params.put("password", "e10adc3949ba59abbe56e057f20f883e");
        this.baseTest(url, params);
    }

    @Test
    public void reportTwitterTest() throws Exception {
        url = "/twitter/report";
        params.clear();
        params.put("uid", 10000001);
        params.put("content", "this is test");
        this.baseTest(url, params);
        LOGGER.info("lalallala");
    }

    @Test
    public void registTest() throws Exception {
        url = "/regist";
        params.clear();
        params.put("username", "jiang");
        params.put("password", "111111");
        this.baseTest(url, params);

    }

    @Test
    public void updatePw() throws Exception {
        url = "/update_pw";
        params.clear();
        params.put("username", "jiang");
        params.put("old_password", "111111");
        params.put("new_password", "222222");
        this.baseTest(url, params);
    }

    @Test
    public void updatePwTest() throws Exception {
        registTest();
        updatePw();
    }

    @Cacheable("redisTest")
    public String redisTest() throws Exception {
        return "test";
    }

    @Test
    public void testRedis() throws Exception {
        Jedis jedis = new Jedis("localhost");
        jedis.set("test3", "江江");
        System.out.println(jedis.get("test3"));
        jedis.set("test4", jedis.get("test3"));
    }

    @Test
    public void jsonTest() {
        String jsonString = JSONObject.toJSONString("姜江");
        System.out.println(jsonString);
    }
}
