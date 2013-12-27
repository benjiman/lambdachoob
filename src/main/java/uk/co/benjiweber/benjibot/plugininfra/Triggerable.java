package uk.co.benjiweber.benjibot.plugininfra;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import uk.co.benjiweber.benjibot.utils.Arguments;

import java.util.Optional;

public interface Triggerable extends MessageProcessor {
    default Optional<String> command(Arguments arguments) {
        return Optional.empty();
    }

    default void process(Arguments arguments, Responder responder) {
        command(arguments).ifPresent(responder::message);
    }
}
