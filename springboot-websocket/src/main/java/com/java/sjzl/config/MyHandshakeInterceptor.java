package com.java.sjzl.config;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.lang.Nullable;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import java.util.Map;

/**
 * @author Java升级之路
 * @date 2021/5/16 21:57
 */
public class MyHandshakeInterceptor extends HttpSessionHandshakeInterceptor {

    /**
    * @Description 握手之前，若返回false，则不建立链接
    * @Date 21:59 2021/5/16
    * @return boolean
    **/
    @Override
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> attributes) throws Exception {
        //获得 accessToken ,将用户id放入socket处理器的会话(WebSocketSession)中
        if (serverHttpRequest instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest serverRequest = (ServletServerHttpRequest) serverHttpRequest;
            attributes.put("accessToken", serverRequest.getServletRequest().getParameter("accessToken"));
        }
        // 调用父方法，继续执行逻辑
        return super.beforeHandshake(serverHttpRequest, serverHttpResponse, webSocketHandler, attributes);
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, @Nullable Exception e) {
        System.out.println("握手成功啦。。。。。。");
    }
}
