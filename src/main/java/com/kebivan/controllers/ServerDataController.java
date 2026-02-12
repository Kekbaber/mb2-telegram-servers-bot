package com.kebivan.controllers;

import com.kebivan.models.Server;
import com.kebivan.services.ServerDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/servers")
public class ServerDataController {

    private final ServerDataService service;

    public ServerDataController(ServerDataService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Server> getServersList()  {
        return service.getServersList();
    }

    @GetMapping("/populated")
    public List<Server> getPopulatedServers() {
        return service.getPopulatedServers();
    }

}
