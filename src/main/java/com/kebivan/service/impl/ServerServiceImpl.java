package com.kebivan.service.impl;

import com.kebivan.model.Server;
import com.kebivan.service.ServerService;
import com.kebivan.storage.ServerStorage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ServerServiceImpl implements ServerService {

    private final ServerStorage serverStorage;
    private final AtomicLong lastUpdateTime = new AtomicLong(0);

    public ServerServiceImpl(ServerStorage serverStorage) {
        this.serverStorage = serverStorage;
    }

    @Override
    public void updateServers(List<Server> servers) {
        serverStorage.replaceAll(servers);
        setLastUpdateTime();
        log.info("Updated {} servers in cache", servers.size());

    }

    @Override
    public Collection<Server> findAll() {
        return serverStorage.findAll();
    }

    @Override
    public Optional<Server> findById(String id) {
        return serverStorage.findById(id);
    }

    @Override
    public List<Server> findPopulated() {
        return findAll().stream()
                .filter(server -> server.getOnlinePlayers() > 0)
                .collect(Collectors.toList());
    }

    @Override
    public void setLastUpdateTime() {
        lastUpdateTime.set(System.currentTimeMillis());
    }

    @Override
    public long getLastUpdateTime() {
        return lastUpdateTime.get();
    }
}
