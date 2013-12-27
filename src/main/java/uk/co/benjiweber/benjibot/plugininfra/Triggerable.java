package uk.co.benjiweber.benjibot.plugininfra;

import uk.co.benjiweber.benjibot.plugininfra.responses.Message;
import uk.co.benjiweber.benjibot.plugininfra.responses.Response;
import uk.co.benjiweber.benjibot.utils.Arguments;

import java.util.Optional;

public interface Triggerable extends MessageProcessor {
    default Optional<String> command(Arguments arguments) {
        return Optional.empty();
    }

    default Response process(Arguments arguments) {
        return new Message(command(arguments));
    }
}
