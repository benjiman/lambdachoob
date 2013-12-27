package uk.co.benjiweber.benjibot.plugininfra.responses;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.output.OutputIRC;
import uk.co.benjiweber.benjibot.BenjiBot;

import java.util.Optional;

public class Reply extends AbstractResponse {
    private final MessageEvent<BenjiBot> request;

    public Reply(MessageEvent<BenjiBot> request, Optional<String> message) {
        super(message);
        this.request = request;
    }

    @Override public String toString() {
        return request.getUser().getNick() + ": " + super.toString();
    }

    @Override
    public void perform(MessageEvent msg, OutputIRC output, String target, String message) {
        msg.respond(message);
    }
}
