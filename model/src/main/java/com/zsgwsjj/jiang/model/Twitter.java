package com.zsgwsjj.jiang.model;

import lombok.Data;

/**
 * @author : jiang
 * @time : 2018/1/31 19:18
 */
@Data
public class Twitter {

    private int id;
    private int uid;
    private String avatar;
    private String content;
    private long createTime;
    private long updateTime;

    public Twitter(int uid, String content, long createTime, long updateTime) {
        this.uid = uid;
        this.content = content;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

}
