package tech.sejour.hlh.scene;

import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.message.StickerMessageContent;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import tech.sejour.diamond.discussion.DiscussionOpeningRequest;
import tech.sejour.diamond.event.annotation.DiamondMessageHandler;
import tech.sejour.diamond.event.matcher.annotation.TextEquals;

/**
 * Created by Shuka on 2017/03/27.
 */
@DiamondMessageHandler
public class MessageHandler {

    @EventMapping
    public String receiveDefault(Event event) {
        return "default";
    }

    @EventMapping
    public String receiveSticker(StickerMessageContent stickerMessageContent) {
        return "スタンプを受け取りました。";
    }

    @EventMapping
    @TextEquals({"入力", "入力開始", "開始", "はじめる"})
    public DiscussionOpeningRequest start(String text) {
        return DiscussionOpeningRequest.request(InputScene.class);
    }

}
