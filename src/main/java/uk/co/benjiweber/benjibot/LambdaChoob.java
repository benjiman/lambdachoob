package uk.co.benjiweber.benjibot;

import org.pircbotx.PircBotX;
import org.pircbotx.exception.IrcException;

import java.io.IOException;

public class LambdaChoob extends PircBotX {

    public LambdaChoob() {
        super(Settings.getConfiguration());
    }

    public static void main(String... args) throws IrcException, IOException {
        new LambdaChoob().startBot();
    }

}
