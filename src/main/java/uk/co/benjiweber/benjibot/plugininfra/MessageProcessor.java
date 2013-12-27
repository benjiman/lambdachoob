package uk.co.benjiweber.benjibot.plugininfra;

import uk.co.benjiweber.benjibot.plugininfra.responses.Response;
import uk.co.benjiweber.benjibot.utils.Arguments;

public interface MessageProcessor {
    Response process(Arguments arguments);
}
