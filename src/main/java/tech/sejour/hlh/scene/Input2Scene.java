package tech.sejour.hlh.scene;

import com.linecorp.bot.model.event.message.TextMessageContent;
import tech.sejour.diamond.dialog.annotation.Dialog;
import tech.sejour.diamond.dialog.message.annotation.Message;
import tech.sejour.diamond.dialog.reply.annotation.ReplyMapping;
import tech.sejour.diamond.script.Scene;
import tech.sejour.diamond.script.annotation.DialogScript;

/**
 * Created by Shuka on 2017/04/01.
 */
@DialogScript
public class Input2Scene extends Scene {

    @Dialog(1)
    class School {

        @Message
        final String message = "将来の夢を教えて下さい。";

        @ReplyMapping
        public void receive(String dream) {

        }

    }

    @Dialog(2)
    class Brothers {

        @Message
        final String message = "兄弟姉妹はいますか？";

        @ReplyMapping
        public void receive(TextMessageContent textMessageContent) {

        }

    }

}
