package com.kebivan.configs;

import com.kebivan.telegram.comannds.BotCommand;
import com.kebivan.telegram.comannds.impl.UnknownCommand;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class CommandProcessorConfig {

    @Bean
    public Map<String, BotCommand> commandsByNames(List<BotCommand> commands) {
        Map<String, BotCommand> commandMap = new HashMap<>();
        for (BotCommand command: commands) {
            if (command instanceof UnknownCommand) {
                continue;
            }
            commandMap.put(command.getCommandName(), command);
        }
        return commandMap;
    }

}
