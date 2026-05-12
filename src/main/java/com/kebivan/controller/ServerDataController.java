package com.kebivan.controller;

import com.kebivan.model.Server;
import com.kebivan.service.ServerService;
import com.kebivan.service.impl.ServerServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/servers")
public class ServerDataController {

    private final ServerService service;

    public ServerDataController(ServerServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/all")
    public Collection<Server> findAll()  {
        return service.findAll();
    }

    @GetMapping("/populated")
    public List<Server> findPopulated() {
        return service.findPopulated();
    }

}
