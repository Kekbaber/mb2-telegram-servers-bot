package com.kebivan.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Player {

    private String score;
    private int ping;
    private String name;

    @JsonProperty("playerName")
    public String getName() {
        return name;
    }

    @JsonProperty("name_nocolor")
    public void setName(String name) {
        this.name = name;
    }
}
