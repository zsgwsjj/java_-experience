package com.zsgwsjj.jiang.im_demo.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author : jiang
 * @time : 2018/2/23 15:47
 */
public class SpringWebSocketHandlerInterceptor extends HttpSessionHandshakeInterceptor {

    private static Logger LOGGER = LoggerFactory.getLogger(SpringWebSocketHandler.class);

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler handler,
                                   Map<String, Object> attributes) throws Exception {
        LOGGER.info("Before Handshake");
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
            HttpSession session = servletRequest.getServletRequest().getSession(false);
            if (session != null) {
                String userName = (String) session.getAttribute("SESSION_USERNAME");
                if (userName == null) {
                    userName = "default-system";
                }
                attributes.put("WEBSOCKET_USERNAME", userName);
            }
        }
        return super.beforeHandshake(request, response, handler, attributes);
    }

    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler handler, Exception ex) {
        super.afterHandshake(request, response, handler, ex);
    }
}
