package com.kebivan.telegram;

import com.kebivan.telegram.comannds.BotCommand;
import com.kebivan.telegram.comannds.impl.UnknownCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class CommandProcessor {

    private final Map<String, BotCommand> commandsByNames;
    private final UnknownCommand unknownCommand;

    public BotCommand distributeCommand(String[] commandArray) {
        String commandIdentifier = commandArray[0].toLowerCase();
        return commandsByNames.getOrDefault(commandIdentifier, unknownCommand);
    }

}
