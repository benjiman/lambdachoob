package uk.co.benjiweber.benjibot;

import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.exception.IrcException;
import plugins.*;
import uk.co.benjiweber.benjibot.plugininfra.PluginManager;

import java.io.IOException;

public class BenjiBot extends PircBotX {

    public BenjiBot(PluginManager pluginManager) {
        super(new Configuration.Builder<BenjiBot>()
                .setName(BenjiBot.class.getSimpleName())
                .setLogin(BenjiBot.class.getSimpleName())
                .setRealName(BenjiBot.class.getSimpleName())
                .addAutoJoinChannel("#benjibot")
                .setServerHostname("irc.uwcs.co.uk")
                .addListener(pluginManager)
                .buildConfiguration()
        );
    }

    public static void main(String... args) throws IrcException, IOException {
        new BenjiBot(new PluginManager()
                .addPlugin(new Hello())
                .addPlugin(new Reply())
                .addPlugin(new Action())
                .addPlugin(new Alias())
                .addPlugin(new Pipes())
        ).startBot();
    }

}
