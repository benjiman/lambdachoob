package uk.co.benjiweber.benjibot.plugininfra;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;
import uk.co.benjiweber.benjibot.plugininfra.filter.Filter;
import uk.co.benjiweber.benjibot.utils.Arguments;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class LambdaListenerAdapter extends ListenerAdapter<PircBotX> {
    private final Object plugin;
    private final Map<String, Triggerable> commands;
    private final Set<Filter> filters;

    public LambdaListenerAdapter(Object plugin) {
        this.plugin = plugin;
        this.commands = PluginScanner.findCommands(plugin);
        this.filters = PluginScanner.findFilters(plugin);
    }

    @Override public void onMessage(MessageEvent<PircBotX> event) {
        Arguments arguments = Arguments.fromString(event.getMessage());
        Responder responder = new Responder(event);

        if (arguments.getPluginName().orElse("").equalsIgnoreCase(plugin.getClass().getSimpleName())) {
            Optional<Triggerable> command = arguments.getCommandName().map(commands::get);
            command.ifPresent(cmd -> cmd.process(arguments, responder));
        }

        filters.forEach(filter -> filter.process(arguments, responder));
    }
}
