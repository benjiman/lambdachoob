package uk.co.benjiweber.benjibot;

import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.exception.IrcException;
import plugins.Action;
import plugins.Alias;
import plugins.Hello;
import plugins.Reply;
import uk.co.benjiweber.benjibot.plugininfra.LambdaListenerAdapter;

import java.io.IOException;

public class BenjiBot {
    public static void main(String... args) throws IOException, IrcException {
        PircBotX bot = new PircBotX(
            new Configuration.Builder<PircBotX>()
                .setName(BenjiBot.class.getSimpleName())
                .setLogin(BenjiBot.class.getSimpleName())
                .setRealName(BenjiBot.class.getSimpleName())
                .addAutoJoinChannel("#benjibot")
                .setServerHostname("irc.uwcs.co.uk")
                .addListener(new LambdaListenerAdapter(new Hello()))
                .addListener(new LambdaListenerAdapter(new Reply()))
                .addListener(new LambdaListenerAdapter(new Action()))
                .addListener(new LambdaListenerAdapter(new Alias()))
                .buildConfiguration()
        );
        bot.startBot();
    }
}
