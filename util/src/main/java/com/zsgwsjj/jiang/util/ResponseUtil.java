package com.zsgwsjj.jiang.util;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

/**
 * @author : jiang
 * @time : 2018/1/30 20:20
 */
public class ResponseUtil {

    public static String geneCommonResponse(String desc, Object result) {
        HashMap<String, Object> response = new HashMap<>();
        response.put("desc", result);
        return JSON.toJSONString(response);
    }
}
