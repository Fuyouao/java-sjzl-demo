package com.java.sjzl.handler;

import com.java.sjzl.message.Message;
import org.springframework.web.socket.WebSocketSession;

/**
 * @author Java升级之路
 * @description ${description}
 * @date 2021/5/27
 */
public interface MessageHandler<T extends Message> {

    /**
     * 执行处理消息
     * @param session 会话
     * @param message 消息
     */
    void execute(WebSocketSession session, T message);

    /**
     * 消息类型，即每个 Message 实现类上的 TYPE 静态字段
     * @return
     */
    String getType();
}
