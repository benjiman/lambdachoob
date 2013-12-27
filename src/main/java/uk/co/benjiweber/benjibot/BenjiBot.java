package uk.co.benjiweber.benjibot;

import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.exception.IrcException;
import plugins.*;
import uk.co.benjiweber.benjibot.plugininfra.PluginManager;

import java.io.IOException;

public class BenjiBot extends PircBotX {

    public BenjiBot() {
        super(Settings.getConfiguration());
    }

    public static void main(String... args) throws IrcException, IOException {
        new BenjiBot().startBot();
    }

}
