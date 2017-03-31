package tech.sejour.hlh.scene;

import com.linecorp.bot.model.event.Event;
import tech.sejour.diamond.dialog.annotation.Dialog;
import tech.sejour.diamond.dialog.message.annotation.Message;
import tech.sejour.diamond.dialog.reply.annotation.ReplyMapping;
import tech.sejour.diamond.event.matcher.annotation.TextIsIntegerValue;
import tech.sejour.diamond.script.Scene;
import tech.sejour.diamond.script.annotation.DialogScript;
import tech.sejour.diamond.transition.ContinueDialog;
import tech.sejour.diamond.transition.KeepDialog;
import tech.sejour.diamond.transition.NextDialog;

/**
 * Created by Shuka on 2017/03/31.
 */
@DialogScript
public class InputScene extends Scene {

    @Dialog(1)
    class Hello {

        @Message(order = 1)
        final String hello = "こんにちは。";

        @Message(order = 2)
        final String inputName = "名前を入力してください。";

        @ReplyMapping
        public NextDialog replyName(String name) {
            return NextDialog.requestWithMessage("あなたの名前は" + name + "さんですね。", name);
        }

    }

    @Dialog(2)
    class Dialog2 {

        private final String name;

        public Dialog2(String name) {
            this.name = name;
        }

        @Message
        public String nameReturn() {
            return "それでは" + name + "さん、年齢を教えて下さい。";
        }

        @ReplyMapping
        @TextIsIntegerValue
        public NextDialog receive(String age) {
            return NextDialog.requestWithMessage("年齢は" + age + "歳ですね。");
        }

        @ReplyMapping
        private KeepDialog receiveContinue(Event event) {
            return KeepDialog.requestWithMessage("年齢を数字で入力してください。");
        }

    }

    @Dialog(3)
    class Dialog3 {

        @Message
        final String message = "場所を入力してください。";

        @ReplyMapping
        public NextDialog receive(String place) {
            return NextDialog.requestWithMessage("場所は" + place + "ですね。");
        }

    }

}
