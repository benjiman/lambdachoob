package uk.co.benjiweber.benjibot.plugininfra;

import org.pircbotx.hooks.Event;
import org.pircbotx.hooks.events.MessageEvent;

public class Responder {
    private final MessageEvent<?> messageEvent;

    public Responder(MessageEvent<?> messageEvent) {
        this.messageEvent = messageEvent;
    }

    public void message(String message) {
        String target = messageEvent.getChannel().getName();
        messageEvent.getBot().sendIRC().message(target, message);
    }

    public void reply(String message) {
        messageEvent.respond(message);
    }

    public void action(String message) {
        String target = messageEvent.getChannel().getName();
        messageEvent.getBot().sendIRC().action(target, message);
    }
}
