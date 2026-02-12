package com.kebivan.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kebivan.models.Server;
import com.kebivan.services.ServerDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class ServerDataLoader {

    private final RestClient restClient;
    private List<Server> servers;

    @Autowired
    private final ServerDataService serverDataService;

    public ServerDataLoader(RestClient restClient, ServerDataService serverDataService) {
        this.restClient = restClient;
        this.serverDataService = serverDataService;
        servers = new ArrayList<>();
        updateServerDetails();
        refreshServerData();
    }

    public void updateServerDetails() {
        log.debug("Update servers details - start");
        String jsonString = restClient.get()
                    .uri("/api/get/detail")
                    .retrieve()
                    .body(String.class);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            servers = mapper.readValue(jsonString, mapper.getTypeFactory().constructCollectionType(List.class, Server.class));
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
        log.debug("Update servers details - finish");
    }

    public void refreshServerData() {
        List<Server> freshData = servers;
        serverDataService.updateServers(freshData);
    }



}
