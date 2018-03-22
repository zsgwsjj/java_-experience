package com.zsgwsjj.jiang.im_demo.client;

import org.java_websocket.WebSocket;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.handshake.ServerHandshake;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;

/**
 * @author : jiang
 * @time : 2018/2/24 15:27
 */
public class Client {

    private static WebSocketClient client;

    public static void main(String[] args) throws URISyntaxException, UnsupportedEncodingException, InterruptedException {
        client = new WebSocketClient(new URI("ws://120.79.144.60:8080/zhihui/connect.html"), new Draft_17()) {

            @Override
            public void onOpen(ServerHandshake arg0) {
                System.out.println("打开链接");
            }

            @Override
            public void onMessage(String arg0) {
                System.out.println("收到消息" + arg0);
            }

            @Override
            public void onError(Exception e) {
                e.printStackTrace();
                System.out.println("发生错误已关闭");
            }

            @Override
            public void onClose(int i, String s, boolean b) {
                System.out.println("链接已经关闭");
            }

            @Override
            public void onMessage(ByteBuffer byteBuffer) {

                try {
                    System.out.println(new String(byteBuffer.array(), "utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        };

        client.connect();
        while (!client.getReadyState().equals(WebSocket.READYSTATE.OPEN)) {
            System.out.println("还没有打开");
            Thread.sleep(1000);
        }
        System.out.println("打开了");
        send("hello world!".getBytes("utf-8"));
        client.send("hello world!");
    }

    private static void send(byte[] bytes) {
        client.send(bytes);
    }
}
