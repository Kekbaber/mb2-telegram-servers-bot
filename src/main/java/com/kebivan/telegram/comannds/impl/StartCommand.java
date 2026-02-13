package com.kebivan.telegram.comannds.impl;

import com.kebivan.telegram.comannds.BotCommand;
import com.kebivan.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.kebivan.telegram.comannds.Commands.START;

@Component
@RequiredArgsConstructor
public class StartCommand implements BotCommand {

    @Override
    public String getCommandName() {
        return START.getCommandName();
    }

    @Override
    public SendMessage getAnswer(Update update) {
        return MessageUtils.createSendMessage(update, "Hello!");
    }

}
