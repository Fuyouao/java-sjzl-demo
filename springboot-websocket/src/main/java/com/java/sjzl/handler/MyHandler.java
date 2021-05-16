package com.java.sjzl.handler;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

/**
 * @author Java升级之路
 * @date 2021/5/16 21:01
 */
public class MyHandler extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        System.out.println("获取到消息 >> " + message.getPayload());
        session.sendMessage(new TextMessage("消息已收到"));
        if(message.getPayload().equals("10")){
            for (int i = 0; i < 10; i++) {
                session.sendMessage(new TextMessage("消息 -> " + i));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace(); }
            }
        }
    }

    /**
     * 连接建立时触发
     **/
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("uid >> " + session.getAttributes().get("uid"));

        session.sendMessage(new TextMessage("欢迎连接到ws服务"));
    }

    /**
     * 关闭连接时触发
     **/
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("断开连接！");
    }

}
