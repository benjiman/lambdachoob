package uk.co.benjiweber.benjibot.plugininfra;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;
import uk.co.benjiweber.benjibot.utils.Arguments;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LambdaListenerAdapter extends ListenerAdapter<PircBotX> {
    private final Object plugin;
    private final Map<String, Triggerable> commands;

    public LambdaListenerAdapter(Object plugin) {
        this.plugin = plugin;
        commands = PluginScanner.findCommands(plugin);
    }

    @Override public void onMessage(MessageEvent<PircBotX> event) {
        Arguments arguments = Arguments.fromString(event.getMessage());
        if (arguments.getPluginName().orElse("").equalsIgnoreCase(plugin.getClass().getSimpleName())) {
            Optional<Triggerable> command = arguments.getCommandName().map(commands::get);
            command.ifPresent(cmd -> cmd.process(arguments, new Responder(event)));
        }
    }
}
