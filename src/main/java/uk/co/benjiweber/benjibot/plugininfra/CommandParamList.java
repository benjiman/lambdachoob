package uk.co.benjiweber.benjibot.plugininfra;

import uk.co.benjiweber.benjibot.utils.Arguments;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public interface CommandParamList extends Triggerable {
    public String command(List<String> args);

    public default Optional<String> command(Arguments arguments) {
        return Optional.of(this.command(arguments.getArgs()));
    }
}