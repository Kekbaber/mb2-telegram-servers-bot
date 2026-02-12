package com.kebivan.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestConfig {

    private final String serverUrl;

    public RestConfig(@Value("${server.url}") String serverUrl) {
        this.serverUrl = serverUrl;
    }

    @Bean
    public RestClient restClient() {
        return RestClient.builder()
                .baseUrl(serverUrl)
                .build();
    }

}
