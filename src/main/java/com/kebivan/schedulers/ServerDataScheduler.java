package com.kebivan.schedulers;

import com.kebivan.api.ServerDataLoader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ServerDataScheduler {

    @Autowired
    private ServerDataLoader serverDataLoader;

    @Value("${app.servers.update-interval}")
    private long updateInterval;

    @Scheduled(fixedRateString = "${app.servers.update-interval}")
    public void scheduledUpdate() {
        try {
            log.debug("Running scheduled server data update");
            serverDataLoader.refreshServerData();
        } catch (Exception e) {
            log.error("Failed to update server data", e);
        }
    }
}
