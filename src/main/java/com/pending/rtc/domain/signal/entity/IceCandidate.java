package com.pending.rtc.domain.signal.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class IceCandidate {
    private String candidate;
    private String sdpMid;
    private int sdpMLineIndex;
}
