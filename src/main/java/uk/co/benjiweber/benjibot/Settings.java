package uk.co.benjiweber.benjibot;

import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import plugins.*;
import uk.co.benjiweber.benjibot.plugininfra.PluginManager;

public class Settings {
    public static final String Trigger = "!";


    public static Configuration<BenjiBot> getConfiguration() {
        return new Configuration.Builder<BenjiBot>()
            .setName(BenjiBot.class.getSimpleName())
            .setLogin(BenjiBot.class.getSimpleName())
            .setRealName(BenjiBot.class.getSimpleName())
            .addAutoJoinChannel("#benjibot")
            .setServerHostname("irc.uwcs.co.uk")
            .addListener(new PluginManager()
                    .addPlugin(new Hello())
                    .addPlugin(new Reply())
                    .addPlugin(new Action())
                    .addPlugin(new Alias())
                    .addPlugin(new Pipes())
            )
            .buildConfiguration();
    }
}
