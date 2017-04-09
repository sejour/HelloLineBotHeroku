package tech.sejour.hlh.scene;

import com.linecorp.bot.model.event.Event;
import tech.sejour.diamond.dialog.EventUnhandledTransition;
import tech.sejour.diamond.dialog.annotation.Dialog;
import tech.sejour.diamond.dialog.extension.ExtendedDialogSupporter;
import tech.sejour.diamond.dialog.message.annotation.Message;
import tech.sejour.diamond.dialog.reply.annotation.ReplyMapping;
import tech.sejour.diamond.dialog.template.ConfirmDialog;
import tech.sejour.diamond.dialog.template.ConfirmDialogSupport;
import tech.sejour.diamond.dialog.template.annotation.No;
import tech.sejour.diamond.dialog.template.annotation.Postback;
import tech.sejour.diamond.dialog.template.annotation.Yes;
import tech.sejour.diamond.event.matcher.annotation.TextIsIntegerValue;
import tech.sejour.diamond.scene.Scene;
import tech.sejour.diamond.scene.annotation.Appeared;
import tech.sejour.diamond.scene.annotation.DialogScript;
import tech.sejour.diamond.scene.annotation.Entered;
import tech.sejour.diamond.transition.ContinueDialog;
import tech.sejour.diamond.transition.ExitScene;
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

    @Dialog(value = 2, eventUnhandledMessage = "「はい」または「いいえ」で入力してください。")
    class Brothers extends ConfirmDialog {

        @Override
        public String text() {
            return "兄弟姉妹はいますか？";
        }

        @Yes(order = 2)
        public NextDialog yes() {
            return NextDialog.request();
        }

        @No(order = 1)
        public ExitScene no() {
            return ExitScene.requestWithMessage("一人っ子なんですね。");
        }

        /*
        @ReplyMapping
        public ContinueDialog receiveDefault(Event event) {
            return ContinueDialog.request();
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
