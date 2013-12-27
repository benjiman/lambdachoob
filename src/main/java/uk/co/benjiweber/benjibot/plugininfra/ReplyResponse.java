package uk.co.benjiweber.benjibot.plugininfra;

import uk.co.benjiweber.benjibot.utils.Arguments;

import java.util.Optional;

public interface ReplyResponse extends Triggerable {
    default void process(Arguments arguments, Responder responder) {
        command(arguments).ifPresent(responder::reply);
    }
}
