package com.pending.rtc.domain.signal.handler;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pending.rtc.domain.signal.entity.IceCandidate;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class SignalingHandler extends TextWebSocketHandler {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Map<String, WebSocketSession> clients = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        String id = session.getId();
        clients.put(id, session);
        System.out.println("✅ WebSocket 연결됨: " + id);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        JsonNode json = objectMapper.readTree(message.getPayload());
        String type = json.get("type").asText();

        if ("candidate".equals(type)) {
            IceCandidate candidate = objectMapper.treeToValue(json.get("candidate"), IceCandidate.class);

            System.out.println("📡 ICE Candidate 수신 from " + session.getId());
            System.out.println(" - candidate: " + candidate.getCandidate());
            System.out.println(" - sdpMid: " + candidate.getSdpMid());
            System.out.println(" - sdpMLineIndex: " + candidate.getSdpMLineIndex());
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        clients.remove(session.getId());
        System.out.println("❌ 연결 종료: " + session.getId());
    }
}
