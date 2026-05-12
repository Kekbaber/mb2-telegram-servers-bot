package com.kebivan.service;

import com.kebivan.model.Server;

import java.util.Collection;
import java.util.List;

public interface ServerService {
    public void updateServers(List<Server> newServers);

    public Collection<Server> findAll();

    public List<Server> findPopulated();
}
