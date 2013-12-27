package uk.co.benjiweber.benjibot.plugininfra.responses;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.output.OutputIRC;

import java.util.Optional;

public class Action extends AbstractResponse {

    public Action(Optional<String> message) {
        super(message);
    }

    @Override
    public void perform(MessageEvent msg, OutputIRC output, String target, String message) {
        output.action(target, message);
    }
}
