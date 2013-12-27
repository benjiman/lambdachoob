package uk.co.benjiweber.benjibot.plugininfra.commands;

import uk.co.benjiweber.benjibot.plugininfra.Triggerable;
import uk.co.benjiweber.benjibot.plugininfra.responses.Reply;
import uk.co.benjiweber.benjibot.plugininfra.responses.Response;
import uk.co.benjiweber.benjibot.utils.Arguments;

public interface ReplyResponse extends Triggerable {
    default Response process(Arguments arguments) {
        return new Reply(arguments.getMessage(), command(arguments));
    }
}
