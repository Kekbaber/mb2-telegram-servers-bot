package com.kebivan.service;

import com.kebivan.model.Server;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ServerService {
    public void updateServers(List<Server> newServers);

    public Collection<Server> findAll();

    public Optional<Server> findById(String id);

    public List<Server> findPopulated();

    public void setLastUpdateTime();

    public long getLastUpdateTime();
}
