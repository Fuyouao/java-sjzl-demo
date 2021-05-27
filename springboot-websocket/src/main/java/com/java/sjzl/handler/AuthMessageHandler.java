package com.java.sjzl.handler;

import com.java.sjzl.message.AuthRequest;
import com.java.sjzl.message.AuthResponse;
import com.java.sjzl.until.WebSocketUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.WebSocketSession;

/**
 * @author Java升级之路
 * @description
 * @date 2021/5/27
 */
@Component
public class AuthMessageHandler implements MessageHandler<AuthRequest>{

    @Override
    public void execute(WebSocketSession session, AuthRequest message) {
        // 如果未传递 accessToken
        if (StringUtils.isEmpty(message.getAccessToken())) {
            AuthResponse authResponse = new AuthResponse();
            authResponse.setCode(1);
            authResponse.setMessage("认证 accessToken 未传入");
            WebSocketUtil.send(session, AuthResponse.TYPE,authResponse);
            return;
        }

        // 添加到 WebSocketUtil 中,考虑到代码简化，我们先直接使用 accessToken 作为 User
        WebSocketUtil.addSession(session, message.getAccessToken());

        // 判断是否认证成功。这里，假装直接成功
        AuthResponse authResponse = new AuthResponse();
        authResponse.setCode(0);
        WebSocketUtil.send(session, AuthResponse.TYPE, authResponse);


    }


    @Override
    public String getType() {
        return AuthRequest.TYPE;
    }
}
