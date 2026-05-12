package com.kebivan.storage.impl;

import com.kebivan.model.Server;
import com.kebivan.storage.ServerStorage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ServerStorageImpl implements ServerStorage {

    private ConcurrentHashMap<String, Server> serversCache = new ConcurrentHashMap<>();

    public void replaceAll(Collection<Server> servers) {
        ConcurrentHashMap<String, Server> newMap = new ConcurrentHashMap<>();
        for (Server s : servers) {
            newMap.put(s.getId(), s);
        }
        this.serversCache = newMap;
    }

    @Override
    public Collection<Server> findAll() {
        return new ArrayList<>(serversCache.values());
    }

    @Override
    public Optional<Server> findById(String id) {
        return Optional.ofNullable(serversCache.get(id));
    }

    @Override
    public void add(Server server) {
        serversCache.put(server.getId(), server);
    }

    @Override
    public void clear() {
        serversCache.clear();
    }
}
