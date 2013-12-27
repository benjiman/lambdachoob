package uk.co.benjiweber.benjibot.plugininfra.commands;

import uk.co.benjiweber.benjibot.plugininfra.Triggerable;
import uk.co.benjiweber.benjibot.utils.Arguments;
import uk.co.benjiweber.benjibot.utils.Optionals;

import java.util.Optional;

public interface CommandThreeParam extends Triggerable {
    public String command(String arg1, String arg2, String arg3);

    public default Optional<String> command(Arguments arguments) {
        return Optionals.flatten2(arguments.arg(1).map(arg1 -> arguments.arg(2).map(arg2 -> arguments.argsFrom(3).map(arg3 -> command(arg1, arg2, arg3)))));
    }
}
