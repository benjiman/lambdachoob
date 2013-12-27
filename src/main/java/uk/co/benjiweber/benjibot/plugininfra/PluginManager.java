package uk.co.benjiweber.benjibot.plugininfra;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;
import uk.co.benjiweber.benjibot.BenjiBot;
import uk.co.benjiweber.benjibot.plugininfra.responses.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PluginManager extends ListenerAdapter<BenjiBot> {

    private List<PluginWrapper> pluginWrappers = new ArrayList<>();

    public PluginManager addPlugin(Object plugin) {
        pluginWrappers.add(new PluginWrapper(plugin, this));
        return this;
    }

    @Override public void onMessage(MessageEvent<BenjiBot> event) {
        processMessage(event)
            .forEach(response -> response.perform(event));
    }

    public List<Response> processMessage(MessageEvent<BenjiBot> event) {
        return pluginWrappers
                .stream()
                .flatMap(pluginWrapper -> pluginWrapper.onMessage(event).stream())
                .collect(Collectors.toList());
    }
}
