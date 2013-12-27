package uk.co.benjiweber.benjibot.plugininfra;

import uk.co.benjiweber.benjibot.utils.Arguments;

public interface MessageProcessor {
    void process(Arguments arguments, Responder responder);
}
