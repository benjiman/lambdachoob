package uk.co.benjiweber.benjibot.plugininfra;

import uk.co.benjiweber.benjibot.utils.Arguments;

public interface ActionResponse extends Triggerable {
    default void process(Arguments arguments, Responder responder) {
        command(arguments).ifPresent(responder::action);
    }
}
