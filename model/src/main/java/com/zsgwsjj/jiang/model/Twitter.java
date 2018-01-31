package com.zsgwsjj.jiang.model;

/**
 * @author : jiang
 * @time : 2018/1/31 19:18
 */
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

    public int getId() {
        return id;
    }

    public Twitter setId(int id) {
        this.id = id;
        return this;
    }

    public int getUid() {
        return uid;
    }

    public Twitter setUid(int uid) {
        this.uid = uid;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public Twitter setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Twitter setContent(String content) {
        this.content = content;
        return this;
    }

    public long getCreateTime() {
        return createTime;
    }

    public Twitter setCreateTime(long createTime) {
        this.createTime = createTime;
        return this;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public Twitter setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}
