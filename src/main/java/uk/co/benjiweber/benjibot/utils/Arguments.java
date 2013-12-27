package uk.co.benjiweber.benjibot.utils;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import org.pircbotx.hooks.events.MessageEvent;
import uk.co.benjiweber.benjibot.LambdaChoob;
import uk.co.benjiweber.benjibot.Settings;
import uk.co.benjiweber.benjibot.plugininfra.PluginManager;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Arguments {

    private final PluginManager pluginManager;
    private final MessageEvent<LambdaChoob> message;
    private final String raw;
    private final Optional<String> pluginName;
    private final Optional<String> commandName;
    private final List<String> args;

    public Arguments(PluginManager pluginManager, MessageEvent<LambdaChoob> message) {
        this(message.getMessage(), pluginManager, message);
    }

    private Arguments(String raw) {
        this(raw, null, null);
    }

    private Arguments(String raw, PluginManager pluginManager, MessageEvent<LambdaChoob> message) {
        this.raw = raw;
        String[] parts = raw.split(" ");
        this.pluginManager = pluginManager;
        this.message = message;
        Optional<String> pluginCommand = Optionals.flatten(ifHas(parts, 0).map(part -> validCommand(part) ? Optional.of(part) : Optional.<String>empty()));
        this.pluginName = pluginCommand.map(plugin -> plugin.substring(1).replaceAll("\\..*",""));
        this.commandName = pluginCommand.map(plugin -> plugin.substring(1).replaceAll(".*?\\.", ""));
        args = parts.length < 2
                ? Lists.<String>newArrayList()
                : Arrays.asList(parts)
                .subList(1, parts.length);
    }
    public Arguments(Arguments other, String raw, String[] parts) {
        this.raw = raw;
        this.pluginName = Optional.empty();
        this.commandName = Optional.of("" + raw.hashCode());
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

    public Optional<String> arg(int i) {
        return args.size() >= i ? Optional.of(args.get(i - 1)) : Optional.<String>empty();
    }

    public Optional<String> argsFrom(int i) {
        if (args.size() >= i) {
            return Optional.of(Joiner.on(" ").join(args.subList(i - 1, args.size())));
        } else {
            return Optional.<String>empty();
        }
    }

    public Optional<String> getCommandName() {
        return commandName;
    }

    public Optional<String> getPluginName() {
        return pluginName;
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

    public MessageEvent<LambdaChoob> getMessage() {
        return message;
    }

    public static Arguments forTest(String raw) {
        return new Arguments(raw);
    }
}
