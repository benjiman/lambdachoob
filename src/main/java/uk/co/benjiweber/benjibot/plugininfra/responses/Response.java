package uk.co.benjiweber.benjibot.plugininfra.responses;

import org.pircbotx.hooks.events.MessageEvent;

public interface Response {
    public void perform(MessageEvent event);
}
