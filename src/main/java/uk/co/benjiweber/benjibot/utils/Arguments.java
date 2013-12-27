package uk.co.benjiweber.benjibot.utils;

import com.google.common.collect.Lists;
import org.pircbotx.hooks.events.MessageEvent;
import uk.co.benjiweber.benjibot.BenjiBot;
import uk.co.benjiweber.benjibot.Settings;
import uk.co.benjiweber.benjibot.plugininfra.PluginManager;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Arguments {

    private final PluginManager pluginManager;
    private final MessageEvent<BenjiBot> message;
    private final String raw;
    private final Optional<String> pluginName;
    private final Optional<String> commandName;
    private final Optional<String> arg1;
    private final Optional<String> arg2;
    private final Optional<String> arg3;
    private final List<String> args;

    public Arguments(PluginManager pluginManager, MessageEvent<BenjiBot> message) {
        this.pluginManager = pluginManager;
        this.message = message;
        this.raw = message.getMessage();
        String[] parts = raw.split(" ");
        Optional<String> pluginCommand = Optionals.flatten(ifHas(parts, 0).map(part -> validCommand(part) ? Optional.of(part) : Optional.<String>empty()));
        this.pluginName = pluginCommand.map(plugin -> plugin.substring(1).replaceAll("\\..*",""));
        this.commandName = pluginCommand.map(plugin -> plugin.substring(1).replaceAll(".*?\\.", ""));
        this.arg1 = ifHas(parts,1);
        this.arg2 = ifHas(parts,2);
        this.arg3 = ifHas(parts,3);
        args = parts.length < 2
            ? Lists.<String>newArrayList()
            : Arrays.asList(parts)
                .subList(1, parts.length);
    }

    public Arguments(Arguments other, String raw, String[] parts) {
        this.raw = raw;
        this.pluginName = Optional.empty();
        this.commandName = Optional.of("" + raw.hashCode());
        this.arg1 = ifHas(parts, 0);
        this.arg2 = ifHas(parts, 1);
        this.arg3 = ifHas(parts, 2);
        this.args = Arrays.asList(parts);
        this.pluginManager = other.pluginManager;
        this.message = other.message;
    }

    private boolean validCommand(String part) {
        return part.contains(".") && part.startsWith(Settings.Trigger);
    }

    private static <T> Optional<T> ifHas(T[] arr, int i) {
        return arr.length > i ? Optional.of(arr[i]) : Optional.<T>empty();
    }

    public Optional<String> getCommandName() {
        return commandName;
    }

    public Optional<String> getPluginName() {
        return pluginName;
    }

    public Optional<String> getArg1() {
        return arg1;
    }

    public Optional<String> getArg2() {
        return arg2;
    }

    public Optional<String> getArg3() {
        return arg3;
    }

    public List<String> getArgs() {
        return args;
    }

    public String getRaw() {
        return raw;
    }

    public PluginManager getPluginManager() {
        return pluginManager;
    }

    public MessageEvent<BenjiBot> getMessage() {
        return message;
    }
}
