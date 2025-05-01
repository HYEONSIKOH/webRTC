package com.pending.rtc.global.config;

import com.pending.rtc.domain.signal.handler.SignalingHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    /**
     * addHandler(...): 완전한 커스터마이징이 필요한 Raw WebSocket 용
     * addEndpoint(...): STOMP 프로토콜을 사용하기 위한 WebSocket 핸들러 등록
     * ------------------------------------------------------------------
     * signal 로 요청이 왔을 때 아래의 signalingSocketHandler 가 동작하도록 registry에 설정
     * 요청은 클라이언트 접속, close, 메시지 발송 등에 대해 특정 메서드를 호출한다
     * 참고: https://velog.io/@moon-jar/Signaling-Stomp-1
     */

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new SignalingHandler(), "/signal")
                .setAllowedOriginPatterns("*");  // CORS 설정
    }
}
