package com.zsgwsjj.jiang.user;

import com.zsgwsjj.jiang.user.service.IUserAccService;
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

    @Autowired
    private IUserAccService userAccService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String userName,
                        @RequestParam("password") String password,
                        HttpServletRequest request) {
        return ResponseUtil.geneCommonResponse("token", userAccService.loginWithUserName(userName, password));
    }

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public String regist(@RequestParam("username") String userName,
                         @RequestParam("password") String password,
                         HttpServletRequest request) {
        userAccService.registByUserName(userName, password);
        return ResponseUtil.geneSuccessResponse();
    }

    @RequestMapping(value = "/update_pw", method = RequestMethod.POST)
    public String updatePassword(@RequestParam("username") String userName,
                                 @RequestParam("old_password") String oldPassword,
                                 @RequestParam("new_password") String newPassword) {
        userAccService.updatePassword(userName, oldPassword, newPassword);
        return ResponseUtil.geneSuccessResponse();
    }
}

