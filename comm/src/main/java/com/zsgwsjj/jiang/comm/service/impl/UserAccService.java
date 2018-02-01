package com.zsgwsjj.jiang.comm.service.impl;

import com.zsgwsjj.jiang.comm.dao.IUserAccDao;
import com.zsgwsjj.jiang.comm.service.IUserAccService;
import com.zsgwsjj.jiang.model.User;
import com.zsgwsjj.jiang.util.enums.EnumUserError;
import com.zsgwsjj.jiang.util.other.YaoException;
import com.zsgwsjj.jiang.util.util.Md5Utils;
import com.zsgwsjj.jiang.util.util.SqlUtils;
import com.zsgwsjj.jiang.util.util.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


/**
 * @author : jiang
 * @time : 2018/1/29 18:34
 */
@Service("userAccService")
public class UserAccService implements IUserAccService {

    @Autowired
    private IUserAccDao userAccDao;

    @Override
    public String loginWithUserName(String userName, String password) {
        Optional<User> userOp = SqlUtils.getObjectOp(userAccDao.getUserByName(userName));
        User user = userOp.orElseThrow(() -> new YaoException(EnumUserError.NO_USER));
        if (!user.getPassword().equals(password)) {
            throw new YaoException(EnumUserError.PASSWORD_ERROR);
        }
        return geneToken(userName);
    }

    private String geneToken(String userName) {
        long curUTS = TimeUtils.getCurrentUnixTimestamp();
        return Md5Utils.MD5(userName + curUTS);
    }
}
