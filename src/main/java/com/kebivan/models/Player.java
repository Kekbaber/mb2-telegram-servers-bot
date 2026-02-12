package com.kebivan.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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

    @Override
    public String toString() {
        return "Player{" +
                "score='" + score + '\'' +
                ", ping=" + ping +
                ", name='" + name + '\'' +
                '}';
    }
}
