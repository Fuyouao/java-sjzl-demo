package com.java.sjzl.config;

import com.java.sjzl.handler.MyHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author Java升级之路
 * @date 2021/5/16 21:13
 */
@Configuration
@EnableWebSocket //开启spring websocket功能
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //配置处理器
        registry.addHandler(this.myHandler(), "/")
                //配置拦截器
                .addInterceptors(new MyHandshakeInterceptor())
                .setAllowedOrigins("*");
    }

    @Bean
    public WebSocketHandler myHandler() {
        return new MyHandler();
    }

    @Bean
    public MyHandshakeInterceptor webSocketShakeInterceptor() {
        return new MyHandshakeInterceptor();
    }
}
