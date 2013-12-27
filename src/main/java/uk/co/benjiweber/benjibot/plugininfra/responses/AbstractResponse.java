package uk.co.benjiweber.benjibot.plugininfra.responses;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.output.OutputIRC;

import java.util.Optional;

public abstract class AbstractResponse implements Response {
    private Optional<String> message;

    public AbstractResponse(Optional<String> message) {
        this.message = message;
    }

    @Override public String toString() {
        return message.orElse("");
    }

    public void perform(MessageEvent event) {
        String target = event.getChannel().getName();
        message.ifPresent(msg -> perform(event, event.getBot().sendIRC(), target, msg));
    }

    public abstract void perform(MessageEvent event, OutputIRC output, String target, String message);
}
