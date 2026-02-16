package com.kebivan.telegram;

import com.kebivan.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.ActionType;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
@Slf4j
public class UpdateProcessor {

    public static String COMMAND_PREFIX = "/";

    private Bot telegramBot;
    private final CommandProcessor commandProcessor;

    public void registerBot(Bot telegramBot) {
        this.telegramBot = telegramBot;
    }

    public void processUpdate(Update update) {
        if (update == null) {
            log.error("Received update is null");
            return;
        }

        if (update.hasMessage()) {
            distributeMessagesByType(update);
        } else {
            log.error("Unsupported message type is received: {}", update);
        }
    }

    private void distributeMessagesByType(Update update) {
        Long chatId = update.getMessage().getChatId();
        telegramBot.changeAction(chatId, ActionType.TYPING);
        var message = update.getMessage();
        if (message.hasText()) {
            processTextMessage(update);
        } else {
            processUnsupportedMessageType(update);
        }
    }

    public void processTextMessage(Update update) {
        String text = update.getMessage().getText();
        if (text.startsWith(COMMAND_PREFIX)) {
            String[] commandArray = update.getMessage().getText().trim().split(" ");
            SendMessage message = commandProcessor.distributeCommand(commandArray).getAnswer(update);
            telegramBot.sendMessage(message);
        } else {
            SendMessage message = MessageUtils.createSendMessage(update, "Please message a command!");
            telegramBot.sendMessage(message);
        }
    }

    private void processUnsupportedMessageType(Update update) {
        SendMessage message = MessageUtils.createSendMessage(update, "Unsupported message type!");
        telegramBot.sendMessage(message);
    }

}
