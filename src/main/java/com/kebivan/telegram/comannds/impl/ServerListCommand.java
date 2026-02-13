package com.kebivan.telegram.comannds.impl;

import com.kebivan.models.Server;
import com.kebivan.services.ServerDataService;
import com.kebivan.telegram.comannds.BotCommand;
import com.kebivan.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

import static com.kebivan.telegram.comannds.Commands.SERVER_LIST;

@Component
@RequiredArgsConstructor
public class ServerListCommand implements BotCommand {

    @Autowired
    private ServerDataService service;

    @Override
    public String getCommandName() {
        return SERVER_LIST.getCommandName();
    }

    @Override
    public SendMessage getAnswer(Update update) {
        List<Server> serverList = service.getPopulatedServers();
        StringBuilder text = new StringBuilder();

        for(Server server : serverList) {
            text.append(server.getServerName()).append(" - ")
                    .append(server.getOnlinePlayers())
                    .append("/")
                    .append(server.getMaxPlayers())
                    .append("\n");
        }

        return MessageUtils.createSendMessage(update, text.toString());
    }
}
