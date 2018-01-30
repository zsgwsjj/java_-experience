package com.zsgwsjj.jiang.util.util;


import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author : wangjia
 * @time : 2017/6/4 16:44
 */
public class LogUtils {

    public static StringBuilder logRequestInfo(HttpServletRequest httpServletRequest, StringBuilder log) {
        Map<String, String[]> params = httpServletRequest.getParameterMap();
        log.append("uri:").append(httpServletRequest.getRequestURI()).append("\t");
        log.append("params:[");
        for (Map.Entry<String, String[]> entry : params.entrySet()) {
            log.append(entry.getKey());
            log.append(":");
            String value = entry.getValue()[0];
            if (value.length() > 500) {
                log.append(value.substring(0, 500));
            } else {
                log.append(value);
            }
            log.append("\t");
        }
        log.append("]\t");
        return log;
    }
}
