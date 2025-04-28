package com.pending.rtc.global.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class StartConfig implements CommandLineRunner {

    @Value("${git.commit.id.abbrev:unknown}")
    private String gitCommitId;

    @Override
    public void run(String... args) {
        log.info("Starting RTC application...");
        log.info("Version: {}", gitCommitId);
    }
}
