package uk.co.benjiweber.benjibot;

import org.pircbotx.Configuration;
import plugins.*;
import uk.co.benjiweber.benjibot.plugininfra.PluginManager;

public class Settings {
    public static final String Trigger = "!";


    public static Configuration<LambdaChoob> getConfiguration() {
        return new Configuration.Builder<LambdaChoob>()
            .setName(LambdaChoob.class.getSimpleName())
            .setLogin(LambdaChoob.class.getSimpleName())
            .setRealName(LambdaChoob.class.getSimpleName())
            .addAutoJoinChannel("#" + LambdaChoob.class.getSimpleName())
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
