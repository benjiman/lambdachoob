package uk.co.benjiweber.benjibot.plugininfra;

import uk.co.benjiweber.benjibot.utils.Arguments;
import uk.co.benjiweber.benjibot.utils.Optionals;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

public interface CommandTwoParam extends Triggerable {
    public String command(String arg1, String arg2);

    public default Optional<String> command(Arguments arguments) {
        return Optionals.flatten(arguments.getArg1().map(arg1 -> arguments.getArg2().map(arg2 -> command(arg1, arg2))));
    }
}
