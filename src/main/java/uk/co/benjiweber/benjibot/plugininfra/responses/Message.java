package uk.co.benjiweber.benjibot.plugininfra.responses;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.output.OutputIRC;

import java.util.Optional;

public class Message extends AbstractResponse {
    public Message(Optional<String> message) {
        super(message);
    }

    @Override
    public void perform(MessageEvent msg, OutputIRC output, String target, String message) {
        output.message(target, message);
    }
}
