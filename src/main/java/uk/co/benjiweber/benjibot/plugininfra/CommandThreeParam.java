package uk.co.benjiweber.benjibot.plugininfra;

import uk.co.benjiweber.benjibot.utils.Arguments;
import uk.co.benjiweber.benjibot.utils.Optionals;

import java.util.Optional;

public interface CommandThreeParam extends Triggerable {
    public String command(String arg1, String arg2, String arg3);

    public default Optional<String> command(Arguments arguments) {
        return Optionals.flatten2(arguments.getArg1().map(arg1 -> arguments.getArg2().map(arg2 -> arguments.getArg3().map(arg3 -> command(arg1, arg2, arg3)))));
    }
}
