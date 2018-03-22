package com.zsgwsjj.jiang.im_demo.server;

import org.apache.log4j.Logger;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author : jiang
 * @time : 2018/2/23 15:27
 */
public class SpringWebSocketHandler extends TextWebSocketHandler {

    private static final ArrayList<WebSocketSession> users = new ArrayList<>();
    private static Logger LOGGER = Logger.getLogger(SpringWebSocketHandler.class);

    public SpringWebSocketHandler() {
    }

    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        LOGGER.info("connect to the websocket success......当前数量:" + users.size());
        users.add(session);
    }

    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        LOGGER.debug("websocket connection closed......");
        String userName = (String) session.getAttributes().get("WEBSOCKET_USERNAME");
        LOGGER.info("用户" + userName + "退出");
        users.remove(session);
        LOGGER.info("剩余在线用户" + users.size());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
    }

    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if (session.isOpen()) {
            session.close();
        }
        LOGGER.info("websocket connection closed......");
        users.remove(session);
    }

    public boolean supportsPartialMessage() {
        return false;
    }

    public void sendMessageToUser(String userName, TextMessage message) {
        for (WebSocketSession user : users) {
            if (user.getAttributes().get("WEBSOCKET_USERNAME").equals(userName)) {
                try {
                    if (user.isOpen()) {
                        user.sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    public void sendMessageToUsers(TextMessage message) {
        for (WebSocketSession user : users) {
            try {
                if (user.isOpen()) {
                    user.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
