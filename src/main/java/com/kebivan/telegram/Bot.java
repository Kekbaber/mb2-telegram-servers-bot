package com.kebivan.telegram;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.ActionType;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendChatAction;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.Serializable;

@Component
@Slf4j
public class Bot extends TelegramLongPollingBot {

    private final UpdateProcessor updateProcessor;
    private final String botName;

    public Bot(@Value("${bot.token}") String botToken, @Value("${bot.name}") String botName, UpdateProcessor updateProcessor) {
        super(botToken);
        this.botName = botName;
        this.updateProcessor = updateProcessor;

        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(this);
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
        }
        this.updateProcessor.registerBot(this);
    }

    @Override
    public void onUpdateReceived(Update update) {
        updateProcessor.processUpdate(update);
    }

    public void changeAction(Long chatId, ActionType actionType) {
        SendChatAction method = new SendChatAction();
        method.setChatId(chatId);
        method.setAction(actionType);
        try {
            execute(method);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public <T extends Serializable, Method extends BotApiMethod<T>> void sendMessage(Method message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public String getBotUsername() {
        return botName;
    }
}
