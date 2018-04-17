package com.zsgwsjj.jiang.spider1.service.impl;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author : jiang
 * @time : 2018/4/12 14:50
 */
public class HttpRequest {

    public static Response httpRequest(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        return client.newCall(request).execute();
    }

}
