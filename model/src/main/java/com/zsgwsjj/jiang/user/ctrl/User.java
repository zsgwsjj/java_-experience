package com.zsgwsjj.jiang.user.ctrl;

/**
 * @author : jiang
 * @time : 2018/1/30 17:19
 */
public class User {

    private int id;
    private String userName;
    private String password;
    private long createTime;
    private long updateTime;

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public long getCreateTime() {
        return createTime;
    }

    public User setCreateTime(long createTime) {
        this.createTime = createTime;
        return this;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public User setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}
