package com.pending.rtc.domain.signal.entity;

import lombok.*;

@Data
@NoArgsConstructor
public class IceCandidate {
    private String candidate;
    private String sdpMid;
    private int sdpMLineIndex;
}
