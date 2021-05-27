package com.java.sjzl.message;/**
 * @author huoqiang
 * @description
 * @date 2021/5/27
 */

/**
 * @author Java升级之路
 * @description
 * @date 2021/5/27
 */
public class SendToUserRequest implements Message{

    public static final String TYPE = "SEND_TO_USER_REQUEST";

    /**
     * 消息编号
     */
    private String msgId;
    /**
     * 内容
     */
    private String content;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
