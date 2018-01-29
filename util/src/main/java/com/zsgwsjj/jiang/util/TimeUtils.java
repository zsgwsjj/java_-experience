package com.zsgwsjj.jiang.util;

import java.util.Date;

/**
 * @author : jiang
 * @time : 2018/1/29 18:56
 */
public class TimeUtils {

    public static long getCurrentUnixTimestamp() {
        return new Date().getTime() / 1000;
    }
}
