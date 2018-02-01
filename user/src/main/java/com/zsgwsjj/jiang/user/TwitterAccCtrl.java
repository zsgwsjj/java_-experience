package com.zsgwsjj.jiang.user;

import com.zsgwsjj.jiang.comm.service.ITwitterService;
import com.zsgwsjj.jiang.model.Twitter;
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
@RequestMapping("/twitter")
public class TwitterAccCtrl {

    @Autowired
    private ITwitterService twitterService;

    @RequestMapping(value = "/report", method = RequestMethod.POST)
    public String report(@RequestParam("uid") int uid,
                         @RequestParam("content") String content,
                         HttpServletRequest request) {
        long curUTS = TimeUtils.getCurrentUnixTimestamp();
        Twitter twitter = new Twitter(uid, content, curUTS, curUTS);
        twitterService.reportNewTwitter(twitter);
        return ResponseUtil.geneSuccessResponse();
    }

    @RequestMapping(value = "/query/by_time", method = RequestMethod.POST)
    public String query(@RequestParam("start_time") long startTime,
                        @RequestParam("end_time") long endTime,
                        @RequestParam("uid") int uid,
                        HttpServletRequest request) {
        return ResponseUtil.geneCommonResponse("twitter", twitterService.getTwitters(startTime, endTime, uid));
    }
}

