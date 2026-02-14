package com.kebivan.telegram.comannds;

import lombok.Getter;

@Getter
public enum Commands {
    START("/start"),
    SERVER_LIST("/serverlist"),
    UNKNOWN("/unknown");

    private final String commandName;

    Commands(String commandName) {
        this.commandName = commandName;
    }
}
