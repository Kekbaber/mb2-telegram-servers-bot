package com.kebivan.telegram.comannds.impl;

import com.kebivan.telegram.comannds.BotCommand;
import com.kebivan.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.kebivan.telegram.comannds.Commands.UNKNOWN;

@Component
@RequiredArgsConstructor
public class UnknownCommand implements BotCommand {

    @Override
    public String getCommandName() {
        return UNKNOWN.getCommandName();
    }

    @Override
    public SendMessage getAnswer(Update update) {
        return MessageUtils.createSendMessage(update, "Unknown command!");
    }

}