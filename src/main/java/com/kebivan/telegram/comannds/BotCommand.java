package com.kebivan.telegram.comannds;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface BotCommand {
    public String getCommandName();
    public SendMessage getAnswer(Update update);
}
