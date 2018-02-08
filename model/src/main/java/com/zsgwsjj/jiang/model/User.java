package com.zsgwsjj.jiang.model;

import lombok.Data;
import lombok.ToString;

/**
 * @author : jiang
 * @time : 2018/1/30 17:19
 */
@Data
@ToString
public class User {

    private int id;
    private String userName;
    private String password;
    private long createTime;
    private long updateTime;

    public User() {
    }

    public User(int id, String userName, String password, long createTime, long updateTime) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

}
