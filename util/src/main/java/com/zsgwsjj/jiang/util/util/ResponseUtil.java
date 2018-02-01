package com.zsgwsjj.jiang.util.util;

import com.alibaba.fastjson.JSON;
import com.zsgwsjj.jiang.util.enums.IYaoError;
import com.zsgwsjj.jiang.util.other.YaoException;

import java.util.HashMap;

/**
 * @author : jiang
 * @time : 2018/1/30 20:20
 */
public class ResponseUtil {

    public static String geneSuccessResponse() {
        return "{\"code\":0,\"reason\":\"success\"}";
    }

    public static String geneCommonResponse(String desc, Object result) {
        HashMap<String, Object> response = new HashMap<>();
        response.put(desc, result);
        return JSON.toJSONString(response);
    }

    public static String geneCommonResponse(YaoException e) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", e.getErrorCode().getErrorCode());
        map.put("reason", e.getErrorCode().getErrorMessage());
        return JSON.toJSONString(map);
    }

    public static String geneCommonResponse(String message) {
        return JSON.toJSONString(message);
    }

    public static String geneCommonResponse(IYaoError e) {
        return JSON.toJSONString("{code:" + e.getErrorCode() + ",reason:" + e.getErrorMessage() + "}");
    }
}
