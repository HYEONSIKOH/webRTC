package com.pending.rtc.domain.signal.entity;

import lombok.*;

@Data
@NoArgsConstructor
public class SignalingMessage {
    private String type;
    private IceCandidate candidate;
    private String sender;
    private String target;
}
