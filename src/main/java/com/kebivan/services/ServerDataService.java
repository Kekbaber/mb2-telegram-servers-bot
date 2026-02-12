package com.kebivan.services;

import com.kebivan.models.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ServerDataService {

    private final ConcurrentHashMap<String, Server> serversCache = new ConcurrentHashMap<>();
    private final AtomicLong lastUpdateTime = new AtomicLong(0);
    private final Object updateLock = new Object();

    public void updateServers(List<Server> newServers) {
        synchronized (updateLock) {
            serversCache.clear();
            newServers.forEach(server -> serversCache.put(server.getId(), server));
            lastUpdateTime.set(System.currentTimeMillis());
            log.info("Updated {} servers in cache", newServers.size());
        }
    }

    public List<Server> getServersList() {
        return new ArrayList<>(serversCache.values());
    }

    public List<Server> getPopulatedServers() {
        return getServersList().stream()
                .filter(server -> server.getOnlinePlayers() > 0)
                .collect(Collectors.toList());
    }

    public long getLastUpdateTime() {
        return lastUpdateTime.get();
    }

    public int getCacheSize() {
        return serversCache.size();
    }
}
