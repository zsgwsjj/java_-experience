package com.zsgwsjj.jiang.user.ctrl;

import com.zsgwsjj.jiang.comm.service.IUserAccService;
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
@RequestMapping("/user")
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
        return userAccService.loginWithUserName(userName, password);
    }
}
