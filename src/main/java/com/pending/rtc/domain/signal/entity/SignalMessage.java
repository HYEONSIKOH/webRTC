package com.pending.rtc.domain.signal.entity;

import lombok.Data;

@Data
public class SignalMessage {
    private String type;
    private String targetSessionId;
    private Object data;
    private String roomId;
}
