package com.java.sjzl.handler;

import com.java.sjzl.message.SendResponse;
import com.java.sjzl.message.SendToAllRequest;
import com.java.sjzl.message.SendToUserRequest;
import com.java.sjzl.until.WebSocketUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

/**
 * @author Java升级之路
 * @description
 * @date 2021/5/27
 */
@Component
public class SendToAllHandler implements MessageHandler<SendToAllRequest> {

    @Override
    public void execute(WebSocketSession session, SendToAllRequest message) {
        // 这里，假装直接成功
        SendResponse sendResponse = new SendResponse();
        sendResponse.setMsgId(message.getMsgId());
        sendResponse.setCode(0);
        WebSocketUtil.send(session, SendResponse.TYPE, sendResponse);

        // 创建转发的消息
        SendToUserRequest sendToUserRequest = new SendToUserRequest();
        sendToUserRequest.setMsgId(message.getMsgId());
        sendToUserRequest.setContent(message.getContent());

        // 广播发送
        WebSocketUtil.broadcast(SendToUserRequest.TYPE, sendToUserRequest);
    }

    @Override
    public String getType() {
        return SendToAllRequest.TYPE;
    }
}
