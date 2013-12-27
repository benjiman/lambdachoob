package uk.co.benjiweber.benjibot.utils;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Arguments {

    private final Optional<String> pluginName;
    private final Optional<String> commandName;
    private final Optional<String> arg1;
    private final Optional<String> arg2;
    private final Optional<String> arg3;
    private final List<String> args;

    public Arguments(String[] parts) {
        Optional<String> pluginCommand = Optionals.flatten(ifHas(parts, 0).map(part -> part.contains(".") ? Optional.of(part) : Optional.<String>empty()));
        this.pluginName = pluginCommand.map(plugin -> plugin.replaceAll("\\..*",""));
        this.commandName = pluginCommand.map(plugin -> plugin.replaceAll(".*?\\.",""));
        this.arg1 = ifHas(parts,1);
        this.arg2 = ifHas(parts,2);
        this.arg3 = ifHas(parts,3);
        args = parts.length < 2
            ? Lists.<String>newArrayList()
            : Arrays.asList(parts)
                .subList(1, parts.length);
    }

    private static <T> Optional<T> ifHas(T[] arr, int i) {
        return arr.length > i ? Optional.of(arr[i]) : Optional.<T>empty();
    }

    public static Arguments fromString(String message) {
        String[] parts = message.split(" ");
        return new Arguments(parts);
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

}
