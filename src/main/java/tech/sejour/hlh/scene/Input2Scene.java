package tech.sejour.hlh.scene;

import com.linecorp.bot.model.event.message.TextMessageContent;
import tech.sejour.diamond.dialog.annotation.Dialog;
import tech.sejour.diamond.dialog.message.annotation.Message;
import tech.sejour.diamond.dialog.reply.annotation.ReplyMapping;
import tech.sejour.diamond.scene.Scene;
import tech.sejour.diamond.scene.annotation.Appeared;
import tech.sejour.diamond.scene.annotation.DialogScript;
import tech.sejour.diamond.scene.annotation.Entered;

import java.util.Date;

/**
 * Created by Shuka on 2017/04/01.
 */
@DialogScript
public class Input2Scene extends Scene {

    private Date date = null;

    @Entered
    public void entered() {
        System.out.println("entered");
        date = new Date();
    }

    @Dialog(1)
    class School {

        @Message
        public String date() {
            return date == null ? "null" : date.toString();
        }

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

    @Appeared
    public void appeared() {
        System.out.println("appeared");
    }

}
