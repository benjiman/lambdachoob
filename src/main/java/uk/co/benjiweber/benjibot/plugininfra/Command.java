package uk.co.benjiweber.benjibot.plugininfra;

import uk.co.benjiweber.benjibot.utils.Arguments;

import java.util.Optional;

public interface Command extends Triggerable {
    public String command();

    public default Optional<String> command(Arguments arguments) {
        return Optional.of(command());
    }
}
