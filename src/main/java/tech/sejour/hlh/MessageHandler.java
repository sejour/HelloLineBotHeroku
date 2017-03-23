package tech.sejour.hlh;

import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;

@LineMessageHandler
public class MessageHandler {

    @EventMapping
    public TextMessage handleTextMessage(MessageEvent<TextMessageContent> event) {
        return new TextMessage("> " + event.getMessage().getText());
    }

    @EventMapping
    public TextMessage handleDefault(Event event) {
        return new TextMessage("hello " + event.getSource().getSenderId());
    }

}
