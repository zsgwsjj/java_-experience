package com.zsgwsjj.jiang.util.util;

import com.alibaba.fastjson.JSON;
import com.zsgwsjj.jiang.util.enums.IYaoError;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.HashMap;

/**
 * @author : jiang
 * @time : 2018/2/1 17:11
 */
public class TestUtils {

    public static Integer getCode(String response) {
        return Integer.valueOf(JSON.parseObject(response).get("code").toString());
    }

}
