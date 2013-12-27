package uk.co.benjiweber.benjibot.plugininfra;

import uk.co.benjiweber.benjibot.utils.Arguments;

public interface DispatchResponse extends Triggerable {
    default void process(Arguments arguments, Responder responder) {
        command(arguments).ifPresent(responder::dispatch);
    }
}
