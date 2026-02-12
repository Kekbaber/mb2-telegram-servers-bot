package com.kebivan.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Server {

    private String id;
    private String serverName;
    private String gameMode;
    private String mapName;
    private int onlinePlayers;
    private int maxPlayers;
    private List<Player> playerList;
    private String regionCode;
    private String countryCode;

    @JsonProperty("serverName")
    public String getServerName() {
        return serverName;
    }

    @JsonProperty("sv_hostname_nocolor")
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    @JsonProperty("gameMode")
    public String getGameMode() {
        return gameMode;
    }

    @JsonProperty("mbmode")
    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    @JsonProperty("mapName")
    public String getMapName() {
        return mapName;
    }

    @JsonProperty("mapname")
    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    @JsonProperty("onlinePlayers")
    public int getOnlinePlayers() {
        return onlinePlayers;
    }

    @JsonProperty("numplayers")
    public void setOnlinePlayers(int onlinePlayers) {
        this.onlinePlayers = onlinePlayers;
    }

    @JsonProperty("maxPlayers")
    public int getMaxPlayers() {
        return maxPlayers;
    }

    @JsonProperty("sv_maxclients")
    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    @JsonProperty("playerList")
    public List<Player> getPlayerList() {
        return playerList;
    }

    @JsonProperty("players")
    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    @JsonProperty("regionCode")
    public String getRegionCode() {
        return regionCode;
    }

    @JsonProperty("region_code")
    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    @JsonProperty("countyCode")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("country_code")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "Server{" +
                "id='" + id + '\'' +
                ", serverName='" + serverName + '\'' +
                ", gameMode='" + gameMode + '\'' +
                ", mapName='" + mapName + '\'' +
                ", onlinePlayers=" + onlinePlayers +
                ", maxPlayers=" + maxPlayers +
                ", playerList=" + playerList +
                ", regionCode='" + regionCode + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
