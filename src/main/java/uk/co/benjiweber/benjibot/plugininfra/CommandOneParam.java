package uk.co.benjiweber.benjibot.plugininfra;

import uk.co.benjiweber.benjibot.utils.Arguments;

import java.util.Optional;
import java.util.function.Function;

public interface CommandOneParam extends Triggerable {
    public String command(String arg);

    public default Optional<String> command(Arguments arguments) {
        return arguments.getArg1().map(arg1 -> this.command(arg1));
    }
}
