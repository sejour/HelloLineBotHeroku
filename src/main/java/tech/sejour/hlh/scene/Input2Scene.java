package tech.sejour.hlh.scene;

import tech.sejour.diamond.dialog.annotation.Dialog;
import tech.sejour.diamond.dialog.message.annotation.Message;
import tech.sejour.diamond.dialog.reply.annotation.ReplyMapping;
import tech.sejour.diamond.event.matcher.annotation.TextIsIntegerValue;
import tech.sejour.diamond.scene.Scene;
import tech.sejour.diamond.scene.annotation.Appeared;
import tech.sejour.diamond.scene.annotation.DialogScript;
import tech.sejour.diamond.scene.annotation.Entered;
import tech.sejour.diamond.transition.NextDialog;

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

        @Message(order = 1)
        public String date() {
            return date == null ? "null" : date.toString();
        }

        @Message(order = 2)
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
        public void receive(String message) {

        }

        /*
        @Yes(order = 1)
        public NextDialog yes() {

        }

        @Postback(order = 2)
        public ExitScene no() {
            return new ExitScene("一人っ子なんですね。");
        }
        */

    }

    @Dialog(3)
    class NumberOfPeople {

        @Message
        final String message = "兄弟姉妹は何人いますか？";

        @ReplyMapping
        @TextIsIntegerValue
        public NextDialog receive(String number) {
            return NextDialog.request();
        }

    }

    @Appeared
    public void appeared() {
        System.out.println("appeared");
    }

}
