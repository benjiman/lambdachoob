package uk.co.benjiweber.benjibot.plugininfra.commands;

import uk.co.benjiweber.benjibot.plugininfra.Triggerable;
import uk.co.benjiweber.benjibot.plugininfra.responses.Action;
import uk.co.benjiweber.benjibot.plugininfra.responses.Response;
import uk.co.benjiweber.benjibot.utils.Arguments;

public interface ActionResponse extends Triggerable {
    default Response process(Arguments arguments) {
        return new Action(command(arguments));
    }
}
