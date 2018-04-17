package com.zsgwsjj.jiang.spider1.ctrl;

import com.zsgwsjj.jiang.util.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.zsgwsjj.jiang.spider1.service.IGetInfoService;
import javax.servlet.http.HttpServletRequest;

/**
 * @author : jiang
 * @time : 2018/4/11 18:07
 */
@RestController
@RequestMapping("/spider")
public class SpiderCtrl {

    @Autowired
    private IGetInfoService getInfoService;
//    @Autowired
//    private ISpiderService spiderService;

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public String getBaiduPan(HttpServletRequest request) {
        getInfoService.getInfo();
        return ResponseUtil.geneSuccessResponse();
    }

//    @RequestMapping("/delete")
//    public String dealWithSameTitle(@RequestParam("username") String userName,
//                                    @RequestParam("password") String password,
//                                    HttpServletRequest request) {
//        if (userName.equals("jiang") && password.equals("123456")) {
//            getInfoService.cleanUp();
//        }
//    }

//    @RequestMapping(value = "/check", method = RequestMethod.POST)
//    public String checkState() {
//        spiderService.checkLastOne();
//        return null;
//    }
}
