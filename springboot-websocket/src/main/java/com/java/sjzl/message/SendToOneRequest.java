package com.java.sjzl.message;

/**
 * @author Java升级之路
 * @description
 * @date 2021/5/27
 */
public class SendToOneRequest implements Message {

    public static final String TYPE = "SEND_TO_ONE_REQUEST";

    /**
     * 发送给的用户
     */
    private String toUser;

    /**
     * 消息编号
     */
    private String msgId;

    /**
     * 发送的内容
     */
    private String content;


    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

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

