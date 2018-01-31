package com.zsgwsjj.jiang.model;

import com.zsgwsjj.jiang.comm.service.IUserAccService;
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
@RequestMapping("/twitter")
public class TwitterAccCtrl {

    private IUserAccService userAccService;

    @Autowired
    public TwitterAccCtrl(IUserAccService userAccService) {
        this.userAccService = userAccService;
    }

    @RequestMapping(value = "/report", method = RequestMethod.POST)
    public String register(@RequestParam("uid") int uid,
                           @RequestParam("content") String content,
                           HttpServletRequest request) {
        long curUTS = TimeUtils.getCurrentUnixTimestamp();
        Twitter twitter = new Twitter(uid, content, curUTS, curUTS);
        return null;
    }

}

