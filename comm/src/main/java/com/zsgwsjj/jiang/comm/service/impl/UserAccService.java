package com.zsgwsjj.jiang.comm.service.impl;

import com.zsgwsjj.jiang.comm.dao.IUserAccDao;
import com.zsgwsjj.jiang.comm.service.IUserAccService;
import com.zsgwsjj.jiang.user.ctrl.User;
import com.zsgwsjj.jiang.util.util.Md5Utils;
import com.zsgwsjj.jiang.util.util.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


/**
 * @author : jiang
 * @time : 2018/1/29 18:34
 */
public class UserAccService implements IUserAccService {

    private static final String JIANG = "jiang";
    private static final String YAO = "yao";

    private IUserAccDao userAccDao;

    @Autowired
    public UserAccService(IUserAccDao userAccDao) {
        this.userAccDao = userAccDao;
    }

    @Override
    public String loginWithUserName(String userName, String password) {
        Optional<User> userOp = userAccDao.getUserByName(userName);
//        userOp.orElseThrow(()->new Exception());
        if (userName.equals(JIANG) || userName.equals(YAO)) {
            if (password.equals("123456")) {
                return geneToken(userName);
            }
        }
        return userName;
    }

    private String geneToken(String userName) {
        long curUTS = TimeUtils.getCurrentUnixTimestamp();
        return Md5Utils.MD5(userName + curUTS);
    }
}
