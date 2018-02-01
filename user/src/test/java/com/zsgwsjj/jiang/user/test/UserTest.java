package com.zsgwsjj.jiang.user.test;

import com.zsgwsjj.jiang.util.base.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

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

    @Test
    public void test() throws Exception {
        url = "/login";
        params.clear();
        params.put("username", "xx");
        params.put("password", "e10adc3949ba59abbe56e057f20f883e");
        this.baseTest(url, params);
    }

    @Test
    public void test2() throws Exception {
        url = "/twitter/report";
        params.clear();
        params.put("uid", 1);
        params.put("content", "this is test");
        this.baseTest(url, params);
    }

    @Test
    public void registTest() throws Exception {
        url = "/regist";
        params.clear();
        params.put("username", "jiang");
        params.put("password", "111111");
        this.baseTest(url, params);
    }
}
