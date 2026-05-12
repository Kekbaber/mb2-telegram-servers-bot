package com.kebivan.service.impl;

import com.kebivan.model.Server;
import com.kebivan.service.ServerService;
import com.kebivan.storage.ServerStorage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ServerServiceImpl implements ServerService {

    private final ServerStorage serverStorage;
    private final AtomicLong lastUpdateTime = new AtomicLong(0);
    private final Object updateLock = new Object();

    public ServerServiceImpl(ServerStorage serverStorage) {
        this.serverStorage = serverStorage;
    }

    @Override
    public void updateServers(List<Server> newServers) {
        synchronized (updateLock) {
            serverStorage.clear();
            newServers.forEach(serverStorage::add);
            lastUpdateTime.set(System.currentTimeMillis());
            log.info("Updated {} servers in cache", newServers.size());
        }
    }

    @Override
    public Collection<Server> findAll() {
        return serverStorage.findAll();
    }

    @Override
    public List<Server> findPopulated() {
        return findAll().stream()
                .filter(server -> server.getOnlinePlayers() > 0)
                .collect(Collectors.toList());
    }
}
