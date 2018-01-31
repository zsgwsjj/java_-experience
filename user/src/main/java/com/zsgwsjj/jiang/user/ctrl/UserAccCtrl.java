package com.zsgwsjj.jiang.user.ctrl;

import com.zsgwsjj.jiang.comm.service.IUserAccService;
import com.zsgwsjj.jiang.util.util.ResponseUtil;
import com.zsgwsjj.jiang.util.util.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : jiang
 * @time : 2018/1/12 22:01
 */
@RestController
public class UserAccCtrl {

    private IUserAccService userAccService;

    @Autowired
    public UserAccCtrl(IUserAccService userAccService) {
        this.userAccService = userAccService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String register(@RequestParam("username") String userName,
                           @RequestParam("password") String password,
                           HttpServletRequest request) {
        return ResponseUtil.geneCommonResponse("token", userAccService.loginWithUserName(userName, password));
    }

    @RequestMapping(value = "/time", method = RequestMethod.GET)
    public String getTime() {
        String haveTime = String.valueOf(1518431700 - TimeUtils.getCurrentUnixTimestamp());
        return "距离下次见到瑶阿妹还剩:" + haveTime + "秒";
    }
}

