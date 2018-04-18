package com.zsgwsjj.jiang.im_demo.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author : jiang
 * @time : 2018/2/23 15:57
 */
@Controller
public class WebSocketController {

    private static Logger LOGGER = LoggerFactory.getLogger(WebSocketController.class);

    @Bean
    public SpringWebSocketHandler infoHandler() {
        return new SpringWebSocketHandler();
    }

    @RequestMapping("/websocket/login")
    public ModelAndView login(HttpServletRequest request,
                              @RequestParam("username") String userName,
                              HttpServletResponse response) {
        LOGGER.info(userName + "登录");
        HttpSession session = request.getSession(false);
        session.setAttribute("SESSION_USERNAME", userName);
        return new ModelAndView("websocket");
    }

    @RequestMapping("/websocket/send")
    public String send(HttpServletRequest request,
                       @RequestParam("username") String username) {
        infoHandler().sendMessageToUser(username, new TextMessage("测试测试！！！！！"));
        return null;
    }
}
