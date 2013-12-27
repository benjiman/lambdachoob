package uk.co.benjiweber.benjibot.plugininfra;

import org.pircbotx.hooks.events.MessageEvent;
import uk.co.benjiweber.benjibot.BenjiBot;
import uk.co.benjiweber.benjibot.plugininfra.filter.Filter;
import uk.co.benjiweber.benjibot.plugininfra.responses.Response;
import uk.co.benjiweber.benjibot.utils.Arguments;

import java.util.*;

public class PluginWrapper {
    private final Object plugin;
    private PluginManager pluginManager;
    private final Map<String, Triggerable> commands;
    private final Set<Filter> filters;

    public PluginWrapper(Object plugin, PluginManager pluginManager) {
        this.plugin = plugin;
        this.pluginManager = pluginManager;
        this.commands = PluginScanner.findCommands(plugin);
        this.filters = PluginScanner.findFilters(plugin);
    }

    public List<Response> onMessage(MessageEvent<BenjiBot> event) {
        Arguments arguments = new Arguments(pluginManager, event);
        List<Response> responses = new ArrayList<>();

        if (arguments.getPluginName().orElse("").equalsIgnoreCase(plugin.getClass().getSimpleName())) {
            System.out.println("Processing " );
            Optional<Triggerable> command = arguments.getCommandName().map(commands::get);
            command.ifPresent(cmd -> {responses.add(cmd.process(arguments));});
        }

        filters.forEach(filter -> { responses.add(filter.process(arguments)); });
        return responses;
    }
}
