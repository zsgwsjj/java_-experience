package com.zsgwsjj.jiang.comm.service.impl;

import com.zsgwsjj.jiang.comm.service.IUserAccService;
import com.zsgwsjj.jiang.util.TimeUtils;


/**
 * @author : jiang
 * @time : 2018/1/29 18:34
 */
public class UserAccService implements IUserAccService {

    private static final String JIANG = "jiang";
    private static final String YAO = "yao";

    @Override
    public String loginWithUserName(String userName, String password) {
        if (userName.equals(JIANG) || userName.equals(YAO)) {
            if (password.equals("123456")) {
                return geneToken(userName);
            }
        }
        return userName;
    }

    private String geneToken(String userName) {
        long curUTS = TimeUtils.getCurrentUnixTimestamp();
        return userName + curUTS;
    }
}
