package uk.co.benjiweber.benjibot.plugininfra.commands;

import uk.co.benjiweber.benjibot.plugininfra.Triggerable;
import uk.co.benjiweber.benjibot.utils.Arguments;
import uk.co.benjiweber.benjibot.utils.Optionals;

import java.util.Optional;

public interface CommandTwoParam extends Triggerable {
    public String command(String arg1, String arg2);

    public default Optional<String> command(Arguments arguments) {
        return Optionals.flatten(arguments.arg(1).map(arg1 -> arguments.argsFrom(2).map(arg2 -> command(arg1, arg2))));
    }
}
