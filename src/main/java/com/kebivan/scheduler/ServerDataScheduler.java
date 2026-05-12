package com.kebivan.scheduler;

import com.kebivan.api.ServerDataLoader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ServerDataScheduler {

    private final ServerDataLoader serverDataLoader;

    @Value("${app.servers.update-interval}")
    private long updateInterval;

    @Scheduled(fixedDelayString = "${app.servers.update-interval}")
    public void scheduledUpdate() {
        long start = System.currentTimeMillis();
        try {
            log.debug("Running scheduled server data update");
            serverDataLoader.refreshServerData();
            log.info("Servers updated successfully in {} ms", System.currentTimeMillis() - start);
        } catch (Exception e) {
            log.error("Failed to update server data after {} ms", System.currentTimeMillis() - start, e);
        }
    }
}
