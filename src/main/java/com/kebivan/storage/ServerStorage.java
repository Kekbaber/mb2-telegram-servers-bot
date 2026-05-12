package com.kebivan.storage;

import com.kebivan.model.Server;

import java.util.Collection;
import java.util.Optional;

public interface ServerStorage {
    public void replaceAll(Collection<Server> servers);

    public Collection<Server> findAll();

    public Optional<Server> findById(String id);

    public void add(Server server);

    public void clear();
}
