package com.kebivan.telegram.comannds;

import lombok.Getter;

@Getter
public enum Commands {
    START("/check"),
    SERVER_LIST("/serverlist"),
    UNKNOWN("/unknown");

    private final String commandName;

    Commands(String commandName) {
        this.commandName = commandName;
    }
}
